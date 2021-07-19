/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

public final class zzgc
extends Enum {
    public static final /* enum */ zzgc zza;
    public static final /* enum */ zzgc zzb;
    public static final /* enum */ zzgc zzc;
    public static final /* enum */ zzgc zzd;
    private static final /* synthetic */ zzgc[] zzf;
    private final boolean zze;

    static {
        zzgc zzgc2;
        zzgc zzgc3;
        zzgc zzgc4;
        zzgc zzgc5;
        zza = zzgc5 = new zzgc("SCALAR", 0, false);
        int n10 = 1;
        zzb = zzgc4 = new zzgc("VECTOR", n10, n10 != 0);
        int n11 = 2;
        zzc = zzgc3 = new zzgc("PACKED_VECTOR", n11, n10 != 0);
        int n12 = 3;
        zzd = zzgc2 = new zzgc("MAP", n12, false);
        zzgc[] zzgcArray = new zzgc[4];
        zzgcArray[0] = zzgc5;
        zzgcArray[n10] = zzgc4;
        zzgcArray[n11] = zzgc3;
        zzgcArray[n12] = zzgc2;
        zzf = zzgcArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzgc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzgc[] values() {
        return (zzgc[])zzf.clone();
    }
}

