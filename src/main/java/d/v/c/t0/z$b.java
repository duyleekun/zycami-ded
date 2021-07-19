/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import d.v.c.t0.z;
import java.util.HashMap;

public class z$b {
    private final HashMap a;

    public z$b(z object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = z.a((z)object);
        hashMap.putAll(object);
    }

    public z$b(String object) {
        HashMap<String, Object> hashMap;
        this.a = hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put("FileUrl", object);
            return;
        }
        object = new IllegalArgumentException("Argument \"FileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public z a() {
        HashMap hashMap = this.a;
        z z10 = new z(hashMap, null);
        return z10;
    }

    public String b() {
        return (String)this.a.get("FileUrl");
    }

    public z$b c(String object) {
        if (object != null) {
            this.a.put("FileUrl", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"FileUrl\" is marked as non-null but was passed a null value.");
        throw object;
    }
}

