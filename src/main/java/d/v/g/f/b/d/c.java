/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.lifecycle.LiveData;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import java.util.List;

public interface c {
    default public void a(DeviceInfo deviceInfo) {
        long l10 = System.currentTimeMillis();
        deviceInfo.setCreateTimestamp(l10);
        this.c(deviceInfo);
    }

    default public void b(DeviceInfo deviceInfo) {
        long l10 = System.currentTimeMillis();
        deviceInfo.setUpdateTimestamp(l10);
        this.k(deviceInfo);
    }

    public void c(DeviceInfo var1);

    public void d();

    public LiveData e(int var1);

    public void f(DeviceInfo var1);

    public void g(List var1);

    public void h(AppDeviceInfo ... var1);

    public LiveData i();

    public List j();

    public void k(DeviceInfo var1);

    public List l(int var1);

    public LiveData m(int var1);
}

