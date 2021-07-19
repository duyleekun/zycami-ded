/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.Escaper;
import com.google.common.escape.Platform;

public abstract class CharEscaper
extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    private static char[] growBuffer(char[] object, int n10, int n11) {
        if (n11 >= 0) {
            char[] cArray = new char[n11];
            if (n10 > 0) {
                System.arraycopy(object, 0, cArray, 0, n10);
            }
            return cArray;
        }
        object = new AssertionError;
        object((Object)"Cannot increase internal buffer any further");
        throw object;
    }

    public String escape(String string2) {
        Preconditions.checkNotNull(string2);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = string2.charAt(i10);
            char[] cArray = this.escape(c10);
            if (cArray == null) continue;
            return this.escapeSlow(string2, i10);
        }
        return string2;
    }

    public abstract char[] escape(char var1);

    public final String escapeSlow(String string2, int n10) {
        int n11 = string2.length();
        char[] cArray = Platform.charBufferFromThreadLocal();
        int n12 = cArray.length;
        int n13 = 0;
        int n14 = 0;
        while (n10 < n11) {
            char c10 = string2.charAt(n10);
            char[] cArray2 = this.escape(c10);
            if (cArray2 != null) {
                int n15 = n10 - n13;
                int n16 = n14 + n15;
                int n17 = cArray2.length;
                int n18 = n16 + n17;
                if (n12 < n18) {
                    n12 = (n11 - n10) * 2 + n18;
                    cArray = CharEscaper.growBuffer(cArray, n14, n12);
                }
                if (n15 > 0) {
                    string2.getChars(n13, n10, cArray, n14);
                    n14 = n16;
                }
                if (n17 > 0) {
                    System.arraycopy(cArray2, 0, cArray, n14, n17);
                    n14 += n17;
                }
                n13 = n10 + 1;
            }
            ++n10;
        }
        n10 = n11 - n13;
        if (n10 > 0) {
            if (n12 < (n10 += n14)) {
                cArray = CharEscaper.growBuffer(cArray, n14, n10);
            }
            string2.getChars(n13, n11, cArray, n14);
            n14 = n10;
        }
        string2 = new String(cArray, 0, n14);
        return string2;
    }
}

