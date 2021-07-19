/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

public class t {
    private final int a;
    private final short b;
    private final short c;
    private final short d;
    private final short e;
    private final short f;
    private final short g;
    private final int h;

    public t(int n10, short s10, short s11, short s12, short s13, short s14, short s15, int n11) {
        this.a = n10;
        this.b = s10;
        this.c = s11;
        this.d = s12;
        this.e = s13;
        this.f = s14;
        this.g = s15;
        this.h = n11;
    }

    public short a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public short c() {
        return this.g;
    }

    public short d() {
        return this.f;
    }

    public short e() {
        return this.e;
    }

    public short f() {
        return this.c;
    }

    public short g() {
        return this.b;
    }

    public int h() {
        return this.h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InfoData{deviceId=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", pageSize=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", pageNums=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", blVersion=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", mechanic=");
        n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", hwVersion=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", fwVersion=");
        n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append(", sn=");
        n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

