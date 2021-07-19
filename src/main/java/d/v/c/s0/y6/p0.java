/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.JoystickSpeed;
import e.a.v0.g;

public final class p0
implements g {
    public final /* synthetic */ JoystickSpeed a;

    public /* synthetic */ p0(JoystickSpeed joystickSpeed) {
        this.a = joystickSpeed;
    }

    public final void accept(Object object) {
        JoystickSpeed joystickSpeed = this.a;
        object = (Throwable)object;
        BleViewModel.E0(joystickSpeed, (Throwable)object);
    }
}

