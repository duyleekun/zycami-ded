/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0$c;
import e.a.s0.b;
import e.a.s0.c;
import e.a.w0.g.l$a;
import e.a.w0.g.l$b;
import e.a.w0.g.l$c$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.io.Serializable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class l$c
extends h0$c
implements b {
    public final PriorityBlockingQueue a;
    private final AtomicInteger b;
    public final AtomicInteger c;
    public volatile boolean d;

    public l$c() {
        Serializable serializable;
        this.a = serializable = new Serializable();
        this.b = serializable;
        super();
        this.c = serializable;
    }

    public b b(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l10 = this.a(timeUnit);
        return this.e(runnable, l10);
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long l11 = this.a(timeUnit2);
        l10 = timeUnit.toMillis(l10);
        l$a l$a = new l$a(runnable, this, l11 += l10);
        return this.e(l$a, l11);
    }

    public void dispose() {
        this.d = true;
    }

    public b e(Runnable object, long l10) {
        boolean bl2 = this.d;
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        Object object2 = l10;
        AtomicInteger atomicInteger = this.c;
        int n10 = atomicInteger.incrementAndGet();
        l$b l$b = new l$b((Runnable)object, (Long)object2, n10);
        this.a.add(l$b);
        object = this.b;
        int n11 = ((AtomicInteger)object).getAndIncrement();
        if (n11 == 0) {
            n11 = 1;
            while (true) {
                boolean bl3;
                if (bl3 = this.d) {
                    this.a.clear();
                    return EmptyDisposable.INSTANCE;
                }
                object2 = (l$b)this.a.poll();
                if (object2 == null) {
                    object2 = this.b;
                    n11 = -n11;
                    if ((n11 = ((AtomicInteger)object2).addAndGet(n11)) != 0) continue;
                    return EmptyDisposable.INSTANCE;
                }
                n10 = (int)(((l$b)object2).d ? 1 : 0);
                if (n10 != 0) continue;
                object2 = ((l$b)object2).a;
                object2.run();
            }
        }
        object = new l$c$a(this, l$b);
        return e.a.s0.c.f((Runnable)object);
    }

    public boolean isDisposed() {
        return this.d;
    }
}

