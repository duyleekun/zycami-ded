/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.exceptions.CompositeException;
import k.d;
import k.f;
import k.r;

public final class b$a
implements b,
f {
    private final d a;
    private final g0 b;
    private volatile boolean c;
    public boolean d = false;

    public b$a(d d10, g0 g02) {
        this.a = d10;
        this.b = g02;
    }

    public void dispose() {
        this.c = true;
        this.a.cancel();
    }

    public boolean isDisposed() {
        return this.c;
    }

    public void onFailure(d object, Throwable throwable) {
        boolean bl2 = object.isCanceled();
        if (bl2) {
            return;
        }
        object = this.b;
        try {
            object.onError(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            e.a.a1.a.Y(compositeException);
        }
    }

    public void onResponse(d d10, r object) {
        block10: {
            int n10 = (int)(this.c ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = 1;
            g0 g02 = this.b;
            g02.onNext(object);
            boolean bl2 = this.c;
            if (bl2) break block10;
            this.d = n10;
            object = this.b;
            try {
                object.onComplete();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                boolean bl3 = this.d;
                if (bl3) {
                    e.a.a1.a.Y(throwable);
                    break block10;
                }
                bl3 = this.c;
                if (bl3) break block10;
                g02 = this.b;
                try {
                    g02.onError(throwable);
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    int n11 = 2;
                    Throwable[] throwableArray = new Throwable[n11];
                    throwableArray[0] = throwable;
                    throwableArray[n10] = throwable2;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    e.a.a1.a.Y(compositeException);
                }
            }
        }
    }
}

