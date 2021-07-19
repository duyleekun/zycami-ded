/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.e;

import com.zhiyun.protocol.message.bl.active.ActiveState;
import d.v.y.c.s1.a;
import d.v.y.c.s1.e.b;

public class e
extends a {
    private int b;
    private int c;
    private int d;
    private byte[] e;
    private ActiveState f;
    private b g;

    public byte[] a() {
        byte[] byArray = new byte[]{19};
        return byArray;
    }

    public void clear() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.d;
    }

    public byte[] f() {
        return this.e;
    }

    public ActiveState g() {
        return this.f;
    }

    public int h() {
        return this.c;
    }

    public void i(b b10) {
        this.g = b10;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n102 = byArray.length;
        boolean bl2 = false;
        int n11 = 16;
        if (n102 < n11) {
            return false;
        }
        n102 = byArray[0];
        n11 = 19;
        if (n102 != n11) {
            return false;
        }
        Object object = this.g;
        n11 = 1;
        byArray = d.v.y.d.a.d(byArray, n11);
        if ((byArray = object.b(byArray)) == null) {
            return false;
        }
        object = ActiveState.from(byArray[0]);
        this.f = object;
        object = d.v.y.d.a.e(byArray, n11, 11);
        this.e = (byte[])object;
        n102 = byArray[12];
        int n12 = byArray[13];
        boolean bl3 = this.b();
        n102 = d.v.y.d.b.y((byte)n102, (byte)n12, bl3);
        this.c = n12 = n102 >>> 9;
        if (n12 > 0) {
            n10 = n12 + 2000;
        }
        this.c = n10;
        this.d = n102 &= 0x1FF;
        n102 = byArray[14];
        short s10 = byArray[15];
        boolean bl4 = this.b();
        s10 = d.v.y.d.b.y((byte)n102, (byte)s10, bl4);
        this.b = s10;
        return n11 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CheckActiveInfoBody{crc=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", year=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", day=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", randomData='");
        Object object = d.v.y.d.a.h(this.e);
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", state=");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

