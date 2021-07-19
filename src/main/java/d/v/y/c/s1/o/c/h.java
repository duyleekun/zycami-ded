/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class h
extends b {
    private static final int d = 8;
    private int c;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(8, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2, 0};
        return byArray;
    }

    public void clear() {
        this.c = 0;
    }

    public int f() {
        return this.c;
    }

    public void g(int n10) {
        this.c = n10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        void var3_7;
        WifiDevice wifiDevice;
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
        this.b = wifiDevice = WifiDevice.toDevice((int)var3_7);
        boolean bl6 = 8 != 0;
        boolean bl7 = this.b();
        bl2 = bl7 ? byArray2[bl5] : byArray2[0];
        if (bl6 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray2 = null;
        }
        if (bl2) {
            int n10;
            this.c = n10 = byArray[bl5];
            return bl5;
        }
        return false;
    }
}

