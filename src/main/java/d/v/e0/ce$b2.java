/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.e;
import e.a.g0;
import e.a.s0.b;

public class ce$b2
implements g0 {
    public final /* synthetic */ e a;
    public final /* synthetic */ ce b;

    public ce$b2(ce ce2, e e10) {
        this.b = ce2;
        this.a = e10;
    }

    public void a(Boolean bl2) {
        this.a.e();
    }

    public void onComplete() {
        this.a.o();
    }

    public void onError(Throwable throwable) {
        this.a.onFailed(throwable);
    }

    public void onSubscribe(b b10) {
        ce.u(this.b).f("story_moving", b10);
        this.a.k();
    }
}

