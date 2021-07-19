/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.JoystickSpeed;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import e.a.v0.o;

public final class v2
implements o {
    public final /* synthetic */ JoystickSpeed a;

    public /* synthetic */ v2(JoystickSpeed joystickSpeed) {
        this.a = joystickSpeed;
    }

    public final Object apply(Object object) {
        JoystickSpeed joystickSpeed = this.a;
        object = (rd)object;
        return Stabilizer.v5(joystickSpeed, (rd)object);
    }
}

