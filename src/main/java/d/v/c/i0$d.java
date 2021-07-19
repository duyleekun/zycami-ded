/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public class i0$d
extends d {
    private static final String a = "res_preference";
    private static final String b = "key_copy_assets_ok";
    private static final String c = "key_assets_ok";
    private static final String d = "key_init_db_ok";
    private static final String e = "key_res_version";

    private i0$d() {
    }

    private static Context A() {
        return f.a().c();
    }

    public static boolean B() {
        return d.v.e.d.d(i0$d.A(), a, b, false);
    }

    public static boolean C() {
        return d.v.e.d.d(i0$d.A(), a, d, false);
    }

    public static int D() {
        return d.v.e.d.h(i0$d.A(), a, e, 0);
    }

    public static void E(boolean bl2) {
        d.v.e.d.s(i0$d.A(), a, c, bl2);
    }

    public static void F(boolean bl2) {
        d.v.e.d.s(i0$d.A(), a, b, bl2);
    }

    public static void G(boolean bl2) {
        d.v.e.d.s(i0$d.A(), a, d, bl2);
    }

    public static void H(int n10) {
        d.v.e.d.u(i0$d.A(), a, e, n10);
    }

    public static boolean z() {
        return d.v.e.d.d(i0$d.A(), a, c, false);
    }
}

