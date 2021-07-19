/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.gms.common.util;

import android.util.Base64;

public final class Base64Utils {
    public static byte[] decode(String string2) {
        if (string2 == null) {
            return null;
        }
        return Base64.decode((String)string2, (int)0);
    }

    public static byte[] decodeUrlSafe(String string2) {
        if (string2 == null) {
            return null;
        }
        return Base64.decode((String)string2, (int)10);
    }

    public static byte[] decodeUrlSafeNoPadding(String string2) {
        if (string2 == null) {
            return null;
        }
        return Base64.decode((String)string2, (int)11);
    }

    public static String encode(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        return Base64.encodeToString((byte[])byArray, (int)0);
    }

    public static String encodeUrlSafe(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        return Base64.encodeToString((byte[])byArray, (int)10);
    }

    public static String encodeUrlSafeNoPadding(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        return Base64.encodeToString((byte[])byArray, (int)11);
    }
}

