/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.x1.c;
import f.x1.c$a;
import java.util.RandomAccess;

public final class c$d
extends c
implements RandomAccess {
    private int b;
    private final c c;
    private final int d;

    public c$d(c c10, int n10, int n11) {
        f0.p(c10, "list");
        this.c = c10;
        this.d = n10;
        c$a c$a = f.x1.c.a;
        int n12 = c10.size();
        c$a.d(n10, n11, n12);
        this.b = n11 -= n10;
    }

    public int b() {
        return this.b;
    }

    public Object get(int n10) {
        Object object = f.x1.c.a;
        int n11 = this.b;
        ((c$a)object).b(n10, n11);
        object = this.c;
        n11 = this.d + n10;
        return ((c)object).get(n11);
    }
}

