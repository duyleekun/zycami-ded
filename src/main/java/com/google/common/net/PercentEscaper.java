/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

public final class PercentEscaper
extends UnicodeEscaper {
    private static final char[] PLUS_SIGN;
    private static final char[] UPPER_HEX_DIGITS;
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    static {
        char[] cArray = new char[]{'+'};
        PLUS_SIGN = cArray;
        UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }

    public PercentEscaper(String object, boolean bl2) {
        Preconditions.checkNotNull(object);
        CharSequence charSequence = ".*[0-9A-Za-z].*";
        boolean bl3 = ((String)object).matches((String)charSequence);
        if (!bl3) {
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            object = ((StringBuilder)charSequence).toString();
            if (bl2 && (bl3 = ((String)object).contains(charSequence = " "))) {
                object = new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
                throw object;
            }
            this.plusForSpace = bl2;
            object = PercentEscaper.createSafeOctets((String)object);
            this.safeOctets = (boolean[])object;
            return;
        }
        object = new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        throw object;
    }

    private static boolean[] createSafeOctets(String object) {
        Object object2;
        int n10;
        object = ((String)object).toCharArray();
        int n11 = ((Object)object).length;
        int n12 = 0;
        int n13 = -1;
        for (n10 = 0; n10 < n11; ++n10) {
            object2 = object[n10];
            n13 = Math.max((int)object2, n13);
        }
        n11 = 1;
        boolean[] blArray = new boolean[n13 += n11];
        n10 = ((Object)object).length;
        while (n12 < n10) {
            object2 = object[n12];
            blArray[object2] = n11;
            ++n12;
        }
        return blArray;
    }

    public String escape(String string2) {
        Preconditions.checkNotNull(string2);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean[] blArray;
            int n11;
            char c10 = string2.charAt(i10);
            if (c10 < (n11 = (blArray = this.safeOctets).length) && (c10 = blArray[c10]) != '\u0000') {
                continue;
            }
            string2 = this.escapeSlow(string2, i10);
            break;
        }
        return string2;
    }

    public char[] escape(int n10) {
        int n11;
        Object object = this.safeOctets;
        int n12 = ((boolean[])object).length;
        if (n10 < n12 && (n11 = object[n10]) != 0) {
            return null;
        }
        n11 = 32;
        if (n10 == n11 && (n11 = (int)(this.plusForSpace ? 1 : 0)) != 0) {
            return PLUS_SIGN;
        }
        n11 = 127;
        n12 = 1;
        int n13 = 0;
        char[] cArray = null;
        int n14 = 2;
        int n15 = 37;
        int n16 = 3;
        int n17 = 4;
        if (n10 <= n11) {
            object = new char[n16];
            object[0] = n15;
            cArray = UPPER_HEX_DIGITS;
            n15 = n10 & 0xF;
            object[n14] = n15 = cArray[n15];
            n10 >>>= n17;
            object[n12] = n10 = cArray[n10];
            return object;
        }
        n11 = 2047;
        int n18 = 12;
        int n19 = 5;
        int n20 = 6;
        int n21 = 8;
        if (n10 <= n11) {
            object = new char[n20];
            object[0] = n15;
            object[n16] = n15;
            cArray = UPPER_HEX_DIGITS;
            n15 = n10 & 0xF;
            object[n19] = n15 = cArray[n15];
            n15 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n15 = cArray[n15];
            n15 = (n10 >>>= n14) & 0xF;
            object[n14] = n15 = cArray[n15];
            n10 = n10 >>> n17 | n18;
            object[n12] = n10 = cArray[n10];
            return object;
        }
        n11 = (char)-1;
        int n22 = 9;
        int n23 = 7;
        if (n10 <= n11) {
            object = new char[n22];
            object[0] = n15;
            object[n12] = 69;
            object[n16] = n15;
            object[n20] = n15;
            char[] cArray2 = UPPER_HEX_DIGITS;
            n13 = n10 & 0xF;
            object[n21] = n13 = cArray2[n13];
            n13 = (n10 >>>= n17) & 3 | n21;
            object[n23] = n13 = cArray2[n13];
            n13 = (n10 >>>= n14) & 0xF;
            object[n19] = n13 = cArray2[n13];
            n13 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n13 = cArray2[n13];
            n10 >>>= n14;
            object[n14] = n10 = cArray2[n10];
            return object;
        }
        n11 = 0x10FFFF;
        if (n10 <= n11) {
            object = new char[n18];
            object[0] = n15;
            object[n12] = 70;
            object[n16] = n15;
            object[n20] = n15;
            object[n22] = n15;
            cArray = UPPER_HEX_DIGITS;
            n15 = n10 & 0xF;
            object[11] = n15 = cArray[n15];
            n15 = (n10 >>>= n17) & 3 | n21;
            object[10] = n15 = cArray[n15];
            n12 = (n10 >>>= n14) & 0xF;
            object[n21] = n12 = cArray[n12];
            n12 = (n10 >>>= n17) & 3 | n21;
            object[n23] = n12 = cArray[n12];
            n12 = (n10 >>>= n14) & 0xF;
            object[n19] = n12 = cArray[n12];
            n12 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n12 = cArray[n12];
            n10 = n10 >>> n14 & n23;
            object[n14] = n10 = cArray[n10];
            return object;
        }
        object = new IllegalArgumentException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid unicode character value ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object(string2);
        throw object;
    }

    public int nextEscapeIndex(CharSequence charSequence, int n10, int n11) {
        boolean[] blArray;
        int n12;
        char c10;
        Preconditions.checkNotNull(charSequence);
        while (n10 < n11 && (c10 = charSequence.charAt(n10)) < (n12 = (blArray = this.safeOctets).length) && (c10 = blArray[c10]) != '\u0000') {
            ++n10;
        }
        return n10;
    }
}

