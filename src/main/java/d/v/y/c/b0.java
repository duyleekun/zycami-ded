/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.c0;
import d.v.y.c.s1.g.c;
import java.util.Map;

public class b0
extends c0 {
    public b0() {
        c c10 = new c();
        super(c10);
    }

    public CCSParams n() {
        CCSStatus cCSStatus = this.o();
        Map map = ((c)this.f()).d();
        CCSParams cCSParams = new CCSParams(cCSStatus, map);
        return cCSParams;
    }

    public CCSStatus o() {
        return ((c)this.f()).e();
    }

    public void p(short s10) {
        ((c)this.f()).f(s10);
    }

    public void q(CCSStatus cCSStatus) {
        ((c)this.f()).g(cCSStatus);
    }
}

