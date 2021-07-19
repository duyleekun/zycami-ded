/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.s0.b;
import e.a.t;
import e.a.t0.a;
import e.a.v0.r;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

public final class f0$a
implements t,
b {
    public final t a;
    public final r b;
    public b c;

    public f0$a(t t10, r r10) {
        this.a = t10;
        this.b = r10;
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
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            t t10 = this.a;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            t10.onError(compositeException);
            return;
        }
        boolean bl2 = object2.test(object);
        if (bl2) {
            object = this.a;
            object.onComplete();
        } else {
            object2 = this.a;
            object2.onError((Throwable)object);
        }
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

