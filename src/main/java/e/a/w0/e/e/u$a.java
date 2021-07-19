/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.u;
import e.a.w0.e.e.u$a$a;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class u$a
implements g0 {
    public final SequentialDisposable a;
    public final g0 b;
    public boolean c;
    public final /* synthetic */ u d;

    public u$a(u u10, SequentialDisposable sequentialDisposable, g0 g02) {
        this.d = u10;
        this.a = sequentialDisposable;
        this.b = g02;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        e0 e02 = this.d.a;
        u$a$a u$a$a = new u$a$a(this);
        e02.subscribe(u$a$a);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        this.onComplete();
    }

    public void onSubscribe(b b10) {
        this.a.update(b10);
    }
}

