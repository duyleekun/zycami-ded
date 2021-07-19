/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.geetest.sdk;

import android.util.Base64;
import com.geetest.sdk.a7;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class a9 {
    private static String a() {
        return a9.a("2A2C22122832442026360522203D055621252031353630243551343A262126360C223F25023430274741292B231C3734231D2823240B4A3D500E523D000B27523D131D2F2147225C2F11523F5B5450550C50174D2611121009353C540B012C3704251015173804030029075212341C3702073F0C0B1B101E33094C2F01462D56232E22203D065250332F1D3F532C123A043445570C1C370F2A30110C282D1C1E0224113F1722242716362210265C36040B5721263C1D2F362803023B3E3417023608422E1D104E185D1D27281424011714252E2124252431");
    }

    private static String a(String object) {
        int n10;
        Object object2;
        int n11;
        int n12 = ((String)object).length() / 2;
        Object object3 = new ByteArrayOutputStream(n12);
        n12 = 0;
        for (n11 = 0; n11 < (object2 = ((String)object).length()); n11 += 2) {
            object2 = ((String)object).charAt(n11);
            String string2 = "0123456789ABCDEF";
            object2 = string2.indexOf((int)object2) << 4;
            int n13 = n11 + 1;
            n13 = ((String)object).charAt(n13);
            n10 = string2.indexOf(n13);
            ((ByteArrayOutputStream)object3).write((int)(object2 |= n10));
        }
        object = ((ByteArrayOutputStream)object3).toByteArray();
        n11 = ((Object)object).length;
        while (n12 < n11) {
            object2 = object[n12];
            n10 = n12 % 7;
            String string3 = "geetest";
            n10 = string3.charAt(n10);
            object2 = (byte)(object2 ^ n10);
            object[n12] = object2;
            ++n12;
        }
        ((ByteArrayOutputStream)object3).close();
        object3 = new String((byte[])object);
        return object3;
    }

    private static byte[] a(byte[] byArray, RSAPublicKey rSAPublicKey) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(byArray);
    }

    public static String b(String object) {
        object = ((String)object).getBytes();
        RSAPublicKey rSAPublicKey = (RSAPublicKey)a9.c(a9.a());
        return a7.a(a9.a((byte[])object, rSAPublicKey));
    }

    private static PublicKey c(String object) {
        object = Base64.decode((String)object, (int)4);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object);
        return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    }
}

