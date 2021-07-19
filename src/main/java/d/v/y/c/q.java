/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.otherevent.MoveLineStatus;
import d.v.y.c.p;
import d.v.y.c.s1.k.d;
import d.v.y.c.s1.k.g;

public class q
extends p {
    public q() {
        g g10 = new g();
        d d10 = new d();
        super(g10, d10);
    }

    public MoveLineStatus n() {
        return ((d)this.f()).d();
    }

    public void o(MoveLineStatus moveLineStatus) {
        ((d)this.f()).e(moveLineStatus);
    }
}

