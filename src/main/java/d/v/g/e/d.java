/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.data.local.entity.RegionalRestrictionsInfo;

public final class d
implements Runnable {
    public final /* synthetic */ BleConnection a;
    public final /* synthetic */ RegionalRestrictionsInfo b;

    public /* synthetic */ d(BleConnection bleConnection, RegionalRestrictionsInfo regionalRestrictionsInfo) {
        this.a = bleConnection;
        this.b = regionalRestrictionsInfo;
    }

    public final void run() {
        BleConnection bleConnection = this.a;
        RegionalRestrictionsInfo regionalRestrictionsInfo = this.b;
        bleConnection.l0(regionalRestrictionsInfo);
    }
}

