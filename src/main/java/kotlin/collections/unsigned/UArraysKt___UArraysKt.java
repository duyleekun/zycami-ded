/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections.unsigned;

import f.c1;
import f.d1;
import f.d2.l;
import f.g1;
import f.h2.s.p;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.k;
import f.l2.q;
import f.m1;
import f.n1;
import f.s1;
import f.w0;
import f.x1.a0;
import f.x1.c;
import f.x1.c$a;
import f.x1.h1;
import f.x1.j0;
import f.x1.n;
import f.x1.q1.b;
import f.x1.s0;
import f.x1.t;
import f.x1.u;
import f.x1.y;
import f.y0;
import f.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$1;
import kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$2;
import kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$3;
import kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$4;
import kotlin.jvm.internal.Ref$ByteRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ShortRef;

public class UArraysKt___UArraysKt
extends b {
    private static final boolean A(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = c1.b(nArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final /* synthetic */ boolean A0(short[] sArray, short[] sArray2) {
        f0.p(sArray, "$this$contentEquals");
        f0.p(sArray2, "other");
        return UArraysKt___UArraysKt.u0(sArray, sArray2);
    }

    private static final List A1(int[] nArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Comparable comparable = c1.b(d1.l(nArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.cc(nArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    private static final c1 A2(int[] object, f.h2.s.l l10) {
        block3: {
            int n10;
            k k10 = ArraysKt___ArraysKt.Gd(object);
            int n11 = k10.f();
            if (n11 >= (n10 = k10.e())) {
                while (true) {
                    int n12 = d1.l(object, n11);
                    Comparable comparable = c1.b(n12);
                    boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                    if (bl2) {
                        object = c1.b(n12);
                        break block3;
                    }
                    if (n11 == n10) break;
                    n11 += -1;
                }
            }
            object = null;
        }
        return object;
    }

    private static final void A3(int[] nArray, f.h2.s.l l10) {
        for (int n10 : nArray) {
            c1 c12 = c1.b(n10);
            l10.invoke(c12);
        }
    }

    private static final int A4(int[] nArray, f.h2.s.l l10) {
        int n10;
        block2: {
            int n11 = nArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Comparable comparable = c1.b(c1.h(nArray[n10]));
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private static final c1 A5(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        int n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 == 0) {
            return c1.b(n10);
        }
        Comparable comparable = c1.b(n10);
        comparable = (Comparable)l10.invoke(comparable);
        int n12 = 1;
        if (n12 <= n11) {
            while (true) {
                int n13 = d1.l(nArray, n12);
                Comparable comparable2 = c1.b(n13);
                int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return c1.b(n10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final c1 A6(int[] object, f.h2.s.l l10) {
        void var0_3;
        int n10 = d1.q(object);
        if (n10 != 0) {
            return var0_3;
        }
        n10 = d1.l(object, 0);
        int n11 = ArraysKt___ArraysKt.Pd(object);
        if (n11 != 0) {
            void var1_4;
            Comparable comparable = c1.b(n10);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n12 = 1;
            if (n12 <= n11) {
                while (true) {
                    int n13;
                    c1 c12;
                    Comparable comparable2;
                    int n14;
                    if ((n14 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(c12 = c1.b(n13 = d1.l(object, n12))))) > 0) {
                        n10 = n13;
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
        }
        c1 c13 = c1.b(n10);
        return var0_3;
    }

    private static final boolean A7(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final m1 A8(short[] sArray, f.h2.s.q q10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        m1 m12 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                Integer n12 = n10;
                m12 = m1.b(s10);
                short s11 = n1.l(sArray, n10);
                m1 m13 = m1.b(s11);
                m12 = (m1)q10.invoke(n12, m12, m13);
                s10 = m12.Y();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    private static final List A9(short[] sArray, f.h2.s.q q10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        m1 m12 = null;
        s10 = n1.l(sArray, 0);
        int n10 = n1.n(sArray);
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
        m1 m13 = m1.b(s10);
        arrayList.add(m13);
        n10 = n1.n(sArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            Comparable<Integer> comparable = i10;
            m12 = m1.b(s10);
            short s11 = n1.l(sArray, i10);
            m1 m14 = m1.b(s11);
            m12 = (m1)q10.invoke(comparable, m12, m14);
            s10 = m12.Y();
            comparable = m1.b(s10);
            arrayList.add(comparable);
        }
        return arrayList;
    }

    public static final long[] Aa(long[] lArray, k k10) {
        f0.p(lArray, "$this$sliceArray");
        f0.p(k10, "indices");
        return f.h1.f(ArraysKt___ArraysKt.Tt(lArray, k10));
    }

    private static final double Ab(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Object object = c1.b(n11);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final int[] Ac(int[] nArray) {
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        return d1.f(nArray);
    }

    private static final boolean B(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final /* synthetic */ boolean B0(long[] lArray, long[] lArray2) {
        f0.p(lArray, "$this$contentEquals");
        f0.p(lArray2, "other");
        return UArraysKt___UArraysKt.z0(lArray, lArray2);
    }

    private static final List B1(short[] sArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Comparable comparable = m1.b(n1.l(sArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.bc(sArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    private static final m1 B2(short[] object, f.h2.s.l l10) {
        block3: {
            int n10;
            k k10 = ArraysKt___ArraysKt.Jd(object);
            int n11 = k10.f();
            if (n11 >= (n10 = k10.e())) {
                while (true) {
                    short s10 = n1.l(object, n11);
                    Comparable comparable = m1.b(s10);
                    boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                    if (bl2) {
                        object = m1.b(s10);
                        break block3;
                    }
                    if (n11 == n10) break;
                    n11 += -1;
                }
            }
            object = null;
        }
        return object;
    }

    private static final void B3(short[] sArray, f.h2.s.l l10) {
        for (short s10 : sArray) {
            m1 m12 = m1.b(s10);
            l10.invoke(m12);
        }
    }

    private static final int B4(short[] sArray, f.h2.s.l l10) {
        int n10;
        block2: {
            int n11 = sArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Comparable comparable = m1.b(m1.h(sArray[n10]));
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private static final m1 B5(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 == 0) {
            return m1.b(s10);
        }
        Comparable comparable = m1.b(s10);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                short s11 = n1.l(sArray, n11);
                Comparable comparable2 = m1.b(s11);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    s10 = s11;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return m1.b(s10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final m1 B6(short[] object, f.h2.s.l l10) {
        void var0_3;
        short s10 = n1.q(object);
        if (s10 != 0) {
            return var0_3;
        }
        s10 = n1.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Sd(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = m1.b(s10);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    short s11;
                    m1 m12;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(m12 = m1.b(s11 = n1.l(object, n11))))) > 0) {
                        s10 = s11;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        m1 m13 = m1.b(s10);
        return var0_3;
    }

    private static final boolean B7(long[] lArray, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final g1 B8(long[] lArray, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        g1 g12 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                Integer n12 = n10;
                g12 = g1.b(l10);
                long l11 = f.h1.l(lArray, n10);
                g1 g13 = g1.b(l11);
                g12 = (g1)q10.invoke(n12, g12, g13);
                l10 = g12.a0();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    private static final List B9(long[] lArray, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        bl2 = false;
        g1 g12 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = f.h1.n(lArray);
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
        g1 g13 = g1.b(l10);
        arrayList.add(g13);
        n10 = f.h1.n(lArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            Comparable<Integer> comparable = i10;
            g12 = g1.b(l10);
            long l11 = f.h1.l(lArray, i10);
            g1 g14 = g1.b(l11);
            g12 = (g1)q10.invoke(comparable, g12, g14);
            l10 = g12.a0();
            comparable = g1.b(l10);
            arrayList.add(comparable);
        }
        return arrayList;
    }

    public static final byte[] Ba(byte[] byArray, k k10) {
        f0.p(byArray, "$this$sliceArray");
        f0.p(k10, "indices");
        return z0.f(ArraysKt___ArraysKt.Jt(byArray, k10));
    }

    private static final double Bb(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Object object = m1.b(s10);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final int[] Bc(c1[] c1Array) {
        String string2 = "$this$toUIntArray";
        f0.p(c1Array, string2);
        int n10 = c1Array.length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            c1 c12 = c1Array[i10];
            nArray[i10] = n11 = c12.a0();
        }
        return d1.f(nArray);
    }

    private static final boolean C(int[] nArray) {
        return ArraysKt___ArraysKt.I4(nArray);
    }

    public static final /* synthetic */ int C0(int[] nArray) {
        f0.p(nArray, "$this$contentHashCode");
        return UArraysKt___UArraysKt.G0(nArray);
    }

    private static final List C1(byte[] byArray, f.h2.s.l l10) {
        ArrayList<y0> arrayList = new ArrayList<y0>();
        int n10 = byArray.length;
        boolean bl2 = false;
        y0 y02 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            if (bl2) {
                y0 y03 = y0.b(by2);
                arrayList.add(y03);
                continue;
            }
            Comparable comparable = y0.b(by2);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl3) continue;
            y02 = y0.b(by2);
            arrayList.add(y02);
            bl2 = true;
        }
        return arrayList;
    }

    private static final int C2(int[] nArray) {
        return c1.h(ArraysKt___ArraysKt.kb(nArray));
    }

    private static final void C3(byte[] byArray, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            y0 y02 = y0.b(by2);
            p10.invoke(n12, y02);
        }
    }

    private static final int C4(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Comparable comparable = y0.b(y0.h(byArray[n10]));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    private static final double C5(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final y0 C6(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 == 0) {
            return y0.b(by2);
        }
        Comparable comparable = y0.b(by2);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                byte by3 = z0.l(byArray, n11);
                Comparable comparable2 = y0.b(by3);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    by2 = by3;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return y0.b(by2);
    }

    private static final boolean C7(long[] lArray) {
        return f.h1.q(lArray);
    }

    private static final y0 C8(byte[] byArray, p p10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        y0 y02 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                y02 = y0.b(by2);
                byte by3 = z0.l(byArray, n10);
                y0 y03 = y0.b(by3);
                y02 = (y0)p10.invoke(y02, y03);
                by2 = y02.Y();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    /*
     * WARNING - void declaration
     */
    private static final List C9(long[] object, Object object2, p p10) {
        void var0_3;
        Object object3;
        boolean bl2 = f.h1.q((long[])object);
        if (bl2) {
            List list = t.k(object3);
        } else {
            int n10 = f.h1.n((long[])object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object3);
            for (Object object4 : object) {
                void var2_5;
                g1 g12 = g1.b((long)object4);
                object3 = var2_5.invoke(object3, g12);
                arrayList.add(object3);
            }
            ArrayList<Object> arrayList2 = arrayList;
        }
        return var0_3;
    }

    public static final long[] Ca(long[] lArray, Collection collection) {
        f0.p(lArray, "$this$sliceArray");
        f0.p(collection, "indices");
        return f.h1.f(ArraysKt___ArraysKt.St(lArray, collection));
    }

    private static final double Cb(byte[] byArray, f.h2.s.l l10) {
        double d10 = 0.0;
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long[] Cc(long[] lArray) {
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        return f.h1.f(lArray);
    }

    private static final boolean D(byte[] byArray) {
        return ArraysKt___ArraysKt.A4(byArray);
    }

    public static final int D0(byte[] byArray) {
        if (byArray == null) {
            byArray = null;
        }
        return Arrays.hashCode(byArray);
    }

    private static final List D1(long[] lArray, f.h2.s.l l10) {
        ArrayList<g1> arrayList = new ArrayList<g1>();
        int n10 = lArray.length;
        boolean bl2 = false;
        g1 g12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            if (bl2) {
                g1 g13 = g1.b(l11);
                arrayList.add(g13);
                continue;
            }
            Comparable comparable = g1.b(l11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl3) continue;
            g12 = g1.b(l11);
            arrayList.add(g12);
            bl2 = true;
        }
        return arrayList;
    }

    private static final byte D2(byte[] byArray) {
        return y0.h(ArraysKt___ArraysKt.cb(byArray));
    }

    private static final void D3(int[] nArray, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            c1 c12 = c1.b(n12);
            p10.invoke(n13, c12);
        }
    }

    private static final int D4(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            long l11 = g1.h(lArray[n10]);
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    private static final float D5(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.max(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final g1 D6(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 == 0) {
            return g1.b(l11);
        }
        Comparable comparable = g1.b(l11);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                long l12 = f.h1.l(lArray, n11);
                Comparable comparable2 = g1.b(l12);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    l11 = l12;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return g1.b(l11);
    }

    private static final boolean D7(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = c1.b(nArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final c1 D8(int[] nArray, p p10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        c1 c12 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                c12 = c1.b(n10);
                int n13 = d1.l(nArray, n11);
                c1 c13 = c1.b(n13);
                c12 = (c1)p10.invoke(c12, c13);
                n10 = c12.a0();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    /*
     * WARNING - void declaration
     */
    private static final List D9(byte[] object, Object object2, p p10) {
        void var0_3;
        Object object3;
        boolean bl2 = z0.q((byte[])object);
        if (bl2) {
            List list = t.k(object3);
        } else {
            int n10 = z0.n((byte[])object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object3);
            for (Object object4 : object) {
                void var2_5;
                y0 y02 = y0.b((byte)object4);
                object3 = var2_5.invoke(object3, y02);
                arrayList.add(object3);
            }
            ArrayList<Object> arrayList2 = arrayList;
        }
        return var0_3;
    }

    public static final short[] Da(short[] sArray, Collection collection) {
        f0.p(sArray, "$this$sliceArray");
        f0.p(collection, "indices");
        return n1.f(ArraysKt___ArraysKt.Wt(sArray, collection));
    }

    private static final double Db(int[] nArray, f.h2.s.l l10) {
        double d10 = 0.0;
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final long[] Dc(g1[] g1Array) {
        String string2 = "$this$toULongArray";
        f0.p(g1Array, string2);
        int n10 = g1Array.length;
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            g1 g12 = g1Array[i10];
            lArray[i10] = l10 = g12.a0();
        }
        return f.h1.f(lArray);
    }

    private static final boolean E(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final /* synthetic */ int E0(byte[] byArray) {
        f0.p(byArray, "$this$contentHashCode");
        return UArraysKt___UArraysKt.D0(byArray);
    }

    private static final List E1(int[] nArray, f.h2.s.l l10) {
        ArrayList<c1> arrayList = new ArrayList<c1>();
        int n10 = nArray.length;
        boolean bl2 = false;
        c1 c12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            if (bl2) {
                c1 c13 = c1.b(n11);
                arrayList.add(c13);
                continue;
            }
            Comparable comparable = c1.b(n11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl3) continue;
            c12 = c1.b(n11);
            arrayList.add(c12);
            bl2 = true;
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    private static final byte E2(byte[] object, f.h2.s.l l10) {
        for (Object object2 : object) {
            void var1_2;
            Comparable comparable = y0.b((byte)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (!bl2) continue;
            return (byte)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final void E3(long[] lArray, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            g1 g12 = g1.b(l10);
            p10.invoke(n12, g12);
        }
    }

    private static final int E4(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Comparable comparable = c1.b(c1.h(nArray[n10]));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    private static final Comparable E5(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Comparable comparable = y0.b(by2);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Comparable comparable2 = y0.b(by3);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 < 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final c1 E6(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        int n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 == 0) {
            return c1.b(n10);
        }
        Comparable comparable = c1.b(n10);
        comparable = (Comparable)l10.invoke(comparable);
        int n12 = 1;
        if (n12 <= n11) {
            while (true) {
                int n13 = d1.l(nArray, n12);
                Comparable comparable2 = c1.b(n13);
                int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return c1.b(n10);
    }

    private static final boolean E7(short[] sArray) {
        return n1.q(sArray);
    }

    private static final g1 E8(long[] lArray, p p10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        g1 g12 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                g12 = g1.b(l10);
                long l11 = f.h1.l(lArray, n10);
                g1 g13 = g1.b(l11);
                g12 = (g1)p10.invoke(g12, g13);
                l10 = g12.a0();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    /*
     * WARNING - void declaration
     */
    private static final List E9(int[] object, Object object2, p p10) {
        void var0_3;
        Object object3;
        boolean bl2 = d1.q((int[])object);
        if (bl2) {
            List list = t.k(object3);
        } else {
            int n10 = d1.n((int[])object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object3);
            for (Object object4 : object) {
                void var2_5;
                c1 c12 = c1.b((int)object4);
                object3 = var2_5.invoke(object3, c12);
                arrayList.add(object3);
            }
            ArrayList<Object> arrayList2 = arrayList;
        }
        return var0_3;
    }

    public static final int[] Ea(int[] nArray, k k10) {
        f0.p(nArray, "$this$sliceArray");
        f0.p(k10, "indices");
        return d1.f(ArraysKt___ArraysKt.Rt(nArray, k10));
    }

    private static final double Eb(long[] lArray, f.h2.s.l l10) {
        double d10 = 0.0;
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final short[] Ec(m1[] m1Array) {
        String string2 = "$this$toUShortArray";
        f0.p(m1Array, string2);
        int n10 = m1Array.length;
        short[] sArray = new short[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10;
            m1 m12 = m1Array[i10];
            sArray[i10] = s10 = m12.Y();
        }
        return n1.f(sArray);
    }

    private static final boolean F(long[] lArray, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final /* synthetic */ int F0(long[] lArray) {
        f0.p(lArray, "$this$contentHashCode");
        return UArraysKt___UArraysKt.J0(lArray);
    }

    private static final List F1(short[] sArray, f.h2.s.l l10) {
        ArrayList<m1> arrayList = new ArrayList<m1>();
        int n10 = sArray.length;
        boolean bl2 = false;
        m1 m12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            if (bl2) {
                m1 m13 = m1.b(s10);
                arrayList.add(m13);
                continue;
            }
            Comparable comparable = m1.b(s10);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl3) continue;
            m12 = m1.b(s10);
            arrayList.add(m12);
            bl2 = true;
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    private static final long F2(long[] object, f.h2.s.l l10) {
        for (Object object2 : object) {
            void var1_2;
            Comparable comparable = g1.b((long)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (!bl2) continue;
            return (long)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final void F3(short[] sArray, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            m1 m12 = m1.b(s10);
            p10.invoke(n12, m12);
        }
    }

    private static final int F4(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Comparable comparable = m1.b(m1.h(sArray[n10]));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    private static final double F5(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final m1 F6(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 == 0) {
            return m1.b(s10);
        }
        Comparable comparable = m1.b(s10);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                short s11 = n1.l(sArray, n11);
                Comparable comparable2 = m1.b(s11);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    s10 = s11;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return m1.b(s10);
    }

    private static final boolean F7(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final m1 F8(short[] sArray, p p10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        m1 m12 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                m12 = m1.b(s10);
                short s11 = n1.l(sArray, n10);
                m1 m13 = m1.b(s11);
                m12 = (m1)p10.invoke(m12, m13);
                s10 = m12.Y();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    /*
     * WARNING - void declaration
     */
    private static final List F9(short[] object, Object object2, p p10) {
        void var0_3;
        Object object3;
        boolean bl2 = n1.q((short[])object);
        if (bl2) {
            List list = t.k(object3);
        } else {
            int n10 = n1.n((short[])object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object3);
            for (Object object4 : object) {
                void var2_5;
                m1 m12 = m1.b((short)object4);
                object3 = var2_5.invoke(object3, m12);
                arrayList.add(object3);
            }
            ArrayList<Object> arrayList2 = arrayList;
        }
        return var0_3;
    }

    public static final byte[] Fa(byte[] byArray, Collection collection) {
        f0.p(byArray, "$this$sliceArray");
        f0.p(collection, "indices");
        return z0.f(ArraysKt___ArraysKt.It(byArray, collection));
    }

    private static final double Fb(short[] sArray, f.h2.s.l l10) {
        double d10 = 0.0;
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final short[] Fc(short[] sArray) {
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        return n1.f(sArray);
    }

    private static final boolean G(long[] lArray) {
        return ArraysKt___ArraysKt.K4(lArray);
    }

    public static final int G0(int[] nArray) {
        if (nArray == null) {
            nArray = null;
        }
        return Arrays.hashCode(nArray);
    }

    private static final short G1(short[] object, int n10, f.h2.s.l l10) {
        short s10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd((short[])object))) {
            s10 = n1.l((short[])object, n10);
        } else {
            object = n10;
            object = (m1)l10.invoke(object);
            s10 = ((m1)object).Y();
        }
        return s10;
    }

    private static final long G2(long[] lArray) {
        return g1.h(ArraysKt___ArraysKt.mb(lArray));
    }

    public static final k G3(int[] nArray) {
        f0.p(nArray, "$this$indices");
        return ArraysKt___ArraysKt.Gd(nArray);
    }

    private static final int G4(int[] nArray) {
        return c1.h(ArraysKt___ArraysKt.Rg(nArray));
    }

    private static final float G5(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.max(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final double G6(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final byte[] G7(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            y0 y02 = y0.b(by2);
            l10.invoke(y02);
        }
        return byArray;
    }

    private static final byte G8(byte[] object, p p10) {
        int n10 = ArraysKt___ArraysKt.Ld(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = z0.l(object, n10);
            while (n11 >= 0) {
                int n12 = n11 + -1;
                y0 y02 = y0.b(z0.l(object, n11));
                y0 y03 = y0.b((byte)n10);
                y03 = (y0)p10.invoke(y02, y03);
                n10 = y03.Y();
                n11 = n12;
            }
            return (byte)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List G9(byte[] object, Object object2, f.h2.s.q q10) {
        boolean bl2 = z0.q(object);
        if (bl2) {
            object = t.k(object2);
        } else {
            int n10 = z0.n(object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object2);
            k k10 = ArraysKt___ArraysKt.Cd(object);
            int n11 = k10.e();
            n10 = k10.f();
            if (n11 <= n10) {
                while (true) {
                    Integer n12 = n11;
                    byte by2 = z0.l(object, n11);
                    y0 y02 = y0.b(by2);
                    object2 = q10.invoke(n12, object2, y02);
                    arrayList.add(object2);
                    if (n11 == n10) break;
                    ++n11;
                }
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Ga(int[] nArray) {
        String string2 = "$this$sort";
        f0.p(nArray, string2);
        int n10 = d1.n(nArray);
        int n11 = 1;
        if (n10 > n11) {
            n10 = 0;
            string2 = null;
            n11 = d1.n(nArray);
            h1.l(nArray, 0, n11);
        }
    }

    private static final int Gb(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = y0.b(byArray[i10]);
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final Iterable Gc(int[] nArray) {
        f0.p(nArray, "$this$withIndex");
        UArraysKt___UArraysKt$withIndex$1 uArraysKt___UArraysKt$withIndex$1 = new UArraysKt___UArraysKt$withIndex$1(nArray);
        j0 j02 = new j0(uArraysKt___UArraysKt$withIndex$1);
        return j02;
    }

    private static final boolean H(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = c1.b(nArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final int H0(short[] sArray) {
        if (sArray == null) {
            sArray = null;
        }
        return Arrays.hashCode(sArray);
    }

    private static final int H1(int[] object, int n10, f.h2.s.l l10) {
        int n11;
        int n12;
        if (n10 >= 0 && n10 <= (n12 = ArraysKt___ArraysKt.Pd((int[])object))) {
            n11 = d1.l((int[])object, n10);
        } else {
            object = n10;
            object = (c1)l10.invoke(object);
            n11 = ((c1)object).a0();
        }
        return n11;
    }

    /*
     * WARNING - void declaration
     */
    private static final int H2(int[] object, f.h2.s.l l10) {
        for (Object object2 : object) {
            void var1_2;
            Comparable comparable = c1.b((int)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (!bl2) continue;
            return (int)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public static /* synthetic */ void H3(int[] nArray) {
    }

    private static final byte H4(byte[] byArray) {
        return y0.h(ArraysKt___ArraysKt.Jg(byArray));
    }

    private static final Comparable H5(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Comparable comparable = g1.b(l11);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Comparable comparable2 = g1.b(l12);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 < 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final float H6(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.min(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final long[] H7(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            g1 g12 = g1.b(l11);
            l10.invoke(g12);
        }
        return lArray;
    }

    private static final int H8(int[] object, p p10) {
        int n10 = ArraysKt___ArraysKt.Pd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = d1.l(object, n10);
            while (n11 >= 0) {
                int n12 = n11 + -1;
                c1 c12 = c1.b(d1.l(object, n11));
                c1 c13 = c1.b(n10);
                c13 = (c1)p10.invoke(c12, c13);
                n10 = c13.a0();
                n11 = n12;
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List H9(short[] object, Object object2, f.h2.s.q q10) {
        boolean bl2 = n1.q(object);
        if (bl2) {
            object = t.k(object2);
        } else {
            int n10 = n1.n(object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object2);
            k k10 = ArraysKt___ArraysKt.Jd(object);
            int n11 = k10.e();
            n10 = k10.f();
            if (n11 <= n10) {
                while (true) {
                    Integer n12 = n11;
                    short s10 = n1.l(object, n11);
                    m1 m12 = m1.b(s10);
                    object2 = q10.invoke(n12, object2, m12);
                    arrayList.add(object2);
                    if (n11 == n10) break;
                    ++n11;
                }
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Ha(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$sort");
        c$a c$a = c.a;
        int n12 = f.h1.n(lArray);
        c$a.d(n10, n11, n12);
        h1.i(lArray, n10, n11);
    }

    private static final int Hb(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = c1.b(nArray[i10]);
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final Iterable Hc(byte[] byArray) {
        f0.p(byArray, "$this$withIndex");
        UArraysKt___UArraysKt$withIndex$3 uArraysKt___UArraysKt$withIndex$3 = new UArraysKt___UArraysKt$withIndex$3(byArray);
        j0 j02 = new j0(uArraysKt___UArraysKt$withIndex$3);
        return j02;
    }

    private static final boolean I(short[] sArray) {
        return ArraysKt___ArraysKt.O4(sArray);
    }

    public static final /* synthetic */ int I0(short[] sArray) {
        f0.p(sArray, "$this$contentHashCode");
        return UArraysKt___UArraysKt.H0(sArray);
    }

    private static final long I1(long[] object, int n10, f.h2.s.l l10) {
        long l11;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd((long[])object))) {
            l11 = f.h1.l((long[])object, n10);
        } else {
            object = n10;
            object = (g1)l10.invoke(object);
            l11 = ((g1)object).a0();
        }
        return l11;
    }

    private static final short I2(short[] sArray) {
        return m1.h(ArraysKt___ArraysKt.qb(sArray));
    }

    public static final k I3(byte[] byArray) {
        f0.p(byArray, "$this$indices");
        return ArraysKt___ArraysKt.Cd(byArray);
    }

    private static final byte I4(byte[] object, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Cd(object);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                byte by2 = z0.l(object, n11);
                Comparable comparable = y0.b(by2);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return by2;
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    private static final double I5(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Comparable I6(byte[] object, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Comparable comparable = y0.b(by2);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Comparable comparable2 = y0.b(by3);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 > 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final int[] I7(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            c1 c12 = c1.b(n11);
            l10.invoke(c12);
        }
        return nArray;
    }

    private static final long I8(long[] object, p p10) {
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            long l10 = f.h1.l(object, n10);
            while (n11 >= 0) {
                n10 = n11 + -1;
                long l11 = f.h1.l(object, n11);
                g1 g12 = g1.b(l11);
                g1 g13 = g1.b(l10);
                g12 = (g1)p10.invoke(g12, g13);
                l10 = g12.a0();
                n11 = n10;
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List I9(long[] object, Object object2, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            object = t.k(object2);
        } else {
            int n10 = f.h1.n(object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object2);
            k k10 = ArraysKt___ArraysKt.Hd(object);
            int n11 = k10.e();
            n10 = k10.f();
            if (n11 <= n10) {
                while (true) {
                    Integer n12 = n11;
                    long l10 = f.h1.l(object, n11);
                    g1 g12 = g1.b(l10);
                    object2 = q10.invoke(n12, object2, g12);
                    arrayList.add(object2);
                    if (n11 == n10) break;
                    ++n11;
                }
            }
            object = arrayList;
        }
        return object;
    }

    public static /* synthetic */ void Ia(long[] lArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = f.h1.n(lArray);
        }
        UArraysKt___UArraysKt.Ha(lArray, n10, n11);
    }

    private static final int Ib(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Object object = g1.b(l11);
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final Iterable Ic(long[] lArray) {
        f0.p(lArray, "$this$withIndex");
        UArraysKt___UArraysKt$withIndex$2 uArraysKt___UArraysKt$withIndex$2 = new UArraysKt___UArraysKt$withIndex$2(lArray);
        j0 j02 = new j0(uArraysKt___UArraysKt$withIndex$2);
        return j02;
    }

    private static final boolean J(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final int J0(long[] lArray) {
        if (lArray == null) {
            lArray = null;
        }
        return Arrays.hashCode(lArray);
    }

    private static final byte J1(byte[] object, int n10, f.h2.s.l l10) {
        byte by2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld((byte[])object))) {
            by2 = z0.l((byte[])object, n10);
        } else {
            object = n10;
            object = (y0)l10.invoke(object);
            by2 = ((y0)object).Y();
        }
        return by2;
    }

    /*
     * WARNING - void declaration
     */
    private static final short J2(short[] object, f.h2.s.l l10) {
        for (Object object2 : object) {
            void var1_2;
            Comparable comparable = m1.b((short)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (!bl2) continue;
            return (short)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public static /* synthetic */ void J3(byte[] byArray) {
    }

    private static final long J4(long[] object, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Hd(object);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                long l11 = f.h1.l(object, n11);
                Comparable comparable = g1.b(l11);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return l11;
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    private static final float J5(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.max(f10, f11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final double J6(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final short[] J7(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            m1 m12 = m1.b(s10);
            l10.invoke(m12);
        }
        return sArray;
    }

    private static final short J8(short[] object, p p10) {
        int n10 = ArraysKt___ArraysKt.Sd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = n1.l(object, n10);
            while (n11 >= 0) {
                int n12 = n11 + -1;
                m1 m12 = m1.b(n1.l(object, n11));
                m1 m13 = m1.b((short)n10);
                m13 = (m1)p10.invoke(m12, m13);
                n10 = m13.Y();
                n11 = n12;
            }
            return (short)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List J9(int[] object, Object object2, f.h2.s.q q10) {
        boolean bl2 = d1.q(object);
        if (bl2) {
            object = t.k(object2);
        } else {
            int n10 = d1.n(object) + 1;
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            arrayList.add(object2);
            k k10 = ArraysKt___ArraysKt.Gd(object);
            int n11 = k10.e();
            n10 = k10.f();
            if (n11 <= n10) {
                while (true) {
                    Integer n12 = n11;
                    int n13 = d1.l(object, n11);
                    c1 c12 = c1.b(n13);
                    object2 = q10.invoke(n12, object2, c12);
                    arrayList.add(object2);
                    if (n11 == n10) break;
                    ++n11;
                }
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Ja(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$sort");
        c$a c$a = c.a;
        int n12 = z0.n(byArray);
        c$a.d(n10, n11, n12);
        h1.j(byArray, n10, n11);
    }

    private static final int Jb(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = m1.b(sArray[i10]);
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final Iterable Jc(short[] sArray) {
        f0.p(sArray, "$this$withIndex");
        UArraysKt___UArraysKt$withIndex$4 uArraysKt___UArraysKt$withIndex$4 = new UArraysKt___UArraysKt$withIndex$4(sArray);
        j0 j02 = new j0(uArraysKt___UArraysKt$withIndex$4);
        return j02;
    }

    private static final byte[] K(byte[] byArray) {
        return byArray;
    }

    public static final /* synthetic */ String K0(int[] nArray) {
        f0.p(nArray, "$this$contentToString");
        return UArraysKt___UArraysKt.O0(nArray);
    }

    private static final y0 K1(byte[] byArray, int n10) {
        return UArraysKt___UArraysKt.a4(byArray, n10);
    }

    public static final c1 K2(int[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        boolean bl2 = d1.q(object);
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            bl2 = false;
            string2 = null;
            int n10 = d1.l(object, 0);
            object = c1.b(n10);
        }
        return object;
    }

    public static final k K3(long[] lArray) {
        f0.p(lArray, "$this$indices");
        return ArraysKt___ArraysKt.Hd(lArray);
    }

    private static final long K4(long[] lArray) {
        return g1.h(ArraysKt___ArraysKt.Tg(lArray));
    }

    private static final Comparable K5(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Comparable comparable = c1.b(n10);
            comparable = (Comparable)l10.invoke(comparable);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Comparable comparable2 = c1.b(n13);
                    int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n14 < 0) {
                        comparable = comparable2;
                    }
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final float K6(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.min(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final byte[] K7(byte[] byArray, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            y0 y02 = y0.b(by2);
            p10.invoke(n12, y02);
        }
        return byArray;
    }

    private static final int K8(int[] object, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Pd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = d1.l(object, n10);
            while (n11 >= 0) {
                Integer n12 = n11;
                int n13 = d1.l(object, n11);
                c1 c12 = c1.b(n13);
                c1 c13 = c1.b(n10);
                c13 = (c1)q10.invoke(n12, c12, c13);
                n10 = c13.a0();
                n11 += -1;
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List K9(byte[] object, p p10) {
        boolean bl2 = z0.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            byte by2;
            Ref$ByteRef ref$ByteRef = new Ref$ByteRef();
            ref$ByteRef.element = by2 = z0.l(object, 0);
            int n10 = z0.n(object);
            ArrayList<y0> arrayList = new ArrayList<y0>(n10);
            y0 y02 = y0.b(ref$ByteRef.element);
            arrayList.add(y02);
            n10 = z0.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                byte by3;
                y0 y03 = y0.b(ref$ByteRef.element);
                byte by4 = z0.l(object, i10);
                y0 y04 = y0.b(by4);
                ref$ByteRef.element = by3 = ((y0)p10.invoke(y03, y04)).Y();
                y03 = y0.b(by3);
                arrayList.add(y03);
            }
            object = arrayList;
        }
        return object;
    }

    public static /* synthetic */ void Ka(byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = z0.n(byArray);
        }
        UArraysKt___UArraysKt.Ja(byArray, n10, n11);
    }

    private static final long Kb(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Object object = y0.b(by2);
            object = (Number)l10.invoke(object);
            long l12 = ((Number)object).longValue();
            l11 += l12;
        }
        return l11;
    }

    private static final List Kc(int[] nArray, Iterable object, p p10) {
        boolean bl2;
        int n10 = d1.n(nArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = c1.b(d1.l(nArray, n11));
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    private static final int[] L(int[] nArray) {
        return nArray;
    }

    public static final String L0(byte[] object) {
        block3: {
            block2: {
                if (object == null) break block2;
                object = object != null ? (Object)z0.c(object) : null;
                String string2 = ", ";
                String string3 = "[";
                String string4 = "]";
                int n10 = 56;
                if ((object = (Object)CollectionsKt___CollectionsKt.X2((Iterable)object, string2, string3, string4, 0, null, null, n10, null)) != null) break block3;
            }
            object = "null";
        }
        return object;
    }

    private static final m1 L1(short[] sArray, int n10) {
        return UArraysKt___UArraysKt.b4(sArray, n10);
    }

    public static final y0 L2(byte[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        boolean bl2 = z0.q(object);
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            bl2 = false;
            string2 = null;
            byte by2 = z0.l(object, 0);
            object = y0.b(by2);
        }
        return object;
    }

    public static /* synthetic */ void L3(long[] lArray) {
    }

    private static final int L4(int[] object, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Gd(object);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                int n12 = d1.l(object, n11);
                Comparable comparable = c1.b(n12);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return n12;
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    private static final double L5(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Comparable L6(long[] object, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Comparable comparable = g1.b(l11);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Comparable comparable2 = g1.b(l12);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 > 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final int[] L7(int[] nArray, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            c1 c12 = c1.b(n12);
            p10.invoke(n13, c12);
        }
        return nArray;
    }

    private static final byte L8(byte[] object, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Ld(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = z0.l(object, n10);
            while (n11 >= 0) {
                Integer n12 = n11;
                byte by2 = z0.l(object, n11);
                y0 y02 = y0.b(by2);
                y0 y03 = y0.b((byte)n10);
                y03 = (y0)q10.invoke(n12, y02, y03);
                n10 = y03.Y();
                n11 += -1;
            }
            return (byte)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List L9(int[] object, p p10) {
        boolean bl2 = d1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            int n10;
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = n10 = d1.l(object, 0);
            int n11 = d1.n(object);
            ArrayList<c1> arrayList = new ArrayList<c1>(n11);
            c1 c12 = c1.b(ref$IntRef.element);
            arrayList.add(c12);
            n11 = d1.n(object);
            for (int i10 = 1; i10 < n11; ++i10) {
                int n12;
                c1 c13 = c1.b(ref$IntRef.element);
                int n13 = d1.l(object, i10);
                c1 c14 = c1.b(n13);
                ref$IntRef.element = n12 = ((c1)p10.invoke(c13, c14)).a0();
                c13 = c1.b(n12);
                arrayList.add(c13);
            }
            object = arrayList;
        }
        return object;
    }

    public static final void La(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$sort");
        c$a c$a = c.a;
        int n12 = n1.n(sArray);
        c$a.d(n10, n11, n12);
        h1.k(sArray, n10, n11);
    }

    private static final long Lb(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Object object = c1.b(n11);
            object = (Number)l10.invoke(object);
            long l12 = ((Number)object).longValue();
            l11 += l12;
        }
        return l11;
    }

    private static final List Lc(long[] lArray, Object[] objectArray, p p10) {
        int n10 = f.h1.n(lArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = f.h1.l(lArray, i10);
            Object object = g1.b(l10);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final long[] M(long[] lArray) {
        return lArray;
    }

    public static final /* synthetic */ String M0(byte[] byArray) {
        f0.p(byArray, "$this$contentToString");
        return UArraysKt___UArraysKt.L0(byArray);
    }

    private static final c1 M1(int[] nArray, int n10) {
        return UArraysKt___UArraysKt.c4(nArray, n10);
    }

    private static final y0 M2(byte[] byArray, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return y0.b(by2);
        }
        return null;
    }

    public static final k M3(short[] sArray) {
        f0.p(sArray, "$this$indices");
        return ArraysKt___ArraysKt.Jd(sArray);
    }

    private static final short M4(short[] sArray) {
        return m1.h(ArraysKt___ArraysKt.Xg(sArray));
    }

    private static final float M5(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.max(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final double M6(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final long[] M7(long[] lArray, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            g1 g12 = g1.b(l10);
            p10.invoke(n12, g12);
        }
        return lArray;
    }

    private static final short M8(short[] object, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Sd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = n1.l(object, n10);
            while (n11 >= 0) {
                Integer n12 = n11;
                short s10 = n1.l(object, n11);
                m1 m12 = m1.b(s10);
                m1 m13 = m1.b((short)n10);
                m13 = (m1)q10.invoke(n12, m12, m13);
                n10 = m13.Y();
                n11 += -1;
            }
            return (short)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List M9(long[] object, p p10) {
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            long l10;
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = l10 = f.h1.l(object, 0);
            int n10 = f.h1.n(object);
            ArrayList<g1> arrayList = new ArrayList<g1>(n10);
            long l11 = ref$LongRef.element;
            g1 g12 = g1.b(l11);
            arrayList.add(g12);
            n10 = f.h1.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                long l12;
                g1 g13 = g1.b(ref$LongRef.element);
                long l13 = f.h1.l(object, i10);
                g1 g14 = g1.b(l13);
                ref$LongRef.element = l12 = ((g1)p10.invoke(g13, g14)).a0();
                g13 = g1.b(l12);
                arrayList.add(g13);
            }
            object = arrayList;
        }
        return object;
    }

    public static /* synthetic */ void Ma(short[] sArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = n1.n(sArray);
        }
        UArraysKt___UArraysKt.La(sArray, n10, n11);
    }

    private static final long Mb(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = g1.b(lArray[i10]);
            object = (Number)l10.invoke(object);
            long l12 = ((Number)object).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Mc(int[] nArray, Object[] objectArray) {
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = d1.n(nArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = d1.l(nArray, i10);
            Object object = objectArray[i10];
            Pair pair = w0.a(c1.b(n12), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    private static final short[] N(short[] sArray) {
        return sArray;
    }

    public static final /* synthetic */ String N0(long[] lArray) {
        f0.p(lArray, "$this$contentToString");
        return UArraysKt___UArraysKt.R0(lArray);
    }

    private static final g1 N1(long[] lArray, int n10) {
        return UArraysKt___UArraysKt.d4(lArray, n10);
    }

    private static final g1 N2(long[] lArray, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return g1.b(l11);
        }
        return null;
    }

    public static /* synthetic */ void N3(short[] sArray) {
    }

    private static final short N4(short[] object, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Jd(object);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                short s10 = n1.l(object, n11);
                Comparable comparable = m1.b(s10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return s10;
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    private static final Comparable N5(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Comparable comparable = m1.b(s10);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Comparable comparable2 = m1.b(s11);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 < 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final float N6(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.min(f10, f11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final short[] N7(short[] sArray, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            m1 m12 = m1.b(s10);
            p10.invoke(n12, m12);
        }
        return sArray;
    }

    private static final long N8(long[] object, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 >= 0) {
            long l10 = f.h1.l(object, n10);
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                Comparable<Integer> comparable = i10;
                long l11 = f.h1.l(object, i10);
                g1 g12 = g1.b(l11);
                g1 g13 = g1.b(l10);
                comparable = (g1)q10.invoke(comparable, g12, g13);
                l10 = ((g1)comparable).a0();
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List N9(short[] object, p p10) {
        boolean bl2 = n1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            short s10;
            Ref$ShortRef ref$ShortRef = new Ref$ShortRef();
            ref$ShortRef.element = s10 = n1.l(object, 0);
            int n10 = n1.n(object);
            ArrayList<m1> arrayList = new ArrayList<m1>(n10);
            m1 m12 = m1.b(ref$ShortRef.element);
            arrayList.add(m12);
            n10 = n1.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                short s11;
                m1 m13 = m1.b(ref$ShortRef.element);
                short s12 = n1.l(object, i10);
                m1 m14 = m1.b(s12);
                ref$ShortRef.element = s11 = ((m1)p10.invoke(m13, m14)).Y();
                m13 = m1.b(s11);
                arrayList.add(m13);
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Na(byte[] byArray) {
        String string2 = "$this$sort";
        f0.p(byArray, string2);
        int n10 = z0.n(byArray);
        int n11 = 1;
        if (n10 > n11) {
            n10 = 0;
            string2 = null;
            n11 = z0.n(byArray);
            h1.j(byArray, 0, n11);
        }
    }

    private static final long Nb(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Object object = m1.b(s10);
            object = (Number)l10.invoke(object);
            long l12 = ((Number)object).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Nc(long[] lArray, Iterable object) {
        boolean bl2;
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = f.h1.n(lArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            long l10 = f.h1.l(lArray, n11);
            pair = w0.a(g1.b(l10), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    private static final byte[] O(byte[] byArray) {
        return z0.f(byArray);
    }

    public static final String O0(int[] object) {
        block3: {
            block2: {
                if (object == null) break block2;
                object = object != null ? (Object)d1.c(object) : null;
                String string2 = ", ";
                String string3 = "[";
                String string4 = "]";
                int n10 = 56;
                if ((object = (Object)CollectionsKt___CollectionsKt.X2((Iterable)object, string2, string3, string4, 0, null, null, n10, null)) != null) break block3;
            }
            object = "null";
        }
        return object;
    }

    public static final void O1(int[] nArray, int n10, int n11, int n12) {
        f0.p(nArray, "$this$fill");
        n.l2(nArray, n10, n11, n12);
    }

    public static final g1 O2(long[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            object = null;
        } else {
            bl2 = false;
            string2 = null;
            long l10 = f.h1.l(object, 0);
            object = g1.b(l10);
        }
        return object;
    }

    public static final int O3(int[] nArray) {
        f0.p(nArray, "$this$lastIndex");
        return ArraysKt___ArraysKt.Pd(nArray);
    }

    private static final int O4(long[] lArray, long l10) {
        return ArraysKt___ArraysKt.gh(lArray, l10);
    }

    private static final Comparable O5(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Comparable comparable = y0.b(by2);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Comparable comparable2 = y0.b(by3);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    private static final Comparable O6(int[] object, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Comparable comparable = c1.b(n10);
            comparable = (Comparable)l10.invoke(comparable);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Comparable comparable2 = c1.b(n13);
                    int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n14 > 0) {
                        comparable = comparable2;
                    }
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final long[] O7(long[] lArray, long l10) {
        f0.p(lArray, "$this$plus");
        return f.h1.f(n.Q2(lArray, l10));
    }

    private static final c1 O8(int[] nArray, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = d1.l(nArray, n10);
        while (n11 >= 0) {
            Integer n12 = n11;
            int n13 = d1.l(nArray, n11);
            c1 c12 = c1.b(n13);
            c1 c13 = c1.b(n10);
            c13 = (c1)q10.invoke(n12, c12, c13);
            n10 = c13.a0();
            n11 += -1;
        }
        return c1.b(n10);
    }

    private static final List O9(int[] object, f.h2.s.q q10) {
        boolean bl2 = d1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            int n10;
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = n10 = d1.l(object, 0);
            int n11 = d1.n(object);
            ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n11);
            c1 c12 = c1.b(ref$IntRef.element);
            arrayList.add(c12);
            n11 = d1.n(object);
            for (int i10 = 1; i10 < n11; ++i10) {
                int n12;
                Comparable<Integer> comparable = i10;
                int n13 = ref$IntRef.element;
                c1 c13 = c1.b(n13);
                int n14 = d1.l(object, i10);
                c1 c14 = c1.b(n14);
                ref$IntRef.element = n12 = ((c1)q10.invoke(comparable, c13, c14)).a0();
                comparable = c1.b(n12);
                arrayList.add(comparable);
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Oa(long[] lArray) {
        String string2 = "$this$sort";
        f0.p(lArray, string2);
        int n10 = f.h1.n(lArray);
        int n11 = 1;
        if (n10 > n11) {
            n10 = 0;
            string2 = null;
            n11 = f.h1.n(lArray);
            h1.i(lArray, 0, n11);
        }
    }

    public static final int Ob(y0[] y0Array) {
        String string2 = "$this$sum";
        f0.p(y0Array, string2);
        int n10 = y0Array.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            y0 y02 = y0Array[i10];
            int n12 = c1.h(y02.Y() & 0xFF);
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    public static final List Oc(int[] nArray, Iterable object) {
        boolean bl2;
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = d1.n(nArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(c1.b(d1.l(nArray, n11)), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    private static final int[] P(int[] nArray) {
        return d1.f(nArray);
    }

    public static final String P0(short[] object) {
        block3: {
            block2: {
                if (object == null) break block2;
                object = object != null ? (Object)n1.c(object) : null;
                String string2 = ", ";
                String string3 = "[";
                String string4 = "]";
                int n10 = 56;
                if ((object = (Object)CollectionsKt___CollectionsKt.X2((Iterable)object, string2, string3, string4, 0, null, null, n10, null)) != null) break block3;
            }
            object = "null";
        }
        return object;
    }

    public static /* synthetic */ void P1(int[] nArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n11 = 0;
        }
        if ((n13 &= 4) != 0) {
            n12 = d1.n(nArray);
        }
        UArraysKt___UArraysKt.O1(nArray, n10, n11, n12);
    }

    private static final c1 P2(int[] nArray, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return c1.b(n10);
        }
        return null;
    }

    public static /* synthetic */ void P3(int[] nArray) {
    }

    private static final int P4(short[] sArray, short s10) {
        return ArraysKt___ArraysKt.ih(sArray, s10);
    }

    private static final Double P5(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    private static final double P6(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    object3 = (Number)l10.invoke(object3);
                    double d11 = ((Number)object3).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final int[] P7(int[] nArray, Collection object) {
        f0.p(nArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = d1.n(nArray);
        int n11 = d1.n(nArray);
        int n12 = object.size();
        nArray = Arrays.copyOf(nArray, n11 += n12);
        Object object2 = "java.util.Arrays.copyOf(this, newSize)";
        f0.o(nArray, (String)object2);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (c1)object.next();
            n11 = ((c1)object2).a0();
            n12 = n10 + 1;
            nArray[n10] = n11;
            n10 = n12;
        }
        return d1.f(nArray);
    }

    private static final y0 P8(byte[] byArray, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = z0.l(byArray, n10);
        while (n11 >= 0) {
            Integer n12 = n11;
            byte by2 = z0.l(byArray, n11);
            y0 y02 = y0.b(by2);
            y0 y03 = y0.b((byte)n10);
            y03 = (y0)q10.invoke(n12, y02, y03);
            n10 = y03.Y();
            n11 += -1;
        }
        return y0.b((byte)n10);
    }

    private static final List P9(byte[] object, f.h2.s.q q10) {
        boolean bl2 = z0.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            byte by2;
            Ref$ByteRef ref$ByteRef = new Ref$ByteRef();
            ref$ByteRef.element = by2 = z0.l(object, 0);
            int n10 = z0.n(object);
            ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
            y0 y02 = y0.b(ref$ByteRef.element);
            arrayList.add(y02);
            n10 = z0.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                byte by3;
                Comparable<Integer> comparable = i10;
                byte by4 = ref$ByteRef.element;
                y0 y03 = y0.b(by4);
                byte by5 = z0.l(object, i10);
                y0 y04 = y0.b(by5);
                ref$ByteRef.element = by3 = ((y0)q10.invoke(comparable, y03, y04)).Y();
                comparable = y0.b(by3);
                arrayList.add(comparable);
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Pa(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$sort");
        c$a c$a = c.a;
        int n12 = d1.n(nArray);
        c$a.d(n10, n11, n12);
        h1.l(nArray, n10, n11);
    }

    private static final int Pb(byte[] byArray, f.h2.s.l l10) {
        int n10 = c1.h(0);
        int n11 = byArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            comparable = (c1)l10.invoke(comparable);
            int n12 = ((c1)comparable).a0();
            n10 = c1.h(n10 + n12);
        }
        return n10;
    }

    private static final List Pc(byte[] byArray, byte[] byArray2, p p10) {
        int n10 = z0.n(byArray);
        int n11 = z0.n(byArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = z0.l(byArray, i10);
            Object object = y0.b(by2);
            byte by3 = z0.l(byArray2, i10);
            y0 y02 = y0.b(by3);
            object = p10.invoke(object, y02);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final long[] Q(long[] lArray) {
        return f.h1.f(lArray);
    }

    public static final /* synthetic */ String Q0(short[] sArray) {
        f0.p(sArray, "$this$contentToString");
        return UArraysKt___UArraysKt.P0(sArray);
    }

    public static final void Q1(short[] sArray, short s10, int n10, int n11) {
        f0.p(sArray, "$this$fill");
        n.o2(sArray, s10, n10, n11);
    }

    public static final m1 Q2(short[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        boolean bl2 = n1.q(object);
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            bl2 = false;
            string2 = null;
            short s10 = n1.l(object, 0);
            object = m1.b(s10);
        }
        return object;
    }

    public static final int Q3(byte[] byArray) {
        f0.p(byArray, "$this$lastIndex");
        return ArraysKt___ArraysKt.Ld(byArray);
    }

    private static final int Q4(byte[] byArray, byte by2) {
        return ArraysKt___ArraysKt.bh(byArray, by2);
    }

    private static final Float Q5(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.max(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    private static final float Q6(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    object3 = (Number)l10.invoke(object3);
                    float f11 = ((Number)object3).floatValue();
                    f10 = Math.min(f10, f11);
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final short[] Q7(short[] sArray, short s10) {
        f0.p(sArray, "$this$plus");
        return n1.f(n.X2(sArray, s10));
    }

    private static final m1 Q8(short[] sArray, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = n1.l(sArray, n10);
        while (n11 >= 0) {
            Integer n12 = n11;
            short s10 = n1.l(sArray, n11);
            m1 m12 = m1.b(s10);
            m1 m13 = m1.b((short)n10);
            m13 = (m1)q10.invoke(n12, m12, m13);
            n10 = m13.Y();
            n11 += -1;
        }
        return m1.b((short)n10);
    }

    private static final List Q9(short[] object, f.h2.s.q q10) {
        boolean bl2 = n1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            short s10;
            Ref$ShortRef ref$ShortRef = new Ref$ShortRef();
            ref$ShortRef.element = s10 = n1.l(object, 0);
            int n10 = n1.n(object);
            ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
            m1 m12 = m1.b(ref$ShortRef.element);
            arrayList.add(m12);
            n10 = n1.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                short s11;
                Comparable<Integer> comparable = i10;
                short s12 = ref$ShortRef.element;
                m1 m13 = m1.b(s12);
                short s13 = n1.l(object, i10);
                m1 m14 = m1.b(s13);
                ref$ShortRef.element = s11 = ((m1)q10.invoke(comparable, m13, m14)).Y();
                comparable = m1.b(s11);
                arrayList.add(comparable);
            }
            object = arrayList;
        }
        return object;
    }

    public static /* synthetic */ void Qa(int[] nArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = d1.n(nArray);
        }
        UArraysKt___UArraysKt.Pa(nArray, n10, n11);
    }

    private static final int Qb(int[] nArray, f.h2.s.l l10) {
        int n10 = c1.h(0);
        int n11 = nArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            c1 c12 = c1.b(nArray[i10]);
            c12 = (c1)l10.invoke(c12);
            int n12 = c12.a0();
            n10 = c1.h(n10 + n12);
        }
        return n10;
    }

    public static final List Qc(short[] sArray, Iterable object) {
        boolean bl2;
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = n1.n(sArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(m1.b(n1.l(sArray, n11)), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    private static final short[] R(short[] sArray) {
        return n1.f(sArray);
    }

    public static final String R0(long[] object) {
        block3: {
            block2: {
                if (object == null) break block2;
                object = object != null ? (Object)f.h1.c(object) : null;
                String string2 = ", ";
                String string3 = "[";
                String string4 = "]";
                int n10 = 56;
                if ((object = (Object)CollectionsKt___CollectionsKt.X2((Iterable)object, string2, string3, string4, 0, null, null, n10, null)) != null) break block3;
            }
            object = "null";
        }
        return object;
    }

    public static /* synthetic */ void R1(short[] sArray, short s10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = n1.n(sArray);
        }
        UArraysKt___UArraysKt.Q1(sArray, s10, n10, n11);
    }

    private static final m1 R2(short[] sArray, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return m1.b(s10);
        }
        return null;
    }

    public static /* synthetic */ void R3(byte[] byArray) {
    }

    private static final int R4(int[] nArray, int n10) {
        return ArraysKt___ArraysKt.fh(nArray, n10);
    }

    private static final Comparable R5(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Comparable comparable = g1.b(l11);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Comparable comparable2 = g1.b(l12);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    private static final Comparable R6(short[] object, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Comparable comparable = m1.b(s10);
            comparable = (Comparable)l10.invoke(comparable);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Comparable comparable2 = m1.b(s11);
                    int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                    if (n12 > 0) {
                        comparable = comparable2;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final int[] R7(int[] nArray, int[] nArray2) {
        f0.p(nArray, "$this$plus");
        return d1.f(n.P2(nArray, nArray2));
    }

    private static final g1 R8(long[] lArray, f.h2.s.q q10) {
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 < 0) {
            return null;
        }
        long l10 = f.h1.l(lArray, n10);
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            Comparable<Integer> comparable = i10;
            long l11 = f.h1.l(lArray, i10);
            g1 g12 = g1.b(l11);
            g1 g13 = g1.b(l10);
            comparable = (g1)q10.invoke(comparable, g12, g13);
            l10 = ((g1)comparable).a0();
        }
        return g1.b(l10);
    }

    private static final List R9(long[] object, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            long l10;
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = l10 = f.h1.l(object, 0);
            int n10 = f.h1.n(object);
            ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
            long l11 = ref$LongRef.element;
            g1 g12 = g1.b(l11);
            arrayList.add(g12);
            n10 = f.h1.n(object);
            for (int i10 = 1; i10 < n10; ++i10) {
                long l12;
                Comparable<Integer> comparable = i10;
                long l13 = ref$LongRef.element;
                g1 g13 = g1.b(l13);
                long l14 = f.h1.l(object, i10);
                g1 g14 = g1.b(l14);
                ref$LongRef.element = l12 = ((g1)q10.invoke(comparable, g13, g14)).a0();
                comparable = g1.b(l12);
                arrayList.add(comparable);
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Ra(short[] sArray) {
        String string2 = "$this$sort";
        f0.p(sArray, string2);
        int n10 = n1.n(sArray);
        int n11 = 1;
        if (n10 > n11) {
            n10 = 0;
            string2 = null;
            n11 = n1.n(sArray);
            h1.k(sArray, 0, n11);
        }
    }

    private static final int Rb(long[] lArray, f.h2.s.l l10) {
        int n10 = c1.h(0);
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            comparable = (c1)l10.invoke(comparable);
            int n11 = ((c1)comparable).a0();
            n10 = c1.h(n10 + n11);
        }
        return n10;
    }

    public static final List Rc(byte[] byArray, Iterable object) {
        boolean bl2;
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = z0.n(byArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(y0.b(z0.l(byArray, n11)), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    private static final Map S(byte[] byArray, f.h2.s.l l10) {
        int n10 = q.n(s0.j(z0.n(byArray)), 16);
        LinkedHashMap<y0, Object> linkedHashMap = new LinkedHashMap<y0, Object>(n10);
        for (byte by2 : byArray) {
            y0 y02 = y0.b(by2);
            Object object = y0.b(by2);
            object = l10.invoke(object);
            linkedHashMap.put(y02, object);
        }
        return linkedHashMap;
    }

    private static final long[] S0(long[] lArray, long[] lArray2, int n10, int n11, int n12) {
        n.b1(lArray, lArray2, n10, n11, n12);
        return lArray2;
    }

    public static final void S1(long[] lArray, long l10, int n10, int n11) {
        f0.p(lArray, "$this$fill");
        n.m2(lArray, l10, n10, n11);
    }

    private static final List S2(byte[] byArray, f.h2.s.l l10) {
        ArrayList arrayList = new ArrayList();
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final int S3(long[] lArray) {
        f0.p(lArray, "$this$lastIndex");
        return ArraysKt___ArraysKt.Qd(lArray);
    }

    public static final c1 S4(int[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = d1.q(object);
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = d1.n(object) + -1;
            int n11 = d1.l(object, n10);
            object = c1.b(n11);
        }
        return object;
    }

    private static final Double S5(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    private static final Comparable S6(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Comparable comparable = y0.b(by2);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Comparable comparable2 = y0.b(by3);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    private static final byte[] S7(byte[] byArray, byte by2) {
        f0.p(byArray, "$this$plus");
        return z0.f(n.B2(byArray, by2));
    }

    private static final y0 S8(byte[] byArray, p p10) {
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = z0.l(byArray, n10);
        while (n11 >= 0) {
            int n12 = n11 + -1;
            y0 y02 = y0.b(z0.l(byArray, n11));
            y0 y03 = y0.b((byte)n10);
            y03 = (y0)p10.invoke(y02, y03);
            n10 = y03.Y();
            n11 = n12;
        }
        return y0.b((byte)n10);
    }

    public static final void S9(int[] nArray) {
        f0.p(nArray, "$this$shuffle");
        e$a e$a = e.b;
        UArraysKt___UArraysKt.T9(nArray, e$a);
    }

    public static final void Sa(int[] nArray) {
        String string2 = "$this$sortDescending";
        f0.p(nArray, string2);
        int n10 = d1.n(nArray);
        int n11 = 1;
        if (n10 > n11) {
            UArraysKt___UArraysKt.Ga(nArray);
            ArraysKt___ArraysKt.sq(nArray);
        }
    }

    public static final int Sb(c1[] c1Array) {
        String string2 = "$this$sum";
        f0.p(c1Array, string2);
        int n10 = c1Array.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            c1 c12 = c1Array[i10];
            int n12 = c12.a0();
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    private static final List Sc(int[] nArray, int[] nArray2, p p10) {
        int n10 = d1.n(nArray);
        int n11 = d1.n(nArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = d1.l(nArray, i10);
            Object object = c1.b(n12);
            int n13 = d1.l(nArray2, i10);
            c1 c12 = c1.b(n13);
            object = p10.invoke(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map T(long[] lArray, f.h2.s.l l10) {
        int n10 = q.n(s0.j(f.h1.n(lArray)), 16);
        LinkedHashMap<g1, Object> linkedHashMap = new LinkedHashMap<g1, Object>(n10);
        for (long l11 : lArray) {
            g1 g12 = g1.b(l11);
            Object object = g1.b(l11);
            object = l10.invoke(object);
            linkedHashMap.put(g12, object);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ long[] T0(long[] lArray, long[] lArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = f.h1.n(lArray);
        }
        n.b1(lArray, lArray2, n10, n11, n12);
        return lArray2;
    }

    public static /* synthetic */ void T1(long[] lArray, long l10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = f.h1.n(lArray);
        }
        UArraysKt___UArraysKt.S1(lArray, l10, n10, n11);
    }

    private static final List T2(long[] lArray, f.h2.s.l l10) {
        ArrayList arrayList = new ArrayList();
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static /* synthetic */ void T3(long[] lArray) {
    }

    public static final y0 T4(byte[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = z0.q(object);
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = z0.n(object) + -1;
            byte by2 = z0.l(object, n10);
            object = y0.b(by2);
        }
        return object;
    }

    private static final Float T5(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.max(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Double T6(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    private static final byte[] T7(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "$this$plus");
        return z0.f(n.D2(byArray, byArray2));
    }

    private static final c1 T8(int[] nArray, p p10) {
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = d1.l(nArray, n10);
        while (n11 >= 0) {
            int n12 = n11 + -1;
            c1 c12 = c1.b(d1.l(nArray, n11));
            c1 c13 = c1.b(n10);
            c13 = (c1)p10.invoke(c12, c13);
            n10 = c13.a0();
            n11 = n12;
        }
        return c1.b(n10);
    }

    public static final void T9(int[] nArray, e e10) {
        int n10;
        f0.p(nArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= (n10 = 1); i10 += -1) {
            n10 = i10 + 1;
            n10 = e10.m(n10);
            int n11 = d1.l(nArray, i10);
            int n12 = d1.l(nArray, n10);
            d1.t(nArray, i10, n12);
            d1.t(nArray, n10, n11);
        }
    }

    public static final void Ta(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$sortDescending");
        UArraysKt___UArraysKt.Ha(lArray, n10, n11);
        ArraysKt___ArraysKt.vq(lArray, n10, n11);
    }

    private static final int Tb(short[] sArray, f.h2.s.l l10) {
        int n10 = c1.h(0);
        int n11 = sArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            comparable = (c1)l10.invoke(comparable);
            int n12 = ((c1)comparable).a0();
            n10 = c1.h(n10 + n12);
        }
        return n10;
    }

    private static final List Tc(byte[] byArray, Object[] objectArray, p p10) {
        int n10 = z0.n(byArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = z0.l(byArray, i10);
            Object object = y0.b(by2);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map U(int[] nArray, f.h2.s.l l10) {
        int n10 = q.n(s0.j(d1.n(nArray)), 16);
        LinkedHashMap<c1, Object> linkedHashMap = new LinkedHashMap<c1, Object>(n10);
        for (int n11 : nArray) {
            c1 c12 = c1.b(n11);
            Object object = c1.b(n11);
            object = l10.invoke(object);
            linkedHashMap.put(c12, object);
        }
        return linkedHashMap;
    }

    private static final short[] U0(short[] sArray, short[] sArray2, int n10, int n11, int n12) {
        n.d1(sArray, sArray2, n10, n11, n12);
        return sArray2;
    }

    public static final void U1(byte[] byArray, byte by2, int n10, int n11) {
        f0.p(byArray, "$this$fill");
        n.h2(byArray, by2, n10, n11);
    }

    private static final List U2(int[] nArray, f.h2.s.l l10) {
        ArrayList arrayList = new ArrayList();
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final int U3(short[] sArray) {
        f0.p(sArray, "$this$lastIndex");
        return ArraysKt___ArraysKt.Sd(sArray);
    }

    private static final y0 U4(byte[] byArray, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Cd(byArray);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                byte by2 = z0.l(byArray, n11);
                Comparable comparable = y0.b(by2);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return y0.b(by2);
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        return null;
    }

    private static final Comparable U5(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Comparable comparable = c1.b(n10);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Comparable comparable2 = c1.b(n13);
                int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n14 < 0) {
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return comparable;
    }

    private static final Float U6(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.min(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    public static final long[] U7(long[] lArray, Collection object) {
        f0.p(lArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = f.h1.n(lArray);
        int n11 = f.h1.n(lArray);
        int n12 = object.size();
        lArray = Arrays.copyOf(lArray, n11 += n12);
        Object object2 = "java.util.Arrays.copyOf(this, newSize)";
        f0.o(lArray, (String)object2);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (g1)object.next();
            long l10 = ((g1)object2).a0();
            int n13 = n10 + 1;
            lArray[n10] = l10;
            n10 = n13;
        }
        return f.h1.f(lArray);
    }

    private static final g1 U8(long[] lArray, p p10) {
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        long l10 = f.h1.l(lArray, n10);
        while (n11 >= 0) {
            n10 = n11 + -1;
            long l11 = f.h1.l(lArray, n11);
            g1 g12 = g1.b(l11);
            g1 g13 = g1.b(l10);
            g12 = (g1)p10.invoke(g12, g13);
            l10 = g12.a0();
            n11 = n10;
        }
        return g1.b(l10);
    }

    public static final void U9(byte[] byArray) {
        f0.p(byArray, "$this$shuffle");
        e$a e$a = e.b;
        UArraysKt___UArraysKt.X9(byArray, e$a);
    }

    public static final void Ua(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$sortDescending");
        UArraysKt___UArraysKt.Ja(byArray, n10, n11);
        ArraysKt___ArraysKt.lq(byArray, n10, n11);
    }

    private static final long Ub(byte[] byArray, f.h2.s.l l10) {
        long l11 = g1.h(0);
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    private static final List Uc(long[] lArray, long[] lArray2, p p10) {
        int n10 = f.h1.n(lArray);
        int n11 = f.h1.n(lArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = f.h1.l(lArray, i10);
            Object object = g1.b(l10);
            long l11 = f.h1.l(lArray2, i10);
            g1 g12 = g1.b(l11);
            object = p10.invoke(object, g12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map V(short[] sArray, f.h2.s.l l10) {
        int n10 = q.n(s0.j(n1.n(sArray)), 16);
        LinkedHashMap<m1, Object> linkedHashMap = new LinkedHashMap<m1, Object>(n10);
        for (short s10 : sArray) {
            m1 m12 = m1.b(s10);
            Object object = m1.b(s10);
            object = l10.invoke(object);
            linkedHashMap.put(m12, object);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ short[] V0(short[] sArray, short[] sArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = n1.n(sArray);
        }
        n.d1(sArray, sArray2, n10, n11, n12);
        return sArray2;
    }

    public static /* synthetic */ void V1(byte[] byArray, byte by2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = z0.n(byArray);
        }
        UArraysKt___UArraysKt.U1(byArray, by2, n10, n11);
    }

    private static final List V2(short[] sArray, f.h2.s.l l10) {
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static /* synthetic */ void V3(short[] sArray) {
    }

    private static final g1 V4(long[] lArray, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Hd(lArray);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                long l11 = f.h1.l(lArray, n11);
                Comparable comparable = g1.b(l11);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return g1.b(l11);
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        return null;
    }

    private static final Double V5(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final Comparable V6(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Comparable comparable = g1.b(l11);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Comparable comparable2 = g1.b(l12);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    private static final short[] V7(short[] sArray, short[] sArray2) {
        f0.p(sArray, "$this$plus");
        return n1.f(n.Y2(sArray, sArray2));
    }

    private static final m1 V8(short[] sArray, p p10) {
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = n1.l(sArray, n10);
        while (n11 >= 0) {
            int n12 = n11 + -1;
            m1 m12 = m1.b(n1.l(sArray, n11));
            m1 m13 = m1.b((short)n10);
            m13 = (m1)p10.invoke(m12, m13);
            n10 = m13.Y();
            n11 = n12;
        }
        return m1.b((short)n10);
    }

    public static final void V9(long[] lArray, e e10) {
        int n10;
        f0.p(lArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= (n10 = 1); i10 += -1) {
            n10 = i10 + 1;
            n10 = e10.m(n10);
            long l10 = f.h1.l(lArray, i10);
            long l11 = f.h1.l(lArray, n10);
            f.h1.t(lArray, i10, l11);
            f.h1.t(lArray, n10, l10);
        }
    }

    public static final void Va(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$sortDescending");
        UArraysKt___UArraysKt.La(sArray, n10, n11);
        ArraysKt___ArraysKt.zq(sArray, n10, n11);
    }

    private static final long Vb(int[] nArray, f.h2.s.l l10) {
        long l11 = g1.h(0);
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    private static final List Vc(long[] lArray, Iterable object, p p10) {
        boolean bl2;
        int n10 = f.h1.n(lArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            long l10 = f.h1.l(lArray, n11);
            object2 = g1.b(l10);
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    private static final Map W(int[] nArray, Map map, f.h2.s.l l10) {
        for (int n10 : nArray) {
            c1 c12 = c1.b(n10);
            Object object = c1.b(n10);
            object = l10.invoke(object);
            map.put(c12, object);
        }
        return map;
    }

    private static final byte[] W0(byte[] byArray, byte[] byArray2, int n10, int n11, int n12) {
        n.W0(byArray, byArray2, n10, n11, n12);
        return byArray2;
    }

    private static final List W1(byte[] byArray, f.h2.s.l l10) {
        ArrayList<y0> arrayList = new ArrayList<y0>();
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            y0 y02 = y0.b(by2);
            arrayList.add(y02);
        }
        return arrayList;
    }

    private static final List W2(byte[] byArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = y0.b(by2);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final short W3(short[] object, int n10, f.h2.s.l l10) {
        short s10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd((short[])object))) {
            s10 = n1.l((short[])object, n10);
        } else {
            object = n10;
            object = (m1)l10.invoke(object);
            s10 = ((m1)object).Y();
        }
        return s10;
    }

    public static final g1 W4(long[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = f.h1.q(object);
        if (n10 != 0) {
            object = null;
        } else {
            n10 = f.h1.n(object) + -1;
            long l10 = f.h1.l(object, n10);
            object = g1.b(l10);
        }
        return object;
    }

    private static final Float W5(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.max(f10, f11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Double W6(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    public static final short[] W7(short[] sArray, Collection object) {
        f0.p(sArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = n1.n(sArray);
        int n11 = n1.n(sArray);
        int n12 = object.size();
        sArray = Arrays.copyOf(sArray, n11 += n12);
        Object object2 = "java.util.Arrays.copyOf(this, newSize)";
        f0.o(sArray, (String)object2);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (m1)object.next();
            n11 = ((m1)object2).Y();
            n12 = n10 + 1;
            sArray[n10] = n11;
            n10 = n12;
        }
        return n1.f(sArray);
    }

    private static final void W8(int[] nArray) {
        ArraysKt___ArraysKt.sq(nArray);
    }

    public static final void W9(long[] lArray) {
        f0.p(lArray, "$this$shuffle");
        e$a e$a = e.b;
        UArraysKt___UArraysKt.V9(lArray, e$a);
    }

    public static final void Wa(byte[] byArray) {
        String string2 = "$this$sortDescending";
        f0.p(byArray, string2);
        int n10 = z0.n(byArray);
        int n11 = 1;
        if (n10 > n11) {
            UArraysKt___UArraysKt.Na(byArray);
            ArraysKt___ArraysKt.kq(byArray);
        }
    }

    private static final long Wb(long[] lArray, f.h2.s.l l10) {
        long l11 = g1.h(0);
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g1 g12 = g1.b(lArray[i10]);
            g12 = (g1)l10.invoke(g12);
            long l12 = g12.a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    private static final List Wc(byte[] byArray, Iterable object, p p10) {
        boolean bl2;
        int n10 = z0.n(byArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = y0.b(z0.l(byArray, n11));
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    private static final Map X(byte[] byArray, Map map, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            y0 y02 = y0.b(by2);
            Object object = y0.b(by2);
            object = l10.invoke(object);
            map.put(y02, object);
        }
        return map;
    }

    public static /* synthetic */ byte[] X0(byte[] byArray, byte[] byArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = z0.n(byArray);
        }
        n.W0(byArray, byArray2, n10, n11, n12);
        return byArray2;
    }

    private static final List X1(long[] lArray, f.h2.s.l l10) {
        ArrayList<g1> arrayList = new ArrayList<g1>();
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            g1 g12 = g1.b(l11);
            arrayList.add(g12);
        }
        return arrayList;
    }

    private static final List X2(int[] nArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = c1.b(n12);
            object = (Iterable)p10.invoke(n13, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final int X3(int[] object, int n10, f.h2.s.l l10) {
        int n11;
        int n12;
        if (n10 >= 0 && n10 <= (n12 = ArraysKt___ArraysKt.Pd((int[])object))) {
            n11 = d1.l((int[])object, n10);
        } else {
            object = n10;
            object = (c1)l10.invoke(object);
            n11 = ((c1)object).a0();
        }
        return n11;
    }

    private static final c1 X4(int[] nArray, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Gd(nArray);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                int n12 = d1.l(nArray, n11);
                Comparable comparable = c1.b(n12);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return c1.b(n12);
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        return null;
    }

    private static final Comparable X5(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Comparable comparable = m1.b(s10);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Comparable comparable2 = m1.b(s11);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    private static final Float X6(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.min(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    private static final int[] X7(int[] nArray, int n10) {
        f0.p(nArray, "$this$plus");
        return d1.f(n.N2(nArray, n10));
    }

    private static final void X8(long[] lArray, int n10, int n11) {
        ArraysKt___ArraysKt.vq(lArray, n10, n11);
    }

    public static final void X9(byte[] byArray, e e10) {
        int n10;
        f0.p(byArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= (n10 = 1); i10 += -1) {
            n10 = i10 + 1;
            n10 = e10.m(n10);
            byte by2 = z0.l(byArray, i10);
            byte by3 = z0.l(byArray, n10);
            z0.t(byArray, i10, by3);
            z0.t(byArray, n10, by2);
        }
    }

    public static final void Xa(long[] lArray) {
        String string2 = "$this$sortDescending";
        f0.p(lArray, string2);
        int n10 = f.h1.n(lArray);
        int n11 = 1;
        if (n10 > n11) {
            UArraysKt___UArraysKt.Oa(lArray);
            ArraysKt___ArraysKt.uq(lArray);
        }
    }

    public static final long Xb(g1[] g1Array) {
        String string2 = "$this$sum";
        f0.p(g1Array, string2);
        int n10 = g1Array.length;
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            g1 g12 = g1Array[i10];
            long l11 = g12.a0();
            l10 = g1.h(l10 + l11);
        }
        return l10;
    }

    private static final List Xc(int[] nArray, Object[] objectArray, p p10) {
        int n10 = d1.n(nArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = d1.l(nArray, i10);
            Object object = c1.b(n12);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map Y(long[] lArray, Map map, f.h2.s.l l10) {
        for (long l11 : lArray) {
            g1 g12 = g1.b(l11);
            Object object = g1.b(l11);
            object = l10.invoke(object);
            map.put(g12, object);
        }
        return map;
    }

    private static final int[] Y0(int[] nArray, int[] nArray2, int n10, int n11, int n12) {
        n.a1(nArray, nArray2, n10, n11, n12);
        return nArray2;
    }

    private static final List Y1(int[] nArray, f.h2.s.l l10) {
        ArrayList<c1> arrayList = new ArrayList<c1>();
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            c1 c12 = c1.b(n10);
            arrayList.add(c12);
        }
        return arrayList;
    }

    private static final List Y2(long[] lArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = g1.b(l10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final long Y3(long[] object, int n10, f.h2.s.l l10) {
        long l11;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd((long[])object))) {
            l11 = f.h1.l((long[])object, n10);
        } else {
            object = n10;
            object = (g1)l10.invoke(object);
            l11 = ((g1)object).a0();
        }
        return l11;
    }

    public static final m1 Y4(short[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = n1.q(object);
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = n1.n(object) + -1;
            short s10 = n1.l(object, n10);
            object = m1.b(s10);
        }
        return object;
    }

    private static final Double Y5(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    private static final Comparable Y6(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Comparable comparable = c1.b(n10);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Comparable comparable2 = c1.b(n13);
                int n14 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n14 > 0) {
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return comparable;
    }

    private static final long[] Y7(long[] lArray, long[] lArray2) {
        f0.p(lArray, "$this$plus");
        return f.h1.f(n.S2(lArray, lArray2));
    }

    private static final void Y8(byte[] byArray, int n10, int n11) {
        ArraysKt___ArraysKt.lq(byArray, n10, n11);
    }

    public static final void Y9(short[] sArray) {
        f0.p(sArray, "$this$shuffle");
        e$a e$a = e.b;
        UArraysKt___UArraysKt.Z9(sArray, e$a);
    }

    public static final void Ya(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$sortDescending");
        UArraysKt___UArraysKt.Pa(nArray, n10, n11);
        ArraysKt___ArraysKt.tq(nArray, n10, n11);
    }

    private static final long Yb(short[] sArray, f.h2.s.l l10) {
        long l11 = g1.h(0);
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final List Yc(int[] nArray, int[] nArray2) {
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(nArray2, string2);
        int n10 = d1.n(nArray);
        int n11 = d1.n(nArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = d1.l(nArray, i10);
            int n13 = d1.l(nArray2, i10);
            Object object = c1.b(n12);
            c1 c12 = c1.b(n13);
            object = w0.a(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map Z(short[] sArray, Map map, f.h2.s.l l10) {
        for (short s10 : sArray) {
            m1 m12 = m1.b(s10);
            Object object = m1.b(s10);
            object = l10.invoke(object);
            map.put(m12, object);
        }
        return map;
    }

    public static /* synthetic */ int[] Z0(int[] nArray, int[] nArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = d1.n(nArray);
        }
        n.a1(nArray, nArray2, n10, n11, n12);
        return nArray2;
    }

    private static final List Z1(short[] sArray, f.h2.s.l l10) {
        ArrayList<m1> arrayList = new ArrayList<m1>();
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            m1 m12 = m1.b(s10);
            arrayList.add(m12);
        }
        return arrayList;
    }

    private static final List Z2(short[] sArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = m1.b(s10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final byte Z3(byte[] object, int n10, f.h2.s.l l10) {
        byte by2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld((byte[])object))) {
            by2 = z0.l((byte[])object, n10);
        } else {
            object = n10;
            object = (y0)l10.invoke(object);
            by2 = ((y0)object).Y();
        }
        return by2;
    }

    private static final m1 Z4(short[] sArray, f.h2.s.l l10) {
        int n10;
        k k10 = ArraysKt___ArraysKt.Jd(sArray);
        int n11 = k10.f();
        if (n11 >= (n10 = k10.e())) {
            while (true) {
                short s10 = n1.l(sArray, n11);
                Comparable comparable = m1.b(s10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) {
                    return m1.b(s10);
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        return null;
    }

    private static final Float Z5(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.max(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Double Z6(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final byte[] Z7(byte[] byArray, Collection object) {
        f0.p(byArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = z0.n(byArray);
        int n11 = z0.n(byArray);
        int n12 = object.size();
        byArray = Arrays.copyOf(byArray, n11 += n12);
        Object object2 = "java.util.Arrays.copyOf(this, newSize)";
        f0.o(byArray, (String)object2);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (y0)object.next();
            n11 = ((y0)object2).Y();
            n12 = n10 + 1;
            byArray[n10] = n11;
            n10 = n12;
        }
        return z0.f(byArray);
    }

    private static final void Z8(short[] sArray, int n10, int n11) {
        ArraysKt___ArraysKt.zq(sArray, n10, n11);
    }

    public static final void Z9(short[] sArray, e e10) {
        int n10;
        f0.p(sArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= (n10 = 1); i10 += -1) {
            n10 = i10 + 1;
            n10 = e10.m(n10);
            short s10 = n1.l(sArray, i10);
            short s11 = n1.l(sArray, n10);
            n1.t(sArray, i10, s11);
            n1.t(sArray, n10, s10);
        }
    }

    public static final void Za(short[] sArray) {
        String string2 = "$this$sortDescending";
        f0.p(sArray, string2);
        int n10 = n1.n(sArray);
        int n11 = 1;
        if (n10 > n11) {
            UArraysKt___UArraysKt.Ra(sArray);
            ArraysKt___ArraysKt.yq(sArray);
        }
    }

    public static final int Zb(m1[] m1Array) {
        String string2 = "$this$sum";
        f0.p(m1Array, string2);
        int n10 = m1Array.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            m1 m12 = m1Array[i10];
            int n12 = m12.Y();
            char c10 = (char)-1;
            n12 = c1.h(n12 & c10);
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    private static final List Zc(short[] sArray, Object[] objectArray, p p10) {
        int n10 = n1.n(sArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = n1.l(sArray, i10);
            Object object = m1.b(s10);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final int a0(int[] nArray) {
        f0.p(nArray, "$this$component1");
        return d1.l(nArray, 0);
    }

    private static final int[] a1(int[] nArray) {
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        return d1.f(nArray);
    }

    private static final List a2(byte[] byArray, p p10) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n10 = byArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            y0 y02 = y0.b(by2);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, y02))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = y0.b(by2);
                arrayList.add((Integer)comparable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Collection a3(int[] nArray, Collection collection, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = c1.b(n12);
            object = (Iterable)p10.invoke(n13, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final y0 a4(byte[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld(object))) {
            byte by2 = z0.l(object, n10);
            object = y0.b(by2);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    private static final List a5(byte[] byArray, f.h2.s.l l10) {
        int n10 = z0.n(byArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object a6(long[] object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 < 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float a7(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.min(f10, f11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return Float.valueOf(f10);
    }

    private static final int a8(int[] nArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.b8(nArray, e$a);
    }

    private static final void a9(byte[] byArray) {
        ArraysKt___ArraysKt.kq(byArray);
    }

    private static final int aa(int[] nArray) {
        return c1.h(ArraysKt___ArraysKt.Os(nArray));
    }

    public static final List ab(int[] nArray) {
        f0.p(nArray, "$this$sorted");
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        nArray = d1.f(nArray);
        UArraysKt___UArraysKt.Ga(nArray);
        return b.a(nArray);
    }

    public static final List ac(byte[] object, int n10) {
        ArrayList<y0> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = z0.n((byte[])object);
            if (n10 >= n11) {
                return CollectionsKt___CollectionsKt.I5(z0.c((byte[])object));
            }
            if (n10 == n12) {
                return t.k(y0.b(z0.l((byte[])object, 0)));
            }
            arrayList = new ArrayList<y0>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                y0 y02 = y0.b((byte)object2);
                arrayList.add(y02);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List ad(long[] lArray, Object[] objectArray) {
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = f.h1.n(lArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = f.h1.l(lArray, i10);
            Object object = objectArray[i10];
            Pair pair = w0.a(g1.b(l10), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    private static final byte b0(byte[] byArray) {
        f0.p(byArray, "$this$component1");
        return z0.l(byArray, 0);
    }

    private static final byte[] b1(byte[] byArray) {
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        return z0.f(byArray);
    }

    private static final List b2(int[] nArray, p p10) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n10 = nArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            int n13 = n11 + 1;
            comparable = n11;
            c1 c12 = c1.b(n12);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, c12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = c1.b(n12);
                arrayList.add((Integer)comparable);
            }
            n11 = n13;
        }
        return arrayList;
    }

    private static final Collection b3(short[] sArray, Collection collection, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = m1.b(s10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final m1 b4(short[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd(object))) {
            short s10 = n1.l(object, n10);
            object = m1.b(s10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    private static final List b5(long[] lArray, f.h2.s.l l10) {
        int n10 = f.h1.n(lArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object b6(byte[] object, Comparator comparator, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 < 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Comparable b7(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Comparable comparable = m1.b(s10);
        comparable = (Comparable)l10.invoke(comparable);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Comparable comparable2 = m1.b(s11);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 > 0) {
                    comparable = comparable2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return comparable;
    }

    public static final int b8(int[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.n(object);
            int n11 = e10.m(n10);
            return d1.l(object, n11);
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final void b9(long[] lArray) {
        ArraysKt___ArraysKt.uq(lArray);
    }

    private static final byte ba(byte[] byArray) {
        return y0.h(ArraysKt___ArraysKt.Gs(byArray));
    }

    public static final List bb(byte[] byArray) {
        f0.p(byArray, "$this$sorted");
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        byArray = z0.f(byArray);
        UArraysKt___UArraysKt.Na(byArray);
        return b.b(byArray);
    }

    public static final List bc(short[] object, int n10) {
        ArrayList<m1> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = n1.n((short[])object);
            if (n10 >= n11) {
                return CollectionsKt___CollectionsKt.I5(n1.c((short[])object));
            }
            if (n10 == n12) {
                return t.k(m1.b(n1.l((short[])object, 0)));
            }
            arrayList = new ArrayList<m1>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                m1 m12 = m1.b((short)object2);
                arrayList.add(m12);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final List bd(short[] sArray, short[] sArray2, p p10) {
        int n10 = n1.n(sArray);
        int n11 = n1.n(sArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = n1.l(sArray, i10);
            Object object = m1.b(s10);
            short s11 = n1.l(sArray2, i10);
            m1 m12 = m1.b(s11);
            object = p10.invoke(object, m12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final long c0(long[] lArray) {
        f0.p(lArray, "$this$component1");
        return f.h1.l(lArray, 0);
    }

    private static final byte[] c1(byte[] byArray, int n10) {
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, newSize)");
        return z0.f(byArray);
    }

    private static final List c2(long[] lArray, p p10) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n10 = lArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            g1 g12 = g1.b(l10);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, g12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = g1.b(l10);
                arrayList.add((Integer)comparable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Collection c3(byte[] byArray, Collection collection, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = y0.b(by2);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final c1 c4(int[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Pd(object))) {
            int n12 = d1.l(object, n10);
            object = c1.b(n12);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    private static final List c5(int[] nArray, f.h2.s.l l10) {
        int n10 = d1.n(nArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int n11 : nArray) {
            Object object = c1.b(n11);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object c6(short[] object, Comparator comparator, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 < 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Double c7(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return d10;
    }

    private static final byte c8(byte[] byArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.f8(byArray, e$a);
    }

    private static final void c9(int[] nArray, int n10, int n11) {
        ArraysKt___ArraysKt.tq(nArray, n10, n11);
    }

    private static final byte ca(byte[] object, f.h2.s.l l10) {
        int n10 = ((byte[])object).length;
        boolean bl2 = false;
        y0 y02 = null;
        boolean bl3 = false;
        y0 y03 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = object[i10];
            Comparable comparable = y0.b(by2);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                y03 = y0.b(by2);
                bl2 = true;
                y02 = y03;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(y02, "null cannot be cast to non-null type kotlin.UByte");
            return y02.Y();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List cb(long[] lArray) {
        f0.p(lArray, "$this$sorted");
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        lArray = f.h1.f(lArray);
        UArraysKt___UArraysKt.Oa(lArray);
        return b.c(lArray);
    }

    public static final List cc(int[] object, int n10) {
        ArrayList<c1> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = d1.n((int[])object);
            if (n10 >= n11) {
                return CollectionsKt___CollectionsKt.I5(d1.c((int[])object));
            }
            if (n10 == n12) {
                return t.k(c1.b(d1.l((int[])object, 0)));
            }
            arrayList = new ArrayList<c1>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                c1 c12 = c1.b((int)object2);
                arrayList.add(c12);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final List cd(short[] sArray, Iterable object, p p10) {
        boolean bl2;
        int n10 = n1.n(sArray);
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = m1.b(n1.l(sArray, n11));
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    private static final short d0(short[] sArray) {
        f0.p(sArray, "$this$component1");
        return n1.l(sArray, 0);
    }

    private static final long[] d1(long[] lArray) {
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        return f.h1.f(lArray);
    }

    private static final List d2(short[] sArray, p p10) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n10 = sArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            m1 m12 = m1.b(s10);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, m12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = m1.b(s10);
                arrayList.add((Integer)comparable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Collection d3(long[] lArray, Collection collection, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = g1.b(l10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final g1 d4(long[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd(object))) {
            long l10 = f.h1.l(object, n10);
            object = g1.b(l10);
        } else {
            object = null;
        }
        return object;
    }

    private static final List d5(short[] sArray, f.h2.s.l l10) {
        int n10 = n1.n(sArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object d6(int[] object, Comparator comparator, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = l10.invoke(object2);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    int n14 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n14 < 0) {
                        object2 = object3;
                    }
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float d7(short[] sArray, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = (Number)l10.invoke(object);
        float f10 = ((Number)object).floatValue();
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                object2 = (Number)l10.invoke(object2);
                float f11 = ((Number)object2).floatValue();
                f10 = Math.min(f10, f11);
                if (n10 == n11) break;
                ++n10;
            }
        }
        return Float.valueOf(f10);
    }

    public static final long d8(long[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = f.h1.q(object);
        if (n10 == 0) {
            n10 = f.h1.n(object);
            int n11 = e10.m(n10);
            return f.h1.l(object, n11);
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final void d9(short[] sArray) {
        ArraysKt___ArraysKt.yq(sArray);
    }

    private static final long da(long[] object, f.h2.s.l l10) {
        int n10 = ((long[])object).length;
        boolean bl2 = false;
        g1 g12 = null;
        boolean bl3 = false;
        g1 g13 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = object[i10];
            Comparable comparable = g1.b(l11);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                g13 = g1.b(l11);
                bl2 = true;
                g12 = g13;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(g12, "null cannot be cast to non-null type kotlin.ULong");
            return g12.a0();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List db(short[] sArray) {
        f0.p(sArray, "$this$sorted");
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        sArray = n1.f(sArray);
        UArraysKt___UArraysKt.Ra(sArray);
        return b.d(sArray);
    }

    public static final List dc(long[] object, int n10) {
        ArrayList<g1> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = f.h1.n((long[])object);
            if (n10 >= n11) {
                return CollectionsKt___CollectionsKt.I5(f.h1.c((long[])object));
            }
            if (n10 == n12) {
                return t.k(g1.b(f.h1.l((long[])object, 0)));
            }
            arrayList = new ArrayList<g1>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                g1 g12 = g1.b((long)object2);
                arrayList.add(g12);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List dd(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(byArray2, string2);
        int n10 = z0.n(byArray);
        int n11 = z0.n(byArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = z0.l(byArray, i10);
            byte by3 = z0.l(byArray2, i10);
            Object object = y0.b(by2);
            y0 y02 = y0.b(by3);
            object = w0.a(object, y02);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final int e0(int[] nArray) {
        f0.p(nArray, "$this$component2");
        return d1.l(nArray, 1);
    }

    private static final short[] e1(short[] sArray, int n10) {
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, newSize)");
        return n1.f(sArray);
    }

    private static final Collection e2(int[] nArray, Collection collection, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            int n13 = n11 + 1;
            comparable = n11;
            c1 c12 = c1.b(n12);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, c12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = c1.b(n12);
                collection.add(comparable);
            }
            n11 = n13;
        }
        return collection;
    }

    private static final Collection e3(long[] lArray, Collection collection, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Map e4(long[] lArray, f.h2.s.l l10, f.h2.s.l l11) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (long l12 : lArray) {
            Object object = g1.b(l12);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = g1.b(l12);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    private static final List e5(byte[] byArray, p p10) {
        int n10 = z0.n(byArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = y0.b(by2);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object e6(long[] lArray, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 < 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    private static final Object e7(long[] object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            long l11 = f.h1.l(object, 0);
            Object object2 = g1.b(l11);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    long l12 = f.h1.l(object, n10);
                    Object object3 = g1.b(l12);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 > 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final long e8(long[] lArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.d8(lArray, e$a);
    }

    public static final List e9(int[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        boolean bl2 = d1.q(object);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = CollectionsKt___CollectionsKt.L5(d1.c(object));
        a0.e1((List)object);
        return object;
    }

    private static final long ea(long[] lArray) {
        return g1.h(ArraysKt___ArraysKt.Qs(lArray));
    }

    public static final int[] eb(int[] nArray) {
        String string2 = "$this$sortedArray";
        f0.p(nArray, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return nArray;
        }
        n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        nArray = d1.f(nArray);
        UArraysKt___UArraysKt.Ga(nArray);
        return nArray;
    }

    public static final List ec(byte[] object, int n10) {
        ArrayList<y0> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = z0.n((byte[])object);
            if (n10 >= n12) {
                return CollectionsKt___CollectionsKt.I5(z0.c((byte[])object));
            }
            if (n10 == n11) {
                return t.k(y0.b(z0.l((byte[])object, n12 -= n11)));
            }
            arrayList = new ArrayList<y0>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                byte by2 = z0.l((byte[])object, n10);
                y0 y02 = y0.b(by2);
                arrayList.add(y02);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List ed(short[] sArray, short[] sArray2) {
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(sArray2, string2);
        int n10 = n1.n(sArray);
        int n11 = n1.n(sArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = n1.l(sArray, i10);
            short s11 = n1.l(sArray2, i10);
            Object object = m1.b(s10);
            m1 m12 = m1.b(s11);
            object = w0.a(object, m12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final byte f0(byte[] byArray) {
        f0.p(byArray, "$this$component2");
        return z0.l(byArray, 1);
    }

    private static final int[] f1(int[] nArray, int n10) {
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, newSize)");
        return d1.f(nArray);
    }

    private static final Collection f2(short[] sArray, Collection collection, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            m1 m12 = m1.b(s10);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, m12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = m1.b(s10);
                collection.add(comparable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Collection f3(short[] sArray, Collection collection, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Map f4(short[] sArray, f.h2.s.l l10, f.h2.s.l l11) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = m1.b(s10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    private static final List f5(int[] nArray, p p10) {
        int n10 = d1.n(nArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = c1.b(n12);
            object = p10.invoke(n13, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object f6(byte[] byArray, Comparator comparator, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 < 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    private static final Object f7(byte[] object, Comparator comparator, f.h2.s.l l10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            by2 = z0.l(object, 0);
            Object object2 = y0.b(by2);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    byte by3 = z0.l(object, n10);
                    Object object3 = y0.b(by3);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 > 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final byte f8(byte[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = z0.q(object);
        if (n10 == 0) {
            n10 = z0.n(object);
            int n11 = e10.m(n10);
            return z0.l(object, n11);
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List f9(byte[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        boolean bl2 = z0.q(object);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = CollectionsKt___CollectionsKt.L5(z0.c(object));
        a0.e1((List)object);
        return object;
    }

    private static final int fa(int[] object, f.h2.s.l l10) {
        int n10 = ((int[])object).length;
        boolean bl2 = false;
        c1 c12 = null;
        boolean bl3 = false;
        c1 c13 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = object[i10];
            Comparable comparable = c1.b(n11);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                c13 = c1.b(n11);
                bl2 = true;
                c12 = c13;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(c12, "null cannot be cast to non-null type kotlin.UInt");
            return c12.a0();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final byte[] fb(byte[] byArray) {
        String string2 = "$this$sortedArray";
        f0.p(byArray, string2);
        int n10 = z0.q(byArray);
        if (n10 != 0) {
            return byArray;
        }
        n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        byArray = z0.f(byArray);
        UArraysKt___UArraysKt.Na(byArray);
        return byArray;
    }

    public static final List fc(short[] object, int n10) {
        ArrayList<m1> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = n1.n((short[])object);
            if (n10 >= n12) {
                return CollectionsKt___CollectionsKt.I5(n1.c((short[])object));
            }
            if (n10 == n11) {
                return t.k(m1.b(n1.l((short[])object, n12 -= n11)));
            }
            arrayList = new ArrayList<m1>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                short s10 = n1.l((short[])object, n10);
                m1 m12 = m1.b(s10);
                arrayList.add(m12);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List fd(byte[] byArray, Object[] objectArray) {
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = z0.n(byArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = z0.l(byArray, i10);
            Object object = objectArray[i10];
            Pair pair = w0.a(y0.b(by2), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    private static final long g0(long[] lArray) {
        f0.p(lArray, "$this$component2");
        return f.h1.l(lArray, 1);
    }

    private static final long[] g1(long[] lArray, int n10) {
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, newSize)");
        return f.h1.f(lArray);
    }

    private static final Collection g2(byte[] byArray, Collection collection, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            y0 y02 = y0.b(by2);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, y02))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = y0.b(by2);
                collection.add(comparable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Collection g3(int[] nArray, Collection collection, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Map g4(byte[] byArray, f.h2.s.l l10) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            y0 y02 = y0.b(by2);
            object2.add((y0)y02);
        }
        return linkedHashMap;
    }

    private static final List g5(long[] lArray, p p10) {
        int n10 = f.h1.n(lArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = g1.b(l10);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object g6(short[] sArray, Comparator comparator, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 < 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    private static final Object g7(short[] object, Comparator comparator, f.h2.s.l l10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            s10 = n1.l(object, 0);
            Object object2 = m1.b(s10);
            object2 = l10.invoke(object2);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    short s11 = n1.l(object, n10);
                    Object object3 = m1.b(s11);
                    int n12 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n12 > 0) {
                        object2 = object3;
                    }
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final short g8(short[] sArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.h8(sArray, e$a);
    }

    public static final List g9(long[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = CollectionsKt___CollectionsKt.L5(f.h1.c(object));
        a0.e1((List)object);
        return object;
    }

    private static final short ga(short[] sArray) {
        return m1.h(ArraysKt___ArraysKt.Us(sArray));
    }

    public static final long[] gb(long[] lArray) {
        String string2 = "$this$sortedArray";
        f0.p(lArray, string2);
        int n10 = f.h1.q(lArray);
        if (n10 != 0) {
            return lArray;
        }
        n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        lArray = f.h1.f(lArray);
        UArraysKt___UArraysKt.Oa(lArray);
        return lArray;
    }

    public static final List gc(int[] object, int n10) {
        ArrayList<c1> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = d1.n((int[])object);
            if (n10 >= n12) {
                return CollectionsKt___CollectionsKt.I5(d1.c((int[])object));
            }
            if (n10 == n11) {
                return t.k(c1.b(d1.l((int[])object, n12 -= n11)));
            }
            arrayList = new ArrayList<c1>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                int n13 = d1.l((int[])object, n10);
                c1 c12 = c1.b(n13);
                arrayList.add(c12);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List gd(short[] sArray, Object[] objectArray) {
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = n1.n(sArray);
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = n1.l(sArray, i10);
            Object object = objectArray[i10];
            Pair pair = w0.a(m1.b(s10), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    private static final short h0(short[] sArray) {
        f0.p(sArray, "$this$component2");
        return n1.l(sArray, 1);
    }

    private static final short[] h1(short[] sArray) {
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        return n1.f(sArray);
    }

    private static final Collection h2(long[] lArray, Collection collection, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        Comparable<Integer> comparable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            int n12 = n11 + 1;
            comparable = n11;
            g1 g12 = g1.b(l10);
            n11 = (int)(((Boolean)(comparable = (Boolean)p10.invoke(comparable, g12))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                comparable = g1.b(l10);
                collection.add(comparable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Collection h3(byte[] byArray, Collection collection, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Map h4(int[] nArray, f.h2.s.l l10, f.h2.s.l l11) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = c1.b(n10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    private static final List h5(short[] sArray, p p10) {
        int n10 = n1.n(sArray);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = m1.b(s10);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object h6(int[] nArray, Comparator comparator, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = l10.invoke(object);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                int n14 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n14 < 0) {
                    object = object2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final Object h7(int[] object, Comparator comparator, f.h2.s.l l10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            n10 = d1.l(object, 0);
            Object object2 = c1.b(n10);
            object2 = l10.invoke(object2);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = d1.l(object, n11);
                    Object object3 = c1.b(n13);
                    int n14 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n14 > 0) {
                        object2 = object3;
                    }
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final short h8(short[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = n1.q(object);
        if (n10 == 0) {
            n10 = n1.n(object);
            int n11 = e10.m(n10);
            return n1.l(object, n11);
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List h9(short[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        boolean bl2 = n1.q(object);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = CollectionsKt___CollectionsKt.L5(n1.c(object));
        a0.e1((List)object);
        return object;
    }

    private static final short ha(short[] object, f.h2.s.l l10) {
        int n10 = ((short[])object).length;
        boolean bl2 = false;
        m1 m12 = null;
        boolean bl3 = false;
        m1 m13 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = object[i10];
            Comparable comparable = m1.b(s10);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                m13 = m1.b(s10);
                bl2 = true;
                m12 = m13;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(m12, "null cannot be cast to non-null type kotlin.UShort");
            return m12.Y();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final short[] hb(short[] sArray) {
        String string2 = "$this$sortedArray";
        f0.p(sArray, string2);
        int n10 = n1.q(sArray);
        if (n10 != 0) {
            return sArray;
        }
        n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        sArray = n1.f(sArray);
        UArraysKt___UArraysKt.Ra(sArray);
        return sArray;
    }

    public static final List hc(long[] object, int n10) {
        ArrayList<g1> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = f.h1.n((long[])object);
            if (n10 >= n12) {
                return CollectionsKt___CollectionsKt.I5(f.h1.c((long[])object));
            }
            if (n10 == n11) {
                return t.k(g1.b(f.h1.l((long[])object, n12 -= n11)));
            }
            arrayList = new ArrayList<g1>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                long l10 = f.h1.l((long[])object, n10);
                g1 g12 = g1.b(l10);
                arrayList.add(g12);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List hd(long[] lArray, long[] lArray2) {
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(lArray2, string2);
        int n10 = f.h1.n(lArray);
        int n11 = f.h1.n(lArray2);
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = f.h1.l(lArray, i10);
            long l11 = f.h1.l(lArray2, i10);
            Object object = g1.b(l10);
            g1 g12 = g1.b(l11);
            object = w0.a(object, g12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final int i0(int[] nArray) {
        f0.p(nArray, "$this$component3");
        return d1.l(nArray, 2);
    }

    private static final long[] i1(long[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.L1(object, n10, n11);
                    break block3;
                }
                n12 = ((long[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return f.h1.f(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((long[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static final List i2(byte[] byArray, f.h2.s.l l10) {
        ArrayList<y0> arrayList = new ArrayList<y0>();
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            y0 y02 = y0.b(by2);
            arrayList.add(y02);
        }
        return arrayList;
    }

    private static final Object i3(long[] lArray, Object object, p p10) {
        for (long l10 : lArray) {
            g1 g12 = g1.b(l10);
            object = p10.invoke(object, g12);
        }
        return object;
    }

    private static final Map i4(long[] lArray, f.h2.s.l l10) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            g1 g12 = g1.b(l11);
            object2.add((g1)g12);
        }
        return linkedHashMap;
    }

    private static final Collection i5(int[] nArray, Collection collection, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = c1.b(n12);
            object = p10.invoke(n13, object);
            collection.add(object);
        }
        return collection;
    }

    public static final c1 i6(int[] nArray) {
        String string2 = "$this$maxOrNull";
        f0.p(nArray, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        string2 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = s1.c(n10, n13 = d1.l(nArray, n11))) < 0) {
                    n10 = n13;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    private static final Object i7(long[] lArray, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        Object object = g1.b(l11);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l12 = f.h1.l(lArray, n10);
                Object object2 = g1.b(l12);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 > 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    private static final c1 i8(int[] nArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.j8(nArray, e$a);
    }

    private static final int[] i9(int[] nArray) {
        return d1.f(ArraysKt___ArraysKt.Pq(nArray));
    }

    public static final c1 ia(int[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = d1.n(object);
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            int n12 = d1.l(object, 0);
            object = c1.b(n12);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final int[] ib(int[] nArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(nArray, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return nArray;
        }
        n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        nArray = d1.f(nArray);
        UArraysKt___UArraysKt.Sa(nArray);
        return nArray;
    }

    private static final List ic(byte[] byArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Comparable comparable = y0.b(z0.l(byArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.q1(byArray, ++i10);
        }
        return CollectionsKt___CollectionsKt.I5(z0.c(byArray));
    }

    private static final byte j0(byte[] byArray) {
        f0.p(byArray, "$this$component3");
        return z0.l(byArray, 2);
    }

    private static final byte[] j1(byte[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.G1(object, n10, n11);
                    break block3;
                }
                n12 = ((byte[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return z0.f(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((byte[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static final List j2(long[] lArray, f.h2.s.l l10) {
        ArrayList<g1> arrayList = new ArrayList<g1>();
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            g1 g12 = g1.b(l11);
            arrayList.add(g12);
        }
        return arrayList;
    }

    private static final Object j3(byte[] byArray, Object object, p p10) {
        for (byte by2 : byArray) {
            y0 y02 = y0.b(by2);
            object = p10.invoke(object, y02);
        }
        return object;
    }

    private static final Map j4(byte[] byArray, f.h2.s.l l10, f.h2.s.l l11) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = y0.b(by2);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    private static final Collection j5(short[] sArray, Collection collection, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = m1.b(s10);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    public static final y0 j6(byte[] byArray) {
        String string2 = "$this$maxOrNull";
        f0.p(byArray, string2);
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        string2 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                int n12 = by2 & 0xFF;
                int n13 = by3 & 0xFF;
                if ((n12 = f0.t(n12, n13)) < 0) {
                    by2 = by3;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    private static final Object j7(byte[] byArray, Comparator comparator, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        Object object = y0.b(by2);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                Object object2 = y0.b(by3);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 > 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    public static final c1 j8(int[] nArray, e e10) {
        f0.p(nArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.n(nArray);
        int n11 = e10.m(n10);
        return c1.b(d1.l(nArray, n11));
    }

    private static final byte[] j9(byte[] byArray) {
        return z0.f(ArraysKt___ArraysKt.Lq(byArray));
    }

    public static final y0 ja(byte[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = z0.n(object);
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            byte by2 = z0.l(object, 0);
            object = y0.b(by2);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final byte[] jb(byte[] byArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(byArray, string2);
        int n10 = z0.q(byArray);
        if (n10 != 0) {
            return byArray;
        }
        n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        byArray = z0.f(byArray);
        UArraysKt___UArraysKt.Wa(byArray);
        return byArray;
    }

    private static final List jc(long[] lArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            long l11 = f.h1.l(lArray, i10);
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.t1(lArray, ++i10);
        }
        return CollectionsKt___CollectionsKt.I5(f.h1.c(lArray));
    }

    private static final long k0(long[] lArray) {
        f0.p(lArray, "$this$component3");
        return f.h1.l(lArray, 2);
    }

    private static final short[] k1(short[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.N1(object, n10, n11);
                    break block3;
                }
                n12 = ((short[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return n1.f(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((short[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static final List k2(int[] nArray, f.h2.s.l l10) {
        ArrayList<c1> arrayList = new ArrayList<c1>();
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            c1 c12 = c1.b(n10);
            arrayList.add(c12);
        }
        return arrayList;
    }

    private static final Object k3(int[] nArray, Object object, p p10) {
        for (int n10 : nArray) {
            c1 c12 = c1.b(n10);
            object = p10.invoke(object, c12);
        }
        return object;
    }

    private static final Map k4(int[] nArray, f.h2.s.l l10) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            c1 c12 = c1.b(n10);
            object2.add((c1)c12);
        }
        return linkedHashMap;
    }

    private static final Collection k5(byte[] byArray, Collection collection, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = y0.b(by2);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    public static final g1 k6(long[] lArray) {
        String string2 = "$this$maxOrNull";
        f0.p(lArray, string2);
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        string2 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l11;
                int n12;
                if ((n12 = s1.g(l10, l11 = f.h1.l(lArray, n10))) < 0) {
                    l10 = l11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    private static final Object k7(short[] sArray, Comparator comparator, f.h2.s.l l10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        s10 = n1.l(sArray, 0);
        Object object = m1.b(s10);
        object = l10.invoke(object);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                Object object2 = m1.b(s11);
                int n12 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n12 > 0) {
                    object = object2;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return object;
    }

    private static final y0 k8(byte[] byArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.n8(byArray, e$a);
    }

    private static final long[] k9(long[] lArray) {
        return f.h1.f(ArraysKt___ArraysKt.Qq(lArray));
    }

    private static final y0 ka(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        boolean bl2 = false;
        y0 y02 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Comparable comparable = y0.b(by2);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            y02 = y0.b(by2);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return y02;
    }

    public static final long[] kb(long[] lArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(lArray, string2);
        int n10 = f.h1.q(lArray);
        if (n10 != 0) {
            return lArray;
        }
        n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        lArray = f.h1.f(lArray);
        UArraysKt___UArraysKt.Xa(lArray);
        return lArray;
    }

    private static final List kc(int[] nArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Comparable comparable = c1.b(d1.l(nArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.s1(nArray, ++i10);
        }
        return CollectionsKt___CollectionsKt.I5(d1.c(nArray));
    }

    private static final short l0(short[] sArray) {
        f0.p(sArray, "$this$component3");
        return n1.l(sArray, 2);
    }

    private static final int[] l1(int[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.K1(object, n10, n11);
                    break block3;
                }
                n12 = ((int[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return d1.f(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static final List l2(short[] sArray, f.h2.s.l l10) {
        ArrayList<m1> arrayList = new ArrayList<m1>();
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            m1 m12 = m1.b(s10);
            arrayList.add(m12);
        }
        return arrayList;
    }

    private static final Object l3(short[] sArray, Object object, p p10) {
        for (short s10 : sArray) {
            m1 m12 = m1.b(s10);
            object = p10.invoke(object, m12);
        }
        return object;
    }

    private static final Map l4(short[] sArray, f.h2.s.l l10) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            m1 m12 = m1.b(s10);
            object2.add((m1)m12);
        }
        return linkedHashMap;
    }

    private static final Collection l5(long[] lArray, Collection collection, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = g1.b(l10);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    public static final m1 l6(short[] sArray) {
        String string2 = "$this$maxOrNull";
        f0.p(sArray, string2);
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        string2 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                int n12 = -1;
                int n13 = s10 & n12;
                n12 &= s11;
                if ((n12 = f0.t(n13, n12)) < 0) {
                    s10 = s11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    private static final Object l7(int[] nArray, Comparator comparator, f.h2.s.l l10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        n10 = d1.l(nArray, 0);
        Object object = c1.b(n10);
        object = l10.invoke(object);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = d1.l(nArray, n11);
                Object object2 = c1.b(n13);
                int n14 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n14 > 0) {
                    object = object2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    public static final g1 l8(long[] lArray, e e10) {
        f0.p(lArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = f.h1.q(lArray);
        if (n10 != 0) {
            return null;
        }
        n10 = f.h1.n(lArray);
        int n11 = e10.m(n10);
        return g1.b(f.h1.l(lArray, n11));
    }

    private static final short[] l9(short[] sArray) {
        return n1.f(ArraysKt___ArraysKt.Sq(sArray));
    }

    private static final g1 la(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        boolean bl2 = false;
        g1 g12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Comparable comparable = g1.b(l11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            g12 = g1.b(l11);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return g12;
    }

    public static final short[] lb(short[] sArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(sArray, string2);
        int n10 = n1.q(sArray);
        if (n10 != 0) {
            return sArray;
        }
        n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        sArray = n1.f(sArray);
        UArraysKt___UArraysKt.Za(sArray);
        return sArray;
    }

    private static final List lc(short[] sArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Comparable comparable = m1.b(n1.l(sArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.r1(sArray, ++i10);
        }
        return CollectionsKt___CollectionsKt.I5(n1.c(sArray));
    }

    private static final int m0(int[] nArray) {
        f0.p(nArray, "$this$component4");
        return d1.l(nArray, 3);
    }

    private static final int m1(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    private static final Collection m2(long[] lArray, Collection collection, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            g1 g12 = g1.b(l11);
            collection.add(g12);
        }
        return collection;
    }

    private static final Object m3(byte[] byArray, Object object, f.h2.s.q q10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            y0 y02 = y0.b(by2);
            object = q10.invoke(n12, object, y02);
        }
        return object;
    }

    private static final Map m4(int[] nArray, Map map, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            c1 c12 = c1.b(n10);
            object2.add((c1)c12);
        }
        return map;
    }

    private static final Collection m5(long[] lArray, Collection collection, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    public static final y0 m6(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.q6(byArray, comparator);
    }

    public static final c1 m7(int[] nArray) {
        String string2 = "$this$minOrNull";
        f0.p(nArray, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        string2 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = s1.c(n10, n13 = d1.l(nArray, n11))) > 0) {
                    n10 = n13;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    private static final g1 m8(long[] lArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.l8(lArray, e$a);
    }

    private static final List m9(long[] lArray, Object object, p p10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = f.h1.n(lArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        for (long l10 : lArray) {
            g1 g12 = g1.b(l10);
            object = p10.invoke(object, g12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final g1 ma(long[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = f.h1.n(object);
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            long l10 = f.h1.l(object, 0);
            object = g1.b(l10);
        } else {
            object = null;
        }
        return object;
    }

    public static final List mb(int[] nArray) {
        f0.p(nArray, "$this$sortedDescending");
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        nArray = d1.f(nArray);
        UArraysKt___UArraysKt.Ga(nArray);
        return UArraysKt___UArraysKt.e9(nArray);
    }

    private static final List mc(byte[] byArray, f.h2.s.l l10) {
        ArrayList<y0> arrayList = new ArrayList<y0>();
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) break;
            y0 y02 = y0.b(by2);
            arrayList.add(y02);
        }
        return arrayList;
    }

    private static final byte n0(byte[] byArray) {
        f0.p(byArray, "$this$component4");
        return z0.l(byArray, 3);
    }

    private static final int n1(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    private static final Collection n2(short[] sArray, Collection collection, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            m1 m12 = m1.b(s10);
            collection.add(m12);
        }
        return collection;
    }

    private static final Object n3(short[] sArray, Object object, f.h2.s.q q10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            m1 m12 = m1.b(s10);
            object = q10.invoke(n12, object, m12);
        }
        return object;
    }

    private static final Map n4(byte[] byArray, Map map, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            y0 y02 = y0.b(by2);
            object2.add((y0)y02);
        }
        return map;
    }

    private static final Collection n5(short[] sArray, Collection collection, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    public static final c1 n6(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.r6(nArray, comparator);
    }

    public static final y0 n7(byte[] byArray) {
        String string2 = "$this$minOrNull";
        f0.p(byArray, string2);
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        string2 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                byte by3 = z0.l(byArray, n10);
                int n12 = by2 & 0xFF;
                int n13 = by3 & 0xFF;
                if ((n12 = f0.t(n12, n13)) > 0) {
                    by2 = by3;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    public static final y0 n8(byte[] byArray, e e10) {
        f0.p(byArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = z0.q(byArray);
        if (n10 != 0) {
            return null;
        }
        n10 = z0.n(byArray);
        int n11 = e10.m(n10);
        return y0.b(z0.l(byArray, n11));
    }

    private static final List n9(byte[] byArray, Object object, p p10) {
        boolean bl2 = z0.q(byArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = z0.n(byArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        for (byte by2 : byArray) {
            y0 y02 = y0.b(by2);
            object = p10.invoke(object, y02);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final c1 na(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        boolean bl2 = false;
        c1 c12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Comparable comparable = c1.b(n11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            c12 = c1.b(n11);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return c12;
    }

    public static final List nb(byte[] byArray) {
        f0.p(byArray, "$this$sortedDescending");
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        byArray = z0.f(byArray);
        UArraysKt___UArraysKt.Na(byArray);
        return UArraysKt___UArraysKt.f9(byArray);
    }

    private static final List nc(long[] lArray, f.h2.s.l l10) {
        ArrayList<g1> arrayList = new ArrayList<g1>();
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) break;
            g1 g12 = g1.b(l11);
            arrayList.add(g12);
        }
        return arrayList;
    }

    private static final long o0(long[] lArray) {
        f0.p(lArray, "$this$component4");
        return f.h1.l(lArray, 3);
    }

    private static final int o1(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = c1.b(nArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    private static final Collection o2(int[] nArray, Collection collection, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            c1 c12 = c1.b(n10);
            collection.add(c12);
        }
        return collection;
    }

    private static final Object o3(long[] lArray, Object object, f.h2.s.q q10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            g1 g12 = g1.b(l10);
            object = q10.invoke(n12, object, g12);
        }
        return object;
    }

    private static final Map o4(int[] nArray, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = c1.b(n10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final Collection o5(int[] nArray, Collection collection, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Object object = c1.b(n10);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    public static final m1 o6(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.s6(sArray, comparator);
    }

    public static final g1 o7(long[] lArray) {
        String string2 = "$this$minOrNull";
        f0.p(lArray, string2);
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        string2 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                long l11;
                int n12;
                if ((n12 = s1.g(l10, l11 = f.h1.l(lArray, n10))) > 0) {
                    l10 = l11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    private static final m1 o8(short[] sArray) {
        e$a e$a = e.b;
        return UArraysKt___UArraysKt.p8(sArray, e$a);
    }

    private static final List o9(int[] nArray, Object object, p p10) {
        boolean bl2 = d1.q(nArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = d1.n(nArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        for (int n11 : nArray) {
            c1 c12 = c1.b(n11);
            object = p10.invoke(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final m1 oa(short[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = n1.n(object);
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            short s10 = n1.l(object, 0);
            object = m1.b(s10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final List ob(long[] lArray) {
        f0.p(lArray, "$this$sortedDescending");
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        lArray = f.h1.f(lArray);
        UArraysKt___UArraysKt.Oa(lArray);
        return UArraysKt___UArraysKt.g9(lArray);
    }

    private static final List oc(int[] nArray, f.h2.s.l l10) {
        ArrayList<c1> arrayList = new ArrayList<c1>();
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) break;
            c1 c12 = c1.b(n10);
            arrayList.add(c12);
        }
        return arrayList;
    }

    private static final short p0(short[] sArray) {
        f0.p(sArray, "$this$component4");
        return n1.l(sArray, 3);
    }

    private static final int p1(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    private static final Collection p2(byte[] byArray, Collection collection, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            y0 y02 = y0.b(by2);
            collection.add(y02);
        }
        return collection;
    }

    private static final Object p3(int[] nArray, Object object, f.h2.s.q q10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            c1 c12 = c1.b(n12);
            object = q10.invoke(n13, object, c12);
        }
        return object;
    }

    private static final Map p4(long[] lArray, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        for (long l12 : lArray) {
            Object object = g1.b(l12);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = g1.b(l12);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final Collection p5(byte[] byArray, Collection collection, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    public static final g1 p6(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.t6(lArray, comparator);
    }

    public static final m1 p7(short[] sArray) {
        String string2 = "$this$minOrNull";
        f0.p(sArray, string2);
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        string2 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                short s11 = n1.l(sArray, n10);
                int n12 = -1;
                int n13 = s10 & n12;
                n12 &= s11;
                if ((n12 = f0.t(n13, n12)) > 0) {
                    s10 = s11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    public static final m1 p8(short[] sArray, e e10) {
        f0.p(sArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = n1.q(sArray);
        if (n10 != 0) {
            return null;
        }
        n10 = n1.n(sArray);
        int n11 = e10.m(n10);
        return m1.b(n1.l(sArray, n11));
    }

    private static final List p9(short[] sArray, Object object, p p10) {
        boolean bl2 = n1.q(sArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = n1.n(sArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        for (short s10 : sArray) {
            m1 m12 = m1.b(s10);
            object = p10.invoke(object, m12);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final m1 pa(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        boolean bl2 = false;
        m1 m12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Comparable comparable = m1.b(s10);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            m12 = m1.b(s10);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return m12;
    }

    public static final List pb(short[] sArray) {
        f0.p(sArray, "$this$sortedDescending");
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        sArray = n1.f(sArray);
        UArraysKt___UArraysKt.Ra(sArray);
        return UArraysKt___UArraysKt.h9(sArray);
    }

    private static final List pc(short[] sArray, f.h2.s.l l10) {
        ArrayList<m1> arrayList = new ArrayList<m1>();
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) break;
            m1 m12 = m1.b(s10);
            arrayList.add(m12);
        }
        return arrayList;
    }

    private static final int q0(int[] nArray) {
        f0.p(nArray, "$this$component5");
        return d1.l(nArray, 4);
    }

    public static final List q1(byte[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(z0.n((byte[])object) - n10, 0);
            return UArraysKt___UArraysKt.ec((byte[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Collection q2(long[] lArray, Collection collection, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            g1 g12 = g1.b(l11);
            collection.add(g12);
        }
        return collection;
    }

    private static final Object q3(long[] lArray, Object object, p p10) {
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            long l10 = f.h1.l(lArray, n10);
            g1 g12 = g1.b(l10);
            object = p10.invoke(g12, object);
            n10 = n11;
        }
        return object;
    }

    private static final Map q4(long[] lArray, Map map, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Object object = g1.b(l11);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            g1 g12 = g1.b(l11);
            object2.add((g1)g12);
        }
        return map;
    }

    public static final c1 q5(int[] nArray) {
        f0.p(nArray, "$this$max");
        return UArraysKt___UArraysKt.i6(nArray);
    }

    public static final y0 q6(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        string2 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                y0 y02;
                byte by3 = z0.l(byArray, n10);
                y0 y03 = y0.b(by2);
                int n12 = comparator.compare(y03, y02 = y0.b(by3));
                if (n12 < 0) {
                    by2 = by3;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    public static final y0 q7(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.u7(byArray, comparator);
    }

    private static final byte q8(byte[] object, p p10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            y0 y02 = null;
            by2 = z0.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    y02 = y0.b(by2);
                    byte by3 = z0.l(object, n10);
                    y0 y03 = y0.b(by3);
                    y02 = (y0)p10.invoke(y02, y03);
                    by2 = y02.Y();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return by2;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List q9(byte[] byArray, Object object, f.h2.s.q q10) {
        boolean bl2 = z0.q(byArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = z0.n(byArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        k k10 = ArraysKt___ArraysKt.Cd(byArray);
        int n11 = k10.e();
        n10 = k10.f();
        if (n11 <= n10) {
            while (true) {
                Integer n12 = n11;
                byte by2 = z0.l(byArray, n11);
                y0 y02 = y0.b(by2);
                object = q10.invoke(n12, object, y02);
                arrayList.add(object);
                if (n11 == n10) break;
                ++n11;
            }
        }
        return arrayList;
    }

    public static final List qa(long[] lArray, Iterable object) {
        f0.p(lArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            long l10 = f.h1.l(lArray, n10);
            object2 = g1.b(l10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static final int qb(int[] nArray) {
        return c1.h(ArraysKt___ArraysKt.Mv(nArray));
    }

    private static final byte[] qc(byte[] byArray) {
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        return byArray;
    }

    private static final byte r0(byte[] byArray) {
        f0.p(byArray, "$this$component5");
        return z0.l(byArray, 4);
    }

    public static final List r1(short[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(n1.n((short[])object) - n10, 0);
            return UArraysKt___UArraysKt.fc((short[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Collection r2(short[] sArray, Collection collection, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Comparable comparable = m1.b(s10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            m1 m12 = m1.b(s10);
            collection.add(m12);
        }
        return collection;
    }

    private static final Object r3(byte[] byArray, Object object, p p10) {
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            y0 y02 = y0.b(z0.l(byArray, n10));
            object = p10.invoke(y02, object);
            n10 = n11;
        }
        return object;
    }

    private static final Map r4(short[] sArray, Map map, f.h2.s.l l10) {
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            m1 m12 = m1.b(s10);
            object2.add((m1)m12);
        }
        return map;
    }

    public static final y0 r5(byte[] byArray) {
        f0.p(byArray, "$this$max");
        return UArraysKt___UArraysKt.j6(byArray);
    }

    public static final c1 r6(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        string2 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                c1 c12;
                int n13 = d1.l(nArray, n11);
                c1 c13 = c1.b(n10);
                int n14 = comparator.compare(c13, c12 = c1.b(n13));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    public static final c1 r7(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.v7(nArray, comparator);
    }

    private static final int r8(int[] object, p p10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            c1 c12 = null;
            n10 = d1.l(object, 0);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    c12 = c1.b(n10);
                    int n13 = d1.l(object, n11);
                    c1 c13 = c1.b(n13);
                    c12 = (c1)p10.invoke(c12, c13);
                    n10 = c12.a0();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List r9(short[] sArray, Object object, f.h2.s.q q10) {
        boolean bl2 = n1.q(sArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = n1.n(sArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        k k10 = ArraysKt___ArraysKt.Jd(sArray);
        int n11 = k10.e();
        n10 = k10.f();
        if (n11 <= n10) {
            while (true) {
                Integer n12 = n11;
                short s10 = n1.l(sArray, n11);
                m1 m12 = m1.b(s10);
                object = q10.invoke(n12, object, m12);
                arrayList.add(object);
                if (n11 == n10) break;
                ++n11;
            }
        }
        return arrayList;
    }

    public static final List ra(int[] nArray, Iterable object) {
        f0.p(nArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            n10 = d1.l(nArray, n10);
            object2 = c1.b(n10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static final int rb(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = c1.h(byArray[i10] & 0xFF);
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    private static final int[] rc(int[] nArray) {
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        return nArray;
    }

    private static final long s0(long[] lArray) {
        f0.p(lArray, "$this$component5");
        return f.h1.l(lArray, 4);
    }

    public static final List s1(int[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(d1.n((int[])object) - n10, 0);
            return UArraysKt___UArraysKt.gc((int[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Collection s2(int[] nArray, Collection collection, f.h2.s.l l10) {
        for (int n10 : nArray) {
            Comparable comparable = c1.b(n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            c1 c12 = c1.b(n10);
            collection.add(c12);
        }
        return collection;
    }

    private static final Object s3(int[] nArray, Object object, p p10) {
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            c1 c12 = c1.b(d1.l(nArray, n10));
            object = p10.invoke(c12, object);
            n10 = n11;
        }
        return object;
    }

    private static final Map s4(short[] sArray, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        for (short s10 : sArray) {
            Object object = m1.b(s10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = m1.b(s10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    public static final g1 s5(long[] lArray) {
        f0.p(lArray, "$this$max");
        return UArraysKt___UArraysKt.k6(lArray);
    }

    public static final m1 s6(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        string2 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                m1 m12;
                short s11 = n1.l(sArray, n10);
                m1 m13 = m1.b(s10);
                int n12 = comparator.compare(m13, m12 = m1.b(s11));
                if (n12 < 0) {
                    s10 = s11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    public static final m1 s7(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.w7(sArray, comparator);
    }

    private static final long s8(long[] object, p p10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            g1 g12 = null;
            long l10 = f.h1.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    g12 = g1.b(l10);
                    long l11 = f.h1.l(object, n10);
                    g1 g13 = g1.b(l11);
                    g12 = (g1)p10.invoke(g12, g13);
                    l10 = g12.a0();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List s9(long[] lArray, Object object, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = f.h1.n(lArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        k k10 = ArraysKt___ArraysKt.Hd(lArray);
        int n11 = k10.e();
        n10 = k10.f();
        if (n11 <= n10) {
            while (true) {
                Integer n12 = n11;
                long l10 = f.h1.l(lArray, n11);
                g1 g12 = g1.b(l10);
                object = q10.invoke(n12, object, g12);
                arrayList.add(object);
                if (n11 == n10) break;
                ++n11;
            }
        }
        return arrayList;
    }

    public static final List sa(short[] sArray, Iterable object) {
        short s10;
        f0.p(sArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int s102 = u.Y((Iterable)((Object)object), 10);
        if (s102 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(s102);
        object = object.iterator();
        while ((s10 = object.hasNext()) != 0) {
            short s10 = ((Number)object.next()).intValue();
            s10 = n1.l(sArray, s10);
            object2 = m1.b(s10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static final long sb(long[] lArray) {
        return g1.h(ArraysKt___ArraysKt.Ov(lArray));
    }

    private static final long[] sc(long[] lArray) {
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        return lArray;
    }

    private static final short t0(short[] sArray) {
        f0.p(sArray, "$this$component5");
        return n1.l(sArray, 4);
    }

    public static final List t1(long[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(f.h1.n((long[])object) - n10, 0);
            return UArraysKt___UArraysKt.hc((long[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Collection t2(byte[] byArray, Collection collection, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            Comparable comparable = y0.b(by2);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            y0 y02 = y0.b(by2);
            collection.add(y02);
        }
        return collection;
    }

    private static final Object t3(short[] sArray, Object object, p p10) {
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            m1 m12 = m1.b(n1.l(sArray, n10));
            object = p10.invoke(m12, object);
            n10 = n11;
        }
        return object;
    }

    private static final Map t4(byte[] byArray, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        for (byte by2 : byArray) {
            Object object = y0.b(by2);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = y0.b(by2);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    public static final m1 t5(short[] sArray) {
        f0.p(sArray, "$this$max");
        return UArraysKt___UArraysKt.l6(sArray);
    }

    public static final g1 t6(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        string2 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                g1 g12;
                long l11 = f.h1.l(lArray, n10);
                g1 g13 = g1.b(l10);
                int n12 = comparator.compare(g13, g12 = g1.b(l11));
                if (n12 < 0) {
                    l10 = l11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    public static final g1 t7(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.x7(lArray, comparator);
    }

    private static final short t8(short[] object, p p10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            m1 m12 = null;
            s10 = n1.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    m12 = m1.b(s10);
                    short s11 = n1.l(object, n10);
                    m1 m13 = m1.b(s11);
                    m12 = (m1)p10.invoke(m12, m13);
                    s10 = m12.Y();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return s10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List t9(int[] nArray, Object object, f.h2.s.q q10) {
        boolean bl2 = d1.q(nArray);
        if (bl2) {
            return t.k(object);
        }
        int n10 = d1.n(nArray) + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.add(object);
        k k10 = ArraysKt___ArraysKt.Gd(nArray);
        int n11 = k10.e();
        n10 = k10.f();
        if (n11 <= n10) {
            while (true) {
                Integer n12 = n11;
                int n13 = d1.l(nArray, n11);
                c1 c12 = c1.b(n13);
                object = q10.invoke(n12, object, c12);
                arrayList.add(object);
                if (n11 == n10) break;
                ++n11;
            }
        }
        return arrayList;
    }

    public static final List ta(byte[] byArray, Iterable object) {
        byte by2;
        f0.p(byArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int by22 = u.Y((Iterable)((Object)object), 10);
        if (by22 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(by22);
        object = object.iterator();
        while ((by2 = object.hasNext()) != 0) {
            byte by2 = ((Number)object.next()).intValue();
            by2 = z0.l(byArray, by2);
            object2 = y0.b(by2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static final int tb(short[] sArray) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = sArray[i10];
            char c10 = (char)-1;
            n12 = c1.h(n12 & c10);
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    private static final short[] tc(short[] sArray) {
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        return sArray;
    }

    public static final boolean u0(short[] sArray, short[] sArray2) {
        if (sArray == null) {
            sArray = null;
        }
        if (sArray2 == null) {
            sArray2 = null;
        }
        return Arrays.equals(sArray, sArray2);
    }

    public static final List u1(byte[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(z0.n((byte[])object) - n10, 0);
            return UArraysKt___UArraysKt.ac((byte[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final y0 u2(byte[] object, f.h2.s.l l10) {
        block1: {
            int n10 = ((byte[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2 = object[i10];
                Comparable comparable = y0.b(by2);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = y0.b(by2);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final Object u3(byte[] byArray, Object object, f.h2.s.q q10) {
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            byte by2 = z0.l(byArray, i10);
            y0 y02 = y0.b(by2);
            object = q10.invoke(n10, y02, object);
        }
        return object;
    }

    private static final int u4(long[] lArray, long l10) {
        return ArraysKt___ArraysKt.cf(lArray, l10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final y0 u5(byte[] object, f.h2.s.l l10) {
        void var0_3;
        byte by2 = z0.q(object);
        if (by2 != 0) {
            return var0_3;
        }
        by2 = z0.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Ld(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = y0.b(by2);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    byte by3;
                    y0 y02;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(y02 = y0.b(by3 = z0.l(object, n11))))) < 0) {
                        by2 = by3;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        y0 y03 = y0.b(by2);
        return var0_3;
    }

    public static final c1 u6(int[] nArray) {
        f0.p(nArray, "$this$min");
        return UArraysKt___UArraysKt.m7(nArray);
    }

    public static final y0 u7(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        string2 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                y0 y02;
                byte by3 = z0.l(byArray, n10);
                y0 y03 = y0.b(by2);
                int n12 = comparator.compare(y03, y02 = y0.b(by3));
                if (n12 > 0) {
                    by2 = by3;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    private static final int u8(int[] object, f.h2.s.q q10) {
        int n10 = d1.q(object);
        if (n10 == 0) {
            c1 c12 = null;
            n10 = d1.l(object, 0);
            int n11 = 1;
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    Integer n13 = n11;
                    c12 = c1.b(n10);
                    int n14 = d1.l(object, n11);
                    c1 c13 = c1.b(n14);
                    c12 = (c1)q10.invoke(n13, c12, c13);
                    n10 = c12.a0();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List u9(byte[] byArray, p p10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        y0 y02 = null;
        by2 = z0.l(byArray, 0);
        int n10 = z0.n(byArray);
        ArrayList<y0> arrayList = new ArrayList<y0>(n10);
        y0 y03 = y0.b(by2);
        arrayList.add(y03);
        n10 = z0.n(byArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            y02 = y0.b(by2);
            byte by3 = z0.l(byArray, i10);
            y0 y04 = y0.b(by3);
            y02 = (y0)p10.invoke(y02, y04);
            by2 = y02.Y();
            y04 = y0.b(by2);
            arrayList.add(y04);
        }
        return arrayList;
    }

    public static final List ua(short[] sArray, k k10) {
        f0.p(sArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return b.d(n1.f(n.N1(sArray, n10, n11)));
    }

    private static final int ub(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            comparable = (c1)l10.invoke(comparable);
            int n12 = ((c1)comparable).a0();
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    public static final c1[] uc(int[] nArray) {
        String string2 = "$this$toTypedArray";
        f0.p(nArray, string2);
        int n10 = d1.n(nArray);
        c1[] c1Array = new c1[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            c1 c12;
            int n11 = d1.l(nArray, i10);
            c1Array[i10] = c12 = c1.b(n11);
        }
        return c1Array;
    }

    public static final boolean v0(int[] nArray, int[] nArray2) {
        if (nArray == null) {
            nArray = null;
        }
        if (nArray2 == null) {
            nArray2 = null;
        }
        return Arrays.equals(nArray, nArray2);
    }

    public static final List v1(short[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(n1.n((short[])object) - n10, 0);
            return UArraysKt___UArraysKt.bc((short[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final g1 v2(long[] object, f.h2.s.l l10) {
        block1: {
            int n10 = ((long[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                long l11 = object[i10];
                Comparable comparable = g1.b(l11);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = g1.b(l11);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final Object v3(short[] sArray, Object object, f.h2.s.q q10) {
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            short s10 = n1.l(sArray, i10);
            m1 m12 = m1.b(s10);
            object = q10.invoke(n10, m12, object);
        }
        return object;
    }

    private static final int v4(short[] sArray, short s10) {
        return ArraysKt___ArraysKt.ef(sArray, s10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final g1 v5(long[] object, f.h2.s.l l10) {
        void var0_3;
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            return var0_3;
        }
        bl2 = false;
        long l11 = f.h1.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = g1.b(l11);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    long l12;
                    g1 g12;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(g12 = g1.b(l12 = f.h1.l(object, n11))))) < 0) {
                        l11 = l12;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        g1 g13 = g1.b(l11);
        return var0_3;
    }

    public static final y0 v6(byte[] byArray) {
        f0.p(byArray, "$this$min");
        return UArraysKt___UArraysKt.n7(byArray);
    }

    public static final c1 v7(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        string2 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                c1 c12;
                int n13 = d1.l(nArray, n11);
                c1 c13 = c1.b(n10);
                int n14 = comparator.compare(c13, c12 = c1.b(n13));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    private static final byte v8(byte[] object, f.h2.s.q q10) {
        byte by2 = z0.q(object);
        if (by2 == 0) {
            y0 y02 = null;
            by2 = z0.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Ld(object);
            if (n10 <= n11) {
                while (true) {
                    Integer n12 = n10;
                    y02 = y0.b(by2);
                    byte by3 = z0.l(object, n10);
                    y0 y03 = y0.b(by3);
                    y02 = (y0)q10.invoke(n12, y02, y03);
                    by2 = y02.Y();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return by2;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List v9(int[] nArray, p p10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        c1 c12 = null;
        n10 = d1.l(nArray, 0);
        int n11 = d1.n(nArray);
        ArrayList<c1> arrayList = new ArrayList<c1>(n11);
        c1 c13 = c1.b(n10);
        arrayList.add(c13);
        n11 = d1.n(nArray);
        for (int i10 = 1; i10 < n11; ++i10) {
            c12 = c1.b(n10);
            int n12 = d1.l(nArray, i10);
            c1 c14 = c1.b(n12);
            c12 = (c1)p10.invoke(c12, c14);
            n10 = c12.a0();
            c14 = c1.b(n10);
            arrayList.add(c14);
        }
        return arrayList;
    }

    public static final List va(long[] lArray, k k10) {
        f0.p(lArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return b.c(f.h1.f(n.L1(lArray, n10, n11)));
    }

    private static final int vb(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Comparable comparable = g1.b(l11);
            comparable = (c1)l10.invoke(comparable);
            int n12 = ((c1)comparable).a0();
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    public static final y0[] vc(byte[] byArray) {
        String string2 = "$this$toTypedArray";
        f0.p(byArray, string2);
        int n10 = z0.n(byArray);
        y0[] y0Array = new y0[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            y0 y02;
            byte by2 = z0.l(byArray, i10);
            y0Array[i10] = y02 = y0.b(by2);
        }
        return y0Array;
    }

    public static final /* synthetic */ boolean w0(int[] nArray, int[] nArray2) {
        f0.p(nArray, "$this$contentEquals");
        f0.p(nArray2, "other");
        return UArraysKt___UArraysKt.v0(nArray, nArray2);
    }

    public static final List w1(int[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(d1.n((int[])object) - n10, 0);
            return UArraysKt___UArraysKt.cc((int[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final c1 w2(int[] object, f.h2.s.l l10) {
        block1: {
            int n10 = ((int[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = object[i10];
                Comparable comparable = c1.b(n11);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = c1.b(n11);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final Object w3(long[] lArray, Object object, f.h2.s.q q10) {
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            long l10 = f.h1.l(lArray, i10);
            g1 g12 = g1.b(l10);
            object = q10.invoke(n10, g12, object);
        }
        return object;
    }

    private static final int w4(byte[] byArray, byte by2) {
        return ArraysKt___ArraysKt.Xe(byArray, by2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final c1 w5(int[] object, f.h2.s.l l10) {
        void var0_3;
        int n10 = d1.q(object);
        if (n10 != 0) {
            return var0_3;
        }
        n10 = d1.l(object, 0);
        int n11 = ArraysKt___ArraysKt.Pd(object);
        if (n11 != 0) {
            void var1_4;
            Comparable comparable = c1.b(n10);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n12 = 1;
            if (n12 <= n11) {
                while (true) {
                    int n13;
                    c1 c12;
                    Comparable comparable2;
                    int n14;
                    if ((n14 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(c12 = c1.b(n13 = d1.l(object, n12))))) < 0) {
                        n10 = n13;
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
        }
        c1 c13 = c1.b(n10);
        return var0_3;
    }

    public static final g1 w6(long[] lArray) {
        f0.p(lArray, "$this$min");
        return UArraysKt___UArraysKt.o7(lArray);
    }

    public static final m1 w7(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return null;
        }
        string2 = null;
        s10 = n1.l(sArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n10 <= n11) {
            while (true) {
                m1 m12;
                short s11 = n1.l(sArray, n10);
                m1 m13 = m1.b(s10);
                int n12 = comparator.compare(m13, m12 = m1.b(s11));
                if (n12 > 0) {
                    s10 = s11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return m1.b(s10);
    }

    private static final short w8(short[] object, f.h2.s.q q10) {
        short s10 = n1.q(object);
        if (s10 == 0) {
            m1 m12 = null;
            s10 = n1.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Sd(object);
            if (n10 <= n11) {
                while (true) {
                    Integer n12 = n10;
                    m12 = m1.b(s10);
                    short s11 = n1.l(object, n10);
                    m1 m13 = m1.b(s11);
                    m12 = (m1)q10.invoke(n12, m12, m13);
                    s10 = m12.Y();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return s10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List w9(long[] lArray, p p10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        bl2 = false;
        g1 g12 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = f.h1.n(lArray);
        ArrayList<g1> arrayList = new ArrayList<g1>(n10);
        g1 g13 = g1.b(l10);
        arrayList.add(g13);
        n10 = f.h1.n(lArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            g12 = g1.b(l10);
            long l11 = f.h1.l(lArray, i10);
            g1 g14 = g1.b(l11);
            g12 = (g1)p10.invoke(g12, g14);
            l10 = g12.a0();
            g1 g15 = g1.b(l10);
            arrayList.add(g15);
        }
        return arrayList;
    }

    public static final List wa(byte[] byArray, k k10) {
        f0.p(byArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return b.b(z0.f(n.G1(byArray, n10, n11)));
    }

    private static final int wb(int[] nArray, f.h2.s.l l10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            c1 c12 = c1.b(nArray[i10]);
            c12 = (c1)l10.invoke(c12);
            int n12 = c12.a0();
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    public static final g1[] wc(long[] lArray) {
        String string2 = "$this$toTypedArray";
        f0.p(lArray, string2);
        int n10 = f.h1.n(lArray);
        g1[] g1Array = new g1[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            g1 g12;
            long l10 = f.h1.l(lArray, i10);
            g1Array[i10] = g12 = g1.b(l10);
        }
        return g1Array;
    }

    public static final boolean x0(byte[] byArray, byte[] byArray2) {
        if (byArray == null) {
            byArray = null;
        }
        if (byArray2 == null) {
            byArray2 = null;
        }
        return Arrays.equals(byArray, byArray2);
    }

    public static final List x1(long[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(f.h1.n((long[])object) - n10, 0);
            return UArraysKt___UArraysKt.dc((long[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final m1 x2(short[] object, f.h2.s.l l10) {
        block1: {
            int n10 = ((short[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                short s10 = object[i10];
                Comparable comparable = m1.b(s10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = m1.b(s10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final Object x3(int[] nArray, Object object, f.h2.s.q q10) {
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            int n11 = d1.l(nArray, i10);
            c1 c12 = c1.b(n11);
            object = q10.invoke(n10, c12, object);
        }
        return object;
    }

    private static final int x4(int[] nArray, int n10) {
        return ArraysKt___ArraysKt.bf(nArray, n10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final m1 x5(short[] object, f.h2.s.l l10) {
        void var0_3;
        short s10 = n1.q(object);
        if (s10 != 0) {
            return var0_3;
        }
        s10 = n1.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Sd(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = m1.b(s10);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    short s11;
                    m1 m12;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(m12 = m1.b(s11 = n1.l(object, n11))))) < 0) {
                        s10 = s11;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        m1 m13 = m1.b(s10);
        return var0_3;
    }

    public static final m1 x6(short[] sArray) {
        f0.p(sArray, "$this$min");
        return UArraysKt___UArraysKt.p7(sArray);
    }

    public static final g1 x7(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        string2 = null;
        long l10 = f.h1.l(lArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 <= n11) {
            while (true) {
                g1 g12;
                long l11 = f.h1.l(lArray, n10);
                g1 g13 = g1.b(l10);
                int n12 = comparator.compare(g13, g12 = g1.b(l11));
                if (n12 > 0) {
                    l10 = l11;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return g1.b(l10);
    }

    private static final long x8(long[] object, f.h2.s.q q10) {
        boolean bl2 = f.h1.q(object);
        if (!bl2) {
            bl2 = false;
            g1 g12 = null;
            long l10 = f.h1.l(object, 0);
            int n10 = 1;
            int n11 = ArraysKt___ArraysKt.Qd(object);
            if (n10 <= n11) {
                while (true) {
                    Integer n12 = n10;
                    g12 = g1.b(l10);
                    long l11 = f.h1.l(object, n10);
                    g1 g13 = g1.b(l11);
                    g12 = (g1)q10.invoke(n12, g12, g13);
                    l10 = g12.a0();
                    if (n10 == n11) break;
                    ++n10;
                }
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    private static final List x9(short[] sArray, p p10) {
        short s10 = n1.q(sArray);
        if (s10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        m1 m12 = null;
        s10 = n1.l(sArray, 0);
        int n10 = n1.n(sArray);
        ArrayList<m1> arrayList = new ArrayList<m1>(n10);
        m1 m13 = m1.b(s10);
        arrayList.add(m13);
        n10 = n1.n(sArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            m12 = m1.b(s10);
            short s11 = n1.l(sArray, i10);
            m1 m14 = m1.b(s11);
            m12 = (m1)p10.invoke(m12, m14);
            s10 = m12.Y();
            m14 = m1.b(s10);
            arrayList.add(m14);
        }
        return arrayList;
    }

    public static final List xa(int[] nArray, k k10) {
        f0.p(nArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return b.a(d1.f(n.K1(nArray, n10, n11)));
    }

    private static final int xb(short[] sArray, f.h2.s.l l10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = m1.b(sArray[i10]);
            comparable = (c1)l10.invoke(comparable);
            int n12 = ((c1)comparable).a0();
            n11 = c1.h(n11 + n12);
        }
        return n11;
    }

    public static final m1[] xc(short[] sArray) {
        String string2 = "$this$toTypedArray";
        f0.p(sArray, string2);
        int n10 = n1.n(sArray);
        m1[] m1Array = new m1[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            m1 m12;
            short s10 = n1.l(sArray, i10);
            m1Array[i10] = m12 = m1.b(s10);
        }
        return m1Array;
    }

    private static final boolean y(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable comparable = y0.b(byArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final /* synthetic */ boolean y0(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "$this$contentEquals");
        f0.p(byArray2, "other");
        return UArraysKt___UArraysKt.x0(byArray, byArray2);
    }

    private static final List y1(byte[] byArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Comparable comparable = y0.b(z0.l(byArray, i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.ac(byArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    private static final y0 y2(byte[] object, f.h2.s.l l10) {
        block3: {
            int n10;
            k k10 = ArraysKt___ArraysKt.Cd(object);
            int n11 = k10.f();
            if (n11 >= (n10 = k10.e())) {
                while (true) {
                    byte by2 = z0.l(object, n11);
                    Comparable comparable = y0.b(by2);
                    boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                    if (bl2) {
                        object = y0.b(by2);
                        break block3;
                    }
                    if (n11 == n10) break;
                    n11 += -1;
                }
            }
            object = null;
        }
        return object;
    }

    private static final void y3(byte[] byArray, f.h2.s.l l10) {
        for (byte by2 : byArray) {
            y0 y02 = y0.b(by2);
            l10.invoke(y02);
        }
    }

    private static final int y4(byte[] byArray, f.h2.s.l l10) {
        int n10;
        block2: {
            int n11 = byArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Comparable comparable = y0.b(y0.h(byArray[n10]));
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private static final y0 y5(byte[] byArray, f.h2.s.l l10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        by2 = z0.l(byArray, 0);
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 == 0) {
            return y0.b(by2);
        }
        Comparable comparable = y0.b(by2);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                byte by3 = z0.l(byArray, n11);
                Comparable comparable2 = y0.b(by3);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    by2 = by3;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return y0.b(by2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final y0 y6(byte[] object, f.h2.s.l l10) {
        void var0_3;
        byte by2 = z0.q(object);
        if (by2 != 0) {
            return var0_3;
        }
        by2 = z0.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Ld(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = y0.b(by2);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    byte by3;
                    y0 y02;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(y02 = y0.b(by3 = z0.l(object, n11))))) > 0) {
                        by2 = by3;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        y0 y03 = y0.b(by2);
        return var0_3;
    }

    private static final boolean y7(int[] nArray) {
        return d1.q(nArray);
    }

    private static final c1 y8(int[] nArray, f.h2.s.q q10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return null;
        }
        c1 c12 = null;
        n10 = d1.l(nArray, 0);
        int n11 = 1;
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                Integer n13 = n11;
                c12 = c1.b(n10);
                int n14 = d1.l(nArray, n11);
                c1 c13 = c1.b(n14);
                c12 = (c1)q10.invoke(n13, c12, c13);
                n10 = c12.a0();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return c1.b(n10);
    }

    private static final List y9(int[] nArray, f.h2.s.q q10) {
        int n10 = d1.q(nArray);
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        c1 c12 = null;
        n10 = d1.l(nArray, 0);
        int n11 = d1.n(nArray);
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n11);
        c1 c13 = c1.b(n10);
        arrayList.add(c13);
        n11 = d1.n(nArray);
        for (int i10 = 1; i10 < n11; ++i10) {
            Comparable<Integer> comparable = i10;
            c12 = c1.b(n10);
            int n12 = d1.l(nArray, i10);
            c1 c14 = c1.b(n12);
            c12 = (c1)q10.invoke(comparable, c12, c14);
            n10 = c12.a0();
            comparable = c1.b(n10);
            arrayList.add(comparable);
        }
        return arrayList;
    }

    public static final int[] ya(int[] nArray, Collection collection) {
        f0.p(nArray, "$this$sliceArray");
        f0.p(collection, "indices");
        return d1.f(ArraysKt___ArraysKt.Qt(nArray, collection));
    }

    private static final double yb(byte[] byArray, f.h2.s.l l10) {
        int n10 = byArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Object object = y0.b(by2);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final byte[] yc(byte[] byArray) {
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        return z0.f(byArray);
    }

    private static final boolean z(long[] lArray, f.h2.s.l l10) {
        for (long l11 : lArray) {
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final boolean z0(long[] lArray, long[] lArray2) {
        if (lArray == null) {
            lArray = null;
        }
        if (lArray2 == null) {
            lArray2 = null;
        }
        return Arrays.equals(lArray, lArray2);
    }

    private static final List z1(long[] lArray, f.h2.s.l l10) {
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            long l11 = f.h1.l(lArray, i10);
            Comparable comparable = g1.b(l11);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return UArraysKt___UArraysKt.dc(lArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    private static final g1 z2(long[] object, f.h2.s.l l10) {
        block3: {
            int n10;
            k k10 = ArraysKt___ArraysKt.Hd(object);
            int n11 = k10.f();
            if (n11 >= (n10 = k10.e())) {
                while (true) {
                    long l11 = f.h1.l(object, n11);
                    Comparable comparable = g1.b(l11);
                    boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                    if (bl2) {
                        object = g1.b(l11);
                        break block3;
                    }
                    if (n11 == n10) break;
                    n11 += -1;
                }
            }
            object = null;
        }
        return object;
    }

    private static final void z3(long[] lArray, f.h2.s.l l10) {
        for (long l11 : lArray) {
            g1 g12 = g1.b(l11);
            l10.invoke(g12);
        }
    }

    private static final int z4(long[] lArray, f.h2.s.l l10) {
        int n10;
        block2: {
            int n11 = lArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                long l11 = g1.h(lArray[n10]);
                Comparable comparable = g1.b(l11);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    private static final g1 z5(long[] lArray, f.h2.s.l l10) {
        boolean bl2 = f.h1.q(lArray);
        if (bl2) {
            return null;
        }
        bl2 = false;
        long l11 = f.h1.l(lArray, 0);
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 == 0) {
            return g1.b(l11);
        }
        Comparable comparable = g1.b(l11);
        comparable = (Comparable)l10.invoke(comparable);
        int n11 = 1;
        if (n11 <= n10) {
            while (true) {
                long l12 = f.h1.l(lArray, n11);
                Comparable comparable2 = g1.b(l12);
                int n12 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(comparable2));
                if (n12 < 0) {
                    l11 = l12;
                    comparable = comparable2;
                }
                if (n11 == n10) break;
                ++n11;
            }
        }
        return g1.b(l11);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final g1 z6(long[] object, f.h2.s.l l10) {
        void var0_3;
        boolean bl2 = f.h1.q(object);
        if (bl2) {
            return var0_3;
        }
        bl2 = false;
        long l11 = f.h1.l(object, 0);
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 != 0) {
            void var1_4;
            Comparable comparable = g1.b(l11);
            comparable = (Comparable)var1_4.invoke(comparable);
            int n11 = 1;
            if (n11 <= n10) {
                while (true) {
                    long l12;
                    g1 g12;
                    Comparable comparable2;
                    int n12;
                    if ((n12 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(g12 = g1.b(l12 = f.h1.l(object, n11))))) > 0) {
                        l11 = l12;
                        comparable = comparable2;
                    }
                    if (n11 == n10) break;
                    ++n11;
                }
            }
        }
        g1 g13 = g1.b(l11);
        return var0_3;
    }

    private static final boolean z7(byte[] byArray) {
        return z0.q(byArray);
    }

    private static final y0 z8(byte[] byArray, f.h2.s.q q10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return null;
        }
        y0 y02 = null;
        by2 = z0.l(byArray, 0);
        int n10 = 1;
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n10 <= n11) {
            while (true) {
                Integer n12 = n10;
                y02 = y0.b(by2);
                byte by3 = z0.l(byArray, n10);
                y0 y03 = y0.b(by3);
                y02 = (y0)q10.invoke(n12, y02, y03);
                by2 = y02.Y();
                if (n10 == n11) break;
                ++n10;
            }
        }
        return y0.b(by2);
    }

    private static final List z9(byte[] byArray, f.h2.s.q q10) {
        byte by2 = z0.q(byArray);
        if (by2 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        y0 y02 = null;
        by2 = z0.l(byArray, 0);
        int n10 = z0.n(byArray);
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>(n10);
        y0 y03 = y0.b(by2);
        arrayList.add(y03);
        n10 = z0.n(byArray);
        for (int i10 = 1; i10 < n10; ++i10) {
            Comparable<Integer> comparable = i10;
            y02 = y0.b(by2);
            byte by3 = z0.l(byArray, i10);
            y0 y04 = y0.b(by3);
            y02 = (y0)q10.invoke(comparable, y02, y04);
            by2 = y02.Y();
            comparable = y0.b(by2);
            arrayList.add(comparable);
        }
        return arrayList;
    }

    public static final short[] za(short[] sArray, k k10) {
        f0.p(sArray, "$this$sliceArray");
        f0.p(k10, "indices");
        return n1.f(ArraysKt___ArraysKt.Xt(sArray, k10));
    }

    private static final double zb(long[] lArray, f.h2.s.l l10) {
        int n10 = lArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Object object = g1.b(l11);
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final byte[] zc(y0[] y0Array) {
        String string2 = "$this$toUByteArray";
        f0.p(y0Array, string2);
        int n10 = y0Array.length;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            y0 y02 = y0Array[i10];
            byArray[i10] = by2 = y02.Y();
        }
        return z0.f(byArray);
    }
}

