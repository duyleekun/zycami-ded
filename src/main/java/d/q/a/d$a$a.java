/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d$a;
import d.q.a.f;
import d.q.a.t;
import e.a.d;
import e.a.s0.b;
import e.a.v0.a;
import e.a.v0.g;
import io.reactivex.observers.TestObserver;

public class d$a$a
implements t {
    public final /* synthetic */ e.a.a a;
    public final /* synthetic */ d$a b;

    public d$a$a(d$a d$a, e.a.a a10) {
        this.b = d$a;
        this.a = a10;
    }

    public b a() {
        e.a.a a10 = this.a;
        e.a.g g10 = this.b.a;
        f f10 = new f(a10, g10);
        return f10.a();
    }

    public TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.f(testObserver);
        return testObserver;
    }

    public TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.cancel();
        }
        this.f(testObserver);
        return testObserver;
    }

    public void f(d d10) {
        e.a.a a10 = this.a;
        e.a.g g10 = this.b.a;
        f f10 = new f(a10, g10);
        f10.f(d10);
    }

    public d g(d d10) {
        e.a.a a10 = this.a;
        e.a.g g10 = this.b.a;
        f f10 = new f(a10, g10);
        return f10.g(d10);
    }

    public b h(a a10, g g10) {
        e.a.a a11 = this.a;
        e.a.g g11 = this.b.a;
        f f10 = new f(a11, g11);
        return f10.h(a10, g10);
    }

    public b k(a a10) {
        e.a.a a11 = this.a;
        e.a.g g10 = this.b.a;
        f f10 = new f(a11, g10);
        return f10.k(a10);
    }
}

