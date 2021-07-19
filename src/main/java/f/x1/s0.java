/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.x1.o1.c;
import f.x1.r0;
import f.x1.t0;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;

public class s0
extends r0 {
    private static final int a = 0x40000000;

    public static final Map d(Map map) {
        f0.p(map, "builder");
        return ((c)map).o();
    }

    private static final Map e(int n10, l l10) {
        Map map = s0.h(n10);
        l10.invoke(map);
        return s0.d(map);
    }

    private static final Map f(l l10) {
        Map map = s0.g();
        l10.invoke(map);
        return s0.d(map);
    }

    public static final Map g() {
        c c10 = new c();
        return c10;
    }

    public static final Map h(int n10) {
        c c10 = new c(n10);
        return c10;
    }

    public static final Object i(ConcurrentMap object, Object object2, a object3) {
        f0.p(object, "$this$getOrPut");
        f0.p(object3, "defaultValue");
        Object object4 = object.get(object2);
        if (object4 == null) {
            object4 = (object = object.putIfAbsent(object2, object3 = object3.invoke())) != null ? object : object3;
        }
        return object4;
    }

    public static final int j(int n10) {
        if (n10 >= 0) {
            int n11 = 3;
            float f10 = 4.2E-45f;
            if (n10 < n11) {
                ++n10;
            } else {
                n11 = 0x40000000;
                f10 = 2.0f;
                if (n10 < n11) {
                    float f11 = (float)n10 / 0.75f;
                    n11 = 1065353216;
                    f10 = 1.0f;
                    n10 = (int)(f11 += f10);
                } else {
                    n10 = -1 >>> 1;
                    float f12 = 0.0f / 0.0f;
                }
            }
        }
        return n10;
    }

    public static final Map k(Pair map) {
        f0.p(map, "pair");
        Object object = ((Pair)((Object)map)).getFirst();
        map = ((Pair)((Object)map)).getSecond();
        map = Collections.singletonMap(object, map);
        f0.o(map, "java.util.Collections.si\u2026(pair.first, pair.second)");
        return map;
    }

    public static final SortedMap l(Comparator comparator, Pair ... pairArray) {
        f0.p(comparator, "comparator");
        f0.p(pairArray, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        t0.y0(treeMap, pairArray);
        return treeMap;
    }

    public static final SortedMap m(Pair ... pairArray) {
        f0.p(pairArray, "pairs");
        TreeMap treeMap = new TreeMap();
        t0.y0(treeMap, pairArray);
        return treeMap;
    }

    private static final Properties n(Map map) {
        Properties properties = new Properties();
        properties.putAll((Map<?, ?>)map);
        return properties;
    }

    public static final Map o(Map map) {
        f0.p(map, "$this$toSingletonMap");
        map = map.entrySet().iterator().next();
        Object k10 = map.getKey();
        map = map.getValue();
        map = Collections.singletonMap(k10, map);
        f0.o(map, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return map;
    }

    private static final Map p(Map map) {
        return s0.o(map);
    }

    public static final SortedMap q(Map map) {
        f0.p(map, "$this$toSortedMap");
        TreeMap treeMap = new TreeMap(map);
        return treeMap;
    }

    public static final SortedMap r(Map map, Comparator comparator) {
        f0.p(map, "$this$toSortedMap");
        f0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}

