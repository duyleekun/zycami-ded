/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

public final class g0$a
implements t,
b {
    public final t a;
    public final o b;
    public b c;

    public g0$a(t t10, o o10) {
        this.a = t10;
        this.b = o10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        try {
            object3 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.a;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            object2.onError(compositeException);
            return;
        }
        object3 = object3.apply(object);
        object2 = "The valueSupplier returned a null value";
        object = e.a.w0.b.a.g(object3, (String)object2);
        this.a.onSuccess(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.a.onSuccess(object);
    }
}

