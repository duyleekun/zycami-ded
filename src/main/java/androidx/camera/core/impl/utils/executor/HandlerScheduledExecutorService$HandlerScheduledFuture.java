/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture$1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class HandlerScheduledExecutorService$HandlerScheduledFuture
implements RunnableScheduledFuture {
    public final AtomicReference mCompleter;
    private final ListenableFuture mDelegate;
    private final long mRunAtMillis;
    private final Callable mTask;

    public HandlerScheduledExecutorService$HandlerScheduledFuture(Handler object, long l10, Callable callable) {
        AtomicReference<Object> atomicReference;
        this.mCompleter = atomicReference = new AtomicReference<Object>(null);
        this.mRunAtMillis = l10;
        this.mTask = callable;
        HandlerScheduledExecutorService$HandlerScheduledFuture$1 handlerScheduledExecutorService$HandlerScheduledFuture$1 = new HandlerScheduledExecutorService$HandlerScheduledFuture$1(this, (Handler)object, callable);
        object = CallbackToFutureAdapter.getFuture(handlerScheduledExecutorService$HandlerScheduledFuture$1);
        this.mDelegate = object;
    }

    public boolean cancel(boolean bl2) {
        return this.mDelegate.cancel(bl2);
    }

    public int compareTo(Delayed delayed) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l10 = this.getDelay(timeUnit);
        long l11 = delayed.getDelay(timeUnit);
        return Long.compare(l10, l11);
    }

    public Object get() {
        return this.mDelegate.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.mDelegate.get(l10, timeUnit);
    }

    public long getDelay(TimeUnit timeUnit) {
        long l10 = this.mRunAtMillis;
        long l11 = System.currentTimeMillis();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.convert(l10 -= l11, timeUnit2);
    }

    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public boolean isPeriodic() {
        return false;
    }

    public void run() {
        Object object = this.mCompleter;
        Callable callable = null;
        if ((object = (CallbackToFutureAdapter$Completer)((AtomicReference)object).getAndSet(null)) != null) {
            callable = this.mTask;
            callable = callable.call();
            try {
                ((CallbackToFutureAdapter$Completer)object).set(callable);
            }
            catch (Exception exception) {
                ((CallbackToFutureAdapter$Completer)object).setException(exception);
            }
        }
    }
}

