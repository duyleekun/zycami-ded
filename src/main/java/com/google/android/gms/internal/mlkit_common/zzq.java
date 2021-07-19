/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

public final class zzq {
    public static final /* enum */ int zza = 1;
    public static final /* enum */ int zzb = 2;
    public static final /* enum */ int zzc = 3;
    private static final /* synthetic */ int[] zzd;

    static {
        int n10;
        int n11;
        int n12 = 3;
        int[] nArray = new int[n12];
        nArray[0] = n11 = 1;
        nArray[n11] = n10 = 2;
        nArray[n10] = n12;
        zzd = nArray;
    }

    public static int[] zza() {
        return (int[])zzd.clone();
    }
}

