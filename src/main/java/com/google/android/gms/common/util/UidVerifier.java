/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.Wrappers;

public final class UidVerifier {
    private UidVerifier() {
    }

    public static boolean isGooglePlayServicesUid(Context object, int n10) {
        String string2 = "com.google.android.gms";
        if ((n10 = (int)(UidVerifier.uidHasPackageName(object, n10, string2) ? 1 : 0)) == 0) {
            return false;
        }
        Object object2 = object.getPackageManager();
        int n11 = 64;
        try {
            object2 = object2.getPackageInfo(string2, n11);
            return GoogleSignatureVerifier.getInstance(object).isGooglePublicSignedPackage((PackageInfo)object2);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object2 = "UidVerifier";
            boolean bl2 = Log.isLoggable((String)object2, (int)3);
            if (bl2) {
                object = "Package manager can't find google play services package, defaulting to false";
                Log.d((String)object2, (String)object);
            }
            return false;
        }
    }

    public static boolean uidHasPackageName(Context context, int n10, String string2) {
        return Wrappers.packageManager(context).zza(n10, string2);
    }
}

