/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;
import java.nio.charset.Charset;

public class e
extends b {
    private final int c;
    private int d;
    private String e;

    public e() {
        this.c = 7;
    }

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(7, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2, by2 = (byte)this.d};
        return byArray;
    }

    public void clear() {
        this.d = 0;
        this.e = null;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public void h(int n10) {
        this.d = n10;
    }

    public void i(String string2) {
        this.e = string2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] byArray) {
        void var5_9;
        WifiDevice wifiDevice;
        int n10 = 0;
        String string2 = null;
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
        this.b = wifiDevice = WifiDevice.toDevice((int)var5_9);
        boolean bl6 = 7 != 0;
        boolean bl7 = this.b();
        bl2 = bl7 ? byArray2[bl5] : byArray2[0];
        if (bl6 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray2 = null;
        }
        if (!bl2) {
            return false;
        }
        this.d = n10 = byArray[bl5];
        int n11 = byArray.length + -3;
        Charset charset = Charset.forName("utf-8");
        this.e = string2 = new String(byArray, 2, n11, charset);
        return bl5;
    }
}

