/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

public final class CharMatcher$Any
extends CharMatcher$NamedFastMatcher {
    public static final CharMatcher$Any INSTANCE;

    static {
        CharMatcher$Any charMatcher$Any;
        INSTANCE = charMatcher$Any = new CharMatcher$Any();
    }

    private CharMatcher$Any() {
        super("CharMatcher.any()");
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return (CharMatcher)Preconditions.checkNotNull(charMatcher);
    }

    public String collapseFrom(CharSequence charSequence, char c10) {
        int n10 = charSequence.length();
        charSequence = n10 == 0 ? "" : String.valueOf(c10);
        return charSequence;
    }

    public int countIn(CharSequence charSequence) {
        return charSequence.length();
    }

    public int indexIn(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (n10 == 0) {
            n10 = -1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10;
    }

    public int indexIn(CharSequence charSequence, int n10) {
        int n11 = charSequence.length();
        Preconditions.checkPositionIndex(n10, n11);
        if (n10 == n11) {
            n10 = -1;
        }
        return n10;
    }

    public int lastIndexIn(CharSequence charSequence) {
        return charSequence.length() + -1;
    }

    public boolean matches(char c10) {
        return true;
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public CharMatcher negate() {
        return CharMatcher.none();
    }

    public CharMatcher or(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return this;
    }

    public String removeFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }

    public String replaceFrom(CharSequence object, char c10) {
        object = new char[object.length()];
        Arrays.fill((char[])object, c10);
        String string2 = new String((char[])object);
        return string2;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int n10 = charSequence.length();
        int n11 = charSequence2.length();
        StringBuilder stringBuilder = new StringBuilder(n10 *= n11);
        for (n10 = 0; n10 < (n11 = charSequence.length()); ++n10) {
            stringBuilder.append(charSequence2);
        }
        return stringBuilder.toString();
    }

    public String trimFrom(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return "";
    }
}

