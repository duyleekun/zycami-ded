/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$JavaLetter
extends CharMatcher {
    public static final CharMatcher$JavaLetter INSTANCE;

    static {
        CharMatcher$JavaLetter charMatcher$JavaLetter;
        INSTANCE = charMatcher$JavaLetter = new CharMatcher$JavaLetter();
    }

    private CharMatcher$JavaLetter() {
    }

    public boolean matches(char c10) {
        return Character.isLetter(c10);
    }

    public String toString() {
        return "CharMatcher.javaLetter()";
    }
}

