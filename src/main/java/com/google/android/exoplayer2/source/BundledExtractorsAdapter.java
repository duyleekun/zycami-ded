/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.Map;

public final class BundledExtractorsAdapter
implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final ExtractorsFactory extractorsFactory;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.extractorsFactory = extractorsFactory;
    }

    public void disableSeekingOnMp3Streams() {
        Extractor extractor = this.extractor;
        boolean bl2 = extractor instanceof Mp3Extractor;
        if (bl2) {
            extractor = (Mp3Extractor)extractor;
            ((Mp3Extractor)extractor).disableSeeking();
        }
    }

    public long getCurrentInputPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        long l10 = extractorInput != null ? extractorInput.getPosition() : (long)-1;
        return l10;
    }

    public void init(DataReader object, Uri object2, Map object3, long l10, long l11, ExtractorOutput extractorOutput) {
        block17: {
            block14: {
                int n10;
                int n11;
                int n12;
                DefaultExtractorInput defaultExtractorInput;
                Object object4;
                block13: {
                    object4 = object;
                    defaultExtractorInput = new DefaultExtractorInput((DataReader)object, l10, l11);
                    this.extractorInput = defaultExtractorInput;
                    object = this.extractor;
                    if (object != null) {
                        return;
                    }
                    object = this.extractorsFactory.createExtractors((Uri)object2, (Map)object3);
                    n12 = ((Extractor[])object).length;
                    n11 = 0;
                    n10 = 1;
                    if (n12 != n10) break block13;
                    object = object[0];
                    this.extractor = object;
                    break block14;
                }
                n12 = ((Extractor[])object).length;
                for (int i10 = 0; i10 < n12; ++i10) {
                    int n13;
                    block16: {
                        block12: {
                            block15: {
                                long l12;
                                long l13;
                                block11: {
                                    long l14;
                                    long l15;
                                    object4 = object[i10];
                                    boolean bl2 = object4.sniff(defaultExtractorInput);
                                    if (!bl2) break block11;
                                    try {
                                        this.extractor = object4;
                                    }
                                    catch (Throwable throwable) {
                                        long l16;
                                        long l17;
                                        long l18;
                                        object2 = this.extractor;
                                        if (object2 != null || (l18 = (l17 = (l16 = defaultExtractorInput.getPosition()) - l10) == 0L ? 0 : (l17 < 0L ? -1 : 1)) == false) {
                                            n11 = n10;
                                        }
                                        Assertions.checkState(n11 != 0);
                                        defaultExtractorInput.resetPeekPosition();
                                        throw throwable;
                                    }
                                    catch (EOFException eOFException) {
                                        long l19;
                                        object4 = this.extractor;
                                        if (object4 != null || (n13 = (l19 = (l13 = defaultExtractorInput.getPosition()) - l10) == 0L ? 0 : (l19 < 0L ? -1 : 1)) == 0) break block12;
                                    }
                                    if (object4 != null || (n12 = (int)((l15 = (l14 = defaultExtractorInput.getPosition()) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1))) == 0) {
                                        n11 = n10;
                                    }
                                    Assertions.checkState(n11 != 0);
                                    defaultExtractorInput.resetPeekPosition();
                                    break;
                                }
                                object4 = this.extractor;
                                if (object4 == null && (n13 = (int)((l12 = (l13 = defaultExtractorInput.getPosition()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) break block15;
                                break block12;
                            }
                            n13 = 0;
                            object4 = null;
                            break block16;
                        }
                        n13 = n10;
                    }
                    Assertions.checkState(n13 != 0);
                    defaultExtractorInput.resetPeekPosition();
                }
                if ((object3 = this.extractor) == null) break block17;
            }
            this.extractor.init(extractorOutput);
            return;
        }
        object = Util.getCommaDelimitedSimpleClassNames(object);
        int n14 = String.valueOf(object).length() + 58;
        StringBuilder stringBuilder = new StringBuilder(n14);
        stringBuilder.append("None of the available extractors (");
        stringBuilder.append((String)object);
        stringBuilder.append(") could read the stream.");
        object = stringBuilder.toString();
        object2 = (Uri)Assertions.checkNotNull(object2);
        object3 = new UnrecognizedInputFormatException((String)object, (Uri)object2);
        throw object3;
    }

    public int read(PositionHolder positionHolder) {
        Extractor extractor = (Extractor)Assertions.checkNotNull(this.extractor);
        ExtractorInput extractorInput = (ExtractorInput)Assertions.checkNotNull(this.extractorInput);
        return extractor.read(extractorInput, positionHolder);
    }

    public void release() {
        Extractor extractor = this.extractor;
        if (extractor != null) {
            extractor.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    public void seek(long l10, long l11) {
        ((Extractor)Assertions.checkNotNull(this.extractor)).seek(l10, l11);
    }
}

