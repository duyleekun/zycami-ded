/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.WorkingMode;
import e.a.v0.g;

public final class w0
implements g {
    public final /* synthetic */ BleViewModel a;
    public final /* synthetic */ WorkingMode b;

    public /* synthetic */ w0(BleViewModel bleViewModel, WorkingMode workingMode) {
        this.a = bleViewModel;
        this.b = workingMode;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        WorkingMode workingMode = this.b;
        object = (Boolean)object;
        bleViewModel.X0(workingMode, (Boolean)object);
    }
}

