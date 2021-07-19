/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;

public class ce$l
implements o {
    public final /* synthetic */ ce a;

    public ce$l(ce ce2) {
        this.a = ce2;
    }

    public z a(WifiStatus wifiStatus) {
        WifiStatus wifiStatus2 = WifiStatus.SCANNING;
        if (wifiStatus != wifiStatus2) {
            return ce.i(this.a);
        }
        return z.t3((Object)wifiStatus2);
    }
}

