/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer;
import com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.extractor.ts.UserDataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class H262Reader
implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES;
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private static final int START_USER_DATA = 178;
    private final H262Reader$CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    static {
        double[] dArray;
        double[] dArray2 = dArray = new double[8];
        double[] dArray3 = dArray;
        dArray2[0] = 23.976023976023978;
        dArray3[1] = 24.0;
        dArray2[2] = 25.0;
        dArray3[3] = 29.97002997002997;
        dArray2[4] = 30.0;
        dArray3[5] = 50.0;
        dArray2[6] = 59.94005994005994;
        dArray3[7] = 60.0;
        FRAME_RATE_VALUES = dArray;
    }

    public H262Reader() {
        this(null);
    }

    public H262Reader(UserDataReader object) {
        this.userDataReader = object;
        int n10 = 4;
        Object object2 = new boolean[n10];
        this.prefixFlags = object2;
        object2 = new H262Reader$CsdBuffer;
        int n11 = 128;
        super(n11);
        this.csdBuffer = object2;
        if (object != null) {
            n10 = 178;
            this.userData = object = new NalUnitTargetBuffer(n10, n11);
            this.userDataParsable = object = new ParsableByteArray();
        } else {
            object = null;
            this.userData = null;
            this.userDataParsable = null;
        }
    }

    private static Pair parseCsdBuffer(H262Reader$CsdBuffer object, String object2) {
        double[] dArray;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        float f10;
        byte[] byArray;
        block5: {
            block6: {
                int n15;
                block2: {
                    block3: {
                        block4: {
                            byArray = ((H262Reader$CsdBuffer)object).data;
                            n15 = ((H262Reader$CsdBuffer)object).length;
                            byArray = Arrays.copyOf(byArray, n15);
                            n15 = 4;
                            f10 = 5.6E-45f;
                            n14 = byArray[n15] & 0xFF;
                            n13 = 5;
                            n12 = byArray[n13] & 0xFF;
                            n11 = byArray[6] & 0xFF;
                            n14 <<= n15;
                            n10 = n12 >> 4;
                            n14 |= n10;
                            n12 = (n12 & 0xF) << 8 | n11;
                            n11 = 7;
                            n10 = (byArray[n11] & 0xF0) >> n15;
                            int n16 = 2;
                            if (n10 == n16) break block2;
                            n16 = 3;
                            if (n10 == n16) break block3;
                            if (n10 == n15) break block4;
                            n15 = 1065353216;
                            f10 = 1.0f;
                            break block5;
                        }
                        n15 = n12 * 121;
                        f10 = n15;
                        n10 = n14 * 100;
                        break block6;
                    }
                    n15 = n12 * 16;
                    f10 = n15;
                    n10 = n14 * 9;
                    break block6;
                }
                n15 = n12 * 4;
                f10 = n15;
                n10 = n14 * 3;
            }
            float f11 = n10;
            f10 /= f11;
        }
        Object object3 = new Format$Builder();
        object2 = ((Format$Builder)object3).setId((String)object2);
        object3 = "video/mpeg2";
        object2 = ((Format$Builder)object2).setSampleMimeType((String)object3).setWidth(n14).setHeight(n12).setPixelWidthHeightRatio(f10);
        List<byte[]> list = Collections.singletonList(byArray);
        object2 = ((Format$Builder)object2).setInitializationData(list).build();
        long l10 = 0L;
        double d10 = 0.0;
        n12 = (byArray[n11] & 0xF) + -1;
        if (n12 >= 0 && n12 < (n10 = (dArray = FRAME_RATE_VALUES).length)) {
            double d11;
            d10 = dArray[n12];
            int n17 = ((H262Reader$CsdBuffer)object).sequenceExtensionPosition + 9;
            n12 = byArray[n17] & 0x60;
            n13 = n12 >> 5;
            if (n13 != (n17 = byArray[n17] & 0x1F)) {
                d11 = (double)n13 + 1.0;
                double d12 = ++n17;
                d10 *= (d11 /= d12);
            }
            d11 = 1000000.0 / d10;
            l10 = (long)d11;
        }
        object = l10;
        return Pair.create((Object)object2, (Object)object);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        H262Reader h262Reader = this;
        Object object = this.output;
        Assertions.checkStateNotNull(object);
        Object object2 = parsableByteArray.getPosition();
        int n10 = parsableByteArray.limit();
        byte[] byArray = parsableByteArray.getData();
        long l10 = this.totalBytesWritten;
        int n11 = parsableByteArray.bytesLeft();
        long l11 = n11;
        this.totalBytesWritten = l10 += l11;
        Object object3 = this.output;
        int n12 = parsableByteArray.bytesLeft();
        object3.sampleData(parsableByteArray, n12);
        while (true) {
            long l12;
            long l13;
            Object object4;
            Object object5;
            int n13;
            if ((n13 = NalUnitUtil.findNalUnit(byArray, object2, n10, (boolean[])(object3 = (Object)h262Reader.prefixFlags))) == n10) {
                n13 = (int)(h262Reader.hasOutputFormat ? 1 : 0);
                if (n13 == 0) {
                    object3 = h262Reader.csdBuffer;
                    ((H262Reader$CsdBuffer)object3).onData(byArray, (int)object2, n10);
                }
                if ((object3 = h262Reader.userData) != null) {
                    ((NalUnitTargetBuffer)object3).appendToNalUnit(byArray, (int)object2, n10);
                }
                return;
            }
            byte[] byArray2 = parsableByteArray.getData();
            int n14 = n13 + 3;
            n12 = byArray2[n14] & 0xFF;
            int n15 = n13 - object2;
            int n16 = h262Reader.hasOutputFormat;
            Object object6 = 0;
            Object object7 = 1;
            if (n16 == 0) {
                if (n15 > 0) {
                    object5 = h262Reader.csdBuffer;
                    ((H262Reader$CsdBuffer)object5).onData(byArray, (int)object2, n13);
                }
                if (n15 < 0) {
                    n16 = -n15;
                } else {
                    n16 = 0;
                    object5 = null;
                }
                object4 = h262Reader.csdBuffer;
                n16 = (int)(((H262Reader$CsdBuffer)object4).onStartCode(n12, n16) ? 1 : 0);
                if (n16 != 0) {
                    object5 = h262Reader.csdBuffer;
                    object4 = (String)Assertions.checkNotNull(h262Reader.formatId);
                    object5 = H262Reader.parseCsdBuffer((H262Reader$CsdBuffer)object5, (String)object4);
                    object4 = h262Reader.output;
                    Format format = (Format)((Pair)object5).first;
                    object4.format(format);
                    object5 = (Long)((Pair)object5).second;
                    h262Reader.frameDurationUs = l13 = ((Long)object5).longValue();
                    h262Reader.hasOutputFormat = object7;
                }
            }
            if ((object5 = h262Reader.userData) != null) {
                if (n15 > 0) {
                    ((NalUnitTargetBuffer)object5).appendToNalUnit(byArray, (int)object2, n13);
                    object2 = 0;
                    object = null;
                } else {
                    object2 = -n15;
                }
                Object object8 = h262Reader.userData;
                object2 = ((NalUnitTargetBuffer)object8).endNalUnit((int)object2);
                if (object2 != 0) {
                    object = h262Reader.userData;
                    object8 = ((NalUnitTargetBuffer)object).nalData;
                    object2 = ((NalUnitTargetBuffer)object).nalLength;
                    object2 = NalUnitUtil.unescapeStream((byte[])object8, object2);
                    object8 = (ParsableByteArray)Util.castNonNull(h262Reader.userDataParsable);
                    object5 = h262Reader.userData.nalData;
                    ((ParsableByteArray)object8).reset((byte[])object5, (int)object2);
                    object = (UserDataReader)Util.castNonNull(h262Reader.userDataReader);
                    l12 = h262Reader.sampleTimeUs;
                    object4 = h262Reader.userDataParsable;
                    ((UserDataReader)object).consume(l12, (ParsableByteArray)object4);
                }
                if (n12 == (object2 = 178) && (object2 = (Object)(object = (Object)parsableByteArray.getData())[n15 = n13 + 2]) == object7) {
                    object = h262Reader.userData;
                    ((NalUnitTargetBuffer)object).startNalUnit(n12);
                }
            }
            if (n12 != 0 && n12 != (object2 = 179)) {
                object2 = 184;
                if (n12 == object2) {
                    h262Reader.sampleIsKeyframe = object7;
                }
            } else {
                object2 = n10 - n13;
                n13 = (int)(h262Reader.startedFirstSample ? 1 : 0);
                if (n13 != 0 && (n13 = (int)(h262Reader.sampleHasPicture ? 1 : 0)) != 0 && (n13 = (int)(h262Reader.hasOutputFormat ? 1 : 0)) != 0) {
                    int n17 = h262Reader.sampleIsKeyframe;
                    l12 = h262Reader.totalBytesWritten;
                    l13 = h262Reader.samplePosition;
                    n13 = (int)(l12 -= l13);
                    int n18 = n13 - object2;
                    object4 = h262Reader.output;
                    long l14 = h262Reader.sampleTimeUs;
                    object4.sampleMetadata(l14, n17, n18, (int)object2, null);
                }
                if ((n13 = (int)(h262Reader.startedFirstSample ? 1 : 0)) == 0 || (n15 = (int)(h262Reader.sampleHasPicture ? 1 : 0)) != 0) {
                    l12 = h262Reader.totalBytesWritten;
                    l13 = object2;
                    h262Reader.samplePosition = l12 -= l13;
                    l12 = h262Reader.pesTimeUs;
                    l13 = -9223372036854775807L;
                    long l14 = l12 - l13;
                    object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object2 == 0) {
                        if (n13 != 0) {
                            l12 = h262Reader.sampleTimeUs;
                            long l16 = h262Reader.frameDurationUs;
                            l12 += l16;
                        } else {
                            l12 = 0L;
                        }
                    }
                    h262Reader.sampleTimeUs = l12;
                    h262Reader.sampleIsKeyframe = false;
                    h262Reader.pesTimeUs = l13;
                    h262Reader.startedFirstSample = object7;
                }
                if (n12 == 0) {
                    object6 = object7;
                }
                h262Reader.sampleHasPicture = object6;
            }
            object2 = n14;
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        tsPayloadReader$TrackIdGenerator.generateNewId();
        Object object = tsPayloadReader$TrackIdGenerator.getFormatId();
        this.formatId = object;
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        int n11 = 2;
        this.output = object = extractorOutput.track(n10, n11);
        object = this.userDataReader;
        if (object != null) {
            ((UserDataReader)object).createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
        }
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.pesTimeUs = l10;
    }

    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.reset();
        }
        this.totalBytesWritten = 0L;
        this.startedFirstSample = false;
    }
}

