/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import d.v.c.k1.a.q;
import java.util.HashMap;

public class q$b {
    private final HashMap a;

    public q$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public q$b(q object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = q.a((q)object);
        hashMap.putAll(object);
    }

    public q a() {
        HashMap hashMap = this.a;
        q q10 = new q(hashMap, null);
        return q10;
    }

    public String b() {
        return (String)this.a.get("add_video_type");
    }

    public int c() {
        return (Integer)this.a.get("max_count_selected");
    }

    public q$b d(String object) {
        if (object != null) {
            this.a.put("add_video_type", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"add_video_type\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public q$b e(int n10) {
        HashMap hashMap = this.a;
        Integer n11 = n10;
        hashMap.put("max_count_selected", n11);
        return this;
    }
}

