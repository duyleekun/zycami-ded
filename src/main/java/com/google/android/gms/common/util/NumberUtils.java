/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

public class NumberUtils {
    private NumberUtils() {
    }

    public static long parseHexLong(String string2) {
        int n10;
        int n11 = string2.length();
        if (n11 <= (n10 = 16)) {
            n11 = string2.length();
            if (n11 == n10) {
                n11 = 8;
                long l10 = Long.parseLong(string2.substring(n11), n10);
                return Long.parseLong(string2.substring(0, n11), n10) << 32 | l10;
            }
            return Long.parseLong(string2, n10);
        }
        n10 = String.valueOf(string2).length() + 37;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Invalid input: ");
        stringBuilder.append(string2);
        stringBuilder.append(" exceeds 16 characters");
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }
}

