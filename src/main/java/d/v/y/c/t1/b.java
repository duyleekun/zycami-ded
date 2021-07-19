/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.t1;

import d.v.y.c.e0;
import d.v.y.d.h;

public class b
implements e0 {
    public static final byte e = 6;
    private boolean a = true;
    private int b;
    private int c;
    private int d;

    private boolean g(byte[] byArray) {
        boolean bl2;
        boolean bl3;
        byte by2 = 0;
        if (byArray != null && (bl3 = byArray.length) >= (bl2 = 7 != 0)) {
            bl3 = true;
            bl2 = byArray[bl3];
            byte by3 = this.a;
            int n10 = 2;
            bl2 = d.v.y.d.b.r((int)(bl2 ? 1 : 0), n10, by3 != 0)[bl3];
            by3 = byArray[bl3];
            boolean bl4 = this.a;
            by2 = d.v.y.d.b.r(by3, n10, bl4)[0];
            int n11 = byArray[n10];
            this.d = n11 = h.h((int)(bl2 ? 1 : 0), by2, n11);
            this.b = 3;
            this.c = n10;
            return bl3;
        }
        return false;
    }

    private boolean h(byte[] byArray) {
        boolean bl2;
        boolean bl3;
        byte by2 = 0;
        byte[] byArray2 = null;
        if (byArray != null && (bl3 = byArray.length) >= (bl2 = 4 != 0)) {
            bl3 = byArray[0];
            bl2 = this.a;
            bl3 = d.v.y.d.b.p((byte)(bl3 ? 1 : 0), bl2)[0];
            by2 = byArray[0];
            bl2 = this.a;
            byArray2 = d.v.y.d.b.p(by2, bl2);
            bl2 = true;
            by2 = byArray2[bl2];
            int n10 = byArray[bl2];
            this.d = n10 = h.h((int)(bl3 ? 1 : 0), by2, n10);
            this.b = n10 = 2;
            this.c = n10;
            return bl2;
        }
        return false;
    }

    public byte[] a() {
        byte by2 = (byte)h.c(this.d);
        byte by3 = (byte)h.a(this.d);
        byte by4 = (byte)h.d(this.d);
        byte[] byArray = new byte[3];
        byArray[0] = 6;
        boolean bl2 = this.a;
        byArray[1] = by2 = d.v.y.d.b.m(by2, by3, bl2);
        byArray[2] = by4;
        return byArray;
    }

    public void b(int n10) {
        this.c = n10;
    }

    public int c() {
        return this.c;
    }

    public void clear() {
        this.d = 0;
        this.b = 0;
        this.c = 0;
        this.a = true;
    }

    public void d(int n10) {
        this.b = n10;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.d;
    }

    public void i(int n10) {
        this.d = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        boolean bl2;
        boolean bl3 = this.g(byArray);
        if (!bl3 && !(bl2 = this.h(byArray))) {
            bl2 = false;
            byArray = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

