/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SecurityBase64Utils;
import d.j.f.a.a.k.h;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            return object;
        }
        object = ((String)object).toCharArray();
        String string2 = null;
        for (n11 = 0; n11 < (n10 = ((Object)object).length); ++n11) {
            n10 = n11 % 2;
            if (n10 == 0) continue;
            n10 = 42;
            object[n11] = n10;
        }
        string2 = new String((char[])object);
        return string2;
    }

    public static String byte2Str(byte[] byArray) {
        String string2 = "";
        if (byArray == null) {
            return string2;
        }
        String string3 = "UTF-8";
        try {
            String string4 = new String(byArray, string3);
            return string4;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", unsupportedEncodingException);
            return string2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean checkCompatible(String object) {
        boolean bl2;
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass((String)object);
            object = StringUtils.class;
            synchronized (object) {
                IS_AEGIS_STRING_LIBRARY_LOADED = bl2 = true;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        return bl2;
    }

    public static String format(String string2, Object ... objectArray) {
        if (string2 == null) {
            return "";
        }
        return String.format(Locale.ROOT, string2, objectArray);
    }

    public static byte[] getBytes(long l10) {
        return StringUtils.getBytes(String.valueOf(l10));
    }

    public static byte[] getBytes(String string2) {
        byte[] byArray = new byte[]{};
        if (string2 == null) {
            return byArray;
        }
        String string3 = "utf-8";
        try {
            byArray = string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string2 = TAG;
            string3 = "the content has error while it is converted to bytes";
            Logger.w(string2, string3);
        }
        return byArray;
    }

    public static String getTraceInfo(Throwable stackTraceElementArray) {
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTraceElementArray) {
            String string2 = "at ";
            stringBuilder.append(string2);
            String string3 = stackTraceElement.toString();
            stringBuilder.append(string3);
            String object = ";";
            stringBuilder.append(object);
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String replace(String string2, CharSequence charSequence, CharSequence charSequence2) {
        boolean bl2 = IS_AEGIS_STRING_LIBRARY_LOADED;
        if (bl2) return h.a(string2, charSequence, charSequence2);
        String string3 = SAFE_STRING_PATH;
        bl2 = StringUtils.checkCompatible(string3);
        if (bl2) return h.a(string2, charSequence, charSequence2);
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) return string2;
        bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) return string2;
        try {
            return string2.replace(charSequence, charSequence2);
        }
        catch (Exception exception) {
            return string2;
        }
    }

    public static byte[] str2Byte(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return new byte[0];
        }
        String string3 = "UTF-8";
        try {
            return string2.getBytes(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", unsupportedEncodingException);
            return new byte[0];
        }
    }

    public static boolean strEquals(String string2, String string3) {
        boolean bl2;
        if (!(string2 == string3 || string2 != null && (bl2 = string2.equals(string3)))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static int stringToInteger(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return n10;
        }
        try {
            n10 = Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            String string3 = TAG;
            String string4 = "String to Integer catch NumberFormatException.";
            Logger.w(string3, string4, numberFormatException);
        }
        return n10;
    }

    public static long stringToLong(String string2, long l10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return l10;
        }
        try {
            l10 = Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            String string3 = TAG;
            String string4 = "String to Long catch NumberFormatException.";
            Logger.w(string3, string4, numberFormatException);
        }
        return l10;
    }

    public static String substring(String string2, int n10) {
        String string3 = SAFE_STRING_PATH;
        int n11 = StringUtils.checkCompatible(string3);
        if (n11 != 0) {
            return h.b(string2, n10);
        }
        n11 = TextUtils.isEmpty((CharSequence)string2);
        String string4 = "";
        if (n11 == 0 && (n11 = string2.length()) >= n10 && n10 >= 0) {
            try {
                return string2.substring(n10);
            }
            catch (Exception exception) {}
        }
        return string4;
    }

    public static String substring(String string2, int n10, int n11) {
        String string3;
        int n12 = IS_AEGIS_STRING_LIBRARY_LOADED;
        if (n12 == 0 && (n12 = StringUtils.checkCompatible(string3 = SAFE_STRING_PATH)) == 0) {
            n12 = TextUtils.isEmpty((CharSequence)string2);
            String string4 = "";
            if (n12 == 0 && n10 >= 0 && n11 <= (n12 = string2.length()) && n11 >= n10) {
                try {
                    return string2.substring(n10, n11);
                }
                catch (Exception exception) {}
            }
            return string4;
        }
        return h.c(string2, n10, n11);
    }

    public static String toLowerCase(String string2) {
        if (string2 == null) {
            return string2;
        }
        Locale locale = Locale.ROOT;
        return string2.toLowerCase(locale);
    }
}

