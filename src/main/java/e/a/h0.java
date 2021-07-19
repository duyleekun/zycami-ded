/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.a1.a;
import e.a.h0$a;
import e.a.h0$b;
import e.a.h0$c;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import java.util.concurrent.TimeUnit;

public abstract class h0 {
    public static final long a;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long l10 = Long.getLong("rx2.scheduler.drift-tolerance", 15);
        a = timeUnit.toNanos(l10);
    }

    public static long b() {
        return a;
    }

    public abstract h0$c c();

    public long d(TimeUnit timeUnit) {
        long l10 = System.currentTimeMillis();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.convert(l10, timeUnit2);
    }

    public b e(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.f(runnable, 0L, timeUnit);
    }

    public b f(Runnable runnable, long l10, TimeUnit timeUnit) {
        h0$c h0$c = this.c();
        runnable = e.a.a1.a.b0(runnable);
        h0$a h0$a = new h0$a(runnable, h0$c);
        h0$c.c(h0$a, l10, timeUnit);
        return h0$a;
    }

    public b g(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        EmptyDisposable emptyDisposable;
        h0$c h0$c = this.c();
        object = e.a.a1.a.b0((Runnable)object);
        h0$b h0$b = new h0$b((Runnable)object, h0$c);
        if ((object = h0$c.d(h0$b, l10, l11, timeUnit)) == (emptyDisposable = EmptyDisposable.INSTANCE)) {
            return object;
        }
        return h0$b;
    }

    public void h() {
    }

    public void i() {
    }

    public h0 j(o o10) {
        SchedulerWhen schedulerWhen = new SchedulerWhen(o10, this);
        return schedulerWhen;
    }
}

