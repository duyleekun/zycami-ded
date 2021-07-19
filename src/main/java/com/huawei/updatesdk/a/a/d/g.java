/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.a.a.d;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

public abstract class g {
    public static String a(String string2) {
        String string3;
        if (string2 == null) {
            return null;
        }
        String string4 = "UTF-8";
        try {
            string2 = URLEncoder.encode(string2, string4);
            string4 = "+";
            string3 = "%20";
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            a.a("StringUtils", "encode2utf8 error", unsupportedEncodingException);
            return null;
        }
        string2 = string2.replace(string4, string3);
        string4 = "*";
        string3 = "%2A";
        string2 = string2.replace(string4, string3);
        string4 = "~";
        string3 = "%7E";
        return string2.replace(string4, string3);
    }

    public static String a(byte[] object) {
        String string2 = "StringUtils";
        Object object2 = "SHA-256";
        object2 = MessageDigest.getInstance((String)object2);
        ((MessageDigest)object2).update((byte[])object);
        object = new StringBuilder;
        int n10 = 256;
        ((StringBuilder)object)(n10);
        object2 = ((MessageDigest)object2).digest();
        n10 = ((Object)object2).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object2[i10];
            Locale locale = Locale.ENGLISH;
            String string3 = "%02X";
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            Object object4 = (byte)object3;
            objectArray[0] = object4;
            object4 = String.format(locale, string3, objectArray);
            ((StringBuilder)object).append((String)object4);
            continue;
        }
        try {
            return ((StringBuilder)object).toString();
        }
        catch (Exception exception) {
            object = "sha256EncryptStr error:Exception";
        }
        catch (IllegalFormatException illegalFormatException) {
            object = "sha256EncryptStr error:IllegalFormatException";
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = "sha256EncryptStr error:NoSuchAlgorithmException";
        }
        a.b(string2, (String)object);
        return null;
    }

    public static String b(String string2) {
        if ((string2 = g.e(string2)) == null) {
            string2 = null;
        } else {
            Locale locale = Locale.getDefault();
            string2 = string2.toLowerCase(locale);
        }
        return string2;
    }

    public static byte[] c(String object) {
        object = ((String)object).toCharArray();
        int n10 = ((Object)object).length / 2;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = i10 * 2;
            Object object2 = object[n11];
            int n12 = 16;
            object2 = Character.digit((char)object2, n12);
            ++n11;
            n11 = Character.digit((char)object[n11], n12);
            object2 <<= 4;
            if ((n11 |= object2) > (object2 = (Object)127)) {
                n11 += -256;
            }
            Byte by2 = Byte.valueOf(String.valueOf(n11));
            byArray[i10] = n11 = (int)by2.byteValue();
        }
        return byArray;
    }

    public static boolean d(String string2) {
        boolean bl2;
        String string3;
        String string4;
        boolean bl3;
        if (string2 != null && (bl3 = (string4 = string2.trim()).startsWith(string3 = "{")) && (bl2 = (string2 = string2.trim()).endsWith(string4 = "}"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static String e(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        String string3 = "UTF-8";
        try {
            return g.a(string2.getBytes(string3));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            a.b("StringUtils", "can not getBytes");
            return null;
        }
    }
}

