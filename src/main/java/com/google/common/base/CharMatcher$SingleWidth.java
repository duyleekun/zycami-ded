/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

public final class CharMatcher$SingleWidth
extends CharMatcher$RangesMatcher {
    public static final CharMatcher$SingleWidth INSTANCE;

    static {
        CharMatcher$SingleWidth charMatcher$SingleWidth;
        INSTANCE = charMatcher$SingleWidth = new CharMatcher$SingleWidth();
    }

    private CharMatcher$SingleWidth() {
        char[] cArray = "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray();
        char[] cArray2 = "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray();
        super("CharMatcher.singleWidth()", cArray, cArray2);
    }
}

