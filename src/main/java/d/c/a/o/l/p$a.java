/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.p$a$a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p$a {
    private final Map a;

    public p$a() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public void a() {
        this.a.clear();
    }

    public List b(Class object) {
        Map map = this.a;
        object = (object = (p$a$a)map.get(object)) == null ? null : ((p$a$a)object).a;
        return object;
    }

    public void c(Class object, List object2) {
        Object object3 = this.a;
        p$a$a p$a$a = new p$a$a((List)object2);
        if ((object2 = object3.put(object, p$a$a)) == null) {
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Already cached loaders for model: ");
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }
}

