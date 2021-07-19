/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import c.a.l.e;
import c.a.l.g;
import c.a.l.i$a;
import c.a.l.i$b;
import c.b.a.c;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class i
implements e {
    private static final c b = g.a(Collections.emptyMap());
    private final Map a;

    private i(Map map) {
        this.a = map = Collections.unmodifiableMap(map);
    }

    public /* synthetic */ i(Map map, i$a i$a) {
        this(map);
    }

    public static i$b a(int n10) {
        i$b i$b = new i$b(n10, null);
        return i$b;
    }

    public static c b() {
        return b;
    }

    public Map c() {
        boolean bl2;
        int n10 = this.a.size();
        LinkedHashMap linkedHashMap = c.a.l.b.d(n10);
        Iterator iterator2 = this.a.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Object k10 = object.getKey();
            object = ((c)object.getValue()).get();
            linkedHashMap.put(k10, object);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}

