/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build$VERSION
 */
package d.j.f.a.a.j.o;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class k {
    private static final String a = "aegis";
    private static SharedPreferences b;

    public static int a(String string2, int n10, Context context) {
        return k.f(context).getInt(string2, n10);
    }

    public static long b(String string2, long l10, Context context) {
        return k.f(context).getLong(string2, l10);
    }

    public static String c(String string2, String string3, Context context) {
        return k.f(context).getString(string2, string3);
    }

    public static void d(Context context) {
        k.f(context).edit().clear().apply();
    }

    public static void e(String string2, Context context) {
        k.f(context).edit().remove(string2).apply();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SharedPreferences f(Context context) {
        Class<k> clazz = k.class;
        synchronized (clazz) {
            SharedPreferences sharedPreferences = b;
            if (sharedPreferences != null) return b;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if (n10 >= n11) {
                context = context.createDeviceProtectedStorageContext();
                String string2 = a;
                context = context.getSharedPreferences(string2, 0);
                b = context;
                return b;
            } else {
                context = context.getApplicationContext();
                String string3 = a;
                context = context.getSharedPreferences(string3, 0);
                b = context;
            }
            return b;
        }
    }

    public static void g(String string2, int n10, Context context) {
        k.f(context).edit().putInt(string2, n10).apply();
    }

    public static void h(String string2, long l10, Context context) {
        k.f(context).edit().putLong(string2, l10).apply();
    }

    public static void i(String string2, String string3, Context context) {
        k.f(context).edit().putString(string2, string3).apply();
    }
}

