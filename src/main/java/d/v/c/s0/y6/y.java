/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.JoystickSpeed;
import e.a.v0.g;

public final class y
implements g {
    public final /* synthetic */ BleViewModel a;
    public final /* synthetic */ JoystickSpeed b;

    public /* synthetic */ y(BleViewModel bleViewModel, JoystickSpeed joystickSpeed) {
        this.a = bleViewModel;
        this.b = joystickSpeed;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        JoystickSpeed joystickSpeed = this.b;
        object = (Boolean)object;
        bleViewModel.D0(joystickSpeed, (Boolean)object);
    }
}

