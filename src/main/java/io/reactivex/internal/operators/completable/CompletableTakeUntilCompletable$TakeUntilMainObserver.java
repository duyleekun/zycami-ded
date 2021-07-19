/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable$TakeUntilMainObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = 3533011714830024923L;
    public final d downstream;
    public final AtomicBoolean once;
    public final CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver other;

    public CompletableTakeUntilCompletable$TakeUntilMainObserver(d object) {
        this.downstream = object;
        super(this);
        this.other = object;
        this.once = object = new AtomicBoolean();
    }

    public void dispose() {
        Serializable serializable = this.once;
        boolean bl2 = true;
        boolean bl3 = serializable.compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this);
            serializable = this.other;
            DisposableHelper.dispose((AtomicReference)serializable);
        }
    }

    public void innerComplete() {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void innerError(Throwable throwable) {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public boolean isDisposed() {
        return this.once.get();
    }

    public void onComplete() {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this.other);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this.other);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

