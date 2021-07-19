/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.t0;
import f.n2.m;
import f.x1.n;
import f.x1.u;
import f.x1.x;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

public class y
extends x {
    private static final void A0(Collection collection, Object object) {
        f0.p(collection, "$this$plusAssign");
        collection.add(object);
    }

    private static final void B0(Collection collection, m m10) {
        f0.p(collection, "$this$plusAssign");
        y.r0(collection, m10);
    }

    private static final void C0(Collection collection, Object[] objectArray) {
        f0.p(collection, "$this$plusAssign");
        y.s0(collection, objectArray);
    }

    private static final Object D0(List list, int n10) {
        return list.remove(n10);
    }

    private static final boolean E0(Collection collection, Object object) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return t0.a(collection).remove(object);
    }

    public static final boolean F0(Iterable iterable, l l10) {
        f0.p(iterable, "$this$removeAll");
        f0.p(l10, "predicate");
        return y.t0(iterable, l10, true);
    }

    public static final boolean G0(Collection collection, Iterable iterable) {
        f0.p(collection, "$this$removeAll");
        f0.p(iterable, "elements");
        iterable = u.b0(iterable, collection);
        return t0.a(collection).removeAll((Collection<?>)iterable);
    }

    private static final boolean H0(Collection collection, Collection collection2) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return t0.a(collection).removeAll(collection2);
    }

    public static final boolean I0(Collection collection, m object) {
        boolean bl2;
        f0.p(collection, "$this$removeAll");
        String string2 = "elements";
        f0.p(object, string2);
        object = SequencesKt___SequencesKt.U2((m)object);
        boolean bl3 = object.isEmpty();
        boolean bl4 = true;
        if (!(bl3 ^= bl4) || !(bl2 = collection.removeAll((Collection<?>)object))) {
            bl4 = false;
        }
        return bl4;
    }

    public static final boolean J0(Collection collection, Object[] object) {
        boolean bl2;
        f0.p(collection, "$this$removeAll");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if ((n10 ^= n12) != 0 && (bl2 = collection.removeAll((Collection<?>)(object = ArraysKt___ArraysKt.ky(object))))) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public static final boolean K0(List list, l l10) {
        f0.p(list, "$this$removeAll");
        f0.p(l10, "predicate");
        return y.u0(list, l10, true);
    }

    public static final Object L0(List object) {
        String string2 = "$this$removeFirst";
        f0.p(object, string2);
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return object.remove(0);
        }
        object = new NoSuchElementException("List is empty.");
        throw object;
    }

    public static final Object M0(List list) {
        String string2 = "$this$removeFirstOrNull";
        f0.p(list, string2);
        boolean bl2 = list.isEmpty();
        if (bl2) {
            list = null;
        } else {
            bl2 = false;
            string2 = null;
            list = list.remove(0);
        }
        return list;
    }

    public static final Object N0(List object) {
        String string2 = "$this$removeLast";
        f0.p(object, string2);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            n10 = CollectionsKt__CollectionsKt.G((List)object);
            return object.remove(n10);
        }
        object = new NoSuchElementException("List is empty.");
        throw object;
    }

    public static final Object O0(List list) {
        String string2 = "$this$removeLastOrNull";
        f0.p(list, string2);
        int n10 = list.isEmpty();
        if (n10 != 0) {
            list = null;
        } else {
            n10 = CollectionsKt__CollectionsKt.G(list);
            list = list.remove(n10);
        }
        return list;
    }

    public static final boolean P0(Iterable iterable, l l10) {
        f0.p(iterable, "$this$retainAll");
        f0.p(l10, "predicate");
        return y.t0(iterable, l10, false);
    }

    public static final boolean Q0(Collection collection, Iterable iterable) {
        f0.p(collection, "$this$retainAll");
        f0.p(iterable, "elements");
        iterable = u.b0(iterable, collection);
        return t0.a(collection).retainAll((Collection<?>)iterable);
    }

    private static final boolean R0(Collection collection, Collection collection2) {
        Objects.requireNonNull(collection, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        return t0.a(collection).retainAll(collection2);
    }

    public static final boolean S0(Collection collection, m object) {
        f0.p(collection, "$this$retainAll");
        String string2 = "elements";
        f0.p(object, string2);
        object = SequencesKt___SequencesKt.U2((m)object);
        boolean bl2 = object.isEmpty() ^ true;
        if (bl2) {
            return collection.retainAll((Collection<?>)object);
        }
        return y.V0(collection);
    }

    public static final boolean T0(Collection collection, Object[] object) {
        f0.p(collection, "$this$retainAll");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if ((n10 ^= n11) != 0) {
            object = ArraysKt___ArraysKt.ky(object);
            return collection.retainAll((Collection<?>)object);
        }
        return y.V0(collection);
    }

    public static final boolean U0(List list, l l10) {
        f0.p(list, "$this$retainAll");
        f0.p(l10, "predicate");
        return y.u0(list, l10, false);
    }

    private static final boolean V0(Collection collection) {
        boolean bl2 = collection.isEmpty() ^ true;
        collection.clear();
        return bl2;
    }

    public static final boolean q0(Collection collection, Iterable object) {
        boolean bl2;
        f0.p(collection, "$this$addAll");
        String string2 = "elements";
        f0.p(object, string2);
        boolean bl3 = object instanceof Collection;
        if (bl3) {
            object = (Collection)object;
            return collection.addAll(object);
        }
        bl3 = false;
        string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = collection.add(e10);
            if (!bl2) continue;
            bl3 = true;
        }
        return bl3;
    }

    public static final boolean r0(Collection collection, m object) {
        boolean bl2;
        f0.p(collection, "$this$addAll");
        f0.p(object, "elements");
        object = object.iterator();
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = collection.add(e10);
            if (!bl2) continue;
            bl3 = true;
        }
        return bl3;
    }

    public static final boolean s0(Collection collection, Object[] object) {
        f0.p(collection, "$this$addAll");
        f0.p(object, "elements");
        object = n.t(object);
        return collection.addAll(object);
    }

    private static final boolean t0(Iterable object, l l10, boolean bl2) {
        boolean bl3;
        object = object.iterator();
        boolean bl4 = false;
        while (bl3 = object.hasNext()) {
            Object object2 = object.next();
            bl3 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (bl3 != bl2) continue;
            object.remove();
            bl4 = true;
        }
        return bl4;
    }

    private static final boolean u0(List list, l l10, boolean bl2) {
        int n10;
        int n11;
        int n12 = list instanceof RandomAccess;
        if (n12 == 0) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return y.t0(t0.c(list), l10, bl2);
        }
        n12 = CollectionsKt__CollectionsKt.G(list);
        if (n12 >= 0) {
            int n13 = 0;
            n11 = 0;
            while (true) {
                Object e10;
                Boolean bl3;
                boolean bl4;
                if ((bl4 = (bl3 = (Boolean)l10.invoke(e10 = list.get(n13))).booleanValue()) != bl2) {
                    if (n11 != n13) {
                        list.set(n11, e10);
                    }
                    ++n11;
                }
                if (n13 != n12) {
                    ++n13;
                    continue;
                }
                break;
            }
        } else {
            n11 = 0;
        }
        if (n11 < (n10 = list.size())) {
            n10 = CollectionsKt__CollectionsKt.G(list);
            if (n10 >= n11) {
                while (true) {
                    list.remove(n10);
                    if (n10 == n11) break;
                    n10 += -1;
                }
            }
            return true;
        }
        return false;
    }

    private static final void v0(Collection collection, Iterable iterable) {
        f0.p(collection, "$this$minusAssign");
        y.G0(collection, iterable);
    }

    private static final void w0(Collection collection, Object object) {
        f0.p(collection, "$this$minusAssign");
        collection.remove(object);
    }

    private static final void x0(Collection collection, m m10) {
        f0.p(collection, "$this$minusAssign");
        y.I0(collection, m10);
    }

    private static final void y0(Collection collection, Object[] objectArray) {
        f0.p(collection, "$this$minusAssign");
        y.J0(collection, objectArray);
    }

    private static final void z0(Collection collection, Iterable iterable) {
        f0.p(collection, "$this$plusAssign");
        y.q0(collection, iterable);
    }
}

