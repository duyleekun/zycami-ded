/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

public final class c1$a
implements g0,
b {
    public final g0 a;
    public final o b;
    public b c;

    public c1$a(g0 g02, o o10) {
        this.a = g02;
        this.b = o10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        block3: {
            try {
                object = this.b;
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                g0 g02 = this.a;
                Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
                CompositeException compositeException = new CompositeException(throwableArray);
                g02.onError(compositeException);
                return;
            }
            object = object.apply(throwable);
            if (object != null) break block3;
            object = new NullPointerException("The supplied value is null");
            ((Throwable)object).initCause(throwable);
            this.a.onError((Throwable)object);
            return;
        }
        this.a.onNext(object);
        this.a.onComplete();
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

