/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.active.ActiveState;
import d.v.y.c.p;
import d.v.y.c.s1.e.a;
import d.v.y.c.s1.e.f;

public class c
extends p {
    public c() {
        a a10 = new a();
        f f10 = new f();
        super(a10, f10);
    }

    public ActiveState n() {
        return ((f)this.f()).d();
    }

    public void o(int n10) {
        ((f)this.f()).e(n10);
    }

    public void p(d.v.y.c.s1.e.c c10) {
        ((f)this.f()).f(c10);
    }

    public void q(byte[] byArray) {
        ((f)this.f()).g(byArray);
    }

    public void r(ActiveState activeState) {
        ((f)this.f()).h(activeState);
    }

    public void s(int n10) {
        ((f)this.f()).i(n10);
    }
}

