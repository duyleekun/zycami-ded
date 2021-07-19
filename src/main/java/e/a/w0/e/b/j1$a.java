/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.e1.b;
import e.a.w0.e.b.j1$c;
import io.reactivex.processors.UnicastProcessor;

public final class j1$a
extends b {
    public final j1$c b;
    public final UnicastProcessor c;
    public boolean d;

    public j1$a(j1$c c10, UnicastProcessor unicastProcessor) {
        this.b = c10;
        this.c = unicastProcessor;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.b.k(this);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.b.m(throwable);
    }

    public void onNext(Object object) {
        this.a();
        this.onComplete();
    }
}

