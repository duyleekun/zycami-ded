/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

public final class CharMatcher$Is
extends CharMatcher$FastMatcher {
    private final char match;

    public CharMatcher$Is(char c10) {
        this.match = c10;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        char c10 = this.match;
        boolean bl2 = charMatcher.matches(c10);
        charMatcher = bl2 ? this : CharMatcher.none();
        return charMatcher;
    }

    public boolean matches(char c10) {
        char c11 = this.match;
        c10 = c10 == c11 ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public CharMatcher negate() {
        return CharMatcher.isNot(this.match);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        char c10 = this.match;
        if ((c10 = (char)(charMatcher.matches(c10) ? 1 : 0)) == '\u0000') {
            charMatcher = super.or(charMatcher);
        }
        return charMatcher;
    }

    public String replaceFrom(CharSequence charSequence, char c10) {
        charSequence = charSequence.toString();
        char c11 = this.match;
        return ((String)charSequence).replace(c11, c10);
    }

    public void setBits(BitSet bitSet) {
        char c10 = this.match;
        bitSet.set(c10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.is('");
        String string2 = CharMatcher.access$100(this.match);
        stringBuilder.append(string2);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}

