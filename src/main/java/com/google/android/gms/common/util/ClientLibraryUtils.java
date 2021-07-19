/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    public static int getClientVersion(Context context, String string2) {
        context = ClientLibraryUtils.zzb(context, string2);
        int n10 = -1;
        if (context != null && (context = context.applicationInfo) != null) {
            context = context.metaData;
            if (context == null) {
                return n10;
            }
            return context.getInt("com.google.android.gms.version", n10);
        }
        return n10;
    }

    public static boolean isPackageSide() {
        return false;
    }

    public static boolean zza(Context object, String string2) {
        "com.google.android.gms".equals(string2);
        try {
            object = Wrappers.packageManager((Context)object);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        object = ((PackageManagerWrapper)object).getApplicationInfo(string2, 0);
        int n10 = ((ApplicationInfo)object).flags;
        int n11 = 0x200000;
        if ((n10 &= n11) != 0) {
            return true;
        }
        return false;
    }

    private static PackageInfo zzb(Context object, String string2) {
        int n10;
        try {
            object = Wrappers.packageManager((Context)object);
            n10 = 128;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        return ((PackageManagerWrapper)object).getPackageInfo(string2, n10);
    }
}

