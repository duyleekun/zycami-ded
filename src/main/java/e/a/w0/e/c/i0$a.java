/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.l0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class i0$a
implements t,
b {
    public final l0 a;
    public final Object b;
    public b c;

    public i0$a(l0 l02, Object object) {
        this.a = l02;
        this.b = object;
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.c = object;
        object = this.b;
        if (object != null) {
            l0 l02 = this.a;
            l02.onSuccess(object);
        } else {
            object = this.a;
            String string2 = "The MaybeSource is empty";
            NoSuchElementException noSuchElementException = new NoSuchElementException(string2);
            object.onError(noSuchElementException);
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.onError(throwable);
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
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.onSuccess(object);
    }
}

