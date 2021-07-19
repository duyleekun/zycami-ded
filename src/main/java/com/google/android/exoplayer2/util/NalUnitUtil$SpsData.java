/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

public final class NalUnitUtil$SpsData {
    public final int constraintsFlagsAndReservedZero2Bits;
    public final boolean deltaPicOrderAlwaysZeroFlag;
    public final boolean frameMbsOnlyFlag;
    public final int frameNumLength;
    public final int height;
    public final int levelIdc;
    public final int picOrderCntLsbLength;
    public final int picOrderCountType;
    public final float pixelWidthAspectRatio;
    public final int profileIdc;
    public final boolean separateColorPlaneFlag;
    public final int seqParameterSetId;
    public final int width;

    public NalUnitUtil$SpsData(int n10, int n11, int n12, int n13, int n14, int n15, float f10, boolean bl2, boolean bl3, int n16, int n17, int n18, boolean bl4) {
        this.profileIdc = n10;
        this.constraintsFlagsAndReservedZero2Bits = n11;
        this.levelIdc = n12;
        this.seqParameterSetId = n13;
        this.width = n14;
        this.height = n15;
        this.pixelWidthAspectRatio = f10;
        this.separateColorPlaneFlag = bl2;
        this.frameMbsOnlyFlag = bl3;
        this.frameNumLength = n16;
        this.picOrderCountType = n17;
        this.picOrderCntLsbLength = n18;
        this.deltaPicOrderAlwaysZeroFlag = bl4;
    }
}

