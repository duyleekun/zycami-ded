/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.o;

public class ce$h0
implements o {
    public final /* synthetic */ ce a;

    public ce$h0(ce ce2) {
        this.a = ce2;
    }

    public Boolean a(WifiStatus wifiStatus) {
        boolean bl2;
        WifiStatus wifiStatus2 = WifiStatus.CONNECTING;
        if (wifiStatus == wifiStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            wifiStatus = null;
        }
        return bl2;
    }
}

