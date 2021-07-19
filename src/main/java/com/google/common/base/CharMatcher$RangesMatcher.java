/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

public class CharMatcher$RangesMatcher
extends CharMatcher {
    private final String description;
    private final char[] rangeEnds;
    private final char[] rangeStarts;

    public CharMatcher$RangesMatcher(String string2, char[] cArray, char[] cArray2) {
        this.description = string2;
        this.rangeStarts = cArray;
        this.rangeEnds = cArray2;
        int n10 = cArray.length;
        int n11 = cArray2.length;
        int n12 = 1;
        if (n10 == n11) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        Preconditions.checkArgument(n10 != 0);
        n10 = 0;
        string2 = null;
        while (n10 < (n11 = cArray.length)) {
            n11 = cArray[n10];
            int n13 = cArray2[n10];
            n11 = n11 <= n13 ? n12 : 0;
            Preconditions.checkArgument(n11 != 0);
            n11 = n10 + 1;
            n13 = cArray.length;
            if (n11 < n13) {
                n13 = cArray[n11];
                if ((n10 = cArray2[n10]) < n13) {
                    n10 = n12;
                } else {
                    n10 = 0;
                    string2 = null;
                }
                Preconditions.checkArgument(n10 != 0);
            }
            n10 = n11;
        }
    }

    public boolean matches(char c10) {
        char[] cArray;
        char[] cArray2 = this.rangeStarts;
        int n10 = Arrays.binarySearch(cArray2, c10);
        int n11 = 1;
        if (n10 >= 0) {
            return n11 != 0;
        }
        if ((n10 = ~n10 - n11) < 0 || c10 > (n10 = (cArray = this.rangeEnds)[n10])) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public String toString() {
        return this.description;
    }
}

