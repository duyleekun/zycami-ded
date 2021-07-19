/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.t.b;
import d.n.a.q0.u.p;
import d.n.a.q0.w.g$a;
import d.n.a.q0.w.k;
import e.a.b0;
import e.a.h0;
import java.util.concurrent.atomic.AtomicLong;

public class g
implements Comparable {
    private static final AtomicLong d;
    private final long a;
    public final p b;
    public final b0 c;

    static {
        AtomicLong atomicLong;
        d = atomicLong = new AtomicLong(0L);
    }

    public g(p p10, b0 b02) {
        long l10;
        this.a = l10 = d.getAndIncrement();
        this.b = p10;
        this.c = b02;
    }

    public int a(g g10) {
        p p10;
        p p11 = this.b;
        p p12 = g10.b;
        int n10 = p11.compareTo(p12);
        if (n10 == 0 && (p12 = g10.b) != (p10 = this.b)) {
            long l10 = this.a;
            long l11 = g10.a;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object = object < 0 ? (Object)-1 : (Object)1;
            n10 = (int)object;
        }
        return n10;
    }

    public void b(k k10, h0 h02) {
        Object object = this.c;
        boolean bl2 = object.isDisposed();
        if (bl2) {
            d.n.a.q0.t.b.s(this.b);
            k10.release();
            return;
        }
        object = new g$a(this, k10, h02);
        h02.e((Runnable)object);
    }
}

