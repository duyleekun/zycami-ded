/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.k.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private final Map a;
    private final Map b;

    public p() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        this.b = hashMap = new HashMap();
    }

    private Map c(boolean bl2) {
        Map map = bl2 ? this.b : this.a;
        return map;
    }

    public j a(c c10, boolean bl2) {
        return (j)this.c(bl2).get(c10);
    }

    public Map b() {
        return Collections.unmodifiableMap(this.a);
    }

    public void d(c c10, j j10) {
        boolean bl2 = j10.q();
        this.c(bl2).put(c10, j10);
    }

    public void e(c c10, j j10) {
        boolean bl2 = j10.q();
        Map map = this.c(bl2);
        Object v10 = map.get(c10);
        boolean bl3 = j10.equals(v10);
        if (bl3) {
            map.remove(c10);
        }
    }
}

