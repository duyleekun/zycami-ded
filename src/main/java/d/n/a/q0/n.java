/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0;

import c.b.a.c;
import d.n.a.j0;
import d.n.a.q0.b;
import d.n.a.q0.b$a;
import java.util.Map;

public class n {
    private final Map a;
    private final c b;

    public n(d.n.a.q0.r.b b10, c c10) {
        this.a = b10;
        this.b = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public j0 a(String object) {
        Object object2 = (b)this.a.get(object);
        if (object2 != null) {
            return object2.a();
        }
        object2 = this.a;
        synchronized (object2) {
            Object object3 = this.a;
            object3 = object3.get(object);
            object3 = (b)object3;
            if (object3 != null) {
                return object3.a();
            }
            object3 = this.b;
            object3 = object3.get();
            object3 = (b$a)object3;
            object3 = object3.a((String)object);
            object3 = object3.build();
            j0 j02 = object3.a();
            Map map = this.a;
            map.put(object, object3);
            return j02;
        }
    }
}

