/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import d.k.a.a$a;
import e.a.g0;
import e.a.s0.b;

public final class a$d
implements g0 {
    private final g0 a;
    private final a$a b;

    public a$d(g0 g02, a$a a$a) {
        this.a = g02;
        this.b = a$a;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        boolean bl2;
        this.a.onSubscribe((b)object);
        Object object2 = this.b.b;
        if (object2 != null && !(bl2 = object.isDisposed())) {
            object = this.a;
            object.onNext(object2);
        }
    }
}

