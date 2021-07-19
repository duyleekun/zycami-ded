/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import java.util.Arrays;
import java.util.BitSet;

public final class CharMatcher$AnyOf
extends CharMatcher {
    private final char[] chars;

    public CharMatcher$AnyOf(CharSequence object) {
        object = object.toString().toCharArray();
        this.chars = (char[])object;
        Arrays.sort((char[])object);
    }

    public boolean matches(char c10) {
        char[] cArray = this.chars;
        c10 = (c10 = (char)Arrays.binarySearch(cArray, c10)) >= '\u0000' ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        for (char c10 : this.chars) {
            bitSet.set(c10);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
        for (char c10 : this.chars) {
            String string2 = CharMatcher.access$100(c10);
            stringBuilder.append(string2);
        }
        stringBuilder.append("\")");
        return stringBuilder.toString();
    }
}

