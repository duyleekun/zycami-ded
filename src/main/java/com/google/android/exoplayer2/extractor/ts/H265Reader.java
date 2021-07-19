/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H265Reader$SampleReader;
import com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer;
import com.google.android.exoplayer2.extractor.ts.SeiReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class H265Reader
implements ElementaryStreamReader {
    private static final int AUD_NUT = 35;
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps;
    private final boolean[] prefixFlags;
    private final NalUnitTargetBuffer prefixSei;
    private H265Reader$SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper;
    private final NalUnitTargetBuffer sps;
    private final NalUnitTargetBuffer suffixSei;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps;

    public H265Reader(SeiReader object) {
        this.seiReader = object;
        object = new boolean[3];
        this.prefixFlags = (boolean[])object;
        int n10 = 128;
        this.vps = object = new NalUnitTargetBuffer(32, n10);
        this.sps = object = new NalUnitTargetBuffer(33, n10);
        this.pps = object = new NalUnitTargetBuffer(34, n10);
        this.prefixSei = object = new NalUnitTargetBuffer(39, n10);
        this.suffixSei = object = new NalUnitTargetBuffer(40, n10);
        this.seiWrapper = object = new ParsableByteArray();
    }

    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    private void endNalUnit(long l10, int n10, int n11, long l11) {
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        Object object4 = this.sampleReader;
        boolean bl22 = this.hasOutputFormat;
        ((H265Reader$SampleReader)object4).endNalUnit(l10, n10, bl22);
        boolean n12 = this.hasOutputFormat;
        if (!n12) {
            boolean bl3;
            boolean bl4;
            this.vps.endNalUnit(n11);
            this.sps.endNalUnit(n11);
            this.pps.endNalUnit(n11);
            object3 = this.vps;
            boolean bl5 = ((NalUnitTargetBuffer)object3).isCompleted();
            if (bl5 && (bl4 = ((NalUnitTargetBuffer)(object3 = this.sps)).isCompleted()) && (bl3 = ((NalUnitTargetBuffer)(object3 = this.pps)).isCompleted())) {
                boolean bl6;
                object3 = this.output;
                object2 = this.formatId;
                object = this.vps;
                object4 = this.sps;
                NalUnitTargetBuffer nalUnitTargetBuffer = this.pps;
                object2 = H265Reader.parseMediaFormat((String)object2, (NalUnitTargetBuffer)object, (NalUnitTargetBuffer)object4, nalUnitTargetBuffer);
                object3.format((Format)object2);
                this.hasOutputFormat = bl6 = true;
            }
        }
        object3 = this.prefixSei;
        boolean bl7 = ((NalUnitTargetBuffer)object3).endNalUnit(n11);
        int n13 = 5;
        if (bl7) {
            object3 = this.prefixSei;
            object = ((NalUnitTargetBuffer)object3).nalData;
            int n15 = ((NalUnitTargetBuffer)object3).nalLength;
            n15 = NalUnitUtil.unescapeStream((byte[])object, n15);
            object = this.seiWrapper;
            object4 = this.prefixSei.nalData;
            ((ParsableByteArray)object).reset((byte[])object4, n15);
            this.seiWrapper.skipBytes(n13);
            object3 = this.seiReader;
            object = this.seiWrapper;
            ((SeiReader)object3).consume(l11, (ParsableByteArray)object);
        }
        if (bl2 = ((NalUnitTargetBuffer)(object3 = this.suffixSei)).endNalUnit(n11)) {
            object3 = this.suffixSei;
            object = ((NalUnitTargetBuffer)object3).nalData;
            int n17 = ((NalUnitTargetBuffer)object3).nalLength;
            n17 = NalUnitUtil.unescapeStream((byte[])object, n17);
            object = this.seiWrapper;
            byte[] byArray = this.suffixSei.nalData;
            ((ParsableByteArray)object).reset(byArray, n17);
            this.seiWrapper.skipBytes(n13);
            object3 = this.seiReader;
            object2 = this.seiWrapper;
            ((SeiReader)object3).consume(l11, (ParsableByteArray)object2);
        }
    }

    private void nalUnitData(byte[] byArray, int n10, int n11) {
        Object object = this.sampleReader;
        ((H265Reader$SampleReader)object).readNalUnitData(byArray, n10, n11);
        boolean bl2 = this.hasOutputFormat;
        if (!bl2) {
            this.vps.appendToNalUnit(byArray, n10, n11);
            this.sps.appendToNalUnit(byArray, n10, n11);
            object = this.pps;
            ((NalUnitTargetBuffer)object).appendToNalUnit(byArray, n10, n11);
        }
        this.prefixSei.appendToNalUnit(byArray, n10, n11);
        this.suffixSei.appendToNalUnit(byArray, n10, n11);
    }

    /*
     * WARNING - void declaration
     */
    private static Format parseMediaFormat(String string2, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int n10;
        float f10;
        void var20_29;
        int n11;
        int n12;
        Object object = nalUnitTargetBuffer;
        List<byte[]> list = nalUnitTargetBuffer2;
        Object object2 = nalUnitTargetBuffer3;
        int n122 = nalUnitTargetBuffer.nalLength;
        int n13 = nalUnitTargetBuffer2.nalLength + n122;
        int n14 = nalUnitTargetBuffer3.nalLength;
        byte[] byArray = new byte[n13 += n14];
        Object object3 = nalUnitTargetBuffer.nalData;
        System.arraycopy(object3, 0, byArray, 0, n122);
        byte[] byArray2 = nalUnitTargetBuffer2.nalData;
        n14 = nalUnitTargetBuffer.nalLength;
        int n15 = nalUnitTargetBuffer2.nalLength;
        System.arraycopy(byArray2, 0, byArray, n14, n15);
        byArray2 = nalUnitTargetBuffer3.nalData;
        int n16 = nalUnitTargetBuffer.nalLength;
        n14 = nalUnitTargetBuffer2.nalLength;
        int n17 = nalUnitTargetBuffer3.nalLength;
        System.arraycopy(byArray2, 0, byArray, n16 += n14, n17);
        object2 = nalUnitTargetBuffer2.nalData;
        n122 = nalUnitTargetBuffer2.nalLength;
        object = new ParsableNalUnitBitArray((byte[])object2, 0, n122);
        ((ParsableNalUnitBitArray)object).skipBits(44);
        n17 = 3;
        n122 = ((ParsableNalUnitBitArray)object).readBits(n17);
        ((ParsableNalUnitBitArray)object).skipBit();
        ((ParsableNalUnitBitArray)object).skipBits(88);
        n14 = 8;
        float f11 = 1.1E-44f;
        ((ParsableNalUnitBitArray)object).skipBits(n14);
        Object object4 = null;
        int n18 = 0;
        for (n15 = 0; n15 < n122; ++n15) {
            boolean n112 = ((ParsableNalUnitBitArray)object).readBit();
            if (n112) {
                n18 += 89;
            }
            if (!(n112 = ((ParsableNalUnitBitArray)object).readBit())) continue;
            n18 += 8;
        }
        ((ParsableNalUnitBitArray)object).skipBits(n18);
        n15 = 2;
        if (n122 > 0) {
            n18 = (8 - n122) * n15;
            ((ParsableNalUnitBitArray)object).skipBits(n18);
        }
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        n18 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        if (n18 == n17) {
            ((ParsableNalUnitBitArray)object).skipBit();
        }
        n17 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        int n19 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        boolean bl2 = ((ParsableNalUnitBitArray)object).readBit();
        int n20 = 1;
        if (bl2) {
            int n21 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            n12 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            int n22 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            int n23 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            int n24 = n18 != n20 && n18 != n15 ? n20 : n15;
            n18 = n18 == n20 ? n15 : n20;
            int n25 = n21 + n12;
            n17 -= (n24 *= n25);
            n11 = n19 - (n18 *= (n22 += n23));
        }
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        n18 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        boolean bl3 = ((ParsableNalUnitBitArray)object).readBit();
        if (bl3) {
            boolean bl4 = false;
        } else {
            int n26 = n122;
        }
        while (++var20_29 <= n122) {
            ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        }
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        n122 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
        if (n122 != 0 && (n122 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0)) != 0) {
            H265Reader.skipScalingList((ParsableNalUnitBitArray)object);
        }
        ((ParsableNalUnitBitArray)object).skipBits(n15);
        n122 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
        if (n122 != 0) {
            ((ParsableNalUnitBitArray)object).skipBits(n14);
            ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            ((ParsableNalUnitBitArray)object).skipBit();
        }
        H265Reader.skipShortTermRefPicSets((ParsableNalUnitBitArray)object);
        n122 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
        int n27 = 4;
        if (n122 != 0) {
            byArray2 = null;
            f10 = 0.0f;
            for (n122 = 0; n122 < (n12 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt()); ++n122) {
                n12 = n18 + 4 + n20;
                ((ParsableNalUnitBitArray)object).skipBits(n12);
            }
        }
        ((ParsableNalUnitBitArray)object).skipBits(n15);
        n122 = 1065353216;
        f10 = 1.0f;
        n15 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
        n18 = 24;
        if (n15 != 0) {
            n15 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
            if (n15 != 0) {
                if ((n14 = ((ParsableNalUnitBitArray)object).readBits(n14)) == (n15 = 255)) {
                    n14 = 16;
                    f11 = 2.24E-44f;
                    n15 = ((ParsableNalUnitBitArray)object).readBits(n14);
                    n14 = ((ParsableNalUnitBitArray)object).readBits(n14);
                    if (n15 != 0 && n14 != 0) {
                        f10 = n15;
                        f11 = n14;
                        f10 /= f11;
                    }
                } else {
                    object4 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                    n20 = ((float[])object4).length;
                    if (n14 < n20) {
                        f10 = object4[n14];
                    } else {
                        n15 = 46;
                        StringBuilder stringBuilder = new StringBuilder(n15);
                        stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                        stringBuilder.append(n14);
                        object3 = stringBuilder.toString();
                        object4 = TAG;
                        Log.w((String)object4, (String)object3);
                    }
                }
            }
            if ((n14 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0)) != 0) {
                ((ParsableNalUnitBitArray)object).skipBit();
            }
            if ((n14 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0)) != 0) {
                ((ParsableNalUnitBitArray)object).skipBits(n27);
                n14 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
                if (n14 != 0) {
                    ((ParsableNalUnitBitArray)object).skipBits(n18);
                }
            }
            if ((n14 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0)) != 0) {
                ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
                ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
            }
            ((ParsableNalUnitBitArray)object).skipBit();
            n14 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
            if (n14 != 0) {
                n10 = n11 * 2;
            }
        }
        object3 = ((NalUnitTargetBuffer)list).nalData;
        int n28 = ((NalUnitTargetBuffer)list).nalLength;
        ((ParsableNalUnitBitArray)object).reset((byte[])object3, 0, n28);
        ((ParsableNalUnitBitArray)object).skipBits(n18);
        object = CodecSpecificDataUtil.buildHevcCodecStringFromSps((ParsableNalUnitBitArray)object);
        list = new List<byte[]>();
        object3 = string2;
        object = ((Format$Builder)((Object)list)).setId(string2).setSampleMimeType("video/hevc").setCodecs((String)object).setWidth(n17).setHeight(n10).setPixelWidthHeightRatio(f10);
        list = Collections.singletonList(byArray);
        return ((Format$Builder)object).setInitializationData(list).build();
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = 4); ++i10) {
            int n11;
            int n12;
            for (int i11 = 0; i11 < (n11 = 6); i11 += n12) {
                n11 = (int)(parsableNalUnitBitArray.readBit() ? 1 : 0);
                n12 = 1;
                if (n11 == 0) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int n13 = (i10 << 1) + n10;
                    n13 = n12 << n13;
                    n11 = Math.min(64, n13);
                    if (i10 > n12) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (n13 = 0; n13 < n11; ++n13) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                n11 = 3;
                if (i10 != n11) continue;
                n12 = n11;
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int n10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean bl2 = false;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            int n13;
            if (i10 != 0) {
                bl2 = parsableNalUnitBitArray.readBit();
            }
            if (bl2) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (n13 = 0; n13 <= n11; ++n13) {
                    n12 = (int)(parsableNalUnitBitArray.readBit() ? 1 : 0);
                    if (n12 == 0) continue;
                    parsableNalUnitBitArray.skipBit();
                }
                continue;
            }
            n11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            n13 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            n12 = n11 + n13;
            for (int i11 = 0; i11 < n11; ++i11) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
            }
            for (n11 = 0; n11 < n13; ++n11) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
            }
            n11 = n12;
        }
    }

    private void startNalUnit(long l10, int n10, int n11, long l11) {
        H265Reader$SampleReader h265Reader$SampleReader = this.sampleReader;
        boolean bl2 = this.hasOutputFormat;
        h265Reader$SampleReader.startNalUnit(l10, n10, n11, l11, bl2);
        boolean bl3 = this.hasOutputFormat;
        if (!bl3) {
            this.vps.startNalUnit(n11);
            this.sps.startNalUnit(n11);
            NalUnitTargetBuffer nalUnitTargetBuffer = this.pps;
            nalUnitTargetBuffer.startNalUnit(n11);
        }
        this.prefixSei.startNalUnit(n11);
        this.suffixSei.startNalUnit(n11);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int n10;
        H265Reader h265Reader = this;
        this.assertTracksCreated();
        while ((n10 = parsableByteArray.bytesLeft()) > 0) {
            n10 = parsableByteArray.getPosition();
            int n11 = parsableByteArray.limit();
            byte[] byArray = parsableByteArray.getData();
            long l10 = h265Reader.totalBytesWritten;
            int n12 = parsableByteArray.bytesLeft();
            long l11 = n12;
            h265Reader.totalBytesWritten = l10 += l11;
            Object object = h265Reader.output;
            int n13 = parsableByteArray.bytesLeft();
            object.sampleData(parsableByteArray, n13);
            while (n10 < n11) {
                object = h265Reader.prefixFlags;
                int n14 = NalUnitUtil.findNalUnit(byArray, n10, n11, (boolean[])object);
                if (n14 == n11) {
                    h265Reader.nalUnitData(byArray, n10, n11);
                    return;
                }
                int n15 = NalUnitUtil.getH265NalUnitType(byArray, n14);
                int n16 = n14 - n10;
                if (n16 > 0) {
                    h265Reader.nalUnitData(byArray, n10, n14);
                }
                int n17 = n11 - n14;
                long l12 = h265Reader.totalBytesWritten;
                long l13 = n17;
                long l14 = l12 - l13;
                n10 = n16 < 0 ? -n16 : 0;
                long l15 = h265Reader.pesTimeUs;
                l10 = l14;
                n12 = n17;
                this.endNalUnit(l14, n17, n10, l15);
                l15 = h265Reader.pesTimeUs;
                this.startNalUnit(l14, n17, n15, l15);
                n10 = n14 + 3;
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        H265Reader$SampleReader h265Reader$SampleReader;
        tsPayloadReader$TrackIdGenerator.generateNewId();
        Object object = tsPayloadReader$TrackIdGenerator.getFormatId();
        this.formatId = object;
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        this.output = object = extractorOutput.track(n10, 2);
        this.sampleReader = h265Reader$SampleReader = new H265Reader$SampleReader((TrackOutput)object);
        this.seiReader.createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.pesTimeUs = l10;
    }

    public void seek() {
        long l10;
        this.totalBytesWritten = l10 = 0L;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        H265Reader$SampleReader h265Reader$SampleReader = this.sampleReader;
        if (h265Reader$SampleReader != null) {
            h265Reader$SampleReader.reset();
        }
    }
}

