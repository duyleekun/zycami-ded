/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class u0
implements o {
    public final /* synthetic */ WorkingMode a;

    public /* synthetic */ u0(WorkingMode workingMode) {
        this.a = workingMode;
    }

    public final Object apply(Object object) {
        WorkingMode workingMode = this.a;
        object = (Stabilizer)object;
        return BleViewModel.V0(workingMode, (Stabilizer)object);
    }
}

