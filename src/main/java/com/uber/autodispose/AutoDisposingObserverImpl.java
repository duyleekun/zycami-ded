/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.AtomicThrowable;
import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingObserverImpl$a;
import d.q.a.i;
import d.q.a.i0.c;
import d.q.a.v;
import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class AutoDisposingObserverImpl
extends AtomicInteger
implements c {
    private final g0 delegate;
    private final AtomicThrowable error;
    public final AtomicReference mainDisposable;
    private final g scope;
    public final AtomicReference scopeDisposable;

    public AutoDisposingObserverImpl(g g10, g0 g02) {
        AtomicThrowable atomicThrowable;
        this.mainDisposable = atomicThrowable = new AtomicReference();
        this.scopeDisposable = atomicThrowable = new AtomicReference();
        this.error = atomicThrowable = new AtomicThrowable();
        this.scope = g10;
        this.delegate = g02;
    }

    public g0 delegateObserver() {
        return this.delegate;
    }

    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    public boolean isDisposed() {
        boolean bl2;
        AutoDisposableHelper autoDisposableHelper;
        Object v10 = this.mainDisposable.get();
        if (v10 == (autoDisposableHelper = AutoDisposableHelper.DISPOSED)) {
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
            Object object = this.mainDisposable;
            Object object2 = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object).lazySet(object2);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            object = this.delegate;
            object2 = this.error;
            v.a((g0)object, this, (AtomicThrowable)object2);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.mainDisposable;
            Object object2 = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object).lazySet(object2);
            AutoDisposableHelper.dispose(this.scopeDisposable);
            object = this.delegate;
            object2 = this.error;
            v.c((g0)object, throwable, this, (AtomicThrowable)object2);
        }
    }

    public void onNext(Object object) {
        AtomicThrowable atomicThrowable;
        Object object2;
        boolean bl2;
        boolean bl3 = this.isDisposed();
        if (!bl3 && (bl2 = v.e((g0)(object2 = this.delegate), object, this, atomicThrowable = this.error))) {
            object = this.mainDisposable;
            object2 = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object).lazySet(object2);
            object = this.scopeDisposable;
            AutoDisposableHelper.dispose((AtomicReference)object);
        }
    }

    public void onSubscribe(b b10) {
        Object object = this.scopeDisposable;
        Object object2 = new AutoDisposingObserverImpl$a(this);
        Class<AutoDisposingObserverImpl> clazz = AutoDisposingObserverImpl.class;
        boolean bl2 = i.c((AtomicReference)object, (b)object2, clazz);
        if (bl2) {
            this.delegate.onSubscribe(this);
            this.scope.f((d)object2);
            object2 = this.mainDisposable;
            object = AutoDisposingObserverImpl.class;
            i.c((AtomicReference)object2, b10, (Class)object);
        }
    }
}

