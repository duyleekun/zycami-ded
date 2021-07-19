/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.c;

import d.v.c.v0.l.i;
import java.util.HashMap;
import java.util.Map;
import k.d;

public class a {
    private static volatile a a;

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object = a;
        if (object != null) return a;
        object = a.class;
        synchronized (object) {
            a a10 = a;
            if (a10 != null) return a;
            a = a10 = new a();
            return a;
        }
    }

    public d b(int n10, int n11) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = String.valueOf(n10);
        hashMap.put("page", string2);
        string2 = String.valueOf(n11);
        hashMap.put("pageSize", string2);
        return this.c(hashMap);
    }

    public d c(Map map) {
        return i.a.j(map);
    }

    public d d() {
        return i.a.i();
    }
}

