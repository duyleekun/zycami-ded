/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.c0;
import d.v.y.c.s1.g.e;
import java.util.Map;

public class d0
extends c0 {
    public d0() {
        e e10 = new e();
        super(e10);
    }

    public CCSParams n() {
        CCSStatus cCSStatus = this.o();
        Map map = ((e)this.f()).d();
        CCSParams cCSParams = new CCSParams(cCSStatus, map);
        return cCSParams;
    }

    public CCSStatus o() {
        return ((e)this.f()).e();
    }

    public void p(short s10, String string2) {
        ((e)this.f()).f(s10, string2);
    }

    public void q(CCSStatus cCSStatus) {
        ((e)this.f()).g(cCSStatus);
    }
}

