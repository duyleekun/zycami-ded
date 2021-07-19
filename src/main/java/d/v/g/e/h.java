/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;

public final class h
implements Runnable {
    public final /* synthetic */ BleConnection a;
    public final /* synthetic */ AppDeviceInfo b;

    public /* synthetic */ h(BleConnection bleConnection, AppDeviceInfo appDeviceInfo) {
        this.a = bleConnection;
        this.b = appDeviceInfo;
    }

    public final void run() {
        BleConnection bleConnection = this.a;
        AppDeviceInfo appDeviceInfo = this.b;
        bleConnection.j0(appDeviceInfo);
    }
}

