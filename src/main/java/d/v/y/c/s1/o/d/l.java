/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class l
extends b {
    private static final int d = 1;
    private HotspotStatus c;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        int n10 = 1;
        byte by2 = a.a(n10, wifiDevice, bl2);
        byte[] byArray = new byte[n10];
        byArray[0] = by2;
        return byArray;
    }

    public void clear() {
        this.c = null;
    }

    public HotspotStatus f() {
        return this.c;
    }

    public boolean parseFrom(byte[] object) {
        WifiDevice wifiDevice;
        boolean bl2 = object[0];
        byte by2 = this.b();
        byte[] byArray = a.b((byte)(bl2 ? 1 : 0), by2 != 0);
        by2 = this.b();
        boolean bl3 = true;
        by2 = by2 != 0 ? byArray[0] : byArray[bl3];
        this.b = wifiDevice = WifiDevice.toDevice(by2);
        by2 = (byte)(this.b() ? 1 : 0);
        bl2 = by2 != 0 ? byArray[bl3] : byArray[0];
        if (bl3 == bl2) {
            bl2 = bl3;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2) {
            object = (Object)HotspotStatus.toStatus(object[bl3]);
            this.c = (HotspotStatus)((Object)object);
            return bl3;
        }
        return false;
    }
}

