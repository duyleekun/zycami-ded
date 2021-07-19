/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d$a;
import d.q.a.d0;
import d.q.a.o;
import e.a.i0;
import e.a.l0;
import e.a.v0.b;
import e.a.v0.g;
import io.reactivex.observers.TestObserver;

public class d$a$e
implements d0 {
    public final /* synthetic */ i0 a;
    public final /* synthetic */ d$a b;

    public d$a$e(d$a d$a, i0 i02) {
        this.b = d$a;
        this.a = i02;
    }

    public e.a.s0.b a() {
        i0 i02 = this.a;
        e.a.g g10 = this.b.a;
        o o10 = new o(i02, g10);
        return o10.a();
    }

    public TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.f(testObserver);
        return testObserver;
    }

    public e.a.s0.b c(g g10, g g11) {
        i0 i02 = this.a;
        e.a.g g12 = this.b.a;
        o o10 = new o(i02, g12);
        return o10.c(g10, g11);
    }

    public e.a.s0.b d(g g10) {
        i0 i02 = this.a;
        e.a.g g11 = this.b.a;
        o o10 = new o(i02, g11);
        return o10.d(g10);
    }

    public TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.dispose();
        }
        this.f(testObserver);
        return testObserver;
    }

    public void f(l0 l02) {
        i0 i02 = this.a;
        e.a.g g10 = this.b.a;
        o o10 = new o(i02, g10);
        o10.f(l02);
    }

    public e.a.s0.b g(b b10) {
        i0 i02 = this.a;
        e.a.g g10 = this.b.a;
        o o10 = new o(i02, g10);
        return o10.g(b10);
    }

    public l0 h(l0 l02) {
        i0 i02 = this.a;
        e.a.g g10 = this.b.a;
        o o10 = new o(i02, g10);
        return o10.h(l02);
    }
}

