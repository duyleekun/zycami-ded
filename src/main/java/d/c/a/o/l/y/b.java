/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l.y;

import d.c.a.o.c;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.j.j;
import d.c.a.o.l.g;
import d.c.a.o.l.m;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;

public class b
implements n {
    public static final e b;
    private final m a;

    static {
        Integer n10 = 2500;
        b = e.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", n10);
    }

    public b() {
        this(null);
    }

    public b(m m10) {
        this.a = m10;
    }

    public n$a c(g object, int n10, int n11, f object2) {
        n$a n$a;
        Object object3 = this.a;
        if (object3 != null) {
            n$a = null;
            if ((object3 = (g)((m)object3).b(object, 0, 0)) == null) {
                object3 = this.a;
                ((m)object3).c(object, 0, 0, object);
            } else {
                object = object3;
            }
        }
        object3 = b;
        n10 = (Integer)((f)object2).c((e)object3);
        object2 = new j((g)object, n10);
        n$a = new n$a((c)object, (d)object2);
        return n$a;
    }

    public boolean d(g g10) {
        return true;
    }
}

