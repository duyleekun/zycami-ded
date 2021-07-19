/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.y;
import d.j.f.a.a.h.f.c;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class e {
    public static String a(String string2, String object) {
        String string3 = "UTF-8";
        try {
            object = ((String)object).getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            y.c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
        return e.a(string2, (byte[])object);
    }

    public static String a(String object, byte[] byArray) {
        int n10;
        String string2 = "";
        String string3 = "hmsSdk";
        if (byArray != null && (n10 = byArray.length) != 0) {
            object = c.c((String)object);
            object = e.a((byte[])object);
            object = e.a(byArray, (PublicKey)object);
            try {
                return c.b((byte[])object);
            }
            catch (InvalidKeySpecException invalidKeySpecException) {
                object = "encrypt(): Invalid key specification";
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = "encrypt(): getInstance - No such algorithm,transformation";
            }
            y.f(string3, (String)object);
            return string2;
        }
        y.f(string3, "encrypt: content is empty or null");
        return string2;
    }

    public static PublicKey a(byte[] byArray) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byArray);
        return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static byte[] a(byte[] var0, PublicKey var1_1) {
        block11: {
            var2_2 = "hmsSdk";
            if (var1_1 == null) ** GOTO lbl11
            var3_3 = "RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING";
            var3_3 = Cipher.getInstance((String)var3_3);
            var4_4 = 1;
            var3_3.init(var4_4, (Key)var1_1);
            return var3_3.doFinal(var0 /* !! */ );
lbl11:
            // 1 sources

            var0 /* !! */  = (byte[])new UnsupportedEncodingException;
            var1_1 = "The loaded public key is null";
            try {
                var0 /* !! */ ((String)var1_1);
                throw var0 /* !! */ ;
            }
            catch (BadPaddingException v0) {
                var0 /* !! */  = (byte[])"rsaEncrypt():False filling parameters!";
                break block11;
            }
            catch (NoSuchPaddingException v1) {
                var0 /* !! */  = (byte[])"rsaEncrypt():  No such filling parameters ";
                break block11;
            }
            catch (InvalidKeyException v2) {
                var0 /* !! */  = (byte[])"rsaEncrypt(): init - Invalid key!";
                break block11;
            }
            catch (NoSuchAlgorithmException v3) {
                var0 /* !! */  = (byte[])"rsaEncrypt(): getInstance - No such algorithm,transformation";
                break block11;
            }
            catch (UnsupportedEncodingException v4) {
                var0 /* !! */  = (byte[])"rsaEncrypt(): getBytes - Unsupported coding format!";
            }
lbl16:
            // 1 sources

            while (true) {
                var0 /* !! */  = (byte[])"rsaEncrypt(): doFinal - The provided block is not filled with";
                break;
            }
        }
        y.f(var2_2, (String)var0 /* !! */ );
        return new byte[0];
        catch (IllegalBlockSizeException v5) {
            ** continue;
        }
    }
}

