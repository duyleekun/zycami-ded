/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.c;

import d.v.c.v0.l.i;
import d.v.c.v0.y.c.a$a;
import java.util.HashMap;
import java.util.Map;
import k.d;

public class a {
    public static a a() {
        return a$a.a();
    }

    public d b(int n10, int n11) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = String.valueOf(n10);
        hashMap.put("page", string2);
        string2 = String.valueOf(n11);
        hashMap.put("pageSize", string2);
        return this.d(hashMap);
    }

    public d c(int n10, int n11, int n12) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (n12 < 0) {
            String string2 = String.valueOf(n12);
            String string3 = "localId";
            hashMap.put(string3, string2);
        } else {
            String string4 = String.valueOf(n12);
            String string5 = "typeId";
            hashMap.put(string5, string4);
        }
        String string6 = String.valueOf(n10);
        hashMap.put("page", string6);
        string6 = String.valueOf(n11);
        hashMap.put("pageSize", string6);
        return this.d(hashMap);
    }

    public d d(Map map) {
        return i.a.k(map);
    }

    public d e() {
        return i.a.d();
    }
}

