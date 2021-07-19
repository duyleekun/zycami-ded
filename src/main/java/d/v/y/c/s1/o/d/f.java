/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class f
extends b {
    private static final int d = 3;
    private HotspotStatus c;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(3, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2};
        return byArray;
    }

    public void clear() {
        this.c = null;
    }

    public HotspotStatus f() {
        return this.c;
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
        int n10 = 3;
        boolean bl6 = this.b();
        bl2 = bl6 ? (Object)byArray[bl5] : (Object)byArray[0];
        if (n10 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2 != false) {
            object = HotspotStatus.toStatus((int)object[bl5]);
            this.c = (HotspotStatus)((Object)object);
            return bl5;
        }
        return false;
    }
}

