/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.h;

public final class g {
    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    public static final g h;
    private final int[] i;
    private final int[] j;
    private final h k;
    private final h l;
    private final int m;
    private final int n;
    private final int o;

    static {
        g g10;
        g g11;
        int n10 = 1;
        a = g11 = new g(4201, 4096, n10);
        b = g11 = new g(1033, 1024, n10);
        c = g11 = new g(67, 64, n10);
        d = g10 = new g(19, 16, n10);
        int n11 = 256;
        e = g10 = new g(285, n11, 0);
        f = g10 = new g(301, n11, n10);
        g = g10;
        h = g11;
    }

    public g(int n10, int n11, int n12) {
        int n13;
        this.n = n10;
        this.m = n11;
        this.o = n12;
        int[] nArray = new int[n11];
        this.i = nArray;
        nArray = new int[n11];
        this.j = nArray;
        n12 = 0;
        nArray = null;
        int n14 = 1;
        int[] nArray2 = null;
        int n15 = n14;
        for (n13 = 0; n13 < n11; ++n13) {
            int[] nArray3 = this.i;
            nArray3[n13] = n15;
            if ((n15 *= 2) < n11) continue;
            n15 ^= n10;
            int n16 = n11 + -1;
            n15 &= n16;
        }
        n10 = 0;
        h h10 = null;
        while (n10 < (n13 = n11 + -1)) {
            nArray2 = this.j;
            int[] nArray4 = this.i;
            n15 = nArray4[n10];
            nArray2[n15] = n10++;
        }
        int[] nArray5 = new int[n14];
        nArray5[0] = 0;
        this.k = h10 = new h(this, nArray5);
        nArray5 = new int[n14];
        nArray5[0] = n14;
        this.l = h10 = new h(this, nArray5);
    }

    public static int b(int n10, int n11) {
        return n10 ^ n11;
    }

    public int a(int n10) {
        return this.i[n10];
    }

    public h a() {
        return this.k;
    }

    public h a(int n10, int n11) {
        if (n10 >= 0) {
            if (n11 == 0) {
                return this.k;
            }
            int[] nArray = new int[n10 + 1];
            nArray[0] = n11;
            h h10 = new h(this, nArray);
            return h10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public int b() {
        return this.o;
    }

    public int b(int n10) {
        if (n10 != 0) {
            return this.j[n10];
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public int c(int n10) {
        if (n10 != 0) {
            int[] nArray = this.i;
            int n11 = this.m;
            n10 = this.j[n10];
            n11 = n11 - n10 + -1;
            return nArray[n11];
        }
        ArithmeticException arithmeticException = new ArithmeticException();
        throw arithmeticException;
    }

    public int c(int n10, int n11) {
        if (n10 != 0 && n11 != 0) {
            int[] nArray = this.i;
            int[] nArray2 = this.j;
            n10 = nArray2[n10];
            n11 = nArray2[n11];
            n10 += n11;
            n11 = this.m + -1;
            return nArray[n10 %= n11];
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GF(0x");
        String string2 = Integer.toHexString(this.n);
        stringBuilder.append(string2);
        stringBuilder.append(',');
        int n10 = this.m;
        stringBuilder.append(n10);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

