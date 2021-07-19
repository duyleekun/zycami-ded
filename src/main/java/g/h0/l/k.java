/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.x1.n;
import g.h0.l.k$a;

public final class k {
    public static final int c = 65535;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
    public static final int j = 10;
    public static final k$a k;
    private int a;
    private final int[] b;

    static {
        k$a k$a;
        k = k$a = new k$a(null);
    }

    public k() {
        int[] nArray = new int[10];
        this.b = nArray;
    }

    public final void a() {
        this.a = 0;
        n.u2(this.b, 0, 0, 0, 6, null);
    }

    public final int b(int n10) {
        return this.b[n10];
    }

    /*
     * WARNING - void declaration
     */
    public final boolean c(boolean bl2) {
        void var1_5;
        int n10 = this.a & 4;
        int n11 = 1;
        if (n10 != 0) {
            int[] nArray = this.b;
            n10 = 2;
            int n12 = nArray[n10];
            if (n12 == n11) {
                int n13 = n11;
            } else {
                boolean bl3 = false;
                nArray = null;
            }
        }
        return (boolean)var1_5;
    }

    public final int d() {
        int n10 = this.a & 2;
        if (n10 != 0) {
            int[] nArray = this.b;
            int n11 = 1;
            n10 = nArray[n11];
        } else {
            n10 = -1;
        }
        return n10;
    }

    public final int e() {
        int n10 = this.a & 0x80;
        if (n10 != 0) {
            int[] nArray = this.b;
            int n11 = 7;
            n10 = nArray[n11];
        } else {
            n10 = (char)-1;
        }
        return n10;
    }

    public final int f() {
        int n10 = this.a & 0x10;
        if (n10 != 0) {
            int[] nArray = this.b;
            int n11 = 4;
            n10 = nArray[n11];
        } else {
            n10 = -1 >>> 1;
        }
        return n10;
    }

    public final int g(int n10) {
        int n11 = this.a & 0x20;
        if (n11 != 0) {
            int[] nArray = this.b;
            n11 = 5;
            n10 = nArray[n11];
        }
        return n10;
    }

    public final int h(int n10) {
        int n11 = this.a & 0x40;
        if (n11 != 0) {
            int[] nArray = this.b;
            n11 = 6;
            n10 = nArray[n11];
        }
        return n10;
    }

    public final boolean i(int n10) {
        int n11 = 1;
        n10 = n11 << n10;
        int n12 = this.a;
        if ((n10 &= n12) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public final void j(k k10) {
        int n10;
        f0.p(k10, "other");
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            n10 = (int)(k10.i(i10) ? 1 : 0);
            if (n10 == 0) continue;
            n10 = k10.b(i10);
            this.k(i10, n10);
        }
    }

    public final k k(int n10, int n11) {
        int[] nArray;
        int n12;
        if (n10 >= 0 && n10 < (n12 = (nArray = this.b).length)) {
            n12 = 1 << n10;
            int n13 = this.a;
            this.a = n12 |= n13;
            nArray[n10] = n11;
        }
        return this;
    }

    public final int l() {
        return Integer.bitCount(this.a);
    }
}

