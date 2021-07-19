/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$JavaLetterOrDigit
extends CharMatcher {
    public static final CharMatcher$JavaLetterOrDigit INSTANCE;

    static {
        CharMatcher$JavaLetterOrDigit charMatcher$JavaLetterOrDigit;
        INSTANCE = charMatcher$JavaLetterOrDigit = new CharMatcher$JavaLetterOrDigit();
    }

    private CharMatcher$JavaLetterOrDigit() {
    }

    public boolean matches(char c10) {
        return Character.isLetterOrDigit(c10);
    }

    public String toString() {
        return "CharMatcher.javaLetterOrDigit()";
    }
}

