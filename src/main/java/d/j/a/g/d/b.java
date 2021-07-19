/*
 * Decompiled with CFR 0.151.
 */
package d.j.a.g.d;

import d.j.a.c;
import d.j.a.d;
import d.j.a.g.d.b$a;
import d.j.a.g.d.b$b;
import d.j.a.g.e.b.a;
import java.util.HashMap;
import java.util.Map;

public class b {
    private Map a;

    public b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public void a(c c10) {
        Class<a> clazz = a.class;
        if (c10 == null) {
            this.a.remove(clazz);
            return;
        }
        b$b b$b = new b$b(this, c10);
        this.a.put(clazz, b$b);
    }

    public void b(d d10) {
        Class<d.j.a.g.e.b.b> clazz = d.j.a.g.e.b.b.class;
        if (d10 == null) {
            this.a.remove(clazz);
            return;
        }
        b$a b$a = new b$a(this, d10);
        this.a.put(clazz, b$a);
    }

    public boolean c(Class object) {
        boolean bl2;
        Map map = this.a;
        boolean bl3 = map.containsKey(object);
        if (bl3 && (object = this.d((Class)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object d(Class clazz) {
        return this.a.get(clazz);
    }
}

