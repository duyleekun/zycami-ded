/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.ce$u1$a;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.h0;
import e.a.q0.c.a;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;

public class ce$u1
implements o {
    public final /* synthetic */ d a;
    public final /* synthetic */ ce b;

    public ce$u1(ce ce2, d d10) {
        this.b = ce2;
        this.a = d10;
    }

    public e0 a(Boolean object) {
        q.i("invoke mStabilizer.getDeviceInfo(1)");
        object = ce.s(this.b);
        byte by2 = Integer.valueOf(1).byteValue();
        object = ((Stabilizer)object).r2(by2).U4(10);
        Object object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((h0)object2);
        object2 = new ce$u1$a(this);
        return ((z)object).d2((g)object2);
    }
}

