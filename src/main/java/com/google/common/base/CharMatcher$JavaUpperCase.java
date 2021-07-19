/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

public final class CharMatcher$JavaUpperCase
extends CharMatcher {
    public static final CharMatcher$JavaUpperCase INSTANCE;

    static {
        CharMatcher$JavaUpperCase charMatcher$JavaUpperCase;
        INSTANCE = charMatcher$JavaUpperCase = new CharMatcher$JavaUpperCase();
    }

    private CharMatcher$JavaUpperCase() {
    }

    public boolean matches(char c10) {
        return Character.isUpperCase(c10);
    }

    public String toString() {
        return "CharMatcher.javaUpperCase()";
    }
}

