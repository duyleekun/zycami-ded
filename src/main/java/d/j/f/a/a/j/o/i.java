/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.f.a.a.j.o;

import android.util.Log;

public class i {
    private static final String a = "SecurityComp10105306: ";

    private static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void b(String string2, String string3) {
    }

    public static void c(String string2, String string3, Throwable throwable) {
        Log.e((String)i.a(string2), (String)string3, (Throwable)throwable);
    }

    public static void d(String string2, String string3) {
        Log.e((String)i.a(string2), (String)string3);
    }

    public static void e(String string2, String string3) {
        Log.i((String)i.a(string2), (String)string3);
    }

    public static void f(String string2, String string3) {
        Log.v((String)i.a(string2), (String)string3);
    }

    public static void g(String string2, String string3) {
        Log.w((String)i.a(string2), (String)string3);
    }
}

