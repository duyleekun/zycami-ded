/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$1;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$2;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class HandlerScheduledExecutorService
extends AbstractExecutorService
implements ScheduledExecutorService {
    private static ThreadLocal sThreadLocalInstance;
    private final Handler mHandler;

    static {
        HandlerScheduledExecutorService$1 handlerScheduledExecutorService$1 = new HandlerScheduledExecutorService$1();
        sThreadLocalInstance = handlerScheduledExecutorService$1;
    }

    public HandlerScheduledExecutorService(Handler handler) {
        this.mHandler = handler;
    }

    private RejectedExecutionException createPostFailedException() {
        CharSequence charSequence = new StringBuilder();
        Handler handler = this.mHandler;
        charSequence.append(handler);
        charSequence.append(" is shutting down");
        charSequence = charSequence.toString();
        RejectedExecutionException rejectedExecutionException = new RejectedExecutionException((String)charSequence);
        return rejectedExecutionException;
    }

    public static ScheduledExecutorService currentThreadExecutor() {
        Object object = (ScheduledExecutorService)sThreadLocalInstance.get();
        if (object == null) {
            object = Looper.myLooper();
            if (object != null) {
                Handler handler = new Handler((Looper)object);
                HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(handler);
                sThreadLocalInstance.set(handlerScheduledExecutorService);
                object = handlerScheduledExecutorService;
            } else {
                object = new IllegalStateException("Current thread has no looper!");
                throw object;
            }
        }
        return object;
    }

    public boolean awaitTermination(long l10, TimeUnit object) {
        CharSequence charSequence = new StringBuilder();
        object = HandlerScheduledExecutorService.class.getSimpleName();
        charSequence.append((String)object);
        charSequence.append(" cannot be shut down. Use Looper.quitSafely().");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public void execute(Runnable runnable) {
        Handler handler = this.mHandler;
        boolean bl2 = handler.post(runnable);
        if (bl2) {
            return;
        }
        throw this.createPostFailedException();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ScheduledFuture schedule(Runnable runnable, long l10, TimeUnit timeUnit) {
        HandlerScheduledExecutorService$2 handlerScheduledExecutorService$2 = new HandlerScheduledExecutorService$2(this, runnable);
        return this.schedule((Callable)handlerScheduledExecutorService$2, l10, timeUnit);
    }

    public ScheduledFuture schedule(Callable callable, long l10, TimeUnit timeUnit) {
        boolean bl2;
        long l11 = SystemClock.uptimeMillis();
        callable = this.mHandler;
        Handler handler = this.mHandler;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        HandlerScheduledExecutorService$HandlerScheduledFuture handlerScheduledExecutorService$HandlerScheduledFuture = new HandlerScheduledExecutorService$HandlerScheduledFuture(handler, l11 += (l10 = timeUnit2.convert(l10, timeUnit)), callable);
        if (bl2 = callable.postAtTime(handlerScheduledExecutorService$HandlerScheduledFuture, l11)) {
            return handlerScheduledExecutorService$HandlerScheduledFuture;
        }
        return Futures.immediateFailedScheduledFuture(this.createPostFailedException());
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        CharSequence charSequence = new StringBuilder();
        String string2 = HandlerScheduledExecutorService.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" does not yet support fixed-rate scheduling.");
        charSequence = charSequence.toString();
        object = new UnsupportedOperationException((String)charSequence);
        throw object;
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        CharSequence charSequence = new StringBuilder();
        String string2 = HandlerScheduledExecutorService.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" does not yet support fixed-delay scheduling.");
        charSequence = charSequence.toString();
        object = new UnsupportedOperationException((String)charSequence);
        throw object;
    }

    public void shutdown() {
        CharSequence charSequence = new StringBuilder();
        String string2 = HandlerScheduledExecutorService.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" cannot be shut down. Use Looper.quitSafely().");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public List shutdownNow() {
        CharSequence charSequence = new StringBuilder();
        String string2 = HandlerScheduledExecutorService.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" cannot be shut down. Use Looper.quitSafely().");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }
}

