/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.exceptions.CompositeException;
import k.r;
import k.x.a.d;

public class e$a
implements g0 {
    private final g0 a;

    public e$a(g0 g02) {
        this.a = g02;
    }

    public void a(r object) {
        g0 g02 = this.a;
        object = d.e((r)object);
        g02.onNext(object);
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable object) {
        g0 g02;
        try {
            g02 = this.a;
        }
        catch (Throwable throwable) {
            g02 = this.a;
            try {
                g02.onError(throwable);
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
            return;
        }
        object = d.b((Throwable)object);
        g02.onNext(object);
        this.a.onComplete();
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

