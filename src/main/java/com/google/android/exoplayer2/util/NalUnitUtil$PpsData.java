/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

public final class NalUnitUtil$PpsData {
    public final boolean bottomFieldPicOrderInFramePresentFlag;
    public final int picParameterSetId;
    public final int seqParameterSetId;

    public NalUnitUtil$PpsData(int n10, int n11, boolean bl2) {
        this.picParameterSetId = n10;
        this.seqParameterSetId = n11;
        this.bottomFieldPicOrderInFramePresentFlag = bl2;
    }
}

