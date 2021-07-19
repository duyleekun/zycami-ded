/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.n;

import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.z.l.h;
import d.v.z.m.b;
import d.v.z.m.c;
import d.v.z.m.d;
import d.v.z.n.f;

public abstract class g
extends f {
    public g(b b10, h h10) {
        this.j(b10);
        this.f(h10);
    }

    public void k(g g10, h h10) {
        b b10 = this.e().clone();
        g10.j(b10);
        g10.f(h10);
        int n10 = this.d();
        g10.g(n10);
        n10 = this.h();
        g10.b(n10);
    }

    public abstract g l();

    public d.v.z.k.d m() {
        return this.e().d();
    }

    public ProtoType n() {
        return this.getData().a();
    }

    public void o() {
        c c10 = new c();
        this.j(c10);
    }

    public void p() {
        d d10 = new d();
        this.j(d10);
    }

    public void q(g object) {
        object = d.v.z.k.d.b(((g)object).m().getCode());
        d d10 = new d((d.v.z.k.d)object);
        this.j(d10);
    }
}

