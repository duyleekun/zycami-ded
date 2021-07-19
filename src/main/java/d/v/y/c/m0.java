/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.p;
import d.v.y.c.s1.o.a;
import d.v.y.c.s1.o.b;
import d.v.y.d.d;

public class m0
extends p {
    private static final WifiDevice d = WifiDevice.CARENA3;

    public m0(b b10) {
        a a10 = new a();
        super(a10, b10);
        ((d.v.y.c.s1.b)this.g()).o(23);
        ((d.v.y.c.s1.b)this.g()).l(false);
        b10 = (b)this.f();
        WifiDevice wifiDevice = d;
        b10.e(wifiDevice);
        ((b)this.f()).c(false);
    }

    public byte[] h(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = 4;
        byArray = d.v.y.d.a.e(byArray, n11, n10 -= n11);
        byte[][] byArrayArray = new byte[][]{byArray2};
        int n12 = d.v.y.d.d.a(d.v.y.d.a.a(byArray, byArrayArray));
        boolean bl2 = ((b)this.f()).b();
        return d.v.y.d.b.r(n12, 2, bl2);
    }

    public boolean parseFrom(byte[] object) {
        WifiDevice wifiDevice;
        boolean bl2 = super.parseFrom((byte[])object);
        if (bl2 && (object = (Object)((Object)((b)this.f()).d())) == (wifiDevice = d)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

