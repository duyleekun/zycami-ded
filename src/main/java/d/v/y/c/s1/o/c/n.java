/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.c.s1.o.e.a;

public class n
extends b {
    private final int c;
    private boolean d;

    public n() {
        this.c = 4;
    }

    public byte[] a() {
        WifiDevice wifiDevice = this.b;
        boolean bl2 = this.b();
        byte by2 = a.a(4, wifiDevice, bl2);
        byte[] byArray = new byte[]{by2, by2 = (byte)(this.d ? 1 : 0)};
        return byArray;
    }

    public void clear() {
        this.d = false;
    }

    public boolean f() {
        return this.d;
    }

    public void g(boolean bl2) {
        this.d = bl2;
    }

    public boolean parseFrom(byte[] byArray) {
        WifiDevice wifiDevice;
        boolean bl2 = false;
        byte by2 = byArray[0];
        byte by3 = this.b();
        byArray = a.b(by2, by3 != 0);
        by3 = this.b();
        boolean bl3 = true;
        by3 = by3 != 0 ? byArray[0] : byArray[bl3];
        this.b = wifiDevice = WifiDevice.toDevice(by3);
        by3 = 4;
        boolean bl4 = this.b();
        by2 = bl4 ? byArray[bl3] : byArray[0];
        if (by3 == by2) {
            bl2 = bl3;
        }
        return bl2;
    }
}

