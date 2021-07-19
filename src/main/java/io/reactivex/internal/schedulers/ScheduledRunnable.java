/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.s0.b;
import e.a.w0.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable
extends AtomicReferenceArray
implements Runnable,
Callable,
b {
    public static final Object ASYNC_DISPOSED;
    public static final Object DONE;
    public static final int FUTURE_INDEX = 1;
    public static final Object PARENT_DISPOSED;
    public static final int PARENT_INDEX = 0;
    public static final Object SYNC_DISPOSED;
    public static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    public final Runnable actual;

    static {
        Object object;
        PARENT_DISPOSED = object = new Object();
        SYNC_DISPOSED = object = new Object();
        ASYNC_DISPOSED = object = new Object();
        DONE = object = new Object();
    }

    public ScheduledRunnable(Runnable runnable, a a10) {
        super(3);
        this.actual = runnable;
        this.lazySet(0, a10);
    }

    public Object call() {
        this.run();
        return null;
    }

    public void dispose() {
        Object object;
        Object object2;
        Object object3;
        boolean bl2;
        Object object4;
        while ((object4 = this.get((int)((bl2 = true) ? 1 : 0))) != (object3 = DONE) && object4 != (object3 = SYNC_DISPOSED) && object4 != (object2 = ASYNC_DISPOSED)) {
            Thread thread;
            boolean bl3 = 2 != 0;
            Object e10 = this.get((int)(bl3 ? 1 : 0));
            if (e10 != (thread = Thread.currentThread())) {
                bl3 = bl2;
            } else {
                bl3 = false;
                e10 = null;
            }
            if (bl3) {
                object3 = object2;
            }
            if (!(bl2 = (boolean)this.compareAndSet((int)(bl2 ? 1 : 0), object4, object3))) continue;
            if (object4 == null) break;
            object4 = (Future)object4;
            object4.cancel(bl3);
            break;
        }
        while ((object = this.get(0)) != (object4 = DONE) && object != (object4 = PARENT_DISPOSED) && object != null) {
            boolean bl4 = this.compareAndSet(0, object, object4);
            if (!bl4) continue;
            object = (a)object;
            object.c(this);
            break;
        }
    }

    public boolean isDisposed() {
        Object object;
        boolean bl2 = false;
        Object e10 = this.get(0);
        if (e10 == (object = PARENT_DISPOSED) || e10 == (object = DONE)) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = Thread.currentThread();
        int n10 = 2;
        this.lazySet(n10, object);
        boolean bl2 = false;
        object = null;
        int n11 = 1;
        try {
            Runnable runnable = this.actual;
            runnable.run();
        }
        catch (Throwable throwable) {
            try {
                e.a.a1.a.Y(throwable);
            }
            catch (Throwable throwable2) {
                this.lazySet(n10, null);
                object = this.get(0);
                Object object3 = PARENT_DISPOSED;
                if (object != object3 && (n10 = (int)(this.compareAndSet(0, object, object3 = DONE) ? 1 : 0)) != 0 && object != null) {
                    object = (a)object;
                    object.c(this);
                }
                while ((object = this.get(n11)) != (object3 = SYNC_DISPOSED) && object != (object3 = ASYNC_DISPOSED) && !(bl2 = this.compareAndSet(n11, object, object3 = DONE))) {
                }
                throw throwable2;
            }
        }
        this.lazySet(n10, null);
        object = this.get(0);
        Object object2 = PARENT_DISPOSED;
        if (object != object2 && (n10 = (int)(this.compareAndSet(0, object, object2 = DONE) ? 1 : 0)) != 0 && object != null) {
            object = (a)object;
            object.c(this);
        }
        while ((object = this.get(n11)) != (object2 = SYNC_DISPOSED) && object != (object2 = ASYNC_DISPOSED) && !(bl2 = this.compareAndSet(n11, object, object2 = DONE))) {
        }
    }

    public void setFuture(Future future) {
        Object e10;
        int n10;
        do {
            Object object;
            if ((e10 = this.get(n10 = 1)) == (object = DONE)) {
                return;
            }
            object = SYNC_DISPOSED;
            if (e10 == object) {
                future.cancel(false);
                return;
            }
            object = ASYNC_DISPOSED;
            if (e10 != object) continue;
            future.cancel(n10 != 0);
            return;
        } while ((n10 = (int)(this.compareAndSet(n10, e10, future) ? 1 : 0)) == 0);
    }
}

