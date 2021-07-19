/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;

public final class DvbParser$PageComposition {
    public final SparseArray regions;
    public final int state;
    public final int timeOutSecs;
    public final int version;

    public DvbParser$PageComposition(int n10, int n11, int n12, SparseArray sparseArray) {
        this.timeOutSecs = n10;
        this.version = n11;
        this.state = n12;
        this.regions = sparseArray;
    }
}

