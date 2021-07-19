/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class a6 {
    private final int[] a;
    private final int[] b;
    private final int[] c;

    public a6() {
        int[] nArray;
        int n10 = 5;
        int[] nArray2 = nArray = new int[n10];
        int[] nArray3 = nArray;
        nArray2[0] = 1732584193;
        nArray3[1] = -271733879;
        nArray2[2] = -1732584194;
        nArray3[3] = 271733878;
        nArray3[4] = -1009589776;
        this.a = nArray;
        int[] nArray4 = new int[n10];
        this.b = nArray4;
        nArray4 = new int[80];
        this.c = nArray4;
    }

    private int a(int n10, int n11) {
        int n12 = n10 << n11;
        n11 = 32 - n11;
        return n10 >>> n11 | n12;
    }

    private int a(int n10, int n11, int n12) {
        return ~n10 & n12 | (n11 &= n10);
    }

    private int a(byte[] byArray, int n10) {
        int n11 = (byArray[n10] & 0xFF) << 24;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 8;
        return byArray[n10 += 3] & 0xFF | (n11 |= n12);
    }

    private void a() {
        int[] nArray;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int[] nArray2;
        int n20;
        int n21;
        int n22 = 16;
        while (true) {
            n21 = 79;
            n20 = 1;
            if (n22 > n21) break;
            nArray2 = this.c;
            int n23 = n22 + -3;
            n23 = nArray2[n23];
            n19 = n22 + -8;
            n19 = nArray2[n19];
            n23 ^= n19;
            n19 = n22 + -14;
            n19 = nArray2[n19];
            n23 ^= n19;
            n19 = n22 + -16;
            n19 = nArray2[n19];
            nArray2[n22] = n20 = this.a(n23 ^= n19, n20);
            ++n22;
        }
        n22 = 5;
        int[] nArray3 = new int[n22];
        n19 = 0;
        for (n18 = 0; n18 < n22; ++n18) {
            int[] nArray4 = this.b;
            nArray3[n18] = n17 = nArray4[n18];
        }
        n18 = 0;
        while (true) {
            n17 = 19;
            n16 = 30;
            n15 = 4;
            n14 = 2;
            n13 = 3;
            if (n18 > n17) break;
            n17 = nArray3[0];
            n17 = this.a(n17, n22);
            n12 = nArray3[n20];
            n11 = nArray3[n14];
            n10 = nArray3[n13];
            n12 = this.a(n12, n11, n10);
            n17 += n12;
            n12 = nArray3[n15];
            n17 += n12;
            nArray = this.c;
            n12 = nArray[n18];
            n17 = n17 + n12 + 1518500249;
            nArray3[n15] = n12 = nArray3[n13];
            nArray3[n13] = n15 = nArray3[n14];
            n15 = nArray3[n20];
            nArray3[n14] = n16 = this.a(n15, n16);
            nArray3[n20] = n16 = nArray3[0];
            nArray3[0] = n17;
            ++n18;
        }
        for (n18 = 20; n18 <= (n17 = 39); ++n18) {
            n17 = nArray3[0];
            n17 = this.a(n17, n22);
            n12 = nArray3[n20];
            n11 = nArray3[n14];
            n10 = nArray3[n13];
            n12 = this.b(n12, n11, n10);
            n17 += n12;
            n12 = nArray3[n15];
            n17 += n12;
            nArray = this.c;
            n12 = nArray[n18];
            n17 = n17 + n12 + 1859775393;
            nArray3[n15] = n12 = nArray3[n13];
            nArray3[n13] = n12 = nArray3[n14];
            n12 = nArray3[n20];
            nArray3[n14] = n12 = this.a(n12, n16);
            nArray3[n20] = n12 = nArray3[0];
            nArray3[0] = n17;
        }
        for (n18 = 40; n18 <= (n17 = 59); ++n18) {
            n17 = nArray3[0];
            n17 = this.a(n17, n22);
            n12 = nArray3[n20];
            n11 = nArray3[n14];
            n10 = nArray3[n13];
            n12 = this.c(n12, n11, n10);
            n17 += n12;
            n12 = nArray3[n15];
            n17 += n12;
            nArray = this.c;
            n12 = nArray[n18];
            n17 = n17 + n12 + -1894007588;
            nArray3[n15] = n12 = nArray3[n13];
            nArray3[n13] = n12 = nArray3[n14];
            n12 = nArray3[n20];
            nArray3[n14] = n12 = this.a(n12, n16);
            nArray3[n20] = n12 = nArray3[0];
            nArray3[0] = n17;
        }
        for (n18 = 60; n18 <= n21; ++n18) {
            n17 = nArray3[0];
            n17 = this.a(n17, n22);
            n12 = nArray3[n20];
            n11 = nArray3[n14];
            n10 = nArray3[n13];
            n12 = this.b(n12, n11, n10);
            n17 += n12;
            n12 = nArray3[n15];
            n17 += n12;
            nArray = this.c;
            n12 = nArray[n18];
            n17 = n17 + n12 + -899497514;
            nArray3[n15] = n12 = nArray3[n13];
            nArray3[n13] = n12 = nArray3[n14];
            n12 = nArray3[n20];
            nArray3[n14] = n12 = this.a(n12, n16);
            nArray3[n20] = n12 = nArray3[0];
            nArray3[0] = n17;
        }
        nArray2 = null;
        for (n21 = 0; n21 < n22; ++n21) {
            int[] nArray5 = this.b;
            n18 = nArray5[n21];
            n17 = nArray3[n21];
            nArray5[n21] = n18 += n17;
        }
        for (n22 = 0; n22 < (n20 = (nArray2 = this.c).length); ++n22) {
            nArray2[n22] = 0;
        }
    }

    private void a(int n10, byte[] byArray, int n11) {
        byte by2;
        int n12;
        byArray[n11] = n12 = (int)(n10 >>> 24);
        n12 = n11 + 1;
        byArray[n12] = by2 = (byte)(n10 >>> 16);
        n12 = n11 + 2;
        byArray[n12] = by2 = (byte)(n10 >>> 8);
        byArray[n11 += 3] = n10 = (int)((byte)n10);
    }

    private static byte[] a(String string2) {
        String string3 = "UTF-8";
        byte[] byArray = new byte[]{};
        try {
            byArray = string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        return byArray;
    }

    public static byte[] a(String object, String object2) {
        Object object3;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 != 0) {
            return null;
        }
        n10 = 64;
        byte[] byArray = new byte[n10];
        byte[] byArray2 = new byte[n10];
        byte[] byArray3 = new byte[n10];
        int n11 = ((String)object2).length();
        a6 a62 = new a6();
        int n12 = ((String)object2).length();
        int n13 = 0;
        if (n12 > n10) {
            object2 = a6.a((String)object2);
            object2 = a62.b((byte[])object2);
            n11 = ((Object)object2).length;
            for (n12 = 0; n12 < n11; ++n12) {
                byArray3[n12] = object3 = (Object)object2[n12];
            }
        } else {
            object2 = a6.a((String)object2);
            for (n12 = 0; n12 < (object3 = ((Object)object2).length); ++n12) {
                byArray3[n12] = object3 = (Object)object2[n12];
            }
        }
        while (n11 < n10) {
            byArray3[n11] = 0;
            ++n11;
        }
        while (n13 < n10) {
            byte by2;
            byArray[n13] = by2 = (byte)(byArray3[n13] ^ 0x36);
            byArray2[n13] = by2 = (byte)(byArray3[n13] ^ 0x5C);
            ++n13;
        }
        object = a6.a((String)object);
        object = a6.a(byArray, (byte[])object);
        object = a62.b((byte[])object);
        object = a6.a(byArray2, (byte[])object);
        return a62.b((byte[])object);
    }

    private byte[] a(byte[] byArray) {
        int n10;
        int n11;
        int n12;
        int n13 = byArray.length;
        int n14 = n13 % 64;
        int n15 = 56;
        if (n14 < n15) {
            n12 = 55 - n14;
            n14 = n13 - n14 + 64;
        } else if (n14 == n15) {
            n14 = n13 + 8 + 64;
            n12 = 63;
        } else {
            n12 = 63 - n14 + n15;
            n11 = n13 + 64 - n14;
            n14 = n11 + 64;
        }
        byte[] byArray2 = new byte[n14];
        n11 = 0;
        System.arraycopy(byArray, 0, byArray2, 0, n13);
        int n16 = n13 + 1;
        byArray2[n13] = -128;
        for (n10 = 0; n10 < n12; ++n10) {
            int n17 = n16 + 1;
            byArray2[n16] = 0;
            n16 = n17;
        }
        long l10 = (long)n13 * (long)8;
        long l11 = 255L;
        n13 = (byte)(l10 & l11);
        byte by2 = (byte)(l10 >> 8 & l11);
        byte by3 = (byte)(l10 >> 16 & l11);
        byte by4 = (byte)(l10 >> 24 & l11);
        byte by5 = (byte)(l10 >> 32 & l11);
        byte by6 = (byte)(l10 >> 40 & l11);
        long l12 = l10 >> 48;
        n10 = (byte)(l11 & l12);
        n15 = (byte)(l10 >> n15);
        n12 = n16 + 1;
        byArray2[n16] = n15;
        n16 = n12 + 1;
        byArray2[n12] = n10;
        n15 = n16 + 1;
        byArray2[n16] = by6;
        n16 = n15 + 1;
        byArray2[n15] = by5;
        n15 = n16 + 1;
        byArray2[n16] = by4;
        n16 = n15 + 1;
        byArray2[n15] = by3;
        n15 = n16 + 1;
        byArray2[n16] = by2;
        byArray2[n15] = n13;
        return byArray2;
    }

    private static byte[] a(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        int n12 = byArray.length;
        int n13 = byArray2.length;
        byte[] byArray3 = new byte[n12 += n13];
        n13 = 0;
        for (n11 = 0; n11 < (n10 = byArray.length); ++n11) {
            byArray3[n11] = n10 = byArray[n11];
        }
        while (n13 < (n11 = byArray2.length)) {
            n11 = byArray.length + n13;
            byArray3[n11] = n10 = byArray2[n13];
            ++n13;
        }
        return byArray3;
    }

    private int b(int n10, int n11, int n12) {
        return n10 ^ n11 ^ n12;
    }

    private byte[] b(byte[] byArray) {
        int[] nArray;
        int n10;
        this.c(byArray);
        int n11 = 20;
        byArray = new byte[n11];
        for (int i10 = 0; i10 < (n10 = (nArray = this.b).length); ++i10) {
            int n12 = nArray[i10];
            n10 = i10 * 4;
            this.a(n12, byArray, n10);
        }
        return byArray;
    }

    private int c(int n10, int n11, int n12) {
        int n13 = n10 & n11;
        n10 = n10 & n12 | n13;
        return n10 | (n11 &= n12);
    }

    private int c(byte[] byArray) {
        int[] nArray = this.a;
        int[] nArray2 = this.b;
        int n10 = nArray.length;
        System.arraycopy(nArray, 0, nArray2, 0, n10);
        byArray = this.a(byArray);
        int n11 = byArray.length / 64;
        nArray2 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            for (n10 = 0; n10 < (n12 = 16); ++n10) {
                int[] nArray3 = this.c;
                int n13 = i10 * 64;
                int n14 = n10 * 4;
                n13 += n14;
                nArray3[n10] = n13 = this.a(byArray, n13);
            }
            this.a();
        }
        return 20;
    }
}

