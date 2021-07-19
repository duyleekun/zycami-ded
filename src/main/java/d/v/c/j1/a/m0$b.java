/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import com.zhiyun.cama.data.database.model.Feedback;
import d.v.c.j1.a.m0;
import java.util.HashMap;

public class m0$b {
    private final HashMap a;

    public m0$b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public m0$b(m0 object) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        object = m0.a((m0)object);
        hashMap.putAll(object);
    }

    public m0 a() {
        HashMap hashMap = this.a;
        m0 m02 = new m0(hashMap, null);
        return m02;
    }

    public Feedback b() {
        return (Feedback)this.a.get("feedback");
    }

    public m0$b c(Feedback feedback) {
        this.a.put("feedback", feedback);
        return this;
    }
}

