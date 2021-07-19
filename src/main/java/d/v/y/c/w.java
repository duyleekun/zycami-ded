/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.other.Status;
import d.v.y.c.p;
import d.v.y.c.s1.b;
import d.v.y.c.s1.j.o;
import d.v.y.c.s1.j.t;

public class w
extends p {
    public w() {
        d.v.y.c.s1.j.p p10 = new d.v.y.c.s1.j.p();
        o o10 = new o();
        super(p10, o10);
    }

    public byte n() {
        return ((b)this.g()).f();
    }

    public t o() {
        return ((o)this.f()).d();
    }

    public Status p() {
        return Status.from(((b)this.g()).i());
    }

    public void q(byte by2) {
        ((b)this.g()).k(by2);
    }
}

