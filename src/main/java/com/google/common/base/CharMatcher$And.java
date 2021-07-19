/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

public final class CharMatcher$And
extends CharMatcher {
    public final CharMatcher first;
    public final CharMatcher second;

    public CharMatcher$And(CharMatcher charMatcher, CharMatcher charMatcher2) {
        this.first = charMatcher = (CharMatcher)Preconditions.checkNotNull(charMatcher);
        this.second = charMatcher = (CharMatcher)Preconditions.checkNotNull(charMatcher2);
    }

    public boolean matches(char c10) {
        CharMatcher charMatcher = this.first;
        boolean bl2 = charMatcher.matches(c10);
        c10 = bl2 && (c10 = (char)((charMatcher = this.second).matches(c10) ? 1 : 0)) != '\u0000' ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        this.first.setBits(bitSet2);
        BitSet bitSet3 = new BitSet();
        this.second.setBits(bitSet3);
        bitSet2.and(bitSet3);
        bitSet.or(bitSet2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.and(");
        CharMatcher charMatcher = this.first;
        stringBuilder.append(charMatcher);
        stringBuilder.append(", ");
        charMatcher = this.second;
        stringBuilder.append(charMatcher);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

