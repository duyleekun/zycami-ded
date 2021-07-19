/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubscription
extends AtomicLong
implements e,
b {
    private static final long serialVersionUID = 7028635084060361255L;
    public final AtomicReference actual;
    public final AtomicReference resource;

    public AsyncSubscription() {
        AtomicReference atomicReference;
        this.resource = atomicReference = new AtomicReference();
        this.actual = atomicReference = new AtomicReference();
    }

    public AsyncSubscription(b b10) {
        this();
        this.resource.lazySet(b10);
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.actual.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean replaceResource(b b10) {
        return DisposableHelper.replace(this.resource, b10);
    }

    public void request(long l10) {
        SubscriptionHelper.deferredRequest(this.actual, this, l10);
    }

    public boolean setResource(b b10) {
        return DisposableHelper.set(this.resource, b10);
    }

    public void setSubscription(e e10) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, e10);
    }
}

