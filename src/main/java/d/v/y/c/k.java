/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.other.Status;
import d.v.y.c.p;
import d.v.y.c.s1.b;
import d.v.y.c.s1.j.g;
import d.v.y.c.s1.j.h;

public class k
extends p {
    public k() {
        h h10 = new h();
        g g10 = new g();
        super(h10, g10);
    }

    public byte n() {
        return ((b)this.g()).f();
    }

    public short o() {
        return ((g)this.f()).d();
    }

    public Status p() {
        return Status.from(((b)this.g()).i());
    }

    public void q(byte by2) {
        ((b)this.g()).k(by2);
    }

    public void r(int n10) {
        ((g)this.f()).e(n10);
    }
}

