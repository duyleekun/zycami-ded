/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

public final class BaseEncoding$Alphabet {
    public final int bitsPerChar;
    public final int bytesPerChunk;
    private final char[] chars;
    public final int charsPerChunk;
    private final byte[] decodabet;
    public final int mask;
    private final String name;
    private final boolean[] validPadding;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BaseEncoding$Alphabet(String object, char[] object2) {
        char c10;
        Object object3;
        int n12;
        this.name = object = (String)Preconditions.checkNotNull(object);
        object = (char[])Preconditions.checkNotNull(object2);
        this.chars = (char[])object;
        try {
            n12 = ((Object)object2).length;
            object3 = RoundingMode.UNNECESSARY;
            this.bitsPerChar = n12 = IntMath.log2(n12, object3);
        }
        catch (ArithmeticException arithmeticException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal alphabet length ");
            int n10 = ((Object)object2).length;
            stringBuilder.append(n10);
            object2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2, arithmeticException);
            throw illegalArgumentException;
        }
        int n13 = Integer.lowestOneBit(n12);
        int n11 = 8;
        int by3 = Math.min(n11, n13);
        try {
            this.charsPerChunk = n11 /= by3;
            this.bytesPerChunk = n12 /= by3;
        }
        catch (ArithmeticException arithmeticException) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Illegal alphabet ");
            String string2 = new String((char[])object2);
            stringBuilder2.append(string2);
            object2 = stringBuilder2.toString();
            super((String)object2, arithmeticException);
            throw object3;
        }
        n12 = ((Object)object2).length;
        byte by2 = 1;
        this.mask = n12 -= by2;
        n12 = 128;
        byte[] stringBuilder = new byte[n12];
        byte by4 = -1;
        Arrays.fill(stringBuilder, by4);
        int n14 = 0;
        for (int i10 = 0; i10 < (c10 = ((Object)object2).length); ++i10) {
            c10 = (char)object2[i10];
            byte by5 = c10 < n12 ? by2 : (byte)0;
            String string3 = "Non-ASCII character: %s";
            Preconditions.checkArgument(by5 != 0, string3, c10);
            by5 = stringBuilder[c10];
            by5 = by5 == by4 ? by2 : (byte)0;
            string3 = "Duplicate character: %s";
            Preconditions.checkArgument(by5 != 0, string3, c10);
            stringBuilder[c10] = by5 = (byte)i10;
        }
        this.decodabet = stringBuilder;
        n12 = this.charsPerChunk;
        object = new boolean[n12];
        while (true) {
            int n15;
            if (n14 >= (n15 = this.bytesPerChunk)) {
                this.validPadding = (boolean[])object;
                return;
            }
            n15 = n14 * 8;
            n11 = this.bitsPerChar;
            RoundingMode string2 = RoundingMode.CEILING;
            n15 = IntMath.divide(n15, n11, string2);
            object[n15] = by2;
            ++n14;
        }
    }

    public static /* synthetic */ char[] access$000(BaseEncoding$Alphabet baseEncoding$Alphabet) {
        return baseEncoding$Alphabet.chars;
    }

    private boolean hasLowerCase() {
        char[] cArray = this.chars;
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = Ascii.isLowerCase(cArray[i10]);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private boolean hasUpperCase() {
        char[] cArray = this.chars;
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = Ascii.isUpperCase(cArray[i10]);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean canDecode(char n10) {
        byte[] byArray;
        int n11 = 127;
        n10 = n10 <= n11 && (n10 = (byArray = this.decodabet)[n10]) != (n11 = -1) ? 1 : 0;
        return n10 != 0;
    }

    public int decode(char c10) {
        Object object = "Unrecognized character: 0x";
        char c11 = '\u007f';
        if (c10 <= c11) {
            Object object2 = this.decodabet;
            char c12 = object2[c10];
            char c13 = '\uffffffff';
            if (c12 == c13) {
                c12 = ' ';
                if (c10 > c12 && c10 != c11) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized character: ");
                    stringBuilder.append(c10);
                    String string2 = stringBuilder.toString();
                    object = new BaseEncoding$DecodingException(string2);
                    throw object;
                }
                object2 = new StringBuilder;
                object2();
                object2.append((String)object);
                String string3 = Integer.toHexString(c10);
                object2.append(string3);
                string3 = object2.toString();
                BaseEncoding$DecodingException baseEncoding$DecodingException = new BaseEncoding$DecodingException(string3);
                throw baseEncoding$DecodingException;
            }
            return c12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        String string4 = Integer.toHexString(c10);
        stringBuilder.append(string4);
        string4 = stringBuilder.toString();
        BaseEncoding$DecodingException baseEncoding$DecodingException = new BaseEncoding$DecodingException(string4);
        throw baseEncoding$DecodingException;
    }

    public char encode(int n10) {
        return this.chars[n10];
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof BaseEncoding$Alphabet;
        if (bl2) {
            object = (BaseEncoding$Alphabet)object;
            char[] cArray = this.chars;
            object = ((BaseEncoding$Alphabet)object).chars;
            return Arrays.equals(cArray, (char[])object);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.chars);
    }

    public boolean isValidPaddingStartPosition(int n10) {
        boolean[] blArray = this.validPadding;
        int n11 = this.charsPerChunk;
        return blArray[n10 %= n11];
    }

    public BaseEncoding$Alphabet lowerCase() {
        Object object;
        int n10;
        int n11 = this.hasUpperCase();
        if (n11 == 0) {
            return this;
        }
        Preconditions.checkState(this.hasLowerCase() ^ true, "Cannot call lowerCase() on a mixed-case alphabet");
        n11 = this.chars.length;
        char[] cArray = new char[n11];
        BaseEncoding$Alphabet baseEncoding$Alphabet = null;
        for (int i10 = 0; i10 < (n10 = ((char[])(object = this.chars)).length); ++i10) {
            char c10;
            cArray[i10] = c10 = Ascii.toLowerCase(object[i10]);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        String string2 = this.name;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(".lowerCase()");
        object = ((StringBuilder)object).toString();
        baseEncoding$Alphabet = new BaseEncoding$Alphabet((String)object, cArray);
        return baseEncoding$Alphabet;
    }

    public boolean matches(char c10) {
        char c11;
        byte[] byArray = this.decodabet;
        int n10 = byArray.length;
        c10 = c10 < n10 && (c10 = byArray[c10]) != (c11 = '\uffffffff') ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public String toString() {
        return this.name;
    }

    public BaseEncoding$Alphabet upperCase() {
        Object object;
        int n10;
        int n11 = this.hasLowerCase();
        if (n11 == 0) {
            return this;
        }
        Preconditions.checkState(this.hasUpperCase() ^ true, "Cannot call upperCase() on a mixed-case alphabet");
        n11 = this.chars.length;
        char[] cArray = new char[n11];
        BaseEncoding$Alphabet baseEncoding$Alphabet = null;
        for (int i10 = 0; i10 < (n10 = ((char[])(object = this.chars)).length); ++i10) {
            char c10;
            cArray[i10] = c10 = Ascii.toUpperCase(object[i10]);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        String string2 = this.name;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(".upperCase()");
        object = ((StringBuilder)object).toString();
        baseEncoding$Alphabet = new BaseEncoding$Alphabet((String)object, cArray);
        return baseEncoding$Alphabet;
    }
}

