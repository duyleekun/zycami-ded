/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class h {
    public static byte[] a(String string2, String string3) {
        return h.a(string2, string3, "0000000000000000");
    }

    public static byte[] a(String object, String object2, String object3) {
        String string2 = "utf-8";
        object = ((String)object).getBytes(string2);
        object2 = ((String)object2).getBytes(string2);
        object3 = ((String)object3).getBytes(string2);
        return h.b((byte[])object, (byte[])object2, (byte[])object3);
    }

    public static byte[] a(byte[] byArray, String object) {
        Object object2 = "utf-8";
        object = ((String)object).getBytes((String)object2);
        object2 = "0000000000000000".getBytes((String)object2);
        return h.a(byArray, (byte[])object, (byte[])object2);
    }

    public static byte[] a(byte[] byArray, String object, String object2) {
        String string2 = "utf-8";
        object = ((String)object).getBytes(string2);
        object2 = ((String)object2).getBytes(string2);
        return h.a(byArray, (byte[])object, (byte[])object2);
    }

    public static byte[] a(byte[] byArray, byte[] object, byte[] object2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object2);
        object2 = new SecretKeySpec;
        object2((byte[])object, "AES");
        object = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object).init(2, (Key)object2, ivParameterSpec);
        return ((Cipher)object).doFinal(byArray);
    }

    public static byte[] b(byte[] byArray, byte[] object, byte[] object2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object2);
        object2 = new SecretKeySpec;
        object2((byte[])object, "AES");
        object = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object).init(1, (Key)object2, ivParameterSpec);
        return ((Cipher)object).doFinal(byArray);
    }
}

