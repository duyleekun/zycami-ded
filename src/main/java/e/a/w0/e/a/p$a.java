/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class p$a
implements d,
b {
    public final d a;
    public b b;

    public p$a(d d10) {
        this.a = d10;
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
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
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

