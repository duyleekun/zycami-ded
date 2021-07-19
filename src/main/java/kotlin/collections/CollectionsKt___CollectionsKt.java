/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.d2.l;
import f.g1;
import f.h2.s.p;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.k;
import f.l2.q;
import f.n2.m;
import f.q2.n;
import f.w0;
import f.x1.a0;
import f.x1.c1;
import f.x1.d1;
import f.x1.e0;
import f.x1.j0;
import f.x1.s0;
import f.x1.t;
import f.x1.u;
import f.x1.v0;
import f.x1.x;
import f.x1.y;
import f.y1.b;
import f.y1.b$b;
import f.y1.b$d;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$a;
import kotlin.collections.CollectionsKt___CollectionsKt$b;
import kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1;
import kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1;
import kotlin.collections.SlidingWindowKt;
import kotlin.sequences.SequencesKt___SequencesKt;

public class CollectionsKt___CollectionsKt
extends a0 {
    public static final double A1(Iterable object) {
        boolean bl2;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            long l10 = number.longValue();
            double d11 = l10;
            d10 += d11;
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n10 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n10;
            d10 /= d12;
        }
        return d10;
    }

    public static final Object A2(Iterable object, Object object2, p p10) {
        boolean bl2;
        f0.p(object, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            object2 = p10.invoke(object2, string2);
        }
        return object2;
    }

    private static final Float A3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Number)l10.invoke(object2);
        float f10 = ((Number)object2).floatValue();
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            object3 = (Number)l10.invoke(object3);
            float f11 = ((Number)object3).floatValue();
            f10 = Math.max(f10, f11);
        }
        return Float.valueOf(f10);
    }

    public static final Object A4(Iterable object, f.h2.s.q q10) {
        int n10;
        int n11;
        f0.p(object, "$this$reduceIndexedOrNull");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return null;
        }
        object2 = object.next();
        int n12 = n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            n10 = n12 + 1;
            if (n12 < 0) {
                boolean bl3 = l.a(n11, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            Integer n13 = n12;
            Object e10 = object.next();
            object2 = q10.invoke(n13, object2, e10);
            n12 = n10;
        }
        return object2;
    }

    public static final boolean[] A5(Collection object) {
        boolean bl2;
        f0.p(object, "$this$toBooleanArray");
        int n10 = object.size();
        boolean[] blArray = new boolean[n10];
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Boolean bl3 = (Boolean)object.next();
            bl2 = bl3;
            int n12 = n11 + 1;
            blArray[n11] = bl2;
            n11 = n12;
        }
        return blArray;
    }

    public static final double B1(Iterable object) {
        short s10;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n10 = 0;
        while ((s10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            s10 = number.shortValue();
            double d11 = s10;
            d10 += d11;
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n10 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n10;
            d10 /= d12;
        }
        return d10;
    }

    public static final Object B2(Iterable object, Object object2, f.h2.s.q q10) {
        boolean bl2;
        f0.p(object, "$this$foldIndexed");
        f0.p(q10, "operation");
        object = object.iterator();
        int n10 = 0;
        Integer n11 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n10 + 1;
            if (n10 < 0) {
                int n13 = 1;
                boolean bl3 = l.a(n13, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            n11 = n10;
            object2 = q10.invoke(n11, object2, e10);
            n10 = n12;
        }
        return object2;
    }

    private static final Object B3(Iterable object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
                if (n10 >= 0) continue;
                object2 = object3;
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final Object B4(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$reduceOrNull");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = object.next();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            object2 = p10.invoke(object2, e10);
        }
        return object2;
    }

    public static final byte[] B5(Collection object) {
        byte by2;
        f0.p(object, "$this$toByteArray");
        int n10 = object.size();
        byte[] byArray = new byte[n10];
        object = object.iterator();
        int n11 = 0;
        while ((by2 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            by2 = number.byteValue();
            int n12 = n11 + 1;
            byArray[n11] = by2;
            n11 = n12;
        }
        return byArray;
    }

    public static final List C1(Iterable iterable, int n10) {
        f0.p(iterable, "$this$chunked");
        return CollectionsKt___CollectionsKt.Q5(iterable, n10, n10, true);
    }

    public static final Object C2(List object, Object object2, p p10) {
        f0.p(object, "$this$foldRight");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            n10 = object.size();
            object = object.listIterator(n10);
            while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
                string2 = object.previous();
                object2 = p10.invoke(string2, object2);
            }
        }
        return object2;
    }

    private static final Object C3(Iterable object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = l10.invoke(object2);
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
            if (n10 >= 0) continue;
            object2 = object3;
        }
        return object2;
    }

    public static final Object C4(List object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = object.size();
        object = object.listIterator(n10);
        n10 = (int)(object.hasPrevious() ? 1 : 0);
        if (n10 != 0) {
            boolean bl2;
            object2 = object.previous();
            while (bl2 = object.hasPrevious()) {
                Object e10 = object.previous();
                object2 = p10.invoke(e10, object2);
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty list can't be reduced.");
        throw object;
    }

    public static final char[] C5(Collection object) {
        char c10;
        f0.p(object, "$this$toCharArray");
        int n10 = object.size();
        char[] cArray = new char[n10];
        object = object.iterator();
        int n11 = 0;
        while ((c10 = object.hasNext()) != '\u0000') {
            Character c11 = (Character)object.next();
            c10 = c11.charValue();
            int n12 = n11 + 1;
            cArray[n11] = c10;
            n11 = n12;
        }
        return cArray;
    }

    public static final List D1(Iterable iterable, int n10, f.h2.s.l l10) {
        f0.p(iterable, "$this$chunked");
        f0.p(l10, "transform");
        return CollectionsKt___CollectionsKt.R5(iterable, n10, n10, true, l10);
    }

    public static final Object D2(List object, Object object2, f.h2.s.q q10) {
        f0.p(object, "$this$foldRightIndexed");
        Object object3 = "operation";
        f0.p(q10, (String)object3);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            n10 = object.size();
            object = object.listIterator(n10);
            while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
                n10 = object.previousIndex();
                object3 = n10;
                Object e10 = object.previous();
                object2 = q10.invoke(object3, e10, object2);
            }
        }
        return object2;
    }

    public static final Comparable D3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$maxOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Comparable)object.next();
        while (bl2 = object.hasNext()) {
            Comparable comparable = (Comparable)object.next();
            int n10 = object2.compareTo(comparable);
            if (n10 >= 0) continue;
            object2 = comparable;
        }
        return object2;
    }

    public static final Object D4(List object, f.h2.s.q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = object.size();
        object = object.listIterator(n10);
        n10 = (int)(object.hasPrevious() ? 1 : 0);
        if (n10 != 0) {
            int n11;
            object2 = object.previous();
            while ((n11 = object.hasPrevious()) != 0) {
                n11 = object.previousIndex();
                Integer n12 = n11;
                Object e10 = object.previous();
                object2 = q10.invoke(n12, e10, object2);
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty list can't be reduced.");
        throw object;
    }

    public static final Collection D5(Iterable object, Collection collection) {
        boolean bl2;
        f0.p(object, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            collection.add(string2);
        }
        return collection;
    }

    private static final Object E1(List list) {
        f0.p(list, "$this$component1");
        return list.get(0);
    }

    public static final void E2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            l10.invoke(string2);
        }
    }

    public static final Double E3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$maxOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Number)object.next();
        double d10 = ((Number)object2).doubleValue();
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d11 = number.doubleValue();
            d10 = Math.max(d10, d11);
        }
        return d10;
    }

    public static final Object E4(List object, f.h2.s.q q10) {
        int n10;
        f0.p(object, "$this$reduceRightIndexedOrNull");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n11 = object.size();
        object = object.listIterator(n11);
        n11 = (int)(object.hasPrevious() ? 1 : 0);
        if (n11 == 0) {
            return null;
        }
        object2 = object.previous();
        while ((n10 = object.hasPrevious()) != 0) {
            n10 = object.previousIndex();
            Integer n12 = n10;
            Object e10 = object.previous();
            object2 = q10.invoke(n12, e10, object2);
        }
        return object2;
    }

    public static final double[] E5(Collection object) {
        boolean bl2;
        f0.p(object, "$this$toDoubleArray");
        int n10 = object.size();
        double[] dArray = new double[n10];
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d10 = number.doubleValue();
            int n12 = n11 + 1;
            dArray[n11] = d10;
            n11 = n12;
        }
        return dArray;
    }

    private static final Object F1(List list) {
        f0.p(list, "$this$component2");
        return list.get(1);
    }

    public static final void F2(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$forEachIndexed");
        f0.p(p10, "action");
        object = object.iterator();
        int n10 = 0;
        Integer n11 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n10 + 1;
            if (n10 < 0) {
                int n13 = 1;
                boolean bl3 = l.a(n13, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            n11 = n10;
            p10.invoke(n11, e10);
            n10 = n12;
        }
    }

    public static final Float F3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$maxOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Number)object.next();
        float f10 = ((Number)object2).floatValue();
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            float f11 = number.floatValue();
            f10 = Math.max(f10, f11);
        }
        return Float.valueOf(f10);
    }

    public static final Object F4(List object, p p10) {
        boolean bl2;
        f0.p(object, "$this$reduceRightOrNull");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = object.size();
        object = object.listIterator(n10);
        n10 = (int)(object.hasPrevious() ? 1 : 0);
        if (n10 == 0) {
            return null;
        }
        object2 = object.previous();
        while (bl2 = object.hasPrevious()) {
            Object e10 = object.previous();
            object2 = p10.invoke(e10, object2);
        }
        return object2;
    }

    public static final float[] F5(Collection object) {
        boolean bl2;
        f0.p(object, "$this$toFloatArray");
        int n10 = object.size();
        float[] fArray = new float[n10];
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            float f10 = number.floatValue();
            int n12 = n11 + 1;
            fArray[n11] = f10;
            n11 = n12;
        }
        return fArray;
    }

    private static final Object G1(List list) {
        f0.p(list, "$this$component3");
        return list.get(2);
    }

    private static final Object G2(List object, int n10, f.h2.s.l l10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = CollectionsKt__CollectionsKt.G((List)object))) {
            object = object.get(n10);
        } else {
            object = n10;
            object = l10.invoke(object);
        }
        return object;
    }

    public static final Object G3(Iterable iterable, Comparator comparator) {
        f0.p(iterable, "$this$maxWith");
        f0.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.H3(iterable, comparator);
    }

    public static final Iterable G4(Iterable object) {
        boolean bl2;
        f0.p(object, "$this$requireNoNulls");
        Object object2 = object.iterator();
        while (bl2 = object2.hasNext()) {
            Object object3 = object2.next();
            if (object3 != null) continue;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("null element found in ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append('.');
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        return object;
    }

    public static final HashSet G5(Iterable iterable) {
        f0.p(iterable, "$this$toHashSet");
        int n10 = s0.j(u.Y(iterable, 12));
        HashSet hashSet = new HashSet(n10);
        return (HashSet)CollectionsKt___CollectionsKt.D5(iterable, hashSet);
    }

    private static final Object H1(List list) {
        f0.p(list, "$this$component4");
        return list.get(3);
    }

    public static final Object H2(List list, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(list, string2);
        list = n10 >= 0 && n10 <= (n11 = CollectionsKt__CollectionsKt.G(list)) ? list.get(n10) : null;
        return list;
    }

    public static final Object H3(Iterable object, Comparator comparator) {
        boolean bl2;
        f0.p(object, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        string2 = object.next();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n10 = comparator.compare(string2, e10);
            if (n10 >= 0) continue;
            string2 = e10;
        }
        return string2;
    }

    public static final List H4(List object) {
        boolean bl2;
        f0.p(object, "$this$requireNoNulls");
        Object object2 = object.iterator();
        while (bl2 = object2.hasNext()) {
            Object object3 = object2.next();
            if (object3 != null) continue;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("null element found in ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append('.');
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        return object;
    }

    public static final int[] H5(Collection object) {
        int n10;
        f0.p(object, "$this$toIntArray");
        int n11 = object.size();
        int[] nArray = new int[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            nArray[n12] = n10;
            n12 = n13;
        }
        return nArray;
    }

    private static final Object I1(List list) {
        f0.p(list, "$this$component5");
        return list.get(4);
    }

    public static final Map I2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = l10.invoke(e10);
            Object object3 = linkedHashMap.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                linkedHashMap.put(object2, object3);
            }
            object3 = (List)object3;
            object3.add(e10);
        }
        return linkedHashMap;
    }

    public static final Comparable I3(Iterable iterable) {
        f0.p(iterable, "$this$min");
        return CollectionsKt___CollectionsKt.V3(iterable);
    }

    public static final List I4(Iterable iterable) {
        Object object = "$this$reversed";
        f0.p(iterable, (String)object);
        int n10 = iterable instanceof Collection;
        if (n10 != 0) {
            int n11;
            object = iterable;
            object = (Collection)iterable;
            n10 = object.size();
            if (n10 <= (n11 = 1)) {
                return CollectionsKt___CollectionsKt.I5(iterable);
            }
        }
        iterable = CollectionsKt___CollectionsKt.K5(iterable);
        a0.e1((List)iterable);
        return iterable;
    }

    public static final List I5(Iterable iterable) {
        Object object = "$this$toList";
        f0.p(iterable, (String)object);
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            object = iterable;
            object = (Collection)iterable;
            int n10 = object.size();
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    iterable = CollectionsKt___CollectionsKt.L5((Collection)object);
                } else {
                    bl2 = iterable instanceof List;
                    if (bl2) {
                        iterable = (List)iterable;
                        bl2 = false;
                        object = null;
                        iterable = iterable.get(0);
                    } else {
                        iterable = iterable.iterator().next();
                    }
                    iterable = t.k(iterable);
                }
            } else {
                iterable = CollectionsKt__CollectionsKt.E();
            }
            return iterable;
        }
        return CollectionsKt__CollectionsKt.Q(CollectionsKt___CollectionsKt.K5(iterable));
    }

    public static final boolean J1(Iterable iterable, Object object) {
        String string2 = "$this$contains";
        f0.p(iterable, string2);
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ((Collection)iterable).contains(object);
        }
        int n10 = CollectionsKt___CollectionsKt.N2(iterable, object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            iterable = null;
        }
        return n10 != 0;
    }

    public static final Map J2(Iterable object, f.h2.s.l l10, f.h2.s.l l11) {
        boolean bl2;
        f0.p(object, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            Object object3 = l10.invoke(object2);
            Object object4 = linkedHashMap.get(object3);
            if (object4 == null) {
                object4 = new ArrayList();
                linkedHashMap.put(object3, object4);
            }
            object4 = (List)object4;
            object2 = l11.invoke(object2);
            object4.add(object2);
        }
        return linkedHashMap;
    }

    public static final Double J3(Iterable iterable) {
        f0.p(iterable, "$this$min");
        return CollectionsKt___CollectionsKt.W3(iterable);
    }

    public static final List J4(Iterable object, Object object2, p p10) {
        f0.p(object, "$this$runningFold");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = u.Y((Iterable)object, 9);
        if (n10 == 0) {
            return t.k(object2);
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(++n10);
        arrayList.add(object2);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            string2 = object.next();
            object2 = p10.invoke(object2, string2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final long[] J5(Collection object) {
        boolean bl2;
        f0.p(object, "$this$toLongArray");
        int n10 = object.size();
        long[] lArray = new long[n10];
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            long l10 = number.longValue();
            int n12 = n11 + 1;
            lArray[n11] = l10;
            n11 = n12;
        }
        return lArray;
    }

    public static final int K1(Iterable object) {
        boolean bl2;
        String string2 = "$this$count";
        f0.p(object, string2);
        int n10 = object instanceof Collection;
        if (n10 != 0) {
            return ((Collection)object).size();
        }
        n10 = 0;
        string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object.next();
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        return n10;
    }

    public static final Map K2(Iterable object, Map map, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Object object2 = l10.invoke(string2);
            Object object3 = map.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                map.put(object2, object3);
            }
            object3 = (List)object3;
            object3.add((String)string2);
        }
        return map;
    }

    public static final Float K3(Iterable iterable) {
        f0.p(iterable, "$this$min");
        return CollectionsKt___CollectionsKt.X3(iterable);
    }

    public static final List K4(Iterable object, Object object2, f.h2.s.q q10) {
        boolean bl2;
        f0.p(object, "$this$runningFoldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = u.Y((Iterable)object, 9);
        if (n10 == 0) {
            return t.k(object2);
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(++n10);
        arrayList.add(object2);
        n10 = 0;
        string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Integer n11 = n10;
            ++n10;
            object2 = q10.invoke(n11, object2, e10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List K5(Iterable iterable) {
        ArrayList arrayList = "$this$toMutableList";
        f0.p(iterable, (String)((Object)arrayList));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return CollectionsKt___CollectionsKt.L5((Collection)iterable);
        }
        arrayList = new ArrayList();
        return (List)CollectionsKt___CollectionsKt.D5(iterable, arrayList);
    }

    public static final int L1(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$count");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        int n10 = object instanceof Collection;
        if (n10 != 0) {
            object2 = object;
            object2 = (Collection)object;
            n10 = object2.isEmpty();
            if (n10 != 0) {
                return 0;
            }
        }
        object = object.iterator();
        n10 = 0;
        object2 = null;
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            bl2 = (Boolean)(object3 = (Boolean)l10.invoke(object3));
            if (!bl2 || ++n10 >= 0) continue;
            int n11 = 1;
            bl2 = l.a(n11, 3, 0);
            if (bl2) {
                CollectionsKt__CollectionsKt.V();
                continue;
            }
            object = new ArithmeticException("Count overflow has happened.");
            throw object;
        }
        return n10;
    }

    public static final Map L2(Iterable object, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        boolean bl2;
        f0.p(object, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        Object object2 = "valueTransform";
        f0.p(l11, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            Object object3 = l10.invoke(object2);
            Object object4 = map.get(object3);
            if (object4 == null) {
                object4 = new ArrayList();
                map.put(object3, object4);
            }
            object4 = (List)object4;
            object2 = l11.invoke(object2);
            object4.add((Object)object2);
        }
        return map;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object L3(Iterable iterator2, f.h2.s.l l10) {
        boolean bl2;
        void var2_4;
        f0.p(iterator2, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        iterator2 = iterator2.iterator();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return null;
        }
        Object t10 = iterator2.next();
        boolean bl4 = iterator2.hasNext();
        if (!bl4) {
            return var2_4;
        }
        Comparable comparable = (Comparable)l10.invoke(t10);
        do {
            Object t11;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) <= 0) continue;
            Object t12 = t11;
            comparable = comparable2;
        } while (bl2 = iterator2.hasNext());
        return var2_4;
    }

    public static final List L4(Iterable iterable, p p10) {
        f0.p(iterable, "$this$runningReduce");
        f0.p(p10, "operation");
        Iterator iterator2 = iterable.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        Object object = iterator2.next();
        int n10 = 10;
        int n11 = u.Y(iterable, n10);
        ArrayList arrayList = new ArrayList(n11);
        arrayList.add(object);
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            iterable = iterator2.next();
            object = p10.invoke(object, iterable);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List L5(Collection collection) {
        f0.p(collection, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(collection);
        return arrayList;
    }

    private static final int M1(Collection collection) {
        return collection.size();
    }

    public static final e0 M2(Iterable iterable, f.h2.s.l l10) {
        f0.p(iterable, "$this$groupingBy");
        f0.p(l10, "keySelector");
        CollectionsKt___CollectionsKt$b collectionsKt___CollectionsKt$b = new CollectionsKt___CollectionsKt$b(iterable, l10);
        return collectionsKt___CollectionsKt$b;
    }

    public static final Object M3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        string2 = object.next();
        boolean bl4 = object.hasNext();
        if (!bl4) {
            return string2;
        }
        Comparable comparable = (Comparable)l10.invoke(string2);
        do {
            Object e10;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(e10 = object.next()))) <= 0) continue;
            string2 = e10;
            comparable = comparable2;
        } while (bl2 = object.hasNext());
        return string2;
    }

    public static final List M4(Iterable iterable, f.h2.s.q q10) {
        boolean bl2;
        f0.p(iterable, "$this$runningReduceIndexed");
        f0.p(q10, "operation");
        Iterator iterator2 = iterable.iterator();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return CollectionsKt__CollectionsKt.E();
        }
        Object object = iterator2.next();
        int n10 = u.Y(iterable, 10);
        ArrayList arrayList = new ArrayList(n10);
        arrayList.add(object);
        int n11 = n10 = 1;
        while (bl2 = iterator2.hasNext()) {
            Integer n12 = n11;
            n11 += n10;
            Object t10 = iterator2.next();
            object = q10.invoke(n12, object, t10);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Set M5(Iterable iterable) {
        LinkedHashSet linkedHashSet = "$this$toMutableSet";
        f0.p(iterable, (String)((Object)linkedHashSet));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = (Collection)iterable;
            linkedHashSet = new LinkedHashSet(iterable);
        } else {
            linkedHashSet = new LinkedHashSet();
            iterable = CollectionsKt___CollectionsKt.D5(iterable, linkedHashSet);
            linkedHashSet = iterable;
            linkedHashSet = (LinkedHashSet)iterable;
        }
        return linkedHashSet;
    }

    public static final List N1(Iterable iterable) {
        f0.p(iterable, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(CollectionsKt___CollectionsKt.M5(iterable));
    }

    public static final int N2(Iterable object, Object object2) {
        boolean bl2;
        String string2 = "$this$indexOf";
        f0.p(object, string2);
        int n10 = object instanceof List;
        if (n10 != 0) {
            return ((List)object).indexOf(object2);
        }
        n10 = 0;
        string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (bl2 = f0.g(object2, e10)) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private static final double N3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (Number)l10.invoke(object3);
                double d11 = ((Number)object3).doubleValue();
                d10 = Math.min(d10, d11);
            }
            return d10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final List N4(Iterable arrayList, Object object, p p10) {
        f0.p(arrayList, "$this$scan");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = u.Y(arrayList, 9);
        if (n10 == 0) {
            arrayList = t.k(object);
        } else {
            ArrayList<Object> arrayList2 = new ArrayList<Object>(++n10);
            arrayList2.add(object);
            arrayList = arrayList.iterator();
            while ((n10 = (int)(arrayList.hasNext() ? 1 : 0)) != 0) {
                string2 = arrayList.next();
                object = p10.invoke(object, string2);
                arrayList2.add(object);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final Set N5(Iterable iterable) {
        Collection collection = "$this$toSet";
        f0.p(iterable, (String)((Object)collection));
        int n10 = iterable instanceof Collection;
        if (n10 != 0) {
            collection = iterable;
            collection = (Collection)iterable;
            int n11 = collection.size();
            if (n11 != 0) {
                int n12 = 1;
                if (n11 != n12) {
                    n10 = s0.j(collection.size());
                    LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
                    iterable = (Set)CollectionsKt___CollectionsKt.D5(iterable, linkedHashSet);
                } else {
                    n10 = iterable instanceof List;
                    if (n10 != 0) {
                        iterable = (List)iterable;
                        n10 = 0;
                        collection = null;
                        iterable = iterable.get(0);
                    } else {
                        iterable = iterable.iterator().next();
                    }
                    iterable = c1.f(iterable);
                }
            } else {
                iterable = d1.k();
            }
            return iterable;
        }
        collection = new Collection();
        return d1.r((Set)CollectionsKt___CollectionsKt.D5(iterable, collection));
    }

    public static final List O1(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = l10.invoke(e10);
            boolean bl3 = hashSet.add(object2);
            if (!bl3) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final int O2(List list, Object object) {
        f0.p(list, "$this$indexOf");
        return list.indexOf(object);
    }

    private static final float O3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (Number)l10.invoke(object3);
                float f11 = ((Number)object3).floatValue();
                f10 = Math.min(f10, f11);
            }
            return f10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final List O4(Iterable arrayList, Object object, f.h2.s.q q10) {
        f0.p(arrayList, "$this$scanIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = u.Y(arrayList, 9);
        if (n10 == 0) {
            arrayList = t.k(object);
        } else {
            boolean bl2;
            ArrayList<Object> arrayList2 = new ArrayList<Object>(++n10);
            arrayList2.add(object);
            n10 = 0;
            string2 = null;
            arrayList = arrayList.iterator();
            while (bl2 = arrayList.hasNext()) {
                Object e10 = arrayList.next();
                Integer n11 = n10;
                ++n10;
                object = q10.invoke(n11, object, e10);
                arrayList2.add(object);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final short[] O5(Collection object) {
        short s10;
        f0.p(object, "$this$toShortArray");
        int n10 = object.size();
        short[] sArray = new short[n10];
        object = object.iterator();
        int n11 = 0;
        while ((s10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            s10 = number.shortValue();
            int n12 = n11 + 1;
            sArray[n11] = s10;
            n11 = n12;
        }
        return sArray;
    }

    public static final List P1(Iterable listIterator, int n10) {
        Object object;
        int n11;
        f0.p(listIterator, "$this$drop");
        int n12 = 0;
        int n13 = 1;
        if (n10 >= 0) {
            n11 = n13;
        } else {
            n11 = 0;
            object = null;
        }
        if (n11 != 0) {
            ArrayList<Iterator<Object>> arrayList;
            if (n10 == 0) {
                return CollectionsKt___CollectionsKt.I5((Iterable)((Object)listIterator));
            }
            n11 = listIterator instanceof Collection;
            if (n11 != 0) {
                object = listIterator;
                object = (Collection)((Object)listIterator);
                int n14 = object.size() - n10;
                if (n14 <= 0) {
                    return CollectionsKt__CollectionsKt.E();
                }
                if (n14 == n13) {
                    return t.k(CollectionsKt___CollectionsKt.Y2((Iterable)((Object)listIterator)));
                }
                arrayList = new ArrayList<Iterator<Object>>(n14);
                n14 = listIterator instanceof List;
                if (n14 != 0) {
                    n12 = listIterator instanceof RandomAccess;
                    if (n12 != 0) {
                        n12 = object.size();
                        while (n10 < n12) {
                            object = listIterator;
                            object = ((List)((Object)listIterator)).get(n10);
                            arrayList.add((Iterator<Object>)object);
                            ++n10;
                        }
                    } else {
                        listIterator = ((List)((Object)listIterator)).listIterator(n10);
                        while ((n10 = (int)(listIterator.hasNext() ? 1 : 0)) != 0) {
                            Object e10 = listIterator.next();
                            arrayList.add((Iterator<Object>)e10);
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList<Iterator<Object>>();
            }
            listIterator = ((Iterable)((Object)listIterator)).iterator();
            while ((n11 = listIterator.hasNext()) != 0) {
                object = listIterator.next();
                if (n12 >= n10) {
                    arrayList.add((Iterator<Object>)object);
                    continue;
                }
                ++n12;
            }
            return CollectionsKt__CollectionsKt.Q(arrayList);
        }
        listIterator = new ListIterator();
        ((StringBuilder)((Object)listIterator)).append("Requested element count ");
        ((StringBuilder)((Object)listIterator)).append(n10);
        ((StringBuilder)((Object)listIterator)).append(" is less than zero.");
        listIterator = ((StringBuilder)((Object)listIterator)).toString();
        listIterator = listIterator.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)((Object)listIterator));
        throw illegalArgumentException;
    }

    public static final int P2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$indexOfFirst");
        f0.p(l10, "predicate");
        object = object.iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            if (n10 < 0) {
                int n11 = 1;
                boolean bl3 = l.a(n11, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            if (bl2 = ((Boolean)(object2 = (Boolean)l10.invoke(object2))).booleanValue()) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private static final Comparable P3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Comparable)l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
                if (n10 <= 0) continue;
                object2 = object3;
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final List P4(Iterable arrayList, p p10) {
        f0.p(arrayList, "$this$scanReduce");
        f0.p(p10, "operation");
        Iterator iterator2 = arrayList.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            Object object = iterator2.next();
            int n10 = 10;
            int n11 = u.Y(arrayList, n10);
            ArrayList arrayList2 = new ArrayList(n11);
            arrayList2.add(object);
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                arrayList = iterator2.next();
                object = p10.invoke(object, arrayList);
                arrayList2.add(object);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final Set P5(Iterable iterable, Iterable iterable2) {
        f0.p(iterable, "$this$union");
        f0.p(iterable2, "other");
        iterable = CollectionsKt___CollectionsKt.M5(iterable);
        y.q0((Collection)iterable, iterable2);
        return iterable;
    }

    public static final List Q1(List object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(object.size() - n10, 0);
            return CollectionsKt___CollectionsKt.w5((Iterable)object, n10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final int Q2(List object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$indexOfFirst");
        f0.p(l10, "predicate");
        object = object.iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (bl2) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private static final Comparable Q3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Comparable)l10.invoke(object2);
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
            if (n10 <= 0) continue;
            object2 = object3;
        }
        return object2;
    }

    public static final List Q4(Iterable arrayList, f.h2.s.q q10) {
        f0.p(arrayList, "$this$scanReduceIndexed");
        f0.p(q10, "operation");
        Iterator iterator2 = arrayList.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            boolean bl3;
            Object object = iterator2.next();
            int n10 = u.Y(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(n10);
            arrayList2.add(object);
            int n11 = n10 = 1;
            while (bl3 = iterator2.hasNext()) {
                Integer n12 = n11;
                n11 += n10;
                Object t10 = iterator2.next();
                object = q10.invoke(n12, object, t10);
                arrayList2.add(object);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final List Q5(Iterable object, int n10, int n11, boolean bl2) {
        ArrayList<List> arrayList = "$this$windowed";
        f0.p(object, (String)((Object)arrayList));
        SlidingWindowKt.a(n10, n11);
        int n12 = object instanceof RandomAccess;
        if (n12 != 0 && (n12 = object instanceof List) != 0) {
            ArrayList arrayList2;
            object = (List)object;
            n12 = object.size();
            int n13 = n12 / n11;
            int n14 = n12 % n11;
            if (n14 == 0) {
                n14 = 0;
                arrayList2 = null;
            } else {
                n14 = 1;
            }
            arrayList2 = new ArrayList(n13 += n14);
            for (n13 = 0; n13 >= 0 && n12 > n13; n13 += n11) {
                int n15 = n12 - n13;
                if ((n15 = q.u(n10, n15)) < n10 && !bl2) break;
                ArrayList arrayList3 = new ArrayList(n15);
                for (int i10 = 0; i10 < n15; ++i10) {
                    int n16 = i10 + n13;
                    Object e10 = object.get(n16);
                    arrayList3.add(e10);
                }
                arrayList2.add(arrayList3);
            }
            return arrayList2;
        }
        arrayList = new ArrayList<List>();
        object = SlidingWindowKt.b(object.iterator(), n10, n11, bl2, false);
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            List list = (List)object.next();
            arrayList.add(list);
        }
        return arrayList;
    }

    public static final List R1(List list, f.h2.s.l l10) {
        f0.p(list, "$this$dropLastWhile");
        Object object = "predicate";
        f0.p(l10, (String)object);
        int n10 = list.isEmpty();
        if (n10 == 0) {
            boolean bl2;
            n10 = list.size();
            object = list.listIterator(n10);
            while (bl2 = object.hasPrevious()) {
                Object object2 = object.previous();
                bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
                if (bl2) continue;
                int n11 = object.nextIndex() + 1;
                return CollectionsKt___CollectionsKt.w5(list, n11);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final int R2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$indexOfLast");
        f0.p(l10, "predicate");
        object = object.iterator();
        int n10 = -1;
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            if (n11 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            if (bl2 = ((Boolean)(object2 = (Boolean)l10.invoke(object2))).booleanValue()) {
                n10 = n11;
            }
            ++n11;
        }
        return n10;
    }

    private static final Double R3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Number)l10.invoke(object2);
        double d10 = ((Number)object2).doubleValue();
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            object3 = (Number)l10.invoke(object3);
            double d11 = ((Number)object3).doubleValue();
            d10 = Math.min(d10, d11);
        }
        return d10;
    }

    public static final void R4(List list, e e10) {
        int n10;
        f0.p(list, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = CollectionsKt__CollectionsKt.G(list); i10 >= (n10 = 1); i10 += -1) {
            n10 = i10 + 1;
            n10 = e10.m(n10);
            Object e11 = list.get(n10);
            e11 = list.set(i10, e11);
            list.set(n10, e11);
        }
    }

    public static final List R5(Iterable object, int n10, int n11, boolean bl2, f.h2.s.l l10) {
        f0.p(object, "$this$windowed");
        ArrayList<Object> arrayList = "transform";
        f0.p(l10, (String)((Object)arrayList));
        SlidingWindowKt.a(n10, n11);
        int n12 = object instanceof RandomAccess;
        int n13 = 1;
        if (n12 != 0 && (n12 = object instanceof List) != 0) {
            ArrayList<Object> arrayList2;
            object = (List)object;
            n12 = object.size();
            int n14 = n12 / n11;
            int n15 = n12 % n11;
            int n16 = 0;
            if (n15 == 0) {
                n13 = 0;
                arrayList2 = null;
            }
            arrayList2 = new ArrayList<Object>(n14 += n13);
            v0 v02 = new v0((List)object);
            while (n16 >= 0 && n12 > n16) {
                int n17 = n12 - n16;
                n17 = q.u(n10, n17);
                if (!bl2 && n17 < n10) break;
                v02.c(n16, n17 += n16);
                object = l10.invoke(v02);
                arrayList2.add(object);
                n16 += n11;
            }
            return arrayList2;
        }
        arrayList = new ArrayList<Object>();
        object = SlidingWindowKt.b(object.iterator(), n10, n11, bl2, n13 != 0);
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (List)object.next();
            object2 = l10.invoke(object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List S1(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (bl3) {
                arrayList.add(e10);
                continue;
            }
            Boolean bl4 = (Boolean)l10.invoke(e10);
            boolean bl5 = bl4;
            if (bl5) continue;
            arrayList.add(e10);
            bl3 = true;
        }
        return arrayList;
    }

    public static final int S2(List object, f.h2.s.l l10) {
        f0.p(object, "$this$indexOfLast");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        int n10 = object.size();
        object = object.listIterator(n10);
        while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
            object2 = object.previous();
            n10 = (int)(((Boolean)(object2 = (Boolean)l10.invoke(object2))).booleanValue() ? 1 : 0);
            if (n10 == 0) continue;
            return object.nextIndex();
        }
        return -1;
    }

    private static final Float S3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Number)l10.invoke(object2);
        float f10 = ((Number)object2).floatValue();
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            object3 = (Number)l10.invoke(object3);
            float f11 = ((Number)object3).floatValue();
            f10 = Math.min(f10, f11);
        }
        return Float.valueOf(f10);
    }

    public static final Object S4(Iterable object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        boolean bl2 = object instanceof List;
        if (bl2) {
            return CollectionsKt___CollectionsKt.U4((List)object);
        }
        bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            string2 = object.next();
            boolean bl3 = object.hasNext();
            if (!bl3) {
                return string2;
            }
            object = new IllegalArgumentException("Collection has more than one element.");
            throw object;
        }
        object = new NoSuchElementException("Collection is empty.");
        throw object;
    }

    public static /* synthetic */ List S5(Iterable iterable, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return CollectionsKt___CollectionsKt.Q5(iterable, n10, n11, bl2);
    }

    public static final Object T1(Iterable iterable, int n10) {
        Object object = "$this$elementAt";
        f0.p(iterable, (String)object);
        boolean bl2 = iterable instanceof List;
        if (bl2) {
            return ((List)iterable).get(n10);
        }
        object = new CollectionsKt___CollectionsKt$elementAt$1(n10);
        return CollectionsKt___CollectionsKt.V1(iterable, n10, (f.h2.s.l)object);
    }

    public static final Set T2(Iterable iterable, Iterable iterable2) {
        f0.p(iterable, "$this$intersect");
        f0.p(iterable2, "other");
        iterable = CollectionsKt___CollectionsKt.M5(iterable);
        y.Q0((Collection)iterable, iterable2);
        return iterable;
    }

    private static final Object T3(Iterable object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
                if (n10 <= 0) continue;
                object2 = object3;
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final Object T4(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$single");
        f0.p(l10, "predicate");
        object = object.iterator();
        boolean bl3 = false;
        Object var3_3 = null;
        boolean bl4 = false;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl5 = (Boolean)l10.invoke(e10);
            boolean bl6 = bl5;
            if (!bl6) continue;
            if (!bl4) {
                bl4 = bl3 = true;
                var3_3 = e10;
                continue;
            }
            object = new IllegalArgumentException("Collection contains more than one matching element.");
            throw object;
        }
        if (bl4) {
            return var3_3;
        }
        object = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw object;
    }

    public static /* synthetic */ List T5(Iterable iterable, int n10, int n11, boolean bl2, f.h2.s.l l10, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return CollectionsKt___CollectionsKt.R5(iterable, n10, n11, bl2, l10);
    }

    private static final Object U1(List list, int n10) {
        return list.get(n10);
    }

    public static final Appendable U2(Iterable object, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        String string2 = "truncated";
        f0.p(charSequence4, string2);
        appendable.append(charSequence2);
        object = object.iterator();
        int n11 = 0;
        charSequence2 = null;
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            int n12 = 1;
            if (++n11 > n12) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n11 > n10) break;
            n.b(appendable, string2, l10);
        }
        if (n10 >= 0 && n11 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    private static final Object U3(Iterable object, Comparator comparator, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = l10.invoke(object2);
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
            if (n10 <= 0) continue;
            object2 = object3;
        }
        return object2;
    }

    public static final Object U4(List object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = object.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object.get(0);
            }
            object = new IllegalArgumentException("List has more than one element.");
            throw object;
        }
        object = new NoSuchElementException("List is empty.");
        throw object;
    }

    public static final Iterable U5(Iterable iterable) {
        f0.p(iterable, "$this$withIndex");
        CollectionsKt___CollectionsKt$withIndex$1 collectionsKt___CollectionsKt$withIndex$1 = new CollectionsKt___CollectionsKt$withIndex$1(iterable);
        j0 j02 = new j0(collectionsKt___CollectionsKt$withIndex$1);
        return j02;
    }

    public static final Object V1(Iterable object, int n10, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$elementAtOrElse");
        String string2 = "defaultValue";
        f0.p(l10, string2);
        int n11 = object instanceof List;
        if (n11 != 0) {
            object = (List)object;
            if (n10 >= 0 && n10 <= (n11 = CollectionsKt__CollectionsKt.G(object))) {
                object = object.get(n10);
            } else {
                object = n10;
                object = l10.invoke(object);
            }
            return object;
        }
        if (n10 < 0) {
            object = n10;
            return l10.invoke(object);
        }
        object = object.iterator();
        n11 = 0;
        string2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n11 + 1;
            if (n10 == n11) {
                return e10;
            }
            n11 = n12;
        }
        object = n10;
        return l10.invoke(object);
    }

    public static /* synthetic */ Appendable V2(Iterable iterable, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, f.h2.s.l l10, int n11, Object object3) {
        f.h2.s.l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = iterable;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return CollectionsKt___CollectionsKt.U2(iterable, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Comparable V3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$minOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Comparable)object.next();
        while (bl2 = object.hasNext()) {
            Comparable comparable = (Comparable)object.next();
            int n10 = object2.compareTo(comparable);
            if (n10 <= 0) continue;
            object2 = comparable;
        }
        return object2;
    }

    public static final Object V4(Iterable object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = object instanceof List;
        Object var3_3 = null;
        if (n10 != 0) {
            int n11;
            n10 = (object = (List)object).size();
            if (n10 == (n11 = 1)) {
                n10 = 0;
                string2 = null;
                var3_3 = object.get(0);
            }
            return var3_3;
        }
        n10 = (int)((object = object.iterator()).hasNext() ? 1 : 0);
        if (n10 == 0) {
            return null;
        }
        string2 = object.next();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return null;
        }
        return string2;
    }

    public static final List V5(Iterable object, Iterable iterable) {
        f0.p(object, "$this$zip");
        f0.p(iterable, "other");
        Iterator iterator2 = object.iterator();
        Iterator iterator3 = iterable.iterator();
        int n10 = 10;
        int n11 = u.Y((Iterable)object, n10);
        int n12 = u.Y(iterable, n10);
        n11 = Math.min(n11, n12);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0 && (n11 = (int)(iterator3.hasNext() ? 1 : 0)) != 0) {
            object = iterator2.next();
            iterable = iterator3.next();
            object = w0.a(object, iterable);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Object W1(List object, int n10, f.h2.s.l l10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = CollectionsKt__CollectionsKt.G((List)object))) {
            object = object.get(n10);
        } else {
            object = n10;
            object = l10.invoke(object);
        }
        return object;
    }

    public static final String W2(Iterable object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, f.h2.s.l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)CollectionsKt___CollectionsKt.U2((Iterable)object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Double W3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$minOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Number)object.next();
        double d10 = ((Number)object2).doubleValue();
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d11 = number.doubleValue();
            d10 = Math.min(d10, d11);
        }
        return d10;
    }

    public static final Object W4(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$singleOrNull");
        f0.p(l10, "predicate");
        object = object.iterator();
        boolean bl3 = false;
        Object var3_3 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl4 = (Boolean)l10.invoke(e10);
            boolean bl5 = bl4;
            if (!bl5) continue;
            if (bl3) {
                return null;
            }
            bl3 = true;
            var3_3 = e10;
        }
        if (!bl3) {
            return null;
        }
        return var3_3;
    }

    public static final List W5(Iterable object, Iterable iterable, p p10) {
        f0.p(object, "$this$zip");
        f0.p(iterable, "other");
        f0.p(p10, "transform");
        Iterator iterator2 = object.iterator();
        Iterator iterator3 = iterable.iterator();
        int n10 = 10;
        int n11 = u.Y((Iterable)object, n10);
        int n12 = u.Y(iterable, n10);
        n11 = Math.min(n11, n12);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0 && (n11 = (int)(iterator3.hasNext() ? 1 : 0)) != 0) {
            object = iterator2.next();
            iterable = iterator3.next();
            object = p10.invoke(object, iterable);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Object X1(Iterable object, int n10) {
        boolean bl2;
        String string2 = "$this$elementAtOrNull";
        f0.p(object, string2);
        boolean bl3 = object instanceof List;
        if (bl3) {
            return CollectionsKt___CollectionsKt.H2((List)object, n10);
        }
        bl3 = false;
        string2 = null;
        if (n10 < 0) {
            return null;
        }
        object = object.iterator();
        int n11 = 0;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n11 + 1;
            if (n10 == n11) {
                return e10;
            }
            n11 = n12;
        }
        return null;
    }

    public static /* synthetic */ String X2(Iterable iterable, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, f.h2.s.l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = iterable;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return CollectionsKt___CollectionsKt.W2(iterable, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final Float X3(Iterable object) {
        boolean bl2;
        Object object2 = "$this$minOrNull";
        f0.p(object, (String)object2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        object2 = (Number)object.next();
        float f10 = ((Number)object2).floatValue();
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            float f11 = number.floatValue();
            f10 = Math.min(f10, f11);
        }
        return Float.valueOf(f10);
    }

    public static final Object X4(List list) {
        String string2 = "$this$singleOrNull";
        f0.p(list, string2);
        int n10 = list.size();
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            list = list.get(0);
        } else {
            list = null;
        }
        return list;
    }

    public static final List X5(Iterable object, Object[] objectArray) {
        boolean bl2;
        f0.p(object, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = objectArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = objectArray[n11];
            object2 = w0.a(e10, object2);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    private static final Object Y1(List list, int n10) {
        return CollectionsKt___CollectionsKt.H2(list, n10);
    }

    public static final Object Y2(Iterable object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        boolean bl2 = object instanceof List;
        if (bl2) {
            return CollectionsKt___CollectionsKt.a3((List)object);
        }
        bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            string2 = object.next();
            while (bl3 = object.hasNext()) {
                string2 = object.next();
            }
            return string2;
        }
        object = new NoSuchElementException("Collection is empty.");
        throw object;
    }

    public static final Object Y3(Iterable iterable, Comparator comparator) {
        f0.p(iterable, "$this$minWith");
        f0.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.Z3(iterable, comparator);
    }

    public static final List Y4(List list, Iterable object) {
        f0.p(list, "$this$slice");
        String string2 = "indices";
        f0.p(object, string2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<String> arrayList = new ArrayList<String>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            string2 = list.get(n10);
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static final List Y5(Iterable object, Object[] objectArray, p p10) {
        boolean bl2;
        f0.p(object, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = objectArray[n11];
            object2 = p10.invoke(e10, object2);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final List Z1(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(e10);
            boolean bl4 = bl3;
            if (!bl4) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final Object Z2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$last");
        f0.p(l10, "predicate");
        object = object.iterator();
        boolean bl3 = false;
        Object var3_3 = null;
        boolean bl4 = false;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl5 = (Boolean)l10.invoke(e10);
            boolean bl6 = bl5;
            if (!bl6) continue;
            bl4 = bl3 = true;
            var3_3 = e10;
        }
        if (bl4) {
            return var3_3;
        }
        object = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw object;
    }

    public static final Object Z3(Iterable object, Comparator comparator) {
        boolean bl2;
        f0.p(object, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        string2 = object.next();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n10 = comparator.compare(string2, e10);
            if (n10 <= 0) continue;
            string2 = e10;
        }
        return string2;
    }

    public static final List Z4(List list, k k10) {
        f0.p(list, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return CollectionsKt___CollectionsKt.I5(list.subList(n10, n11));
    }

    public static final List Z5(Iterable arrayList) {
        ArrayList arrayList2 = "$this$zipWithNext";
        f0.p(arrayList, (String)((Object)arrayList2));
        arrayList = arrayList.iterator();
        boolean bl2 = arrayList.hasNext();
        if (!bl2) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            boolean bl3;
            arrayList2 = new ArrayList();
            Object object = arrayList.next();
            while (bl3 = arrayList.hasNext()) {
                Object e10 = arrayList.next();
                object = w0.a(object, e10);
                arrayList2.add(object);
                object = e10;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final List a2(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        int n10 = 0;
        Constable constable = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            constable = Integer.valueOf(n10);
            n10 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, e10))).booleanValue() ? 1 : 0);
            if (n10 != 0) {
                arrayList.add(e10);
            }
            n10 = n11;
        }
        return arrayList;
    }

    public static final Object a3(List object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            n10 = CollectionsKt__CollectionsKt.G((List)object);
            return object.get(n10);
        }
        object = new NoSuchElementException("List is empty.");
        throw object;
    }

    public static final List a4(Iterable object, Iterable iterable) {
        boolean bl2;
        f0.p(object, "$this$minus");
        ArrayList arrayList = "elements";
        f0.p(iterable, (String)((Object)arrayList));
        iterable = u.b0(iterable, (Iterable)object);
        boolean bl3 = iterable.isEmpty();
        if (bl3) {
            return CollectionsKt___CollectionsKt.I5((Iterable)object);
        }
        arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl4 = iterable.contains(e10);
            if (bl4) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final void a5(List list, f.h2.s.l l10) {
        f0.p(list, "$this$sortBy");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = list.size();
        int n11 = 1;
        if (n10 > n11) {
            object = new b$b(l10);
            x.p0(list, (Comparator)object);
        }
    }

    public static final List a6(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$zipWithNext");
        ArrayList arrayList = "transform";
        f0.p(p10, (String)((Object)arrayList));
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return CollectionsKt__CollectionsKt.E();
        }
        arrayList = new ArrayList();
        Object object2 = object.next();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            object2 = e10;
        }
        return arrayList;
    }

    public static final Collection b2(Iterable object, Collection collection, p p10) {
        boolean bl2;
        f0.p(object, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        f0.p(p10, "predicate");
        object = object.iterator();
        int n10 = 0;
        Constable constable = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            constable = Integer.valueOf(n10);
            n10 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, e10))).booleanValue() ? 1 : 0);
            if (n10 != 0) {
                collection.add(e10);
            }
            n10 = n11;
        }
        return collection;
    }

    public static final Object b3(List object, f.h2.s.l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = object.size();
        object = object.listIterator(n10);
        while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
            string2 = object.previous();
            Boolean bl2 = (Boolean)l10.invoke(string2);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return string2;
        }
        object = new NoSuchElementException("List contains no element matching the predicate.");
        throw object;
    }

    public static final List b4(Iterable object, Object object2) {
        boolean bl2;
        f0.p(object, "$this$minus");
        int n10 = u.Y((Iterable)object, 10);
        ArrayList arrayList = new ArrayList(n10);
        object = object.iterator();
        n10 = 0;
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            boolean bl4;
            Object e10 = object.next();
            boolean bl5 = true;
            if (!bl3 && (bl4 = f0.g(e10, object2))) {
                bl3 = bl5;
                bl5 = false;
            }
            if (!bl5) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final void b5(List list, f.h2.s.l l10) {
        f0.p(list, "$this$sortByDescending");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = list.size();
        int n11 = 1;
        if (n10 > n11) {
            object = new b$d(l10);
            x.p0(list, (Comparator)object);
        }
    }

    public static final /* synthetic */ List c2(Iterable object) {
        boolean bl2;
        f0.p(object, "$this$filterIsInstance");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            String string2 = "R";
            f0.y(3, string2);
            boolean bl3 = e10 instanceof Object;
            if (!bl3) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final int c3(Iterable object, Object object2) {
        boolean bl2;
        String string2 = "$this$lastIndexOf";
        f0.p(object, string2);
        int n10 = object instanceof List;
        if (n10 != 0) {
            return ((List)object).lastIndexOf(object2);
        }
        n10 = -1;
        int n11 = 0;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            if (bl2 = f0.g(object2, e10)) {
                n10 = n11;
            }
            ++n11;
        }
        return n10;
    }

    public static final List c4(Iterable object, m object2) {
        boolean bl2;
        f0.p(object, "$this$minus");
        ArrayList arrayList = "elements";
        f0.p(object2, (String)((Object)arrayList));
        object2 = SequencesKt___SequencesKt.U2((m)object2);
        boolean bl3 = ((HashSet)object2).isEmpty();
        if (bl3) {
            return CollectionsKt___CollectionsKt.I5((Iterable)object);
        }
        arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl4 = ((HashSet)object2).contains(e10);
            if (bl4) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final void c5(List list) {
        f0.p(list, "$this$sortDescending");
        Comparator comparator = b.q();
        x.p0(list, comparator);
    }

    public static final /* synthetic */ Collection d2(Iterable object, Collection collection) {
        boolean bl2;
        f0.p(object, "$this$filterIsInstanceTo");
        String string2 = "destination";
        f0.p(collection, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            String string3 = "R";
            f0.y(3, string3);
            boolean bl3 = string2 instanceof Object;
            if (!bl3) continue;
            collection.add(string2);
        }
        return collection;
    }

    public static final int d3(List list, Object object) {
        f0.p(list, "$this$lastIndexOf");
        return list.lastIndexOf(object);
    }

    public static final List d4(Iterable object, Object[] object2) {
        boolean bl2;
        f0.p(object, "$this$minus");
        ArrayList arrayList = "elements";
        f0.p(object2, (String)((Object)arrayList));
        int n10 = ((Object[])object2).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return CollectionsKt___CollectionsKt.I5((Iterable)object);
        }
        object2 = ArraysKt___ArraysKt.ky((Object[])object2);
        arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl3 = ((HashSet)object2).contains(e10);
            if (bl3) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final List d5(Iterable objectArray) {
        Object object = "$this$sorted";
        f0.p(objectArray, (String)object);
        boolean bl2 = objectArray instanceof Collection;
        if (bl2) {
            int n10;
            object = objectArray;
            object = (Collection)objectArray;
            int n11 = object.size();
            if (n11 <= (n10 = 1)) {
                return CollectionsKt___CollectionsKt.I5((Iterable)objectArray);
            }
            objectArray = new Comparable[]{};
            objectArray = object.toArray(objectArray);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(objectArray, (String)object);
            Objects.requireNonNull(objectArray, (String)object);
            Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            f.x1.n.r3(objectArray);
            return f.x1.n.t(objectArray);
        }
        objectArray = CollectionsKt___CollectionsKt.K5((Iterable)objectArray);
        x.m0((List)objectArray);
        return objectArray;
    }

    public static final List e2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(e10);
            boolean bl4 = bl3;
            if (bl4) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static final Object e3(Iterable object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = object instanceof List;
        boolean bl2 = false;
        Object var4_4 = null;
        if (n10 != 0) {
            n10 = (object = (List)object).isEmpty();
            if (n10 == 0) {
                n10 = object.size() + -1;
                var4_4 = object.get(n10);
            }
            return var4_4;
        }
        n10 = (object = object.iterator()).hasNext();
        if (n10 == 0) {
            return null;
        }
        string2 = object.next();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
        }
        return string2;
    }

    private static final List e4(Iterable iterable, Object object) {
        return CollectionsKt___CollectionsKt.b4(iterable, object);
    }

    public static final List e5(Iterable iterable, f.h2.s.l l10) {
        f0.p(iterable, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return CollectionsKt___CollectionsKt.h5(iterable, b$b);
    }

    public static final List f2(Iterable iterable) {
        f0.p(iterable, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        return (List)CollectionsKt___CollectionsKt.g2(iterable, arrayList);
    }

    public static final Object f3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$lastOrNull");
        f0.p(l10, "predicate");
        object = object.iterator();
        Object var2_2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(e10);
            boolean bl4 = bl3;
            if (!bl4) continue;
            var2_2 = e10;
        }
        return var2_2;
    }

    public static final boolean f4(Iterable iterable) {
        String string2 = "$this$none";
        f0.p(iterable, string2);
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ((Collection)iterable).isEmpty();
        }
        return iterable.iterator().hasNext() ^ true;
    }

    public static final List f5(Iterable iterable, f.h2.s.l l10) {
        f0.p(iterable, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return CollectionsKt___CollectionsKt.h5(iterable, b$d);
    }

    public static final Collection g2(Iterable object, Collection collection) {
        boolean bl2;
        f0.p(object, "$this$filterNotNullTo");
        String string2 = "destination";
        f0.p(collection, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            if (string2 == null) continue;
            collection.add(string2);
        }
        return collection;
    }

    public static final Object g3(List list) {
        String string2 = "$this$lastOrNull";
        f0.p(list, string2);
        int n10 = list.isEmpty();
        if (n10 != 0) {
            list = null;
        } else {
            n10 = list.size() + -1;
            list = list.get(n10);
        }
        return list;
    }

    public static final boolean g4(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$none");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object instanceof Collection;
        boolean bl3 = true;
        if (bl2) {
            object2 = object;
            object2 = (Collection)object;
            bl2 = object2.isEmpty();
            if (bl2) {
                return bl3;
            }
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return false;
        }
        return bl3;
    }

    public static final List g5(Iterable iterable) {
        f0.p(iterable, "$this$sortedDescending");
        Comparator comparator = b.q();
        return CollectionsKt___CollectionsKt.h5(iterable, comparator);
    }

    public static final Collection h2(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(string2);
            boolean bl4 = bl3;
            if (bl4) continue;
            collection.add(string2);
        }
        return collection;
    }

    public static final Object h3(List object, f.h2.s.l l10) {
        f0.p(object, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = object.size();
        object = object.listIterator(n10);
        while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
            string2 = object.previous();
            Boolean bl2 = (Boolean)l10.invoke(string2);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return string2;
        }
        return null;
    }

    public static final Iterable h4(Iterable iterable, f.h2.s.l l10) {
        boolean bl2;
        f0.p(iterable, "$this$onEach");
        f0.p(l10, "action");
        Iterator iterator2 = iterable.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object t10 = iterator2.next();
            l10.invoke(t10);
        }
        return iterable;
    }

    public static final List h5(Iterable objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        Object object = "comparator";
        f0.p(comparator, (String)object);
        boolean bl2 = objectArray instanceof Collection;
        if (bl2) {
            int n10;
            object = objectArray;
            object = (Collection)objectArray;
            int n11 = object.size();
            if (n11 <= (n10 = 1)) {
                return CollectionsKt___CollectionsKt.I5((Iterable)objectArray);
            }
            objectArray = new Object[]{};
            objectArray = object.toArray(objectArray);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(objectArray, (String)object);
            Objects.requireNonNull(objectArray, (String)object);
            f.x1.n.E3(objectArray, comparator);
            return f.x1.n.t(objectArray);
        }
        objectArray = CollectionsKt___CollectionsKt.K5((Iterable)objectArray);
        x.p0((List)objectArray, comparator);
        return objectArray;
    }

    public static final Collection i2(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(string2);
            boolean bl4 = bl3;
            if (!bl4) continue;
            collection.add(string2);
        }
        return collection;
    }

    public static final List i3(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$map");
        f0.p(l10, "transform");
        int n10 = u.Y((Iterable)object, 10);
        ArrayList arrayList = new ArrayList(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = object.next();
            object2 = l10.invoke(object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final Iterable i4(Iterable iterable, p p10) {
        boolean bl2;
        f0.p(iterable, "$this$onEachIndexed");
        f0.p(p10, "action");
        Iterator iterator2 = iterable.iterator();
        int n10 = 0;
        Integer n11 = null;
        while (bl2 = iterator2.hasNext()) {
            Object t10 = iterator2.next();
            int n12 = n10 + 1;
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            n11 = n10;
            p10.invoke(n11, t10);
            n10 = n12;
        }
        return iterable;
    }

    public static final Set i5(Iterable iterable, Iterable iterable2) {
        f0.p(iterable, "$this$subtract");
        f0.p(iterable2, "other");
        iterable = CollectionsKt___CollectionsKt.M5(iterable);
        y.G0((Collection)iterable, iterable2);
        return iterable;
    }

    public static final boolean j1(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$all");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object instanceof Collection;
        boolean bl3 = true;
        if (bl2) {
            object2 = object;
            object2 = (Collection)object;
            bl2 = object2.isEmpty();
            if (bl2) {
                return bl3;
            }
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (bl2) continue;
            return false;
        }
        return bl3;
    }

    private static final Object j2(Iterable object, f.h2.s.l l10) {
        Object e10;
        block1: {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                e10 = object.next();
                Boolean bl3 = (Boolean)l10.invoke(e10);
                boolean bl4 = bl3;
                if (!bl4) continue;
                break block1;
            }
            bl2 = false;
            e10 = null;
        }
        return e10;
    }

    public static final List j3(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = u.Y((Iterable)object, 10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        n10 = 0;
        int n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n11 + 1;
            if (n11 < 0) {
                int n13 = 1;
                boolean bl3 = l.a(n13, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n11;
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Pair j4(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$partition");
        f0.p(l10, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(e10);
            boolean bl4 = bl3;
            if (bl4) {
                arrayList.add(e10);
                continue;
            }
            arrayList2.add(e10);
        }
        object = new Pair(arrayList, arrayList2);
        return object;
    }

    public static final int j5(Iterable object, f.h2.s.l l10) {
        int n10;
        f0.p(object, "$this$sumBy");
        f0.p(l10, "selector");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            n10 = ((Number)object2).intValue();
            n11 += n10;
        }
        return n11;
    }

    public static final boolean k1(Iterable iterable) {
        String string2 = "$this$any";
        f0.p(iterable, string2);
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ((Collection)iterable).isEmpty() ^ true;
        }
        return iterable.iterator().hasNext();
    }

    private static final Object k2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        object = object.iterator();
        Object var2_2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(e10);
            boolean bl4 = bl3;
            if (!bl4) continue;
            var2_2 = e10;
        }
        return var2_2;
    }

    public static final List k3(Iterable object, p p10) {
        boolean bl2;
        f0.p(object, "$this$mapIndexedNotNull");
        f0.p(p10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            if ((object2 = p10.invoke(object2, e10)) != null) {
                arrayList.add(object2);
            }
            n10 = n11;
        }
        return arrayList;
    }

    public static final List k4(Iterable iterable, Iterable iterable2) {
        f0.p(iterable, "$this$plus");
        ArrayList arrayList = "elements";
        f0.p(iterable2, (String)((Object)arrayList));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return CollectionsKt___CollectionsKt.o4((Collection)iterable, iterable2);
        }
        arrayList = new ArrayList();
        y.q0(arrayList, iterable);
        y.q0(arrayList, iterable2);
        return arrayList;
    }

    public static final double k5(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        object = object.iterator();
        double d10 = 0.0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            double d11 = ((Number)object2).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final boolean l1(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$any");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object2 = object;
            object2 = (Collection)object;
            bl2 = object2.isEmpty();
            if (bl2) {
                return false;
            }
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static final Object l2(List object, f.h2.s.l l10) {
        Object e10;
        block1: {
            int n10 = object.size();
            object = object.listIterator(n10);
            while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
                e10 = object.previous();
                Boolean bl2 = (Boolean)l10.invoke(e10);
                boolean bl3 = bl2;
                if (!bl3) continue;
                break block1;
            }
            n10 = 0;
            e10 = null;
        }
        return e10;
    }

    public static final Collection l3(Iterable object, Collection collection, p p10) {
        boolean bl2;
        f0.p(object, "$this$mapIndexedNotNullTo");
        f0.p(collection, "destination");
        f0.p(p10, "transform");
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            if ((object2 = p10.invoke(object2, e10)) != null) {
                collection.add(object2);
            }
            n10 = n11;
        }
        return collection;
    }

    public static final List l4(Iterable iterable, Object object) {
        ArrayList<Object> arrayList = "$this$plus";
        f0.p(iterable, (String)((Object)arrayList));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return CollectionsKt___CollectionsKt.p4((Collection)iterable, object);
        }
        arrayList = new ArrayList<Object>();
        y.q0(arrayList, iterable);
        arrayList.add(object);
        return arrayList;
    }

    public static final int l5(Iterable object) {
        byte by2;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n10 = 0;
        while ((by2 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            by2 = number.byteValue();
            n10 += by2;
        }
        return n10;
    }

    private static final Iterable m1(Iterable iterable) {
        return iterable;
    }

    public static final Object m2(Iterable object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        boolean bl2 = object instanceof List;
        if (bl2) {
            return CollectionsKt___CollectionsKt.o2((List)object);
        }
        bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            return object.next();
        }
        object = new NoSuchElementException("Collection is empty.");
        throw object;
    }

    public static final Collection m3(Iterable object, Collection collection, p p10) {
        boolean bl2;
        f0.p(object, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        f0.p(p10, "transform");
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            object2 = p10.invoke(object2, e10);
            collection.add(object2);
            n10 = n11;
        }
        return collection;
    }

    public static final List m4(Iterable iterable, m m10) {
        f0.p(iterable, "$this$plus");
        f0.p(m10, "elements");
        ArrayList arrayList = new ArrayList();
        y.q0(arrayList, iterable);
        y.r0(arrayList, m10);
        return arrayList;
    }

    public static final double m5(Iterable object) {
        boolean bl2;
        String string2 = "$this$sum";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final m n1(Iterable iterable) {
        f0.p(iterable, "$this$asSequence");
        CollectionsKt___CollectionsKt$a collectionsKt___CollectionsKt$a = new CollectionsKt___CollectionsKt$a(iterable);
        return collectionsKt___CollectionsKt$a;
    }

    public static final Object n2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(string2);
            boolean bl4 = bl3;
            if (!bl4) continue;
            return string2;
        }
        object = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw object;
    }

    public static final List n3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$mapNotNull");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            if ((object2 = l10.invoke(object2)) == null) continue;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List n4(Iterable iterable, Object[] objectArray) {
        f0.p(iterable, "$this$plus");
        ArrayList arrayList = "elements";
        f0.p(objectArray, (String)((Object)arrayList));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return CollectionsKt___CollectionsKt.r4((Collection)iterable, objectArray);
        }
        arrayList = new ArrayList();
        y.q0(arrayList, iterable);
        y.s0(arrayList, objectArray);
        return arrayList;
    }

    private static final double n5(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        double d10 = 0.0;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            double d11 = ((Number)object2).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final Map o1(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$associate");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        int n10 = s0.j(u.Y((Iterable)object, 10));
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = object.next();
            object2 = (Pair)l10.invoke(object2);
            Object object3 = ((Pair)object2).getFirst();
            object2 = ((Pair)object2).getSecond();
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Object o2(List object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return object.get(0);
        }
        object = new NoSuchElementException("List is empty.");
        throw object;
    }

    public static final Collection o3(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$mapNotNullTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            if ((object2 = l10.invoke(object2)) == null) continue;
            collection.add(object2);
        }
        return collection;
    }

    public static final List o4(Collection collection, Iterable iterable) {
        f0.p(collection, "$this$plus");
        ArrayList arrayList = "elements";
        f0.p(iterable, (String)((Object)arrayList));
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            int n10 = collection.size();
            iterable = (Collection)iterable;
            int n11 = iterable.size();
            arrayList = new ArrayList(n10 += n11);
            arrayList.addAll(collection);
            arrayList.addAll(iterable);
            return arrayList;
        }
        arrayList = new ArrayList(collection);
        y.q0(arrayList, iterable);
        return arrayList;
    }

    public static final float o5(Iterable object) {
        boolean bl2;
        f0.p(object, "$this$sum");
        object = object.iterator();
        float f10 = 0.0f;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            float f11 = number.floatValue();
            f10 += f11;
        }
        return f10;
    }

    public static final Map p1(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(u.Y((Iterable)object, 10));
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, String> linkedHashMap = new LinkedHashMap<Object, String>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            string2 = object.next();
            Object object2 = l10.invoke(string2);
            linkedHashMap.put(object2, string2);
        }
        return linkedHashMap;
    }

    public static final Object p2(Iterable object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        boolean bl2 = object instanceof List;
        if (bl2) {
            bl2 = (object = (List)object).isEmpty();
            if (bl2) {
                return null;
            }
            return object.get(0);
        }
        bl2 = (object = object.iterator()).hasNext();
        if (!bl2) {
            return null;
        }
        return object.next();
    }

    public static final Collection p3(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$mapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = l10.invoke(object2);
            collection.add(object2);
        }
        return collection;
    }

    public static final List p4(Collection collection, Object object) {
        f0.p(collection, "$this$plus");
        int n10 = collection.size() + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        arrayList.addAll(collection);
        arrayList.add(object);
        return arrayList;
    }

    public static final int p5(Iterable object) {
        int n10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            n11 += n10;
        }
        return n11;
    }

    public static final Map q1(Iterable object, f.h2.s.l l10, f.h2.s.l l11) {
        f0.p(object, "$this$associateBy");
        f0.p(l10, "keySelector");
        Object object2 = "valueTransform";
        f0.p(l11, (String)object2);
        int n10 = s0.j(u.Y((Iterable)object, 10));
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = object.next();
            Object object3 = l10.invoke(object2);
            object2 = l11.invoke(object2);
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Object q2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Boolean bl3 = (Boolean)l10.invoke(string2);
            boolean bl4 = bl3;
            if (!bl4) continue;
            return string2;
        }
        return null;
    }

    public static final Comparable q3(Iterable iterable) {
        f0.p(iterable, "$this$max");
        return CollectionsKt___CollectionsKt.D3(iterable);
    }

    public static final List q4(Collection collection, m m10) {
        f0.p(collection, "$this$plus");
        f0.p(m10, "elements");
        int n10 = collection.size() + 10;
        ArrayList arrayList = new ArrayList(n10);
        arrayList.addAll(collection);
        y.r0(arrayList, m10);
        return arrayList;
    }

    private static final int q5(Iterable object, f.h2.s.l l10) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            n10 = ((Number)object2).intValue();
            n11 += n10;
        }
        return n11;
    }

    public static final Map r1(Iterable object, Map map, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Object object2 = l10.invoke(string2);
            map.put(object2, string2);
        }
        return map;
    }

    public static final Object r2(List list) {
        String string2 = "$this$firstOrNull";
        f0.p(list, string2);
        boolean bl2 = list.isEmpty();
        if (bl2) {
            list = null;
        } else {
            bl2 = false;
            string2 = null;
            list = list.get(0);
        }
        return list;
    }

    public static final Double r3(Iterable iterable) {
        f0.p(iterable, "$this$max");
        return CollectionsKt___CollectionsKt.E3(iterable);
    }

    public static final List r4(Collection collection, Object[] objectArray) {
        f0.p(collection, "$this$plus");
        f0.p(objectArray, "elements");
        int n10 = collection.size();
        int n11 = objectArray.length;
        ArrayList arrayList = new ArrayList(n10 += n11);
        arrayList.addAll(collection);
        y.s0(arrayList, objectArray);
        return arrayList;
    }

    public static final long r5(Iterable object) {
        boolean bl2;
        String string2 = "$this$sum";
        f0.p(object, string2);
        object = object.iterator();
        long l10 = 0L;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            long l11 = number.longValue();
            l10 += l11;
        }
        return l10;
    }

    public static final Map s1(Iterable object, Map map, f.h2.s.l l10, f.h2.s.l l11) {
        boolean bl2;
        f0.p(object, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        Object object2 = "valueTransform";
        f0.p(l11, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            Object object3 = l10.invoke(object2);
            object2 = l11.invoke(object2);
            map.put(object3, object2);
        }
        return map;
    }

    public static final List s2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (Iterable)l10.invoke(object2);
            y.q0(arrayList, object2);
        }
        return arrayList;
    }

    public static final Float s3(Iterable iterable) {
        f0.p(iterable, "$this$max");
        return CollectionsKt___CollectionsKt.F3(iterable);
    }

    private static final List s4(Iterable iterable, Object object) {
        return CollectionsKt___CollectionsKt.l4(iterable, object);
    }

    private static final long s5(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        object = object.iterator();
        long l11 = 0L;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            long l12 = ((Number)object2).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final Map t1(Iterable object, Map map, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associateTo");
        f0.p(map, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = (Pair)l10.invoke(object2);
            Object object3 = ((Pair)object2).getFirst();
            object2 = ((Pair)object2).getSecond();
            map.put(object3, object2);
        }
        return map;
    }

    private static final List t2(Iterable object, p p10) {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            object2 = (Iterable)p10.invoke(object2, e10);
            y.q0(arrayList, (Iterable)object2);
            n10 = n11;
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object t3(Iterable iterator2, f.h2.s.l l10) {
        boolean bl2;
        void var2_4;
        f0.p(iterator2, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        iterator2 = iterator2.iterator();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return null;
        }
        Object t10 = iterator2.next();
        boolean bl4 = iterator2.hasNext();
        if (!bl4) {
            return var2_4;
        }
        Comparable comparable = (Comparable)l10.invoke(t10);
        do {
            Object t11;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) >= 0) continue;
            Object t12 = t11;
            comparable = comparable2;
        } while (bl2 = iterator2.hasNext());
        return var2_4;
    }

    private static final List t4(Collection collection, Object object) {
        return CollectionsKt___CollectionsKt.p4(collection, object);
    }

    public static final int t5(Iterable object) {
        short s10;
        f0.p(object, "$this$sum");
        object = object.iterator();
        int n10 = 0;
        while ((s10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            s10 = number.shortValue();
            n10 += s10;
        }
        return n10;
    }

    public static final Map u1(Iterable object, f.h2.s.l l10) {
        f0.p(object, "$this$associateWith");
        f0.p(l10, "valueSelector");
        int n10 = s0.j(u.Y((Iterable)object, 10));
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object.next();
            Object object2 = l10.invoke(e10);
            linkedHashMap.put(e10, object2);
        }
        return linkedHashMap;
    }

    private static final Collection u2(Iterable object, Collection collection, p p10) {
        boolean bl2;
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            object2 = (Iterable)p10.invoke(object2, e10);
            y.q0(collection, (Iterable)object2);
            n10 = n11;
        }
        return collection;
    }

    public static final Object u3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        string2 = object.next();
        boolean bl4 = object.hasNext();
        if (!bl4) {
            return string2;
        }
        Comparable comparable = (Comparable)l10.invoke(string2);
        do {
            Object e10;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(e10 = object.next()))) >= 0) continue;
            string2 = e10;
            comparable = comparable2;
        } while (bl2 = object.hasNext());
        return string2;
    }

    private static final Object u4(Collection collection) {
        e$a e$a = e.b;
        return CollectionsKt___CollectionsKt.v4(collection, e$a);
    }

    private static final int u5(Iterable object, f.h2.s.l l10) {
        int n10;
        int n11 = f.c1.h(0);
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = object.next();
            object2 = (f.c1)l10.invoke(object2);
            n10 = ((f.c1)object2).a0();
            n11 = f.c1.h(n11 + n10);
        }
        return n11;
    }

    public static final Map v1(Iterable object, Map map, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associateWithTo");
        f0.p(map, "destination");
        String string2 = "valueSelector";
        f0.p(l10, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Object object2 = l10.invoke(string2);
            map.put(string2, object2);
        }
        return map;
    }

    private static final List v2(Iterable object, p p10) {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            object2 = (m)p10.invoke(object2, e10);
            y.r0(arrayList, (m)object2);
            n10 = n11;
        }
        return arrayList;
    }

    private static final double v3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            double d10 = ((Number)object2).doubleValue();
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (Number)l10.invoke(object3);
                double d11 = ((Number)object3).doubleValue();
                d10 = Math.max(d10, d11);
            }
            return d10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final Object v4(Collection object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            n10 = object.size();
            int n11 = e10.m(n10);
            return CollectionsKt___CollectionsKt.T1((Iterable)object, n11);
        }
        object = new NoSuchElementException("Collection is empty.");
        throw object;
    }

    private static final long v5(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        long l11 = g1.h(0);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (g1)l10.invoke(object2);
            long l12 = ((g1)object2).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final double w1(Iterable object) {
        byte by2;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n10 = 0;
        while ((by2 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            by2 = number.byteValue();
            double d11 = by2;
            d10 += d11;
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n10 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n10;
            d10 /= d12;
        }
        return d10;
    }

    private static final Collection w2(Iterable object, Collection collection, p p10) {
        boolean bl2;
        object = object.iterator();
        int n10 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                int n12 = 1;
                boolean bl3 = l.a(n12, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = n10;
            object2 = (m)p10.invoke(object2, e10);
            y.r0(collection, (m)object2);
            n10 = n11;
        }
        return collection;
    }

    private static final float w3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Number)l10.invoke(object2);
            float f10 = ((Number)object2).floatValue();
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                object3 = (Number)l10.invoke(object3);
                float f11 = ((Number)object3).floatValue();
                f10 = Math.max(f10, f11);
            }
            return f10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    private static final Object w4(Collection collection) {
        e$a e$a = e.b;
        return CollectionsKt___CollectionsKt.x4(collection, e$a);
    }

    public static final List w5(Iterable object, int n10) {
        Collection collection;
        int n11;
        f0.p(object, "$this$take");
        int n12 = 0;
        int n13 = 1;
        if (n10 >= 0) {
            n11 = n13;
        } else {
            n11 = 0;
            collection = null;
        }
        if (n11 != 0) {
            boolean bl2;
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = object instanceof Collection;
            if (n11 != 0) {
                collection = object;
                collection = (Collection)object;
                n11 = collection.size();
                if (n10 >= n11) {
                    return CollectionsKt___CollectionsKt.I5((Iterable)object);
                }
                if (n10 == n13) {
                    return t.k(CollectionsKt___CollectionsKt.m2((Iterable)object));
                }
            }
            collection = new Collection(n10);
            object = ((Iterable)object).iterator();
            while (bl2 = object.hasNext()) {
                Object e10 = object.next();
                collection.add(e10);
                if ((n12 += n13) != n10) continue;
            }
            return CollectionsKt__CollectionsKt.Q(collection);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final double x1(Iterable object) {
        boolean bl2;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d11 = number.doubleValue();
            d10 += d11;
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n10 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n10;
            d10 /= d12;
        }
        return d10;
    }

    public static final List x2(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (m)l10.invoke(object2);
            y.r0(arrayList, object2);
        }
        return arrayList;
    }

    private static final Comparable x3(Iterable object, f.h2.s.l l10) {
        boolean bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Comparable)l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
                if (n10 >= 0) continue;
                object2 = object3;
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final Object x4(Collection collection, e e10) {
        f0.p(collection, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return null;
        }
        n10 = collection.size();
        int n11 = e10.m(n10);
        return CollectionsKt___CollectionsKt.T1(collection, n11);
    }

    public static final List x5(List listIterator, int n10) {
        ArrayList arrayList = "$this$takeLast";
        f0.p(listIterator, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = listIterator.size();
            if (n10 >= n12) {
                return CollectionsKt___CollectionsKt.I5((Iterable)((Object)listIterator));
            }
            if (n10 == n11) {
                return t.k(CollectionsKt___CollectionsKt.a3((List)((Object)listIterator)));
            }
            arrayList = new ArrayList(n10);
            boolean bl2 = listIterator instanceof RandomAccess;
            if (bl2) {
                for (n10 = n12 - n10; n10 < n12; ++n10) {
                    Object e10 = ((List)((Object)listIterator)).get(n10);
                    arrayList.add(e10);
                }
            } else {
                listIterator = listIterator.listIterator(n12 -= n10);
                while ((n10 = (int)(listIterator.hasNext() ? 1 : 0)) != 0) {
                    Object e11 = listIterator.next();
                    arrayList.add(e11);
                }
            }
            return arrayList;
        }
        listIterator = new ListIterator();
        ((StringBuilder)((Object)listIterator)).append("Requested element count ");
        ((StringBuilder)((Object)listIterator)).append(n10);
        ((StringBuilder)((Object)listIterator)).append(" is less than zero.");
        listIterator = ((StringBuilder)((Object)listIterator)).toString();
        listIterator = listIterator.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)((Object)listIterator));
        throw illegalArgumentException;
    }

    public static final double y1(Iterable object) {
        boolean bl2;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            float f10 = number.floatValue();
            double d11 = f10;
            d10 += d11;
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n10 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n10;
            d10 /= d12;
        }
        return d10;
    }

    public static final Collection y2(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = (m)l10.invoke(object2);
            y.r0(collection, (m)object2);
        }
        return collection;
    }

    private static final Comparable y3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Comparable)l10.invoke(object2);
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
            if (n10 >= 0) continue;
            object2 = object3;
        }
        return object2;
    }

    public static final Object y4(Iterable object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            boolean bl3;
            object2 = object.next();
            while (bl3 = object.hasNext()) {
                Object e10 = object.next();
                object2 = p10.invoke(object2, e10);
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty collection can't be reduced.");
        throw object;
    }

    public static final List y5(List list, f.h2.s.l arrayList) {
        boolean bl2;
        f0.p(list, "$this$takeLastWhile");
        Object object = "predicate";
        f0.p(arrayList, (String)object);
        int n10 = list.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = list.size();
        object = list.listIterator(n10);
        while (bl2 = object.hasPrevious()) {
            Object object2 = object.previous();
            bl2 = (Boolean)(object2 = (Boolean)arrayList.invoke(object2));
            if (bl2) continue;
            object.next();
            int n11 = list.size();
            int n12 = object.nextIndex();
            if ((n11 -= n12) == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            arrayList = new ArrayList<List>(n11);
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                list = object.next();
                arrayList.add(list);
            }
            return arrayList;
        }
        return CollectionsKt___CollectionsKt.I5(list);
    }

    public static final double z1(Iterable object) {
        int n10;
        String string2 = "$this$average";
        f0.p(object, string2);
        object = object.iterator();
        double d10 = 0.0;
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            double d11 = n10;
            d10 += d11;
            if (++n11 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d12 = n11;
            d10 /= d12;
        }
        return d10;
    }

    public static final Collection z2(Iterable object, Collection collection, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = (Iterable)l10.invoke(object2);
            y.q0(collection, (Iterable)object2);
        }
        return collection;
    }

    private static final Double z3(Iterable object, f.h2.s.l l10) {
        boolean bl2;
        boolean bl3 = (object = object.iterator()).hasNext();
        if (!bl3) {
            return null;
        }
        Object object2 = object.next();
        object2 = (Number)l10.invoke(object2);
        double d10 = ((Number)object2).doubleValue();
        while (bl2 = object.hasNext()) {
            Object object3 = object.next();
            object3 = (Number)l10.invoke(object3);
            double d11 = ((Number)object3).doubleValue();
            d10 = Math.max(d10, d11);
        }
        return d10;
    }

    public static final Object z4(Iterable object, f.h2.s.q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            int n10;
            int n11;
            object2 = object.next();
            int n12 = n11 = 1;
            while ((n10 = object.hasNext()) != 0) {
                n10 = n12 + 1;
                if (n12 < 0) {
                    boolean bl3 = l.a(n11, 3, 0);
                    if (bl3) {
                        CollectionsKt__CollectionsKt.W();
                    } else {
                        object = new ArithmeticException("Index overflow has happened.");
                        throw object;
                    }
                }
                Integer n13 = n12;
                Object e10 = object.next();
                object2 = q10.invoke(n13, object2, e10);
                n12 = n10;
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty collection can't be reduced.");
        throw object;
    }

    public static final List z5(Iterable object, f.h2.s.l l10) {
        Object e10;
        Boolean bl2;
        boolean bl3;
        boolean bl4;
        f0.p(object, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while ((bl4 = object.hasNext()) && (bl3 = (bl2 = (Boolean)l10.invoke(e10 = object.next())).booleanValue())) {
            arrayList.add(e10);
        }
        return arrayList;
    }
}

