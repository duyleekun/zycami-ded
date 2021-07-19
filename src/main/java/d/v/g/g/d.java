/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.g.c1;

public final class d
implements Observer {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ LiveData b;
    public final /* synthetic */ DeviceInfo c;

    public /* synthetic */ d(c1 c12, LiveData liveData, DeviceInfo deviceInfo) {
        this.a = c12;
        this.b = liveData;
        this.c = deviceInfo;
    }

    public final void onChanged(Object object) {
        c1 c12 = this.a;
        LiveData liveData = this.b;
        DeviceInfo deviceInfo = this.c;
        object = (FirmwareInfo)object;
        c12.z(liveData, deviceInfo, (FirmwareInfo)object);
    }
}

