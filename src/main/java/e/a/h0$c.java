/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.a1.a;
import e.a.h0$c$a;
import e.a.s0.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public abstract class h0$c
implements b {
    public long a(TimeUnit timeUnit) {
        long l10 = System.currentTimeMillis();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.convert(l10, timeUnit2);
    }

    public b b(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.c(runnable, 0L, timeUnit);
    }

    public abstract b c(Runnable var1, long var2, TimeUnit var4);

    public b d(Runnable runnable, long l10, long l11, TimeUnit timeUnit) {
        SequentialDisposable sequentialDisposable;
        Object object = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable((b)object);
        Runnable runnable2 = a.b0(runnable);
        long l12 = l11;
        long l13 = timeUnit.toNanos(l11);
        Object object2 = TimeUnit.NANOSECONDS;
        long l14 = this.a((TimeUnit)((Object)object2));
        l12 = timeUnit.toNanos(l10);
        long l15 = l14 + l12;
        object2 = sequentialDisposable;
        b b10 = this;
        SequentialDisposable sequentialDisposable3 = object;
        object = sequentialDisposable;
        sequentialDisposable = sequentialDisposable2;
        ((h0$c$a)object2)(this, l15, runnable2, l14, sequentialDisposable2, l13);
        object2 = this.c((Runnable)object2, l10, timeUnit);
        b10 = EmptyDisposable.INSTANCE;
        if (object2 == b10) {
            return object2;
        }
        b10 = sequentialDisposable3;
        sequentialDisposable3.replace((b)object2);
        return sequentialDisposable2;
    }
}

