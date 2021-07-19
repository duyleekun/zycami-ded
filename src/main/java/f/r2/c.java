/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.u;
import f.r2.d;
import f.r2.o;

public final class c
extends o {
    private final o a;
    private final double b;

    private c(o o10, double d10) {
        this.a = o10;
        this.b = d10;
    }

    public /* synthetic */ c(o o10, double d10, u u10) {
        this(o10, d10);
    }

    public double a() {
        double d10 = this.a.a();
        double d11 = this.b;
        return d.H(d10, d11);
    }

    public o e(double d10) {
        o o10 = this.a;
        d10 = d.I(this.b, d10);
        c c10 = new c(o10, d10, null);
        return c10;
    }

    public final double f() {
        return this.b;
    }

    public final o g() {
        return this.a;
    }
}

