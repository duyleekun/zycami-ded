/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class h {
    private static final byte[] a;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[16];
        byte[] byArray3 = byArray;
        byArray2[0] = 100;
        byArray3[1] = 23;
        byArray2[2] = 84;
        byArray3[3] = 114;
        byArray2[4] = 72;
        byArray3[5] = 0;
        byArray2[6] = 4;
        byArray3[7] = 97;
        byArray2[8] = 73;
        byArray3[9] = 97;
        byArray2[10] = 2;
        byArray3[11] = 52;
        byArray2[12] = 84;
        byArray3[13] = 102;
        byArray2[14] = 18;
        byArray3[15] = 32;
        a = byArray;
    }

    private static Cipher a(byte[] object, int n10) {
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object, "AES");
        object = new IvParameterSpec;
        Object object2 = a;
        object((byte[])object2);
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object2).init(n10, (Key)secretKeySpec, (AlgorithmParameterSpec)object);
        return object2;
    }

    public static byte[] a(byte[] byArray, byte[] byArray2) {
        return h.a(byArray, 2).doFinal(byArray2);
    }

    public static byte[] b(byte[] byArray, byte[] byArray2) {
        return h.a(byArray, 1).doFinal(byArray2);
    }
}

