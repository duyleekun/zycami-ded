/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.v0.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUsing$UsingObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -674404550052917487L;
    public final g disposer;
    public final t downstream;
    public final boolean eager;
    public b upstream;

    public MaybeUsing$UsingObserver(t t10, Object object, g g10, boolean bl2) {
        super(object);
        this.downstream = t10;
        this.disposer = g10;
        this.eager = bl2;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.upstream = disposableHelper;
        this.disposeResourceAfter();
    }

    public void disposeResourceAfter() {
        MaybeUsing$UsingObserver maybeUsing$UsingObserver = this.getAndSet(this);
        if (maybeUsing$UsingObserver != this) {
            g g10 = this.disposer;
            try {
                g10.accept(maybeUsing$UsingObserver);
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

    public void onComplete() {
        boolean bl2;
        Object object;
        block6: {
            object = DisposableHelper.DISPOSED;
            this.upstream = object;
            bl2 = this.eager;
            if (bl2) {
                object = this.getAndSet(this);
                if (object != this) {
                    Object object2 = this.disposer;
                    try {
                        object2.accept(object);
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
        object = this.downstream;
        object.onComplete();
        bl2 = this.eager;
        if (!bl2) {
            this.disposeResourceAfter();
        }
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
            this.disposeResourceAfter();
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
            this.disposeResourceAfter();
        }
    }
}

