/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.d$a;
import d.q.a.l;
import d.q.a.y;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.a;
import e.a.v0.g;
import e.a.z;
import io.reactivex.observers.TestObserver;

public class d$a$d
implements y {
    public final /* synthetic */ z a;
    public final /* synthetic */ d$a b;

    public d$a$d(d$a d$a, z z10) {
        this.b = d$a;
        this.a = z10;
    }

    public b a() {
        z z10 = this.a;
        e.a.g g10 = this.b.a;
        l l10 = new l(z10, g10);
        return l10.a();
    }

    public TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.subscribe(testObserver);
        return testObserver;
    }

    public b c(g g10, g g11) {
        z z10 = this.a;
        e.a.g g12 = this.b.a;
        l l10 = new l(z10, g12);
        return l10.c(g10, g11);
    }

    public b d(g g10) {
        z z10 = this.a;
        e.a.g g11 = this.b.a;
        l l10 = new l(z10, g11);
        return l10.d(g10);
    }

    public TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.dispose();
        }
        this.subscribe(testObserver);
        return testObserver;
    }

    public b f(g g10, g g11, a a10) {
        z z10 = this.a;
        e.a.g g12 = this.b.a;
        l l10 = new l(z10, g12);
        return l10.f(g10, g11, a10);
    }

    public b h(g g10, g g11, a a10, g g12) {
        z z10 = this.a;
        e.a.g g13 = this.b.a;
        l l10 = new l(z10, g13);
        return l10.h(g10, g11, a10, g12);
    }

    public g0 i(g0 g02) {
        z z10 = this.a;
        e.a.g g10 = this.b.a;
        l l10 = new l(z10, g10);
        return l10.i(g02);
    }

    public void subscribe(g0 g02) {
        z z10 = this.a;
        e.a.g g10 = this.b.a;
        l l10 = new l(z10, g10);
        l10.subscribe(g02);
    }
}

