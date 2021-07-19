/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.b0.i;

import android.content.Context;
import d.v.b0.i.b;
import d.v.b0.i.b$a0;
import d.v.b0.i.b$b0;
import d.v.b0.i.b$c0;
import d.v.b0.i.b$z;

public class b$x {
    private boolean a = false;
    private int b = 4;
    private int c;
    private Context d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private b$z o;
    private b$a0 p;
    private b$c0 q;
    private b$b0 r;
    private boolean s;
    private boolean t;

    public b$x(Context context) {
        int n10;
        this.c = n10 = 1;
        this.e = 0;
        this.f = 0;
        this.g = 270;
        this.h = -1;
        this.i = n10;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = n10;
        this.d = context = context.getApplicationContext();
    }

    public b a() {
        Object object = this.d;
        boolean bl2 = this.a;
        b b10 = new b((Context)object, bl2, null);
        int bl3 = this.b;
        d.v.b0.i.b.y0(b10, bl3);
        int n10 = this.c;
        d.v.b0.i.b.z0(b10, n10);
        int n11 = this.e;
        d.v.b0.i.b.A0(b10, n11);
        int n12 = this.f;
        d.v.b0.i.b.B0(b10, n12);
        int n13 = this.g;
        d.v.b0.i.b.i0(b10, n13);
        int n14 = this.h;
        d.v.b0.i.b.C0(b10, n14);
        boolean bl4 = this.i;
        d.v.b0.i.b.D0(b10, bl4);
        boolean bl5 = this.m;
        d.v.b0.i.b.E0(b10, bl5);
        boolean bl6 = this.j;
        d.v.b0.i.b.F0(b10, bl6);
        boolean bl7 = this.k;
        d.v.b0.i.b.G0(b10, bl7);
        boolean bl8 = this.l;
        d.v.b0.i.b.I0(b10, bl8);
        int n15 = this.n;
        d.v.b0.i.b.h0(b10, n15);
        object = this.p;
        d.v.b0.i.b.J0(b10, (b$a0)object);
        object = this.q;
        d.v.b0.i.b.K0(b10, (b$c0)object);
        object = this.r;
        d.v.b0.i.b.L0(b10, (b$b0)object);
        object = this.o;
        d.v.b0.i.b.N0(b10, (b$z)object);
        boolean bl9 = this.s;
        d.v.b0.i.b.O0(b10, bl9);
        boolean bl10 = this.t;
        d.v.b0.i.b.P0(b10, bl10);
        return b10;
    }

    public b$x b(boolean bl2) {
        this.a = bl2;
        return this;
    }

    public b$x c(int n10) {
        this.f = n10;
        return this;
    }

    public b$x d(int n10) {
        this.g = n10;
        return this;
    }

    public b$x e(int n10) {
        this.e = n10;
        return this;
    }

    public b$x f(int n10) {
        this.b = n10;
        return this;
    }

    public b$x g(int n10) {
        this.c = n10;
        return this;
    }

    public b$x h(int n10) {
        this.n = n10;
        return this;
    }

    public b$x i(int n10) {
        this.h = n10;
        return this;
    }

    public b$x j(boolean bl2) {
        this.s = bl2;
        return this;
    }

    public b$x k(boolean bl2) {
        this.t = bl2;
        return this;
    }

    public b$x l(boolean bl2) {
        this.j = bl2;
        return this;
    }

    public b$x m(boolean bl2) {
        this.k = bl2;
        return this;
    }

    public b$x n(boolean bl2) {
        this.m = bl2;
        return this;
    }

    public b$x o(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public b$x p(boolean bl2) {
        this.l = bl2;
        return this;
    }

    public b$x q(b$z b$z) {
        this.o = b$z;
        return this;
    }

    public b$x r(b$a0 b$a0) {
        this.p = b$a0;
        return this;
    }

    public b$x s(b$b0 b$b0) {
        this.r = b$b0;
        return this;
    }

    public b$x t(b$c0 b$c0) {
        this.q = b$c0;
        return this;
    }
}

