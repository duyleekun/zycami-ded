/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.framework.common.Logger;

public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "4.0.20.301";

    public static Bundle getMetaDataFromApp(Context object, String string2) {
        block6: {
            string2 = object.getPackageManager();
            if (string2 == null) {
                return null;
            }
            object = object.getPackageName();
            int n10 = 128;
            try {
                object = string2.getApplicationInfo((String)object, n10);
                break block6;
            }
            catch (RuntimeException runtimeException) {
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                // empty catch block
            }
            string2 = TAG;
            String string3 = "NameNotFoundException:";
            Logger.w(string2, string3, (Throwable)object);
            object = null;
        }
        if (object == null) {
            return null;
        }
        return object.metaData;
    }

    public static String getVersionName(Context object) {
        String string2;
        String string3 = "";
        if (object == null) {
            return string3;
        }
        PackageManager packageManager = object.getPackageManager();
        if (packageManager == null) {
            return string3;
        }
        object = object.getPackageName();
        int n10 = 16384;
        object = packageManager.getPackageInfo((String)object, n10);
        try {
            return object.versionName;
        }
        catch (RuntimeException runtimeException) {
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            // empty catch block
        }
        string2 = string2.getClass().getName();
        Logger.w(TAG, string2);
        return string3;
    }

    public String getPackageName(Context object) {
        Object object2 = object.getPackageManager();
        String string2 = "";
        if (object2 == null) {
            return string2;
        }
        object = object.getPackageName();
        int n10 = 16384;
        object = object2.getPackageInfo((String)object, n10);
        try {
            string2 = object.packageName;
        }
        catch (PackageManager.NameNotFoundException | RuntimeException throwable) {
            object = TAG;
            object2 = "Failed to get Package managers Package Info";
            Logger.w((String)object, object2);
        }
        return string2;
    }

    public String getVersion(Context object) {
        Object object2 = object.getPackageManager();
        String string2 = "";
        if (object2 == null) {
            return string2;
        }
        object = object.getPackageName();
        int n10 = 16384;
        object = object2.getPackageInfo((String)object, n10);
        int n11 = object.versionCode;
        try {
            string2 = String.valueOf(n11);
        }
        catch (PackageManager.NameNotFoundException | RuntimeException throwable) {
            object = TAG;
            object2 = "Failed to get Package managers Package Info";
            Logger.w((String)object, object2);
        }
        return string2;
    }
}

