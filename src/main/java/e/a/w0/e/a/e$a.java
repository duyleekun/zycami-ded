/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.a.e;
import io.reactivex.exceptions.CompositeException;

public final class e$a
implements d {
    private final d a;
    public final /* synthetic */ e b;

    public e$a(e e10, d d10) {
        this.b = e10;
        this.a = d10;
    }

    public void onComplete() {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object = ((e)object).b;
        object.accept(null);
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        object = ((e)object).b;
        try {
            object.accept(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            throwable = compositeException;
        }
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

