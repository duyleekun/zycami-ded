/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.d.a;
import java.nio.charset.Charset;

public class d
extends b {
    private final int c;
    private String d;

    public d() {
        this.c = 6;
    }

    public byte[] a() {
        Object object = this.b;
        boolean n10 = this.b();
        byte by2 = d.v.y.c.s1.o.e.a.a(6, object, n10);
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = by2;
        object = this.d;
        Charset charset = Charset.forName("utf-8");
        object = ((String)object).getBytes(charset);
        byte[][] byArrayArray = new byte[n11][];
        byArrayArray[0] = (byte[])object;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.d = null;
    }

    public String f() {
        return this.d;
    }

    public void g(String string2) {
        this.d = string2;
    }

    public boolean parseFrom(byte[] byArray) {
        WifiDevice wifiDevice;
        boolean bl2 = false;
        byte by2 = byArray[0];
        byte by3 = this.b();
        byArray = d.v.y.c.s1.o.e.a.b(by2, by3 != 0);
        by3 = this.b();
        boolean bl3 = true;
        by3 = by3 != 0 ? byArray[0] : byArray[bl3];
        this.b = wifiDevice = WifiDevice.toDevice(by3);
        by3 = 6;
        boolean bl4 = this.b();
        by2 = bl4 ? byArray[bl3] : byArray[0];
        if (by3 == by2) {
            bl2 = bl3;
        }
        return bl2;
    }
}

