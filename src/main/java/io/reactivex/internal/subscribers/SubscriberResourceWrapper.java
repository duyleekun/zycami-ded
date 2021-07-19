/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.o;
import e.a.s0.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SubscriberResourceWrapper
extends AtomicReference
implements o,
b,
e {
    private static final long serialVersionUID = -8612022020200669122L;
    public final d downstream;
    public final AtomicReference upstream;

    public SubscriberResourceWrapper(d d10) {
        AtomicReference atomicReference;
        this.upstream = atomicReference = new AtomicReference();
        this.downstream = d10;
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.upstream.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this);
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(e object) {
        AtomicReference atomicReference = this.upstream;
        boolean bl2 = SubscriptionHelper.setOnce(atomicReference, (e)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            e e10 = (e)this.upstream.get();
            e10.request(l10);
        }
    }

    public void setResource(b b10) {
        DisposableHelper.set(this, b10);
    }
}

