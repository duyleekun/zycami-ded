/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class j
extends b {
    private static final int e = 11;
    private static final int f = 3;
    private int c;
    private int d;

    public byte[] a() {
        int n10;
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(11, wifiDevice, bl2);
        byte[] byArray = new byte[4];
        byArray[0] = by2;
        byArray[1] = n10 = 3;
        byArray[2] = by2 = (byte)this.c;
        byArray[n10] = by2 = (byte)this.d;
        return byArray;
    }

    public void clear() {
        this.c = 0;
        this.d = 0;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.d;
    }

    public void h(int n10) {
        this.c = n10;
    }

    public void i(int n10) {
        this.d = n10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        int n10;
        void var4_8;
        WifiDevice wifiDevice;
        int n102 = 0;
        int bl2 = byArray[0];
        boolean bl3 = this.b();
        byte[] byArray2 = a.b((byte)bl2, bl3);
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
        if (bl2 && (bl2 = byArray[n11]) == (n10 = 3)) {
            int n13;
            this.c = n102 = byArray[2];
            this.d = n13 = byArray[n10];
            return n11;
        }
        return false;
    }
}

