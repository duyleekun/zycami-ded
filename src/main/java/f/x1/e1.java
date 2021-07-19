/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.n2.m;
import f.x1.d1;
import f.x1.s0;
import f.x1.u;
import f.x1.y;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;

public class e1
extends d1 {
    public static final Set A(Set set, Object[] objectArray) {
        f0.p(set, "$this$minus");
        f0.p(objectArray, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        y.J0(linkedHashSet, objectArray);
        return linkedHashSet;
    }

    private static final Set B(Set set, Object object) {
        return e1.y(set, object);
    }

    public static final Set C(Set set, Iterable iterable) {
        int n10;
        int n11;
        f0.p(set, "$this$plus");
        f0.p(iterable, "elements");
        Integer n12 = u.Z(iterable);
        if (n12 != null) {
            n11 = n12;
            n10 = set.size() + n11;
        } else {
            n11 = set.size();
            n10 = n11 * 2;
        }
        n11 = s0.j(n10);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n11);
        linkedHashSet.addAll(set);
        y.q0(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static final Set D(Set set, Object object) {
        f0.p(set, "$this$plus");
        int n10 = s0.j(set.size() + 1);
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>(n10);
        linkedHashSet.addAll(set);
        linkedHashSet.add(object);
        return linkedHashSet;
    }

    public static final Set E(Set set, m m10) {
        f0.p(set, "$this$plus");
        f0.p(m10, "elements");
        int n10 = s0.j(set.size() * 2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        linkedHashSet.addAll(set);
        y.r0(linkedHashSet, m10);
        return linkedHashSet;
    }

    public static final Set F(Set set, Object[] objectArray) {
        f0.p(set, "$this$plus");
        f0.p(objectArray, "elements");
        int n10 = set.size();
        int n11 = objectArray.length;
        n10 = s0.j(n10 + n11);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        linkedHashSet.addAll(set);
        y.s0(linkedHashSet, objectArray);
        return linkedHashSet;
    }

    private static final Set G(Set set, Object object) {
        return e1.D(set, object);
    }

    public static final Set x(Set object, Iterable iterable) {
        f0.p(object, "$this$minus");
        LinkedHashSet linkedHashSet = "elements";
        f0.p(iterable, (String)((Object)linkedHashSet));
        iterable = u.b0(iterable, (Iterable)object);
        boolean bl2 = iterable.isEmpty();
        if (bl2) {
            return CollectionsKt___CollectionsKt.N5((Iterable)object);
        }
        bl2 = iterable instanceof Set;
        if (bl2) {
            boolean bl3;
            linkedHashSet = new LinkedHashSet();
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                Object e10 = object.next();
                boolean bl4 = ((Collection)iterable).contains(e10);
                if (bl4) continue;
                linkedHashSet.add(e10);
            }
            return linkedHashSet;
        }
        linkedHashSet = new LinkedHashSet(object);
        linkedHashSet.removeAll((Collection<?>)iterable);
        return linkedHashSet;
    }

    public static final Set y(Set object, Object object2) {
        boolean bl2;
        f0.p(object, "$this$minus");
        int n10 = s0.j(object.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
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
            linkedHashSet.add(e10);
        }
        return linkedHashSet;
    }

    public static final Set z(Set set, m m10) {
        f0.p(set, "$this$minus");
        f0.p(m10, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        y.I0(linkedHashSet, m10);
        return linkedHashSet;
    }
}

