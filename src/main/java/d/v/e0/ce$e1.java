/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.v0.o;
import e.a.z;

public class ce$e1
implements o {
    public final /* synthetic */ String a;
    public final /* synthetic */ ce b;

    public ce$e1(ce ce2, String string2) {
        this.b = ce2;
        this.a = string2;
    }

    public z a(Object object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("checkIfWriteComplete, md5 = ");
        String string2 = this.a;
        ((StringBuilder)object).append(string2);
        q.f(((StringBuilder)object).toString());
        object = ce.s(this.b);
        string2 = this.a;
        return ((Stabilizer)object).R1(string2);
    }
}

