/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.u;

import android.content.Context;
import d.r.a.u.d0;
import d.r.a.u.q;
import d.r.a.u.r;

public final class s {
    public static final r a;
    private static boolean b;
    private static boolean c;

    static {
        q q10 = new q();
        a = q10;
        b = d0.l("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int a(String string2, String string3) {
        return a.a(string2, string3);
    }

    public static int b(String string2, String string3, Throwable throwable) {
        return a.h(string2, string3, throwable);
    }

    public static int c(String string2, Throwable throwable) {
        return a.f(string2, throwable);
    }

    public static String d(Throwable throwable) {
        return a.k(throwable);
    }

    public static void e(Context context, String string2) {
        a.a(context, string2);
    }

    public static void f(boolean bl2) {
        b = bl2;
        c = bl2;
    }

    public static boolean g() {
        return b;
    }

    public static int h(String string2, String string3) {
        return a.b(string2, string3);
    }

    public static int i(String string2, String string3, Throwable throwable) {
        return a.g(string2, string3, throwable);
    }

    public static void j(Context context, String string2) {
        a.j(context, string2);
    }

    public static int k(String string2, String string3) {
        return a.e(string2, string3);
    }

    public static void l(Context context, String string2) {
        a.i(context, string2);
    }

    public static int m(String string2, String string3) {
        return a.d(string2, string3);
    }

    public static int n(String string2, String string3) {
        return a.c(string2, string3);
    }
}

