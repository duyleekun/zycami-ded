/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.b;
import e.a.w0.e.b.j1$c;

public final class j1$b
extends b {
    public final j1$c b;

    public j1$b(j1$c j1$c) {
        this.b = j1$c;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.m(throwable);
    }

    public void onNext(Object object) {
        this.b.o(object);
    }
}

