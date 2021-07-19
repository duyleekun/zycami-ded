/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.h2.t.f0;
import f.k2.e;
import f.k2.h;
import f.l2.i;
import f.l2.k;
import f.l2.l;
import f.l2.n;
import java.io.Serializable;

public final class f {
    public static final e a(int n10) {
        int n11 = n10 >> 31;
        h h10 = new h(n10, n11);
        return h10;
    }

    public static final e b(long l10) {
        int n10 = (int)l10;
        int n11 = (int)(l10 >> 32);
        h h10 = new h(n10, n11);
        return h10;
    }

    public static final String c(Object object, Object object2) {
        f0.p(object, "from");
        f0.p(object2, "until");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Random range is empty: [");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(").");
        return stringBuilder.toString();
    }

    public static final void d(double d10, double d11) {
        Object object = d11 == d10 ? 0 : (d11 > d10 ? 1 : -1);
        object = object > 0 ? (Object)true : (Object)false;
        if (object != false) {
            return;
        }
        Object object2 = d10;
        Serializable serializable = d11;
        object2 = f.c(object2, serializable);
        object2 = object2.toString();
        serializable = new IllegalArgumentException((String)object2);
        throw serializable;
    }

    public static final void e(int n10, int n11) {
        boolean bl2 = n11 > n10;
        if (bl2) {
            return;
        }
        Object object = n10;
        Serializable serializable = n11;
        object = f.c(object, serializable);
        object = object.toString();
        serializable = new IllegalArgumentException((String)object);
        throw serializable;
    }

    public static final void f(long l10, long l11) {
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        if (object != false) {
            return;
        }
        Object object2 = l10;
        Serializable serializable = l11;
        object2 = f.c(object2, serializable);
        object2 = object2.toString();
        serializable = new IllegalArgumentException((String)object2);
        throw serializable;
    }

    public static final int g(int n10) {
        n10 = Integer.numberOfLeadingZeros(n10);
        return 31 - n10;
    }

    public static final int h(e object, k object2) {
        f0.p(object, "$this$nextInt");
        CharSequence charSequence = "range";
        f0.p(object2, (String)charSequence);
        boolean n10 = ((k)object2).isEmpty();
        if (!n10) {
            int n11;
            int n12;
            int n13 = ((i)object2).f();
            if (n13 < (n12 = -1 >>> 1)) {
                int n14 = ((i)object2).e();
                int n15 = ((i)object2).f() + 1;
                n11 = ((e)object).n(n14, n15);
            } else {
                int n16 = ((i)object2).e();
                if (n16 > (n12 = -1 << -1)) {
                    int n17 = ((i)object2).e() + -1;
                    int n18 = ((i)object2).f();
                    n11 = ((e)object).n(n17, n18) + 1;
                } else {
                    n11 = ((e)object).l();
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

    public static final long i(e object, n object2) {
        f0.p(object, "$this$nextLong");
        CharSequence charSequence = "range";
        f0.p(object2, (String)charSequence);
        boolean n10 = ((n)object2).isEmpty();
        if (!n10) {
            long l10;
            long l11 = ((l)object2).f();
            long l12 = Long.MAX_VALUE;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            long l14 = 1L;
            if (l13 < 0) {
                long l15 = ((l)object2).e();
                long l16 = ((l)object2).f() + l14;
                l10 = ((e)object).q(l15, l16);
            } else {
                long l17;
                long l18 = ((l)object2).e();
                long l19 = l18 - (l17 = Long.MIN_VALUE);
                Object object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object3 > 0) {
                    l18 = ((l)object2).e() - l14;
                    l17 = ((l)object2).f();
                    l10 = ((e)object).q(l18, l17) + l14;
                } else {
                    l10 = ((e)object).o();
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

    public static final int j(int n10, int n11) {
        int n12 = 32 - n11;
        n11 = -n11 >> 31;
        return (n10 >>>= n12) & n11;
    }
}

