/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.PhotoInfoNumber;
import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$x
implements o {
    public final /* synthetic */ ce a;

    public ce$x(ce ce2) {
        this.a = ce2;
    }

    public e0 a(WifiStatus wifiStatus) {
        Object object = ce.s(this.a);
        Object object2 = PhotoInfoNumber.SSID;
        object = ((Stabilizer)object).m1((PhotoInfoNumber)((Object)object2));
        object2 = z.t3("");
        ce ce2 = this.a;
        boolean bl2 = ce.l(ce2, wifiStatus);
        if (!bl2) {
            object = object2;
        }
        return object;
    }
}

