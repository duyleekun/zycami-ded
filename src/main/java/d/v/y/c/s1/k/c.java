/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.k;

import com.zhiyun.protocol.message.bl.otherevent.DeviceType;
import d.v.y.c.s1.k.e;
import d.v.y.d.a;

public class c
extends e {
    private static final int e = 0;
    private static final int f = 128;
    private boolean b;
    private DeviceType c;
    private byte d = 0;

    public c() {
        this.clear();
    }

    public byte[] a() {
        byte[][] byArrayArray;
        int n10 = this.b;
        if (n10 != 0) {
            n10 = -128;
        } else {
            n10 = 0;
            byArrayArray = null;
        }
        this.d = (byte)n10;
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = 9;
        byte[] byArray2 = new byte[2];
        byArray2[0] = n10;
        byArray2[n11] = n10 = (int)((byte)this.c.value);
        byArrayArray = new byte[n11][];
        byArrayArray[0] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        DeviceType deviceType;
        this.c = deviceType = DeviceType.CAMERA;
    }

    public DeviceType d() {
        return this.c;
    }

    public void e(DeviceType deviceType) {
        this.c = deviceType;
    }

    public void f(boolean bl2) {
        this.b = bl2;
    }

    public boolean parseFrom(byte[] object) {
        int n10 = 0;
        int n11 = 9;
        int n12 = object[0];
        if (n11 == n12) {
            n10 = 1;
            this.d = n12 = object[n10];
            n12 = 2;
            byte by2 = object[n12];
            object = (Object)DeviceType.toDeviceType(by2);
            this.c = (DeviceType)((Object)object);
        }
        return n10 != 0;
    }
}

