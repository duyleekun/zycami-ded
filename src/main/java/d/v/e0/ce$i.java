/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeoutException;

public class ce$i
implements o {
    public final /* synthetic */ ce a;

    public ce$i(ce ce2) {
        this.a = ce2;
    }

    public z a(WifiStatus object) {
        WifiStatus wifiStatus = WifiStatus.SCANNING;
        if (object != wifiStatus) {
            object = new TimeoutException();
            return z.m2((Throwable)object);
        }
        return z.t3(object);
    }
}

