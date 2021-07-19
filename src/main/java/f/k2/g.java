/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.k2.e;
import f.k2.f;
import f.l2.r;
import f.l2.t;
import f.l2.u;
import f.l2.w;
import f.s1;
import f.z0;

public final class g {
    public static final void a(int n10, int n11) {
        int n12 = s1.c(n11, n10);
        n12 = n12 > 0 ? 1 : 0;
        if (n12 != 0) {
            return;
        }
        Object object = c1.b(n10);
        Object object2 = c1.b(n11);
        object = f.c(object, object2);
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static final void b(long l10, long l11) {
        int n10 = s1.g(l11, l10);
        n10 = n10 > 0 ? 1 : 0;
        if (n10 != 0) {
            return;
        }
        Object object = g1.b(l10);
        Object object2 = g1.b(l11);
        object = f.c(object, object2);
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static final byte[] c(e e10, int n10) {
        f0.p(e10, "$this$nextUBytes");
        return z0.f(e10.d(n10));
    }

    public static final byte[] d(e e10, byte[] byArray) {
        f0.p(e10, "$this$nextUBytes");
        f0.p(byArray, "array");
        e10.e(byArray);
        return byArray;
    }

    public static final byte[] e(e e10, byte[] byArray, int n10, int n11) {
        f0.p(e10, "$this$nextUBytes");
        f0.p(byArray, "array");
        e10.f(byArray, n10, n11);
        return byArray;
    }

    public static /* synthetic */ byte[] f(e e10, byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = z0.n(byArray);
        }
        return g.e(e10, byArray, n10, n11);
    }

    public static final int g(e e10) {
        f0.p(e10, "$this$nextUInt");
        return c1.h(e10.l());
    }

    public static final int h(e object, t object2) {
        f0.p(object, "$this$nextUInt");
        CharSequence charSequence = "range";
        f0.p(object2, (String)charSequence);
        boolean n10 = ((t)object2).isEmpty();
        if (!n10) {
            int n11;
            int n12;
            int n14 = ((r)object2).f();
            n14 = s1.c(n14, n12 = -1);
            if (n14 < 0) {
                int n15 = ((r)object2).e();
                int n16 = c1.h(((r)object2).f() + 1);
                n11 = g.i((e)object, n15, n16);
            } else {
                int n17 = ((r)object2).e();
                n12 = 0;
                int n18 = s1.c(n17, 0);
                if (n18 > 0) {
                    int n19 = c1.h(((r)object2).e() + -1);
                    int n20 = ((r)object2).f();
                    n11 = c1.h(g.i((e)object, n19, n20) + 1);
                } else {
                    n11 = g.g((e)object);
                }
            }
            return n11;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Cannot get random in empty range: ");
        ((StringBuilder)charSequence).append(object2);
        object2 = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static final int i(e e10, int n10, int n11) {
        f0.p(e10, "$this$nextUInt");
        g.a(n10, n11);
        int n12 = -1 << -1;
        return c1.h(e10.n(n10 ^= n12, n11 ^= n12) ^ n12);
    }

    public static final int j(e e10, int n10) {
        f0.p(e10, "$this$nextUInt");
        return g.i(e10, 0, n10);
    }

    public static final long k(e e10) {
        f0.p(e10, "$this$nextULong");
        return g1.h(e10.o());
    }

    public static final long l(e object, w object2) {
        f0.p(object, "$this$nextULong");
        CharSequence charSequence = "range";
        f0.p(object2, (String)charSequence);
        boolean n10 = ((w)object2).isEmpty();
        if (!n10) {
            long l10;
            long l11 = ((u)object2).f();
            long l12 = -1;
            int n11 = s1.g(l11, l12);
            long l13 = 0xFFFFFFFFL;
            int n12 = 1;
            if (n11 < 0) {
                long l14 = ((u)object2).e();
                long l15 = ((u)object2).f();
                long l16 = n12;
                l11 = g1.h(l16 & l13);
                l15 += l11;
                l11 = g1.h(l15);
                l10 = g.n((e)object, l14, l11);
            } else {
                long l17;
                long l18 = ((u)object2).e();
                int n13 = s1.g(l18, l17 = 0L);
                if (n13 > 0) {
                    l18 = ((u)object2).e();
                    l17 = n12;
                    l11 = l17 & l13;
                    l12 = g1.h(l11);
                    l12 = g1.h(l18 - l12);
                    l18 = ((u)object2).f();
                    l10 = g.n((e)object, l12, l18);
                    l11 = g1.h(l11);
                    l10 = g1.h(l10 + l11);
                } else {
                    l10 = g.k((e)object);
                }
            }
            return l10;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Cannot get random in empty range: ");
        ((StringBuilder)charSequence).append(object2);
        object2 = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static final long m(e e10, long l10) {
        f0.p(e10, "$this$nextULong");
        return g.n(e10, 0L, l10);
    }

    public static final long n(e e10, long l10, long l11) {
        f0.p(e10, "$this$nextULong");
        g.b(l10, l11);
        long l12 = Long.MIN_VALUE;
        return g1.h(e10.q(l10 ^= l12, l11 ^= l12) ^ l12);
    }
}

