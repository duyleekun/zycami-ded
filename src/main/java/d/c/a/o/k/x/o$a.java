/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.x;

import d.c.a.o.k.x.m;
import d.c.a.o.k.x.o;
import d.c.a.o.k.x.o$b;

public final class o$a
implements m {
    private final o$b a;
    public int b;

    public o$a(o$b b10) {
        this.a = b10;
    }

    public void a() {
        this.a.c(this);
    }

    public void b(int n10) {
        this.b = n10;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof o$a;
        boolean bl2 = false;
        if (n10 != 0) {
            object = (o$a)object;
            n10 = this.b;
            int n11 = ((o$a)object).b;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        return o.g(this.b);
    }
}

