/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.other.Status;
import d.v.y.c.p;
import d.v.y.c.s1.b;
import d.v.y.c.s1.j.q;
import d.v.y.c.s1.j.r;

public class x
extends p {
    public x() {
        r r10 = new r();
        q q10 = new q();
        super(r10, q10);
    }

    public byte n() {
        return ((b)this.g()).f();
    }

    public short o() {
        return ((q)this.f()).e();
    }

    public Status p() {
        return Status.from(((b)this.g()).i());
    }

    public void q(byte by2) {
        ((b)this.g()).k(by2);
    }

    public void r(byte[] byArray) {
        ((q)this.f()).f(byArray);
    }

    public void s(short s10) {
        ((q)this.f()).g(s10);
    }
}

