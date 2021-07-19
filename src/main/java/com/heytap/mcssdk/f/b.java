/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.heytap.mcssdk.f;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class b {
    public static String a(String object, String object2) {
        Object object3 = Cipher.getInstance("DES");
        object2 = b.a((String)object2);
        ((Cipher)object3).init(2, (Key)object2);
        object = Base64.decode((String)object, (int)0);
        object = ((Cipher)object3).doFinal((byte[])object);
        object3 = Charset.defaultCharset();
        object2 = new String((byte[])object, (Charset)object3);
        return ((String)object2).trim();
    }

    private static Key a(String object) {
        object = Base64.decode((String)object, (int)0);
        DESKeySpec dESKeySpec = new DESKeySpec((byte[])object);
        return SecretKeyFactory.getInstance("DES").generateSecret(dESKeySpec);
    }
}

