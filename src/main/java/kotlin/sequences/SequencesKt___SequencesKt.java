/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.c1;
import f.d2.l;
import f.g1;
import f.h2.s.p;
import f.h2.s.q;
import f.h2.t.f0;
import f.n2.c;
import f.n2.d;
import f.n2.e;
import f.n2.f;
import f.n2.h;
import f.n2.i;
import f.n2.k;
import f.n2.m;
import f.n2.t;
import f.n2.u;
import f.n2.v;
import f.n2.w;
import f.q2.n;
import f.x1.d1;
import f.x1.e0;
import f.x1.y;
import f.y1.b;
import f.y1.b$b;
import f.y1.b$d;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesJvmKt;
import kotlin.sequences.SequencesKt___SequencesKt$a;
import kotlin.sequences.SequencesKt___SequencesKt$b;
import kotlin.sequences.SequencesKt___SequencesKt$c;
import kotlin.sequences.SequencesKt___SequencesKt$d;
import kotlin.sequences.SequencesKt___SequencesKt$distinct$1;
import kotlin.sequences.SequencesKt___SequencesKt$elementAt$1;
import kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$1;
import kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$2;
import kotlin.sequences.SequencesKt___SequencesKt$filterIsInstance$1;
import kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$1;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;
import kotlin.sequences.SequencesKt___SequencesKt$flatMapIndexed$1;
import kotlin.sequences.SequencesKt___SequencesKt$flatMapIndexed$2;
import kotlin.sequences.SequencesKt___SequencesKt$minus$1;
import kotlin.sequences.SequencesKt___SequencesKt$minus$2;
import kotlin.sequences.SequencesKt___SequencesKt$minus$3;
import kotlin.sequences.SequencesKt___SequencesKt$minus$4;
import kotlin.sequences.SequencesKt___SequencesKt$onEach$1;
import kotlin.sequences.SequencesKt___SequencesKt$onEachIndexed$1;
import kotlin.sequences.SequencesKt___SequencesKt$requireNoNulls$1;
import kotlin.sequences.SequencesKt___SequencesKt$runningFold$1;
import kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1;
import kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1;
import kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1;
import kotlin.sequences.SequencesKt___SequencesKt$zip$1;
import kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$1;
import kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2;

