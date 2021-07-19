/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.os.UserHandle
 *  android.os.UserManager
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Log;

public class zzas {
    private static UserManager zzfm;
    private static volatile boolean zzfn;
    private static boolean zzfo;

    static {
        zzfn = zzas.zzu() ^ true;
        zzfo = false;
    }

    private zzas() {
    }

    public static boolean isUserUnlocked(Context context) {
        boolean bl2;
        boolean bl3 = zzas.zzu();
        return !bl3 || (bl2 = zzas.zzd(context));
        {
        }
    }

    private static boolean zzc(Context context) {
        int n10;
        int n11;
        int n12 = n11 = 1;
        while (true) {
            block8: {
                String string2;
                int n13 = 2;
                n10 = 0;
                String string3 = null;
                if (n12 > n13) break;
                UserManager userManager = zzfm;
                if (userManager == null) {
                    zzfm = userManager = (UserManager)context.getSystemService(UserManager.class);
                }
                if ((userManager = zzfm) == null) {
                    return n11 != 0;
                }
                try {
                    boolean bl2 = userManager.isUserUnlocked();
                    if (bl2) break block8;
                }
                catch (NullPointerException nullPointerException) {
                    string3 = "DirectBootUtils";
                    string2 = "Failed to check if user is unlocked.";
                    Log.w((String)string3, (String)string2, (Throwable)nullPointerException);
                    zzfm = null;
                    ++n12;
                    continue;
                }
                string2 = Process.myUserHandle();
                boolean bl3 = userManager.isUserRunning((UserHandle)string2);
                if (!bl3) break block8;
                n11 = 0;
            }
            n10 = n11;
            break;
        }
        if (n10 != 0) {
            zzfm = null;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean zzd(Context context) {
        boolean bl2 = zzfn;
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        Class<zzas> clazz = zzas.class;
        synchronized (clazz) {
            boolean bl4 = zzfn;
            if (bl4) {
                return bl3;
            }
            boolean bl5 = zzas.zzc(context);
            if (bl5) {
                zzfn = bl5;
            }
            return bl5;
        }
    }

    public static boolean zzu() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        return n10 >= n11;
    }
}

