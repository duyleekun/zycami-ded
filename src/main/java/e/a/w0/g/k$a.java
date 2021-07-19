/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class k$a
extends h0$c {
    public final ScheduledExecutorService a;
    public final e.a.s0.a b;
    public volatile boolean c;

    public k$a(ScheduledExecutorService object) {
        this.a = object;
        this.b = object = new e.a.s0.a();
    }

    public b c(Runnable future, long l10, TimeUnit timeUnit) {
        boolean bl2 = this.c;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        future = e.a.a1.a.b0((Runnable)((Object)future));
        e.a.s0.a a10 = this.b;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable((Runnable)((Object)future), a10);
        future = this.b;
        ((e.a.s0.a)((Object)future)).b(scheduledRunnable);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 <= 0) {
            future = this.a;
            future = future.submit(scheduledRunnable);
        } else {
            future = this.a;
            future = future.schedule(scheduledRunnable, l10, timeUnit);
        }
        try {
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.dispose();
            e.a.a1.a.Y(rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void dispose() {
        boolean bl2 = this.c;
        if (!bl2) {
            this.c = bl2 = true;
            e.a.s0.a a10 = this.b;
            a10.dispose();
        }
    }

    public boolean isDisposed() {
        return this.c;
    }
}

