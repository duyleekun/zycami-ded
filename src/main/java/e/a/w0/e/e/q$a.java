/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class q$a
implements g0,
b {
    public final l0 a;
    public b b;
    public long c;

    public q$a(l0 l02) {
        this.a = l02;
    }

    public void dispose() {
        this.b.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.b = object;
        object = this.a;
        Long l10 = this.c;
        object.onSuccess(l10);
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.b = disposableHelper;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        long l10;
        this.c = l10 = this.c + 1L;
    }

    public void onSubscribe(b object) {
        b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

