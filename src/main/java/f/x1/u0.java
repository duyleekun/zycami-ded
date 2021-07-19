/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.x1.t;
import f.x1.t0;
import f.x1.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

public class u0
extends t0 {
    public static final boolean A1(Map object, l l10) {
        f0.p(object, "$this$none");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object.isEmpty();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return false;
        }
        return bl3;
    }

    public static final Map B1(Map map, l l10) {
        boolean bl2;
        f0.p(map, "$this$onEach");
        f0.p(l10, "action");
        Iterator iterator2 = map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            l10.invoke(entry);
        }
        return map;
    }

    public static final Map C1(Map map, p p10) {
        boolean bl2;
        f0.p(map, "$this$onEachIndexed");
        f0.p(p10, "action");
        Iterator iterator2 = map.entrySet().iterator();
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
        return map;
    }

    public static final List D1(Map object) {
        Iterator iterator2 = "$this$toList";
        f0.p(object, (String)((Object)iterator2));
        int n10 = object.size();
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        iterator2 = object.entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return CollectionsKt__CollectionsKt.E();
        }
        Object object2 = (Map.Entry)iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            iterator2 = object2.getKey();
            object2 = object2.getValue();
            object = new Pair(iterator2, object2);
            return t.k(object);
        }
        int n11 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        Object k10 = object2.getKey();
        object2 = object2.getValue();
        object = new Pair(k10, object2);
        arrayList.add(object);
        do {
            object = (Map.Entry)iterator2.next();
            k10 = object.getKey();
            object = object.getValue();
            object2 = new Pair(k10, object);
            arrayList.add(object2);
        } while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0);
        return arrayList;
    }

    public static final boolean L0(Map object, l l10) {
        f0.p(object, "$this$all");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object.isEmpty();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (bl2) continue;
            return false;
        }
        return bl3;
    }

    public static final boolean M0(Map map) {
        f0.p(map, "$this$any");
        return map.isEmpty() ^ true;
    }

    public static final boolean N0(Map object, l l10) {
        f0.p(object, "$this$any");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return false;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static final Iterable O0(Map map) {
        return map.entrySet();
    }

    public static final m P0(Map map) {
        f0.p(map, "$this$asSequence");
        return CollectionsKt___CollectionsKt.n1(map.entrySet());
    }

    private static final int Q0(Map map) {
        return map.size();
    }

    public static final int R0(Map object, l l10) {
        f0.p(object, "$this$count");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        boolean bl2 = object.isEmpty();
        int n10 = 0;
        if (bl2) {
            return 0;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            bl2 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl2) continue;
            ++n10;
        }
        return n10;
    }

    public static final List S0(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            object2 = (Iterable)l10.invoke(object2);
            y.q0(arrayList, (Iterable)object2);
        }
        return arrayList;
    }

    public static final List T0(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            object2 = (m)l10.invoke(object2);
            y.r0(arrayList, (m)object2);
        }
        return arrayList;
    }

    public static final Collection U0(Map object, Collection collection, l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            object2 = (m)l10.invoke(object2);
            y.r0(collection, (m)object2);
        }
        return collection;
    }

    public static final Collection V0(Map object, Collection collection, l l10) {
        boolean bl2;
        f0.p(object, "$this$flatMapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            object2 = (Iterable)l10.invoke(object2);
            y.q0(collection, (Iterable)object2);
        }
        return collection;
    }

    public static final void W0(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$forEach");
        Object object2 = "action";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            l10.invoke(object2);
        }
    }

    public static final List X0(Map object, l l10) {
        f0.p(object, "$this$map");
        f0.p(l10, "transform");
        int n10 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (Map.Entry)object.next();
            object2 = l10.invoke(object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List Y0(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$mapNotNull");
        f0.p(l10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            if ((object2 = l10.invoke(object2)) == null) continue;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final Collection Z0(Map object, Collection collection, l l10) {
        boolean bl2;
        f0.p(object, "$this$mapNotNullTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            if ((object2 = l10.invoke(object2)) == null) continue;
            collection.add(object2);
        }
        return collection;
    }

    public static final Collection a1(Map object, Collection collection, l l10) {
        boolean bl2;
        f0.p(object, "$this$mapTo");
        f0.p(collection, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            object2 = l10.invoke(object2);
            collection.add(object2);
        }
        return collection;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Map.Entry b1(Map iterator2, l l10) {
        boolean bl2 = (iterator2 = iterator2.entrySet().iterator()).hasNext();
        if (!bl2) {
            iterator2 = null;
            return (Map.Entry)((Object)iterator2);
        }
        Object t10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (bl3) {
            boolean bl4;
            Comparable comparable = (Comparable)l10.invoke(t10);
            do {
                Object t11;
                Comparable comparable2;
                int n10;
                if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) >= 0) continue;
                t10 = t11;
                comparable = comparable2;
            } while (bl4 = iterator2.hasNext());
        }
        iterator2 = t10;
        return (Map.Entry)((Object)iterator2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Map.Entry c1(Map iterator2, l l10) {
        boolean bl2 = (iterator2 = iterator2.entrySet().iterator()).hasNext();
        if (!bl2) {
            iterator2 = null;
            return (Map.Entry)((Object)iterator2);
        }
        Object t10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (bl3) {
            boolean bl4;
            Comparable comparable = (Comparable)l10.invoke(t10);
            do {
                Object t11;
                Comparable comparable2;
                int n10;
                if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) >= 0) continue;
                t10 = t11;
                comparable = comparable2;
            } while (bl4 = iterator2.hasNext());
        }
        iterator2 = t10;
        return (Map.Entry)((Object)iterator2);
    }

    private static final double d1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final float e1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Comparable f1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Comparable g1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Comparable)l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
                if (n10 >= 0) continue;
                object2 = object3;
            }
            object = object2;
        }
        return object;
    }

    private static final Double h1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
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
            object = d10;
        }
        return object;
    }

    private static final Float i1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
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
            object = Float.valueOf(f10);
        }
        return object;
    }

    private static final Object j1(Map object, Comparator comparator, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Object k1(Map object, Comparator comparator, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
            boolean bl3;
            Object object2 = object.next();
            object2 = l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
                if (n10 >= 0) continue;
                object2 = object3;
            }
            object = object2;
        }
        return object;
    }

    private static final Map.Entry l1(Map map, Comparator comparator) {
        return (Map.Entry)CollectionsKt___CollectionsKt.H3(map.entrySet(), comparator);
    }

    private static final Map.Entry m1(Map map, Comparator comparator) {
        return (Map.Entry)CollectionsKt___CollectionsKt.H3(map.entrySet(), comparator);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static final Map.Entry n1(Map iterator2, l l10) {
        void var2_4;
        f0.p(iterator2, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        iterator2 = iterator2.entrySet().iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            iterator2 = null;
            return (Map.Entry)((Object)iterator2);
        }
        Object t10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (bl3) {
            boolean bl4;
            Comparable comparable = (Comparable)l10.invoke(t10);
            do {
                Object t11;
                Comparable comparable2;
                int n10;
                if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) <= 0) continue;
                Object t12 = t11;
                comparable = comparable2;
            } while (bl4 = iterator2.hasNext());
        }
        iterator2 = var2_4;
        return (Map.Entry)((Object)iterator2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final Map.Entry o1(Map iterator2, l l10) {
        boolean bl2 = (iterator2 = iterator2.entrySet().iterator()).hasNext();
        if (!bl2) {
            iterator2 = null;
            return (Map.Entry)((Object)iterator2);
        }
        Object t10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (bl3) {
            boolean bl4;
            Comparable comparable = (Comparable)l10.invoke(t10);
            do {
                Object t11;
                Comparable comparable2;
                int n10;
                if ((n10 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(t11 = iterator2.next()))) <= 0) continue;
                t10 = t11;
                comparable = comparable2;
            } while (bl4 = iterator2.hasNext());
        }
        iterator2 = t10;
        return (Map.Entry)((Object)iterator2);
    }

    private static final double p1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final float q1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Comparable r1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Comparable s1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
            boolean bl3;
            Object object2 = object.next();
            object2 = (Comparable)l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = object2.compareTo(object3 = (Comparable)l10.invoke(object3));
                if (n10 <= 0) continue;
                object2 = object3;
            }
            object = object2;
        }
        return object;
    }

    private static final Double t1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
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
            object = d10;
        }
        return object;
    }

    private static final Float u1(Map object, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
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
            object = Float.valueOf(f10);
        }
        return object;
    }

    private static final Object v1(Map object, Comparator comparator, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
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

    private static final Object w1(Map object, Comparator comparator, l l10) {
        boolean bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            object = null;
        } else {
            boolean bl3;
            Object object2 = object.next();
            object2 = l10.invoke(object2);
            while (bl3 = object.hasNext()) {
                Object object3 = object.next();
                int n10 = comparator.compare(object2, object3 = l10.invoke(object3));
                if (n10 <= 0) continue;
                object2 = object3;
            }
            object = object2;
        }
        return object;
    }

    public static final Map.Entry x1(Map map, Comparator comparator) {
        f0.p(map, "$this$minWith");
        f0.p(comparator, "comparator");
        return (Map.Entry)CollectionsKt___CollectionsKt.Z3(map.entrySet(), comparator);
    }

    private static final Map.Entry y1(Map map, Comparator comparator) {
        return (Map.Entry)CollectionsKt___CollectionsKt.Z3(map.entrySet(), comparator);
    }

    public static final boolean z1(Map map) {
        f0.p(map, "$this$none");
        return map.isEmpty();
    }
}

