/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.a5;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a4 {
    private static final byte[] a = "0000000000000000".getBytes();

    public static byte[] a(String object, String object2) {
        Object object3 = a;
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object3);
        object3 = new SecretKeySpec;
        object2 = ((String)object2).getBytes();
        object3((byte[])object2, "AES");
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object2).init(1, (Key)object3, ivParameterSpec);
        object = ((String)object).getBytes("utf-8");
        return ((Cipher)object2).doFinal((byte[])object);
    }

    public static String b(String string2, String string3) {
        return String.valueOf(a5.a(a4.a(string2, string3)));
    }
}

