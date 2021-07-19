/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.DeviceInfo;
import d.v.g.g.c1;

public final class h
implements Runnable {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ DeviceInfo b;

    public /* synthetic */ h(c1 c12, DeviceInfo deviceInfo) {
        this.a = c12;
        this.b = deviceInfo;
    }

    public final void run() {
        c1 c12 = this.a;
        DeviceInfo deviceInfo = this.b;
        c12.x(deviceInfo);
    }
}

