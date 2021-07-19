/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.e$a;
import d.c.a.o.l.e$b;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;

public final class e
implements n {
    private static final String b = "data:image";
    private static final String c = ";base64";
    private final e$a a;

    public e(e$a e$a) {
        this.a = e$a;
    }

    public boolean a(Object object) {
        return object.toString().startsWith(b);
    }

    public n$a b(Object object, int n10, int n11, f object2) {
        d.c.a.t.e e10 = new d.c.a.t.e(object);
        object = object.toString();
        e$a e$a = this.a;
        object2 = new e$b((String)object, e$a);
        n$a n$a = new n$a(e10, (d)object2);
        return n$a;
    }
}

