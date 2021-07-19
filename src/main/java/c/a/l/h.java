/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class h {
    private final Map a;

    private h(int n10) {
        LinkedHashMap linkedHashMap = b.d(n10);
        this.a = linkedHashMap;
    }

    public static h b(int n10) {
        h h10 = new h(n10);
        return h10;
    }

    public Map a() {
        Map map = this.a;
        int n10 = map.size();
        if (n10 != 0) {
            return Collections.unmodifiableMap(this.a);
        }
        return Collections.emptyMap();
    }

    public h c(Object object, Object object2) {
        this.a.put(object, object2);
        return this;
    }
}

