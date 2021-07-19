/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Base64
 *  org.bouncycastle.crypto.BlockCipher
 *  org.bouncycastle.crypto.engines.AESEngine
 *  org.bouncycastle.crypto.prng.SP800SecureRandomBuilder
 */
package d.j.f.a.a.h.f;

import android.os.Build;
import android.util.Base64;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

public class b {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";
    private static boolean c = false;
    private static boolean d = true;

    private static boolean a() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private static SecureRandom b() {
        Object object = a;
        String string2 = null;
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        boolean bl2 = true;
        Object object2 = new AESEngine();
        int n10 = 256;
        int n11 = 384;
        int n12 = 32;
        byte[] byArray = new byte[n12];
        secureRandom.nextBytes(byArray);
        SP800SecureRandomBuilder sP800SecureRandomBuilder = new SP800SecureRandomBuilder(secureRandom, bl2);
        secureRandom = sP800SecureRandomBuilder.setEntropyBitsRequired(n11);
        try {
            return secureRandom.buildCTR((BlockCipher)object2, n10, byArray, false);
        }
        catch (Throwable throwable) {
            bl2 = d;
            if (bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                object2 = "exception : ";
                stringBuilder.append((String)object2);
                String string3 = throwable.getMessage();
                stringBuilder.append(string3);
                stringBuilder.append(" , you should implementation bcprov-jdk15on library");
                string3 = stringBuilder.toString();
                g.f((String)object, string3);
                d = false;
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            string2 = "NoSuchAlgorithmException";
            g.f((String)object, string2);
        }
        object = new SecureRandom();
        return object;
    }

    private static byte[] c(int n10) {
        String string2 = "generateSecureRandomNew ";
        g.c(a, string2);
        SecureRandom secureRandom = d.j.f.a.a.h.f.b.b();
        if (secureRandom == null) {
            return new byte[0];
        }
        byte[] byArray = new byte[n10];
        secureRandom.nextBytes(byArray);
        return byArray;
    }

    public static SecureRandom d() {
        boolean bl2 = c;
        if (bl2 && (bl2 = d.j.f.a.a.h.f.b.a())) {
            return d.j.f.a.a.h.f.b.b();
        }
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom;
    }

    public static byte[] e(int n10) {
        byte[] byArray;
        Serializable serializable;
        boolean bl2 = c;
        if (bl2 && (bl2 = d.j.f.a.a.h.f.b.a())) {
            return d.j.f.a.a.h.f.b.c(n10);
        }
        try {
            serializable = new SecureRandom();
            byArray = new byte[n10];
        }
        catch (Exception exception) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("generate secure random error");
            String string2 = exception.getMessage();
            ((StringBuilder)serializable).append(string2);
            string2 = ((StringBuilder)serializable).toString();
            g.f(a, string2);
            return new byte[0];
        }
        ((SecureRandom)serializable).nextBytes(byArray);
        return byArray;
    }

    public static String f(int n10) {
        return d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.f.b.e(n10));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PrivateKey g(String object) {
        String string2 = a;
        Object object2 = null;
        try {
            object = Base64.decode((String)object, (int)0);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("base64 decode Exception");
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            g.f(string2, string4);
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            g.f(string2, "base64 decode IllegalArgumentException");
            return null;
        }
        try {
            object2 = new PKCS8EncodedKeySpec((byte[])object);
            object = b;
            object = KeyFactory.getInstance((String)object);
            return ((KeyFactory)object).generatePrivate((KeySpec)object2);
        }
        catch (GeneralSecurityException generalSecurityException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("load Key Exception:");
            String string3 = generalSecurityException.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            g.f(string2, string3);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RSAPublicKey h(String object) {
        String string2 = a;
        Object object2 = null;
        try {
            object = Base64.decode((String)object, (int)0);
            object2 = b;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("base64 decode Exception");
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            g.f(string2, string4);
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            g.f(string2, "base64 decode IllegalArgumentException");
            return null;
        }
        try {
            object2 = KeyFactory.getInstance((String)object2);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object);
            object = ((KeyFactory)object2).generatePublic(x509EncodedKeySpec);
            return (RSAPublicKey)object;
        }
        catch (GeneralSecurityException generalSecurityException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("load Key Exception:");
            String string3 = generalSecurityException.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            g.f(string2, string3);
            return null;
        }
    }

    public static boolean i() {
        return c;
    }

    public static void j(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setBouncycastleFlag: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        g.d(a, (String)charSequence);
        c = bl2;
    }
}

