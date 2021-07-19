/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.b0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate$SerializedEmitter;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCreate$CreateEmitter
extends AtomicReference
implements b0,
b {
    private static final long serialVersionUID = -3434801548987643227L;
    public final g0 observer;

    public ObservableCreate$CreateEmitter(g0 g02) {
        this.observer = g02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            try {
                g0 g02 = this.observer;
                g02.onComplete();
            }
            finally {
                this.dispose();
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.tryOnError(throwable);
        if (!bl2) {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)object);
            return;
        }
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            g0 g02 = this.observer;
            g02.onNext(object);
        }
    }

    public b0 serialize() {
        ObservableCreate$SerializedEmitter observableCreate$SerializedEmitter = new ObservableCreate$SerializedEmitter(this);
        return observableCreate$SerializedEmitter;
    }

    public void setCancellable(f f10) {
        CancellableDisposable cancellableDisposable = new CancellableDisposable(f10);
        this.setDisposable(cancellableDisposable);
    }

    public void setDisposable(b b10) {
        DisposableHelper.set(this, b10);
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        String string2 = ObservableCreate$CreateEmitter.class.getSimpleName();
        objectArray[0] = string2;
        string2 = super.toString();
        objectArray[1] = string2;
        return String.format("%s{%s}", objectArray);
    }

    public boolean tryOnError(Throwable throwable) {
        boolean bl2;
        Object object;
        if (throwable == null) {
            object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
            throwable = new NullPointerException((String)object);
        }
        if (!(bl2 = this.isDisposed())) {
            try {
                object = this.observer;
                object.onError(throwable);
                return true;
            }
            finally {
                this.dispose();
            }
        }
        return false;
    }
}

