/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUsing$UsingSingleObserver
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = -5331524057054083935L;
    public final g disposer;
    public final l0 downstream;
    public final boolean eager;
    public b upstream;

    public SingleUsing$UsingSingleObserver(l0 l02, Object object, boolean bl2, g g10) {
        super(object);
        this.downstream = l02;
        this.eager = bl2;
        this.disposer = g10;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.upstream = disposableHelper;
        this.disposeAfter();
    }

    public void disposeAfter() {
        SingleUsing$UsingSingleObserver singleUsing$UsingSingleObserver = this.getAndSet(this);
        if (singleUsing$UsingSingleObserver != this) {
            g g10 = this.disposer;
            try {
                g10.accept(singleUsing$UsingSingleObserver);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a.Y(throwable);
            }
        }
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable object) {
        Object object2 = DisposableHelper.DISPOSED;
        this.upstream = object2;
        boolean bl2 = this.eager;
        if (bl2) {
            object2 = this.getAndSet(this);
            if (object2 != this) {
                Object object3 = this.disposer;
                try {
                    object3.accept(object2);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    int n11 = 2;
                    Throwable[] throwableArray = new Throwable[n11];
                    throwableArray[0] = object;
                    int n10 = 1;
                    throwableArray[n10] = throwable;
                    object = object3 = new CompositeException(throwableArray);
                }
            } else {
                return;
            }
        }
        object2 = this.downstream;
        object2.onError((Throwable)object);
        boolean bl3 = this.eager;
        if (!bl3) {
            this.disposeAfter();
        }
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

    public void onSuccess(Object object) {
        Object object2;
        block6: {
            object2 = DisposableHelper.DISPOSED;
            this.upstream = object2;
            boolean bl2 = this.eager;
            if (bl2) {
                object2 = this.getAndSet(this);
                if (object2 != this) {
                    g g10 = this.disposer;
                    try {
                        g10.accept(object2);
                        break block6;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        object2 = this.downstream;
                        object2.onError(throwable);
                    }
                }
                return;
            }
        }
        object2 = this.downstream;
        object2.onSuccess(object);
        boolean bl3 = this.eager;
        if (!bl3) {
            this.disposeAfter();
        }
    }
}

