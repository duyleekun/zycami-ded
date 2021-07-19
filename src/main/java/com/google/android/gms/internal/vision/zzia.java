/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public final class zzia
extends Enum {
    public static final /* enum */ zzia zzxo;
    public static final /* enum */ zzia zzxp;
    public static final /* enum */ zzia zzxq;
    public static final /* enum */ zzia zzxr;
    private static final /* synthetic */ zzia[] zzxt;
    private final boolean zzxs;

    static {
        zzia zzia2;
        zzia zzia3;
        zzia zzia4;
        zzia zzia5;
        zzxo = zzia5 = new zzia("SCALAR", 0, false);
        int n10 = 1;
        zzxp = zzia4 = new zzia("VECTOR", n10, n10 != 0);
        int n11 = 2;
        zzxq = zzia3 = new zzia("PACKED_VECTOR", n11, n10 != 0);
        int n12 = 3;
        zzxr = zzia2 = new zzia("MAP", n12, false);
        zzia[] zziaArray = new zzia[4];
        zziaArray[0] = zzia5;
        zziaArray[n10] = zzia4;
        zziaArray[n11] = zzia3;
        zziaArray[n12] = zzia2;
        zzxt = zziaArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzia() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzxs = var3_1;
    }

    public static zzia[] values() {
        return (zzia[])zzxt.clone();
    }
}

