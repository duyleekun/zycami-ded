/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.g.y;
import io.reactivex.exceptions.CompositeException;

public final class y$a
implements l0 {
    private final l0 a;
    public final /* synthetic */ y b;

    public y$a(y y10, l0 l02) {
        this.b = y10;
        this.a = l02;
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        Object object2 = ((y)object).b;
        if (object2 != null) {
            try {
                object = object2.apply(throwable);
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                object2 = this.a;
                Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
                CompositeException compositeException = new CompositeException(throwableArray);
                object2.onError(compositeException);
                return;
            }
        } else {
            object = ((y)object).c;
        }
        if (object == null) {
            object = new NullPointerException("Value supplied was null");
            ((Throwable)object).initCause(throwable);
            this.a.onError((Throwable)object);
            return;
        }
        this.a.onSuccess(object);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }

    public void onSuccess(Object object) {
        this.a.onSuccess(object);
    }
}

