/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;

public final class q
implements Observer {
    public final /* synthetic */ DeviceConnectFragment a;

    public /* synthetic */ q(DeviceConnectFragment deviceConnectFragment) {
        this.a = deviceConnectFragment;
    }

    public final void onChanged(Object object) {
        DeviceConnectFragment deviceConnectFragment = this.a;
        object = (BleDeviceViewModel$ShowStatus)((Object)object);
        deviceConnectFragment.s((BleDeviceViewModel$ShowStatus)((Object)object));
    }
}

