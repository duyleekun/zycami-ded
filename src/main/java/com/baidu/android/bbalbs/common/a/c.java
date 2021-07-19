/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.android.bbalbs.common.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    public static String a(byte[] byArray, String string2, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            int n13 = byArray[i10] & 0xFF;
            String string3 = Integer.toHexString(n13);
            if (bl2) {
                string3 = string3.toUpperCase();
            }
            if ((n12 = string3.length()) == (n11 = 1)) {
                String string4 = "0";
                stringBuilder.append(string4);
            }
            stringBuilder.append(string3);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String a(byte[] byArray, boolean bl2) {
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            RuntimeException runtimeException = new RuntimeException(noSuchAlgorithmException);
            throw runtimeException;
        }
        ((MessageDigest)object).reset();
        ((MessageDigest)object).update(byArray);
        byArray = ((MessageDigest)object).digest();
        object = "";
        return c.a(byArray, (String)object, bl2);
    }
}

