/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.p0;

import d.n.a.q0.p;

public class e {
    public static final int a = 17;
    public static final int b = 18;
    public static final int c = 20;
    public static final int d = 33;
    public static final int e = 34;
    public static final int f = 36;
    public static final int g = 50;
    public static final int h = 52;

    private e() {
    }

    private static float a(byte by2, byte by3) {
        by2 = (byte)d.n.a.p0.e.g(by2);
        int n10 = (d.n.a.p0.e.g(by3) & 0xF) << 8;
        by2 = (byte)d.n.a.p0.e.j(by2 + n10, 12);
        by3 = (byte)d.n.a.p0.e.g(by3);
        n10 = 4;
        by3 = (byte)d.n.a.p0.e.j(by3 >> n10, n10);
        double d10 = by2;
        double d11 = by3;
        d11 = Math.pow(10.0, d11);
        return (float)(d10 * d11);
    }

    private static float b(byte by2, byte by3, byte by4, byte by5) {
        by2 = (byte)d.n.a.p0.e.g(by2);
        by3 = (byte)(d.n.a.p0.e.g(by3) << 8);
        by2 = (byte)(by2 + by3);
        by3 = (byte)(d.n.a.p0.e.g(by4) << 16);
        double d10 = d.n.a.p0.e.j(by2 + by3, 24);
        double d11 = by5;
        d11 = Math.pow(10.0, d11);
        return (float)(d10 * d11);
    }

    public static Float c(byte[] object, int n10, int n11) {
        byte by2 = d.n.a.p0.e.f(n10) + n11;
        byte by3 = ((byte[])object).length;
        int n12 = 1;
        if (by2 > by3) {
            Object[] objectArray = new Object[2];
            Integer n13 = n10;
            objectArray[0] = n13;
            object = ((byte[])object).length - n11;
            objectArray[n12] = object;
            p.u("Float formatType (0x%x) is longer than remaining bytes (%d) - returning null", objectArray);
            return null;
        }
        by2 = 50;
        if (n10 != by2) {
            by2 = 52;
            if (n10 != by2) {
                object = new Object[n12];
                Integer n14 = n10;
                object[0] = (byte)n14;
                p.u("Passed an invalid float formatType (0x%x) - returning null", object);
                return null;
            }
            n10 = object[n11];
            by2 = n11 + 1;
            by2 = object[by2];
            by3 = n11 + 2;
            by3 = object[by3];
            byte by4 = object[n11 += 3];
            return Float.valueOf(d.n.a.p0.e.b((byte)n10, by2, by3, by4));
        }
        n10 = object[n11];
        byte by5 = object[n11 += n12];
        return Float.valueOf(d.n.a.p0.e.a((byte)n10, by5));
    }

    public static Integer d(byte[] object, int n10, int n11) {
        byte by2 = d.n.a.p0.e.f(n10) + n11;
        byte by3 = ((byte[])object).length;
        int n12 = 1;
        if (by2 > by3) {
            Object[] objectArray = new Object[2];
            Integer n13 = n10;
            objectArray[0] = n13;
            object = ((byte[])object).length - n11;
            objectArray[n12] = object;
            p.u("Int formatType (0x%x) is longer than remaining bytes (%d) - returning null", objectArray);
            return null;
        }
        by2 = 17;
        if (n10 != by2) {
            by2 = 18;
            if (n10 != by2) {
                by2 = 20;
                if (n10 != by2) {
                    by2 = 36;
                    if (n10 != by2) {
                        by2 = 33;
                        if (n10 != by2) {
                            by2 = 34;
                            if (n10 != by2) {
                                object = new Object[n12];
                                Integer n14 = n10;
                                object[0] = (byte)n14;
                                p.u("Passed an invalid integer formatType (0x%x) - returning null", object);
                                return null;
                            }
                            n10 = object[n11];
                            byte by4 = object[n11 += n12];
                            return d.n.a.p0.e.j(d.n.a.p0.e.h((byte)n10, by4), 16);
                        }
                        return d.n.a.p0.e.j(d.n.a.p0.e.g(object[n11]), 8);
                    }
                    n10 = object[n11];
                    by2 = n11 + 1;
                    by2 = object[by2];
                    by3 = n11 + 2;
                    by3 = object[by3];
                    byte by5 = object[n11 += 3];
                    return d.n.a.p0.e.j(d.n.a.p0.e.i((byte)n10, by2, by3, by5), 32);
                }
                n10 = object[n11];
                by2 = n11 + 1;
                by2 = object[by2];
                by3 = n11 + 2;
                by3 = object[by3];
                byte by6 = object[n11 += 3];
                return d.n.a.p0.e.i((byte)n10, by2, by3, by6);
            }
            n10 = object[n11];
            byte by7 = object[n11 += n12];
            return d.n.a.p0.e.h((byte)n10, by7);
        }
        return d.n.a.p0.e.g(object[n11]);
    }

    public static String e(byte[] object, int n10) {
        int n11;
        int n12 = ((byte[])object).length;
        if (n10 > n12) {
            object = new Object[0];
            p.u("Passed offset that exceeds the length of the byte array - returning null", object);
            return null;
        }
        n12 = ((byte[])object).length - n10;
        byte[] byArray = new byte[n12];
        for (int i10 = 0; i10 != (n11 = ((byte[])object).length - n10); ++i10) {
            n11 = n10 + i10;
            byArray[i10] = n11 = object[n11];
        }
        object = new String;
        object(byArray);
        return object;
    }

    private static int f(int n10) {
        return n10 & 0xF;
    }

    private static int g(byte by2) {
        return by2 & 0xFF;
    }

    private static int h(byte by2, byte by3) {
        by2 = (byte)d.n.a.p0.e.g(by2);
        by3 = (byte)(d.n.a.p0.e.g(by3) << 8);
        return by2 + by3;
    }

    private static int i(byte by2, byte by3, byte by4, byte by5) {
        by2 = (byte)d.n.a.p0.e.g(by2);
        by3 = (byte)(d.n.a.p0.e.g(by3) << 8);
        by2 = (byte)(by2 + by3);
        by3 = (byte)(d.n.a.p0.e.g(by4) << 16);
        by2 = (byte)(by2 + by3);
        by3 = (byte)(d.n.a.p0.e.g(by5) << 24);
        return by2 + by3;
    }

    private static int j(int n10, int n11) {
        int n12 = 1;
        n11 -= n12;
        if ((n12 = n10 & (n11 = n12 << n11)) != 0) {
            n12 = n11 + -1;
            n10 = (n11 -= (n10 &= n12)) * -1;
        }
        return n10;
    }
}

