/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.keystore.KeyGenParameterSpec$Builder
 *  android.text.TextUtils
 *  android.util.Base64
 */
package d.j.f.a.a.h.d.b;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import d.j.f.a.a.h.f.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public abstract class a {
    private static final String a = "a";
    private static final String b = "AndroidKeyStore";
    private static final String c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String d = "";
    private static final int e = 2048;
    private static final int f = 3072;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static KeyPair a(String stringArray, boolean bl2) {
        Class<a> clazz = a.class;
        synchronized (clazz) {
            boolean bl3 = d.j.f.a.a.h.d.b.a.m((String)stringArray);
            KeyPair keyPair = null;
            if (bl3) {
                stringArray = a;
                String string2 = "Key pair exits";
                g.f((String)stringArray, string2);
                return null;
            }
            Object object = a;
            String string3 = "generate key pair.";
            g.d((String)object, string3);
            object = "RSA";
            string3 = b;
            try {
                int n10;
                object = KeyPairGenerator.getInstance((String)object, string3);
                int n11 = 2;
                if (n10 == 0) {
                    String[] stringArray2 = new KeyGenParameterSpec.Builder((String)stringArray, n11);
                    stringArray = "SHA-256";
                    string3 = "SHA-512";
                    stringArray = new String[]{stringArray, string3};
                    stringArray = stringArray2.setDigests(stringArray);
                    stringArray2 = "OAEPPadding";
                    stringArray2 = new String[]{stringArray2};
                    stringArray = stringArray.setEncryptionPaddings(stringArray2);
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
                    stringArray3 = "OAEPPadding";
                    stringArray3 = new String[]{stringArray3};
                    stringArray = stringArray.setEncryptionPaddings(stringArray3);
                    n10 = 3072;
                    stringArray = stringArray.setKeySize(n10);
                    stringArray = stringArray.build();
                    ((KeyPairGenerator)object).initialize((AlgorithmParameterSpec)stringArray);
                }
                return ((KeyPairGenerator)object).generateKeyPair();
            }
            catch (Exception exception) {
                String string4 = a;
                object = new StringBuilder();
                string3 = "Exception: ";
                ((StringBuilder)object).append(string3);
                String string5 = exception.getMessage();
                ((StringBuilder)object).append(string5);
                string5 = ((StringBuilder)object).toString();
                g.f(string4, string5);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                String string6 = a;
                object = new StringBuilder();
                string3 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object).append(string3);
                String string7 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object).append(string7);
                string7 = ((StringBuilder)object).toString();
                g.f(string6, string7);
            }
            catch (NoSuchProviderException noSuchProviderException) {
                String string8 = a;
                object = new StringBuilder();
                string3 = "NoSuchProviderException: ";
                ((StringBuilder)object).append(string3);
                String string9 = noSuchProviderException.getMessage();
                ((StringBuilder)object).append(string9);
                string9 = ((StringBuilder)object).toString();
                g.f(string8, string9);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                String string10 = a;
                object = new StringBuilder();
                string3 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object).append(string3);
                String string11 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object).append(string11);
                string11 = ((StringBuilder)object).toString();
                g.f(string10, string11);
            }
            return keyPair;
        }
    }

    private static byte[] b(String object, byte[] object2, boolean bl2) {
        byte[] byArray = new byte[]{};
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3 && object2 != null) {
            bl3 = d.j.f.a.a.h.d.b.a.o();
            if (!bl3) {
                g.f(a, "sdk version is too low");
                return byArray;
            }
            if ((object = d.j.f.a.a.h.d.b.a.c((String)object, bl2)) == null) {
                g.f(a, "Public key is null");
                return byArray;
            }
            Object object3 = c;
            object3 = Cipher.getInstance((String)object3);
            String string2 = "SHA-256";
            String string3 = "MGF1";
            Object object4 = "SHA-1";
            MGF1ParameterSpec mGF1ParameterSpec = new MGF1ParameterSpec((String)object4);
            object4 = PSource.PSpecified.DEFAULT;
            Object object5 = new OAEPParameterSpec(string2, string3, mGF1ParameterSpec, (PSource)object4);
            int n10 = 1;
            ((Cipher)object3).init(n10, (Key)object, (AlgorithmParameterSpec)object5);
            try {
                return ((Cipher)object3).doFinal((byte[])object2);
            }
            catch (Exception exception) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "Exception: ";
                ((StringBuilder)object3).append((String)object5);
                String string4 = exception.getMessage();
                ((StringBuilder)object3).append(string4);
                string4 = ((StringBuilder)object3).toString();
                g.f((String)object2, string4);
            }
            catch (BadPaddingException badPaddingException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "BadPaddingException: ";
                ((StringBuilder)object3).append((String)object5);
                String string5 = badPaddingException.getMessage();
                ((StringBuilder)object3).append(string5);
                string5 = ((StringBuilder)object3).toString();
                g.f((String)object2, string5);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "IllegalBlockSizeException: ";
                ((StringBuilder)object3).append((String)object5);
                String string6 = illegalBlockSizeException.getMessage();
                ((StringBuilder)object3).append(string6);
                string6 = ((StringBuilder)object3).toString();
                g.f((String)object2, string6);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object3).append((String)object5);
                String string7 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object3).append(string7);
                string7 = ((StringBuilder)object3).toString();
                g.f((String)object2, string7);
            }
            catch (InvalidKeyException invalidKeyException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "InvalidKeyException: ";
                ((StringBuilder)object3).append((String)object5);
                String string8 = invalidKeyException.getMessage();
                ((StringBuilder)object3).append(string8);
                string8 = ((StringBuilder)object3).toString();
                g.f((String)object2, string8);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "NoSuchPaddingException: ";
                ((StringBuilder)object3).append((String)object5);
                String string9 = noSuchPaddingException.getMessage();
                ((StringBuilder)object3).append(string9);
                string9 = ((StringBuilder)object3).toString();
                g.f((String)object2, string9);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object3).append((String)object5);
                String string10 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object3).append(string10);
                string10 = ((StringBuilder)object3).toString();
                g.f((String)object2, string10);
            }
            return byArray;
        }
        g.f(a, "alias or content is null");
        return byArray;
    }

    private static PublicKey c(String object, boolean bl2) {
        boolean bl3 = d.j.f.a.a.h.d.b.a.m((String)object);
        if (!bl3) {
            d.j.f.a.a.h.d.b.a.a((String)object, bl2);
        }
        if ((object = d.j.f.a.a.h.d.b.a.l((String)object)) != null) {
            return ((Certificate)object).getPublicKey();
        }
        return null;
    }

    public static String d(String object, String object2) {
        CharSequence charSequence;
        String string2 = null;
        object2 = Base64.decode((String)object2, (int)0);
        object = d.j.f.a.a.h.d.b.a.e((String)object, (byte[])object2);
        object2 = "UTF-8";
        try {
            charSequence = new String((byte[])object, (String)object2);
            return charSequence;
        }
        catch (Exception exception) {
            object2 = a;
            charSequence = new StringBuilder();
            string2 = "Exception: ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            g.f((String)object2, string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = a;
            charSequence = new StringBuilder();
            string2 = "UnsupportedEncodingException: ";
            ((StringBuilder)charSequence).append(string2);
            String string4 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            g.f((String)object2, string4);
        }
        return d;
    }

    public static byte[] e(String object, byte[] object2) {
        byte[] byArray = new byte[]{};
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && object2 != null) {
            bl2 = d.j.f.a.a.h.d.b.a.o();
            if (!bl2) {
                g.f(a, "sdk version is too low");
                return byArray;
            }
            if ((object = d.j.f.a.a.h.d.b.a.n((String)object)) == null) {
                g.f(a, "Private key is null");
                return byArray;
            }
            Object object3 = c;
            object3 = Cipher.getInstance((String)object3);
            String string2 = "SHA-256";
            String string3 = "MGF1";
            Object object4 = "SHA-1";
            MGF1ParameterSpec mGF1ParameterSpec = new MGF1ParameterSpec((String)object4);
            object4 = PSource.PSpecified.DEFAULT;
            Object object5 = new OAEPParameterSpec(string2, string3, mGF1ParameterSpec, (PSource)object4);
            int n10 = 2;
            ((Cipher)object3).init(n10, (Key)object, (AlgorithmParameterSpec)object5);
            try {
                return ((Cipher)object3).doFinal((byte[])object2);
            }
            catch (Exception exception) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "Exception: ";
                ((StringBuilder)object3).append((String)object5);
                String string4 = exception.getMessage();
                ((StringBuilder)object3).append(string4);
                string4 = ((StringBuilder)object3).toString();
                g.f((String)object2, string4);
            }
            catch (BadPaddingException badPaddingException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "BadPaddingException: ";
                ((StringBuilder)object3).append((String)object5);
                String string5 = badPaddingException.getMessage();
                ((StringBuilder)object3).append(string5);
                string5 = ((StringBuilder)object3).toString();
                g.f((String)object2, string5);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "IllegalBlockSizeException: ";
                ((StringBuilder)object3).append((String)object5);
                String string6 = illegalBlockSizeException.getMessage();
                ((StringBuilder)object3).append(string6);
                string6 = ((StringBuilder)object3).toString();
                g.f((String)object2, string6);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object3).append((String)object5);
                String string7 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object3).append(string7);
                string7 = ((StringBuilder)object3).toString();
                g.f((String)object2, string7);
            }
            catch (InvalidKeyException invalidKeyException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "InvalidKeyException: ";
                ((StringBuilder)object3).append((String)object5);
                String string8 = invalidKeyException.getMessage();
                ((StringBuilder)object3).append(string8);
                string8 = ((StringBuilder)object3).toString();
                g.f((String)object2, string8);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "NoSuchPaddingException: ";
                ((StringBuilder)object3).append((String)object5);
                String string9 = noSuchPaddingException.getMessage();
                ((StringBuilder)object3).append(string9);
                string9 = ((StringBuilder)object3).toString();
                g.f((String)object2, string9);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object2 = a;
                object3 = new StringBuilder();
                object5 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object3).append((String)object5);
                String string10 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object3).append(string10);
                string10 = ((StringBuilder)object3).toString();
                g.f((String)object2, string10);
            }
            return byArray;
        }
        g.f(a, "alias or encrypted content is null");
        return byArray;
    }

    public static String f(String object, String object2) {
        CharSequence charSequence;
        String string2 = null;
        object2 = Base64.decode((String)object2, (int)0);
        object = d.j.f.a.a.h.d.b.a.g((String)object, (byte[])object2);
        object2 = "UTF-8";
        try {
            charSequence = new String((byte[])object, (String)object2);
            return charSequence;
        }
        catch (Exception exception) {
            object2 = a;
            charSequence = new StringBuilder();
            string2 = "Exception: ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            g.f((String)object2, string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = a;
            charSequence = new StringBuilder();
            string2 = "UnsupportedEncodingException: ";
            ((StringBuilder)charSequence).append(string2);
            String string4 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            g.f((String)object2, string4);
        }
        return d;
    }

    public static byte[] g(String string2, byte[] byArray) {
        return d.j.f.a.a.h.d.b.a.e(string2, byArray);
    }

    public static String h(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            CharSequence charSequence = "UTF-8";
            object2 = ((String)object2).getBytes((String)charSequence);
            object = d.j.f.a.a.h.d.b.a.i((String)object, (byte[])object2);
            object2 = null;
            try {
                return Base64.encodeToString((byte[])object, (int)0);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = a;
                charSequence = new StringBuilder();
                String string2 = "UnsupportedEncodingException: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                g.f((String)object2, string3);
            }
        }
        return d;
    }

    public static byte[] i(String string2, byte[] byArray) {
        return d.j.f.a.a.h.d.b.a.b(string2, byArray, false);
    }

    public static String j(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            CharSequence charSequence = "UTF-8";
            object2 = ((String)object2).getBytes((String)charSequence);
            object = d.j.f.a.a.h.d.b.a.k((String)object, (byte[])object2);
            object2 = null;
            try {
                return Base64.encodeToString((byte[])object, (int)0);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = a;
                charSequence = new StringBuilder();
                String string2 = "UnsupportedEncodingException: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                g.f((String)object2, string3);
            }
        }
        return d;
    }

    public static byte[] k(String string2, byte[] byArray) {
        return d.j.f.a.a.h.d.b.a.b(string2, byArray, true);
    }

    private static Certificate l(String string2) {
        Certificate certificate = null;
        Object object = b;
        object = KeyStore.getInstance((String)object);
        ((KeyStore)object).load(null);
        try {
            certificate = ((KeyStore)object).getCertificate(string2);
        }
        catch (Exception exception) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "Exception: ";
            stringBuilder.append(string3);
            String string4 = exception.getMessage();
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
        return certificate;
    }

    private static boolean m(String object) {
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
        catch (Exception exception) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string2 = "Exception: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            g.f((String)object2, string3);
        }
        catch (IOException iOException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string4 = "IOException: ";
            stringBuilder.append(string4);
            String string5 = iOException.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            g.f((String)object2, string5);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string6 = "NoSuchAlgorithmException: ";
            stringBuilder.append(string6);
            String string7 = noSuchAlgorithmException.getMessage();
            stringBuilder.append(string7);
            string7 = stringBuilder.toString();
            g.f((String)object2, string7);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string8 = "UnrecoverableKeyException: ";
            stringBuilder.append(string8);
            String string9 = unrecoverableKeyException.getMessage();
            stringBuilder.append(string9);
            string9 = stringBuilder.toString();
            g.f((String)object2, string9);
        }
        catch (CertificateException certificateException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string10 = "CertificateException: ";
            stringBuilder.append(string10);
            String string11 = certificateException.getMessage();
            stringBuilder.append(string11);
            string11 = stringBuilder.toString();
            g.f((String)object2, string11);
        }
        catch (KeyStoreException keyStoreException) {
            object2 = a;
            stringBuilder = new StringBuilder();
            String string12 = "KeyStoreException: ";
            stringBuilder.append(string12);
            String string13 = keyStoreException.getMessage();
            stringBuilder.append(string13);
            string13 = stringBuilder.toString();
            g.f((String)object2, string13);
        }
        return false;
    }

    private static PrivateKey n(String object) {
        boolean bl2 = d.j.f.a.a.h.d.b.a.m((String)object);
        Object object2 = null;
        if (!bl2) {
            return null;
        }
        Object object3 = b;
        object3 = KeyStore.getInstance((String)object3);
        ((KeyStore)object3).load(null);
        object = ((KeyStore)object3).getKey((String)object, null);
        try {
            object2 = object = (PrivateKey)object;
        }
        catch (Exception exception) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Exception: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            g.f((String)object3, string3);
        }
        catch (IOException iOException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "IOException: ";
            stringBuilder.append(string4);
            String string5 = iOException.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            g.f((String)object3, string5);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = "NoSuchAlgorithmException: ";
            stringBuilder.append(string6);
            String string7 = noSuchAlgorithmException.getMessage();
            stringBuilder.append(string7);
            string7 = stringBuilder.toString();
            g.f((String)object3, string7);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string8 = "UnrecoverableKeyException: ";
            stringBuilder.append(string8);
            String string9 = unrecoverableKeyException.getMessage();
            stringBuilder.append(string9);
            string9 = stringBuilder.toString();
            g.f((String)object3, string9);
        }
        catch (CertificateException certificateException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string10 = "CertificateException: ";
            stringBuilder.append(string10);
            String string11 = certificateException.getMessage();
            stringBuilder.append(string11);
            string11 = stringBuilder.toString();
            g.f((String)object3, string11);
        }
        catch (KeyStoreException keyStoreException) {
            object3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string12 = "KeyStoreException: ";
            stringBuilder.append(string12);
            String string13 = keyStoreException.getMessage();
            stringBuilder.append(string13);
            string13 = stringBuilder.toString();
            g.f((String)object3, string13);
        }
        return object2;
    }

    private static boolean o() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

