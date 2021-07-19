/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.t0;
import f.x1.e0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Ref$IntRef;

public class g0 {
    public static final Map a(e0 object) {
        int n10;
        Object object2;
        boolean bl2;
        f0.p(object, "$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object object3 = object.b();
        while (bl2 = object3.hasNext()) {
            int n11;
            object2 = object3.next();
            object2 = object.a(object2);
            Object object4 = linkedHashMap.get(object2);
            int n12 = 1;
            n11 = object4 == null && (n11 = linkedHashMap.containsKey(object2)) == 0 ? n12 : 0;
            if (n11 != 0) {
                object4 = new Object();
            }
            object4 = (Ref$IntRef)object4;
            ((Ref$IntRef)object4).element = n11 = ((Ref$IntRef)object4).element + n12;
            linkedHashMap.put(object2, object4);
        }
        object = linkedHashMap.entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            object3 = (Map.Entry)object.next();
            Objects.requireNonNull(object3, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            object2 = t0.m(object3);
            n10 = ((Ref$IntRef)object3.getValue()).element;
            object3 = n10;
            object2.setValue((Object)object3);
        }
        return t0.k(linkedHashMap);
    }

    private static final Map b(Map map, l l10) {
        boolean bl2;
        Iterator iterator2 = map.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Map.Entry)iterator2.next();
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            Map.Entry entry = t0.m(object);
            object = l10.invoke(object);
            entry.setValue(object);
        }
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
        return t0.k(map);
    }
}

