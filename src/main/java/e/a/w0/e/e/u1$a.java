/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.c1.d;
import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

public final class u1$a
implements g0,
b {
    public final g0 a;
    public final TimeUnit b;
    public final h0 c;
    public long d;
    public b e;

    public u1$a(g0 g02, TimeUnit timeUnit, h0 h02) {
        this.a = g02;
        this.c = h02;
        this.b = timeUnit;
    }

    public void dispose() {
        this.e.dispose();
    }

    public boolean isDisposed() {
        return this.e.isDisposed();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        h0 h02 = this.c;
        TimeUnit timeUnit = this.b;
        long l10 = h02.d(timeUnit);
        long l11 = this.d;
        this.d = l10;
        g0 g02 = this.a;
        TimeUnit timeUnit2 = this.b;
        d d10 = new d(object, l10 -= l11, timeUnit2);
        g02.onNext(d10);
    }

    public void onSubscribe(b object) {
        Object object2 = this.e;
        boolean bl2 = DisposableHelper.validate(object2, (b)object);
        if (bl2) {
            long l10;
            this.e = object;
            object = this.c;
            object2 = this.b;
            this.d = l10 = ((h0)object).d((TimeUnit)((Object)object2));
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

