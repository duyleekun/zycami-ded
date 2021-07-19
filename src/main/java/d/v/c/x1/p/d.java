/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1.p;

import d.v.c.x1.p.c;
import java.util.List;
import java.util.Map;

public class d {
    private Map a;
    private List b;

    public d() {
        Cloneable cloneable;
        this.a = cloneable = new Cloneable();
        this.b = cloneable;
    }

    public Map a() {
        return this.a;
    }

    public Object b(int n10) {
        List list;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (list = this.b).size())) {
            return this.b.get(n10);
        }
        return null;
    }

    public Object c(int n10) {
        Object object = this.b(n10);
        if (object == null) {
            return null;
        }
        return this.d(object);
    }

    public Object d(Object object) {
        if (object == null) {
            return null;
        }
        Map map = this.a;
        if ((object = (c)map.get(object)) == null) {
            return null;
        }
        return ((c)object).a();
    }

    public void e(Object object, Object object2) {
        if (object == null) {
            return;
        }
        c c10 = new c();
        c10.b(object2);
        this.a.put(object, c10);
        this.b.add(object);
    }
}

