/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class l
extends b {
    public static final int f = 11;
    public static final int g = 4;
    private WifiDevice c;
    private int d;
    private int e;

    public byte[] a() {
        return null;
    }

    public void clear() {
        this.c = null;
        this.d = 0;
        this.e = 0;
    }

    public int f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        int n10;
        void var4_11;
        WifiDevice wifiDevice;
        boolean by2 = false;
        int n11 = byArray[0];
        boolean bl2 = this.b();
        byte[] byArray2 = a.b((byte)n11, bl2);
        boolean bl3 = this.b();
        int n12 = 1;
        if (bl3) {
            byte by3 = byArray2[0];
        } else {
            byte by4 = byArray2[n12];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var4_11);
        int n13 = 11;
        boolean bl4 = this.b();
        n11 = bl4 ? byArray2[n12] : byArray2[0];
        if (n13 == n11) {
            n11 = n12;
        } else {
            n11 = 0;
            byArray2 = null;
        }
        if (n11 && (n11 = byArray[n12]) == (n10 = 4)) {
            int n14;
            byte by5 = byArray[2];
            n11 = byArray[3];
            bl4 = this.b();
            this.d = n14 = d.v.y.d.b.w(by5, (byte)n11, bl4);
            byte by6 = byArray[n10];
            int n15 = byArray[5];
            n11 = (int)(this.b() ? 1 : 0);
            this.e = n15 = d.v.y.d.b.w(by6, (byte)n15, n11 != 0);
            return n12;
        }
        return false;
    }
}

