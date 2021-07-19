/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import d.v.c.i1.j2;

public class k2 {
    private static volatile k2 a;

    private k2() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k2 e() {
        Object object = a;
        if (object != null) return a;
        object = k2.class;
        synchronized (object) {
            k2 k22 = a;
            if (k22 != null) return a;
            a = k22 = new k2();
            return a;
        }
    }

    public boolean a() {
        return j2.z();
    }

    public boolean b() {
        return j2.A();
    }

    public boolean c() {
        return j2.B();
    }

    public boolean d() {
        return j2.D();
    }

    public boolean f() {
        return j2.E();
    }

    public boolean g() {
        return j2.F();
    }

    public boolean h() {
        return j2.G();
    }

    public void i(boolean bl2) {
        j2.H(bl2);
    }

    public void j(boolean bl2) {
        j2.I(bl2);
    }

    public void k(boolean bl2) {
        j2.J(bl2);
    }

    public void l(boolean bl2) {
        j2.K(bl2);
    }

    public void m(boolean bl2) {
        j2.L(bl2);
    }

    public void n(boolean bl2) {
        j2.M(bl2);
    }

    public void o(boolean bl2) {
        j2.N(bl2);
    }
}

