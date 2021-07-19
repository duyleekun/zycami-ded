/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$JavaLowerCase
extends CharMatcher {
    public static final CharMatcher$JavaLowerCase INSTANCE;

    static {
        CharMatcher$JavaLowerCase charMatcher$JavaLowerCase;
        INSTANCE = charMatcher$JavaLowerCase = new CharMatcher$JavaLowerCase();
    }

    private CharMatcher$JavaLowerCase() {
    }

    public boolean matches(char c10) {
        return Character.isLowerCase(c10);
    }

    public String toString() {
        return "CharMatcher.javaLowerCase()";
    }
}

