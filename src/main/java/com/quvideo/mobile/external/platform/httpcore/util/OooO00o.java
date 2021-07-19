/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.httpcore.util;

import java.security.MessageDigest;

public class OooO00o {
    private static final char[] OooO00o;

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
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        OooO00o = cArray;
    }

    public static String OooO00o(String object) {
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
        }
        catch (Exception exception) {
            return null;
        }
        object = ((String)object).getBytes();
        int n10 = ((Object)object).length;
        ((MessageDigest)object2).update((byte[])object, 0, n10);
        object = ((MessageDigest)object2).digest();
        return com.quvideo.mobile.external.platform.httpcore.util.OooO00o.OooO00o((byte[])object, null);
    }

    public static String OooO00o(byte[] byArray, String object) {
        char c10;
        int n10 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = byArray.length + -1); ++n10) {
            char[] cArray = OooO00o;
            int n11 = (byArray[n10] & 0xF0) >>> 4;
            n11 = cArray[n11];
            stringBuilder.append((char)n11);
            n11 = byArray[n10] & 0xF;
            c10 = cArray[n11];
            stringBuilder.append(c10);
            if (object == null) continue;
            stringBuilder.append((String)object);
        }
        object = OooO00o;
        int n12 = (byArray[n10] & 0xF0) >>> 4;
        Object object2 = object[n12];
        stringBuilder.append((char)object2);
        int n13 = byArray[n10] & 0xF;
        Object object3 = object[n13];
        stringBuilder.append((char)object3);
        return stringBuilder.toString();
    }
}

