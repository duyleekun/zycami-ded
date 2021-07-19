/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.g;
import e.a.v0.q;
import e.a.w0.b.a;
import e.a.w0.e.f.i$a;
import i.g.d;

public final class i
extends e.a.z0.a {
    public final e.a.z0.a a;
    public final g b;
    public final g c;
    public final g d;
    public final e.a.v0.a e;
    public final e.a.v0.a f;
    public final g g;
    public final q h;
    public final e.a.v0.a i;

    public i(e.a.z0.a object, g g10, g g11, g g12, e.a.v0.a a10, e.a.v0.a a11, g g13, q q10, e.a.v0.a a12) {
        this.a = object;
        this.b = object = (g)e.a.w0.b.a.g(g10, "onNext is null");
        this.c = object = (g)e.a.w0.b.a.g(g11, "onAfterNext is null");
        this.d = object = (g)e.a.w0.b.a.g(g12, "onError is null");
        this.e = object = (e.a.v0.a)e.a.w0.b.a.g(a10, "onComplete is null");
        this.f = object = (e.a.v0.a)e.a.w0.b.a.g(a11, "onAfterTerminated is null");
        this.g = object = (g)e.a.w0.b.a.g(g13, "onSubscribe is null");
        this.h = object = (q)e.a.w0.b.a.g(q10, "onRequest is null");
        this.i = object = (e.a.v0.a)e.a.w0.b.a.g(a12, "onCancel is null");
    }

    public int G() {
        return this.a.G();
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        d[] dArray2 = new d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            d d10 = dArray[i10];
            i$a i$a = new i$a(d10, this);
            dArray2[i10] = i$a;
        }
        this.a.a(dArray2);
    }
}

