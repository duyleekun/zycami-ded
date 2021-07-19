/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;
import java.nio.charset.Charset;

public class k
extends b {
    private static final int e = 6;
    private HotspotStatus c;
    private String d;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(6, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2};
        return byArray;
    }

    public void clear() {
        this.d = null;
        this.c = null;
    }

    public HotspotStatus f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        void var4_8;
        WifiDevice wifiDevice;
        Object object = null;
        boolean bl2 = byArray[0];
        boolean bl3 = this.b();
        byte[] byArray2 = a.b((byte)(bl2 ? 1 : 0), bl3);
        boolean bl4 = this.b();
        boolean bl5 = true;
        if (bl4) {
            byte by2 = byArray2[0];
        } else {
            byte by3 = byArray2[bl5];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var4_8);
        boolean bl6 = 6 != 0;
        boolean bl7 = this.b();
        bl2 = bl7 ? byArray2[bl5] : byArray2[0];
        if (bl6 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray2 = null;
        }
        if (bl2) {
            this.c = object = HotspotStatus.toStatus(byArray[bl5]);
            int n10 = byArray.length + -3;
            Charset charset = Charset.forName("utf-8");
            object = new String(byArray, 2, n10, charset);
            this.d = object;
            return bl5;
        }
        return false;
    }
}

