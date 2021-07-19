/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;

public final class CharMatcher$None
extends CharMatcher$NamedFastMatcher {
    public static final CharMatcher$None INSTANCE;

    static {
        CharMatcher$None charMatcher$None;
        INSTANCE = charMatcher$None = new CharMatcher$None();
    }

    private CharMatcher$None() {
        super("CharMatcher.none()");
    }

    public CharMatcher and(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    public String collapseFrom(CharSequence charSequence, char c10) {
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return 0;
    }

    public int indexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    public int indexIn(CharSequence charSequence, int n10) {
        int n11 = charSequence.length();
        Preconditions.checkPositionIndex(n10, n11);
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return -1;
    }

    public boolean matches(char c10) {
        return false;
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    public CharMatcher negate() {
        return CharMatcher.any();
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }

    public String removeFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    public String replaceFrom(CharSequence charSequence, char c10) {
        return charSequence.toString();
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence2);
        return charSequence.toString();
    }

    public String trimFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        return charSequence.toString();
    }
}

