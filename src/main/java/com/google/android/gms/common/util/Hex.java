/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

public class Hex {
    private static final char[] zza;
    private static final char[] zzb;

    static {
        char[] cArray;
        char[] cArray2;
        int n10 = 16;
        char[] cArray3 = cArray2 = new char[n10];
        char[] cArray4 = cArray2;
        cArray3[0] = 48;
        cArray4[1] = 49;
        cArray3[2] = 50;
        cArray4[3] = 51;
        cArray3[4] = 52;
        cArray4[5] = 53;
        cArray3[6] = 54;
        cArray4[7] = 55;
        cArray3[8] = 56;
        cArray4[9] = 57;
        cArray3[10] = 65;
        cArray4[11] = 66;
        cArray3[12] = 67;
        cArray4[13] = 68;
        cArray3[14] = 69;
        cArray4[15] = 70;
        zza = cArray2;
        char[] cArray5 = cArray = new char[n10];
        char[] cArray6 = cArray;
        cArray5[0] = 48;
        cArray6[1] = 49;
        cArray5[2] = 50;
        cArray6[3] = 51;
        cArray5[4] = 52;
        cArray6[5] = 53;
        cArray5[6] = 54;
        cArray6[7] = 55;
        cArray5[8] = 56;
        cArray6[9] = 57;
        cArray5[10] = 97;
        cArray6[11] = 98;
        cArray5[12] = 99;
        cArray6[13] = 100;
        cArray5[14] = 101;
        cArray6[15] = 102;
        zzb = cArray;
    }

    public static String bytesToStringLowercase(byte[] object) {
        int n10;
        int n11 = ((byte[])object).length << 1;
        char[] cArray = new char[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); ++i10) {
            n10 = object[i10] & 0xFF;
            int n13 = n12 + 1;
            char[] cArray2 = zzb;
            int n14 = n10 >>> 4;
            cArray[n12] = n14 = cArray2[n14];
            n12 = n13 + 1;
            n10 &= 0xF;
            cArray[n13] = n10 = cArray2[n10];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static String bytesToStringUppercase(byte[] byArray) {
        return Hex.bytesToStringUppercase(byArray, false);
    }

    public static String bytesToStringUppercase(byte[] byArray, boolean bl2) {
        char c10;
        int n10 = byArray.length;
        int n11 = n10 << 1;
        StringBuilder stringBuilder = new StringBuilder(n11);
        for (n11 = 0; !(n11 >= n10 || bl2 && n11 == (c10 = n10 + -1) && (c10 = byArray[n11] & 0xFF) == '\u0000'); ++n11) {
            char[] cArray = zza;
            int n12 = (byArray[n11] & 0xF0) >>> 4;
            n12 = cArray[n12];
            stringBuilder.append((char)n12);
            n12 = byArray[n11] & 0xF;
            c10 = cArray[n12];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static byte[] stringToBytes(String object) {
        int n10 = ((String)object).length();
        int n11 = n10 % 2;
        if (n11 == 0) {
            n11 = n10 / 2;
            byte[] byArray = new byte[n11];
            int n12 = 0;
            String string2 = null;
            while (n12 < n10) {
                int n13 = n12 / 2;
                int n14 = n12 + 2;
                string2 = ((String)object).substring(n12, n14);
                int n15 = 16;
                byArray[n13] = n12 = (int)((byte)Integer.parseInt(string2, n15));
                n12 = n14;
            }
            return byArray;
        }
        object = new IllegalArgumentException("Hex string has odd number of characters");
        throw object;
    }
}

