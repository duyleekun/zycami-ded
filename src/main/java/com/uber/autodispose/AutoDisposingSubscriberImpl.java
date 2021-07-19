/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.AtomicThrowable;
import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingSubscriberImpl$a;
import com.uber.autodispose.AutoSubscriptionHelper;
import d.q.a.i;
import d.q.a.v;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import i.g.e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class AutoDisposingSubscriberImpl
extends AtomicInteger
implements d.q.a.i0.e {
    private final i.g.d delegate;
    private final AtomicThrowable error;
    public final AtomicReference mainSubscription;
    private final AtomicReference ref;
    private final AtomicLong requested;
    private final g scope;
    public final AtomicReference scopeDisposable;

    public AutoDisposingSubscriberImpl(g g10, i.g.d d10) {
        Serializable serializable;
        this.mainSubscription = serializable = new AtomicReference();
        this.scopeDisposable = serializable = new AtomicReference();
        this.error = serializable = new AtomicThrowable();
        this.ref = serializable;
        super();
        this.requested = serializable;
        this.scope = g10;
        this.delegate = d10;
    }

    public void cancel() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoSubscriptionHelper.cancel(this.mainSubscription);
    }

    public i.g.d delegateSubscriber() {
        return this.delegate;
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        boolean bl2;
        AutoSubscriptionHelper autoSubscriptionHelper;
        Object v10 = this.mainSubscription.get();
        if (v10 == (autoSubscriptionHelper = AutoSubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.mainSubscription;
            Object object2 = AutoSubscriptionHelper.CANCELLED;
            ((AtomicReference)object).lazySet(object2);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            object = this.delegate;
            object2 = this.error;
            v.b((i.g.d)object, this, (AtomicThrowable)object2);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.mainSubscription;
            Object object2 = AutoSubscriptionHelper.CANCELLED;
            ((AtomicReference)object).lazySet(object2);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            object = this.delegate;
            object2 = this.error;
            v.d((i.g.d)object, throwable, this, (AtomicThrowable)object2);
        }
    }

    public void onNext(Object object) {
        AtomicThrowable atomicThrowable;
        Object object2;
        boolean bl2;
        boolean bl3 = this.isDisposed();
        if (!bl3 && (bl2 = v.f((i.g.d)(object2 = this.delegate), object, this, atomicThrowable = this.error))) {
            object = this.mainSubscription;
            object2 = AutoSubscriptionHelper.CANCELLED;
            ((AtomicReference)object).lazySet(object2);
            object = this.scopeDisposable;
            AutoDisposableHelper.dispose((AtomicReference)object);
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.scopeDisposable;
        Object object2 = new AutoDisposingSubscriberImpl$a(this);
        Class<AutoDisposingSubscriberImpl> clazz = AutoDisposingSubscriberImpl.class;
        boolean bl2 = i.c((AtomicReference)object, (b)object2, clazz);
        if (bl2) {
            this.delegate.onSubscribe(this);
            this.scope.f((d)object2);
            object2 = this.mainSubscription;
            object = AutoDisposingSubscriberImpl.class;
            boolean bl3 = i.d((AtomicReference)object2, e10, (Class)object);
            if (bl3) {
                object2 = this.ref;
                object = this.requested;
                AutoSubscriptionHelper.deferredSetOnce((AtomicReference)object2, (AtomicLong)object, e10);
            }
        }
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.ref;
        AtomicLong atomicLong = this.requested;
        AutoSubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }
}

