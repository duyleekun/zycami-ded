/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$c1
implements o {
    public final /* synthetic */ WorkingMode a;
    public final /* synthetic */ ce b;

    public ce$c1(ce ce2, WorkingMode workingMode) {
        this.b = ce2;
        this.a = workingMode;
    }

    public e0 a(Boolean object) {
        object = ce.s(this.b);
        Object object2 = this.a;
        object = ((Stabilizer)object).j0((WorkingMode)((Object)object2)).U4(2);
        object2 = Boolean.TRUE;
        return ((z)object).p4(object2);
    }
}

