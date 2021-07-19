/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.WorkingMode;
import d.v.e0.ce;
import e.a.v0.r;

public final class c9
implements r {
    public final /* synthetic */ WorkingMode a;

    public /* synthetic */ c9(WorkingMode workingMode) {
        this.a = workingMode;
    }

    public final boolean test(Object object) {
        WorkingMode workingMode = this.a;
        object = (Boolean)object;
        return ce.b2(workingMode, (Boolean)object);
    }
}