public class SequencesKt___SequencesKt
extends SequencesKt___SequencesJvmKt {
    private static final Collection A0(m object, Collection collection, p p10) {
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

    public static final Object A1(m object, Comparator comparator) {
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

    public static final m A2(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return SequencesKt___SequencesKt.D2(m10, b$b);
    }

    public static final m B0(m m10, p p10) {
        f0.p(m10, "$this$flatMapIndexed");
        f0.p(p10, "transform");
        SequencesKt___SequencesKt$flatMapIndexed$2 sequencesKt___SequencesKt$flatMapIndexed$2 = SequencesKt___SequencesKt$flatMapIndexed$2.INSTANCE;
        return SequencesKt__SequencesKt.k(m10, p10, sequencesKt___SequencesKt$flatMapIndexed$2);
    }

    public static final Comparable B1(m m10) {
        f0.p(m10, "$this$min");
        return SequencesKt___SequencesKt.O1(m10);
    }

    public static final m B2(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return SequencesKt___SequencesKt.D2(m10, b$d);
    }

    private static final Collection C0(m object, Collection collection, p p10) {
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

    public static final Double C1(m m10) {
        f0.p(m10, "$this$min");
        return SequencesKt___SequencesKt.P1(m10);
    }

    public static final m C2(m m10) {
        f0.p(m10, "$this$sortedDescending");
        Comparator comparator = b.q();
        return SequencesKt___SequencesKt.D2(m10, comparator);
    }

    public static final boolean D(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$all");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final m D0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$flatMap");
        f0.p(l10, "transform");
        SequencesKt___SequencesKt$flatMap$1 sequencesKt___SequencesKt$flatMap$1 = SequencesKt___SequencesKt$flatMap$1.INSTANCE;
        i i10 = new i(m10, l10, sequencesKt___SequencesKt$flatMap$1);
        return i10;
    }

    public static final Float D1(m m10) {
        f0.p(m10, "$this$min");
        return SequencesKt___SequencesKt.Q1(m10);
    }

    public static final m D2(m m10, Comparator comparator) {
        f0.p(m10, "$this$sortedWith");
        f0.p(comparator, "comparator");
        SequencesKt___SequencesKt$d sequencesKt___SequencesKt$d = new SequencesKt___SequencesKt$d(m10, comparator);
        return sequencesKt___SequencesKt$d;
    }

    public static final boolean E(m m10) {
        f0.p(m10, "$this$any");
        return m10.iterator().hasNext();
    }

    public static final Collection E0(m object, Collection collection, f.h2.s.l l10) {
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

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object E1(m object, f.h2.s.l l10) {
        boolean bl2;
        void var2_4;
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        Object e10 = object.next();
        boolean bl4 = object.hasNext();
        if (!bl4) {
            return var2_4;
        }
        Comparable comparable = (Comparable)l10.invoke(e10);
        do {
            Object e11;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(e11 = object.next()))) <= 0) continue;
            Object e12 = e11;
            comparable = comparable2;
        } while (bl2 = object.hasNext());
        return var2_4;
    }

    public static final int E2(m object, f.h2.s.l l10) {
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

    public static final boolean F(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$any");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Collection F0(m object, Collection collection, f.h2.s.l l10) {
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

    public static final Object F1(m object, f.h2.s.l l10) {
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

    public static final double F2(m object, f.h2.s.l l10) {
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

    public static final Iterable G(m m10) {
        f0.p(m10, "$this$asIterable");
        SequencesKt___SequencesKt$a sequencesKt___SequencesKt$a = new SequencesKt___SequencesKt$a(m10);
        return sequencesKt___SequencesKt$a;
    }

    public static final Object G0(m object, Object object2, p p10) {
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

    private static final double G1(m object, f.h2.s.l l10) {
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

    public static final int G2(m object) {
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

    private static final m H(m m10) {
        return m10;
    }

    public static final Object H0(m object, Object object2, q q10) {
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

    private static final float H1(m object, f.h2.s.l l10) {
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

    public static final double H2(m object) {
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

    public static final Map I(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associate");
        f0.p(l10, "transform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            object2 = (Pair)l10.invoke(object2);
            Object object3 = ((Pair)object2).getFirst();
            object2 = ((Pair)object2).getSecond();
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final void I0(m object, f.h2.s.l l10) {
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

    private static final Comparable I1(m object, f.h2.s.l l10) {
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

    private static final double I2(m object, f.h2.s.l l10) {
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

    public static final Map J(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associateBy");
        f0.p(l10, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = l10.invoke(e10);
            linkedHashMap.put(object2, e10);
        }
        return linkedHashMap;
    }

    public static final void J0(m object, p p10) {
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

    private static final Comparable J1(m object, f.h2.s.l l10) {
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

    public static final float J2(m object) {
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

    public static final Map K(m object, f.h2.s.l l10, f.h2.s.l l11) {
        boolean bl2;
        f0.p(object, "$this$associateBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            Object object3 = l10.invoke(object2);
            object2 = l11.invoke(object2);
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Map K0(m object, f.h2.s.l l10) {
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

    private static final Double K1(m object, f.h2.s.l l10) {
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

    public static final int K2(m object) {
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

    public static final Map L(m object, Map map, f.h2.s.l l10) {
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

    public static final Map L0(m object, f.h2.s.l l10, f.h2.s.l l11) {
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

    private static final Float L1(m object, f.h2.s.l l10) {
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

    private static final int L2(m object, f.h2.s.l l10) {
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

    public static final Map M(m object, Map map, f.h2.s.l l10, f.h2.s.l l11) {
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

    public static final Map M0(m object, Map map, f.h2.s.l l10) {
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

    private static final Object M1(m object, Comparator comparator, f.h2.s.l l10) {
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

    public static final long M2(m object) {
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

    public static final Map N(m object, Map map, f.h2.s.l l10) {
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

    public static final Map N0(m object, Map map, f.h2.s.l l10, f.h2.s.l l11) {
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

    private static final Object N1(m object, Comparator comparator, f.h2.s.l l10) {
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

    private static final long N2(m object, f.h2.s.l l10) {
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

    public static final Map O(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$associateWith");
        f0.p(l10, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = l10.invoke(e10);
            linkedHashMap.put(e10, object2);
        }
        return linkedHashMap;
    }

    public static final e0 O0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$groupingBy");
        f0.p(l10, "keySelector");
        SequencesKt___SequencesKt$b sequencesKt___SequencesKt$b = new SequencesKt___SequencesKt$b(m10, l10);
        return sequencesKt___SequencesKt$b;
    }

    public static final Comparable O1(m object) {
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

    public static final int O2(m object) {
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

    public static final Map P(m object, Map map, f.h2.s.l l10) {
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

    public static final int P0(m object, Object object2) {
        boolean bl2;
        f0.p(object, "$this$indexOf");
        object = object.iterator();
        int n10 = 0;
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

    public static final Double P1(m object) {
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

    private static final int P2(m object, f.h2.s.l l10) {
        int n10;
        int n11 = c1.h(0);
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = object.next();
            object2 = (c1)l10.invoke(object2);
            n10 = ((c1)object2).a0();
            n11 = c1.h(n11 + n10);
        }
        return n11;
    }

    public static final double Q(m object) {
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

    public static final int Q0(m object, f.h2.s.l l10) {
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

    public static final Float Q1(m object) {
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

    private static final long Q2(m object, f.h2.s.l l10) {
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

    public static final double R(m object) {
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

    public static final int R0(m object, f.h2.s.l l10) {
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

    public static final Object R1(m m10, Comparator comparator) {
        f0.p(m10, "$this$minWith");
        f0.p(comparator, "comparator");
        return SequencesKt___SequencesKt.S1(m10, comparator);
    }

    public static final m R2(m object, int n10) {
        boolean bl2;
        Object object2 = "$this$take";
        f0.p(object, (String)object2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            object = n10 == 0 ? SequencesKt__SequencesKt.j() : ((bl2 = object instanceof e) ? ((e)object).b(n10) : (object2 = new t((m)object, n10)));
            return object;
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

    public static final double S(m object) {
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

    public static final Appendable S0(m object, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, f.h2.s.l l10) {
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

    public static final Object S1(m object, Comparator comparator) {
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

    public static final m S2(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$takeWhile");
        f0.p(l10, "predicate");
        u u10 = new u(m10, l10);
        return u10;
    }

    public static final double T(m object) {
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

    public static /* synthetic */ Appendable T0(m m10, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, f.h2.s.l l10, int n11, Object object3) {
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
        object = m10;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return SequencesKt___SequencesKt.S0(m10, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final m T1(m m10, Iterable iterable) {
        f0.p(m10, "$this$minus");
        f0.p(iterable, "elements");
        SequencesKt___SequencesKt$minus$3 sequencesKt___SequencesKt$minus$3 = new SequencesKt___SequencesKt$minus$3(m10, iterable);
        return sequencesKt___SequencesKt$minus$3;
    }

    public static final Collection T2(m object, Collection collection) {
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

    public static final double U(m object) {
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

    public static final String U0(m object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, f.h2.s.l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)SequencesKt___SequencesKt.S0((m)object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final m U1(m m10, Object object) {
        f0.p(m10, "$this$minus");
        SequencesKt___SequencesKt$minus$1 sequencesKt___SequencesKt$minus$1 = new SequencesKt___SequencesKt$minus$1(m10, object);
        return sequencesKt___SequencesKt$minus$1;
    }

    public static final HashSet U2(m m10) {
        f0.p(m10, "$this$toHashSet");
        HashSet hashSet = new HashSet();
        return (HashSet)SequencesKt___SequencesKt.T2(m10, hashSet);
    }

    public static final double V(m object) {
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

    public static /* synthetic */ String V0(m m10, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, f.h2.s.l l10, int n11, Object object2) {
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
        object = m10;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return SequencesKt___SequencesKt.U0(m10, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final m V1(m m10, m m11) {
        f0.p(m10, "$this$minus");
        f0.p(m11, "elements");
        SequencesKt___SequencesKt$minus$4 sequencesKt___SequencesKt$minus$4 = new SequencesKt___SequencesKt$minus$4(m10, m11);
        return sequencesKt___SequencesKt$minus$4;
    }

    public static final List V2(m m10) {
        f0.p(m10, "$this$toList");
        return CollectionsKt__CollectionsKt.Q(SequencesKt___SequencesKt.W2(m10));
    }

    public static final m W(m m10, int n10) {
        f0.p(m10, "$this$chunked");
        return SequencesKt___SequencesKt.Z2(m10, n10, n10, true);
    }

    public static final Object W0(m object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            boolean bl3;
            string2 = object.next();
            while (bl3 = object.hasNext()) {
                string2 = object.next();
            }
            return string2;
        }
        object = new NoSuchElementException("Sequence is empty.");
        throw object;
    }

    public static final m W1(m m10, Object[] objectArray) {
        f0.p(m10, "$this$minus");
        Object object = "elements";
        f0.p(objectArray, (String)object);
        int n10 = objectArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return m10;
        }
        object = new SequencesKt___SequencesKt$minus$2(m10, objectArray);
        return object;
    }

    public static final List W2(m m10) {
        f0.p(m10, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        return (List)SequencesKt___SequencesKt.T2(m10, arrayList);
    }

    public static final m X(m m10, int n10, f.h2.s.l l10) {
        f0.p(m10, "$this$chunked");
        f0.p(l10, "transform");
        return SequencesKt___SequencesKt.a3(m10, n10, n10, true, l10);
    }

    public static final Object X0(m object, f.h2.s.l l10) {
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
        object = new NoSuchElementException("Sequence contains no element matching the predicate.");
        throw object;
    }

    private static final m X1(m m10, Object object) {
        return SequencesKt___SequencesKt.U1(m10, object);
    }

    public static final Set X2(m object) {
        boolean bl2;
        f0.p(object, "$this$toMutableSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            linkedHashSet.add(e10);
        }
        return linkedHashSet;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean Y(m m10, Object object) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(m10, string2);
        int bl2 = SequencesKt___SequencesKt.P0(m10, object);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            m10 = null;
        }
        return (boolean)var3_6;
    }

    public static final int Y0(m object, Object object2) {
        boolean bl2;
        String string2 = "$this$lastIndexOf";
        f0.p(object, string2);
        object = object.iterator();
        int n10 = -1;
        int n11 = 0;
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

    public static final boolean Y1(m m10) {
        f0.p(m10, "$this$none");
        return m10.iterator().hasNext() ^ true;
    }

    public static final Set Y2(m m10) {
        f0.p(m10, "$this$toSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return d1.r((Set)SequencesKt___SequencesKt.T2(m10, linkedHashSet));
    }

    public static final int Z(m object) {
        boolean bl2;
        f0.p(object, "$this$count");
        object = object.iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            object.next();
            if (++n10 >= 0) continue;
            CollectionsKt__CollectionsKt.V();
        }
        return n10;
    }

    public static final Object Z0(m object) {
        boolean bl2;
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        string2 = object.next();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
        }
        return string2;
    }

    public static final boolean Z1(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$none");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    public static final m Z2(m m10, int n10, int n11, boolean bl2) {
        f0.p(m10, "$this$windowed");
        return SlidingWindowKt.c(m10, n10, n11, bl2, false);
    }

    public static final int a0(m object, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$count");
        f0.p(l10, "predicate");
        object = object.iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
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

    public static final Object a1(m object, f.h2.s.l l10) {
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

    public static final m a2(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$onEach");
        f0.p(l10, "action");
        SequencesKt___SequencesKt$onEach$1 sequencesKt___SequencesKt$onEach$1 = new SequencesKt___SequencesKt$onEach$1(l10);
        return SequencesKt___SequencesKt.b1(m10, sequencesKt___SequencesKt$onEach$1);
    }

    public static final m a3(m m10, int n10, int n11, boolean bl2, f.h2.s.l l10) {
        f0.p(m10, "$this$windowed");
        f0.p(l10, "transform");
        return SequencesKt___SequencesKt.b1(SlidingWindowKt.c(m10, n10, n11, bl2, true), l10);
    }

    public static final m b0(m m10) {
        f0.p(m10, "$this$distinct");
        SequencesKt___SequencesKt$distinct$1 sequencesKt___SequencesKt$distinct$1 = SequencesKt___SequencesKt$distinct$1.INSTANCE;
        return SequencesKt___SequencesKt.c0(m10, sequencesKt___SequencesKt$distinct$1);
    }

    public static final m b1(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$map");
        f0.p(l10, "transform");
        w w10 = new w(m10, l10);
        return w10;
    }

    public static final m b2(m m10, p p10) {
        f0.p(m10, "$this$onEachIndexed");
        f0.p(p10, "action");
        SequencesKt___SequencesKt$onEachIndexed$1 sequencesKt___SequencesKt$onEachIndexed$1 = new SequencesKt___SequencesKt$onEachIndexed$1(p10);
        return SequencesKt___SequencesKt.c1(m10, sequencesKt___SequencesKt$onEachIndexed$1);
    }

    public static /* synthetic */ m b3(m m10, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return SequencesKt___SequencesKt.Z2(m10, n10, n11, bl2);
    }

    public static final m c0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$distinctBy");
        f0.p(l10, "selector");
        c c10 = new c(m10, l10);
        return c10;
    }

    public static final m c1(m m10, p p10) {
        f0.p(m10, "$this$mapIndexed");
        f0.p(p10, "transform");
        v v10 = new v(m10, p10);
        return v10;
    }

    public static final Pair c2(m object, f.h2.s.l l10) {
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

    public static /* synthetic */ m c3(m m10, int n10, int n11, boolean bl2, f.h2.s.l l10, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return SequencesKt___SequencesKt.a3(m10, n10, n11, bl2, l10);
    }

    public static final m d0(m object, int n10) {
        boolean bl2;
        Object object2 = "$this$drop";
        f0.p(object, (String)object2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            if (n10 != 0) {
                bl2 = object instanceof e;
                object = bl2 ? ((e)object).a(n10) : (object2 = new d((m)object, n10));
            }
            return object;
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

    public static final m d1(m m10, p p10) {
        f0.p(m10, "$this$mapIndexedNotNull");
        f0.p(p10, "transform");
        v v10 = new v(m10, p10);
        return SequencesKt___SequencesKt.o0(v10);
    }

    public static final m d2(m m10, Iterable iterable) {
        f0.p(m10, "$this$plus");
        f0.p(iterable, "elements");
        Object[] objectArray = new m[]{m10, m10 = CollectionsKt___CollectionsKt.n1(iterable)};
        return SequencesKt__SequencesKt.l(SequencesKt__SequencesKt.t(objectArray));
    }

    public static final m d3(m m10) {
        f0.p(m10, "$this$withIndex");
        k k10 = new k(m10);
        return k10;
    }

    public static final m e0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$dropWhile");
        f0.p(l10, "predicate");
        f f10 = new f(m10, l10);
        return f10;
    }

    public static final Collection e1(m object, Collection collection, p p10) {
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

    public static final m e2(m m10, Object object) {
        f0.p(m10, "$this$plus");
        Object[] objectArray = new m[2];
        objectArray[0] = m10;
        int n10 = 1;
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = object;
        objectArray[n10] = object = SequencesKt__SequencesKt.t(objectArray2);
        return SequencesKt__SequencesKt.l(SequencesKt__SequencesKt.t(objectArray));
    }

    public static final m e3(m m10, m m11) {
        f0.p(m10, "$this$zip");
        f0.p(m11, "other");
        SequencesKt___SequencesKt$zip$1 sequencesKt___SequencesKt$zip$1 = SequencesKt___SequencesKt$zip$1.INSTANCE;
        f.n2.l l10 = new f.n2.l(m10, m11, sequencesKt___SequencesKt$zip$1);
        return l10;
    }

    public static final Object f0(m m10, int n10) {
        f0.p(m10, "$this$elementAt");
        SequencesKt___SequencesKt$elementAt$1 sequencesKt___SequencesKt$elementAt$1 = new SequencesKt___SequencesKt$elementAt$1(n10);
        return SequencesKt___SequencesKt.g0(m10, n10, sequencesKt___SequencesKt$elementAt$1);
    }

    public static final Collection f1(m object, Collection collection, p p10) {
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

    public static final m f2(m m10, m m11) {
        f0.p(m10, "$this$plus");
        f0.p(m11, "elements");
        Object[] objectArray = new m[]{m10, m11};
        return SequencesKt__SequencesKt.l(SequencesKt__SequencesKt.t(objectArray));
    }

    public static final m f3(m m10, m m11, p p10) {
        f0.p(m10, "$this$zip");
        f0.p(m11, "other");
        f0.p(p10, "transform");
        f.n2.l l10 = new f.n2.l(m10, m11, p10);
        return l10;
    }

    public static final Object g0(m object, int n10, f.h2.s.l l10) {
        boolean bl2;
        f0.p(object, "$this$elementAtOrElse");
        String string2 = "defaultValue";
        f0.p(l10, string2);
        if (n10 < 0) {
            object = n10;
            return l10.invoke(object);
        }
        object = object.iterator();
        int n11 = 0;
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

    public static final m g1(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$mapNotNull");
        f0.p(l10, "transform");
        w w10 = new w(m10, l10);
        return SequencesKt___SequencesKt.o0(w10);
    }

    public static final m g2(m m10, Object[] object) {
        f0.p(m10, "$this$plus");
        f0.p(object, "elements");
        object = f.x1.n.t(object);
        return SequencesKt___SequencesKt.d2(m10, (Iterable)object);
    }

    public static final m g3(m m10) {
        f0.p(m10, "$this$zipWithNext");
        SequencesKt___SequencesKt$zipWithNext$1 sequencesKt___SequencesKt$zipWithNext$1 = SequencesKt___SequencesKt$zipWithNext$1.INSTANCE;
        return SequencesKt___SequencesKt.h3(m10, sequencesKt___SequencesKt$zipWithNext$1);
    }

    public static final Object h0(m object, int n10) {
        boolean bl2;
        f0.p(object, "$this$elementAtOrNull");
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

    public static final Collection h1(m object, Collection collection, f.h2.s.l l10) {
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

    private static final m h2(m m10, Object object) {
        return SequencesKt___SequencesKt.e2(m10, object);
    }

    public static final m h3(m m10, p p10) {
        f0.p(m10, "$this$zipWithNext");
        f0.p(p10, "transform");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(m10, p10, null);
        return f.n2.q.e(sequencesKt___SequencesKt$zipWithNext$2);
    }

    public static final m i0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$filter");
        f0.p(l10, "predicate");
        h h10 = new h(m10, true, l10);
        return h10;
    }

    public static final Collection i1(m object, Collection collection, f.h2.s.l l10) {
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

    public static final Object i2(m object, p p10) {
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
        object = new UnsupportedOperationException("Empty sequence can't be reduced.");
        throw object;
    }

    public static final m j0(m object, p p10) {
        f0.p(object, "$this$filterIndexed");
        f0.p(p10, "predicate");
        k k10 = new k((m)object);
        object = new SequencesKt___SequencesKt$filterIndexed$1(p10);
        h h10 = new h(k10, true, (f.h2.s.l)object);
        object = SequencesKt___SequencesKt$filterIndexed$2.INSTANCE;
        w w10 = new w(h10, (f.h2.s.l)object);
        return w10;
    }

    public static final Comparable j1(m m10) {
        f0.p(m10, "$this$max");
        return SequencesKt___SequencesKt.w1(m10);
    }

    public static final Object j2(m object, q q10) {
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
        object = new UnsupportedOperationException("Empty sequence can't be reduced.");
        throw object;
    }

    public static final Collection k0(m object, Collection collection, p p10) {
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

    public static final Double k1(m m10) {
        f0.p(m10, "$this$max");
        return SequencesKt___SequencesKt.x1(m10);
    }

    public static final Object k2(m object, q q10) {
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

    public static final /* synthetic */ m l0(m m10) {
        f0.p(m10, "$this$filterIsInstance");
        f0.w();
        SequencesKt___SequencesKt$filterIsInstance$1 sequencesKt___SequencesKt$filterIsInstance$1 = SequencesKt___SequencesKt$filterIsInstance$1.INSTANCE;
        m10 = SequencesKt___SequencesKt.i0(m10, sequencesKt___SequencesKt$filterIsInstance$1);
        Objects.requireNonNull(m10, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return m10;
    }

    public static final Float l1(m m10) {
        f0.p(m10, "$this$max");
        return SequencesKt___SequencesKt.y1(m10);
    }

    public static final Object l2(m object, p p10) {
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

    public static final /* synthetic */ Collection m0(m object, Collection collection) {
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

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object m1(m object, f.h2.s.l l10) {
        boolean bl2;
        void var2_4;
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        object = object.iterator();
        boolean bl3 = object.hasNext();
        if (!bl3) {
            return null;
        }
        Object e10 = object.next();
        boolean bl4 = object.hasNext();
        if (!bl4) {
            return var2_4;
        }
        Comparable comparable = (Comparable)l10.invoke(e10);
        do {
            Object e11;
            Comparable comparable2;
            int n10;
            if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(e11 = object.next()))) >= 0) continue;
            Object e12 = e11;
            comparable = comparable2;
        } while (bl2 = object.hasNext());
        return var2_4;
    }

    public static final m m2(m m10) {
        f0.p(m10, "$this$requireNoNulls");
        SequencesKt___SequencesKt$requireNoNulls$1 sequencesKt___SequencesKt$requireNoNulls$1 = new SequencesKt___SequencesKt$requireNoNulls$1(m10);
        return SequencesKt___SequencesKt.b1(m10, sequencesKt___SequencesKt$requireNoNulls$1);
    }

    public static final m n0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$filterNot");
        f0.p(l10, "predicate");
        h h10 = new h(m10, false, l10);
        return h10;
    }

    public static final Object n1(m object, f.h2.s.l l10) {
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

    public static final m n2(m m10, Object object, p p10) {
        f0.p(m10, "$this$runningFold");
        f0.p(p10, "operation");
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(m10, object, p10, null);
        return f.n2.q.e(sequencesKt___SequencesKt$runningFold$1);
    }

    public static final m o0(m m10) {
        f0.p(m10, "$this$filterNotNull");
        SequencesKt___SequencesKt$filterNotNull$1 sequencesKt___SequencesKt$filterNotNull$1 = SequencesKt___SequencesKt$filterNotNull$1.INSTANCE;
        m10 = SequencesKt___SequencesKt.n0(m10, sequencesKt___SequencesKt$filterNotNull$1);
        Objects.requireNonNull(m10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return m10;
    }

    private static final double o1(m object, f.h2.s.l l10) {
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

    public static final m o2(m m10, Object object, q q10) {
        f0.p(m10, "$this$runningFoldIndexed");
        f0.p(q10, "operation");
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(m10, object, q10, null);
        return f.n2.q.e(sequencesKt___SequencesKt$runningFoldIndexed$1);
    }

    public static final Collection p0(m object, Collection collection) {
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

    private static final float p1(m object, f.h2.s.l l10) {
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

    public static final m p2(m m10, p p10) {
        f0.p(m10, "$this$runningReduce");
        f0.p(p10, "operation");
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(m10, p10, null);
        return f.n2.q.e(sequencesKt___SequencesKt$runningReduce$1);
    }

    public static final Collection q0(m object, Collection collection, f.h2.s.l l10) {
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

    private static final Comparable q1(m object, f.h2.s.l l10) {
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

    public static final m q2(m m10, q q10) {
        f0.p(m10, "$this$runningReduceIndexed");
        f0.p(q10, "operation");
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(m10, q10, null);
        return f.n2.q.e(sequencesKt___SequencesKt$runningReduceIndexed$1);
    }

    public static final Collection r0(m object, Collection collection, f.h2.s.l l10) {
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

    private static final Comparable r1(m object, f.h2.s.l l10) {
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

    public static final m r2(m m10, Object object, p p10) {
        f0.p(m10, "$this$scan");
        f0.p(p10, "operation");
        return SequencesKt___SequencesKt.n2(m10, object, p10);
    }

    private static final Object s0(m object, f.h2.s.l l10) {
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

    private static final Double s1(m object, f.h2.s.l l10) {
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

    public static final m s2(m m10, Object object, q q10) {
        f0.p(m10, "$this$scanIndexed");
        f0.p(q10, "operation");
        return SequencesKt___SequencesKt.o2(m10, object, q10);
    }

    private static final Object t0(m object, f.h2.s.l l10) {
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

    private static final Float t1(m object, f.h2.s.l l10) {
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

    public static final m t2(m m10, p p10) {
        f0.p(m10, "$this$scanReduce");
        f0.p(p10, "operation");
        return SequencesKt___SequencesKt.p2(m10, p10);
    }

    public static final Object u0(m object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            return object.next();
        }
        object = new NoSuchElementException("Sequence is empty.");
        throw object;
    }

    private static final Object u1(m object, Comparator comparator, f.h2.s.l l10) {
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

    public static final m u2(m m10, q q10) {
        f0.p(m10, "$this$scanReduceIndexed");
        f0.p(q10, "operation");
        return SequencesKt___SequencesKt.q2(m10, q10);
    }

    public static final Object v0(m object, f.h2.s.l l10) {
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
        object = new NoSuchElementException("Sequence contains no element matching the predicate.");
        throw object;
    }

    private static final Object v1(m object, Comparator comparator, f.h2.s.l l10) {
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

    public static final Object v2(m object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (bl2) {
            string2 = object.next();
            boolean bl3 = object.hasNext();
            if (!bl3) {
                return string2;
            }
            object = new IllegalArgumentException("Sequence has more than one element.");
            throw object;
        }
        object = new NoSuchElementException("Sequence is empty.");
        throw object;
    }

    public static final Object w0(m object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return null;
        }
        return object.next();
    }

    public static final Comparable w1(m object) {
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

    public static final Object w2(m object, f.h2.s.l l10) {
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
            object = new IllegalArgumentException("Sequence contains more than one matching element.");
            throw object;
        }
        if (bl4) {
            return var3_3;
        }
        object = new NoSuchElementException("Sequence contains no element matching the predicate.");
        throw object;
    }

    public static final Object x0(m object, f.h2.s.l l10) {
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

    public static final Double x1(m object) {
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

    public static final Object x2(m object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        object = object.iterator();
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return null;
        }
        string2 = object.next();
        boolean bl3 = object.hasNext();
        if (bl3) {
            return null;
        }
        return string2;
    }

    public static final m y0(m m10, f.h2.s.l l10) {
        f0.p(m10, "$this$flatMap");
        f0.p(l10, "transform");
        SequencesKt___SequencesKt$flatMap$2 sequencesKt___SequencesKt$flatMap$2 = SequencesKt___SequencesKt$flatMap$2.INSTANCE;
        i i10 = new i(m10, l10, sequencesKt___SequencesKt$flatMap$2);
        return i10;
    }

    public static final Float y1(m object) {
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

    public static final Object y2(m object, f.h2.s.l l10) {
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

    public static final m z0(m m10, p p10) {
        f0.p(m10, "$this$flatMapIndexed");
        f0.p(p10, "transform");
        SequencesKt___SequencesKt$flatMapIndexed$1 sequencesKt___SequencesKt$flatMapIndexed$1 = SequencesKt___SequencesKt$flatMapIndexed$1.INSTANCE;
        return SequencesKt__SequencesKt.k(m10, p10, sequencesKt___SequencesKt$flatMapIndexed$1);
    }

    public static final Object z1(m m10, Comparator comparator) {
        f0.p(m10, "$this$maxWith");
        f0.p(comparator, "comparator");
        return SequencesKt___SequencesKt.A1(m10, comparator);
    }

    public static final m z2(m m10) {
        f0.p(m10, "$this$sorted");
        SequencesKt___SequencesKt$c sequencesKt___SequencesKt$c = new SequencesKt___SequencesKt$c(m10);
        return sequencesKt___SequencesKt$c;
    }
}

