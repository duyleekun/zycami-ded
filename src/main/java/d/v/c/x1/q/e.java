/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1.q;

import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.v.c.x1.q.b;
import d.v.c.x1.q.c;
import d.v.c.x1.q.d;
import d.v.v.o.b.a;
import java.util.HashMap;
import java.util.Map;

public class e
implements o {
    public Map a;

    public e() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private a d(String string2) {
        a a10 = (a)this.a.get(string2);
        if (a10 == null) {
            a10 = new a(string2);
            Map map = this.a;
            map.put(string2, a10);
        }
        return a10;
    }

    public void a() {
        Object[] objectArray = new Object[1];
        Long l10 = Thread.currentThread().getId();
        objectArray[0] = l10;
        m.a.a.b("teardown, thread:%s", objectArray);
    }

    public b b(c c10) {
        b b10 = new b(c10);
        return b10;
    }

    public n c(r object) {
        object = new d(this);
        return object;
    }
}

