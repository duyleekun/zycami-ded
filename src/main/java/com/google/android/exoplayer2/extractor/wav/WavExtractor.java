/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.wav.WavExtractor$ImaAdPcmOutputWriter;
import com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter;
import com.google.android.exoplayer2.extractor.wav.WavExtractor$PassthroughOutputWriter;
import com.google.android.exoplayer2.extractor.wav.WavHeader;
import com.google.android.exoplayer2.extractor.wav.WavHeaderReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.j.a;

public final class WavExtractor
implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    private static final int TARGET_SAMPLES_PER_SECOND = 10;
    private long dataEndPosition = -1;
    private int dataStartPosition = -1;
    private ExtractorOutput extractorOutput;
    private WavExtractor$OutputWriter outputWriter;
    private TrackOutput trackOutput;

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        WavExtractor wavExtractor = new WavExtractor();
        extractorArray[0] = wavExtractor;
        return extractorArray;
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    public void init(ExtractorOutput extractorOutput) {
        TrackOutput trackOutput;
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /*
     * Enabled aggressive block sorting
     */
    public int read(ExtractorInput object, PositionHolder object2) {
        long l10;
        long l11;
        int n10;
        Object object3;
        int n11;
        int n12;
        this.assertInitialized();
        object2 = this.outputWriter;
        if (object2 == null) {
            Object object4;
            WavHeader wavHeader = WavHeaderReader.peek((ExtractorInput)object);
            if (wavHeader == null) {
                object = new ParserException("Unsupported or unrecognized wav header.");
                throw object;
            }
            n12 = wavHeader.formatType;
            n11 = 17;
            if (n12 == n11) {
                object4 = this.extractorOutput;
                object3 = this.trackOutput;
                this.outputWriter = object2 = new WavExtractor$ImaAdPcmOutputWriter((ExtractorOutput)object4, (TrackOutput)object3, wavHeader);
            } else {
                n11 = 6;
                if (n12 == n11) {
                    object3 = this.extractorOutput;
                    TrackOutput trackOutput = this.trackOutput;
                    int n13 = -1;
                    String string2 = "audio/g711-alaw";
                    object4 = object2;
                    this.outputWriter = object2 = new WavExtractor$PassthroughOutputWriter((ExtractorOutput)object3, trackOutput, wavHeader, string2, n13);
                } else {
                    n11 = 7;
                    if (n12 == n11) {
                        object3 = this.extractorOutput;
                        TrackOutput trackOutput = this.trackOutput;
                        int n14 = -1;
                        String string3 = "audio/g711-mlaw";
                        object4 = object2;
                        this.outputWriter = object2 = new WavExtractor$PassthroughOutputWriter((ExtractorOutput)object3, trackOutput, wavHeader, string3, n14);
                    } else {
                        n11 = wavHeader.bitsPerSample;
                        int n15 = WavUtil.getPcmEncodingForType(n12, n11);
                        if (n15 == 0) {
                            n12 = wavHeader.formatType;
                            StringBuilder stringBuilder = new StringBuilder(40);
                            stringBuilder.append("Unsupported WAV format type: ");
                            stringBuilder.append(n12);
                            object2 = stringBuilder.toString();
                            object = new ParserException((String)object2);
                            throw object;
                        }
                        object3 = this.extractorOutput;
                        TrackOutput trackOutput = this.trackOutput;
                        String string4 = "audio/raw";
                        object4 = object2;
                        this.outputWriter = object2 = new WavExtractor$PassthroughOutputWriter((ExtractorOutput)object3, trackOutput, wavHeader, string4, n15);
                    }
                }
            }
        }
        if ((n12 = this.dataStartPosition) == (n11 = -1)) {
            object2 = WavHeaderReader.skipToData((ExtractorInput)object);
            object3 = (Long)((Pair)object2).first;
            this.dataStartPosition = n10 = ((Long)object3).intValue();
            this.dataEndPosition = l11 = ((Long)((Pair)object2).second).longValue();
            object2 = this.outputWriter;
            int n16 = this.dataStartPosition;
            object2.init(n16, l11);
        } else {
            l11 = object.getPosition();
            long l12 = l11 - (l10 = 0L);
            n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n12 == 0) {
                n12 = this.dataStartPosition;
                object.skipFully(n12);
            }
        }
        l11 = this.dataEndPosition;
        l10 = -1;
        n12 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        n10 = 0;
        object3 = null;
        if (n12 != 0) {
            n12 = 1;
        } else {
            n12 = 0;
            object2 = null;
        }
        Assertions.checkState(n12 != 0);
        long l13 = this.dataEndPosition;
        long l14 = object.getPosition();
        object2 = this.outputWriter;
        boolean bl2 = object2.sampleData((ExtractorInput)object, l13 -= l14);
        if (!bl2) return 0;
        return n11;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        WavExtractor$OutputWriter wavExtractor$OutputWriter = this.outputWriter;
        if (wavExtractor$OutputWriter != null) {
            wavExtractor$OutputWriter.reset(l11);
        }
    }

    public boolean sniff(ExtractorInput object) {
        boolean bl2;
        if ((object = WavHeaderReader.peek((ExtractorInput)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

