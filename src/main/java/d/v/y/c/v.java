/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.p;
import d.v.y.c.s1.n.a;
import d.v.y.c.s1.n.b;
import d.v.y.c.s1.n.d;
import java.util.Map;

public class v
extends p {
    public v() {
        b b10 = new b();
        a a10 = new a();
        super(b10, a10);
    }

    public d n() {
        Map map = ((a)this.f()).d();
        d d10 = new d(map);
        return d10;
    }

    public int o() {
        return ((a)this.f()).e();
    }

    public void p(Map map) {
        ((a)this.f()).f(map);
    }

    public void q(int n10) {
        ((a)this.f()).g(n10);
    }
}

