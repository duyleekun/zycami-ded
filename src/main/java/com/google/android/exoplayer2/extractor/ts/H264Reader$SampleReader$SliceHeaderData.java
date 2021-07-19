/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ts.H264Reader$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil$SpsData;

public final class H264Reader$SampleReader$SliceHeaderData {
    private static final int SLICE_TYPE_ALL_I = 7;
    private static final int SLICE_TYPE_I = 2;
    private boolean bottomFieldFlag;
    private boolean bottomFieldFlagPresent;
    private int deltaPicOrderCnt0;
    private int deltaPicOrderCnt1;
    private int deltaPicOrderCntBottom;
    private boolean fieldPicFlag;
    private int frameNum;
    private boolean hasSliceType;
    private boolean idrPicFlag;
    private int idrPicId;
    private boolean isComplete;
    private int nalRefIdc;
    private int picOrderCntLsb;
    private int picParameterSetId;
    private int sliceType;
    private NalUnitUtil$SpsData spsData;

    private H264Reader$SampleReader$SliceHeaderData() {
    }

    public /* synthetic */ H264Reader$SampleReader$SliceHeaderData(H264Reader$1 h264Reader$1) {
        this();
    }

    public static /* synthetic */ boolean access$100(H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData, H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData2) {
        return h264Reader$SampleReader$SliceHeaderData.isFirstVclNalUnitOfPicture(h264Reader$SampleReader$SliceHeaderData2);
    }

    private boolean isFirstVclNalUnitOfPicture(H264Reader$SampleReader$SliceHeaderData h264Reader$SampleReader$SliceHeaderData) {
        int n10;
        int n11;
        int n12 = this.isComplete;
        int n13 = 0;
        if (n12 == 0) {
            return false;
        }
        n12 = h264Reader$SampleReader$SliceHeaderData.isComplete;
        int n14 = 1;
        if (n12 == 0) {
            return n14 != 0;
        }
        NalUnitUtil$SpsData nalUnitUtil$SpsData = (NalUnitUtil$SpsData)Assertions.checkStateNotNull(this.spsData);
        NalUnitUtil$SpsData nalUnitUtil$SpsData2 = (NalUnitUtil$SpsData)Assertions.checkStateNotNull(h264Reader$SampleReader$SliceHeaderData.spsData);
        int n15 = this.frameNum;
        int n16 = h264Reader$SampleReader$SliceHeaderData.frameNum;
        if (n15 != n16 || (n15 = this.picParameterSetId) != (n16 = h264Reader$SampleReader$SliceHeaderData.picParameterSetId) || (n15 = (int)(this.fieldPicFlag ? 1 : 0)) != (n16 = (int)(h264Reader$SampleReader$SliceHeaderData.fieldPicFlag ? 1 : 0)) || (n15 = (int)(this.bottomFieldFlagPresent ? 1 : 0)) != 0 && (n15 = (int)(h264Reader$SampleReader$SliceHeaderData.bottomFieldFlagPresent ? 1 : 0)) != 0 && (n15 = (int)(this.bottomFieldFlag ? 1 : 0)) != (n16 = (int)(h264Reader$SampleReader$SliceHeaderData.bottomFieldFlag ? 1 : 0)) || (n15 = this.nalRefIdc) != (n16 = h264Reader$SampleReader$SliceHeaderData.nalRefIdc) && (n15 == 0 || n16 == 0) || (n12 = nalUnitUtil$SpsData.picOrderCountType) == 0 && (n15 = nalUnitUtil$SpsData2.picOrderCountType) == 0 && ((n15 = this.picOrderCntLsb) != (n16 = h264Reader$SampleReader$SliceHeaderData.picOrderCntLsb) || (n15 = this.deltaPicOrderCntBottom) != (n16 = h264Reader$SampleReader$SliceHeaderData.deltaPicOrderCntBottom)) || n12 == n14 && (n12 = nalUnitUtil$SpsData2.picOrderCountType) == n14 && ((n12 = this.deltaPicOrderCnt0) != (n11 = h264Reader$SampleReader$SliceHeaderData.deltaPicOrderCnt0) || (n12 = this.deltaPicOrderCnt1) != (n11 = h264Reader$SampleReader$SliceHeaderData.deltaPicOrderCnt1)) || (n12 = (int)(this.idrPicFlag ? 1 : 0)) != (n11 = h264Reader$SampleReader$SliceHeaderData.idrPicFlag) || n12 != 0 && (n12 = this.idrPicId) != (n10 = h264Reader$SampleReader$SliceHeaderData.idrPicId)) {
            n13 = n14;
        }
        return n13 != 0;
    }

    public void clear() {
        this.hasSliceType = false;
        this.isComplete = false;
    }

    public boolean isISlice() {
        int n10;
        int n11 = this.hasSliceType;
        n11 = n11 != 0 && ((n11 = this.sliceType) == (n10 = 7) || n11 == (n10 = 2)) ? 1 : 0;
        return n11 != 0;
    }

    public void setAll(NalUnitUtil$SpsData nalUnitUtil$SpsData, int n10, int n11, int n12, int n13, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n14, int n15, int n16, int n17, int n18) {
        boolean bl6;
        this.spsData = nalUnitUtil$SpsData;
        this.nalRefIdc = n10;
        this.sliceType = n11;
        this.frameNum = n12;
        this.picParameterSetId = n13;
        this.fieldPicFlag = bl2;
        this.bottomFieldFlagPresent = bl3;
        this.bottomFieldFlag = bl4;
        this.idrPicFlag = bl5;
        this.idrPicId = n14;
        this.picOrderCntLsb = n15;
        this.deltaPicOrderCntBottom = n16;
        this.deltaPicOrderCnt0 = n17;
        this.deltaPicOrderCnt1 = n18;
        this.isComplete = bl6 = true;
        this.hasSliceType = bl6;
    }

    public void setSliceType(int n10) {
        this.sliceType = n10;
        this.hasSliceType = true;
    }
}

