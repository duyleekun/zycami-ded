/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.UserManager
 */
package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class zzaa {
    private static volatile UserManager zzdc;
    private static volatile boolean zzdd;

    static {
        zzdd = zzaa.zzf() ^ true;
    }

    private zzaa() {
    }

    public static boolean zze(Context context) {
        boolean bl2;
        boolean bl3 = zzaa.zzf();
        return bl3 && !(bl2 = zzaa.zzf(context));
    }

    private static boolean zzf() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        return n10 >= n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean zzf(Context object) {
        boolean bl2 = zzdd;
        if (!bl2) {
            Object object2 = zzdc;
            if (object2 == null) {
                Class<zzaa> clazz = zzaa.class;
                synchronized (clazz) {
                    object2 = zzdc;
                    if (object2 == null) {
                        object2 = UserManager.class;
                        object = object.getSystemService((Class)object2);
                        object = (UserManager)object;
                        zzdc = object;
                        if (object == null) {
                            boolean bl3;
                            zzdd = bl3 = true;
                            return bl3;
                        }
                        object2 = object;
                    }
                }
            }
            zzdd = bl2 = object2.isUserUnlocked();
            if (bl2) {
                boolean bl4 = false;
                object = null;
                zzdc = null;
            }
        }
        return bl2;
    }
}

