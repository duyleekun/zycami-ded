/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import f.x1.r0;
import f.x1.s0;
import f.x1.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.EmptyMap;

public class t0
extends s0 {
    public static final Map A(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$filter");
        f0.p(l10, "predicate");
        LinkedHashMap<Boolean, Map.Entry> linkedHashMap = new LinkedHashMap<Boolean, Map.Entry>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Boolean bl3 = (Boolean)l10.invoke(entry);
            boolean bl4 = bl3;
            if (!bl4) continue;
            bl3 = entry.getKey();
            entry = entry.getValue();
            linkedHashMap.put(bl3, entry);
        }
        return linkedHashMap;
    }

    private static final void A0(Map map, Object object, Object object2) {
        f0.p(map, "$this$set");
        map.put(object, object2);
    }

    public static final Map B(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterKeys");
        f0.p(l10, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object object2 = entry.getKey();
            boolean bl3 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl3) continue;
            object2 = entry.getKey();
            entry = entry.getValue();
            linkedHashMap.put(object2, entry);
        }
        return linkedHashMap;
    }

    public static final Map B0(Iterable object) {
        Object object2 = "$this$toMap";
        f0.p(object, (String)object2);
        int n10 = object instanceof Collection;
        if (n10 != 0) {
            object2 = object;
            object2 = (Collection)object;
            int n11 = object2.size();
            if (n11 != 0) {
                int n12 = 1;
                if (n11 != n12) {
                    n10 = s0.j(object2.size());
                    LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
                    object = t0.C0((Iterable)object, linkedHashMap);
                } else {
                    n10 = object instanceof List;
                    if (n10 != 0) {
                        object = (List)object;
                        n10 = 0;
                        object2 = null;
                        object = object.get(0);
                    } else {
                        object = ((Iterable)object).iterator().next();
                    }
                    object = s0.k((Pair)object);
                }
            } else {
                object = t0.z();
            }
            return object;
        }
        object2 = new LinkedHashMap();
        return t0.k0(t0.C0((Iterable)object, (Map)object2));
    }

    public static final Map C(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterNot");
        f0.p(l10, "predicate");
        LinkedHashMap<Boolean, Map.Entry> linkedHashMap = new LinkedHashMap<Boolean, Map.Entry>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Boolean bl3 = (Boolean)l10.invoke(entry);
            boolean bl4 = bl3;
            if (bl4) continue;
            bl3 = entry.getKey();
            entry = entry.getValue();
            linkedHashMap.put(bl3, entry);
        }
        return linkedHashMap;
    }

    public static final Map C0(Iterable iterable, Map map) {
        f0.p(iterable, "$this$toMap");
        f0.p(map, "destination");
        t0.w0(map, iterable);
        return map;
    }

    public static final Map D(Map object, Map map, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterNotTo");
        f0.p(map, "destination");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            Boolean bl3 = (Boolean)l10.invoke(object2);
            boolean bl4 = bl3;
            if (bl4) continue;
            bl3 = object2.getKey();
            object2 = object2.getValue();
            map.put(bl3, object2);
        }
        return map;
    }

    public static final Map D0(Map map) {
        int n10;
        String string2 = "$this$toMap";
        f0.p(map, string2);
        int n11 = map.size();
        map = n11 != 0 ? (n11 != (n10 = 1) ? t0.J0(map) : s0.o(map)) : t0.z();
        return map;
    }

    public static final Map E(Map object, Map map, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterTo");
        f0.p(map, "destination");
        Object object2 = "predicate";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            Boolean bl3 = (Boolean)l10.invoke(object2);
            boolean bl4 = bl3;
            if (!bl4) continue;
            bl3 = object2.getKey();
            object2 = object2.getValue();
            map.put(bl3, object2);
        }
        return map;
    }

    public static final Map E0(Map map, Map map2) {
        f0.p(map, "$this$toMap");
        f0.p(map2, "destination");
        map2.putAll(map);
        return map2;
    }

    public static final Map F(Map object, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterValues");
        f0.p(l10, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object object2 = entry.getValue();
            boolean bl3 = (Boolean)(object2 = (Boolean)l10.invoke(object2));
            if (!bl3) continue;
            object2 = entry.getKey();
            entry = entry.getValue();
            linkedHashMap.put(object2, entry);
        }
        return linkedHashMap;
    }

    public static final Map F0(m m10) {
        f0.p(m10, "$this$toMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return t0.k0(t0.G0(m10, linkedHashMap));
    }

    private static final Object G(Map map, Object object) {
        f0.p(map, "$this$get");
        return map.get(object);
    }

    public static final Map G0(m m10, Map map) {
        f0.p(m10, "$this$toMap");
        f0.p(map, "destination");
        t0.x0(map, m10);
        return map;
    }

    private static final Object H(Map object, Object object2, a a10) {
        if ((object = object.get(object2)) == null) {
            object = a10.invoke();
        }
        return object;
    }

    public static final Map H0(Pair[] object) {
        LinkedHashMap linkedHashMap = "$this$toMap";
        f0.p(object, (String)((Object)linkedHashMap));
        int n10 = ((Pair[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((Pair[])object).length);
                linkedHashMap = new LinkedHashMap(n11);
                object = t0.I0(object, linkedHashMap);
            } else {
                n10 = 0;
                linkedHashMap = null;
                object = s0.k(object[0]);
            }
        } else {
            object = t0.z();
        }
        return object;
    }

    public static final Object I(Map map, Object object, a a10) {
        boolean bl2;
        f0.p(map, "$this$getOrElseNullable");
        f0.p(a10, "defaultValue");
        Object v10 = map.get(object);
        if (v10 == null && !(bl2 = map.containsKey(object))) {
            return a10.invoke();
        }
        return v10;
    }

    public static final Map I0(Pair[] pairArray, Map map) {
        f0.p(pairArray, "$this$toMap");
        f0.p(map, "destination");
        t0.y0(map, pairArray);
        return map;
    }

    public static final Object J(Map map, Object object, a a10) {
        f0.p(map, "$this$getOrPut");
        f0.p(a10, "defaultValue");
        Object object2 = map.get(object);
        if (object2 == null) {
            object2 = a10.invoke();
            map.put(object, object2);
        }
        return object2;
    }

    public static final Map J0(Map map) {
        f0.p(map, "$this$toMutableMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        return linkedHashMap;
    }

    public static final Object K(Map map, Object object) {
        f0.p(map, "$this$getValue");
        return r0.a(map, object);
    }

    private static final Pair K0(Map.Entry entry) {
        Object k10 = entry.getKey();
        entry = entry.getValue();
        Pair pair = new Pair(k10, entry);
        return pair;
    }

    private static final HashMap L() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }

    public static final HashMap M(Pair ... pairArray) {
        f0.p(pairArray, "pairs");
        int n10 = s0.j(pairArray.length);
        HashMap hashMap = new HashMap(n10);
        t0.y0(hashMap, pairArray);
        return hashMap;
    }

    private static final Object N(Map object, a a10) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = a10.invoke();
        }
        return object;
    }

    private static final boolean O(Map map) {
        return map.isEmpty() ^ true;
    }

    private static final boolean P(Map map) {
        boolean bl2;
        if (map != null && !(bl2 = map.isEmpty())) {
            bl2 = false;
            map = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static final Iterator Q(Map map) {
        f0.p(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    private static final LinkedHashMap R() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return linkedHashMap;
    }

    public static final LinkedHashMap S(Pair ... pairArray) {
        f0.p(pairArray, "pairs");
        int n10 = s0.j(pairArray.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        return (LinkedHashMap)t0.I0(pairArray, linkedHashMap);
    }

    public static final Map T(Map object, l l10) {
        f0.p(object, "$this$mapKeys");
        f0.p(l10, "transform");
        int n10 = s0.j(object.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = object.next();
            Object object3 = l10.invoke(object2);
            object2 = ((Map.Entry)object2).getValue();
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Map U(Map object, Map map, l l10) {
        boolean bl2;
        f0.p(object, "$this$mapKeysTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            Object object2 = l10.invoke(string2);
            string2 = ((Map.Entry)((Object)string2)).getValue();
            map.put(object2, string2);
        }
        return map;
    }

    private static final Map V() {
        return t0.z();
    }

    public static final Map W(Pair ... object) {
        LinkedHashMap linkedHashMap = "pairs";
        f0.p(object, (String)((Object)linkedHashMap));
        int n10 = ((Pair[])object).length;
        if (n10 > 0) {
            int n11 = s0.j(((Pair[])object).length);
            linkedHashMap = new LinkedHashMap(n11);
            object = t0.I0(object, linkedHashMap);
        } else {
            object = t0.z();
        }
        return object;
    }

    public static final Map X(Map object, l l10) {
        f0.p(object, "$this$mapValues");
        f0.p(l10, "transform");
        int n10 = s0.j(object.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2;
            Object object3 = object2 = object.next();
            object3 = ((Map.Entry)object2).getKey();
            object2 = l10.invoke(object2);
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Map Y(Map object, Map map, l l10) {
        boolean bl2;
        f0.p(object, "$this$mapValuesTo");
        f0.p(map, "destination");
        Object object2 = "transform";
        f0.p(l10, (String)object2);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            String string2 = object2;
            string2 = ((Map.Entry)object2).getKey();
            object2 = l10.invoke(object2);
            map.put(string2, object2);
        }
        return map;
    }

    public static final Map Z(Map map, Iterable iterable) {
        f0.p(map, "$this$minus");
        f0.p(iterable, "keys");
        map = t0.J0(map);
        y.G0(map.keySet(), iterable);
        return t0.k0(map);
    }

    public static final Map a0(Map map, Object object) {
        f0.p(map, "$this$minus");
        map = t0.J0(map);
        map.remove(object);
        return t0.k0(map);
    }

    public static final Map b0(Map map, m m10) {
        f0.p(map, "$this$minus");
        f0.p(m10, "keys");
        map = t0.J0(map);
        y.I0(map.keySet(), m10);
        return t0.k0(map);
    }

    public static final Map c0(Map map, Object[] objectArray) {
        f0.p(map, "$this$minus");
        f0.p(objectArray, "keys");
        map = t0.J0(map);
        y.J0(map.keySet(), objectArray);
        return t0.k0(map);
    }

    private static final void d0(Map map, Iterable iterable) {
        f0.p(map, "$this$minusAssign");
        y.G0(map.keySet(), iterable);
    }

    private static final void e0(Map map, Object object) {
        f0.p(map, "$this$minusAssign");
        map.remove(object);
    }

    private static final void f0(Map map, m m10) {
        f0.p(map, "$this$minusAssign");
        y.I0(map.keySet(), m10);
    }

    private static final void g0(Map map, Object[] objectArray) {
        f0.p(map, "$this$minusAssign");
        y.J0(map.keySet(), objectArray);
    }

    private static final Iterator h0(Map map) {
        f0.p(map, "$this$iterator");
        return map.entrySet().iterator();
    }

    private static final Map i0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return linkedHashMap;
    }

    public static final Map j0(Pair ... pairArray) {
        f0.p(pairArray, "pairs");
        int n10 = s0.j(pairArray.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        t0.y0(linkedHashMap, pairArray);
        return linkedHashMap;
    }

    public static final Map k0(Map map) {
        String string2 = "$this$optimizeReadOnlyMap";
        f0.p(map, string2);
        int n10 = map.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                map = s0.o(map);
            }
        } else {
            map = t0.z();
        }
        return map;
    }

    private static final Map l0(Map map) {
        if (map == null) {
            map = t0.z();
        }
        return map;
    }

    public static final Map m0(Map linkedHashMap, Iterable iterable) {
        f0.p(linkedHashMap, "$this$plus");
        LinkedHashMap linkedHashMap2 = "pairs";
        f0.p(iterable, (String)((Object)linkedHashMap2));
        boolean bl2 = linkedHashMap.isEmpty();
        if (bl2) {
            linkedHashMap = t0.B0(iterable);
        } else {
            linkedHashMap2 = new LinkedHashMap(linkedHashMap);
            t0.w0(linkedHashMap2, iterable);
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public static final Map n0(Map map, Map map2) {
        f0.p(map, "$this$plus");
        f0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final Map o0(Map linkedHashMap, Pair object) {
        f0.p(linkedHashMap, "$this$plus");
        LinkedHashMap linkedHashMap2 = "pair";
        f0.p(object, (String)((Object)linkedHashMap2));
        boolean bl2 = linkedHashMap.isEmpty();
        if (bl2) {
            linkedHashMap = s0.k((Pair)object);
        } else {
            linkedHashMap2 = new LinkedHashMap(linkedHashMap);
            linkedHashMap = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap2.put(linkedHashMap, object);
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public static final Map p0(Map map, m m10) {
        f0.p(map, "$this$plus");
        f0.p(m10, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        t0.x0(linkedHashMap, m10);
        return t0.k0(linkedHashMap);
    }

    public static final Map q0(Map linkedHashMap, Pair[] pairArray) {
        f0.p(linkedHashMap, "$this$plus");
        LinkedHashMap linkedHashMap2 = "pairs";
        f0.p(pairArray, (String)((Object)linkedHashMap2));
        boolean bl2 = linkedHashMap.isEmpty();
        if (bl2) {
            linkedHashMap = t0.H0(pairArray);
        } else {
            linkedHashMap2 = new LinkedHashMap(linkedHashMap);
            t0.y0(linkedHashMap2, pairArray);
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    private static final void r0(Map map, Iterable iterable) {
        f0.p(map, "$this$plusAssign");
        t0.w0(map, iterable);
    }

    private static final Map s(int n10, l l10) {
        Map map = s0.h(n10);
        l10.invoke(map);
        return s0.d(map);
    }

    private static final void s0(Map map, Map map2) {
        f0.p(map, "$this$plusAssign");
        map.putAll(map2);
    }

    private static final Map t(l l10) {
        Map map = s0.g();
        l10.invoke(map);
        return s0.d(map);
    }

    private static final void t0(Map map, Pair object) {
        f0.p(map, "$this$plusAssign");
        Object object2 = ((Pair)object).getFirst();
        object = ((Pair)object).getSecond();
        map.put(object2, object);
    }

    private static final Object u(Map.Entry entry) {
        f0.p(entry, "$this$component1");
        return entry.getKey();
    }

    private static final void u0(Map map, m m10) {
        f0.p(map, "$this$plusAssign");
        t0.x0(map, m10);
    }

    private static final Object v(Map.Entry entry) {
        f0.p(entry, "$this$component2");
        return entry.getValue();
    }

    private static final void v0(Map map, Pair[] pairArray) {
        f0.p(map, "$this$plusAssign");
        t0.y0(map, pairArray);
    }

    private static final boolean w(Map map, Object object) {
        f0.p(map, "$this$contains");
        return map.containsKey(object);
    }

    public static final void w0(Map map, Iterable object) {
        boolean bl2;
        f0.p(map, "$this$putAll");
        Object object2 = "pairs";
        f0.p(object, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Pair)object.next();
            Object object3 = ((Pair)object2).component1();
            object2 = ((Pair)object2).component2();
            map.put(object3, object2);
        }
    }

    private static final boolean x(Map map, Object object) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(object);
    }

    public static final void x0(Map map, m object) {
        boolean bl2;
        f0.p(map, "$this$putAll");
        Object object2 = "pairs";
        f0.p(object, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Pair)object.next();
            Object object3 = ((Pair)object2).component1();
            object2 = ((Pair)object2).component2();
            map.put(object3, object2);
        }
    }

    private static final boolean y(Map map, Object object) {
        return map.containsValue(object);
    }

    public static final void y0(Map map, Pair[] pairArray) {
        f0.p(map, "$this$putAll");
        String string2 = "pairs";
        f0.p(pairArray, string2);
        for (Pair pair : pairArray) {
            Object object = pair.component1();
            Object object2 = pair.component2();
            map.put(object, object2);
        }
    }

    public static final Map z() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Objects.requireNonNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return emptyMap;
    }

    private static final Object z0(Map map, Object object) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        return f.h2.t.t0.k(map).remove(object);
    }
}

