/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.JoystickSpeed;
import e.a.v0.g;

public final class d0
implements g {
    public final /* synthetic */ BleViewModel a;

    public /* synthetic */ d0(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        object = (JoystickSpeed)((Object)object);
        bleViewModel.U((JoystickSpeed)((Object)object));
    }
}

