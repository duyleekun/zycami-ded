/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import java.util.Comparator;

public final class b
implements Comparator {
    public final /* synthetic */ DeviceBindViewModel a;

    public /* synthetic */ b(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public final int compare(Object object, Object object2) {
        DeviceBindViewModel deviceBindViewModel = this.a;
        object = (BindDeviceInfo)object;
        object2 = (BindDeviceInfo)object2;
        return DeviceBindViewModel.G(deviceBindViewModel, (BindDeviceInfo)object, (BindDeviceInfo)object2);
    }
}

