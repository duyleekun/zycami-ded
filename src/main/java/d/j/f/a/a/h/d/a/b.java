/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.keystore.KeyGenParameterSpec$Builder
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.d.a;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class b {
    private static final String a = "b";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/GCM/NoPadding";
    private static final String d = "";
    private static final int e = 12;
    private static final int f = 256;

    public static String a(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
            CharSequence charSequence;
            try {
                object2 = d.j.f.a.a.h.f.c.c((String)object2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = a;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("decrypt: UnsupportedEncodingException : ");
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                g.f((String)object2, string3);
                return string2;
            }
            object = d.j.f.a.a.h.d.a.b.b((String)object, (byte[])object2);
            object2 = "UTF-8";
            charSequence = new String((byte[])object, (String)object2);
            return charSequence;
        }
        g.f(a, "alias or encrypt content is null");
        return string2;
    }

    public static byte[] b(String object, byte[] object2) {
        byte[] byArray = new byte[]{};
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && object2 != null) {
            n10 = d.j.f.a.a.h.d.a.b.f();
            if (n10 == 0) {
                g.f(a, "sdk version is too low");
                return byArray;
            }
            n10 = ((byte[])object2).length;
            int n11 = 12;
            if (n10 <= n11) {
                g.f(a, "Decrypt source data is invalid.");
                return byArray;
            }
            if ((object = d.j.f.a.a.h.d.a.b.c((String)object)) == null) {
                g.f(a, "Decrypt secret key is null");
                return byArray;
            }
            Object object3 = Arrays.copyOf(object2, n11);
            Object object4 = c;
            object4 = Cipher.getInstance((String)object4);
            int n12 = 128;
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(n12, (byte[])object3);
            n10 = 2;
            ((Cipher)object4).init(n10, (Key)object, gCMParameterSpec);
            int n13 = ((byte[])object2).length - n11;
            try {
                byArray = ((Cipher)object4).doFinal((byte[])object2, n11, n13);
            }
            catch (Exception exception) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string2 = "Exception: ";
                ((StringBuilder)object3).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                g.f((String)object2, string3);
            }
            catch (BadPaddingException badPaddingException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string4 = "BadPaddingException : ";
                ((StringBuilder)object3).append(string4);
                String string5 = badPaddingException.getMessage();
                ((StringBuilder)object3).append(string5);
                string5 = ((StringBuilder)object3).toString();
                g.f((String)object2, string5);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string6 = "IllegalBlockSizeException : ";
                ((StringBuilder)object3).append(string6);
                String string7 = illegalBlockSizeException.getMessage();
                ((StringBuilder)object3).append(string7);
                string7 = ((StringBuilder)object3).toString();
                g.f((String)object2, string7);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string8 = "InvalidAlgorithmParameterException : ";
                ((StringBuilder)object3).append(string8);
                String string9 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object3).append(string9);
                string9 = ((StringBuilder)object3).toString();
                g.f((String)object2, string9);
            }
            catch (InvalidKeyException invalidKeyException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string10 = "InvalidKeyException : ";
                ((StringBuilder)object3).append(string10);
                String string11 = invalidKeyException.getMessage();
                ((StringBuilder)object3).append(string11);
                string11 = ((StringBuilder)object3).toString();
                g.f((String)object2, string11);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string12 = "NoSuchPaddingException : ";
                ((StringBuilder)object3).append(string12);
                String string13 = noSuchPaddingException.getMessage();
                ((StringBuilder)object3).append(string13);
                string13 = ((StringBuilder)object3).toString();
                g.f((String)object2, string13);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object2 = a;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string14 = "NoSuchAlgorithmException : ";
                ((StringBuilder)object3).append(string14);
                String string15 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object3).append(string15);
                string15 = ((StringBuilder)object3).toString();
                g.f((String)object2, string15);
            }
            return byArray;
        }
        g.f(a, "alias or encrypt content is null");
        return byArray;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SecretKey c(String var0) {
        var1_18 = b.class;
        synchronized (var1_18) {
            block14: {
                var2_19 = null;
                var3_20 = "AndroidKeyStore";
                try {
                    var3_20 = KeyStore.getInstance((String)var3_20);
                    var3_20.load(null);
                    var3_20 = var3_20.getKey((String)var0 /* !! */ , null);
                    if (var3_20 != null) {
                    }
                    ** GOTO lbl111
                }
                catch (Exception var0_2) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_23 = new StringBuilder();
                    var7_32 = "Exception: ";
                    var5_23.append(var7_32);
                    var0_3 = var0_2.getMessage();
                    var5_23.append(var0_3);
                    var0_3 = var5_23.toString();
                    g.f((String)var3_20, var0_3);
                }
                catch (NoSuchProviderException var0_4) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_24 = new StringBuilder();
                    var7_33 = "NoSuchProviderException : ";
                    var5_24.append(var7_33);
                    var0_5 = var0_4.getMessage();
                    var5_24.append(var0_5);
                    var0_5 = var5_24.toString();
                    g.f((String)var3_20, var0_5);
                }
                catch (InvalidAlgorithmParameterException var0_6) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_25 = new StringBuilder();
                    var7_34 = "InvalidAlgorithmParameterException : ";
                    var5_25.append(var7_34);
                    var0_7 = var0_6.getMessage();
                    var5_25.append(var0_7);
                    var0_7 = var5_25.toString();
                    g.f((String)var3_20, var0_7);
                }
                catch (UnrecoverableKeyException var0_8) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_26 = new StringBuilder();
                    var7_35 = "UnrecoverableKeyException : ";
                    var5_26.append(var7_35);
                    var0_9 = var0_8.getMessage();
                    var5_26.append(var0_9);
                    var0_9 = var5_26.toString();
                    g.f((String)var3_20, var0_9);
                }
                catch (NoSuchAlgorithmException var0_10) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_27 = new StringBuilder();
                    var7_36 = "NoSuchAlgorithmException : ";
                    var5_27.append(var7_36);
                    var0_11 = var0_10.getMessage();
                    var5_27.append(var0_11);
                    var0_11 = var5_27.toString();
                    g.f((String)var3_20, var0_11);
                }
                catch (CertificateException var0_12) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_28 = new StringBuilder();
                    var7_37 = "CertificateException : ";
                    var5_28.append(var7_37);
                    var0_13 = var0_12.getMessage();
                    var5_28.append(var0_13);
                    var0_13 = var5_28.toString();
                    g.f((String)var3_20, var0_13);
                }
                catch (IOException var0_14) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_29 = new StringBuilder();
                    var7_38 = "IOException : ";
                    var5_29.append(var7_38);
                    var0_15 = var0_14.getMessage();
                    var5_29.append(var0_15);
                    var0_15 = var5_29.toString();
                    g.f((String)var3_20, var0_15);
                }
                catch (KeyStoreException var0_16) {
                    var3_20 = d.j.f.a.a.h.d.a.b.a;
                    var5_30 = new StringBuilder();
                    var7_39 = "KeyStoreException : ";
                    var5_30.append(var7_39);
                    var0_17 = var0_16.getMessage();
                    var5_30.append(var0_17);
                    var0_17 = var5_30.toString();
                    g.f((String)var3_20, var0_17);
                }
                var4_21 = var3_20 instanceof SecretKey;
                if (var4_21 == 0) ** GOTO lbl111
                {
                    return var3_20 = (SecretKey)var3_20;
lbl111:
                    // 2 sources

                    var3_20 = "AES";
                    var5_22 = "AndroidKeyStore";
                    var3_20 = KeyGenerator.getInstance((String)var3_20, (String)var5_22);
                    var6_31 = 3;
                    var5_22 = new KeyGenParameterSpec.Builder((String)var0 /* !! */ , var6_31);
                    var0 /* !! */  = "GCM";
                    var0 /* !! */  = new String[]{var0 /* !! */ };
                    var0 /* !! */  = var5_22.setBlockModes(var0 /* !! */ );
                    var5_22 = "NoPadding";
                    var5_22 = new String[]{var5_22};
                    var0 /* !! */  = var0 /* !! */ .setEncryptionPaddings(var5_22);
                    var4_21 = 256;
                    var0 /* !! */  = var0 /* !! */ .setKeySize(var4_21);
                    var0 /* !! */  = var0 /* !! */ .build();
                    var3_20.init((AlgorithmParameterSpec)var0 /* !! */ );
                    var0 /* !! */  = var3_20.generateKey();
                    return var0 /* !! */ ;
                }
                catch (Throwable var0_1) {
                    break block14;
                }
                return var2_19;
            }
            throw var0_1;
        }
    }

    public static String d(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
            CharSequence charSequence = "UTF-8";
            try {
                object2 = ((String)object2).getBytes((String)charSequence);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = a;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("encrypt: UnsupportedEncodingException : ");
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                g.f((String)object2, string3);
                return string2;
            }
            object = d.j.f.a.a.h.d.a.b.e((String)object, (byte[])object2);
            return d.j.f.a.a.h.f.c.b((byte[])object);
        }
        g.f(a, "alias or encrypt content is null");
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] e(String object, byte[] object2) {
        StringBuilder stringBuilder = null;
        byte[] byArray = new byte[]{};
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && object2 != null) {
            n10 = d.j.f.a.a.h.d.a.b.f();
            if (n10 == 0) {
                g.f(a, "sdk version is too low");
                return byArray;
            }
            Object object3 = c;
            try {
                object3 = Cipher.getInstance((String)object3);
                object = d.j.f.a.a.h.d.a.b.c((String)object);
                if (object == null) {
                    object = a;
                    String string2 = "Encrypt secret key is null";
                    g.f((String)object, string2);
                    return byArray;
                }
                int n11 = 1;
                ((Cipher)object3).init(n11, (Key)object);
                object = ((Cipher)object3).doFinal((byte[])object2);
                byte[] byArray2 = ((Cipher)object3).getIV();
                if (byArray2 != null && (n10 = byArray2.length) == (n11 = 12)) {
                    n10 = byArray2.length;
                    n11 = ((Object)object).length;
                    byArray = Arrays.copyOf(byArray2, n10 += n11);
                    int n12 = byArray2.length;
                    n10 = ((Object)object).length;
                    System.arraycopy(object, 0, byArray, n12, n10);
                    return byArray;
                }
                object = a;
                String string3 = "IV is invalid.";
                g.f((String)object, string3);
                return byArray;
            }
            catch (Exception exception) {
                String string4 = a;
                stringBuilder = new StringBuilder();
                object3 = "Exception: ";
                stringBuilder.append((String)object3);
                String string5 = exception.getMessage();
                stringBuilder.append(string5);
                string5 = stringBuilder.toString();
                g.f(string4, string5);
                return byArray;
            }
            catch (InvalidKeyException invalidKeyException) {
                String string6 = a;
                stringBuilder = new StringBuilder();
                object3 = "InvalidKeyException : ";
                stringBuilder.append((String)object3);
                String string7 = invalidKeyException.getMessage();
                stringBuilder.append(string7);
                string7 = stringBuilder.toString();
                g.f(string6, string7);
                return byArray;
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                String string8 = a;
                stringBuilder = new StringBuilder();
                object3 = "IllegalBlockSizeException : ";
                stringBuilder.append((String)object3);
                String string9 = illegalBlockSizeException.getMessage();
                stringBuilder.append(string9);
                string9 = stringBuilder.toString();
                g.f(string8, string9);
                return byArray;
            }
            catch (BadPaddingException badPaddingException) {
                String string10 = a;
                stringBuilder = new StringBuilder();
                object3 = "BadPaddingException : ";
                stringBuilder.append((String)object3);
                String string11 = badPaddingException.getMessage();
                stringBuilder.append(string11);
                string11 = stringBuilder.toString();
                g.f(string10, string11);
                return byArray;
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                String string12 = a;
                stringBuilder = new StringBuilder();
                object3 = "NoSuchPaddingException : ";
                stringBuilder.append((String)object3);
                String string13 = noSuchPaddingException.getMessage();
                stringBuilder.append(string13);
                string13 = stringBuilder.toString();
                g.f(string12, string13);
                return byArray;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                String string14 = a;
                stringBuilder = new StringBuilder();
                object3 = "NoSuchAlgorithmException : ";
                stringBuilder.append((String)object3);
                String string15 = noSuchAlgorithmException.getMessage();
                stringBuilder.append(string15);
                string15 = stringBuilder.toString();
                g.f(string14, string15);
            }
            return byArray;
        }
        g.f(a, "alias or encrypt content is null");
        return byArray;
    }

    private static boolean f() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

