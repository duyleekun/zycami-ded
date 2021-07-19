/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class f
extends b {
    private static final int d = 9;
    private boolean c;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(9, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2, 0};
        return byArray;
    }

    public void clear() {
        this.c = false;
    }

    public boolean f() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        void var4_8;
        WifiDevice wifiDevice;
        boolean bl2 = false;
        boolean bl3 = byArray[0];
        boolean bl4 = this.b();
        byte[] byArray2 = a.b((byte)(bl3 ? 1 : 0), bl4);
        boolean bl5 = this.b();
        boolean bl6 = true;
        if (bl5) {
            byte by2 = byArray2[0];
        } else {
            byte by3 = byArray2[bl6];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var4_8);
        boolean bl7 = 9 != 0;
        boolean bl8 = this.b();
        bl3 = bl8 ? byArray2[bl6] : byArray2[0];
        if (bl7 == bl3) {
            bl3 = bl6;
        } else {
            bl3 = false;
            byArray2 = null;
        }
        if (bl3) {
            byte by4 = byArray[bl6];
            if (by4 > 0) {
                bl2 = bl6;
            }
            this.c = bl2;
            return bl6;
        }
        return false;
    }
}

