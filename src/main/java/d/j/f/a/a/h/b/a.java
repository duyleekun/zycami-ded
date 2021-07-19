/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.b;

import android.text.TextUtils;
import d.j.f.a.a.h.f.b;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static final String a = "security:";
    private static final String b = "AES/CBC/PKCS5Padding";
    private static final String c = "AES";
    private static final String d = "a";
    private static final String e = "";
    private static final int f = 16;
    private static final int g = 16;

    private a() {
    }

    private static String a(String string2) {
        CharSequence charSequence;
        int n10;
        int n11;
        CharSequence charSequence2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (bl2) {
            return string3;
        }
        try {
            charSequence2 = new StringBuilder();
            n11 = 6;
            n10 = 12;
        }
        catch (Exception exception) {
            charSequence2 = d;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getIv exception : ");
            String string4 = exception.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            d.j.f.a.a.h.f.g.f((String)charSequence2, string4);
            return string3;
        }
        charSequence = string2.substring(n11, n10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        n11 = 16;
        n10 = 26;
        charSequence = string2.substring(n11, n10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        n11 = 32;
        n10 = 48;
        string2 = string2.substring(n11, n10);
        ((StringBuilder)charSequence2).append(string2);
        return ((StringBuilder)charSequence2).toString();
    }

    private static String b(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string4 = e;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            StringBuilder stringBuilder = new StringBuilder();
            int n10 = 0;
            String string5 = null;
            int n11 = 6;
            String string6 = string3.substring(0, n11);
            stringBuilder.append(string6);
            string5 = string2.substring(0, n11);
            stringBuilder.append(string5);
            n10 = 10;
            string6 = string3.substring(n11, n10);
            stringBuilder.append(string6);
            int n12 = 16;
            String string7 = string2.substring(n11, n12);
            stringBuilder.append(string7);
            string5 = string3.substring(n10, n12);
            stringBuilder.append(string5);
            string2 = string2.substring(n12);
            stringBuilder.append(string2);
            string2 = string3.substring(n12);
            try {
                stringBuilder.append(string2);
                return stringBuilder.toString();
            }
            catch (Exception exception) {
                string3 = d;
                stringBuilder = new StringBuilder();
                string5 = "mix exception: ";
                stringBuilder.append(string5);
                String string8 = exception.getMessage();
                stringBuilder.append(string8);
                string8 = stringBuilder.toString();
                d.j.f.a.a.h.f.g.f(string3, string8);
            }
        }
        return string4;
    }

    private static byte[] c(String object, byte[] object2, byte[] object3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
            return new byte[0];
        }
        String string2 = "UTF-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = d;
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            ((StringBuilder)object3).append(" cbc encrypt data error");
            String string3 = unsupportedEncodingException.getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            d.j.f.a.a.h.f.g.f((String)object2, string3);
            return new byte[0];
        }
        return d.j.f.a.a.h.b.a.y((byte[])object, object2, (byte[])object3);
    }

    private static byte[] d(byte[] byArray) {
        int n10 = 16;
        byte[] byArray2 = new byte[n10];
        System.arraycopy(byArray, 0, byArray2, 0, n10);
        return byArray2;
    }

    private static byte[] e(byte[] byArray, byte[] byArray2) {
        int n10 = byArray.length;
        int n11 = byArray2.length;
        byte[] byArray3 = new byte[n10 + n11];
        n11 = byArray.length;
        System.arraycopy(byArray, 0, byArray3, 0, n11);
        int n12 = byArray.length;
        n11 = byArray2.length;
        System.arraycopy(byArray2, 0, byArray3, n12, n11);
        return byArray3;
    }

    private static String f(String string2) {
        int n10;
        CharSequence charSequence;
        int n11;
        CharSequence charSequence2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (bl2) {
            return string3;
        }
        try {
            charSequence2 = new StringBuilder();
            n11 = 0;
            charSequence = null;
            n10 = 6;
        }
        catch (Exception exception) {
            charSequence2 = d;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("get encryptword exception : ");
            String string4 = exception.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            d.j.f.a.a.h.f.g.f((String)charSequence2, string4);
            return string3;
        }
        charSequence = string2.substring(0, n10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        n11 = 12;
        n10 = 16;
        charSequence = string2.substring(n11, n10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        n11 = 26;
        n10 = 32;
        charSequence = string2.substring(n11, n10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        n11 = 48;
        string2 = string2.substring(n11);
        ((StringBuilder)charSequence2).append(string2);
        return ((StringBuilder)charSequence2).toString();
    }

    private static byte[] g(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 16;
        byte[] byArray2 = new byte[n10 - n11];
        int n12 = byArray.length - n11;
        System.arraycopy(byArray, n11, byArray2, 0, n12);
        return byArray2;
    }

    public static String h(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n11 != 0) {
            return string3;
        }
        String string4 = a;
        n11 = string2.indexOf(string4);
        if (n11 != (n10 = -1)) {
            n11 = 9;
            string3 = string2.substring(n11);
        }
        return string3;
    }

    public static byte[] i(byte[] byArray) {
        Object object;
        String string2;
        String string3 = "UTF-8";
        try {
            string2 = new String(byArray, string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string3 = d;
            StringBuilder stringBuilder = new StringBuilder();
            object = "stripCryptHead: exception : ";
            stringBuilder.append((String)object);
            string2 = unsupportedEncodingException.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            d.j.f.a.a.h.f.g.f(string3, string2);
            string2 = e;
        }
        int n10 = string2.startsWith(a);
        string3 = null;
        if (n10 == 0) {
            return new byte[0];
        }
        n10 = byArray.length;
        int n11 = 9;
        if (n10 > n11) {
            n10 = byArray.length - n11;
            object = new byte[n10];
            System.arraycopy(byArray, n11, object, 0, n10);
            return object;
        }
        return new byte[0];
    }

    private static int j(byte[] byArray) {
        int n10 = 16;
        byte by2 = byArray[n10];
        byte by3 = 58;
        if (by2 == by3) {
            return n10;
        }
        return -1;
    }

    public static String k(String string2, String object) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            int n11;
            n10 = ((Object)(object = (Object)d.j.f.a.a.h.f.c.c((String)object))).length;
            if (n10 < (n11 = 16)) {
                d.j.f.a.a.h.f.g.f(d, "key length is not right");
                return string3;
            }
            return d.j.f.a.a.h.b.a.m(string2, (byte[])object);
        }
        d.j.f.a.a.h.f.g.f(d, "content or key is null");
        return string3;
    }

    public static String l(String string2, String object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            object = d.j.f.a.a.h.f.c.c((String)object);
            object2 = d.j.f.a.a.h.f.c.c((String)object2);
            n10 = ((Object)object).length;
            int n11 = 16;
            if (n10 >= n11 && (n10 = ((Object)object2).length) >= n11) {
                return d.j.f.a.a.h.b.a.n(string2, (byte[])object, (byte[])object2);
            }
            d.j.f.a.a.h.f.g.f(d, "key length or ivParameter is not right");
            return string3;
        }
        d.j.f.a.a.h.f.g.f(d, "cbc decrypt param is not right");
        return string3;
    }

    public static String m(String string2, byte[] object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n11 == 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16)) {
            Object object2 = d.j.f.a.a.h.b.a.a(string2);
            string2 = d.j.f.a.a.h.b.a.f(string2);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) {
                object2 = d.j.f.a.a.h.f.c.c((String)object2);
                return d.j.f.a.a.h.b.a.n(string2, object, (byte[])object2);
            }
            string2 = d;
            object = "ivParameter or encrypedWord is null";
            d.j.f.a.a.h.f.g.f(string2, (String)object);
        }
        return string3;
    }

    public static String n(String object, byte[] object2, byte[] object3) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        String string2 = e;
        if (n11 == 0 && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 16) && object3 != null && (n11 = ((byte[])object3).length) >= n10) {
            try {
                object = d.j.f.a.a.h.f.c.c((String)object);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = d;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                ((StringBuilder)object3).append(" cbc decrypt data error");
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                d.j.f.a.a.h.f.g.f((String)object2, string3);
                return string2;
            }
            object = d.j.f.a.a.h.b.a.p((byte[])object, object2, (byte[])object3);
            object2 = new String;
            object3 = "UTF-8";
            object2((byte[])object, (String)object3);
            return object2;
        }
        d.j.f.a.a.h.f.g.f(d, "cbc decrypt param is not right");
        return string2;
    }

    public static byte[] o(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.b.a.d(byArray);
        return d.j.f.a.a.h.b.a.p(d.j.f.a.a.h.b.a.g(byArray), byArray2, byArray3);
    }

    public static byte[] p(byte[] byArray, byte[] object, byte[] object2) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) != 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16) && object2 != null && (n11 = ((byte[])object2).length) >= n10) {
            Object object3 = c;
            Object object4 = new SecretKeySpec((byte[])object, (String)object3);
            object = b;
            object = Cipher.getInstance((String)object);
            object3 = new IvParameterSpec((byte[])object2);
            int n12 = 2;
            ((Cipher)object).init(n12, (Key)object4, (AlgorithmParameterSpec)object3);
            try {
                return ((Cipher)object).doFinal(byArray);
            }
            catch (BadPaddingException badPaddingException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "BadPaddingException: ";
                ((StringBuilder)object2).append((String)object4);
                String string2 = badPaddingException.getMessage();
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string2);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "IllegalBlockSizeException: ";
                ((StringBuilder)object2).append((String)object4);
                String string3 = illegalBlockSizeException.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string3);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object2).append((String)object4);
                String string4 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string4);
            }
            catch (InvalidKeyException invalidKeyException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "InvalidKeyException: ";
                ((StringBuilder)object2).append((String)object4);
                String string5 = invalidKeyException.getMessage();
                ((StringBuilder)object2).append(string5);
                string5 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string5);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "NoSuchPaddingException: ";
                ((StringBuilder)object2).append((String)object4);
                String string6 = noSuchPaddingException.getMessage();
                ((StringBuilder)object2).append(string6);
                string6 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string6);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object2).append((String)object4);
                String string7 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object2).append(string7);
                string7 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string7);
            }
            return new byte[0];
        }
        d.j.f.a.a.h.f.g.f(d, "cbc decrypt param is not right");
        return new byte[0];
    }

    public static String q(String string2, byte[] object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        Object object2 = e;
        if (n11 == 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16)) {
            n11 = (int)(((String)object2).equals(string2 = d.j.f.a.a.h.b.a.h(string2)) ? 1 : 0);
            if (n11 != 0) {
                return object2;
            }
            n11 = string2.indexOf(58);
            if (n11 >= 0) {
                object2 = d.j.f.a.a.h.f.c.c(string2.substring(0, n11));
                return d.j.f.a.a.h.b.a.n(d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.f.c.c(string2.substring(++n11))), object, (byte[])object2);
            }
            string2 = d;
            object = " cbc cipherText data missing colon";
            d.j.f.a.a.h.f.g.f(string2, (String)object);
        }
        return object2;
    }

    public static String r(byte[] byArray, byte[] object) {
        try {
            byArray = d.j.f.a.a.h.b.a.s(byArray, object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            d.j.f.a.a.h.f.g.f(d, "decryptWithCryptHead UnsupportedEncodingException ");
            return e;
        }
        object = "UTF-8";
        String string2 = new String(byArray, (String)object);
        return string2;
    }

    public static byte[] s(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        if (byArray != null && byArray2 != null && (n11 = byArray2.length) >= (n10 = 16)) {
            n11 = (byArray = d.j.f.a.a.h.b.a.i(byArray)).length;
            if (n11 == 0) {
                return new byte[0];
            }
            n11 = d.j.f.a.a.h.b.a.j(byArray);
            if (n11 >= 0) {
                byte[] byArray3 = Arrays.copyOf(byArray, n11);
                int n12 = byArray.length;
                int n13 = byArray3.length;
                n12 = n12 - n13 + -1;
                byte[] byArray4 = new byte[n12];
                System.arraycopy(byArray, ++n11, byArray4, 0, n12);
                return d.j.f.a.a.h.b.a.p(byArray4, byArray2, byArray3);
            }
            d.j.f.a.a.h.f.g.f(d, " cbc cipherText data missing colon");
            return new byte[0];
        }
        return new byte[0];
    }

    public static String t(String string2, String object) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            int n11;
            n10 = ((Object)(object = (Object)d.j.f.a.a.h.f.c.c((String)object))).length;
            if (n10 < (n11 = 16)) {
                d.j.f.a.a.h.f.g.f(d, "key length is not right");
                return string3;
            }
            return d.j.f.a.a.h.b.a.v(string2, (byte[])object);
        }
        d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
        return string3;
    }

    public static String u(String string2, String object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            object = d.j.f.a.a.h.f.c.c((String)object);
            object2 = d.j.f.a.a.h.f.c.c((String)object2);
            n10 = ((Object)object).length;
            int n11 = 16;
            if (n10 >= n11 && (n10 = ((Object)object2).length) >= n11) {
                return d.j.f.a.a.h.b.a.w(string2, (byte[])object, (byte[])object2);
            }
            d.j.f.a.a.h.f.g.f(d, "key length or ivParameter length is not right");
            return string3;
        }
        d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
        return string3;
    }

    public static String v(String object, byte[] object2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        String string2 = e;
        if (n11 == 0 && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 16)) {
            int n12;
            byte[] byArray = d.j.f.a.a.h.f.b.e(n10);
            if ((object = (Object)d.j.f.a.a.h.b.a.c((String)object, object2, byArray)) != null && (n12 = ((Object)object).length) != 0) {
                object2 = d.j.f.a.a.h.f.c.b(byArray);
                object = d.j.f.a.a.h.f.c.b((byte[])object);
                return d.j.f.a.a.h.b.a.b((String)object2, (String)object);
            }
            return string2;
        }
        d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
        return string2;
    }

    public static String w(String string2, byte[] byArray, byte[] byArray2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && byArray != null && (n11 = byArray.length) >= (n10 = 16) && byArray2 != null && (n11 = byArray2.length) >= n10) {
            return d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.b.a.c(string2, byArray, byArray2));
        }
        d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
        return e;
    }

    public static byte[] x(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.f.b.e(16);
        byArray = d.j.f.a.a.h.b.a.y(byArray, byArray2, byArray3);
        return d.j.f.a.a.h.b.a.e(byArray3, byArray);
    }

    public static byte[] y(byte[] byArray, byte[] object, byte[] object2) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) != 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16) && object2 != null && (n11 = ((byte[])object2).length) >= n10) {
            Object object3 = c;
            Object object4 = new SecretKeySpec((byte[])object, (String)object3);
            object = b;
            object = Cipher.getInstance((String)object);
            object3 = new IvParameterSpec((byte[])object2);
            int n12 = 1;
            ((Cipher)object).init(n12, (Key)object4, (AlgorithmParameterSpec)object3);
            try {
                return ((Cipher)object).doFinal(byArray);
            }
            catch (BadPaddingException badPaddingException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "BadPaddingException: ";
                ((StringBuilder)object2).append((String)object4);
                String string2 = badPaddingException.getMessage();
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string2);
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "IllegalBlockSizeException: ";
                ((StringBuilder)object2).append((String)object4);
                String string3 = illegalBlockSizeException.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string3);
            }
            catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "InvalidAlgorithmParameterException: ";
                ((StringBuilder)object2).append((String)object4);
                String string4 = invalidAlgorithmParameterException.getMessage();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string4);
            }
            catch (InvalidKeyException invalidKeyException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "InvalidKeyException: ";
                ((StringBuilder)object2).append((String)object4);
                String string5 = invalidKeyException.getMessage();
                ((StringBuilder)object2).append(string5);
                string5 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string5);
            }
            catch (NoSuchPaddingException noSuchPaddingException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "NoSuchPaddingException: ";
                ((StringBuilder)object2).append((String)object4);
                String string6 = noSuchPaddingException.getMessage();
                ((StringBuilder)object2).append(string6);
                string6 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string6);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                object4 = "NoSuchAlgorithmException: ";
                ((StringBuilder)object2).append((String)object4);
                String string7 = noSuchAlgorithmException.getMessage();
                ((StringBuilder)object2).append(string7);
                string7 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string7);
            }
            return new byte[0];
        }
        d.j.f.a.a.h.f.g.f(d, "cbc encrypt param is not right");
        return new byte[0];
    }
}

