/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcj;

public final class zzs {
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
        int n13;
        Object object4;
        int n14 = zzcc.values().length;
        int[] nArray = new int[n14];
        zzb = nArray;
        int n15 = 1;
        try {
            object4 = zzcc.zzb;
            n13 = ((Enum)object4).ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = zzb;
            object3 = zzcc.zzc;
            n12 = ((Enum)object3).ordinal();
            object4[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = zzb;
            object2 = zzcc.zzd;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = zzb;
            enum_ = zzcc.zze;
            n10 = enum_.ordinal();
            object2[n10] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = zzcj.values().length;
        object2 = new int[n11];
        zza = (int[])object2;
        try {
            enum_ = zzcj.zzb;
            n10 = enum_.ordinal();
            object2[n10] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = zza;
            object2 = zzcj.zzc;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            object = zzcj.zzd;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            object = zzcj.zze;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            object = zzcj.zzf;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            object = zzcj.zzg;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

