/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d;
import d.q.a.d0;
import d.q.a.g;
import d.q.a.h;
import d.q.a.t;
import d.q.a.u;
import d.q.a.x;
import d.q.a.y;
import d.q.a.z;
import e.a.i0;
import e.a.j;
import e.a.q;
import e.a.z0.a;
import f.h2.t.f0;

public final class a0
implements g {
    private final e.a.a a;

    public a0(e.a.a a10) {
        f0.q(a10, "scope");
        this.a = a10;
    }

    public u a(j object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((j)object).r(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable(scope))");
        return (u)object;
    }

    public t b(e.a.a object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((e.a.a)object).s(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable<Any>(scope))");
        return (t)object;
    }

    public z c(a object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((a)object).b(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable(scope))");
        return (z)object;
    }

    public y d(e.a.z object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((e.a.z)object).q(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable(scope))");
        return (y)object;
    }

    public x e(q object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((q)object).n(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable(scope))");
        return (x)object;
    }

    public d0 f(i0 object) {
        f0.q(object, "$this$autoDispose");
        h h10 = d.b(this.a);
        object = ((i0)object).o(h10);
        f0.h(object, "this.`as`(AutoDispose.autoDisposable(scope))");
        return (d0)object;
    }
}

