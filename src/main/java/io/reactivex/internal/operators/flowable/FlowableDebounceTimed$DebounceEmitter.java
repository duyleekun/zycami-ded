/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed$DebounceTimedSubscriber;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableDebounceTimed$DebounceEmitter
extends AtomicReference
implements Runnable,
b {
    private static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once;
    public final FlowableDebounceTimed$DebounceTimedSubscriber parent;
    public final Object value;

    public FlowableDebounceTimed$DebounceEmitter(Object object, long l10, FlowableDebounceTimed$DebounceTimedSubscriber debounceTimedSubscriber) {
        AtomicBoolean atomicBoolean;
        this.once = atomicBoolean = new AtomicBoolean();
        this.value = object;
        this.idx = l10;
        this.parent = debounceTimedSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        Serializable serializable = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (bl3) {
            serializable = this.parent;
            long l10 = this.idx;
            Object object = this.value;
            ((FlowableDebounceTimed$DebounceTimedSubscriber)serializable).emit(l10, object, this);
        }
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
        this.emit();
    }

    public void setResource(b b10) {
        DisposableHelper.replace(this, b10);
    }
}

