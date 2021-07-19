/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.keystore.KeyGenParameterSpec$Builder
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Log
 */
package d.j.f.a.a.h.d.b;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import d.j.f.a.a.h.f.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;

public abstract class b {
    private static final String a = "b";
    private static final String b = "AndroidKeyStore";
    private static final String c = "SHA256withRSA/PSS";
    private static final String d = "";
    private static final int e = 2048;
    private static final int f = 3072;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static KeyPair a(String stringArray, boolean bl2) {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            boolean bl3 = d.j.f.a.a.h.d.b.b.e((String)stringArray);
            KeyPair keyPair = null;
            if (bl3) {
                stringArray = a;
                String string2 = "Key pair exits";
                g.f((String)stringArray, string2);
                return null;
            }
            Object object = "RSA";
            String string3 = b;
            try {
                int n10;
                object = KeyPairGenerator.getInstance((String)object, string3);
                int n11 = 12;
                if (n10 == 0) {
                    String[] stringArray2 = new KeyGenParameterSpec.Builder((String)stringArray, n11);
                    stringArray = "SHA-256";
                    string3 = "SHA-512";
                    stringArray = new String[]{stringArray, string3};
                    stringArray = stringArray2.setDigests(stringArray);
                    stringArray2 = "PSS";
                    stringArray2 = new String[]{stringArray2};
                    stringArray = stringArray.setSignaturePaddings(stringArray2);
                    n10 = 2048;
                    stringArray = stringArray.setKeySize(n10);
                    stringArray = stringArray.build();
                    ((KeyPairGenerator)object).initialize((AlgorithmParameterSpec)stringArray);
                    return ((KeyPairGenerator)object).generateKeyPair();
                } else {
                    String[] stringArray3 = new KeyGenParameterSpec.Builder((String)stringArray, n11);
                    stringArray = "SHA-256";
                    string3 = "SHA-512";
                    stringArray = new String[]{stringArray, string3};
                    stringArray = stringArray3.setDigests(stringArray);
                    stringArray3 = "PSS";
                    stringArray3 = new String[]{stringArray3};
                    stringArray = stringArray.setSignaturePaddings(stringArray3);
                    n10 = 3072;
                    stringArray = stringArray.setKeySize(n10);
                    stringArray = stringArray.build();
                    ((KeyPairGenerator)object).initialize((AlgorithmParameterSpec)stringArray);
                }
                return ((KeyPairGenerator)object).generateKeyPair();
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                String string4 = a;
                object = new StringBuilder();
                string3 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object).append(string3);
                String string5 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object).append(string5);
                string5 = ((StringBuilder)object).toString();
                g.f(string4, string5);
            }
            catch (NoSuchProviderException noSuchProviderException) {
                String string6 = a;
                object = new StringBuilder();
                string3 = "NoSuchProviderException: ";
                ((StringBuilder)object).append(string3);
                String string7 = noSuchProviderException.getMessage();
                ((StringBuilder)object).append(string7);
                string7 = ((StringBuilder)object).toString();
                g.f(string6, string7);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                String string8 = a;
                object = new StringBuilder();
                string3 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object).append(string3);
                String string9 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object).append(string9);
                string9 = ((StringBuilder)object).toString();
                g.f(string8, string9);
            }
            return keyPair;
        }
    }

    private static boolean b(String object, byte[] object2, byte[] object3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        boolean bl4 = false;
        if (!bl3 && object2 != null && object3 != null) {
            bl3 = d.j.f.a.a.h.d.b.b.f();
            if (!bl3) {
                g.f(a, "sdk version is too low");
                return false;
            }
            if (!(bl2 = (object = d.j.f.a.a.h.d.b.b.d((String)object, bl2)) instanceof KeyStore.PrivateKeyEntry)) {
                g.f(a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            Object object4 = c;
            object4 = Signature.getInstance((String)object4);
            object = (KeyStore.PrivateKeyEntry)object;
            object = ((KeyStore.PrivateKeyEntry)object).getCertificate();
            ((Signature)object4).initVerify((Certificate)object);
            ((Signature)object4).update((byte[])object2);
            try {
                bl4 = ((Signature)object4).verify((byte[])object3);
            }
            catch (Exception exception) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                object4 = "Exception: ";
                ((StringBuilder)object3).append((String)object4);
                String string2 = exception.getMessage();
                ((StringBuilder)object3).append(string2);
                string2 = ((StringBuilder)object3).toString();
                g.f((String)object2, string2);
            }
            catch (InvalidKeyException invalidKeyException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                object4 = "InvalidKeyException: ";
                ((StringBuilder)object3).append((String)object4);
                String string3 = invalidKeyException.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                g.f((String)object2, string3);
            }
            catch (SignatureException signatureException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                object4 = "SignatureException: ";
                ((StringBuilder)object3).append((String)object4);
                String string4 = signatureException.getMessage();
                ((StringBuilder)object3).append(string4);
                string4 = ((StringBuilder)object3).toString();
                g.f((String)object2, string4);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                object4 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object3).append((String)object4);
                String string5 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object3).append(string5);
                string5 = ((StringBuilder)object3).toString();
                g.f((String)object2, string5);
            }
            return bl4;
        }
        g.f(a, "alias or content or sign value is null");
        return false;
    }

    private static byte[] c(String object, byte[] object2, boolean bl2) {
        byte[] byArray = new byte[]{};
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3 && object2 != null) {
            bl3 = d.j.f.a.a.h.d.b.b.f();
            if (!bl3) {
                g.f(a, "sdk version is too low");
                return byArray;
            }
            if (!(bl2 = (object = d.j.f.a.a.h.d.b.b.d((String)object, bl2)) instanceof KeyStore.PrivateKeyEntry)) {
                g.f(a, "Not an instance of a PrivateKeyEntry");
                return byArray;
            }
            Object object3 = c;
            object3 = Signature.getInstance((String)object3);
            object = (KeyStore.PrivateKeyEntry)object;
            object = ((KeyStore.PrivateKeyEntry)object).getPrivateKey();
            ((Signature)object3).initSign((PrivateKey)object);
            try {
                ((Signature)object3).update((byte[])object2);
                return ((Signature)object3).sign();
            }
            catch (Exception exception) {
                object2 = a;
                object3 = new StringBuilder();
                String string2 = "Exception: ";
                ((StringBuilder)object3).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                g.f((String)object2, string3);
            }
            catch (InvalidKeyException invalidKeyException) {
                object2 = a;
                object3 = new StringBuilder();
                String string4 = "InvalidKeyException: ";
                ((StringBuilder)object3).append(string4);
                String string5 = invalidKeyException.getMessage();
                ((StringBuilder)object3).append(string5);
                string5 = ((StringBuilder)object3).toString();
                g.f((String)object2, string5);
            }
            catch (SignatureException signatureException) {
                object2 = a;
                object3 = new StringBuilder();
                String string6 = "SignatureException: ";
                ((StringBuilder)object3).append(string6);
                String string7 = signatureException.getMessage();
                ((StringBuilder)object3).append(string7);
                string7 = ((StringBuilder)object3).toString();
                g.f((String)object2, string7);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object2 = a;
                object3 = new StringBuilder();
                String string8 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object3).append(string8);
                String string9 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object3).append(string9);
                string9 = ((StringBuilder)object3).toString();
                g.f((String)object2, string9);
            }
            return byArray;
        }
        g.f(a, "alias or content is null");
        return byArray;
    }

    private static KeyStore.Entry d(String string2, boolean bl2) {
        boolean bl3 = d.j.f.a.a.h.d.b.b.e(string2);
        if (!bl3) {
            d.j.f.a.a.h.d.b.b.a(string2, bl2);
        }
        bl2 = false;
        KeyStore.Entry entry = null;
        Object object = b;
        object = KeyStore.getInstance((String)object);
        ((KeyStore)object).load(null);
        try {
            entry = ((KeyStore)object).getEntry(string2, null);
        }
        catch (UnrecoverableEntryException unrecoverableEntryException) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "UnrecoverableEntryException: ";
            stringBuilder.append(string3);
            String string4 = unrecoverableEntryException.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            g.f((String)object, string4);
        }
        catch (IOException iOException) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "IOException: ";
            stringBuilder.append(string5);
            String string6 = iOException.getMessage();
            stringBuilder.append(string6);
            string6 = stringBuilder.toString();
            g.f((String)object, string6);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = "NoSuchAlgorithmException: ";
            stringBuilder.append(string7);
            String string8 = noSuchAlgorithmException.getMessage();
            stringBuilder.append(string8);
            string8 = stringBuilder.toString();
            g.f((String)object, string8);
        }
        catch (CertificateException certificateException) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string9 = "CertificateException: ";
            stringBuilder.append(string9);
            String string10 = certificateException.getMessage();
            stringBuilder.append(string10);
            string10 = stringBuilder.toString();
            g.f((String)object, string10);
        }
        catch (KeyStoreException keyStoreException) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string11 = "KeyStoreException: ";
            stringBuilder.append(string11);
            String string12 = keyStoreException.getMessage();
            stringBuilder.append(string12);
            string12 = stringBuilder.toString();
            g.f((String)object, string12);
        }
        return entry;
    }

    private static boolean e(String object) {
        boolean bl2 = false;
        Object object2 = b;
        object2 = KeyStore.getInstance((String)object2);
        StringBuilder stringBuilder = null;
        ((KeyStore)object2).load(null);
        try {
            object = ((KeyStore)object2).getKey((String)object, null);
            if (object != null) {
                bl2 = true;
            }
            return bl2;
        }
        catch (IOException iOException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string2 = "IOException: ";
            stringBuilder.append(string2);
            String string3 = iOException.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            g.f((String)object2, string3);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string4 = "NoSuchAlgorithmException: ";
            stringBuilder.append(string4);
            String string5 = noSuchAlgorithmException.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            g.f((String)object2, string5);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string6 = "UnrecoverableKeyException: ";
            stringBuilder.append(string6);
            String string7 = unrecoverableKeyException.getMessage();
            stringBuilder.append(string7);
            string7 = stringBuilder.toString();
            g.f((String)object2, string7);
        }
        catch (CertificateException certificateException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string8 = "CertificateException: ";
            stringBuilder.append(string8);
            String string9 = certificateException.getMessage();
            stringBuilder.append(string9);
            string9 = stringBuilder.toString();
            g.f((String)object2, string9);
        }
        catch (KeyStoreException keyStoreException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string10 = "KeyStoreException: ";
            stringBuilder.append(string10);
            String string11 = keyStoreException.getMessage();
            stringBuilder.append(string11);
            string11 = stringBuilder.toString();
            g.f((String)object2, string11);
        }
        return false;
    }

    public static boolean f() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static String g(String object, String object2) {
        CharSequence charSequence = "UTF-8";
        try {
            object2 = ((String)object2).getBytes((String)charSequence);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = a;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("sign UnsupportedEncodingException : ");
            String string2 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            Log.e((String)object2, (String)string2);
            return d;
        }
        object = d.j.f.a.a.h.d.b.b.h((String)object, (byte[])object2);
        object2 = null;
        return Base64.encodeToString((byte[])object, (int)0);
    }

    public static byte[] h(String string2, byte[] byArray) {
        return d.j.f.a.a.h.d.b.b.c(string2, byArray, false);
    }

    public static String i(String object, String object2) {
        CharSequence charSequence = "UTF-8";
        try {
            object2 = ((String)object2).getBytes((String)charSequence);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = a;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("sign UnsupportedEncodingException : ");
            String string2 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            Log.e((String)object2, (String)string2);
            return d;
        }
        object = d.j.f.a.a.h.d.b.b.j((String)object, (byte[])object2);
        object2 = null;
        return Base64.encodeToString((byte[])object, (int)0);
    }

    public static byte[] j(String string2, byte[] byArray) {
        return d.j.f.a.a.h.d.b.b.c(string2, byArray, true);
    }

    public static boolean k(String string2, String object, String object2) {
        String string3 = "UTF-8";
        object = ((String)object).getBytes(string3);
        object2 = Base64.decode((String)object2, (int)0);
        try {
            return d.j.f.a.a.h.d.b.b.l(string2, (byte[])object, (byte[])object2);
        }
        catch (Exception exception) {
            object = a;
            object2 = new StringBuilder();
            string3 = "base64 decode Exception";
            ((StringBuilder)object2).append(string3);
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            g.f((String)object, string4);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = a;
            object2 = new StringBuilder();
            string3 = "verifySign UnsupportedEncodingException: ";
            ((StringBuilder)object2).append(string3);
            String string5 = unsupportedEncodingException.getMessage();
            ((StringBuilder)object2).append(string5);
            string5 = ((StringBuilder)object2).toString();
            Log.e((String)object, (String)string5);
        }
        return false;
    }

    public static boolean l(String string2, byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.d.b.b.b(string2, byArray, byArray2, false);
    }

    public static boolean m(String string2, String object, String object2) {
        String string3 = "UTF-8";
        object = ((String)object).getBytes(string3);
        object2 = Base64.decode((String)object2, (int)0);
        try {
            return d.j.f.a.a.h.d.b.b.n(string2, (byte[])object, (byte[])object2);
        }
        catch (Exception exception) {
            object = a;
            object2 = new StringBuilder();
            string3 = "base64 decode Exception";
            ((StringBuilder)object2).append(string3);
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            g.f((String)object, string4);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = a;
            object2 = new StringBuilder();
            string3 = "verifySign UnsupportedEncodingException: ";
            ((StringBuilder)object2).append(string3);
            String string5 = unsupportedEncodingException.getMessage();
            ((StringBuilder)object2).append(string5);
            string5 = ((StringBuilder)object2).toString();
            Log.e((String)object, (String)string5);
        }
        return false;
    }

    public static boolean n(String string2, byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.d.b.b.b(string2, byArray, byArray2, true);
    }
}

