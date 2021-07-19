/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader;
import com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer;
import com.google.android.exoplayer2.extractor.ts.SeiReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.NalUnitUtil$PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil$SpsData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class H264Reader
implements ElementaryStreamReader {
    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps;
    private final boolean[] prefixFlags;
    private boolean randomAccessIndicator;
    private H264Reader$SampleReader sampleReader;
    private final NalUnitTargetBuffer sei;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper;
    private final NalUnitTargetBuffer sps;
    private long totalBytesWritten;

    public H264Reader(SeiReader object, boolean bl2, boolean bl3) {
        this.seiReader = object;
        this.allowNonIdrKeyframes = bl2;
        this.detectAccessUnits = bl3;
        object = new boolean[3];
        this.prefixFlags = (boolean[])object;
        int n10 = 128;
        this.sps = object = new NalUnitTargetBuffer(7, n10);
        this.pps = object = new NalUnitTargetBuffer(8, n10);
        this.sei = object = new NalUnitTargetBuffer(6, n10);
        this.seiWrapper = object = new ParsableByteArray();
    }

    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    private void endNalUnit(long l10, int n10, int n11, long l11) {
        int n12;
        int n13;
        Object object;
        Object object2;
        boolean bl2;
        boolean n14 = this.hasOutputFormat;
        if (!n14 || (bl2 = ((H264Reader$SampleReader)(object2 = this.sampleReader)).needsSpsPps())) {
            this.sps.endNalUnit(n11);
            object2 = this.pps;
            ((NalUnitTargetBuffer)object2).endNalUnit(n11);
            boolean bl3 = this.hasOutputFormat;
            int n15 = 3;
            if (!bl3) {
                boolean bl4;
                object2 = this.sps;
                boolean bl5 = ((NalUnitTargetBuffer)object2).isCompleted();
                if (bl5 && (bl4 = ((NalUnitTargetBuffer)(object2 = this.pps)).isCompleted())) {
                    boolean bl6;
                    object2 = new ArrayList();
                    Object object3 = this.sps;
                    Object object4 = ((NalUnitTargetBuffer)object3).nalData;
                    int n16 = ((NalUnitTargetBuffer)object3).nalLength;
                    object3 = Arrays.copyOf((byte[])object4, n16);
                    object2.add(object3);
                    object3 = this.pps;
                    object4 = ((NalUnitTargetBuffer)object3).nalData;
                    n16 = ((NalUnitTargetBuffer)object3).nalLength;
                    object3 = Arrays.copyOf((byte[])object4, n16);
                    object2.add(object3);
                    object3 = this.sps;
                    object4 = ((NalUnitTargetBuffer)object3).nalData;
                    n16 = ((NalUnitTargetBuffer)object3).nalLength;
                    object3 = NalUnitUtil.parseSpsNalUnit((byte[])object4, n15, n16);
                    object4 = this.pps;
                    Object object5 = ((NalUnitTargetBuffer)object4).nalData;
                    int n17 = ((NalUnitTargetBuffer)object4).nalLength;
                    object = NalUnitUtil.parsePpsNalUnit((byte[])object5, n15, n17);
                    n17 = ((NalUnitUtil$SpsData)object3).profileIdc;
                    n13 = ((NalUnitUtil$SpsData)object3).constraintsFlagsAndReservedZero2Bits;
                    n12 = ((NalUnitUtil$SpsData)object3).levelIdc;
                    object4 = CodecSpecificDataUtil.buildAvcCodecString(n17, n13, n12);
                    object5 = this.output;
                    Format$Builder format$Builder = new Format$Builder();
                    String string2 = this.formatId;
                    format$Builder = format$Builder.setId(string2);
                    string2 = "video/avc";
                    format$Builder = format$Builder.setSampleMimeType(string2);
                    object4 = format$Builder.setCodecs((String)object4);
                    n12 = ((NalUnitUtil$SpsData)object3).width;
                    object4 = ((Format$Builder)object4).setWidth(n12);
                    n12 = ((NalUnitUtil$SpsData)object3).height;
                    object4 = ((Format$Builder)object4).setHeight(n12);
                    float f10 = ((NalUnitUtil$SpsData)object3).pixelWidthAspectRatio;
                    object4 = ((Format$Builder)object4).setPixelWidthHeightRatio(f10);
                    object2 = ((Format$Builder)object4).setInitializationData((List)object2).build();
                    object5.format((Format)object2);
                    this.hasOutputFormat = bl6 = true;
                    this.sampleReader.putSps((NalUnitUtil$SpsData)object3);
                    this.sampleReader.putPps((NalUnitUtil$PpsData)object);
                    this.sps.reset();
                    object2 = this.pps;
                    ((NalUnitTargetBuffer)object2).reset();
                }
            } else {
                object2 = this.sps;
                boolean bl7 = ((NalUnitTargetBuffer)object2).isCompleted();
                if (bl7) {
                    object2 = this.sps;
                    byte[] byArray = ((NalUnitTargetBuffer)object2).nalData;
                    int n18 = ((NalUnitTargetBuffer)object2).nalLength;
                    object2 = NalUnitUtil.parseSpsNalUnit(byArray, n15, n18);
                    object = this.sampleReader;
                    ((H264Reader$SampleReader)object).putSps((NalUnitUtil$SpsData)object2);
                    object2 = this.sps;
                    ((NalUnitTargetBuffer)object2).reset();
                } else {
                    object2 = this.pps;
                    boolean bl8 = ((NalUnitTargetBuffer)object2).isCompleted();
                    if (bl8) {
                        object2 = this.pps;
                        byte[] byArray = ((NalUnitTargetBuffer)object2).nalData;
                        int n19 = ((NalUnitTargetBuffer)object2).nalLength;
                        object2 = NalUnitUtil.parsePpsNalUnit(byArray, n15, n19);
                        object = this.sampleReader;
                        ((H264Reader$SampleReader)object).putPps((NalUnitUtil$PpsData)object2);
                        object2 = this.pps;
                        ((NalUnitTargetBuffer)object2).reset();
                    }
                }
            }
        }
        if ((n11 = (int)(((NalUnitTargetBuffer)(object2 = this.sei)).endNalUnit(n11) ? 1 : 0)) != 0) {
            Object object6 = this.sei;
            object2 = ((NalUnitTargetBuffer)object6).nalData;
            n11 = ((NalUnitTargetBuffer)object6).nalLength;
            n11 = NalUnitUtil.unescapeStream((byte[])object2, n11);
            object2 = this.seiWrapper;
            object = this.sei.nalData;
            ((ParsableByteArray)object2).reset((byte[])object, n11);
            object6 = this.seiWrapper;
            int n20 = 4;
            ((ParsableByteArray)object6).setPosition(n20);
            object6 = this.seiReader;
            object2 = this.seiWrapper;
            ((SeiReader)object6).consume(l11, (ParsableByteArray)object2);
        }
        object = this.sampleReader;
        n12 = this.hasOutputFormat;
        boolean bl9 = this.randomAccessIndicator;
        n13 = n10;
        boolean bl10 = ((H264Reader$SampleReader)object).endNalUnit(l10, n10, n12 != 0, bl9);
        if (bl10) {
            bl10 = false;
            this.randomAccessIndicator = false;
        }
    }

    private void nalUnitData(byte[] byArray, int n10, int n11) {
        Object object;
        boolean bl2 = this.hasOutputFormat;
        if (!bl2 || (bl2 = ((H264Reader$SampleReader)(object = this.sampleReader)).needsSpsPps())) {
            this.sps.appendToNalUnit(byArray, n10, n11);
            object = this.pps;
            ((NalUnitTargetBuffer)object).appendToNalUnit(byArray, n10, n11);
        }
        this.sei.appendToNalUnit(byArray, n10, n11);
        this.sampleReader.appendToNalUnit(byArray, n10, n11);
    }

    private void startNalUnit(long l10, int n10, long l11) {
        Object object;
        boolean bl2 = this.hasOutputFormat;
        if (!bl2 || (bl2 = ((H264Reader$SampleReader)(object = this.sampleReader)).needsSpsPps())) {
            this.sps.startNalUnit(n10);
            object = this.pps;
            ((NalUnitTargetBuffer)object).startNalUnit(n10);
        }
        this.sei.startNalUnit(n10);
        this.sampleReader.startNalUnit(l10, n10, l11);
    }

    public void consume(ParsableByteArray object) {
        this.assertTracksCreated();
        int n10 = ((ParsableByteArray)object).getPosition();
        int n11 = ((ParsableByteArray)object).limit();
        byte[] byArray = ((ParsableByteArray)object).getData();
        long l10 = this.totalBytesWritten;
        int n12 = ((ParsableByteArray)object).bytesLeft();
        long l11 = n12;
        this.totalBytesWritten = l10 += l11;
        Object object2 = this.output;
        int n13 = ((ParsableByteArray)object).bytesLeft();
        object2.sampleData((ParsableByteArray)object, n13);
        while (true) {
            int n14;
            if ((n14 = NalUnitUtil.findNalUnit(byArray, n10, n11, (boolean[])(object = (Object)this.prefixFlags))) == n11) {
                this.nalUnitData(byArray, n10, n11);
                return;
            }
            int n15 = NalUnitUtil.getNalUnitType(byArray, n14);
            int n16 = n14 - n10;
            if (n16 > 0) {
                this.nalUnitData(byArray, n10, n14);
            }
            int n17 = n11 - n14;
            long l12 = this.totalBytesWritten;
            long l13 = n17;
            n10 = n16 < 0 ? -n16 : 0;
            long l14 = this.pesTimeUs;
            this.endNalUnit(l12 -= l13, n17, n10, l14);
            l13 = this.pesTimeUs;
            object2 = this;
            this.startNalUnit(l12, n15, l13);
            n10 = n14 + 3;
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        H264Reader$SampleReader h264Reader$SampleReader;
        tsPayloadReader$TrackIdGenerator.generateNewId();
        Object object = tsPayloadReader$TrackIdGenerator.getFormatId();
        this.formatId = object;
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        this.output = object = extractorOutput.track(n10, 2);
        boolean bl2 = this.allowNonIdrKeyframes;
        boolean bl3 = this.detectAccessUnits;
        this.sampleReader = h264Reader$SampleReader = new H264Reader$SampleReader((TrackOutput)object, bl2, bl3);
        this.seiReader.createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.pesTimeUs = l10;
        int n11 = this.randomAccessIndicator;
        int n12 = n10 & 2;
        n12 = n12 != 0 ? 1 : 0;
        int n13 = n11 | n12;
        this.randomAccessIndicator = n13;
    }

    public void seek() {
        long l10;
        this.totalBytesWritten = l10 = 0L;
        this.randomAccessIndicator = false;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        H264Reader$SampleReader h264Reader$SampleReader = this.sampleReader;
        if (h264Reader$SampleReader != null) {
            h264Reader$SampleReader.reset();
        }
    }
}

