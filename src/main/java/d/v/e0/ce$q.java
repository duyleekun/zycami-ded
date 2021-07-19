/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;

public class ce$q
implements o {
    public final /* synthetic */ ce a;

    public ce$q(ce ce2) {
        this.a = ce2;
    }

    public z a(WifiStatus wifiStatus) {
        WifiStatus wifiStatus2 = WifiStatus.DISCONNECTED;
        if (wifiStatus == wifiStatus2) {
            return ce.k(this.a);
        }
        return z.t3(Boolean.TRUE);
    }
}

