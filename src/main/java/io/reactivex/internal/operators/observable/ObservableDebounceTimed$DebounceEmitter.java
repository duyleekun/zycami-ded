/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed$a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed$DebounceEmitter
extends AtomicReference
implements Runnable,
b {
    private static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once;
    public final ObservableDebounceTimed$a parent;
    public final Object value;

    public ObservableDebounceTimed$DebounceEmitter(Object object, long l10, ObservableDebounceTimed$a a10) {
        AtomicBoolean atomicBoolean;
        this.once = atomicBoolean = new AtomicBoolean();
        this.value = object;
        this.idx = l10;
        this.parent = a10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void run() {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.parent;
            long l10 = this.idx;
            Object object2 = this.value;
            ((ObservableDebounceTimed$a)object).a(l10, object2, this);
        }
    }

    public void setResource(b b10) {
        DisposableHelper.replace(this, b10);
    }
}

