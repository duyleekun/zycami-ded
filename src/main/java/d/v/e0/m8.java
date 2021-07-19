/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.WorkingMode;
import d.v.e0.ce;
import e.a.v0.g;

public final class m8
implements g {
    public final /* synthetic */ WorkingMode[] a;

    public /* synthetic */ m8(WorkingMode[] workingModeArray) {
        this.a = workingModeArray;
    }

    public final void accept(Object object) {
        WorkingMode[] workingModeArray = this.a;
        object = (WorkingMode)((Object)object);
        ce.h4(workingModeArray, (WorkingMode)((Object)object));
    }
}

