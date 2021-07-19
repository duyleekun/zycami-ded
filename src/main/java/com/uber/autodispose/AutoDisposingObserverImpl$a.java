/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingObserverImpl;
import e.a.y0.b;
import java.util.concurrent.atomic.AtomicReference;

public class AutoDisposingObserverImpl$a
extends b {
    public final /* synthetic */ AutoDisposingObserverImpl b;

    public AutoDisposingObserverImpl$a(AutoDisposingObserverImpl autoDisposingObserverImpl) {
        this.b = autoDisposingObserverImpl;
    }

    public void onComplete() {
        AtomicReference atomicReference = this.b.scopeDisposable;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        AutoDisposableHelper.dispose(this.b.mainDisposable);
    }

    public void onError(Throwable throwable) {
        AtomicReference atomicReference = this.b.scopeDisposable;
        AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
        atomicReference.lazySet(autoDisposableHelper);
        this.b.onError(throwable);
    }
}

