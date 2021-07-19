/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.c;

import android.os.Build;
import android.text.TextUtils;
import d.j.f.a.a.h.f.b;
import d.j.f.a.a.h.f.g;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class c {
    private static final String a = "c";
    private static final String b = "PBKDF2WithHmacSHA1";
    private static final String c = "PBKDF2WithHmacSHA256";
    private static final String d = "";
    private static final int e = 8;
    private static final int f = 16;
    private static final int g = 32;
    private static final int h = 10000;
    private static final int i = 1000;

    private static byte[] a(char[] object, byte[] object2, int n10, int n11, boolean bl2) {
        String string2;
        PBEKeySpec pBEKeySpec;
        block9: {
            block8: {
                pBEKeySpec = new PBEKeySpec((char[])object, (byte[])object2, n10, n11);
                if (!bl2) break block8;
                object = c;
                object = SecretKeyFactory.getInstance((String)object);
                break block9;
            }
            object = b;
            object = SecretKeyFactory.getInstance((String)object);
        }
        object = ((SecretKeyFactory)object).generateSecret(pBEKeySpec);
        try {
            return object.getEncoded();
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        object2 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pbkdf exception : ");
        string2 = ((Throwable)((Object)string2)).getMessage();
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        d.j.f.a.a.h.f.g.f((String)object2, string2);
        return new byte[0];
    }

    private static boolean b(byte[] byArray, byte[] byArray2) {
        boolean bl2 = false;
        if (byArray != null && byArray2 != null) {
            int n10;
            int n11 = byArray.length;
            int n12 = byArray2.length;
            n11 ^= n12;
            for (n12 = 0; n12 < (n10 = byArray.length) && n12 < (n10 = byArray2.length); ++n12) {
                n10 = byArray[n12];
                byte by2 = byArray2[n12];
                n11 |= (n10 ^= by2);
            }
            if (n11 == 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static byte[] c(char[] cArray, byte[] byArray, int n10, int n11) {
        return d.j.f.a.a.h.c.c.a(cArray, byArray, n10, n11, false);
    }

    public static String d(String string2) {
        return d.j.f.a.a.h.c.c.e(string2, 10000);
    }

    public static String e(String string2, int n10) {
        byte[] byArray = d.j.f.a.a.h.f.b.e(8);
        return d.j.f.a.a.h.c.c.f(string2, byArray, n10, 32);
    }

    public static String f(String object, byte[] object2, int n10, int n11) {
        int n12;
        int n13 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        if (n13 != 0) {
            d.j.f.a.a.h.f.g.f(a, "pwd is null.");
            return string2;
        }
        n13 = 1000;
        if (n10 < n13) {
            d.j.f.a.a.h.f.g.f(a, "iterations times is not enough.");
            return string2;
        }
        if (object2 != null && (n13 = ((byte[])object2).length) >= (n12 = 8)) {
            n13 = 32;
            if (n11 < n13) {
                d.j.f.a.a.h.f.g.f(a, "cipherLen length is not enough");
                return string2;
            }
            object = ((String)object).toCharArray();
            object = d.j.f.a.a.h.c.c.c((char[])object, object2, n10, n11 *= n12);
            StringBuilder stringBuilder = new StringBuilder();
            object2 = d.j.f.a.a.h.f.c.b(object2);
            stringBuilder.append((String)object2);
            object = d.j.f.a.a.h.f.c.b((byte[])object);
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        d.j.f.a.a.h.f.g.f(a, "salt parameter is null or length is not enough");
        return string2;
    }

    public static String g(String string2) {
        return d.j.f.a.a.h.c.c.h(string2, 10000);
    }

    public static String h(String string2, int n10) {
        byte[] byArray = d.j.f.a.a.h.f.b.e(16);
        return d.j.f.a.a.h.c.c.i(string2, byArray, n10, 32);
    }

    public static String i(String object, byte[] object2, int n10, int n11) {
        int n12;
        int n13 = TextUtils.isEmpty((CharSequence)object);
        String string2 = d;
        if (n13 != 0) {
            d.j.f.a.a.h.f.g.f(a, "pwd is null.");
            return string2;
        }
        n13 = 1000;
        if (n10 < n13) {
            d.j.f.a.a.h.f.g.f(a, "iterations times is not enough.");
            return string2;
        }
        if (object2 != null && (n13 = ((byte[])object2).length) >= (n12 = 16)) {
            n13 = 32;
            if (n11 < n13) {
                d.j.f.a.a.h.f.g.f(a, "cipherLen length is not enough");
                return string2;
            }
            n13 = Build.VERSION.SDK_INT;
            int n14 = 26;
            if (n13 < n14) {
                String string3 = a;
                string2 = "sha 1";
                d.j.f.a.a.h.f.g.d(string3, string2);
                object = ((String)object).toCharArray();
                object = d.j.f.a.a.h.c.c.c((char[])object, object2, n10, n11 *= 8);
            } else {
                String string4 = a;
                string2 = "sha 256";
                d.j.f.a.a.h.f.g.d(string4, string2);
                object = ((String)object).toCharArray();
                object = d.j.f.a.a.h.c.c.j((char[])object, object2, n10, n11 *= 8);
            }
            StringBuilder stringBuilder = new StringBuilder();
            object2 = d.j.f.a.a.h.f.c.b(object2);
            stringBuilder.append((String)object2);
            object = d.j.f.a.a.h.f.c.b((byte[])object);
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        d.j.f.a.a.h.f.g.f(a, "salt parameter is null or length is not enough");
        return string2;
    }

    public static byte[] j(char[] cArray, byte[] byArray, int n10, int n11) {
        byte[] byArray2 = new byte[]{};
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 26;
        if (n12 < n13) {
            d.j.f.a.a.h.f.g.f(a, "system version not high than 26");
            return byArray2;
        }
        return d.j.f.a.a.h.c.c.a(cArray, byArray, n10, n11, true);
    }

    public static boolean k(String string2, String string3) {
        return d.j.f.a.a.h.c.c.l(string2, string3, 10000);
    }

    public static boolean l(String object, String object2, int n10) {
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)object);
        if (n12 == 0 && (n12 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (n12 = ((String)object2).length()) >= (n11 = 16)) {
            Object object3 = ((String)object2).substring(0, n11);
            object2 = ((String)object2).substring(n11);
            object = ((String)object).toCharArray();
            object3 = d.j.f.a.a.h.f.c.c((String)object3);
            object = d.j.f.a.a.h.c.c.c((char[])object, (byte[])object3, n10, 256);
            object2 = d.j.f.a.a.h.f.c.c((String)object2);
            return d.j.f.a.a.h.c.c.b((byte[])object, (byte[])object2);
        }
        return false;
    }

    public static boolean m(String string2, String string3) {
        return d.j.f.a.a.h.c.c.n(string2, string3, 10000);
    }

    public static boolean n(String object, String object2, int n10) {
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)object);
        int n13 = 0;
        if (n12 == 0 && (n12 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (n12 = ((String)object2).length()) >= (n11 = 32)) {
            Object object3 = ((String)object2).substring(0, n11);
            object2 = ((String)object2).substring(n11);
            n13 = Build.VERSION.SDK_INT;
            n11 = 26;
            int n14 = 256;
            if (n13 < n11) {
                object = ((String)object).toCharArray();
                object3 = d.j.f.a.a.h.f.c.c((String)object3);
                object = d.j.f.a.a.h.c.c.c((char[])object, (byte[])object3, n10, n14);
            } else {
                object = ((String)object).toCharArray();
                object3 = d.j.f.a.a.h.f.c.c((String)object3);
                object = d.j.f.a.a.h.c.c.j((char[])object, (byte[])object3, n10, n14);
            }
            object2 = d.j.f.a.a.h.f.c.c((String)object2);
            return d.j.f.a.a.h.c.c.b((byte[])object, (byte[])object2);
        }
        return false;
    }
}

