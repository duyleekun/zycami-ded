/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package d.r.a.u;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public final class x {
    private static String a = "RSA";

    public static PublicKey a(String object) {
        int n10 = 2;
        object = Base64.decode((String)object, (int)n10);
        Object object2 = a;
        object2 = KeyFactory.getInstance((String)object2);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object);
        try {
            return ((KeyFactory)object2).generatePublic(x509EncodedKeySpec);
        }
        catch (NullPointerException nullPointerException) {
            object = new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
            throw object;
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            object = new Exception("\u516c\u94a5\u975e\u6cd5");
            throw object;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = new Exception("\u65e0\u6b64\u7b97\u6cd5");
            throw object;
        }
    }

    public static boolean b(byte[] byArray, PublicKey publicKey, byte[] byArray2) {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(byArray);
        return signature.verify(byArray2);
    }
}

