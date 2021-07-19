/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;

public final class k
implements Observer {
    public final /* synthetic */ DeviceConnectFragment a;

    public /* synthetic */ k(DeviceConnectFragment deviceConnectFragment) {
        this.a = deviceConnectFragment;
    }

    public final void onChanged(Object object) {
        DeviceConnectFragment deviceConnectFragment = this.a;
        object = (BleDeviceViewModel$OperationStatus)((Object)object);
        deviceConnectFragment.y((BleDeviceViewModel$OperationStatus)((Object)object));
    }
}

