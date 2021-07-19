/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

public final class CharMatcher$Or
extends CharMatcher {
    public final CharMatcher first;
    public final CharMatcher second;

    public CharMatcher$Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
        this.first = charMatcher = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = charMatcher = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }

    public boolean matches(char c10) {
        CharMatcher charMatcher = this.first;
        boolean bl2 = charMatcher.matches(c10);
        c10 = !bl2 && (c10 = (char)((charMatcher = this.second).matches(c10) ? 1 : 0)) == '\u0000' ? (char)'\u0000' : '\u0001';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        this.first.setBits(bitSet);
        this.second.setBits(bitSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.or(");
        CharMatcher charMatcher = this.first;
        stringBuilder.append(charMatcher);
        stringBuilder.append(", ");
        charMatcher = this.second;
        stringBuilder.append(charMatcher);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

