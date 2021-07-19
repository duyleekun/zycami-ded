/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$JavaDigit
extends CharMatcher {
    public static final CharMatcher$JavaDigit INSTANCE;

    static {
        CharMatcher$JavaDigit charMatcher$JavaDigit;
        INSTANCE = charMatcher$JavaDigit = new CharMatcher$JavaDigit();
    }

    private CharMatcher$JavaDigit() {
    }

    public boolean matches(char c10) {
        return Character.isDigit(c10);
    }

    public String toString() {
        return "CharMatcher.javaDigit()";
    }
}

