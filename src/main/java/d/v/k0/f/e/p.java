/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.a;

public abstract class p
extends a {
    public int b;
    public int c;
    public String d;
    private long e;

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c() {
        void var1_5;
        int n10 = this.c;
        if (n10 != 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            int n11 = this.c;
            long l12 = (l10 -= l11) - (l11 = (long)n11);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                return (boolean)var1_5;
            }
        }
        boolean bl2 = false;
        return (boolean)var1_5;
    }

    public void d(String string2) {
        this.d = string2;
    }

    public void e(int n10) {
        this.b = n10;
    }

    public void f(int n10) {
        this.c = n10;
    }

    public void g() {
        long l10;
        this.e = l10 = System.currentTimeMillis();
    }

    public abstract void h();
}

