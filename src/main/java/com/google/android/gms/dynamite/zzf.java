/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zza;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zzb;

public final class zzf
implements DynamiteModule$VersionPolicy {
    public final DynamiteModule$VersionPolicy$zza zza(Context context, String string2, DynamiteModule$VersionPolicy$zzb dynamiteModule$VersionPolicy$zzb) {
        int n10;
        int n11;
        DynamiteModule$VersionPolicy$zza dynamiteModule$VersionPolicy$zza = new DynamiteModule$VersionPolicy$zza();
        dynamiteModule$VersionPolicy$zza.zza = n11 = dynamiteModule$VersionPolicy$zzb.zza(context, string2);
        n11 = 1;
        dynamiteModule$VersionPolicy$zza.zzb = n10 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, n11 != 0);
        int n12 = dynamiteModule$VersionPolicy$zza.zza;
        if (n12 == 0 && n10 == 0) {
            n10 = 0;
            context = null;
            dynamiteModule$VersionPolicy$zza.zzc = 0;
        } else {
            dynamiteModule$VersionPolicy$zza.zzc = n12 >= n10 ? (n10 = -1) : n11;
        }
        return dynamiteModule$VersionPolicy$zza;
    }
}

