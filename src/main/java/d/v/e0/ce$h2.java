/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.e;
import e.a.g0;
import e.a.s0.b;

public class ce$h2
implements g0 {
    public final /* synthetic */ e a;
    public final /* synthetic */ ce b;

    public ce$h2(ce ce2, e e10) {
        this.b = ce2;
        this.a = e10;
    }

    public void a(Boolean bl2) {
    }

    public void onComplete() {
        Object object = this.b;
        boolean bl2 = ce.a((ce)object);
        if (bl2) {
            object = this.a;
            object.l();
        } else {
            object = this.a;
            object.o();
        }
        ce.b(this.b, true);
    }

    public void onError(Throwable throwable) {
        ce.b(this.b, true);
        this.a.onFailed(throwable);
    }

    public void onSubscribe(b b10) {
        ce.u(this.b).f("move", b10);
        this.a.k();
    }
}

