/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;

public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public static String getVersionName(Context object) {
        int n10;
        String string2 = "";
        if (object == null) {
            return string2;
        }
        PackageManager packageManager = object.getPackageManager();
        try {
            object = object.getPackageName();
            n10 = 16384;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Logger.w(TAG, string2, nameNotFoundException);
            return string2;
        }
        object = packageManager.getPackageInfo((String)object, n10);
        return object.versionName;
    }
}

