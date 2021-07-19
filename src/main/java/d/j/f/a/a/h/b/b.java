/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.b;

import android.os.Build;
import android.text.TextUtils;
import d.j.f.a.a.h.b.a;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    private static final String a = "security:";
    private static final String b = "AES/GCM/NoPadding";
    private static final String c = "AES";
    private static final String d = "b";
    private static final String e = "";
    private static final int f = 16;
    private static final int g = 12;
    private static final int h = 2;

    private b() {
    }

    private static String a(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && (n11 = string2.length()) >= (n10 = 24)) {
            return string2.substring(0, n10);
        }
        d.j.f.a.a.h.f.g.f(d, "IV is invalid.");
        return e;
    }

    private static byte[] b(String object, byte[] object2, byte[] object3) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0 && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 16) && object3 != null && (n11 = ((byte[])object3).length) >= (n10 = 12) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            String string2 = "UTF-8";
            try {
                object = ((String)object).getBytes(string2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = d;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                ((StringBuilder)object3).append("GCM encrypt data error");
                String string3 = unsupportedEncodingException.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                d.j.f.a.a.h.f.g.f((String)object2, string3);
                return new byte[0];
            }
            return d.j.f.a.a.h.b.b.v((byte[])object, object2, (byte[])object3);
        }
        d.j.f.a.a.h.f.g.f(d, "gcm encrypt param is not right");
        return new byte[0];
    }

    private static byte[] c(byte[] byArray) {
        int n10 = 12;
        byte[] byArray2 = new byte[n10];
        System.arraycopy(byArray, 0, byArray2, 0, n10);
        return byArray2;
    }

    private static byte[] d(byte[] byArray, byte[] byArray2) {
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

    private static String e(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && (n11 = string2.length()) >= (n10 = 24)) {
            return string2.substring(n10);
        }
        return e;
    }

    private static byte[] f(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 12;
        byte[] byArray2 = new byte[n10 - n11];
        int n12 = byArray.length - n11;
        System.arraycopy(byArray, n11, byArray2, 0, n12);
        return byArray2;
    }

    private static int g(byte[] byArray) {
        int n10 = 12;
        byte by2 = byArray[n10];
        byte by3 = 58;
        if (by2 == by3) {
            return n10;
        }
        return -1;
    }

    public static String h(String string2, String object) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0 && (n10 = d.j.f.a.a.h.b.b.x()) != 0) {
            int n11;
            n10 = ((Object)(object = (Object)d.j.f.a.a.h.f.c.c((String)object))).length;
            if (n10 < (n11 = 16)) {
                d.j.f.a.a.h.f.g.f(d, "key length is not right");
                return string3;
            }
            return d.j.f.a.a.h.b.b.j(string2, (byte[])object);
        }
        return string3;
    }

    public static String i(String string2, String object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (n10 = d.j.f.a.a.h.b.b.x()) != 0) {
            object = d.j.f.a.a.h.f.c.c((String)object);
            object2 = d.j.f.a.a.h.f.c.c((String)object2);
            n10 = ((Object)object).length;
            int n11 = 16;
            if (n10 >= n11 && (n10 = ((Object)object2).length) >= (n11 = 12)) {
                return d.j.f.a.a.h.b.b.k(string2, (byte[])object, (byte[])object2);
            }
            d.j.f.a.a.h.f.g.f(d, "key length or iv length is not right");
            return string3;
        }
        d.j.f.a.a.h.f.g.f(d, "gcm decrypt param is not right");
        return string3;
    }

    public static String j(String object, byte[] object2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        String string2 = e;
        if (n11 == 0 && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 16) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            String string3;
            Object object3;
            Object object4;
            block18: {
                object4 = c;
                object3 = new SecretKeySpec((byte[])object2, (String)object4);
                object2 = b;
                object2 = Cipher.getInstance((String)object2);
                object4 = d.j.f.a.a.h.b.b.a((String)object);
                object = d.j.f.a.a.h.b.b.e((String)object);
                int n12 = TextUtils.isEmpty((CharSequence)object4);
                if (n12 != 0) break block18;
                n12 = TextUtils.isEmpty((CharSequence)object);
                if (n12 != 0) break block18;
                object4 = d.j.f.a.a.h.f.c.c((String)object4);
                object4 = d.j.f.a.a.h.b.b.w((byte[])object4);
                n12 = 2;
                ((Cipher)object2).init(n12, (Key)object3, (AlgorithmParameterSpec)object4);
                object = d.j.f.a.a.h.f.c.c((String)object);
                object = ((Cipher)object2).doFinal((byte[])object);
                object3 = "UTF-8";
                object2 = new String((byte[])object, (String)object3);
                return object2;
            }
            object = d;
            object2 = "ivParameter or encrypedWord is null";
            try {
                d.j.f.a.a.h.f.g.f((String)object, (String)object2);
                return string2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
            }
            catch (GeneralSecurityException generalSecurityException) {
                // empty catch block
            }
            object2 = d;
            object3 = new StringBuilder();
            object4 = "GCM decrypt data exception: ";
            ((StringBuilder)object3).append((String)object4);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            d.j.f.a.a.h.f.g.f((String)object2, string3);
        }
        return string2;
    }

    public static String k(String object, byte[] object2, byte[] object3) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        String string2 = e;
        if (n11 == 0 && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 16) && object3 != null && (n11 = ((byte[])object3).length) >= (n10 = 12) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            object = d.j.f.a.a.h.f.c.c((String)object);
            object = d.j.f.a.a.h.b.b.m((byte[])object, object2, (byte[])object3);
            object2 = new String;
            object3 = "UTF-8";
            try {
                object2((byte[])object, (String)object3);
                return object2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object2 = d;
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                String string3 = "GCM decrypt data exception: ";
                ((StringBuilder)object3).append(string3);
                String string4 = unsupportedEncodingException.getMessage();
                ((StringBuilder)object3).append(string4);
                string4 = ((StringBuilder)object3).toString();
                d.j.f.a.a.h.f.g.f((String)object2, string4);
            }
        }
        return string2;
    }

    public static byte[] l(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.b.b.c(byArray);
        return d.j.f.a.a.h.b.b.m(d.j.f.a.a.h.b.b.f(byArray), byArray2, byArray3);
    }

    public static byte[] m(byte[] byArray, byte[] object, byte[] object2) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) != 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            SecretKeySpec secretKeySpec;
            String string2 = c;
            try {
                secretKeySpec = new SecretKeySpec((byte[])object, string2);
            }
            catch (GeneralSecurityException generalSecurityException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("GCM decrypt data exception: ");
                String string3 = generalSecurityException.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string3);
                return new byte[0];
            }
            object = b;
            object = Cipher.getInstance((String)object);
            object2 = d.j.f.a.a.h.b.b.w((byte[])object2);
            n10 = 2;
            ((Cipher)object).init(n10, (Key)secretKeySpec, (AlgorithmParameterSpec)object2);
            return ((Cipher)object).doFinal(byArray);
        }
        return new byte[0];
    }

    public static String n(String string2, byte[] object) {
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
                return d.j.f.a.a.h.b.b.k(d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.f.c.c(string2.substring(++n11))), object, (byte[])object2);
            }
            string2 = d;
            object = " gcm cipherText data missing colon";
            d.j.f.a.a.h.f.g.f(string2, (String)object);
        }
        return object2;
    }

    public static String o(byte[] byArray, byte[] object) {
        try {
            byArray = d.j.f.a.a.h.b.b.p(byArray, object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            d.j.f.a.a.h.f.g.f(d, "UnsupportedEncodingException");
            return e;
        }
        object = "UTF-8";
        String string2 = new String(byArray, (String)object);
        return string2;
    }

    public static byte[] p(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        if (byArray != null && byArray2 != null && (n11 = byArray2.length) >= (n10 = 16)) {
            n11 = (byArray = d.j.f.a.a.h.b.a.i(byArray)).length;
            if (n11 == 0) {
                return new byte[0];
            }
            n11 = d.j.f.a.a.h.b.b.g(byArray);
            if (n11 >= 0) {
                byte[] byArray3 = Arrays.copyOf(byArray, n11);
                int n12 = byArray.length;
                int n13 = byArray3.length;
                n12 = n12 - n13 + -1;
                byte[] byArray4 = new byte[n12];
                System.arraycopy(byArray, ++n11, byArray4, 0, n12);
                return d.j.f.a.a.h.b.b.m(byArray4, byArray2, byArray3);
            }
            d.j.f.a.a.h.f.g.f(d, " gcm cipherText data missing colon");
            return new byte[0];
        }
        return new byte[0];
    }

    public static String q(String string2, String object) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = e;
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0 && (n10 = d.j.f.a.a.h.b.b.x()) != 0) {
            int n11;
            n10 = ((Object)(object = (Object)d.j.f.a.a.h.f.c.c((String)object))).length;
            if (n10 < (n11 = 16)) {
                d.j.f.a.a.h.f.g.f(d, "key length is not right");
                return string3;
            }
            return d.j.f.a.a.h.b.b.s(string2, (byte[])object);
        }
        return string3;
    }

    public static String r(String string2, String object, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string4 = e;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3)) && (bl2 = d.j.f.a.a.h.b.b.x())) {
            int n10;
            object = d.j.f.a.a.h.f.c.c((String)object);
            byte[] byArray = d.j.f.a.a.h.f.c.c(string3);
            int n11 = ((Object)object).length;
            int n12 = 16;
            if (n11 >= n12 && (n10 = string3.length()) >= (n11 = 12)) {
                return d.j.f.a.a.h.b.b.t(string2, (byte[])object, byArray);
            }
            d.j.f.a.a.h.f.g.f(d, "key length or iv length is not right");
            return string4;
        }
        d.j.f.a.a.h.f.g.f(d, "gcm encrypt parameter is not right");
        return string4;
    }

    public static String s(String object, byte[] object2) {
        int n10;
        Object object3;
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)object);
        String string2 = e;
        if (n12 == 0 && object2 != null && (n12 = ((byte[])object2).length) >= (n11 = 16) && (n12 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0 && (object = (Object)d.j.f.a.a.h.b.b.b((String)object, object2, (byte[])(object3 = d.j.f.a.a.h.f.b.e(n12 = 12)))) != null && (n10 = ((Object)object).length) != 0) {
            object2 = d.j.f.a.a.h.f.c.b((byte[])object3);
            object = d.j.f.a.a.h.f.c.b((byte[])object);
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)object);
            return ((StringBuilder)object3).toString();
        }
        return string2;
    }

    public static String t(String string2, byte[] byArray, byte[] byArray2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && byArray != null && (n11 = byArray.length) >= (n10 = 16) && byArray2 != null && (n11 = byArray2.length) >= (n10 = 12) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            return d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.b.b.b(string2, byArray, byArray2));
        }
        d.j.f.a.a.h.f.g.f(d, "gcm encrypt param is not right");
        return e;
    }

    public static byte[] u(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = d.j.f.a.a.h.f.b.e(12);
        byArray = d.j.f.a.a.h.b.b.v(byArray, byArray2, byArray3);
        return d.j.f.a.a.h.b.b.d(byArray3, byArray);
    }

    public static byte[] v(byte[] byArray, byte[] object, byte[] object2) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) != 0 && object != null && (n11 = ((byte[])object).length) >= (n10 = 16) && object2 != null && (n11 = ((byte[])object2).length) >= (n10 = 12) && (n11 = (int)(d.j.f.a.a.h.b.b.x() ? 1 : 0)) != 0) {
            SecretKeySpec secretKeySpec;
            String string2 = c;
            try {
                secretKeySpec = new SecretKeySpec((byte[])object, string2);
            }
            catch (GeneralSecurityException generalSecurityException) {
                object = d;
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("GCM encrypt data error");
                String string3 = generalSecurityException.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                d.j.f.a.a.h.f.g.f((String)object, string3);
                return new byte[0];
            }
            object = b;
            object = Cipher.getInstance((String)object);
            object2 = d.j.f.a.a.h.b.b.w((byte[])object2);
            n10 = 1;
            ((Cipher)object).init(n10, (Key)secretKeySpec, (AlgorithmParameterSpec)object2);
            return ((Cipher)object).doFinal(byArray);
        }
        d.j.f.a.a.h.f.g.f(d, "gcm encrypt param is not right");
        return new byte[0];
    }

    public static AlgorithmParameterSpec w(byte[] byArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
            return ivParameterSpec;
        }
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, byArray);
        return gCMParameterSpec;
    }

    public static boolean x() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

