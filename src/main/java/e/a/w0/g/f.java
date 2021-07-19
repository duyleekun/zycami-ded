/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0;
import e.a.h0$c;
import e.a.w0.g.g;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;

public final class f
extends h0 {
    private static final String c = "RxNewThreadScheduler";
    private static final RxThreadFactory d;
    private static final String e = "rx2.newthread-priority";
    public final ThreadFactory b;

    static {
        RxThreadFactory rxThreadFactory;
        int n10 = Integer.getInteger(e, 5);
        n10 = Math.min(10, n10);
        n10 = Math.max(1, n10);
        d = rxThreadFactory = new RxThreadFactory(c, n10);
    }

    public f() {
        RxThreadFactory rxThreadFactory = d;
        this(rxThreadFactory);
    }

    public f(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    public h0$c c() {
        ThreadFactory threadFactory = this.b;
        g g10 = new g(threadFactory);
        return g10;
    }
}

