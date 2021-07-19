/*
 * Decompiled with CFR 0.151.
 */
package e.a.s0;

import e.a.s0.b;
import e.a.s0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class d
implements b {
    public final AtomicReference a;

    public d() {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
    }

    public d(b b10) {
        AtomicReference<b> atomicReference;
        this.a = atomicReference = new AtomicReference<b>(b10);
    }

    public b a() {
        DisposableHelper disposableHelper;
        b b10 = (b)this.a.get();
        if (b10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            b10 = c.a();
        }
        return b10;
    }

    public boolean b(b b10) {
        return DisposableHelper.replace(this.a, b10);
    }

    public boolean c(b b10) {
        return DisposableHelper.set(this.a, b10);
    }

    public void dispose() {
        DisposableHelper.dispose(this.a);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.a.get());
    }
}

