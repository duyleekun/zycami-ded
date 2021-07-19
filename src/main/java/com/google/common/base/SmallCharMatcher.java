/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import java.util.BitSet;

public final class SmallCharMatcher
extends CharMatcher$NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5;
    public static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArray, long l10, boolean bl2, String string2) {
        super(string2);
        this.table = cArray;
        this.filter = l10;
        this.containsZero = bl2;
    }

    private boolean checkFilter(int n10) {
        long l10 = this.filter >> n10;
        long l11 = 1L;
        long l12 = l11 - (l10 &= l11);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public static int chooseTableSize(int n10) {
        double d10;
        double d11;
        double d12;
        int n11 = 1;
        if (n10 == n11) {
            return 2;
        }
        int n12 = Integer.highestOneBit(n10 + -1);
        n11 = n12 << 1;
        while ((n12 = (int)((d12 = (d11 = (double)n11 * 0.5) - (d10 = (double)n10)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) < 0) {
            n11 <<= 1;
        }
        return n11;
    }

    public static CharMatcher from(BitSet object, String string2) {
        int n10;
        int n11 = ((BitSet)object).cardinality();
        boolean bl2 = ((BitSet)object).get(0);
        n11 = SmallCharMatcher.chooseTableSize(n11);
        char[] cArray = new char[n11];
        n11 += -1;
        int n12 = ((BitSet)object).nextSetBit(0);
        long l10 = 0L;
        block0: while (n12 != (n10 = -1)) {
            long l11 = 1L << n12 | l10;
            n10 = SmallCharMatcher.smear(n12);
            while (true) {
                char c10;
                if ((c10 = cArray[n10 &= n11]) == '\u0000') {
                    cArray[n10] = c10 = (char)n12;
                    ++n12;
                    n12 = ((BitSet)object).nextSetBit(n12);
                    l10 = l11;
                    continue block0;
                }
                ++n10;
            }
        }
        object = new SmallCharMatcher(cArray, l10, bl2, string2);
        return object;
    }

    public static int smear(int n10) {
        return Integer.rotateLeft(n10 * -862048943, 15) * 461845907;
    }

    public boolean matches(char c10) {
        int n10;
        if (c10 == '\u0000') {
            return this.containsZero;
        }
        int n11 = this.checkFilter(c10);
        if (n11 == 0) {
            return false;
        }
        char[] cArray = this.table;
        n11 = cArray.length;
        int n12 = 1;
        int n13 = n10 = SmallCharMatcher.smear(c10) & (n11 -= n12);
        do {
            char[] cArray2;
            char c11;
            if ((c11 = (cArray2 = this.table)[n13]) == '\u0000') {
                return false;
            }
            char c12 = cArray2[n13];
            if (c12 != c10) continue;
            return n12 != 0;
        } while ((n13 = n13 + 1 & n11) != n10);
        return false;
    }

    public void setBits(BitSet bitSet) {
        boolean bl2 = this.containsZero;
        int n10 = 0;
        if (bl2) {
            bitSet.set(0);
        }
        char[] cArray = this.table;
        int n11 = cArray.length;
        while (n10 < n11) {
            char c10 = cArray[n10];
            if (c10 != '\u0000') {
                bitSet.set(c10);
            }
            ++n10;
        }
    }
}

