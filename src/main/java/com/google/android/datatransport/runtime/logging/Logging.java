/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging {
    private Logging() {
    }

    public static void d(String string2, String string3) {
        Log.d((String)Logging.getTag(string2), (String)string3);
    }

    public static void d(String string2, String string3, Object object) {
        string2 = Logging.getTag(string2);
        Object[] objectArray = new Object[]{object};
        string3 = String.format(string3, objectArray);
        Log.d((String)string2, (String)string3);
    }

    public static void d(String string2, String string3, Object object, Object object2) {
        string2 = Logging.getTag(string2);
        Object[] objectArray = new Object[]{object, object2};
        string3 = String.format(string3, objectArray);
        Log.d((String)string2, (String)string3);
    }

    public static void d(String string2, String string3, Object ... objectArray) {
        string2 = Logging.getTag(string2);
        string3 = String.format(string3, objectArray);
        Log.d((String)string2, (String)string3);
    }

    public static void e(String string2, String string3, Throwable throwable) {
        Log.e((String)Logging.getTag(string2), (String)string3, (Throwable)throwable);
    }

    private static String getTag(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransportRuntime.");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void i(String string2, String string3) {
        Log.i((String)Logging.getTag(string2), (String)string3);
    }

    public static void w(String string2, String string3, Object object) {
        string2 = Logging.getTag(string2);
        Object[] objectArray = new Object[]{object};
        string3 = String.format(string3, objectArray);
        Log.w((String)string2, (String)string3);
    }
}

