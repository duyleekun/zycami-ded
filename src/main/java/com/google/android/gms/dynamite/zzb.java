/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zzb;

public final class zzb
implements DynamiteModule$VersionPolicy$zzb {
    public final int zza(Context context, String string2) {
        return DynamiteModule.getLocalVersion(context, string2);
    }

    public final int zza(Context context, String string2, boolean bl2) {
        return DynamiteModule.zza(context, string2, bl2);
    }
}

