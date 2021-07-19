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
import d.j.f.a.a.h.e.a;
import d.j.f.a.a.h.f.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public abstract class b {
    private static final String a = "SHA256WithRSA";
    private static final String b = "SHA256WithRSA/PSS";
    private static final String c = "b";
    private static final String d = "UTF-8";
    private static final String e = "";

    private static String a(String string2, String object, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)object))) {
            object = d.j.f.a.a.h.f.b.g((String)object);
            if (bl2) {
                return d.j.f.a.a.h.e.b.f(string2, (PrivateKey)object);
            }
            return d.j.f.a.a.h.e.b.j(string2, (PrivateKey)object);
        }
        g.f(c, "sign content or key is null");
        return e;
    }

    private static String b(String object, PrivateKey object2, boolean bl2) {
        String string2 = d;
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sign UnsupportedEncodingException: ");
            String string3 = unsupportedEncodingException.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            g.f((String)object2, string3);
            return e;
        }
        object = d.j.f.a.a.h.e.b.k((byte[])object, (PrivateKey)object2, bl2);
        object2 = null;
        return Base64.encodeToString((byte[])object, (int)0);
    }

    private static boolean c(String string2, String string3, String object, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!(bl3 || (bl3 = TextUtils.isEmpty((CharSequence)object)) || (bl3 = TextUtils.isEmpty((CharSequence)string3)))) {
            object = d.j.f.a.a.h.f.b.h((String)object);
            if (bl2) {
                return d.j.f.a.a.h.e.b.h(string2, string3, (PublicKey)object);
            }
            return d.j.f.a.a.h.e.b.m(string2, string3, (PublicKey)object);
        }
        g.f(c, "content or public key or sign value is null");
        return false;
    }

    private static boolean d(String object, String object2, PublicKey serializable, boolean bl2) {
        String string2 = d;
        object = ((String)object).getBytes(string2);
        object2 = Base64.decode((String)object2, (int)0);
        try {
            return d.j.f.a.a.h.e.b.n((byte[])object, (byte[])object2, (PublicKey)serializable, bl2);
        }
        catch (Exception exception) {
            object2 = c;
            serializable = new StringBuilder();
            String string3 = "base64 decode Exception : ";
            ((StringBuilder)serializable).append(string3);
            String string4 = exception.getMessage();
            ((StringBuilder)serializable).append(string4);
            string4 = ((StringBuilder)serializable).toString();
            g.f((String)object2, string4);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = c;
            serializable = new StringBuilder();
            String string5 = "verifySign UnsupportedEncodingException: ";
            ((StringBuilder)serializable).append(string5);
            String string6 = unsupportedEncodingException.getMessage();
            ((StringBuilder)serializable).append(string6);
            string6 = ((StringBuilder)serializable).toString();
            g.f((String)object2, string6);
        }
        return false;
    }

    public static String e(String string2, String string3) {
        boolean bl2 = d.j.f.a.a.h.d.b.b.f();
        if (!bl2) {
            g.f(c, "sdk version is too low");
            return e;
        }
        return d.j.f.a.a.h.e.b.a(string2, string3, true);
    }

    public static String f(String string2, PrivateKey privateKey) {
        boolean bl2 = d.j.f.a.a.h.d.b.b.f();
        if (!bl2) {
            g.f(c, "sdk version is too low");
            return e;
        }
        return d.j.f.a.a.h.e.b.b(string2, privateKey, true);
    }

    public static boolean g(String string2, String string3, String string4) {
        boolean bl2 = d.j.f.a.a.h.d.b.b.f();
        if (!bl2) {
            g.f(c, "sdk version is too low");
            return false;
        }
        return d.j.f.a.a.h.e.b.c(string2, string3, string4, true);
    }

    public static boolean h(String string2, String string3, PublicKey publicKey) {
        boolean bl2 = d.j.f.a.a.h.d.b.b.f();
        if (!bl2) {
            g.f(c, "sdk version is too low");
            return false;
        }
        return d.j.f.a.a.h.e.b.d(string2, string3, publicKey, true);
    }

    public static String i(String string2, String string3) {
        return d.j.f.a.a.h.e.b.a(string2, string3, false);
    }

    public static String j(String string2, PrivateKey privateKey) {
        return d.j.f.a.a.h.e.b.b(string2, privateKey, false);
    }

    public static byte[] k(byte[] byArray, PrivateKey object, boolean bl2) {
        byte[] byArray2 = new byte[]{};
        if (byArray != null && object != null) {
            Object object2 = object;
            object2 = (RSAPrivateKey)object;
            boolean bl3 = d.j.f.a.a.h.e.a.h((RSAPrivateKey)object2);
            if (bl3) {
                Object object3;
                if (bl2) {
                    PSSParameterSpec pSSParameterSpec;
                    object3 = b;
                    object3 = Signature.getInstance((String)object3);
                    String string2 = "SHA-256";
                    String string3 = "MGF1";
                    MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
                    int n10 = 32;
                    int n11 = 1;
                    object2 = pSSParameterSpec;
                    pSSParameterSpec = new PSSParameterSpec(string2, string3, mGF1ParameterSpec, n10, n11);
                    ((Signature)object3).setParameter(pSSParameterSpec);
                } else {
                    object3 = a;
                    object3 = Signature.getInstance((String)object3);
                }
                ((Signature)object3).initSign((PrivateKey)object);
                try {
                    ((Signature)object3).update(byArray);
                    byArray2 = ((Signature)object3).sign();
                }
                catch (Exception exception) {
                    object = c;
                    object3 = new StringBuilder();
                    object2 = "sign Exception: ";
                    ((StringBuilder)object3).append((String)object2);
                    String string4 = exception.getMessage();
                    ((StringBuilder)object3).append(string4);
                    string4 = ((StringBuilder)object3).toString();
                    g.f((String)object, string4);
                }
                catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                    object = c;
                    object3 = new StringBuilder();
                    object2 = "sign InvalidAlgorithmParameterException: ";
                    ((StringBuilder)object3).append((String)object2);
                    String string5 = invalidAlgorithmParameterException.getMessage();
                    ((StringBuilder)object3).append(string5);
                    string5 = ((StringBuilder)object3).toString();
                    g.f((String)object, string5);
                }
                catch (SignatureException signatureException) {
                    object = c;
                    object3 = new StringBuilder();
                    object2 = "sign SignatureException: ";
                    ((StringBuilder)object3).append((String)object2);
                    String string6 = signatureException.getMessage();
                    ((StringBuilder)object3).append(string6);
                    string6 = ((StringBuilder)object3).toString();
                    g.f((String)object, string6);
                }
                catch (InvalidKeyException invalidKeyException) {
                    object = c;
                    object3 = new StringBuilder();
                    object2 = "sign InvalidKeyException: ";
                    ((StringBuilder)object3).append((String)object2);
                    String string7 = invalidKeyException.getMessage();
                    ((StringBuilder)object3).append(string7);
                    string7 = ((StringBuilder)object3).toString();
                    g.f((String)object, string7);
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    object = c;
                    object3 = new StringBuilder();
                    object2 = "sign NoSuchAlgorithmException: ";
                    ((StringBuilder)object3).append((String)object2);
                    String string8 = noSuchAlgorithmException.getMessage();
                    ((StringBuilder)object3).append(string8);
                    string8 = ((StringBuilder)object3).toString();
                    g.f((String)object, string8);
                }
                return byArray2;
            }
        }
        g.f(c, "content or privateKey is null , or length is too short");
        return byArray2;
    }

    public static boolean l(String string2, String string3, String string4) {
        return d.j.f.a.a.h.e.b.c(string2, string3, string4, false);
    }

    public static boolean m(String string2, String string3, PublicKey publicKey) {
        return d.j.f.a.a.h.e.b.d(string2, string3, publicKey, false);
    }

    public static boolean n(byte[] byArray, byte[] object, PublicKey serializable, boolean bl2) {
        if (byArray != null && serializable != null && object != null) {
            Object object2 = serializable;
            object2 = (RSAPublicKey)serializable;
            boolean bl3 = d.j.f.a.a.h.e.a.i((RSAPublicKey)object2);
            if (bl3) {
                Object object3;
                if (bl2) {
                    PSSParameterSpec pSSParameterSpec;
                    object3 = b;
                    object3 = Signature.getInstance((String)object3);
                    String string2 = "SHA-256";
                    String string3 = "MGF1";
                    MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
                    int n10 = 32;
                    int n11 = 1;
                    object2 = pSSParameterSpec;
                    pSSParameterSpec = new PSSParameterSpec(string2, string3, mGF1ParameterSpec, n10, n11);
                    ((Signature)object3).setParameter(pSSParameterSpec);
                } else {
                    object3 = a;
                    object3 = Signature.getInstance((String)object3);
                }
                ((Signature)object3).initVerify((PublicKey)serializable);
                ((Signature)object3).update(byArray);
                try {
                    return ((Signature)object3).verify((byte[])object);
                }
                catch (Exception exception) {
                    object = c;
                    serializable = new StringBuilder();
                    object3 = "exception : ";
                    ((StringBuilder)serializable).append((String)object3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)serializable).append(string4);
                    string4 = ((StringBuilder)serializable).toString();
                    g.f((String)object, string4);
                }
                catch (GeneralSecurityException generalSecurityException) {
                    object = c;
                    serializable = new StringBuilder();
                    object3 = "check sign exception: ";
                    ((StringBuilder)serializable).append((String)object3);
                    String string5 = generalSecurityException.getMessage();
                    ((StringBuilder)serializable).append(string5);
                    string5 = ((StringBuilder)serializable).toString();
                    g.f((String)object, string5);
                }
                return false;
            }
        }
        g.f(c, "content or publicKey is null , or length is too short");
        return false;
    }
}

