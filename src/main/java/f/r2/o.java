/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.r2.c;
import f.r2.d;

public abstract class o {
    public abstract double a();

    public final boolean b() {
        return d.F(this.a());
    }

    public final boolean c() {
        return d.F(this.a()) ^ true;
    }

    public o d(double d10) {
        d10 = d.a0(d10);
        return this.e(d10);
    }

    public o e(double d10) {
        c c10 = new c(this, d10, null);
        return c10;
    }
}

