/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.exceptions.CompositeException;
import k.r;
import retrofit2.adapter.rxjava2.HttpException;

public class a$a
implements g0 {
    private final g0 a;
    private boolean b;

    public a$a(g0 g02) {
        this.a = g02;
    }

    public void a(r object) {
        int n10 = (int)(((r)object).g() ? 1 : 0);
        if (n10 != 0) {
            g0 g02 = this.a;
            object = ((r)object).a();
            g02.onNext(object);
        } else {
            n10 = 1;
            this.b = n10;
            HttpException httpException = new HttpException((r)object);
            object = this.a;
            try {
                object.onError(httpException);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                int n11 = 2;
                Throwable[] throwableArray = new Throwable[n11];
                throwableArray[0] = httpException;
                throwableArray[n10] = throwable;
                CompositeException compositeException = new CompositeException(throwableArray);
                e.a.a1.a.Y(compositeException);
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.b;
        if (!bl2) {
            g0 g02 = this.a;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.b;
        if (!bl2) {
            g0 g02 = this.a;
            g02.onError(throwable);
        } else {
            String string2 = "This should never happen! Report as a bug with the full stacktrace.";
            AssertionError assertionError = new AssertionError((Object)string2);
            ((Throwable)((Object)assertionError)).initCause(throwable);
            e.a.a1.a.Y((Throwable)((Object)assertionError));
        }
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

