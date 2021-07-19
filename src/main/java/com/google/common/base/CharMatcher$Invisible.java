/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$RangesMatcher;

public final class CharMatcher$Invisible
extends CharMatcher$RangesMatcher {
    public static final CharMatcher$Invisible INSTANCE;
    private static final String RANGE_ENDS = " \u00a0\u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f\u202f\u2064\u206f\u3000\uf8ff\ufeff\ufffb";
    private static final String RANGE_STARTS = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

    static {
        CharMatcher$Invisible charMatcher$Invisible;
        INSTANCE = charMatcher$Invisible = new CharMatcher$Invisible();
    }

    private CharMatcher$Invisible() {
        char[] cArray = RANGE_STARTS.toCharArray();
        char[] cArray2 = RANGE_ENDS.toCharArray();
        super("CharMatcher.invisible()", cArray, cArray2);
    }
}

