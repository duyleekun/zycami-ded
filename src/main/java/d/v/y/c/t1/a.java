/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.t1;

import d.v.y.c.y;
import d.v.y.d.b;

public class a
implements y {
    private int a;
    private boolean b = true;

    public byte[] a() {
        int n10 = this.a;
        boolean bl2 = this.b;
        return d.v.y.d.b.r(n10, 2, bl2);
    }

    public boolean b() {
        return this.b;
    }

    public void c(boolean bl2) {
        this.b = bl2;
    }

    public void clear() {
        this.a = 0;
        this.b = true;
    }

    public int d() {
        return this.a;
    }

    public void e(int n10) {
        this.a = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        byte by2 = byArray[0];
        boolean bl2 = true;
        int n10 = byArray[bl2];
        boolean bl3 = this.b;
        this.a = n10 = d.v.y.d.b.w(by2, (byte)n10, bl3);
        return bl2;
    }
}

