/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

public class e {
    private static short a = 1;
    private static byte b = 1;

    public static byte a() {
        byte by2 = b;
        byte by3 = 1;
        byte by4 = 127;
        if (by2 >= by4) {
            b = by3;
            by2 = by3;
        } else {
            b = by3 = (byte)(by2 + 1);
        }
        return by2;
    }

    public static short b() {
        short s10 = a;
        short s11 = 1;
        short s12 = Short.MAX_VALUE;
        if (s10 >= s12) {
            a = s11;
            s10 = s11;
        } else {
            a = s11 = (short)(s10 + 1);
        }
        return s10;
    }
}

