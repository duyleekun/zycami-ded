/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfo;
import com.google.android.gms.internal.mlkit_common.zzgd;

public final class zzfp {
    public static final /* synthetic */ int[] zza;
    public static final /* synthetic */ int[] zzb;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = zzgd.values().length;
        int[] nArray = new int[n13];
        zzb = nArray;
        int n14 = 1;
        try {
            object3 = zzgd.zzh;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = zzb;
            object2 = zzgd.zzj;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (zzgd)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = zzb;
            enum_ = zzgd.zzg;
            n10 = enum_.ordinal();
            object2[n10] = (zzgd)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = zzfo.values().length;
        object2 = new int[n11];
        zza = (int[])object2;
        try {
            enum_ = zzfo.zzd;
            n10 = enum_.ordinal();
            object2[n10] = (zzgd)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = zza;
            object2 = zzfo.zzb;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            object = (Object)zzfo.zza;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

