/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.h;

import android.content.Context;

public class d {
    private static final String a = "camera_sdk";
    private static final String b = "camera_api";
    private static final String c = "camera_mode";
    private static final String d = "camera_id";

    public static int a(Context context) {
        return context.getSharedPreferences(a, 0).getInt(b, -1);
    }

    public static int b(Context context) {
        return context.getSharedPreferences(a, 0).getInt(d, -1);
    }

    public static int c(Context context) {
        return context.getSharedPreferences(a, 0).getInt(c, -1);
    }

    public static void d(Context context, int n10) {
        context.getSharedPreferences(a, 0).edit().putInt(b, n10).apply();
    }

    public static void e(Context context, int n10) {
        context.getSharedPreferences(a, 0).edit().putInt(d, n10).apply();
    }

    public static void f(Context context, int n10) {
        context.getSharedPreferences(a, 0).edit().putInt(c, n10).apply();
    }
}

