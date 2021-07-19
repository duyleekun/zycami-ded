/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.u;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class j {
    public static String a(byte[] object) {
        int n10 = ((byte[])object).length;
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            cArray[i10] = c10 = (char)(object[i10] ^ 0x10);
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static byte[] b(String object, String object2, byte[] byArray) {
        String string2 = "utf-8";
        object2 = ((String)object2).getBytes(string2);
        SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object2, "AES");
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        object = ((String)object).getBytes(string2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object);
        ((Cipher)object2).init(2, (Key)secretKeySpec, ivParameterSpec);
        return ((Cipher)object2).doFinal(byArray);
    }
}

