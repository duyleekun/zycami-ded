/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.dvb;

public final class DvbParser$RegionObject {
    public final int backgroundPixelCode;
    public final int foregroundPixelCode;
    public final int horizontalPosition;
    public final int provider;
    public final int type;
    public final int verticalPosition;

    public DvbParser$RegionObject(int n10, int n11, int n12, int n13, int n14, int n15) {
        this.type = n10;
        this.provider = n11;
        this.horizontalPosition = n12;
        this.verticalPosition = n13;
        this.foregroundPixelCode = n14;
        this.backgroundPixelCode = n15;
    }
}

