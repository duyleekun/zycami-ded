/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Environment
 */
package com.geetest.sdk.utils;

import android.os.Build;
import android.os.Environment;

public class m {
    public static String a;

    public static String a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (n10 = (int)(Environment.isExternalStorageLegacy() ? 1 : 0)) == 0) {
            return a;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}

