/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {
    private SharedPreferencesUtils() {
    }

    public static void publishWorldReadableSharedPreferences(Context object, SharedPreferences.Editor editor, String string2) {
        object = new IllegalStateException("world-readable shared preferences should only be used by apk");
        throw object;
    }
}

