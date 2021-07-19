/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class p1$a
implements g0 {
    public final g0 a;
    public final e0 b;
    public final SequentialDisposable c;
    public boolean d;

    public p1$a(g0 object, e0 e02) {
        this.a = object;
        this.b = e02;
        this.d = true;
        this.c = object = new SequentialDisposable();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            bl2 = false;
            this.d = false;
            e0 e02 = this.b;
            e02.subscribe(this);
        } else {
            g0 g02 = this.a;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (bl2) {
            bl2 = false;
            this.d = false;
        }
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.c.update(b10);
    }
}

