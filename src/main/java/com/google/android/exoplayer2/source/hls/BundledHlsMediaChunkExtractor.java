/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.WebvttExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class BundledHlsMediaChunkExtractor
implements HlsMediaChunkExtractor {
    private static final PositionHolder POSITION_HOLDER;
    public final Extractor extractor;
    private final Format masterPlaylistFormat;
    private final TimestampAdjuster timestampAdjuster;

    static {
        PositionHolder positionHolder;
        POSITION_HOLDER = positionHolder = new PositionHolder();
    }

    public BundledHlsMediaChunkExtractor(Extractor extractor, Format format, TimestampAdjuster timestampAdjuster) {
        this.extractor = extractor;
        this.masterPlaylistFormat = format;
        this.timestampAdjuster = timestampAdjuster;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractor.init(extractorOutput);
    }

    public boolean isPackedAudioExtractor() {
        boolean bl2;
        Extractor extractor = this.extractor;
        boolean bl3 = extractor instanceof AdtsExtractor;
        if (!(bl3 || (bl3 = extractor instanceof Ac3Extractor) || (bl3 = extractor instanceof Ac4Extractor) || (bl2 = extractor instanceof Mp3Extractor))) {
            bl2 = false;
            extractor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isReusable() {
        boolean bl2;
        Extractor extractor = this.extractor;
        boolean bl3 = extractor instanceof TsExtractor;
        if (!bl3 && !(bl2 = extractor instanceof FragmentedMp4Extractor)) {
            bl2 = false;
            extractor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void onTruncatedSegmentParsed() {
        Extractor extractor = this.extractor;
        long l10 = 0L;
        extractor.seek(l10, l10);
    }

    public boolean read(ExtractorInput extractorInput) {
        Extractor extractor = this.extractor;
        PositionHolder positionHolder = POSITION_HOLDER;
        int n10 = extractor.read(extractorInput, positionHolder);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            extractorInput = null;
        }
        return n10 != 0;
    }

    public HlsMediaChunkExtractor recreate() {
        Object object;
        block7: {
            Object object2;
            Object object3;
            block3: {
                boolean bl2;
                block6: {
                    boolean bl3;
                    block5: {
                        block4: {
                            block2: {
                                bl2 = this.isReusable() ^ true;
                                Assertions.checkState(bl2);
                                object = this.extractor;
                                bl3 = object instanceof WebvttExtractor;
                                if (!bl3) break block2;
                                object3 = this.masterPlaylistFormat.language;
                                object2 = this.timestampAdjuster;
                                object = new WebvttExtractor((String)object3, (TimestampAdjuster)object2);
                                break block3;
                            }
                            bl3 = object instanceof AdtsExtractor;
                            if (!bl3) break block4;
                            object = new AdtsExtractor();
                            break block3;
                        }
                        bl3 = object instanceof Ac3Extractor;
                        if (!bl3) break block5;
                        object = new Ac3Extractor();
                        break block3;
                    }
                    bl3 = object instanceof Ac4Extractor;
                    if (!bl3) break block6;
                    object = new Ac4Extractor();
                    break block3;
                }
                bl2 = object instanceof Mp3Extractor;
                if (!bl2) break block7;
                object = new Mp3Extractor();
            }
            object2 = this.masterPlaylistFormat;
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            object3 = new BundledHlsMediaChunkExtractor((Extractor)object, (Format)object2, timestampAdjuster);
            return object3;
        }
        String string2 = "Unexpected extractor type for recreation: ";
        String string3 = String.valueOf(this.extractor.getClass().getSimpleName());
        int n10 = string3.length();
        string2 = n10 != 0 ? string2.concat(string3) : (string3 = new String(string2));
        object = new IllegalStateException(string2);
        throw object;
    }
}

