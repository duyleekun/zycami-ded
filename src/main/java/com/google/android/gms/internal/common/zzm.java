/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal.common;

import android.content.Context;
import android.os.Build;

public final class zzm {
    private static volatile boolean zza = zzm.zza() ^ true;
    private static boolean zzb = false;

    public static Context zza(Context context) {
        boolean bl2 = context.isDeviceProtectedStorage();
        if (bl2) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }

    public static boolean zza() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        return n10 >= n11;
    }
}

