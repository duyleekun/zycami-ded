/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.w.g$a;
import e.a.g0;
import e.a.s0.b;

public class g$a$a
implements g0 {
    public final /* synthetic */ g$a a;

    public g$a$a(g$a g$a) {
        this.a = g$a;
    }

    public void onComplete() {
        this.a.c.c.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.c.c.tryOnError(throwable);
    }

    public void onNext(Object object) {
        this.a.c.c.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.a.c.c.setDisposable(b10);
    }
}

