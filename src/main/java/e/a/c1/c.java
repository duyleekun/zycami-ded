/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.c1.c$a;
import e.a.c1.c$b;
import e.a.h0;
import e.a.h0$c;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c
extends h0 {
    public final Queue b;
    public long c;
    public volatile long d;

    public c() {
        PriorityBlockingQueue priorityBlockingQueue;
        this.b = priorityBlockingQueue = new PriorityBlockingQueue(11);
    }

    public c(long l10, TimeUnit timeUnit) {
        PriorityBlockingQueue priorityBlockingQueue;
        this.b = priorityBlockingQueue = new PriorityBlockingQueue(11);
        this.d = l10 = timeUnit.toNanos(l10);
    }

    private void n(long l10) {
        long l11;
        long l12;
        Object object;
        Object object2;
        while ((object2 = (c$b)this.b.peek()) != null && (object = (l12 = (l11 = ((c$b)object2).a) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            long l13 = 0L;
            long l14 = l11 - l13;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object == false) {
                l11 = this.d;
            }
            this.d = l11;
            this.b.remove(object2);
            c$a c$a = ((c$b)object2).c;
            boolean bl2 = c$a.a;
            if (bl2) continue;
            object2 = ((c$b)object2).b;
            object2.run();
        }
        this.d = l10;
    }

    public h0$c c() {
        c$a c$a = new c$a(this);
        return c$a;
    }

    public long d(TimeUnit timeUnit) {
        long l10 = this.d;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        return timeUnit.convert(l10, timeUnit2);
    }

    public void k(long l10, TimeUnit timeUnit) {
        long l11 = this.d;
        l10 = timeUnit.toNanos(l10);
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        this.l(l11 += l10, timeUnit2);
    }

    public void l(long l10, TimeUnit timeUnit) {
        l10 = timeUnit.toNanos(l10);
        this.n(l10);
    }

    public void m() {
        long l10 = this.d;
        this.n(l10);
    }
}

