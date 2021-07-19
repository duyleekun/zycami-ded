/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

public class b {
    public static byte a(byte by2) {
        return (byte)(by2 & 0xF);
    }

    public static byte b(byte by2) {
        return (byte)(by2 >> 4);
    }

    public static boolean c(int n10, int n11) {
        int n12 = 1;
        if ((n10 &= (n11 = n12 << n11)) != n11) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static byte d(int n10) {
        return (byte)n10;
    }

    public static byte e(int n10) {
        return (byte)(n10 >> 8);
    }

    public static byte f(int n10) {
        return (byte)(n10 >> 16);
    }

    public static byte g(int n10) {
        return (byte)(n10 >> 24);
    }

    private static byte h(byte by2, byte by3) {
        by2 = (byte)(by2 & 0xFF);
        by3 = (byte)(by3 & 0xFF);
        return (byte)(by2 | by3);
    }

    private static int i(byte by2, byte by3) {
        by2 = (byte)((by2 & 0xFF) << 8);
        by3 = (byte)(by3 & 0xFF);
        return by2 | by3;
    }

    private static int j(byte by2, byte by3, byte by4) {
        by2 = (byte)((by2 & 0xFF) << 16);
        by3 = (byte)((by3 & 0xFF) << 8);
        by2 = (byte)(by2 | by3);
        by3 = (byte)(by4 & 0xFF);
        return by2 | by3;
    }

    private static int k(byte by2, byte by3, byte by4, byte by5) {
        by2 = (byte)(by2 << 24);
        by3 = (byte)((by3 & 0xFF) << 16);
        by2 = (byte)(by2 | by3);
        by3 = (byte)((by4 & 0xFF) << 8);
        by2 = (byte)(by2 | by3);
        by3 = (byte)(by5 & 0xFF);
        return by2 | by3;
    }

    private static short l(byte by2, byte by3) {
        by2 = (byte)(by2 << 8);
        by3 = (byte)(by3 & 0xFF);
        return (short)(by2 | by3);
    }

    public static byte m(byte by2, byte by3, boolean bl2) {
        by2 = bl2 ? b.h(by2, by3) : b.h(by3, by2);
        return by2;
    }

    /*
     * WARNING - void declaration
     */
    public static byte n(byte by2, byte by3, boolean bl2, boolean bl3) {
        void var2_5;
        void var3_6;
        if (bl2) {
            int n10 = 4;
        } else {
            boolean bl4 = false;
        }
        if (var3_6 != false) {
            by2 = b.h((byte)(by2 << var2_5), by3);
        } else {
            by3 = (byte)(by3 << var2_5);
            by2 = b.h(by3, by2);
        }
        return by2;
    }

    public static byte o(byte by2, byte by3, boolean bl2) {
        by2 = bl2 ? (byte)(by2 | by3) : (byte)(by2 | by3);
        return by2;
    }

    public static byte[] p(byte by2, boolean bl2) {
        byte by3 = (byte)((by2 & 0xF0) >> 4);
        by2 = (byte)(by2 & 0xF);
        int n10 = 2;
        byte[] byArray = new byte[n10];
        byte by4 = bl2 ? by3 : by2;
        byArray[0] = by4;
        by4 = 1;
        if (bl2) {
            by3 = by2;
        }
        byArray[by4] = by3;
        return byArray;
    }

    public static byte[] q(int n10, int n11) {
        return b.r(n10, n11, true);
    }

    public static byte[] r(int n10, int n11, boolean bl2) {
        int n12;
        int n13 = 4;
        if (n11 <= n13 && n11 >= (n12 = 1)) {
            byte by2 = b.d(n10);
            byte by3 = b.e(n10);
            byte by4 = b.f(n10);
            n10 = b.g(n10);
            byte[] byArray = new byte[n11];
            int n14 = 3;
            int n15 = 2;
            if (bl2) {
                if (n11 != n12) {
                    if (n11 != n15) {
                        if (n11 != n14) {
                            if (n11 == n13) {
                                byArray[0] = n10;
                                byArray[n12] = by4;
                                byArray[n15] = by3;
                                byArray[n14] = by2;
                            }
                        } else {
                            byArray[0] = by4;
                            byArray[n12] = by3;
                            byArray[n15] = by2;
                        }
                    } else {
                        byArray[0] = by3;
                        byArray[n12] = by2;
                    }
                } else {
                    byArray[0] = by2;
                }
            } else if (n11 != n12) {
                if (n11 != n15) {
                    if (n11 != n14) {
                        if (n11 == n13) {
                            byArray[0] = by2;
                            byArray[n12] = by3;
                            byArray[n15] = by4;
                            byArray[n14] = n10;
                        }
                    } else {
                        byArray[0] = by2;
                        byArray[n12] = by3;
                        byArray[n15] = by4;
                    }
                } else {
                    byArray[0] = by2;
                    byArray[n12] = by3;
                }
            } else {
                byArray[0] = by2;
            }
            return byArray;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bit must be between 1~4 !!!");
        throw illegalArgumentException;
    }

    public static byte[] s(int n10, boolean bl2) {
        int n11 = n10 >> 24;
        int n12 = n10 >> 16;
        int n13 = n10 >> 8;
        n10 = (byte)n10;
        int n14 = 4;
        byte[] byArray = new byte[n14];
        int n15 = bl2 ? n11 : n10;
        int n16 = 0;
        byArray[0] = n15;
        n15 = 1;
        n16 = bl2 ? n12 : n13;
        byArray[n15] = n16;
        n15 = 2;
        if (bl2) {
            n12 = n13;
        }
        byArray[n15] = n12;
        n12 = 3;
        if (bl2) {
            n11 = n10;
        }
        byArray[n12] = n11;
        return byArray;
    }

    public static byte[] t(short s10, boolean bl2) {
        short s11 = (short)((0xFF00 & s10) >> 8);
        s10 = (byte)(s10 & 0xFF);
        int n10 = 2;
        byte[] byArray = new byte[n10];
        short s12 = bl2 ? s11 : s10;
        byArray[0] = s12;
        s12 = 1;
        if (bl2) {
            s11 = s10;
        }
        byArray[s12] = s11;
        return byArray;
    }

    public static int u(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        by2 = bl2 ? (byte)b.k(by2, by3, by4, by5) : (byte)b.k(by5, by4, by3, by2);
        return by2;
    }

    public static int v(byte by2, byte by3, byte by4, boolean bl2) {
        by2 = bl2 ? (byte)b.j(by2, by3, by4) : (byte)b.j(by4, by3, by2);
        return by2;
    }

    public static int w(byte by2, byte by3, boolean bl2) {
        by2 = bl2 ? (byte)b.i(by2, by3) : (byte)b.i(by3, by2);
        return by2;
    }

    public static int x(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        if (bl2) {
            by2 = (byte)(by2 << 24);
            by3 = (byte)(by3 << 16);
            by2 = (byte)(by2 | by3);
            by3 = (byte)(by4 << 8);
            by2 = (byte)(by2 | by3 | by5);
        } else {
            by5 = (byte)(by5 << 24);
            by4 = (byte)(by4 << 16 | by5);
            by3 = (byte)(by3 << 8 | by4);
            by2 = (byte)(by2 | by3);
        }
        return by2;
    }

    public static short y(byte by2, byte by3, boolean bl2) {
        by2 = bl2 ? (byte)b.l(by2, by3) : (byte)b.l(by3, by2);
        return by2;
    }
}

