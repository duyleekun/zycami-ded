/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.common.escape.ArrayBasedEscaperMap
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.ArrayBasedEscaperMap;
import com.google.common.escape.CharEscaper;
import java.util.Map;

public abstract class ArrayBasedCharEscaper
extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    public ArrayBasedCharEscaper(ArrayBasedEscaperMap object, char c10, char c11) {
        int n10;
        Preconditions.checkNotNull(object);
        object = object.getReplacementArray();
        this.replacements = (char[][])object;
        this.replacementsLength = n10 = ((ArrayBasedEscaperMap)object).length;
        if (c11 < c10) {
            c11 = '\u0000';
            c10 = (char)-1;
        }
        this.safeMin = c10;
        this.safeMax = c11;
    }

    public ArrayBasedCharEscaper(Map map, char c10, char c11) {
        map = ArrayBasedEscaperMap.create((Map)map);
        this((ArrayBasedEscaperMap)map, c10, c11);
    }

    public final String escape(String string2) {
        int n10;
        Preconditions.checkNotNull(string2);
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            char[] cArray;
            int n11;
            n10 = string2.charAt(i10);
            if ((n10 >= (n11 = this.replacementsLength) || (cArray = this.replacements[n10]) == null) && n10 <= (n11 = (int)this.safeMax) && n10 >= (n11 = (int)this.safeMin)) {
                continue;
            }
            string2 = this.escapeSlow(string2, i10);
            break;
        }
        return string2;
    }

    public final char[] escape(char c10) {
        char[] cArray;
        int n10 = this.replacementsLength;
        if (c10 < n10 && (cArray = this.replacements[c10]) != null) {
            return cArray;
        }
        n10 = this.safeMin;
        if (c10 >= n10 && c10 <= (n10 = (int)this.safeMax)) {
            return null;
        }
        return this.escapeUnsafe(c10);
    }

    public abstract char[] escapeUnsafe(char var1);
}

