/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.Escaper;
import com.google.common.escape.Platform;

public abstract class UnicodeEscaper
extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence object, int n10, int n11) {
        Preconditions.checkNotNull(object);
        if (n10 < n11) {
            int n12;
            int n13 = n10 + 1;
            if ((n10 = (int)object.charAt(n10)) >= (n12 = 55296) && n10 <= (n12 = 57343)) {
                n12 = 56319;
                String string2 = "'";
                String string3 = " in '";
                String string4 = " at index ";
                String string5 = "' with value ";
                if (n10 <= n12) {
                    if (n13 == n11) {
                        return -n10;
                    }
                    n11 = object.charAt(n13);
                    n12 = (int)(Character.isLowSurrogate((char)n11) ? 1 : 0);
                    if (n12 != 0) {
                        return Character.toCodePoint((char)n10, (char)n11);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected low surrogate but got char '");
                    stringBuilder.append((char)n11);
                    stringBuilder.append(string5);
                    stringBuilder.append(n11);
                    stringBuilder.append(string4);
                    stringBuilder.append(n13);
                    stringBuilder.append(string3);
                    stringBuilder.append(object);
                    stringBuilder.append(string2);
                    object = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected low surrogate character '");
                stringBuilder.append((char)n10);
                stringBuilder.append(string5);
                stringBuilder.append(n10);
                stringBuilder.append(string4);
                stringBuilder.append(n13 += -1);
                stringBuilder.append(string3);
                stringBuilder.append(object);
                stringBuilder.append(string2);
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            return n10;
        }
        object = new IndexOutOfBoundsException("Index exceeds specified range");
        throw object;
    }

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
        int n11 = this.nextEscapeIndex(string2, 0, n10);
        if (n11 != n10) {
            string2 = this.escapeSlow(string2, n11);
        }
        return string2;
    }

    public abstract char[] escape(int var1);

    public final String escapeSlow(String object, int n10) {
        int n11;
        int n12 = ((String)object).length();
        char[] cArray = Platform.charBufferFromThreadLocal();
        int n13 = 0;
        int n14 = 0;
        while (n10 < n12) {
            n11 = UnicodeEscaper.codePointAt((CharSequence)object, n10, n12);
            if (n11 >= 0) {
                char[] cArray2 = this.escape(n11);
                n11 = (n11 = (int)(Character.isSupplementaryCodePoint(n11) ? 1 : 0)) != 0 ? 2 : 1;
                n11 += n10;
                if (cArray2 != null) {
                    int n15 = cArray.length;
                    int n16 = n10 - n13;
                    int n17 = n14 + n16;
                    int n18 = cArray2.length + n17;
                    if (n15 < n18) {
                        n15 = n12 - n10;
                        n18 = n18 + n15 + 32;
                        cArray = UnicodeEscaper.growBuffer(cArray, n14, n18);
                    }
                    if (n16 > 0) {
                        ((String)object).getChars(n13, n10, cArray, n14);
                        n14 = n17;
                    }
                    if ((n10 = cArray2.length) > 0) {
                        n10 = cArray2.length;
                        System.arraycopy(cArray2, 0, cArray, n14, n10);
                        n10 = cArray2.length;
                        n14 += n10;
                    }
                    n13 = n11;
                }
                n10 = this.nextEscapeIndex((CharSequence)object, n11, n12);
                continue;
            }
            object = new IllegalArgumentException("Trailing high surrogate at end of input");
            throw object;
        }
        n10 = n12 - n13;
        if (n10 > 0) {
            n11 = cArray.length;
            if (n11 < (n10 += n14)) {
                cArray = UnicodeEscaper.growBuffer(cArray, n14, n10);
            }
            ((String)object).getChars(n13, n12, cArray, n14);
            n14 = n10;
        }
        object = new String(cArray, 0, n14);
        return object;
    }

    public int nextEscapeIndex(CharSequence charSequence, int n10, int n11) {
        char[] cArray;
        int n12;
        while (n10 < n11 && (n12 = UnicodeEscaper.codePointAt(charSequence, n10, n11)) >= 0 && (cArray = this.escape(n12)) == null) {
            n12 = (n12 = (int)(Character.isSupplementaryCodePoint(n12) ? 1 : 0)) != 0 ? 2 : 1;
            n10 += n12;
        }
        return n10;
    }
}

