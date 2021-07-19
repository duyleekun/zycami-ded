/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.huawei.updatesdk.a.a;

import android.util.Log;

public class a {
    public static void a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateSDK_");
        stringBuilder.append(string2);
        Log.e((String)stringBuilder.toString(), (String)string3);
    }

    public static void b(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateSDK_");
        stringBuilder.append(string2);
        Log.i((String)stringBuilder.toString(), (String)string3);
    }

    public static void c(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpdateSDK_");
        stringBuilder.append(string2);
        Log.w((String)stringBuilder.toString(), (String)string3);
    }
}

