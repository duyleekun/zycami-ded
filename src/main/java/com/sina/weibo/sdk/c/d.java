/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.c;

import java.security.MessageDigest;

public final class d {
    private static final char[] ao;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
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
        cArray2[10] = 97;
        cArray3[11] = 98;
        cArray2[12] = 99;
        cArray3[13] = 100;
        cArray2[14] = 101;
        cArray3[15] = 102;
        ao = cArray;
    }

    public static String a(byte[] object) {
        int n10;
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        ((MessageDigest)object2).update((byte[])object);
        object = ((MessageDigest)object2).digest();
        int n11 = 32;
        object2 = new char[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = 16); ++i10) {
            n10 = object[i10];
            int n13 = n12 + 1;
            char[] cArray = ao;
            int n14 = n10 >>> 4 & 0xF;
            n14 = cArray[n14];
            object2[n12] = n14;
            n12 = n13 + 1;
            n10 &= 0xF;
            n10 = cArray[n10];
            object2[n13] = n10;
            continue;
        }
        object = new String;
        try {
            object((char[])object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = null;
        }
        return object;
    }

    public static String f(String object) {
        object = ((String)object).getBytes();
        try {
            object = d.a((byte[])object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = null;
        }
        return object;
    }
}

