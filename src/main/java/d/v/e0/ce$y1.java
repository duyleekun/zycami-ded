/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.WorkingMode;
import d.v.e0.ce;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$y1
implements o {
    public final /* synthetic */ ce a;

    public ce$y1(ce ce2) {
        this.a = ce2;
    }

    public e0 a(WorkingMode workingMode) {
        WorkingMode workingMode2 = WorkingMode.L;
        if (workingMode == workingMode2) {
            return z.t3(Boolean.TRUE);
        }
        return ce.s(this.a).j0(workingMode2);
    }
}

