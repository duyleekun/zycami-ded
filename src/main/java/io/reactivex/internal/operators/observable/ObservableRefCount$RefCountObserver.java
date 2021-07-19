/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableRefCount$RefCountObserver
extends AtomicBoolean
implements g0,
b {
    private static final long serialVersionUID = -7419642935409022375L;
    public final ObservableRefCount$RefConnection connection;
    public final g0 downstream;
    public final ObservableRefCount parent;
    public b upstream;

    public ObservableRefCount$RefCountObserver(g0 g02, ObservableRefCount observableRefCount, ObservableRefCount$RefConnection observableRefCount$RefConnection) {
        this.downstream = g02;
        this.parent = observableRefCount;
        this.connection = observableRefCount$RefConnection;
    }

    public void dispose() {
        this.upstream.dispose();
        ObservableRefCount observableRefCount = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            observableRefCount = this.parent;
            ObservableRefCount$RefConnection observableRefCount$RefConnection = this.connection;
            observableRefCount.h8(observableRefCount$RefConnection);
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        Object object = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            object = this.parent;
            ObservableRefCount$RefConnection observableRefCount$RefConnection = this.connection;
            ((ObservableRefCount)object).k8(observableRefCount$RefConnection);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            object = this.parent;
            ObservableRefCount$RefConnection observableRefCount$RefConnection = this.connection;
            ((ObservableRefCount)object).k8(observableRefCount$RefConnection);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

