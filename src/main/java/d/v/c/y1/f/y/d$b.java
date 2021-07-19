/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.y;

import d.v.c.y1.f.y.d;
import java.util.HashMap;

public class d$b {
    private final HashMap a;

    public d$b(d object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = d.a((d)object);
        hashMap.putAll(object);
    }

    public d$b(boolean bl2) {
        HashMap<String, Boolean> hashMap;
        this.a = hashMap = new HashMap<String, Boolean>();
        Boolean bl3 = bl2;
        hashMap.put("isMusic", bl3);
    }

    public d a() {
        HashMap hashMap = this.a;
        d d10 = new d(hashMap, null);
        return d10;
    }

    public boolean b() {
        return (Boolean)this.a.get("isMusic");
    }

    public d$b c(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("isMusic", bl3);
        return this;
    }
}

