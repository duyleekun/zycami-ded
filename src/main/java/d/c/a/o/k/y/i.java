/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.c;
import d.c.a.o.k.s;
import d.c.a.o.k.y.j;
import d.c.a.o.k.y.j$a;
import d.c.a.u.h;

public class i
extends h
implements j {
    private j$a e;

    public i(long l10) {
        super(l10);
    }

    public void a(int n10) {
        int n11 = 40;
        if (n10 >= n11) {
            this.b();
        } else {
            n11 = 20;
            if (n10 >= n11 || n10 == (n11 = 15)) {
                long l10 = this.e();
                long l11 = 2;
                this.p(l10 /= l11);
            }
        }
    }

    public void g(j$a j$a) {
        this.e = j$a;
    }

    public int q(s s10) {
        if (s10 == null) {
            return super.l(null);
        }
        return s10.getSize();
    }

    public void r(c object, s s10) {
        object = this.e;
        if (object != null && s10 != null) {
            object.a(s10);
        }
    }
}

