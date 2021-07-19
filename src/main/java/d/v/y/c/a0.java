/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.c0;
import d.v.y.c.s1.g.b;
import java.util.Map;

public class a0
extends c0 {
    public a0() {
        b b10 = new b();
        super(b10);
    }

    public CCSParams n() {
        CCSStatus cCSStatus = this.o();
        Map map = ((b)this.f()).d();
        CCSParams cCSParams = new CCSParams(cCSStatus, map);
        return cCSParams;
    }

    public CCSStatus o() {
        return ((b)this.f()).e();
    }

    public void p(short s10) {
        ((b)this.f()).f(s10);
    }

    public void q(CCSStatus cCSStatus) {
        ((b)this.f()).g(cCSStatus);
    }
}

