/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d$a;
import d.q.a.k;
import d.q.a.x;
import e.a.q;
import e.a.s0.b;
import e.a.t;
import e.a.v0.a;
import e.a.v0.g;
import io.reactivex.observers.TestObserver;

public class d$a$c
implements x {
    public final /* synthetic */ q a;
    public final /* synthetic */ d$a b;

    public d$a$c(d$a d$a, q q10) {
        this.b = d$a;
        this.a = q10;
    }

    public b a() {
        q q10 = this.a;
        e.a.g g10 = this.b.a;
        k k10 = new k(q10, g10);
        return k10.a();
    }

    public TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.g(testObserver);
        return testObserver;
    }

    public b c(g g10, g g11) {
        q q10 = this.a;
        e.a.g g12 = this.b.a;
        k k10 = new k(q10, g12);
        return k10.c(g10, g11);
    }

    public b d(g g10) {
        q q10 = this.a;
        e.a.g g11 = this.b.a;
        k k10 = new k(q10, g11);
        return k10.d(g10);
    }

    public TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.cancel();
        }
        this.g(testObserver);
        return testObserver;
    }

    public b f(g g10, g g11, a a10) {
        q q10 = this.a;
        e.a.g g12 = this.b.a;
        k k10 = new k(q10, g12);
        return k10.f(g10, g11, a10);
    }

    public void g(t t10) {
        q q10 = this.a;
        e.a.g g10 = this.b.a;
        k k10 = new k(q10, g10);
        k10.g(t10);
    }

    public t h(t t10) {
        q q10 = this.a;
        e.a.g g10 = this.b.a;
        k k10 = new k(q10, g10);
        return k10.h(t10);
    }
}

