/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

public final class zzcd
extends Enum {
    public static final /* enum */ zzcd zzjg;
    public static final /* enum */ zzcd zzjh;
    public static final /* enum */ zzcd zzji;
    public static final /* enum */ zzcd zzjj;
    private static final /* synthetic */ zzcd[] zzjl;
    private final boolean zzjk;

    static {
        zzcd zzcd2;
        zzcd zzcd3;
        zzcd zzcd4;
        zzcd zzcd5;
        zzjg = zzcd5 = new zzcd("SCALAR", 0, false);
        int n10 = 1;
        zzjh = zzcd4 = new zzcd("VECTOR", n10, n10 != 0);
        int n11 = 2;
        zzji = zzcd3 = new zzcd("PACKED_VECTOR", n11, n10 != 0);
        int n12 = 3;
        zzjj = zzcd2 = new zzcd("MAP", n12, false);
        zzcd[] zzcdArray = new zzcd[4];
        zzcdArray[0] = zzcd5;
        zzcdArray[n10] = zzcd4;
        zzcdArray[n11] = zzcd3;
        zzcdArray[n12] = zzcd2;
        zzjl = zzcdArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzjk = var3_1;
    }

    public static zzcd[] values() {
        return (zzcd[])zzjl.clone();
    }
}

