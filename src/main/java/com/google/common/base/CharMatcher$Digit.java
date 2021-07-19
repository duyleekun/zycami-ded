/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

public final class CharMatcher$Digit
extends CharMatcher$RangesMatcher {
    public static final CharMatcher$Digit INSTANCE;
    private static final String ZEROES = "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0de6\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1a80\u1a90\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\ua9d0\ua9f0\uaa50\uabf0\uff10";

    static {
        CharMatcher$Digit charMatcher$Digit;
        INSTANCE = charMatcher$Digit = new CharMatcher$Digit();
    }

    private CharMatcher$Digit() {
        char[] cArray = CharMatcher$Digit.zeroes();
        char[] cArray2 = CharMatcher$Digit.nines();
        super("CharMatcher.digit()", cArray, cArray2);
    }

    private static char[] nines() {
        int n10 = 37;
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            String string2 = ZEROES;
            cArray[i10] = c10 = (char)(string2.charAt(i10) + 9);
        }
        return cArray;
    }

    private static char[] zeroes() {
        return ZEROES.toCharArray();
    }
}

