/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.l;
import e.a.v0.f;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableCreate$SerializedEmitter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FlowableCreate$BaseEmitter
extends AtomicLong
implements l,
e {
    private static final long serialVersionUID = 7326289992464377023L;
    public final d downstream;
    public final SequentialDisposable serial;

    public FlowableCreate$BaseEmitter(d object) {
        this.downstream = object;
        this.serial = object = new SequentialDisposable();
    }

    public final void cancel() {
        this.serial.dispose();
        this.onUnsubscribed();
    }

    public void complete() {
        boolean bl2 = this.isCancelled();
        if (bl2) {
            return;
        }
        try {
            d d10 = this.downstream;
            d10.onComplete();
            return;
        }
        finally {
            this.serial.dispose();
        }
    }

    public boolean error(Throwable throwable) {
        boolean bl2;
        Object object;
        if (throwable == null) {
            object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
            throwable = new NullPointerException((String)object);
        }
        if (bl2 = this.isCancelled()) {
            return false;
        }
        try {
            object = this.downstream;
            object.onError(throwable);
            return true;
        }
        finally {
            this.serial.dispose();
        }
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    public void onComplete() {
        this.complete();
    }

    public final void onError(Throwable throwable) {
        boolean bl2 = this.tryOnError(throwable);
        if (!bl2) {
            a.Y(throwable);
        }
    }

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public final void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.a(this, l10);
            this.onRequested();
        }
    }

    public final long requested() {
        return this.get();
    }

    public final l serialize() {
        FlowableCreate$SerializedEmitter flowableCreate$SerializedEmitter = new FlowableCreate$SerializedEmitter(this);
        return flowableCreate$SerializedEmitter;
    }

    public final void setCancellable(f f10) {
        CancellableDisposable cancellableDisposable = new CancellableDisposable(f10);
        this.setDisposable(cancellableDisposable);
    }

    public final void setDisposable(e.a.s0.b b10) {
        this.serial.update(b10);
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        String string2 = this.getClass().getSimpleName();
        objectArray[0] = string2;
        string2 = super.toString();
        objectArray[1] = string2;
        return String.format("%s{%s}", objectArray);
    }

    public boolean tryOnError(Throwable throwable) {
        return this.error(throwable);
    }
}

