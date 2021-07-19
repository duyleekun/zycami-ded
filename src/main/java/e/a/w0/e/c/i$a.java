/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.s0.b;
import e.a.t;
import e.a.t0.a;
import e.a.w0.e.c.i;
import io.reactivex.exceptions.CompositeException;

public final class i$a
implements t {
    public final t a;
    public final /* synthetic */ i b;

    public i$a(i i10, t t10) {
        this.b = i10;
        this.a = t10;
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
        object = ((i)object).b;
        object.run();
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        object = ((i)object).b;
        try {
            object.run();
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

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object2 = ((i)object2).b;
        object2.run();
        this.a.onSuccess(object);
    }
}

