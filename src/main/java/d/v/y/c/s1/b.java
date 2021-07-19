/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1;

import d.v.y.c.e0;

public class b
implements e0 {
    public static final int i = 15396;
    public static final int j = 15908;
    private int a = 15396;
    private int b;
    private int c;
    private int d;
    private byte e = (byte)8;
    private byte f = 1;
    private int g;
    private boolean h = false;

    public byte[] a() {
        byte by2;
        byte by3;
        byte by4;
        byte by5;
        byte by6;
        boolean bl2;
        int by22 = this.a;
        boolean bl3 = this.h;
        int n10 = 2;
        byte[] byArray = d.v.y.d.b.r(by22, n10, bl3);
        int n11 = this.d;
        boolean bl4 = this.h;
        byte[] byArray2 = d.v.y.d.b.r(n11, n10, bl4);
        byte[] byArray3 = new byte[6];
        byArray3[0] = bl2 = byArray[0];
        bl2 = true;
        byArray3[bl2] = by6 = byArray[bl2];
        byArray3[n10] = by5 = byArray2[0];
        byArray3[3] = by4 = byArray2[bl2];
        byte by7 = this.e;
        byte by8 = this.f;
        boolean bl5 = this.h;
        byArray3[4] = by3 = d.v.y.d.b.n(by7, by8, bl2, bl5);
        byArray3[5] = by2 = (byte)this.g;
        return byArray3;
    }

    public void b(int n10) {
        this.d = n10;
    }

    public int c() {
        return this.d;
    }

    public void clear() {
        this.a = 15396;
        this.d = 0;
        this.g = 0;
    }

    public void d(int n10) {
        this.b = n10;
    }

    public int e() {
        return this.b;
    }

    public byte f() {
        return this.f;
    }

    public int g() {
        return this.a;
    }

    public byte h() {
        return this.e;
    }

    public int i() {
        return this.g;
    }

    public boolean j() {
        return this.h;
    }

    public void k(byte by2) {
        this.f = by2;
    }

    public void l(boolean bl2) {
        this.h = bl2;
    }

    public void m(int n10) {
        this.a = n10;
    }

    public void n(byte by2) {
        this.e = by2;
    }

    public void o(int n10) {
        this.g = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n11;
        byte by2 = 0;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 6)) {
            int n12;
            n11 = byArray[0];
            int n13 = 1;
            boolean bl2 = byArray[n13];
            boolean bl3 = this.h;
            this.a = n11 = d.v.y.d.b.w((byte)n11, (byte)(bl2 ? 1 : 0), bl3);
            n11 = byArray[2];
            bl2 = byArray[3];
            bl3 = this.h;
            this.d = n11 = d.v.y.d.b.y((byte)n11, (byte)(bl2 ? 1 : 0), bl3) - n13 - n13;
            n11 = byArray[4];
            bl2 = this.h;
            byte[] byArray2 = d.v.y.d.b.p((byte)n11, bl2);
            this.e = by2 = byArray2[0];
            this.f = by2 = byArray2[n13];
            this.g = n12 = byArray[5];
            this.b = n10;
            this.c = n10;
            return n13 != 0;
        }
        return false;
    }
}

