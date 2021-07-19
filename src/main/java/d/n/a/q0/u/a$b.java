/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import d.n.a.q0.u.a;
import d.n.a.q0.x.d;
import d.n.a.q0.x.x;
import e.a.g0;
import e.a.s0.b;

public class a$b
implements g0 {
    public final /* synthetic */ x a;
    public final /* synthetic */ a b;

    public a$b(a a10, x x10) {
        this.b = a10;
        this.a = x10;
    }

    public void a(d d10) {
    }

    public void onComplete() {
        x x10 = this.a;
        byte[] byArray = this.b.i;
        x10.onNext(byArray);
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
    }
}

