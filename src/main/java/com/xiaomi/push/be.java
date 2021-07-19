/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class be {
    private static String a(byte by2) {
        StringBuilder stringBuilder;
        int n10 = by2 & 0x7F;
        if (by2 < 0) {
            by2 = (byte)128;
        } else {
            by2 = 0;
            stringBuilder = null;
        }
        stringBuilder = new StringBuilder();
        int n11 = 16;
        String string2 = (n10 += by2) < n11 ? "0" : "";
        stringBuilder.append(string2);
        String string3 = Integer.toHexString(n10).toLowerCase();
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String a(String object) {
        byte by2;
        StringBuffer stringBuffer;
        Object object2 = "MD5";
        try {
            object2 = MessageDigest.getInstance((String)object2);
            stringBuffer = new StringBuffer();
            byte[] byArray = ((String)object).getBytes();
            int n10 = ((String)object).length();
            ((MessageDigest)object2).update(byArray, 0, n10);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return null;
        }
        object = ((MessageDigest)object2).digest();
        for (int i10 = 0; i10 < (by2 = ((Object)object).length); ++i10) {
            by2 = (byte)object[i10];
            object2 = be.a(by2);
            stringBuffer.append((String)object2);
        }
        return stringBuffer.toString();
    }

    public static String b(String string2) {
        return be.a(string2).subSequence(8, 24).toString();
    }
}

