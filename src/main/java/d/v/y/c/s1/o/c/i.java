/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.c.a;

public class i
extends b {
    private static final int d = 11;
    private static final int e = 5;
    private a c;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = d.v.y.c.s1.o.e.a.a(11, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2, 5, 0};
        return byArray;
    }

    public void clear() {
        this.c = null;
    }

    public a f() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        int n10;
        void var4_8;
        WifiDevice wifiDevice;
        a a10 = null;
        int bl2 = byArray[0];
        boolean bl3 = this.b();
        byte[] byArray2 = d.v.y.c.s1.o.e.a.b((byte)bl2, bl3);
        boolean bl4 = this.b();
        int n11 = 1;
        if (bl4) {
            byte by2 = byArray2[0];
        } else {
            byte by3 = byArray2[n11];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var4_8);
        int n12 = 11;
        boolean bl5 = this.b();
        bl2 = bl5 ? byArray2[n11] : byArray2[0];
        if (n12 == bl2) {
            bl2 = n11;
        } else {
            bl2 = 0;
            byArray2 = null;
        }
        if (bl2 && (bl2 = byArray[n11]) == (n10 = 5)) {
            bl2 = (int)(this.b() ? 1 : 0);
            this.c = a10 = new a(byArray, bl2 != 0);
            return n11;
        }
        return false;
    }
}

