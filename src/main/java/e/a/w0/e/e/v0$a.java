/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class v0$a
implements g0,
b {
    public final l0 a;
    public final Object b;
    public b c;
    public Object d;

    public v0$a(l0 l02, Object object) {
        this.a = l02;
        this.b = object;
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }

    public boolean isDisposed() {
        boolean bl2;
        b b10 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 == disposableHelper) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.c = object;
        object = this.d;
        if (object != null) {
            this.d = null;
            l0 l02 = this.a;
            l02.onSuccess(object);
        } else {
            object = this.b;
            if (object != null) {
                l0 l03 = this.a;
                l03.onSuccess(object);
            } else {
                object = this.a;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            }
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.d = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.d = object;
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
}

