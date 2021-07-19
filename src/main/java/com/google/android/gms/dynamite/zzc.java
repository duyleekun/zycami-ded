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

public final class zzc
implements DynamiteModule$VersionPolicy {
    public final DynamiteModule$VersionPolicy$zza zza(Context context, String string2, DynamiteModule$VersionPolicy$zzb dynamiteModule$VersionPolicy$zzb) {
        int n10;
        DynamiteModule$VersionPolicy$zza dynamiteModule$VersionPolicy$zza = new DynamiteModule$VersionPolicy$zza();
        dynamiteModule$VersionPolicy$zza.zzb = n10 = dynamiteModule$VersionPolicy$zzb.zza(context, string2, false);
        dynamiteModule$VersionPolicy$zza.zzc = n10 == 0 ? 0 : (n10 = 1);
        return dynamiteModule$VersionPolicy$zza;
    }
}

