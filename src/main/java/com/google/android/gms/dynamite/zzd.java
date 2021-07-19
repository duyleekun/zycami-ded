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

public final class zzd
implements DynamiteModule$VersionPolicy {
    public final DynamiteModule$VersionPolicy$zza zza(Context context, String string2, DynamiteModule$VersionPolicy$zzb dynamiteModule$VersionPolicy$zzb) {
        int n10;
        DynamiteModule$VersionPolicy$zza dynamiteModule$VersionPolicy$zza = new DynamiteModule$VersionPolicy$zza();
        dynamiteModule$VersionPolicy$zza.zza = n10 = dynamiteModule$VersionPolicy$zzb.zza(context, string2);
        if (n10 != 0) {
            int n11;
            dynamiteModule$VersionPolicy$zza.zzc = n11 = -1;
        } else {
            int n12;
            n10 = 1;
            dynamiteModule$VersionPolicy$zza.zzb = n12 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, n10 != 0);
            if (n12 != 0) {
                dynamiteModule$VersionPolicy$zza.zzc = n10;
            }
        }
        return dynamiteModule$VersionPolicy$zza;
    }
}

