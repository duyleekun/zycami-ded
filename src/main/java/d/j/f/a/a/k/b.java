/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package d.j.f.a.a.k;

import android.util.Base64;
import com.huawei.secure.android.common.util.LogsUtil;
import d.j.f.a.a.k.c;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class b {
    private static final String a = "b";
    private static final String b = "RSA";

    public static byte[] a(int n10) {
        byte[] byArray;
        Object object;
        try {
            object = new SecureRandom();
            byArray = new byte[n10];
        }
        catch (Exception exception) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("generate secure random error");
            String string2 = exception.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            LogsUtil.q((String)object, string2, true);
            return new byte[0];
        }
        ((SecureRandom)object).nextBytes(byArray);
        return byArray;
    }

    public static String b(int n10) {
        return c.b(d.j.f.a.a.k.b.a(n10));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PrivateKey c(String object) {
        Object object2 = null;
        boolean bl2 = true;
        try {
            object = Base64.decode((String)object, (int)0);
        }
        catch (Exception exception) {
            LogsUtil.q(a, "base64 decode Exception", bl2);
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            LogsUtil.q(a, "base64 decode IllegalArgumentException", bl2);
            return null;
        }
        try {
            object2 = new PKCS8EncodedKeySpec((byte[])object);
            object = b;
            object = KeyFactory.getInstance((String)object);
            return ((KeyFactory)object).generatePrivate((KeySpec)object2);
        }
        catch (GeneralSecurityException generalSecurityException) {
            object2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("load Key Exception:");
            String string2 = generalSecurityException.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            LogsUtil.q((String)object2, string2, bl2);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RSAPublicKey d(String object) {
        Object object3 = null;
        boolean bl2 = true;
        try {
            object = Base64.decode((String)object, (int)0);
            object3 = b;
        }
        catch (Exception exception) {
            LogsUtil.q(a, "base64 decode Exception", bl2);
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            LogsUtil.q(a, "base64 decode IllegalArgumentException", bl2);
            return null;
        }
        try {
            object3 = KeyFactory.getInstance((String)object3);
            X509EncodedKeySpec object2 = new X509EncodedKeySpec((byte[])object);
            object = ((KeyFactory)object3).generatePublic(object2);
            return (RSAPublicKey)object;
        }
        catch (GeneralSecurityException generalSecurityException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("load Key Exception:");
            String string2 = generalSecurityException.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            LogsUtil.q((String)object3, string2, bl2);
            return null;
        }
    }
}

