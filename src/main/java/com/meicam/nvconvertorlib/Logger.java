/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.meicam.nvconvertorlib;

import android.util.Log;

public class Logger {
    private static boolean DEBUG = false;

    public static void e(String string2, Object object) {
        boolean bl2 = DEBUG;
        if (bl2) {
            object = String.valueOf(object);
            Log.e((String)string2, (String)object);
        }
    }
}

