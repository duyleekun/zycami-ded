/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.android.bbalbs.common.a;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static byte[] a(String object, String object2, byte[] byArray) {
        object2 = ((String)object2).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, "AES");
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        object = ((String)object).getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object);
        ((Cipher)object2).init(1, (Key)secretKeySpec, ivParameterSpec);
        return ((Cipher)object2).doFinal(byArray);
    }

    public static byte[] b(String object, String object2, byte[] byArray) {
        object2 = ((String)object2).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, "AES");
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        object = ((String)object).getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object);
        ((Cipher)object2).init(2, (Key)secretKeySpec, ivParameterSpec);
        return ((Cipher)object2).doFinal(byArray);
    }
}

