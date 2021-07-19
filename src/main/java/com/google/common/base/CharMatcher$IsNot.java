/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

public final class CharMatcher$IsNot
extends CharMatcher$FastMatcher {
    private final char match;

    public CharMatcher$IsNot(char c10) {
        this.match = c10;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        char c10 = this.match;
        if ((c10 = (char)(charMatcher.matches(c10) ? 1 : 0)) != '\u0000') {
            charMatcher = super.and(charMatcher);
        }
        return charMatcher;
    }

    public boolean matches(char c10) {
        char c11 = this.match;
        c10 = c10 != c11 ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public CharMatcher negate() {
        return CharMatcher.is(this.match);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        char c10 = this.match;
        boolean bl2 = charMatcher.matches(c10);
        charMatcher = bl2 ? CharMatcher.any() : this;
        return charMatcher;
    }

    public void setBits(BitSet bitSet) {
        int n10 = this.match;
        bitSet.set(0, n10);
        n10 = this.match + '\u0001';
        bitSet.set(n10, 65536);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.isNot('");
        String string2 = CharMatcher.access$100(this.match);
        stringBuilder.append(string2);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}

