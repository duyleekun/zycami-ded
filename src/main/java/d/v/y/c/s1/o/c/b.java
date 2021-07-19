/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.device.CameraBrand;
import d.v.y.c.s1.o.e.a;

public class b
extends d.v.y.c.s1.o.b {
    private static final int e = 0;
    private static final int f = 128;
    public static final int g = 11;
    public static final int h = 6;
    private boolean c;
    private CameraBrand d;

    public b() {
        this.clear();
    }

    /*
     * WARNING - void declaration
     */
    public byte[] a() {
        void var2_6;
        WifiDevice wifiDevice = this.b;
        boolean by2 = this.b();
        byte by3 = a.a(11, wifiDevice, by2);
        boolean bl2 = this.c;
        if (bl2) {
            boolean bl3 = false;
        } else {
            int n10 = 128;
        }
        byte by4 = (byte)var2_6;
        byte by5 = (byte)CameraBrand.to(this.d);
        boolean bl4 = this.b();
        byte by6 = d.v.y.d.b.m(by4, by5, bl4);
        byte[] byArray = new byte[]{by3, 6, by6};
        return byArray;
    }

    public void clear() {
        CameraBrand cameraBrand;
        this.c = false;
        this.d = cameraBrand = CameraBrand.ERROR;
    }

    public CameraBrand f() {
        return this.d;
    }

    public void g(CameraBrand cameraBrand) {
        this.d = cameraBrand;
    }

    public void h(boolean bl2) {
        this.c = bl2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] object) {
        int n10;
        void var3_7;
        WifiDevice wifiDevice;
        Object bl2 = object[0];
        boolean bl3 = this.b();
        byte[] byArray = a.b((byte)bl2, bl3);
        boolean bl4 = this.b();
        boolean bl5 = true;
        if (bl4) {
            byte by2 = byArray[0];
        } else {
            byte by3 = byArray[bl5];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var3_7);
        int n11 = 11;
        boolean bl6 = this.b();
        bl2 = bl6 ? (Object)byArray[bl5] : (Object)byArray[0];
        if (n11 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2 != false && (bl2 = object[bl5]) == (n10 = 6)) {
            object = CameraBrand.from((int)object[2]);
            this.d = (CameraBrand)((Object)object);
            return bl5;
        }
        return false;
    }
}

