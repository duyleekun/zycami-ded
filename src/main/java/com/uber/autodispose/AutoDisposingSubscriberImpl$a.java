/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingSubscriberImpl;
import com.uber.autodispose.AutoSubscriptionHelper;
import e.a.y0.b;
import java.util.concurrent.atomic.AtomicReference;

public class AutoDisposingSubscriberImpl$a
extends b {
    public final /* synthetic */ AutoDisposingSubscriberImpl b;

    public AutoDisposingSubscriberImpl$a(AutoDisposingSubscriberImpl autoDisposingSubscriberImpl) {
        this.b = autoDisposingSubscriberImpl;
    }

    public void onComplete() {
        AtomicReference atomicReference = this.b.scopeDisposable;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        AutoSubscriptionHelper.cancel(this.b.mainSubscription);
    }

    public void onError(Throwable throwable) {
        AtomicReference atomicReference = this.b.scopeDisposable;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        this.b.onError(throwable);
    }
}

