/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.os.Build$VERSION
 */
package com.xiaomi.push;

import android.content.SharedPreferences;
import android.os.Build;

public final class r {
    public static void a(SharedPreferences.Editor editor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 8;
        if (n10 > n11) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}

