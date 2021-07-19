/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import e.a.g0;
import e.a.s0.b;
import i.g.d;
import i.g.e;

public final class a$a
implements g0,
d {
    private final Object a;
    public volatile Object b;

    public a$a(Object object) {
        this.a = object;
        this.b = object;
    }

    public void onComplete() {
        Object object;
        this.b = object = this.a;
    }

    public void onError(Throwable object) {
        this.b = object = this.a;
    }

    public void onNext(Object object) {
        this.b = object;
    }

    public void onSubscribe(b b10) {
    }

    public void onSubscribe(e e10) {
    }
}

