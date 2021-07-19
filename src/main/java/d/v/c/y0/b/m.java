/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleDevice;

public final class m
implements Observer {
    public final /* synthetic */ DeviceConnectFragment a;

    public /* synthetic */ m(DeviceConnectFragment deviceConnectFragment) {
        this.a = deviceConnectFragment;
    }

    public final void onChanged(Object object) {
        DeviceConnectFragment deviceConnectFragment = this.a;
        object = (BleDevice)object;
        deviceConnectFragment.w((BleDevice)object);
    }
}

