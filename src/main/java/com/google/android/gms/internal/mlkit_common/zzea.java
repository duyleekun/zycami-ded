/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzav$zzal$zzb;
import com.google.android.gms.internal.mlkit_common.zzec;
import com.google.mlkit.common.sdkinternal.ModelType;

public final class zzea {
    public static zzav$zzal$zzb zza(ModelType modelType) {
        int[] nArray = zzec.zza;
        int n10 = modelType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                return zzav$zzal$zzb.zza;
            }
            return zzav$zzal$zzb.zzb;
        }
        return zzav$zzal$zzb.zzc;
    }
}

