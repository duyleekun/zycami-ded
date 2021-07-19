/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

public final class ParseRequest {
    public final int radix;
    public final String rawValue;

    private ParseRequest(String string2, int n10) {
        this.rawValue = string2;
        this.radix = n10;
    }

    public static ParseRequest fromString(String object) {
        int n10 = ((String)object).length();
        if (n10 != 0) {
            boolean bl2;
            ParseRequest parseRequest = null;
            n10 = ((String)object).charAt(0);
            String string2 = "0x";
            boolean n11 = ((String)object).startsWith(string2);
            int n12 = 16;
            if (!n11 && !(bl2 = ((String)object).startsWith(string2 = "0X"))) {
                int n13 = 35;
                int n14 = 1;
                if (n10 == n13) {
                    object = ((String)object).substring(n14);
                } else {
                    int n15 = 48;
                    if (n10 == n15 && (n10 = ((String)object).length()) > n14) {
                        object = ((String)object).substring(n14);
                        n12 = 8;
                    } else {
                        n12 = 10;
                    }
                }
            } else {
                n10 = 2;
                object = ((String)object).substring(n10);
            }
            parseRequest = new ParseRequest((String)object, n12);
            return parseRequest;
        }
        object = new NumberFormatException("empty string");
        throw object;
    }
}

