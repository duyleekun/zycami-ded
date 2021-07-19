/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.f;

import d.v.y.d.b;
import d.v.y.d.h;

public class a
extends d.v.y.c.s1.a {
    private byte b;
    private int c;
    private int d;

    public byte[] a() {
        int n10;
        this.d = n10 = this.d & 0xF0FF;
        n10 = (byte)h.c(n10);
        h.a(this.d);
        byte by2 = (byte)h.d(this.d);
        byte[] byArray = new byte[6];
        int n11 = this.b;
        byArray[0] = n11;
        n11 = (int)(this.b() ? 1 : 0);
        int n12 = 1;
        byArray[n12] = n11 = d.v.y.d.b.n((byte)n12, (byte)0, n12 != 0, n11 != 0);
        n11 = 2;
        byArray[n11] = by2;
        byArray[3] = n10;
        n10 = this.c;
        by2 = (byte)(this.b() ? 1 : 0);
        byte[] byArray2 = d.v.y.d.b.r(n10, n11, by2 != 0);
        byArray[4] = by2 = byArray2[0];
        byArray[5] = n10 = byArray2[n12];
        return byArray;
    }

    public void clear() {
        this.b = 0;
        this.d = 0;
        this.c = 0;
    }

    public byte d() {
        return this.b;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.c;
    }

    public void g(byte by2) {
        this.b = by2;
    }

    public void h(int n10) {
        this.d = n10;
    }

    public void i(int n10) {
        this.c = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        boolean bl2 = byArray.length;
        boolean by2 = false;
        boolean bl3 = 6 != 0;
        if (bl2 >= bl3) {
            int n10;
            bl2 = (byArray[0] & 0xFF) != 0;
            this.b = (byte)(bl2 ? 1 : 0);
            bl2 = true;
            byte by3 = byArray[bl2];
            byte by4 = this.b();
            int n11 = 2;
            byte[] byArray2 = d.v.y.d.b.r(by3, n11, by4 != 0);
            by4 = byArray2[0];
            byte by6 = byArray2[bl2];
            by6 = byArray[n11];
            this.d = n10 = h.h(byArray[3], 0, by6);
            byte by7 = byArray[4];
            int n12 = byArray[5];
            boolean bl4 = this.b();
            this.c = n12 = d.v.y.d.b.w(by7, (byte)n12, bl4);
            return bl2;
        }
        return false;
    }
}

