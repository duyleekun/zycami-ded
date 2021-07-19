/*
 * Decompiled with CFR 0.151.
 */
package f.x1.p1;

import f.h2.t.t0;
import java.util.Map;
import java.util.Objects;

public final class a {
    private static final Object a(Map map, Object object, Object object2) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return map.getOrDefault(object, object2);
    }

    private static final boolean b(Map map, Object object, Object object2) {
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        return t0.k(map).remove(object, object2);
    }
}

