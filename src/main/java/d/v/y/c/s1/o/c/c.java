/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.d.a;
import java.nio.charset.Charset;

public class c
extends b {
    private final int c;
    private String d;
    private String e;

    public c() {
        this.c = 5;
    }

    public byte[] a() {
        Object object = this.b;
        boolean bl2 = this.b();
        byte by2 = d.v.y.c.s1.o.e.a.a(5, object, bl2);
        Object object2 = Charset.forName("utf-8");
        byte[] byArray = this.d.getBytes((Charset)object2);
        int n10 = 1;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = 0;
        object2 = this.e.getBytes((Charset)object2);
        byte[] byArray3 = new byte[n10];
        byArray3[0] = by2;
        object = new byte[4][];
        object[0] = (WifiDevice)byArray;
        object[n10] = (WifiDevice)byArray2;
        object[2] = object2;
        object[3] = (WifiDevice)byArray2;
        return a.a(byArray3, (byte[][])object);
    }

    public void clear() {
        this.d = null;
        this.e = null;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.d;
    }

    public void h(String string2) {
        this.e = string2;
    }

    public void i(String string2) {
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
        by3 = 5;
        boolean bl4 = this.b();
        by2 = bl4 ? byArray[bl3] : byArray[0];
        if (by3 == by2) {
            bl2 = bl3;
        }
        return bl2;
    }
}

