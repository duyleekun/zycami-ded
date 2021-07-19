/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing$UsingObserver
extends AtomicBoolean
implements g0,
b {
    private static final long serialVersionUID = 5904473792286235046L;
    public final g disposer;
    public final g0 downstream;
    public final boolean eager;
    public final Object resource;
    public b upstream;

    public ObservableUsing$UsingObserver(g0 g02, Object object, g g10, boolean bl2) {
        this.downstream = g02;
        this.resource = object;
        this.disposer = g10;
        this.eager = bl2;
    }

    public void dispose() {
        this.disposeAfter();
        this.upstream.dispose();
    }

    public void disposeAfter() {
        g g10 = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            g10 = this.disposer;
            Object object = this.resource;
            try {
                g10.accept(object);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a.Y(throwable);
            }
        }
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        boolean bl2 = this.eager;
        if (bl2) {
            Object object = null;
            boolean bl3 = true;
            bl2 = this.compareAndSet(false, bl3);
            if (bl2) {
                try {
                    object = this.disposer;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                Object object2 = this.resource;
                object.accept(object2);
            }
            this.upstream.dispose();
            object = this.downstream;
            object.onComplete();
        } else {
            this.downstream.onComplete();
            b b10 = this.upstream;
            b10.dispose();
            this.disposeAfter();
        }
    }

    public void onError(Throwable object) {
        boolean bl2 = this.eager;
        if (bl2) {
            bl2 = false;
            g0 g02 = null;
            int n10 = 1;
            boolean bl3 = this.compareAndSet(false, n10 != 0);
            if (bl3) {
                g g10 = this.disposer;
                Object object2 = this.resource;
                try {
                    g10.accept(object2);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    int n11 = 2;
                    Throwable[] throwableArray = new Throwable[n11];
                    throwableArray[0] = object;
                    throwableArray[n10] = throwable;
                    object = object2 = new CompositeException(throwableArray);
                }
            }
            this.upstream.dispose();
            g02 = this.downstream;
            g02.onError((Throwable)object);
        } else {
            g0 g03 = this.downstream;
            g03.onError((Throwable)object);
            object = this.upstream;
            object.dispose();
            this.disposeAfter();
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

