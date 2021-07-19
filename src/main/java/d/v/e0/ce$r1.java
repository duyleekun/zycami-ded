/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import com.zhiyun.protocol.message.bl.other.Status;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.v0.o;
import e.a.z;

public class ce$r1
implements o {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ ce b;

    public ce$r1(ce ce2, int[] nArray) {
        this.b = ce2;
        this.a = nArray;
    }

    public z a(Integer object) {
        int n10;
        Object object2 = this.a;
        object2[0] = n10 = ((Integer)object).intValue();
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("[invoke mStabilizer.getDeviceInfo(");
        n10 = ((Integer)object).byteValue();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(")]");
        q.i(((StringBuilder)object2).toString());
        object2 = ce.s(this.b);
        byte by2 = ((Integer)object).byteValue();
        object = ((Stabilizer)object2).r2(by2);
        Status status = Status.ERR_CMD;
        object2 = new Pair((Object)status, null);
        return ((z)object).p4(object2);
    }
}

