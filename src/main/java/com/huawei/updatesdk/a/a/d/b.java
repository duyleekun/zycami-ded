/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d;

import java.io.UnsupportedEncodingException;

public class b {
    private byte[] a = null;
    private int b;
    private int c;

    public b() {
        int n10;
        this.b = n10 = 1024;
        this.c = 0;
        byte[] byArray = new byte[n10];
        this.a = byArray;
    }

    public static String a(byte[] byArray) {
        char[] cArray;
        int n10 = 16;
        char[] cArray2 = cArray = new char[n10];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        int n11 = byArray.length * 2;
        char[] cArray4 = new char[n11];
        int n12 = byArray.length;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14 = byArray[i10];
            int n15 = n13 + 1;
            int n16 = n14 >>> 4 & 0xF;
            cArray4[n13] = n16 = cArray[n16];
            n13 = n15 + 1;
            n14 &= 0xF;
            cArray4[n15] = n14 = cArray[n14];
        }
        return String.valueOf(cArray4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a() {
        String string2;
        byte[] byArray;
        int n10 = this.c;
        String string3 = null;
        if (n10 <= 0) {
            return null;
        }
        try {
            byArray = this.a;
            string2 = "UTF-8";
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string3;
        }
        String string4 = new String(byArray, 0, n10, string2);
        return string4;
    }

    public void a(byte[] byArray, int n10) {
        int n11;
        if (n10 <= 0) {
            return;
        }
        byte[] byArray2 = this.a;
        int n12 = byArray2.length;
        int n13 = this.c;
        if ((n12 -= n13) >= n10) {
            System.arraycopy(byArray, 0, byArray2, n13, n10);
        } else {
            n12 = byArray2.length + n10 << 1;
            byte[] byArray3 = new byte[n12];
            System.arraycopy(byArray2, 0, byArray3, 0, n13);
            int n14 = this.c;
            System.arraycopy(byArray, 0, byArray3, n14, n10);
            this.a = byArray3;
        }
        this.c = n11 = this.c + n10;
    }
}

