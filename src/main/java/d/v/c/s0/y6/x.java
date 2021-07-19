/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.JoystickSpeed;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class x
implements o {
    public final /* synthetic */ JoystickSpeed a;

    public /* synthetic */ x(JoystickSpeed joystickSpeed) {
        this.a = joystickSpeed;
    }

    public final Object apply(Object object) {
        JoystickSpeed joystickSpeed = this.a;
        object = (Stabilizer)object;
        return BleViewModel.B0(joystickSpeed, (Stabilizer)object);
    }
}

