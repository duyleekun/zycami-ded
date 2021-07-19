/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.f.a.a.h.f;

import android.util.Log;

public class g {
    private static final String a = "SecurityComp10105302: ";

    public static void a(String string2, String string3, Throwable throwable) {
        Log.e((String)g.g(string2), (String)string3, (Throwable)throwable);
    }

    public static void b(String string2, String string3) {
        Log.v((String)g.g(string2), (String)string3);
    }

    public static void c(String string2, String string3) {
    }

    public static void d(String string2, String string3) {
        Log.i((String)g.g(string2), (String)string3);
    }

    public static void e(String string2, String string3) {
        Log.w((String)g.g(string2), (String)string3);
    }

    public static void f(String string2, String string3) {
        Log.e((String)g.g(string2), (String)string3);
    }

    private static String g(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

