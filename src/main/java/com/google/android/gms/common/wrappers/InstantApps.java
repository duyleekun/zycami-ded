/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isInstantApp(Context object) {
        Class<InstantApps> clazz = InstantApps.class;
        synchronized (clazz) {
            Boolean bl2;
            Context context = object.getApplicationContext();
            Object object2 = zza;
            if (object2 != null && (bl2 = zzb) != null && object2 == context) {
                return bl2;
            }
            boolean bl3 = false;
            object2 = null;
            zzb = null;
            bl3 = PlatformVersion.isAtLeastO();
            if (bl3) {
                object = context.getPackageManager();
                boolean bl4 = object.isInstantApp();
                zzb = object = Boolean.valueOf(bl4);
            } else {
                try {
                    object = object.getClassLoader();
                    object2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime";
                    ((ClassLoader)object).loadClass((String)object2);
                    zzb = object = Boolean.TRUE;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    zzb = object = Boolean.FALSE;
                }
            }
            zza = context;
            object = zzb;
            return (Boolean)object;
        }
    }
}

