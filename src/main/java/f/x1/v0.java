/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.x1.c;
import f.x1.c$a;
import java.util.List;
import java.util.RandomAccess;

public final class v0
extends c
implements RandomAccess {
    private int b;
    private int c;
    private final List d;

    public v0(List list) {
        f0.p(list, "list");
        this.d = list;
    }

    public int b() {
        return this.c;
    }

    public final void c(int n10, int n11) {
        c$a c$a = f.x1.c.a;
        int n12 = this.d.size();
        c$a.d(n10, n11, n12);
        this.b = n10;
        this.c = n11 -= n10;
    }

    public Object get(int n10) {
        Object object = f.x1.c.a;
        int n11 = this.c;
        ((c$a)object).b(n10, n11);
        object = this.d;
        n11 = this.b + n10;
        return object.get(n11);
    }
}

