/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import com.zhiyun.protocol.message.bl.wifi.hotspot.Channel;
import com.zhiyun.protocol.message.bl.wifi.hotspot.Channel$Status;
import d.v.y.c.s1.o.b;
import d.v.y.d.a;
import d.v.y.d.f;
import d.v.y.d.k;
import java.util.ArrayList;
import java.util.List;

public class d
extends b {
    private static final int f = 11;
    private static final int g = 0;
    private static final int h = 1;
    private boolean c = true;
    private List d;
    private boolean e;

    public d() {
        ArrayList arrayList;
        this.d = arrayList = new ArrayList();
    }

    private List i(String stringArray) {
        boolean bl2 = k.a((String)stringArray);
        if (!bl2) {
            return this.d;
        }
        bl2 = false;
        stringArray = k.g((String)stringArray, '\u0000');
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = ",,,";
            Object object2 = stringArray[i10];
            int n11 = object.equals(object2);
            if (n11 != 0) continue;
            object2 = object2.split(",");
            n11 = d.v.y.d.f.c(object2[0]);
            object = Channel$Status.from(n11);
            String string2 = object2[1];
            int n12 = d.v.y.d.f.c(string2);
            int n13 = 2;
            object2 = object2[n13];
            int n14 = d.v.y.d.f.c((String)object2);
            List list = this.d;
            Channel channel = new Channel(n12, (Channel$Status)((Object)object), n14);
            list.add(channel);
        }
        return this.d;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        Object object = this.b;
        boolean bl2 = this.b();
        byArray[0] = by2 = d.v.y.c.s1.o.e.a.a(11, object, bl2);
        object = new byte[n10];
        byte by3 = (byte)(this.c ^ n10);
        object[0] = (WifiDevice)by3;
        byte[] byArray2 = k.h("\u0000");
        byte[][] byArrayArray = new byte[2][];
        byArrayArray[0] = (byte[])object;
        byArrayArray[n10] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.c = true;
        this.d.clear();
    }

    public boolean f() {
        return this.e;
    }

    public List g() {
        return this.d;
    }

    public boolean h() {
        return this.c;
    }

    public void j(boolean bl2) {
        this.c = bl2;
    }

    public boolean parseFrom(byte[] object) {
        WifiDevice wifiDevice;
        int n10 = 0;
        int n11 = object[0];
        int n12 = this.b();
        byte[] byArray = d.v.y.c.s1.o.e.a.b((byte)n11, n12 != 0);
        n12 = this.b();
        int n13 = 1;
        n12 = n12 != 0 ? byArray[0] : byArray[n13];
        this.b = wifiDevice = WifiDevice.toDevice(n12);
        n12 = 11;
        boolean bl2 = this.b();
        n11 = bl2 ? byArray[n13] : byArray[0];
        if (n12 == n11) {
            n11 = n13;
        } else {
            n11 = 0;
            byArray = null;
        }
        if (n11) {
            n11 = object[n13];
            if (!n11) {
                n11 = n13;
            } else {
                n11 = 0;
                byArray = null;
            }
            this.c = n11;
            n11 = ((byte[])object).length;
            n12 = 2;
            object = k.e(object, n12, n11 -= n12);
            n11 = (int)(this.c ? 1 : 0);
            if (n11) {
                int n14 = d.v.y.d.f.c((String)object);
                if (n14 == n13) {
                    n10 = n13;
                }
                this.e = n10;
            } else {
                object = this.i((String)object);
                this.d = object;
            }
            return n13 != 0;
        }
        return false;
    }
}

