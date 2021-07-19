/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0;

import d.v.h0.b;
import d.v.h0.g;
import d.v.h0.i;
import d.v.k0.f.d.a;
import d.v.k0.g.d;
import e.a.g0;

public class i$b
implements g0 {
    public final /* synthetic */ i a;

    public i$b(i i10) {
        this.a = i10;
    }

    private /* synthetic */ void a(Throwable throwable) {
        g g10 = i.b(this.a);
        d.h("socket push error", throwable, -1, g10);
    }

    public /* synthetic */ void b(Throwable throwable) {
        this.a(throwable);
    }

    public void c(a a10) {
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.a.w();
        b b10 = new b(this, throwable);
        d.i(b10);
    }

    public void onSubscribe(e.a.s0.b b10) {
        i.c(this.a).b(b10);
    }
}

