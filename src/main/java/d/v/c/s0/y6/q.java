/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.WorkingMode;
import e.a.v0.g;

public final class q
implements g {
    public final /* synthetic */ BleViewModel a;

    public /* synthetic */ q(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        object = (WorkingMode)((Object)object);
        bleViewModel.j0((WorkingMode)((Object)object));
    }
}

