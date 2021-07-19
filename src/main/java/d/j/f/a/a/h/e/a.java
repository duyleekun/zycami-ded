/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 */
package d.j.f.a.a.h.e;

import android.text.TextUtils;
import android.util.Base64;
import d.j.f.a.a.h.f.b;
import d.j.f.a.a.h.f.g;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public abstract class a {
    private static final String a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String b = "RSAEncrypt";
    private static final String c = "UTF-8";
    private static final String d = "";
    private static final int e = 2048;
    private static final String f = "RSA";

    public static String a(String string2, String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object = d.j.f.a.a.h.f.b.g((String)object);
            return d.j.f.a.a.h.e.a.b(string2, (PrivateKey)object);
        }
        g.f(b, "content or private key is null");
        return d;
    }

    public static String b(String object, PrivateKey object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        String string3 = b;
        if (!bl2 && object2 != null) {
            Object object3 = object2;
            object3 = (RSAPrivateKey)object2;
            bl2 = d.j.f.a.a.h.e.a.h((RSAPrivateKey)object3);
            if (bl2) {
                object = Base64.decode((String)object, (int)0);
                object = d.j.f.a.a.h.e.a.c((byte[])object, (PrivateKey)object2);
                object2 = c;
                try {
                    object3 = new String((byte[])object, (String)object2);
                    return object3;
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    object3 = "exception : ";
                    ((StringBuilder)object2).append((String)object3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)object2).append(string4);
                    string4 = ((StringBuilder)object2).toString();
                    g.f(string3, string4);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    object2 = new StringBuilder();
                    object3 = "RSA decrypt exception : ";
                    ((StringBuilder)object2).append((String)object3);
                    String string5 = unsupportedEncodingException.getMessage();
                    ((StringBuilder)object2).append(string5);
                    string5 = ((StringBuilder)object2).toString();
                    g.f(string3, string5);
                }
                return string2;
            }
        }
        g.f(string3, "content or privateKey is null , or length is too short");
        return string2;
    }

    public static byte[] c(byte[] byArray, PrivateKey serializable) {
        byte[] byArray2 = new byte[]{};
        String string2 = b;
        if (byArray != null && serializable != null) {
            Object object = serializable;
            object = (RSAPrivateKey)serializable;
            boolean bl2 = d.j.f.a.a.h.e.a.h((RSAPrivateKey)object);
            if (bl2) {
                object = a;
                object = Cipher.getInstance((String)object);
                int n10 = 2;
                ((Cipher)object).init(n10, (Key)serializable);
                try {
                    byArray2 = ((Cipher)object).doFinal(byArray);
                }
                catch (GeneralSecurityException generalSecurityException) {
                    serializable = new StringBuilder();
                    object = "RSA decrypt exception : ";
                    ((StringBuilder)serializable).append((String)object);
                    String string3 = generalSecurityException.getMessage();
                    ((StringBuilder)serializable).append(string3);
                    string3 = ((StringBuilder)serializable).toString();
                    g.f(string2, string3);
                }
                return byArray2;
            }
        }
        g.f(string2, "content or privateKey is null , or length is too short");
        return byArray2;
    }

    public static String d(String string2, String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object = d.j.f.a.a.h.f.b.h((String)object);
            return d.j.f.a.a.h.e.a.e(string2, (PublicKey)object);
        }
        g.f(b, "content or public key is null");
        return d;
    }

    public static String e(String object, PublicKey serializable) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        String string3 = b;
        if (!bl2 && serializable != null) {
            Object object2 = serializable;
            object2 = (RSAPublicKey)serializable;
            bl2 = d.j.f.a.a.h.e.a.i((RSAPublicKey)object2);
            if (bl2) {
                object2 = c;
                object = ((String)object).getBytes((String)object2);
                object = d.j.f.a.a.h.e.a.f((byte[])object, (PublicKey)serializable);
                serializable = null;
                try {
                    return Base64.encodeToString((byte[])object, (int)0);
                }
                catch (Exception exception) {
                    serializable = new StringBuilder();
                    object2 = "exception : ";
                    ((StringBuilder)serializable).append((String)object2);
                    String string4 = exception.getMessage();
                    ((StringBuilder)serializable).append(string4);
                    string4 = ((StringBuilder)serializable).toString();
                    g.f(string3, string4);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    object = "encrypt: UnsupportedEncodingException";
                    g.f(string3, (String)object);
                }
                return string2;
            }
        }
        g.f(string3, "content or PublicKey is null , or length is too short");
        return string2;
    }

    public static byte[] f(byte[] byArray, PublicKey serializable) {
        byte[] byArray2 = new byte[]{};
        String string2 = b;
        if (byArray != null && serializable != null) {
            Object object = serializable;
            object = (RSAPublicKey)serializable;
            boolean bl2 = d.j.f.a.a.h.e.a.i((RSAPublicKey)object);
            if (bl2) {
                int n10;
                object = a;
                try {
                    object = Cipher.getInstance((String)object);
                    n10 = 1;
                }
                catch (GeneralSecurityException generalSecurityException) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("RSA encrypt exception : ");
                    String string3 = generalSecurityException.getMessage();
                    ((StringBuilder)serializable).append(string3);
                    string3 = ((StringBuilder)serializable).toString();
                    g.f(string2, string3);
                    return byArray2;
                }
                ((Cipher)object).init(n10, (Key)serializable);
                return ((Cipher)object).doFinal(byArray);
            }
        }
        g.f(string2, "content or PublicKey is null , or length is too short");
        return byArray2;
    }

    public static Map g(int n10) {
        HashMap<String, Serializable> hashMap = new HashMap<String, Serializable>(2);
        int n11 = 2048;
        if (n10 < n11) {
            g.f(b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        Serializable serializable = d.j.f.a.a.h.f.b.d();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f);
        keyPairGenerator.initialize(n10, (SecureRandom)serializable);
        Serializable serializable2 = keyPairGenerator.generateKeyPair();
        serializable = serializable2.getPublic();
        serializable2 = serializable2.getPrivate();
        hashMap.put("publicKey", serializable);
        hashMap.put("privateKey", serializable2);
        return hashMap;
    }

    public static boolean h(RSAPrivateKey serializable) {
        int n10;
        boolean bl2 = false;
        if (serializable == null) {
            return false;
        }
        int n11 = ((BigInteger)(serializable = serializable.getModulus())).bitLength();
        if (n11 >= (n10 = 2048)) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean i(RSAPublicKey serializable) {
        int n10;
        boolean bl2 = false;
        if (serializable == null) {
            return false;
        }
        int n11 = ((BigInteger)(serializable = serializable.getModulus())).bitLength();
        if (n11 >= (n10 = 2048)) {
            bl2 = true;
        }
        return bl2;
    }
}

