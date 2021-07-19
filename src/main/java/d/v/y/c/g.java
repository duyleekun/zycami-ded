/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.other.Status;
import d.v.y.c.p;
import d.v.y.c.s1.b;
import d.v.y.c.s1.j.e;
import d.v.y.c.s1.j.f;

public class g
extends p {
    public g() {
        f f10 = new f();
        e e10 = new e();
        super(f10, e10);
    }

    public byte n() {
        return ((b)this.g()).f();
    }

    public Status o() {
        return Status.from(((b)this.g()).i());
    }

    public void p(byte by2) {
        ((b)this.g()).k(by2);
    }
}

