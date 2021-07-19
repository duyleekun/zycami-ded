/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

public final class StringMerger {
    public static String mergeStrings(String object, String string2) {
        int n10 = ((String)object).length();
        int n11 = string2.length();
        if ((n10 -= n11) >= 0 && n10 <= (n11 = 1)) {
            char c10;
            n11 = ((String)object).length();
            int c102 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n11 += c102);
            for (n11 = 0; n11 < (c10 = ((String)object).length()); ++n11) {
                c10 = ((String)object).charAt(n11);
                stringBuilder.append(c10);
                c10 = string2.length();
                if (c10 <= n11) continue;
                c10 = string2.charAt(n11);
                stringBuilder.append(c10);
            }
            return stringBuilder.toString();
        }
        object = new IllegalArgumentException("Invalid input received");
        throw object;
    }
}

