/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;
import d.v.y.d.k;

public class h
extends b {
    private static final int e = 7;
    private HotspotStatus c;
    private String d;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(7, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2};
        return byArray;
    }

    public void clear() {
        this.c = null;
        this.d = null;
    }

    public HotspotStatus f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public boolean parseFrom(byte[] object) {
        WifiDevice wifiDevice;
        int n10 = 0;
        HotspotStatus hotspotStatus = null;
        int n11 = object[0];
        int n12 = this.b();
        byte[] byArray = a.b((byte)n11, n12 != 0);
        n12 = this.b();
        int n13 = 1;
        n12 = n12 != 0 ? byArray[0] : byArray[n13];
        this.b = wifiDevice = WifiDevice.toDevice(n12);
        n12 = 7;
        boolean bl2 = this.b();
        n11 = bl2 ? byArray[n13] : byArray[0];
        if (n12 == n11) {
            n11 = n13;
        } else {
            n11 = 0;
            byArray = null;
        }
        if (n11 != 0) {
            this.c = hotspotStatus = HotspotStatus.toStatus(object[n13]);
            n10 = ((byte[])object).length;
            n11 = 2;
            object = k.e(object, n11, n10 -= n11);
            this.d = object;
            return n13 != 0;
        }
        return false;
    }
}

