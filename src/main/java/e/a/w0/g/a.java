/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.a$a;
import e.a.w0.g.a$b;
import e.a.w0.g.a$c;
import e.a.w0.g.g;
import e.a.w0.g.i;
import e.a.w0.g.i$a;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a
extends h0
implements i {
    public static final a$b d;
    private static final String e = "RxComputationThreadPool";
    public static final RxThreadFactory f;
    public static final String g = "rx2.computation-threads";
    public static final int h = 0;
    public static final a$c i;
    private static final String j = "rx2.computation-priority";
    public final ThreadFactory b;
    public final AtomicReference c;

    static {
        RxThreadFactory rxThreadFactory;
        int n10 = Runtime.getRuntime().availableProcessors();
        int bl2 = Integer.getInteger(g, 0);
        h = e.a.w0.g.a.k(n10, bl2);
        RxThreadFactory rxThreadFactory2 = new RxThreadFactory("RxComputationShutdown");
        Object object = new a$c(rxThreadFactory2);
        i = object;
        ((g)object).dispose();
        n10 = Integer.getInteger(j, 5);
        n10 = Math.min(10, n10);
        boolean bl3 = true;
        n10 = Math.max((int)(bl3 ? 1 : 0), n10);
        f = rxThreadFactory = new RxThreadFactory(e, n10, bl3);
        d = object = new a$b(0, rxThreadFactory);
        ((a$b)object).c();
    }

    public a() {
        RxThreadFactory rxThreadFactory = f;
        this(rxThreadFactory);
    }

    public a(ThreadFactory atomicReference) {
        this.b = atomicReference;
        a$b a$b = d;
        this.c = atomicReference = new AtomicReference<a$b>(a$b);
        this.i();
    }

    public static int k(int n10, int n11) {
        if (n11 > 0 && n11 <= n10) {
            n10 = n11;
        }
        return n10;
    }

    public void a(int n10, i$a i$a) {
        e.a.w0.b.a.h(n10, "number > 0 required");
        ((a$b)this.c.get()).a(n10, i$a);
    }

    public h0$c c() {
        a$c a$c = ((a$b)this.c.get()).b();
        a$a a$a = new a$a(a$c);
        return a$a;
    }

    public b f(Runnable runnable, long l10, TimeUnit timeUnit) {
        return ((a$b)this.c.get()).b().f(runnable, l10, timeUnit);
    }

    public b g(Runnable runnable, long l10, long l11, TimeUnit timeUnit) {
        return ((a$b)this.c.get()).b().g(runnable, l10, l11, timeUnit);
    }

    public void h() {
        a$b a$b;
        a$b a$b2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            if ((a$b2 = (a$b)this.c.get()) != (a$b = d)) continue;
            return;
        } while (!(bl2 = (atomicReference = this.c).compareAndSet(a$b2, a$b)));
        a$b2.c();
    }

    public void i() {
        int n10 = h;
        Object object = this.b;
        AtomicReference atomicReference = this.c;
        object = d;
        a$b a$b = new a$b(n10, (ThreadFactory)object);
        if ((n10 = (int)(atomicReference.compareAndSet(object, a$b) ? 1 : 0)) == 0) {
            a$b.c();
        }
    }
}

