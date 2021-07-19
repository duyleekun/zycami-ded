/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class y {
    public static byte[] a(byte[] byArray, byte[] object, byte[] object2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object2);
        object2 = new SecretKeySpec;
        object2((byte[])object, "AES");
        object = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object).init(1, (Key)object2, ivParameterSpec);
        return ((Cipher)object).doFinal(byArray);
    }
}

