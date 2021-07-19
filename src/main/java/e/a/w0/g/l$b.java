/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.w0.b.a;

public final class l$b
implements Comparable {
    public final Runnable a;
    public final long b;
    public final int c;
    public volatile boolean d;

    public l$b(Runnable runnable, Long l10, int n10) {
        long l11;
        this.a = runnable;
        this.b = l11 = l10.longValue();
        this.c = n10;
    }

    public int a(l$b l$b) {
        long l10 = this.b;
        long l11 = l$b.b;
        int n10 = e.a.w0.b.a.b(l10, l11);
        if (n10 == 0) {
            n10 = this.c;
            int n11 = l$b.c;
            return e.a.w0.b.a.a(n10, n11);
        }
        return n10;
    }
}

