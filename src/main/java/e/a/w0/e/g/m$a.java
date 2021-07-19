/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.g.m;
import io.reactivex.exceptions.CompositeException;

public final class m$a
implements l0 {
    public final l0 a;
    public final /* synthetic */ m b;

    public m$a(m m10, l0 l02) {
        this.b = m10;
        this.a = l02;
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        object = ((m)object).b;
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
        object2 = ((m)object2).b;
        object2.run();
        this.a.onSuccess(object);
    }
}

