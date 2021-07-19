/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.g.i;
import io.reactivex.exceptions.CompositeException;

public final class i$a
implements l0 {
    private final l0 a;
    public final /* synthetic */ i b;

    public i$a(i i10, l0 l02) {
        this.b = i10;
        this.a = l02;
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        object = ((i)object).b;
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

    public void onSuccess(Object object) {
        this.a.onSuccess(object);
    }
}

