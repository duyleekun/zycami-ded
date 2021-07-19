/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.u;
import f.l2.q;

public final class c$a {
    private c$a() {
    }

    public /* synthetic */ c$a(u u10) {
        this();
    }

    public static final /* synthetic */ int a(c$a c$a, int n10) {
        return c$a.c(n10);
    }

    public static final /* synthetic */ int b(c$a c$a, int n10) {
        return c$a.d(n10);
    }

    private final int c(int n10) {
        return Integer.highestOneBit(q.n(n10, 1) * 3);
    }

    private final int d(int n10) {
        return Integer.numberOfLeadingZeros(n10) + 1;
    }
}

