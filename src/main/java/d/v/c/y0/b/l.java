/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;

public final class l
implements Observer {
    public final /* synthetic */ DeviceConnectFragment a;

    public /* synthetic */ l(DeviceConnectFragment deviceConnectFragment) {
        this.a = deviceConnectFragment;
    }

    public final void onChanged(Object object) {
        DeviceConnectFragment deviceConnectFragment = this.a;
        object = (BleDeviceViewModel$ConnectStatus)((Object)object);
        deviceConnectFragment.u((BleDeviceViewModel$ConnectStatus)((Object)object));
    }
}

