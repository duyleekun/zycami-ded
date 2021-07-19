/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

public final class zzei
extends Enum {
    public static final /* enum */ zzei zza;
    public static final /* enum */ zzei zzb;
    public static final /* enum */ zzei zzc;
    public static final /* enum */ zzei zzd;
    private static final /* synthetic */ zzei[] zzf;
    private final boolean zze;

    static {
        zzei zzei2;
        zzei zzei3;
        zzei zzei4;
        zzei zzei5;
        zza = zzei5 = new zzei("SCALAR", 0, false);
        int n10 = 1;
        zzb = zzei4 = new zzei("VECTOR", n10, n10 != 0);
        int n11 = 2;
        zzc = zzei3 = new zzei("PACKED_VECTOR", n11, n10 != 0);
        int n12 = 3;
        zzd = zzei2 = new zzei("MAP", n12, false);
        zzei[] zzeiArray = new zzei[4];
        zzeiArray[0] = zzei5;
        zzeiArray[n10] = zzei4;
        zzeiArray[n11] = zzei3;
        zzeiArray[n12] = zzei2;
        zzf = zzeiArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzei() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzei[] values() {
        return (zzei[])zzf.clone();
    }
}

