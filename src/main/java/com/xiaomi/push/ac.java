/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

public class ac {
    public static int a(byte[] object) {
        int n10 = ((byte[])object).length;
        int n11 = 4;
        if (n10 == n11) {
            n11 = (object[0] & 0xFF) << 24;
            n10 = 0 | n11;
            n11 = (object[1] & 0xFF) << 16;
            n10 |= n11;
            n11 = (object[2] & 0xFF) << 8;
            return object[3] & 0xFF | (n10 |= n11);
        }
        object = new IllegalArgumentException;
        object("the length of bytes must be 4");
        throw object;
    }

    public static byte[] a(int n10) {
        byte by2 = (byte)(n10 >> 24);
        by2 = (byte)(n10 >> 16);
        by2 = (byte)(n10 >> 8);
        byte[] byArray = new byte[]{by2, by2, by2, n10 = (int)((byte)n10)};
        return byArray;
    }
}

