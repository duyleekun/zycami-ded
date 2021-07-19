/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.c;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a {
    private static String a = "RSA";

    public static PrivateKey a(byte[] byArray) {
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(byArray);
        return KeyFactory.getInstance(a).generatePrivate(pKCS8EncodedKeySpec);
    }

    public static byte[] a(byte[] byArray, PrivateKey privateKey) {
        int n10;
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        int n11 = 2;
        cipher.init(n11, privateKey);
        int n12 = byArray.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n13 = 0;
        while ((n10 = n12 - n13) > 0) {
            byte[] byArray2;
            int n14 = cipher.getBlockSize();
            if (n10 >= n14) {
                n10 = cipher.getBlockSize();
                byArray2 = cipher.doFinal(byArray, n13, n10);
            } else {
                byArray2 = cipher.doFinal(byArray, n13, n10);
            }
            byteArrayOutputStream.write(byArray2);
            n10 = cipher.getBlockSize();
            n13 += n10;
        }
        byArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byArray;
    }
}

