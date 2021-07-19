/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.n;
import java.security.MessageDigest;

public class m {
    public static String a(byte[] byArray) {
        String string2 = "SHA-256";
        try {
            byArray = m.a(byArray, string2);
        }
        catch (Exception exception) {
            return null;
        }
        return n.a(byArray);
    }

    private static byte[] a(byte[] byArray, String object) {
        object = MessageDigest.getInstance((String)object);
        ((MessageDigest)object).update(byArray);
        return ((MessageDigest)object).digest();
    }
}

