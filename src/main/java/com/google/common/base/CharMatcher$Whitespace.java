/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

public final class CharMatcher$Whitespace
extends CharMatcher$NamedFastMatcher {
    public static final CharMatcher$Whitespace INSTANCE;
    public static final int MULTIPLIER = 1682554634;
    public static final int SHIFT = 0;
    public static final String TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001\u202f\u00a0\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";

    static {
        CharMatcher$Whitespace charMatcher$Whitespace;
        SHIFT = Integer.numberOfLeadingZeros(31);
        INSTANCE = charMatcher$Whitespace = new CharMatcher$Whitespace();
    }

    public CharMatcher$Whitespace() {
        super("CharMatcher.whitespace()");
    }

    public boolean matches(char c10) {
        int n10 = 1682554634 * c10;
        int n11 = SHIFT;
        n10 >>>= n11;
        String string2 = TABLE;
        c10 = (n10 = (int)string2.charAt(n10)) == c10 ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public void setBits(BitSet bitSet) {
        int n10;
        for (int i10 = 0; i10 < (n10 = 32); ++i10) {
            String string2 = TABLE;
            n10 = string2.charAt(i10);
            bitSet.set(n10);
        }
    }
}

