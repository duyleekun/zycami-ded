/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.c1.a;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler$DelayedRunnable
extends AtomicReference
implements Runnable,
b,
a {
    private static final long serialVersionUID = -4101336210206799084L;
    public final SequentialDisposable direct;
    public final SequentialDisposable timed;

    public ExecutorScheduler$DelayedRunnable(Runnable object) {
        super(object);
        this.timed = object = new SequentialDisposable();
        this.direct = object = new SequentialDisposable();
    }

    public void dispose() {
        SequentialDisposable sequentialDisposable = this.getAndSet(null);
        if (sequentialDisposable != null) {
            this.timed.dispose();
            sequentialDisposable = this.direct;
            sequentialDisposable.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable)this.get();
        if (runnable == null) {
            runnable = Functions.b;
        }
        return runnable;
    }

    public boolean isDisposed() {
        boolean bl2;
        Object v10 = this.get();
        if (v10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void run() {
        Object object = (Runnable)this.get();
        if (object != null) {
            b b10 = null;
            try {
                object.run();
                this.lazySet(null);
                object = this.timed;
                b10 = DisposableHelper.DISPOSED;
                ((AtomicReference)object).lazySet(b10);
                object = this.direct;
                ((AtomicReference)object).lazySet(b10);
            }
            catch (Throwable throwable) {
                this.lazySet(null);
                b10 = this.timed;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                ((AtomicReference)((Object)b10)).lazySet(disposableHelper);
                b10 = this.direct;
                disposableHelper = DisposableHelper.DISPOSED;
                ((AtomicReference)((Object)b10)).lazySet(disposableHelper);
                throw throwable;
            }
        }
    }
}

