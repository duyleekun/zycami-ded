/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class b1$a
implements g0 {
    public final g0 a;
    public final o b;
    public final boolean c;
    public final SequentialDisposable d;
    public boolean e;
    public boolean f;

    public b1$a(g0 object, o o10, boolean bl2) {
        this.a = object;
        this.b = o10;
        this.c = bl2;
        this.d = object = new SequentialDisposable();
    }

    public void onComplete() {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        this.f = bl2 = true;
        this.e = bl2;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        block7: {
            int n10 = (int)(this.e ? 1 : 0);
            if (n10 != 0) {
                n10 = this.f;
                if (n10 != 0) {
                    e.a.a1.a.Y(throwable);
                    return;
                }
                this.a.onError(throwable);
                return;
            }
            n10 = 1;
            this.e = n10;
            boolean bl2 = this.c;
            if (bl2 && !(bl2 = throwable instanceof Exception)) {
                this.a.onError(throwable);
                return;
            }
            try {
                object = this.b;
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                g0 g02 = this.a;
                Throwable[] throwableArray = new Throwable[2];
                throwableArray[0] = throwable;
                throwableArray[n10] = throwable2;
                CompositeException compositeException = new CompositeException(throwableArray);
                g02.onError(compositeException);
                return;
            }
            object = object.apply(throwable);
            object = (e0)object;
            if (object != null) break block7;
            NullPointerException nullPointerException = new NullPointerException("Observable is null");
            nullPointerException.initCause(throwable);
            this.a.onError(nullPointerException);
            return;
        }
        object.subscribe(this);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.d.replace(b10);
    }
}

