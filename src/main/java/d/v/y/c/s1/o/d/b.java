/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.ChannelMode;
import d.v.y.d.a;
import d.v.y.d.f;
import d.v.y.d.k;

public class b
extends d.v.y.c.s1.o.b {
    private static final int f = 9;
    private static final int g = 255;
    private boolean c;
    private ChannelMode d;
    private int e;

    public b() {
        ChannelMode channelMode;
        this.d = channelMode = ChannelMode.UNKNOWN;
        this.e = -1;
    }

    public byte[] a() {
        Object object;
        int n10;
        int n11 = 1;
        byte[] byArray = new byte[n11];
        Object object2 = this.b;
        boolean bl2 = this.b();
        byte by2 = d.v.y.c.s1.o.e.a.a(9, object2, bl2);
        bl2 = false;
        byArray[0] = by2;
        object2 = new byte[n11];
        byte by3 = (byte)(this.c ? 1 : 0);
        object2[0] = (WifiDevice)by3;
        byte[] byArray2 = new byte[n11];
        Object object3 = this.d;
        byArray2[0] = n10 = (int)ChannelMode.toCode((ChannelMode)((Object)object3));
        n10 = this.e;
        int n12 = -1;
        if (n10 == n12) {
            object3 = "\u0000";
        } else {
            object3 = new StringBuilder();
            n12 = this.e;
            ((StringBuilder)object3).append(n12);
            object = "";
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
        }
        object3 = k.h((String)object3);
        object = new byte[3][];
        object[0] = (byte[])object2;
        object[n11] = byArray2;
        object[2] = (byte[])object3;
        return a.a(byArray, object);
    }

    public void clear() {
        ChannelMode channelMode;
        this.c = false;
        this.d = channelMode = ChannelMode.UNKNOWN;
        this.e = -1;
    }

    public int f() {
        return this.e;
    }

    public ChannelMode g() {
        return this.d;
    }

    public boolean h() {
        int n10 = this.e;
        int n11 = -1;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean i() {
        return this.c;
    }

    public void j(int n10) {
        this.e = n10;
    }

    public void k(ChannelMode channelMode) {
        this.d = channelMode;
    }

    public void l(boolean bl2) {
        this.c = bl2;
    }

    public boolean parseFrom(byte[] object) {
        WifiDevice wifiDevice;
        int n10 = 0;
        ChannelMode channelMode = null;
        int n11 = object[0];
        int n12 = this.b();
        byte[] byArray = d.v.y.c.s1.o.e.a.b((byte)n11, n12 != 0);
        n12 = this.b();
        int n13 = 1;
        n12 = n12 != 0 ? byArray[0] : byArray[n13];
        this.b = wifiDevice = WifiDevice.toDevice(n12);
        n12 = 9;
        boolean bl2 = this.b();
        n11 = bl2 ? byArray[n13] : byArray[0];
        if (n12 == n11) {
            n11 = n13;
        } else {
            n11 = 0;
            byArray = null;
        }
        if (n11 != 0) {
            int n14;
            n11 = object[n13];
            if (n11 == n13) {
                n10 = n13;
            }
            this.c = n10;
            this.d = channelMode = ChannelMode.toStatus(object[2]);
            n10 = ((byte[])object).length;
            n11 = 3;
            object = k.e(object, n11, n10 -= n11);
            this.e = n14 = d.v.y.d.f.c((String)object);
        }
        return n13 != 0;
    }
}

