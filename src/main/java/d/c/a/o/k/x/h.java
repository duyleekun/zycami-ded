/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.x;

import d.c.a.o.k.x.h$a;
import d.c.a.o.k.x.m;
import java.util.HashMap;
import java.util.Map;

public class h {
    private final h$a a;
    private final Map b;

    public h() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        this.b = hashMap = new HashMap();
    }

    private void b(h$a h$a) {
        h$a h$a2;
        h.e(h$a);
        h$a.d = h$a2 = this.a;
        h$a.c = h$a2 = h$a2.c;
        h.g(h$a);
    }

    private void c(h$a h$a) {
        h$a h$a2;
        h.e(h$a);
        h$a h$a3 = this.a;
        h$a.d = h$a2 = h$a3.d;
        h$a.c = h$a3;
        h.g(h$a);
    }

    private static void e(h$a h$a) {
        h$a h$a2;
        h$a h$a3 = h$a.d;
        h$a3.c = h$a2 = h$a.c;
        h$a.c.d = h$a3;
    }

    private static void g(h$a h$a) {
        h$a.c.d = h$a;
        h$a.d.c = h$a;
    }

    public Object a(m m10) {
        h$a h$a = (h$a)this.b.get(m10);
        if (h$a == null) {
            h$a = new h$a(m10);
            Map map = this.b;
            map.put(m10, h$a);
        } else {
            m10.a();
        }
        this.b(h$a);
        return h$a.b();
    }

    public void d(m m10, Object object) {
        h$a h$a = (h$a)this.b.get(m10);
        if (h$a == null) {
            h$a = new h$a(m10);
            this.c(h$a);
            Map map = this.b;
            map.put(m10, h$a);
        } else {
            m10.a();
        }
        h$a.a(object);
    }

    public Object f() {
        Object object;
        boolean bl2;
        h$a h$a = this.a.d;
        while (!(bl2 = h$a.equals(object = this.a))) {
            object = h$a.b();
            if (object != null) {
                return object;
            }
            h.e(h$a);
            object = this.b;
            Object object2 = h$a.a;
            object.remove(object2);
            object = (m)h$a.a;
            object.a();
            h$a = h$a.d;
        }
        return null;
    }

    public String toString() {
        Object object;
        int n10;
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        h$a h$a = this.a.c;
        int n11 = 0;
        while ((n10 = h$a.equals(object = this.a)) == 0) {
            n11 = 1;
            stringBuilder.append('{');
            object = h$a.a;
            stringBuilder.append(object);
            stringBuilder.append(':');
            n10 = h$a.c();
            stringBuilder.append(n10);
            object = "}, ";
            stringBuilder.append((String)object);
            h$a = h$a.c;
        }
        if (n11 != 0) {
            int n12 = stringBuilder.length() + -2;
            n11 = stringBuilder.length();
            stringBuilder.delete(n12, n11);
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}

