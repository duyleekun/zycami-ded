/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

public final class CharMatcher$InRange
extends CharMatcher$FastMatcher {
    private final char endInclusive;
    private final char startInclusive;

    public CharMatcher$InRange(char c10, char c11) {
        boolean bl2 = c11 >= c10;
        Preconditions.checkArgument(bl2);
        this.startInclusive = c10;
        this.endInclusive = c11;
    }

    public boolean matches(char c10) {
        char c11 = this.startInclusive;
        c10 = c11 <= c10 && c10 <= (c11 = this.endInclusive) ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        char c10 = this.startInclusive;
        int n10 = this.endInclusive + '\u0001';
        bitSet.set((int)c10, n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.inRange('");
        String string2 = CharMatcher.access$100(this.startInclusive);
        stringBuilder.append(string2);
        stringBuilder.append("', '");
        string2 = CharMatcher.access$100(this.endInclusive);
        stringBuilder.append(string2);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}

