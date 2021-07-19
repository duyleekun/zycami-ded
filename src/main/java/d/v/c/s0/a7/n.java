/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.ble.BleViewModel$JoystickEvent;
import d.v.c.s0.a7.e1;

public final class n
implements Observer {
    public final /* synthetic */ e1 a;

    public /* synthetic */ n(e1 e12) {
        this.a = e12;
    }

    public final void onChanged(Object object) {
        e1 e12 = this.a;
        object = (BleViewModel$JoystickEvent)((Object)object);
        e12.d0((BleViewModel$JoystickEvent)((Object)object));
    }
}

