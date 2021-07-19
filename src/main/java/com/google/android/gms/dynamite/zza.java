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

public final class zza
implements DynamiteModule$VersionPolicy {
    public final DynamiteModule$VersionPolicy$zza zza(Context context, String string2, DynamiteModule$VersionPolicy$zzb dynamiteModule$VersionPolicy$zzb) {
        int n10;
        DynamiteModule$VersionPolicy$zza dynamiteModule$VersionPolicy$zza = new DynamiteModule$VersionPolicy$zza();
        int n11 = 1;
        dynamiteModule$VersionPolicy$zza.zzb = n10 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, n11 != 0);
        if (n10 != 0) {
            dynamiteModule$VersionPolicy$zza.zzc = n11;
        } else {
            int n12;
            dynamiteModule$VersionPolicy$zza.zza = n12 = dynamiteModule$VersionPolicy$zzb.zza(context, string2);
            if (n12 != 0) {
                dynamiteModule$VersionPolicy$zza.zzc = n12 = -1;
            }
        }
        return dynamiteModule$VersionPolicy$zza;
    }
}

