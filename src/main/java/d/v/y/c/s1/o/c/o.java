/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class o
extends b {
    private final int c;
    private WifiStatus d;

    public o() {
        this.c = 2;
    }

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        int n10 = 2;
        byte by2 = a.a(n10, wifiDevice, bl2);
        byte[] byArray = new byte[n10];
        byArray[0] = by2;
        byArray[1] = 0;
        return byArray;
    }

    public void clear() {
        this.d = null;
    }

    public WifiStatus f() {
        return this.d;
    }

    public void g(WifiStatus wifiStatus) {
        this.d = wifiStatus;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] object) {
        void var3_7;
        WifiDevice wifiDevice;
        Object bl2 = object[0];
        boolean bl3 = this.b();
        byte[] byArray = a.b((byte)bl2, bl3);
        boolean bl4 = this.b();
        boolean bl5 = true;
        if (bl4) {
            byte by2 = byArray[0];
        } else {
            byte by3 = byArray[bl5];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var3_7);
        int n10 = 2;
        boolean bl6 = this.b();
        bl2 = bl6 ? (Object)byArray[bl5] : (Object)byArray[0];
        if (n10 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2 != false) {
            object = WifiStatus.toStatus((int)object[bl5]);
            this.d = (WifiStatus)((Object)object);
            return bl5;
        }
        return false;
    }
}

