/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.b;

import d.v.y.b.a;

public class g {
    public static a a(int n10) {
        a a10 = new a(n10);
        return a10;
    }

    public static int b(int n10, int n11, int n12) {
        n10 = n10 << 8 & 0xF00;
        return n10 | (n11 <<= 4) | n12;
    }

    public static int c(int n10, int n11) {
        return g.b(n10, 3, n11);
    }

    public static int d(int n10, int n11) {
        return g.b(n10, 1, n11);
    }

    public static int e(int n10, int n11) {
        return g.b(n10, 2, n11);
    }
}

