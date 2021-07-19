/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.common.escape.ArrayBasedEscaperMap
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.ArrayBasedEscaperMap;
import com.google.common.escape.UnicodeEscaper;
import java.util.Map;

public abstract class ArrayBasedUnicodeEscaper
extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap object, int n10, int n11, String string2) {
        int n12;
        Preconditions.checkNotNull(object);
        object = object.getReplacementArray();
        this.replacements = (char[][])object;
        this.replacementsLength = n12 = ((ArrayBasedEscaperMap)object).length;
        if (n11 < n10) {
            n11 = -1;
            n10 = -1 >>> 1;
        }
        this.safeMin = n10;
        this.safeMax = n11;
        n12 = 55296;
        if (n10 >= n12) {
            this.safeMinChar = (char)-1;
            n12 = 0;
            object = null;
            this.safeMaxChar = '\u0000';
        } else {
            n12 = (char)n10;
            this.safeMinChar = (char)n12;
            n12 = (char)Math.min(n11, 55295);
            this.safeMaxChar = (char)n12;
        }
    }

    public ArrayBasedUnicodeEscaper(Map map, int n10, int n11, String string2) {
        map = ArrayBasedEscaperMap.create((Map)map);
        this((ArrayBasedEscaperMap)map, n10, n11, string2);
    }

    public final String escape(String string2) {
        int n10;
        Preconditions.checkNotNull(string2);
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            char[] cArray;
            int n11;
            n10 = string2.charAt(i10);
            if ((n10 >= (n11 = this.replacementsLength) || (cArray = this.replacements[n10]) == null) && n10 <= (n11 = (int)this.safeMaxChar) && n10 >= (n11 = (int)this.safeMinChar)) {
                continue;
            }
            string2 = this.escapeSlow(string2, i10);
            break;
        }
        return string2;
    }

    public final char[] escape(int n10) {
        char[] cArray;
        int n11 = this.replacementsLength;
        if (n10 < n11 && (cArray = this.replacements[n10]) != null) {
            return cArray;
        }
        n11 = this.safeMin;
        if (n10 >= n11 && n10 <= (n11 = this.safeMax)) {
            return null;
        }
        return this.escapeUnsafe(n10);
    }

    public abstract char[] escapeUnsafe(int var1);

    public final int nextEscapeIndex(CharSequence charSequence, int n10, int n11) {
        char[] cArray;
        int n12;
        char c10;
        while (n10 < n11 && ((c10 = charSequence.charAt(n10)) >= (n12 = this.replacementsLength) || (cArray = this.replacements[c10]) == null) && c10 <= (n12 = (int)this.safeMaxChar) && c10 >= (n12 = (int)this.safeMinChar)) {
            ++n10;
        }
        return n10;
    }
}

