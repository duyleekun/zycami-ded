/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m0;
import h.u;

public final class g {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final byte e = 0;
    private static final byte f = 1;
    private static final byte g = 2;
    private static final byte h = 3;

    public static final /* synthetic */ boolean a(int n10, int n11) {
        return h.g.b(n10, n11);
    }

    private static final boolean b(int n10, int n11) {
        n10 >>= n11;
        n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static final u c(m0 m02) {
        f0.p(m02, "$this$gzip");
        u u10 = new u(m02);
        return u10;
    }
}

