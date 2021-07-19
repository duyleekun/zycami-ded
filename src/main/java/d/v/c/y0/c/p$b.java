/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import d.v.c.y0.c.p;
import java.util.HashMap;

public class p$b {
    private final HashMap a;

    public p$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public p$b(p object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = p.a((p)object);
        hashMap.putAll(object);
    }

    public p a() {
        HashMap hashMap = this.a;
        p p10 = new p(hashMap, null);
        return p10;
    }

    public boolean b() {
        return (Boolean)this.a.get("showNoReminders");
    }

    public p$b c(boolean bl2) {
        HashMap hashMap = this.a;
        Boolean bl3 = bl2;
        hashMap.put("showNoReminders", bl3);
        return this;
    }
}

