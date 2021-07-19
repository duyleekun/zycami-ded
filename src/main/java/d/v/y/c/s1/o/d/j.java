/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;
import d.v.y.c.s1.o.b;
import d.v.y.d.a;
import d.v.y.d.k;
import java.util.Objects;

public class j
extends b {
    private static final int e = 8;
    private HotspotStatus c;
    private String d;

    public byte[] a() {
        byte by2;
        Objects.requireNonNull(this.d);
        int n10 = 1;
        byte[] byArray = new byte[n10];
        Object object = this.b;
        boolean bl2 = this.b();
        byArray[0] = by2 = d.v.y.c.s1.o.e.a.a(8, object, bl2);
        object = new StringBuilder();
        String string2 = this.d;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("\u0000");
        object = k.h(((StringBuilder)object).toString());
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = (byte[])object;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.c = null;
        this.d = null;
    }

    public HotspotStatus f() {
        return this.c;
    }

    public HotspotStatus g() {
        return this.c;
    }

    public void h(String string2) {
        Objects.requireNonNull(string2);
        this.d = string2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean parseFrom(byte[] object) {
        void var3_7;
        WifiDevice wifiDevice;
        Object bl2 = object[0];
        boolean bl3 = this.b();
        byte[] byArray = d.v.y.c.s1.o.e.a.b((byte)bl2, bl3);
        boolean bl4 = this.b();
        boolean bl5 = true;
        if (bl4) {
            byte by2 = byArray[0];
        } else {
            byte by3 = byArray[bl5];
        }
        this.b = wifiDevice = WifiDevice.toDevice((int)var3_7);
        int n10 = 8;
        boolean bl6 = this.b();
        bl2 = bl6 ? (Object)byArray[bl5] : (Object)byArray[0];
        if (n10 == bl2) {
            bl2 = bl5;
        } else {
            bl2 = false;
            byArray = null;
        }
        if (bl2 != false) {
            object = HotspotStatus.toStatus((int)object[bl5]);
            this.c = (HotspotStatus)((Object)object);
            return bl5;
        }
        return false;
    }
}

