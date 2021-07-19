/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

public final class zzfo
extends Enum {
    public static final /* enum */ zzfo zza;
    public static final /* enum */ zzfo zzb;
    public static final /* enum */ zzfo zzc;
    public static final /* enum */ zzfo zzd;
    private static final /* synthetic */ zzfo[] zzf;
    private final boolean zze;

    static {
        zzfo zzfo2;
        zzfo zzfo3;
        zzfo zzfo4;
        zzfo zzfo5;
        zza = zzfo5 = new zzfo("SCALAR", 0, false);
        int n10 = 1;
        zzb = zzfo4 = new zzfo("VECTOR", n10, n10 != 0);
        int n11 = 2;
        zzc = zzfo3 = new zzfo("PACKED_VECTOR", n11, n10 != 0);
        int n12 = 3;
        zzd = zzfo2 = new zzfo("MAP", n12, false);
        zzfo[] zzfoArray = new zzfo[4];
        zzfoArray[0] = zzfo5;
        zzfoArray[n10] = zzfo4;
        zzfoArray[n11] = zzfo3;
        zzfoArray[n12] = zzfo2;
        zzf = zzfoArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfo() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzfo[] values() {
        return (zzfo[])zzf.clone();
    }
}

