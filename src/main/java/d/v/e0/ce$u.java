/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.PhotoInfoNumber;
import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.a;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;

public class ce$u
implements o {
    public final /* synthetic */ String a;
    public final /* synthetic */ ce b;

    public ce$u(ce ce2, String string2) {
        this.b = ce2;
        this.a = string2;
    }

    public z a(WifiStatus object) {
        Object object2 = WifiStatus.CONNECTED;
        if (object == object2) {
            object = ce.s(this.b);
            object2 = PhotoInfoNumber.SSID;
            object = ((Stabilizer)object).m1((PhotoInfoNumber)((Object)object2));
            object2 = this.a;
            object2.getClass();
            a a10 = new a((String)object2);
            return ((z)object).H3(a10);
        }
        return z.t3(Boolean.FALSE);
    }
}

