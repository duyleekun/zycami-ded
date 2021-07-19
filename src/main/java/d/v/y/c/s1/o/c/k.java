/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.device.PhotoInfoNumber;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;
import java.nio.charset.Charset;

public class k
extends b {
    public static final int e = 11;
    public static final int f = 1;
    private PhotoInfoNumber c;
    private String d;

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(11, wifiDevice, bl2);
        byte[] byArray = new byte[3];
        byArray[0] = by2;
        byArray[by2] = by2 = 1;
        byArray[2] = by2 = (byte)this.c.getNumber();
        return byArray;
    }

    public void clear() {
        this.c = null;
        this.d = null;
    }

    public String f() {
        return this.d;
    }

    public void g(PhotoInfoNumber photoInfoNumber) {
        this.c = photoInfoNumber;
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
        boolean bl6 = 11 != 0;
        boolean bl7 = this.b();
        bl2 = bl7 ? byArray2[bl5] : byArray2[0];
        if (bl6 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray2 = null;
        }
        if (bl2 && (bl2 = byArray[bl5]) == bl5) {
            this.c = object = PhotoInfoNumber.from(byArray[2]);
            bl2 = byArray.length;
            int n10 = 3;
            Charset charset = Charset.forName("utf-8");
            object = new String(byArray, n10, (int)((bl2 -= n10) ? 1 : 0), charset);
            this.d = object;
            return bl5;
        }
        return false;
    }
}

