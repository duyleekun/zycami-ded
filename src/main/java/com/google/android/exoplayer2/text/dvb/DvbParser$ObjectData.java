/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.dvb;

public final class DvbParser$ObjectData {
    public final byte[] bottomFieldData;
    public final int id;
    public final boolean nonModifyingColorFlag;
    public final byte[] topFieldData;

    public DvbParser$ObjectData(int n10, boolean bl2, byte[] byArray, byte[] byArray2) {
        this.id = n10;
        this.nonModifyingColorFlag = bl2;
        this.topFieldData = byArray;
        this.bottomFieldData = byArray2;
    }
}

