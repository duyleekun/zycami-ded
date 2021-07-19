/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;

public final class CharMatcher$Ascii
extends CharMatcher$NamedFastMatcher {
    public static final CharMatcher$Ascii INSTANCE;

    static {
        CharMatcher$Ascii charMatcher$Ascii;
        INSTANCE = charMatcher$Ascii = new CharMatcher$Ascii();
    }

    public CharMatcher$Ascii() {
        super("CharMatcher.ascii()");
    }

    public boolean matches(char c10) {
        char c11 = '\u007f';
        c10 = c10 <= c11 ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }
}

