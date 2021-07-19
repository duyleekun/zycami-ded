/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.c1;
import f.d1;
import f.g1;
import f.h1;
import f.h2.t.f0;
import f.m1;
import f.n1;
import f.y0;
import f.z0;
import java.util.Collection;

public class k1 {
    public static final int a(Iterable object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            y0 y02 = (y0)object.next();
            n10 = c1.h(y02.Y() & 0xFF);
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final int b(Iterable object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            c1 c12 = (c1)object.next();
            n10 = c12.a0();
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final long c(Iterable object) {
        boolean bl2;
        String string2 = "$this$sum";
        f0.p(object, string2);
        object = object.iterator();
        long l10 = 0L;
        while (bl2 = object.hasNext()) {
            g1 g12 = (g1)object.next();
            long l11 = g12.a0();
            l10 = g1.h(l10 + l11);
        }
        return l10;
    }

    public static final int d(Iterable object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            m1 m12 = (m1)object.next();
            n10 = m12.Y();
            char c10 = (char)-1;
            n10 = c1.h(n10 & c10);
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final byte[] e(Collection object) {
        byte by2;
        f0.p(object, "$this$toUByteArray");
        int n10 = object.size();
        byte[] byArray = z0.e(n10);
        object = object.iterator();
        int n11 = 0;
        while ((by2 = object.hasNext()) != 0) {
            y0 y02 = (y0)object.next();
            by2 = y02.Y();
            int n12 = n11 + 1;
            z0.t(byArray, n11, by2);
            n11 = n12;
        }
        return byArray;
    }

    public static final int[] f(Collection object) {
        int n10;
        f0.p(object, "$this$toUIntArray");
        int n11 = object.size();
        int[] nArray = d1.e(n11);
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            c1 c12 = (c1)object.next();
            n10 = c12.a0();
            int n13 = n12 + 1;
            d1.t(nArray, n12, n10);
            n12 = n13;
        }
        return nArray;
    }

    public static final long[] g(Collection object) {
        boolean bl2;
        f0.p(object, "$this$toULongArray");
        int n10 = object.size();
        long[] lArray = h1.e(n10);
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            g1 g12 = (g1)object.next();
            long l10 = g12.a0();
            int n12 = n11 + 1;
            h1.t(lArray, n11, l10);
            n11 = n12;
        }
        return lArray;
    }

    public static final short[] h(Collection object) {
        short s10;
        f0.p(object, "$this$toUShortArray");
        int n10 = object.size();
        short[] sArray = n1.e(n10);
        object = object.iterator();
        int n11 = 0;
        while ((s10 = object.hasNext()) != 0) {
            m1 m12 = (m1)object.next();
            s10 = m12.Y();
            int n12 = n11 + 1;
            n1.t(sArray, n11, s10);
            n11 = n12;
        }
        return sArray;
    }
}

