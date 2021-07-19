/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.h.b;

import d.j.f.a.a.h.b.b;
import d.j.f.a.a.h.f.g;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {
    private static final String a = "CipherUtil";
    private static final String b = "AES/GCM/NoPadding";
    private static final String c = "AES/CBC/PKCS5Padding";
    private static final String d = "AES";
    private static final String e = "";
    private static final int f = 16;
    private static final int g = 12;
    private static final int h = 16;

    private static int a(Cipher cipher, byte[] byArray) {
        if (cipher != null && byArray != null) {
            int n10 = byArray.length;
            return cipher.getOutputSize(n10);
        }
        return -1;
    }

    private static Cipher b(byte[] byArray, byte[] byArray2, int n10) {
        return d.j.f.a.a.h.b.c.c(byArray, byArray2, n10, b);
    }

    private static Cipher c(byte[] object, byte[] object2, int n10, String object3) {
        int n11;
        int n12;
        String string2 = a;
        if (object != null && (n12 = ((byte[])object).length) >= (n11 = 16) && object2 != null && (n12 = ((byte[])object2).length) >= (n11 = 12) && (n12 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            SecretKeySpec secretKeySpec;
            block9: {
                String string3 = d;
                try {
                    secretKeySpec = new SecretKeySpec((byte[])object, string3);
                    object = Cipher.getInstance((String)object3);
                    string3 = b;
                }
                catch (GeneralSecurityException generalSecurityException) {
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("GCM encrypt data error");
                    String string4 = generalSecurityException.getMessage();
                    ((StringBuilder)object2).append(string4);
                    string4 = ((StringBuilder)object2).toString();
                    d.j.f.a.a.h.f.g.f(string2, string4);
                    return null;
                }
                boolean bl2 = string3.equals(object3);
                if (!bl2) break block9;
                object2 = d.j.f.a.a.h.b.b.w((byte[])object2);
            }
            object2 = object3 = new IvParameterSpec((byte[])object2);
            ((Cipher)object).init(n10, (Key)secretKeySpec, (AlgorithmParameterSpec)object2);
            return object;
        }
        d.j.f.a.a.h.f.g.f(string2, "gcm encrypt param is not right");
        return null;
    }

    private static Cipher d(byte[] byArray, byte[] byArray2, int n10) {
        return d.j.f.a.a.h.b.c.c(byArray, byArray2, n10, c);
    }

    public static Cipher e(byte[] byArray, Cipher object) {
        object = ((Cipher)object).getIV();
        return d.j.f.a.a.h.b.c.f(byArray, (byte[])object);
    }

    public static Cipher f(byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.b.c.d(byArray, byArray2, 2);
    }

    public static Cipher g(byte[] byArray) {
        byte[] byArray2 = d.j.f.a.a.h.f.b.e(16);
        return d.j.f.a.a.h.b.c.h(byArray, byArray2);
    }

    public static Cipher h(byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.b.c.d(byArray, byArray2, 1);
    }

    public static int i(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.f.b.e(16);
        return d.j.f.a.a.h.b.c.j(byArray, byArray2, byArray3);
    }

    public static int j(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        return d.j.f.a.a.h.b.c.a(d.j.f.a.a.h.b.c.h(byArray2, byArray3), byArray);
    }

    public static Cipher k(byte[] byArray, Cipher object) {
        object = ((Cipher)object).getIV();
        return d.j.f.a.a.h.b.c.l(byArray, (byte[])object);
    }

    public static Cipher l(byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.b.c.b(byArray, byArray2, 2);
    }

    public static Cipher m(byte[] byArray) {
        byte[] byArray2 = d.j.f.a.a.h.f.b.e(12);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getEncryptCipher: iv is : ");
        String string2 = d.j.f.a.a.h.f.c.b(byArray2);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        d.j.f.a.a.h.f.g.c(a, (String)charSequence);
        return d.j.f.a.a.h.b.c.n(byArray, byArray2);
    }

    public static Cipher n(byte[] byArray, byte[] byArray2) {
        return d.j.f.a.a.h.b.c.b(byArray, byArray2, 1);
    }

    public static int o(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.f.b.e(12);
        return d.j.f.a.a.h.b.c.p(byArray, byArray2, byArray3);
    }

    public static int p(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        return d.j.f.a.a.h.b.c.a(d.j.f.a.a.h.b.c.n(byArray2, byArray3), byArray);
    }

    public static int q(Cipher object, byte[] byArray, byte[] byArray2) {
        int n10 = -1;
        String string2 = a;
        if (object != null && byArray != null) {
            int n11 = byArray.length;
            try {
                return ((Cipher)object).doFinal(byArray, 0, n11, byArray2);
            }
            catch (ShortBufferException shortBufferException) {
                object = "getContent: ShortBufferException";
                d.j.f.a.a.h.f.g.f(string2, (String)object);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object = "getContent: IllegalBlockSizeException";
                d.j.f.a.a.h.f.g.f(string2, (String)object);
            }
            catch (BadPaddingException badPaddingException) {
                object = "getContent: BadPaddingException";
                d.j.f.a.a.h.f.g.f(string2, (String)object);
            }
            return n10;
        }
        d.j.f.a.a.h.f.g.f(string2, "getEncryptCOntent: cipher is null or content is null");
        return n10;
    }

    public static byte[] r(Cipher object, byte[] byArray) {
        String string2 = a;
        if (object != null && byArray != null) {
            int n10 = byArray.length;
            try {
                return ((Cipher)object).doFinal(byArray, 0, n10);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object = "getContent: IllegalBlockSizeException";
                d.j.f.a.a.h.f.g.f(string2, (String)object);
            }
            catch (BadPaddingException badPaddingException) {
                object = "getContent: BadPaddingException";
                d.j.f.a.a.h.f.g.f(string2, (String)object);
            }
            return new byte[0];
        }
        d.j.f.a.a.h.f.g.f(string2, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }
}

