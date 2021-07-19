/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.escape.CharEscaper;

public class CharEscaperBuilder$CharArrayDecorator
extends CharEscaper {
    private final int replaceLength;
    private final char[][] replacements;

    public CharEscaperBuilder$CharArrayDecorator(char[][] cArray) {
        int n10;
        this.replacements = cArray;
        this.replaceLength = n10 = cArray.length;
    }

    public String escape(String string2) {
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char[] cArray;
            char[][] cArray2;
            int n11;
            char c10 = string2.charAt(i10);
            if (c10 >= (n11 = (cArray2 = this.replacements).length) || (cArray = cArray2[c10]) == null) continue;
            return this.escapeSlow(string2, i10);
        }
        return string2;
    }

    public char[] escape(char c10) {
        char[] cArray;
        int n10 = this.replaceLength;
        if (c10 < n10) {
            char[][] cArray2 = this.replacements;
            cArray = cArray2[c10];
        } else {
            c10 = '\u0000';
            cArray = null;
        }
        return cArray;
    }
}

