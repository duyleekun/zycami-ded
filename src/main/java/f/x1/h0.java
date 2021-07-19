/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.p;
import f.h2.s.q;
import f.h2.s.r;
import f.h2.t.f0;
import f.x1.e0;
import f.x1.g0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class h0
extends g0 {
    public static final Map c(e0 e02, r r10) {
        boolean bl2;
        f0.p(e02, "$this$aggregate");
        f0.p(r10, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            Boolean bl3;
            boolean bl4;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object v10 = linkedHashMap.get(object2);
            if (v10 == null && !(bl4 = linkedHashMap.containsKey(object2))) {
                bl4 = true;
            } else {
                bl4 = false;
                bl3 = null;
            }
            bl3 = bl4;
            object = r10.invoke(object2, v10, object, bl3);
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map d(e0 e02, Map map, r r10) {
        boolean bl2;
        f0.p(e02, "$this$aggregateTo");
        f0.p(map, "destination");
        f0.p(r10, "operation");
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            Boolean bl3;
            boolean bl4;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object v10 = map.get(object2);
            if (v10 == null && !(bl4 = map.containsKey(object2))) {
                bl4 = true;
            } else {
                bl4 = false;
                bl3 = null;
            }
            bl3 = bl4;
            object = r10.invoke(object2, v10, object, bl3);
            map.put(object2, object);
        }
        return map;
    }

    public static final Map e(e0 e02, Map map) {
        boolean bl2;
        f0.p(e02, "$this$eachCountTo");
        f0.p(map, "destination");
        Integer n10 = 0;
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            int n11;
            Object object = iterator2.next();
            object = e02.a(object);
            Object object2 = map.get(object);
            int n12 = 1;
            n11 = object2 == null && (n11 = map.containsKey(object)) == 0 ? n12 : 0;
            if (n11 != 0) {
                object2 = n10;
            }
            int n13 = ((Number)object2).intValue() + n12;
            object2 = n13;
            map.put(object, object2);
        }
        return map;
    }

    public static final Map f(e0 e02, Object object, p p10) {
        boolean bl2;
        f0.p(e02, "$this$fold");
        f0.p(p10, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object2 = iterator2.next();
            Object object3 = e02.a(object2);
            Object object4 = linkedHashMap.get(object3);
            bl3 = object4 == null && !(bl3 = linkedHashMap.containsKey(object3));
            if (bl3) {
                object4 = object;
            }
            object2 = p10.invoke(object4, object2);
            linkedHashMap.put(object3, object2);
        }
        return linkedHashMap;
    }

    public static final Map g(e0 e02, p p10, q q10) {
        boolean bl2;
        f0.p(e02, "$this$fold");
        f0.p(p10, "initialValueSelector");
        f0.p(q10, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object object3 = linkedHashMap.get(object2);
            bl3 = object3 == null && !(bl3 = linkedHashMap.containsKey(object2));
            if (bl3) {
                object3 = p10.invoke(object2, object);
            }
            object = q10.invoke(object2, object3, object);
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map h(e0 e02, Map map, Object object, p p10) {
        boolean bl2;
        f0.p(e02, "$this$foldTo");
        f0.p(map, "destination");
        f0.p(p10, "operation");
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object2 = iterator2.next();
            Object object3 = e02.a(object2);
            Object object4 = map.get(object3);
            bl3 = object4 == null && !(bl3 = map.containsKey(object3));
            if (bl3) {
                object4 = object;
            }
            object2 = p10.invoke(object4, object2);
            map.put(object3, object2);
        }
        return map;
    }

    public static final Map i(e0 e02, Map map, p p10, q q10) {
        boolean bl2;
        f0.p(e02, "$this$foldTo");
        f0.p(map, "destination");
        f0.p(p10, "initialValueSelector");
        f0.p(q10, "operation");
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object object3 = map.get(object2);
            bl3 = object3 == null && !(bl3 = map.containsKey(object2));
            if (bl3) {
                object3 = p10.invoke(object2, object);
            }
            object = q10.invoke(object2, object3, object);
            map.put(object2, object);
        }
        return map;
    }

    public static final Map j(e0 e02, q q10) {
        boolean bl2;
        f0.p(e02, "$this$reduce");
        f0.p(q10, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object v10 = linkedHashMap.get(object2);
            bl3 = v10 == null && !(bl3 = linkedHashMap.containsKey(object2));
            if (!bl3) {
                object = q10.invoke(object2, v10, object);
            }
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map k(e0 e02, Map map, q q10) {
        boolean bl2;
        f0.p(e02, "$this$reduceTo");
        f0.p(map, "destination");
        f0.p(q10, "operation");
        Iterator iterator2 = e02.b();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = iterator2.next();
            Object object2 = e02.a(object);
            Object v10 = map.get(object2);
            bl3 = v10 == null && !(bl3 = map.containsKey(object2));
            if (!bl3) {
                object = q10.invoke(object2, v10, object);
            }
            map.put(object2, object);
        }
        return map;
    }
}

