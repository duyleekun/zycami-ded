/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.s0.b;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

public final class d
implements Callable,
b {
    public static final FutureTask f;
    public final Runnable a;
    public final AtomicReference b;
    public final AtomicReference c;
    public final ExecutorService d;
    public Thread e;

    static {
        FutureTask<Object> futureTask;
        Runnable runnable = Functions.b;
        f = futureTask = new FutureTask<Object>(runnable, null);
    }

    public d(Runnable atomicReference, ExecutorService executorService) {
        this.a = atomicReference;
        this.c = atomicReference = new AtomicReference();
        this.b = atomicReference = new AtomicReference();
        this.d = executorService;
    }

    public Void a() {
        Thread thread;
        this.e = thread = Thread.currentThread();
        thread = null;
        Future future = this.a;
        future.run();
        future = this.d;
        future = future.submit(this);
        this.c(future);
        try {
            this.e = null;
        }
        catch (Throwable throwable) {
            this.e = null;
            e.a.a1.a.Y(throwable);
        }
        return null;
    }

    public void b(Future future) {
        Object object;
        Object object2;
        boolean bl2;
        do {
            if ((object = (Future)this.c.get()) != (object2 = f)) continue;
            object = this.e;
            object2 = Thread.currentThread();
            if (object != object2) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            future.cancel(bl2);
            return;
        } while (!(bl2 = ((AtomicReference)(object2 = this.c)).compareAndSet(object, future)));
    }

    public void c(Future future) {
        Object object;
        Object object2;
        boolean bl2;
        do {
            if ((object = (Future)this.b.get()) != (object2 = f)) continue;
            object = this.e;
            object2 = Thread.currentThread();
            if (object != object2) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            future.cancel(bl2);
            return;
        } while (!(bl2 = ((AtomicReference)(object2 = this.b)).compareAndSet(object, future)));
    }

    public void dispose() {
        Thread thread;
        Object object = this.c;
        Runnable runnable = f;
        object = ((AtomicReference)object).getAndSet(runnable);
        boolean bl2 = true;
        if (object != null && object != runnable) {
            boolean bl3;
            thread = this.e;
            Thread thread2 = Thread.currentThread();
            if (thread != thread2) {
                bl3 = bl2;
            } else {
                bl3 = false;
                thread = null;
            }
            object.cancel(bl3);
        }
        if ((object = (Future)this.b.getAndSet(runnable)) != null && object != runnable) {
            runnable = this.e;
            thread = Thread.currentThread();
            if (runnable == thread) {
                bl2 = false;
            }
            object.cancel(bl2);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        FutureTask futureTask;
        Object v10 = this.c.get();
        if (v10 == (futureTask = f)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }
}

