/*
 * Decompiled with CFR 0.151.
 */
package e.a.y0;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d
implements g0,
b {
    public final AtomicReference a;

    public d() {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
    }

    public void a() {
    }

    public final void dispose() {
        DisposableHelper.dispose(this.a);
    }

    public final boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.a.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public final void onSubscribe(b b10) {
        AtomicReference atomicReference = this.a;
        Class<?> clazz = this.getClass();
        boolean bl2 = f.c(atomicReference, b10, clazz);
        if (bl2) {
            this.a();
        }
    }
}

