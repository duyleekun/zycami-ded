/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.fe;
import e.a.v0.o;

public final class tb
implements o {
    public final /* synthetic */ WorkingMode a;

    public /* synthetic */ tb(WorkingMode workingMode) {
        this.a = workingMode;
    }

    public final Object apply(Object object) {
        WorkingMode workingMode = this.a;
        object = (Stabilizer)object;
        return fe.o(workingMode, (Stabilizer)object);
    }
}

