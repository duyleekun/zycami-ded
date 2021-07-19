/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.d;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;
import d.v.y.c.s1.o.b;
import d.v.y.d.a;
import d.v.y.d.f;
import d.v.y.d.k;

public class c
extends b {
    private static final int d = 10;
    private static final int e;
    private int[] c;

    public c() {
        int[] nArray = a.c();
        this.c = nArray;
    }

    private int[] g(String stringArray) {
        String string2;
        int[] nArray = a.c();
        int n10 = k.a((String)stringArray);
        if (n10 != 0 && (n10 = (stringArray = stringArray.split(string2 = ",")).length) > 0) {
            int n11;
            int n12 = stringArray.length;
            nArray = new int[n12];
            string2 = null;
            for (n10 = 0; n10 < (n11 = stringArray.length); ++n10) {
                String string3 = stringArray[n10];
                nArray[n10] = n11 = f.c(string3);
            }
        }
        return nArray;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        Object object = this.b;
        boolean bl2 = this.b();
        byArray[0] = by2 = d.v.y.c.s1.o.e.a.a(10, object, bl2);
        object = new byte[n10];
        object[0] = (WifiDevice)false;
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = (byte[])object;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        int[] nArray = a.c();
        this.c = nArray;
    }

    public int[] f() {
        return this.c;
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
        n12 = 10;
        boolean bl2 = this.b();
        n11 = bl2 ? byArray[n13] : byArray[0];
        if (n12 == n11) {
            n11 = n13;
        } else {
            n11 = 0;
            byArray = null;
        }
        if (n11 != 0) {
            n10 = ((byte[])object).length;
            n11 = 2;
            object = k.e(object, n11, n10 -= n11);
            object = this.g((String)object);
            this.c = object;
            return n13 != 0;
        }
        return false;
    }
}

