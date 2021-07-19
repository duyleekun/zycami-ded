/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

public final class Base64Utils {
    private static final int FLAG_DEFAULT = 0;
    private static final int FLAG_URL = 10;
    private static final int FLAG_URL_NOPADDING = 11;
    private static final String TAG = "Base64Utils";

    public static byte[] decode(String string2) {
        CharSequence charSequence = null;
        byte[] byArray = new byte[]{};
        if (string2 != null) {
            try {
                return Base64.decode((String)string2, (int)0);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                charSequence = new StringBuilder();
                String string3 = "decode failed : ";
                charSequence.append(string3);
                String string4 = illegalArgumentException.getMessage();
                charSequence.append(string4);
                string4 = charSequence.toString();
                charSequence = TAG;
                HMSLog.e((String)charSequence, string4);
            }
        }
        return byArray;
    }

    public static byte[] decodeUrlSafe(String string2) {
        byte[] byArray = new byte[]{};
        if (string2 != null) {
            int n10 = 10;
            try {
                return Base64.decode((String)string2, (int)n10);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CharSequence charSequence = new StringBuilder();
                String string3 = "decodeUrlSafe failed : ";
                charSequence.append(string3);
                String string4 = illegalArgumentException.getMessage();
                charSequence.append(string4);
                string4 = charSequence.toString();
                charSequence = TAG;
                HMSLog.e((String)charSequence, string4);
            }
        }
        return byArray;
    }

    public static byte[] decodeUrlSafeNoPadding(String string2) {
        byte[] byArray = new byte[]{};
        if (string2 != null) {
            int n10 = 11;
            try {
                return Base64.decode((String)string2, (int)n10);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CharSequence charSequence = new StringBuilder();
                String string3 = "decodeUrlSafeNoPadding failed : ";
                charSequence.append(string3);
                String string4 = illegalArgumentException.getMessage();
                charSequence.append(string4);
                string4 = charSequence.toString();
                charSequence = TAG;
                HMSLog.e((String)charSequence, string4);
            }
        }
        return byArray;
    }

    public static String encode(byte[] byArray) {
        if (byArray != null) {
            return Base64.encodeToString((byte[])byArray, (int)0);
        }
        return null;
    }

    public static String encodeUrlSafe(byte[] byArray) {
        if (byArray != null) {
            return Base64.encodeToString((byte[])byArray, (int)10);
        }
        return null;
    }

    public static String encodeUrlSafeNoPadding(byte[] byArray) {
        if (byArray != null) {
            return Base64.encodeToString((byte[])byArray, (int)11);
        }
        return null;
    }
}

