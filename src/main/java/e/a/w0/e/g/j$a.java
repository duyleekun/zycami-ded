/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.g.j;
import io.reactivex.exceptions.CompositeException;

public final class j$a
implements l0 {
    private final l0 a;
    public final /* synthetic */ j b;

    public j$a(j j10, l0 l02) {
        this.b = j10;
        this.a = l02;
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        object = ((j)object).b;
        CompositeException compositeException = null;
        try {
            object.accept(null, throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            compositeException = new CompositeException(throwableArray);
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
        object2 = ((j)object2).b;
        object2.accept(object, null);
        this.a.onSuccess(object);
    }
}

