/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.c1;
import f.x1.s0;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptySet;

public class d1
extends c1 {
    private static final Set i(int n10, l l10) {
        Set set = c1.e(n10);
        l10.invoke(set);
        return c1.a(set);
    }

    private static final Set j(l l10) {
        Set set = c1.d();
        l10.invoke(set);
        return c1.a(set);
    }

    public static final Set k() {
        return EmptySet.INSTANCE;
    }

    private static final HashSet l() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    public static final HashSet m(Object ... objectArray) {
        f0.p(objectArray, "elements");
        int n10 = s0.j(objectArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Zx(objectArray, hashSet);
    }

    private static final LinkedHashSet n() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return linkedHashSet;
    }

    public static final LinkedHashSet o(Object ... objectArray) {
        f0.p(objectArray, "elements");
        int n10 = s0.j(objectArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (LinkedHashSet)ArraysKt___ArraysKt.Zx(objectArray, linkedHashSet);
    }

    private static final Set p() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return linkedHashSet;
    }

    public static final Set q(Object ... objectArray) {
        f0.p(objectArray, "elements");
        int n10 = s0.j(objectArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Zx(objectArray, linkedHashSet);
    }

    public static final Set r(Set set) {
        String string2 = "$this$optimizeReadOnlySet";
        f0.p(set, string2);
        int n10 = set.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                set = c1.f(set.iterator().next());
            }
        } else {
            set = d1.k();
        }
        return set;
    }

    private static final Set s(Set set) {
        if (set == null) {
            set = d1.k();
        }
        return set;
    }

    private static final Set t() {
        return d1.k();
    }

    public static final Set u(Object ... object) {
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        object = n10 > 0 ? ArraysKt___ArraysKt.Wy(object) : d1.k();
        return object;
    }

    public static final Set v(Object object) {
        object = object != null ? c1.f(object) : d1.k();
        return object;
    }

    public static final Set w(Object ... objectArray) {
        f0.p(objectArray, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return (Set)ArraysKt___ArraysKt.ra(objectArray, linkedHashSet);
    }
}

