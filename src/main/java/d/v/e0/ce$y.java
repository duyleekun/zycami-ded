/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import d.v.e0.ce;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$y
implements o {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ce b;

    public ce$y(ce ce2, boolean bl2) {
        this.b = ce2;
        this.a = bl2;
    }

    public e0 a(CCSParams object) {
        boolean bl2 = this.a;
        object = bl2 ? ce.s(this.b).b() : z.t3(Boolean.TRUE);
        return object;
    }
}

