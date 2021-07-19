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

public final class zze
implements DynamiteModule$VersionPolicy {
    public final DynamiteModule$VersionPolicy$zza zza(Context context, String string2, DynamiteModule$VersionPolicy$zzb dynamiteModule$VersionPolicy$zzb) {
        int n10;
        int n11;
        int n12;
        DynamiteModule$VersionPolicy$zza dynamiteModule$VersionPolicy$zza = new DynamiteModule$VersionPolicy$zza();
        dynamiteModule$VersionPolicy$zza.zza = n12 = dynamiteModule$VersionPolicy$zzb.zza(context, string2);
        int n13 = 1;
        dynamiteModule$VersionPolicy$zza.zzb = n12 != 0 ? (n11 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, false)) : (n11 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, n13 != 0));
        n11 = dynamiteModule$VersionPolicy$zza.zza;
        dynamiteModule$VersionPolicy$zza.zzc = n11 == 0 && (n10 = dynamiteModule$VersionPolicy$zza.zzb) == 0 ? 0 : (n11 >= (n10 = dynamiteModule$VersionPolicy$zza.zzb) ? (n11 = -1) : n13);
        return dynamiteModule$VersionPolicy$zza;
    }
}

