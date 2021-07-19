/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.otherevent.DeviceType;
import d.v.y.c.p;
import d.v.y.c.s1.k.c;
import d.v.y.c.s1.k.g;

public class j
extends p {
    public j() {
        g g10 = new g();
        c c10 = new c();
        super(g10, c10);
    }

    public DeviceType n() {
        return ((c)this.f()).d();
    }

    public void o(boolean bl2) {
        ((c)this.f()).f(bl2);
    }

    public void p(DeviceType deviceType) {
        ((c)this.f()).e(deviceType);
    }
}

