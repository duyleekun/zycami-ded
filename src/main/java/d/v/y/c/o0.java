/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.m0;
import d.v.y.c.s1.o.d.j;
import java.util.Objects;

public class o0
extends m0 {
    public o0() {
        j j10 = new j();
        super(j10);
    }

    public HotspotStatus n() {
        return ((j)this.f()).f();
    }

    public void o(String string2) {
        j j10 = (j)this.f();
        Objects.requireNonNull(string2);
        j10.h(string2);
    }
}

