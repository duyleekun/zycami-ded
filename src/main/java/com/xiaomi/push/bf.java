/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bf {
    public static String a(int n10) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = random.nextInt(62);
            String string2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            c10 = string2.charAt(c10);
            stringBuffer.append(c10);
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) return "";
        Object object = "MD5";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return string2;
        }
        byte[] byArray = bf.a(string2);
        ((MessageDigest)object).update(byArray);
        object = ((MessageDigest)object).digest();
        int n10 = 1;
        BigInteger bigInteger = new BigInteger(n10, (byte[])object);
        object = "%1$032X";
        Object[] objectArray = new Object[n10];
        objectArray[0] = bigInteger;
        return String.format((String)object, objectArray);
    }

    public static String a(String string2, int n10) {
        int n11;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n12 = string2.length();
        int n13 = 3;
        if (n10 <= 0 || n12 < n10) {
            n10 = n12 / 3;
            n11 = 1;
            if (n10 <= n11) {
                n10 = n11;
            }
            if (n10 > n13) {
                n10 = n13;
            }
        }
        n13 = 0;
        String string3 = null;
        while (n13 < n12) {
            n11 = n13 + 1;
            int n14 = n11 % n10;
            if (n14 == 0) {
                string3 = "*";
                stringBuilder.append(string3);
            } else {
                n13 = string2.charAt(n13);
                stringBuilder.append((char)n13);
            }
            n13 = n11;
        }
        return stringBuilder.toString();
    }

    public static String a(Collection collection, String string2) {
        if (collection == null) {
            return null;
        }
        return bf.a(collection.iterator(), string2);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    public static String a(Iterator iterator2, String string2) {
        if (iterator2 == null) {
            return null;
        }
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return "";
        }
        Object e10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return e10.toString();
        }
        int n10 = 256;
        StringBuffer stringBuffer = new StringBuffer(n10);
        boolean bl4 = true;
        while (true) {
            if (!bl4 || (bl4 = false) || e10 != null) {
                stringBuffer.append(e10);
            }
            do {
                if (!(bl2 = iterator2.hasNext())) {
                    return stringBuffer.toString();
                }
                if (string2 == null) continue;
                stringBuffer.append(string2);
            } while ((e10 = iterator2.next()) == null);
        }
    }

    public static String a(byte[] byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) > 0) {
            String string2;
            String string3 = "UTF-8";
            try {
                string2 = new String(byArray, string3);
                return string2;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                string2 = new String(byArray);
                return string2;
            }
        }
        return null;
    }

    public static String a(Object[] objectArray, String string2) {
        if (objectArray == null) {
            return null;
        }
        int n10 = objectArray.length;
        return bf.a(objectArray, string2, 0, n10);
    }

    public static String a(Object[] objectArray, String string2, int n10, int n11) {
        int n12;
        int n13;
        if (objectArray == null) {
            return null;
        }
        Object object = "";
        if (string2 == null) {
            string2 = object;
        }
        if ((n13 = n11 - n10) <= 0) {
            return object;
        }
        object = objectArray[n10];
        if (object == null) {
            n12 = 16;
        } else {
            object = objectArray[n10].toString();
            n12 = ((String)object).length();
        }
        int n14 = string2.length();
        object = new StringBuffer(n13 *= (n12 += n14));
        for (n13 = n10; n13 < n11; ++n13) {
            Object object2;
            if (n13 > n10) {
                ((StringBuffer)object).append(string2);
            }
            if ((object2 = objectArray[n13]) == null) continue;
            object2 = objectArray[n13];
            ((StringBuffer)object).append(object2);
        }
        return ((StringBuffer)object).toString();
    }

    public static boolean a(String string2) {
        if (string2 != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
                int n11;
                n10 = string2.charAt(i10);
                if (n10 >= 0 && n10 <= (n11 = 127)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static byte[] a(String string2) {
        String string3 = "UTF-8";
        try {
            return string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string2.getBytes();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String b(String string2) {
        if (string2 == null) return null;
        Object object = "SHA1";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return string2;
        }
        byte[] byArray = bf.a(string2);
        ((MessageDigest)object).update(byArray);
        object = ((MessageDigest)object).digest();
        int n10 = 1;
        BigInteger bigInteger = new BigInteger(n10, (byte[])object);
        object = "%1$032X";
        Object[] objectArray = new Object[n10];
        objectArray[0] = bigInteger;
        return String.format((String)object, objectArray);
    }

    public static boolean b(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        return Pattern.compile("^[A-Za-z0-9]+$").matcher(string2).matches();
    }

    public static boolean c(String string2) {
        int n10;
        int n11;
        char c10 = TextUtils.isEmpty((CharSequence)string2);
        if (c10 != '\u0000') {
            return false;
        }
        c10 = string2.charAt(0);
        for (int i10 = n10 = 1; i10 < (n11 = string2.length()); ++i10) {
            n11 = string2.charAt(i10);
            if (n11 == c10) continue;
            return false;
        }
        return n10 != 0;
    }
}

