/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.transformer.SampleTransformer;
import com.google.android.exoplayer2.transformer.SefSlowMotionVideoSampleTransformer$MetadataInfo;
import com.google.android.exoplayer2.transformer.SefSlowMotionVideoSampleTransformer$SegmentInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class SefSlowMotionVideoSampleTransformer
implements SampleTransformer {
    public static final int INPUT_FRAME_RATE = 30;
    private static final int NAL_START_CODE_LENGTH = 0;
    private static final int NAL_UNIT_TYPE_PREFIX = 14;
    private static final int TARGET_OUTPUT_FRAME_RATE = 30;
    private final float captureFrameRate;
    private SefSlowMotionVideoSampleTransformer$SegmentInfo currentSegmentInfo;
    private long frameTimeDeltaUs;
    private final int inputMaxLayer;
    private SefSlowMotionVideoSampleTransformer$SegmentInfo nextSegmentInfo;
    private final int normalSpeedMaxLayer;
    private final byte[] scratch;
    private final Iterator segmentIterator;
    private final SlowMotionData slowMotionData;

    static {
        NAL_START_CODE_LENGTH = NalUnitUtil.NAL_START_CODE.length;
    }

    public SefSlowMotionVideoSampleTransformer(Format object) {
        SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo;
        int n10;
        int n11;
        float f10;
        int bl2 = NAL_START_CODE_LENGTH;
        Object object2 = new byte[bl2];
        this.scratch = object2;
        object2 = SefSlowMotionVideoSampleTransformer.getMetadataInfo(((Format)object).metadata);
        Object object3 = object2.slowMotionData;
        this.slowMotionData = object3;
        List list = object3 != null ? ((SlowMotionData)object3).segments : ImmutableList.of();
        this.segmentIterator = list = list.iterator();
        this.captureFrameRate = f10 = object2.captureFrameRate;
        this.inputMaxLayer = n11 = object2.inputMaxLayer;
        this.normalSpeedMaxLayer = n10 = object2.normalSpeedMaxLayer;
        boolean bl3 = list.hasNext();
        if (bl3) {
            list = (SlowMotionData$Segment)list.next();
            sefSlowMotionVideoSampleTransformer$SegmentInfo = new SefSlowMotionVideoSampleTransformer$SegmentInfo((SlowMotionData$Segment)((Object)list), n11, n10);
        } else {
            bl3 = false;
            sefSlowMotionVideoSampleTransformer$SegmentInfo = null;
        }
        this.nextSegmentInfo = sefSlowMotionVideoSampleTransformer$SegmentInfo;
        if (object3 != null) {
            object2 = ((Format)object).sampleMimeType;
            boolean bl4 = "video/avc".equals(object2);
            object3 = "Unsupported MIME type for SEF slow motion video track: ";
            object = String.valueOf(((Format)object).sampleMimeType);
            int n12 = ((String)object).length();
            object = n12 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
            Assertions.checkArgument(bl4, object);
        }
    }

    private void enterNextSegment() {
        Object object = this.currentSegmentInfo;
        if (object != null) {
            this.leaveCurrentSegment();
        }
        object = this.nextSegmentInfo;
        this.currentSegmentInfo = object;
        object = this.segmentIterator;
        boolean bl2 = object.hasNext();
        if (bl2) {
            SlowMotionData$Segment slowMotionData$Segment = (SlowMotionData$Segment)this.segmentIterator.next();
            int n10 = this.inputMaxLayer;
            int n11 = this.normalSpeedMaxLayer;
            object = new SefSlowMotionVideoSampleTransformer$SegmentInfo(slowMotionData$Segment, n10, n11);
        } else {
            bl2 = false;
            object = null;
        }
        this.nextSegmentInfo = object;
    }

    private static SefSlowMotionVideoSampleTransformer$MetadataInfo getMetadataInfo(Metadata object) {
        float f10;
        float f11;
        Object object2;
        float f12;
        int n10;
        int n11;
        SefSlowMotionVideoSampleTransformer$MetadataInfo sefSlowMotionVideoSampleTransformer$MetadataInfo = new SefSlowMotionVideoSampleTransformer$MetadataInfo();
        if (object == null) {
            return sefSlowMotionVideoSampleTransformer$MetadataInfo;
        }
        int n12 = 0;
        int n13 = 0;
        String string2 = null;
        float f13 = 0.0f;
        while (true) {
            n11 = ((Metadata)object).length();
            n10 = 1;
            f12 = Float.MIN_VALUE;
            if (n13 >= n11) break;
            object2 = ((Metadata)object).get(n13);
            boolean bl2 = object2 instanceof SmtaMetadataEntry;
            if (bl2) {
                float f14;
                object2 = (SmtaMetadataEntry)object2;
                sefSlowMotionVideoSampleTransformer$MetadataInfo.captureFrameRate = f14 = ((SmtaMetadataEntry)object2).captureFrameRate;
                sefSlowMotionVideoSampleTransformer$MetadataInfo.inputMaxLayer = n11 = ((SmtaMetadataEntry)object2).svcTemporalLayerCount - n10;
            } else {
                n10 = object2 instanceof SlowMotionData;
                if (n10 != 0) {
                    object2 = (SlowMotionData)object2;
                    sefSlowMotionVideoSampleTransformer$MetadataInfo.slowMotionData = object2;
                }
            }
            ++n13;
        }
        object = sefSlowMotionVideoSampleTransformer$MetadataInfo.slowMotionData;
        if (object == null) {
            return sefSlowMotionVideoSampleTransformer$MetadataInfo;
        }
        int n14 = sefSlowMotionVideoSampleTransformer$MetadataInfo.inputMaxLayer;
        n13 = -1;
        f13 = 0.0f / 0.0f;
        if (n14 != n13) {
            n14 = n10;
            f11 = f12;
        } else {
            n14 = 0;
            object = null;
            f11 = 0.0f;
        }
        string2 = "SVC temporal layer count not found.";
        Assertions.checkState(n14 != 0, string2);
        f11 = sefSlowMotionVideoSampleTransformer$MetadataInfo.captureFrameRate;
        n13 = -8388609;
        f13 = -3.4028235E38f;
        n14 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
        if (n14 != 0) {
            n14 = n10;
            f11 = f12;
        } else {
            n14 = 0;
            object = null;
            f11 = 0.0f;
        }
        string2 = "Capture frame rate not found.";
        Assertions.checkState(n14 != 0, string2);
        f11 = sefSlowMotionVideoSampleTransformer$MetadataInfo.captureFrameRate;
        f13 = f11 % 1.0f;
        n11 = 0;
        object2 = null;
        float f15 = f13 - 0.0f;
        n13 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
        if (n13 == 0 && (n13 = (int)((f10 = (f13 = f11 % 30.0f) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) == 0) {
            n13 = n10;
            f13 = f12;
        } else {
            n13 = 0;
            string2 = null;
            f13 = 0.0f;
        }
        n11 = 43;
        StringBuilder stringBuilder = new StringBuilder(n11);
        object2 = "Invalid capture frame rate: ";
        stringBuilder.append((String)object2);
        stringBuilder.append(f11);
        object = stringBuilder.toString();
        Assertions.checkState(n13 != 0, object);
        f11 = sefSlowMotionVideoSampleTransformer$MetadataInfo.captureFrameRate;
        n14 = (int)f11 / 30;
        for (n13 = sefSlowMotionVideoSampleTransformer$MetadataInfo.inputMaxLayer; n13 >= 0; n13 += -1) {
            n11 = n14 & 1;
            if (n11 == n10) {
                if ((n14 >>= n10) == 0) {
                    n12 = n10;
                }
                f11 = sefSlowMotionVideoSampleTransformer$MetadataInfo.captureFrameRate;
                n11 = 84;
                StringBuilder stringBuilder2 = new StringBuilder(n11);
                object2 = "Could not compute normal speed max SVC layer for capture frame rate  ";
                stringBuilder2.append((String)object2);
                stringBuilder2.append(f11);
                object = stringBuilder2.toString();
                Assertions.checkState(n12 != 0, object);
                sefSlowMotionVideoSampleTransformer$MetadataInfo.normalSpeedMaxLayer = n13;
                break;
            }
            n14 >>= 1;
        }
        return sefSlowMotionVideoSampleTransformer$MetadataInfo;
    }

    private void leaveCurrentSegment() {
        long l10 = this.frameTimeDeltaUs;
        SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo = this.currentSegmentInfo;
        long l11 = sefSlowMotionVideoSampleTransformer$SegmentInfo.endTimeUs;
        long l12 = sefSlowMotionVideoSampleTransformer$SegmentInfo.startTimeUs;
        l11 -= l12;
        l12 = sefSlowMotionVideoSampleTransformer$SegmentInfo.speedDivisor + -1;
        this.frameTimeDeltaUs = l10 += (l11 *= l12);
        this.currentSegmentInfo = null;
    }

    private boolean shouldKeepFrameForOutputValidity(int n10, long l10) {
        int n11;
        SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo = this.nextSegmentInfo;
        if (sefSlowMotionVideoSampleTransformer$SegmentInfo != null && n10 < (n11 = sefSlowMotionVideoSampleTransformer$SegmentInfo.maxLayer)) {
            long l11 = (sefSlowMotionVideoSampleTransformer$SegmentInfo.startTimeUs - l10) * (long)30;
            l10 = 1000000L;
            l11 /= l10;
            int n12 = this.inputMaxLayer - n11;
            int n13 = 1;
            n12 = -(n13 << n12);
            float f10 = (float)n12 + 0.45f;
            int n14 = n13;
            while (true) {
                SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo2 = this.nextSegmentInfo;
                n11 = sefSlowMotionVideoSampleTransformer$SegmentInfo2.maxLayer;
                if (n14 >= n11) break;
                float f11 = l11;
                int n15 = this.inputMaxLayer - n14;
                float f12 = (float)(n15 = n13 << n15) + f10;
                float f13 = f11 - f12;
                n11 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
                if (n11 >= 0) break;
                if (n10 <= n14) {
                    return n13 != 0;
                }
                ++n14;
            }
        }
        return false;
    }

    private void skipToNextNalUnit(ByteBuffer object) {
        int n10;
        int n11;
        int n12 = ((Buffer)object).position();
        while ((n11 = ((Buffer)object).remaining()) >= (n10 = NAL_START_CODE_LENGTH)) {
            byte[] byArray = this.scratch;
            ((ByteBuffer)object).get(byArray, 0, n10);
            byArray = this.scratch;
            byte[] byArray2 = NalUnitUtil.NAL_START_CODE;
            n11 = (int)(Arrays.equals(byArray, byArray2) ? 1 : 0);
            if (n11 != 0) {
                ((ByteBuffer)object).position(n12);
                return;
            }
            ((ByteBuffer)object).position(++n12);
        }
        object = new IllegalStateException("Could not find NAL unit start code.");
        throw object;
    }

    public long getCurrentFrameOutputTimeUs(long l10) {
        long l11 = this.frameTimeDeltaUs + l10;
        SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo = this.currentSegmentInfo;
        if (sefSlowMotionVideoSampleTransformer$SegmentInfo != null) {
            long l12 = sefSlowMotionVideoSampleTransformer$SegmentInfo.startTimeUs;
            l10 -= l12;
            int n10 = sefSlowMotionVideoSampleTransformer$SegmentInfo.speedDivisor + -1;
            long l13 = n10;
            l11 += (l10 *= l13);
        }
        float f10 = l11 * (long)30;
        float f11 = this.captureFrameRate;
        return Math.round(f10 / f11);
    }

    public boolean processCurrentFrame(int n10, long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        SefSlowMotionVideoSampleTransformer$SegmentInfo sefSlowMotionVideoSampleTransformer$SegmentInfo;
        while ((sefSlowMotionVideoSampleTransformer$SegmentInfo = this.nextSegmentInfo) != null && (l16 = (l15 = l10 - (l14 = sefSlowMotionVideoSampleTransformer$SegmentInfo.endTimeUs)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) >= 0) {
            this.enterNextSegment();
        }
        if (sefSlowMotionVideoSampleTransformer$SegmentInfo != null && (l13 = (l12 = l10 - (l11 = sefSlowMotionVideoSampleTransformer$SegmentInfo.startTimeUs)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
            this.enterNextSegment();
        } else {
            long l17;
            sefSlowMotionVideoSampleTransformer$SegmentInfo = this.currentSegmentInfo;
            if (sefSlowMotionVideoSampleTransformer$SegmentInfo != null && (l13 = (l17 = l10 - (l11 = sefSlowMotionVideoSampleTransformer$SegmentInfo.endTimeUs)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) >= 0) {
                this.leaveCurrentSegment();
            }
        }
        sefSlowMotionVideoSampleTransformer$SegmentInfo = this.currentSegmentInfo;
        l13 = sefSlowMotionVideoSampleTransformer$SegmentInfo != null ? (long)sefSlowMotionVideoSampleTransformer$SegmentInfo.maxLayer : (long)this.normalSpeedMaxLayer;
        n10 = n10 > l13 && (n10 = (int)(this.shouldKeepFrameForOutputValidity(n10, l10) ? 1 : 0)) == 0 ? 0 : 1;
        return n10 != 0;
    }

    public void transformSample(DecoderInputBuffer decoderInputBuffer) {
        Object object = this.slowMotionData;
        if (object == null) {
            return;
        }
        object = (ByteBuffer)Util.castNonNull(decoderInputBuffer.data);
        int n10 = ((Buffer)object).position();
        int n11 = NAL_START_CODE_LENGTH;
        ((ByteBuffer)object).position(n10 += n11);
        byte[] byArray = this.scratch;
        int n12 = 0;
        ((ByteBuffer)object).get(byArray, 0, 4);
        byArray = this.scratch;
        n11 = byArray[0] & 0x1F;
        int n13 = 1;
        n10 = (byArray[n13] & 0xFF) >> 7;
        if (n10 == n13) {
            n10 = n13;
        } else {
            n10 = 0;
            byArray = null;
        }
        int n14 = 14;
        if (n11 == n14 && n10 != 0) {
            n12 = n13;
        }
        Assertions.checkState(n12 != 0, "Missing SVC extension prefix NAL unit.");
        byArray = this.scratch;
        n11 = 3;
        n10 = (byArray[n11] & 0xFF) >> 5;
        long l10 = decoderInputBuffer.timeUs;
        n10 = (int)(this.processCurrentFrame(n10, l10) ? 1 : 0);
        if (n10 != 0) {
            long l11 = decoderInputBuffer.timeUs;
            decoderInputBuffer.timeUs = l11 = this.getCurrentFrameOutputTimeUs(l11);
            this.skipToNextNalUnit((ByteBuffer)object);
        } else {
            object = null;
            decoderInputBuffer.data = null;
        }
    }
}

