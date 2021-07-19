/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import e.a.v0.g;

public final class n {
    private static volatile g a;
    public static volatile boolean b = false;
    public static volatile boolean c = true;
    public static volatile boolean d;

    private n() {
    }

    public static boolean a() {
        return b;
    }

    public static boolean b() {
        return c;
    }

    public static g c() {
        return a;
    }

    public static boolean d() {
        return d;
    }

    public static void e() {
        d = true;
    }

    public static void f() {
        n.i(null);
    }

    public static void g(boolean bl2) {
        boolean bl3 = d;
        if (!bl3) {
            b = bl2;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Plugins can't be changed anymore");
        throw illegalStateException;
    }

    public static void h(boolean bl2) {
        boolean bl3 = d;
        if (!bl3) {
            c = bl2;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Plugins can't be changed anymore");
        throw illegalStateException;
    }

    public static void i(g object) {
        boolean bl2 = d;
        if (!bl2) {
            a = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }
}

