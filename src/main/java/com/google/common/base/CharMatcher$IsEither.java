/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

public final class CharMatcher$IsEither
extends CharMatcher$FastMatcher {
    private final char match1;
    private final char match2;

    public CharMatcher$IsEither(char c10, char c11) {
        this.match1 = c10;
        this.match2 = c11;
    }

    public boolean matches(char c10) {
        char c11 = this.match1;
        c10 = c10 != c11 && c10 != (c11 = this.match2) ? (char)'\u0000' : '\u0001';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        char c10 = this.match1;
        bitSet.set(c10);
        c10 = this.match2;
        bitSet.set(c10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.anyOf(\"");
        String string2 = CharMatcher.access$100(this.match1);
        stringBuilder.append(string2);
        string2 = CharMatcher.access$100(this.match2);
        stringBuilder.append(string2);
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }
}

