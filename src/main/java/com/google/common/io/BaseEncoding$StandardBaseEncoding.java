/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$SeparatedBaseEncoding;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$1;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$2;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

public class BaseEncoding$StandardBaseEncoding
extends BaseEncoding {
    public final BaseEncoding$Alphabet alphabet;
    private transient BaseEncoding lowerCase;
    public final Character paddingChar;
    private transient BaseEncoding upperCase;

    public BaseEncoding$StandardBaseEncoding(BaseEncoding$Alphabet baseEncoding$Alphabet, Character c10) {
        char c11;
        boolean bl2;
        BaseEncoding$Alphabet baseEncoding$Alphabet2;
        this.alphabet = baseEncoding$Alphabet2 = (BaseEncoding$Alphabet)Preconditions.checkNotNull(baseEncoding$Alphabet);
        if (c10 != null && (bl2 = baseEncoding$Alphabet.matches(c11 = c10.charValue()))) {
            bl2 = false;
            baseEncoding$Alphabet = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "Padding character %s was already in alphabet", (Object)c10);
        this.paddingChar = c10;
    }

    public BaseEncoding$StandardBaseEncoding(String string2, String object, Character c10) {
        object = ((String)object).toCharArray();
        BaseEncoding$Alphabet baseEncoding$Alphabet = new BaseEncoding$Alphabet(string2, (char[])object);
        this(baseEncoding$Alphabet, c10);
    }

    public boolean canDecode(CharSequence charSequence) {
        int n10;
        Preconditions.checkNotNull(charSequence);
        charSequence = this.trimTrailingPadding(charSequence);
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        int n11 = charSequence.length();
        int n12 = baseEncoding$Alphabet.isValidPaddingStartPosition(n11);
        n11 = 0;
        if (n12 == 0) {
            return false;
        }
        baseEncoding$Alphabet = null;
        for (n12 = 0; n12 < (n10 = charSequence.length()); ++n12) {
            BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
            char c10 = charSequence.charAt(n12);
            n10 = (int)(baseEncoding$Alphabet2.canDecode(c10) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public int decodeTo(byte[] object, CharSequence charSequence) {
        Preconditions.checkNotNull(object);
        charSequence = this.trimTrailingPadding(charSequence);
        Object object2 = this.alphabet;
        int n10 = charSequence.length();
        boolean bl2 = ((BaseEncoding$Alphabet)object2).isValidPaddingStartPosition(n10);
        if (bl2) {
            int n11;
            bl2 = false;
            object2 = null;
            int n12 = 0;
            for (n10 = 0; n10 < (n11 = charSequence.length()); n10 += n11) {
                int n13;
                int n14;
                BaseEncoding$Alphabet baseEncoding$Alphabet;
                long l10 = 0L;
                int n15 = 0;
                int n16 = 0;
                while (true) {
                    baseEncoding$Alphabet = this.alphabet;
                    n14 = baseEncoding$Alphabet.charsPerChunk;
                    if (n15 >= n14) break;
                    n13 = baseEncoding$Alphabet.bitsPerChar;
                    l10 <<= n13;
                    n13 = n10 + n15;
                    n14 = charSequence.length();
                    if (n13 < n14) {
                        baseEncoding$Alphabet = this.alphabet;
                        n14 = n16 + 1;
                        n16 += n10;
                        n16 = charSequence.charAt(n16);
                        long l11 = baseEncoding$Alphabet.decode((char)n16);
                        l10 |= l11;
                        n16 = n14;
                    }
                    ++n15;
                }
                n15 = baseEncoding$Alphabet.bytesPerChunk;
                n14 = n15 * 8;
                n13 = baseEncoding$Alphabet.bitsPerChar;
                n14 -= (n16 *= n13);
                for (n15 = (n15 + -1) * 8; n15 >= n14; n15 += -8) {
                    n16 = n12 + 1;
                    long l12 = l10 >>> n15;
                    long l13 = 255L;
                    object[n12] = n13 = (int)((byte)(l12 &= l13));
                    n12 = n16;
                }
                BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
                n11 = baseEncoding$Alphabet2.charsPerChunk;
            }
            return n12;
        }
        object = new BaseEncoding$DecodingException;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Invalid input length ");
        int n17 = charSequence.length();
        ((StringBuilder)object2).append(n17);
        charSequence = ((StringBuilder)object2).toString();
        object((String)charSequence);
        throw object;
    }

    public InputStream decodingStream(Reader reader) {
        Preconditions.checkNotNull(reader);
        BaseEncoding$StandardBaseEncoding$2 baseEncoding$StandardBaseEncoding$2 = new BaseEncoding$StandardBaseEncoding$2(this, reader);
        return baseEncoding$StandardBaseEncoding$2;
    }

    public void encodeChunkTo(Appendable appendable, byte[] object, int n10, int n11) {
        long l10;
        int n12;
        int n13;
        Preconditions.checkNotNull(appendable);
        int n14 = n10 + n11;
        int n15 = ((byte[])object).length;
        Preconditions.checkPositionIndexes(n10, n14, n15);
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        n14 = baseEncoding$Alphabet.bytesPerChunk;
        n15 = 0;
        if (n11 <= n14) {
            n14 = 1;
        } else {
            n14 = 0;
            baseEncoding$Alphabet = null;
        }
        Preconditions.checkArgument(n14 != 0);
        long l11 = 0L;
        n14 = 0;
        baseEncoding$Alphabet = null;
        while (true) {
            n13 = 8;
            if (n14 >= n11) break;
            n12 = n10 + n14;
            n12 = object[n12] & 0xFF;
            l10 = n12;
            l11 = (l11 | l10) << n13;
            ++n14;
        }
        int n16 = (n11 + 1) * n13;
        BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
        n10 = baseEncoding$Alphabet2.bitsPerChar;
        n16 -= n10;
        while (n15 < (n10 = n11 * 8)) {
            n10 = n16 - n15;
            l10 = l11 >>> n10;
            n10 = (int)l10;
            baseEncoding$Alphabet = this.alphabet;
            n12 = baseEncoding$Alphabet.mask;
            n10 &= n12;
            n10 = baseEncoding$Alphabet.encode(n10);
            appendable.append((char)n10);
            baseEncoding$Alphabet2 = this.alphabet;
            n10 = baseEncoding$Alphabet2.bitsPerChar;
            n15 += n10;
        }
        object = this.paddingChar;
        if (object != null) {
            while (true) {
                object = this.alphabet;
                n16 = object.bytesPerChunk * n13;
                if (n15 >= n16) break;
                n16 = this.paddingChar.charValue();
                appendable.append((char)n16);
                object = this.alphabet;
                n16 = object.bitsPerChar;
                n15 += n16;
            }
        }
    }

    public void encodeTo(Appendable appendable, byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(appendable);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        for (n12 = 0; n12 < n11; n12 += n13) {
            n13 = n10 + n12;
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
            int n14 = baseEncoding$Alphabet.bytesPerChunk;
            int n15 = n11 - n12;
            n14 = Math.min(n14, n15);
            this.encodeChunkTo(appendable, byArray, n13, n14);
            BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
            n13 = baseEncoding$Alphabet2.bytesPerChunk;
        }
    }

    public OutputStream encodingStream(Writer writer) {
        Preconditions.checkNotNull(writer);
        BaseEncoding$StandardBaseEncoding$1 baseEncoding$StandardBaseEncoding$1 = new BaseEncoding$StandardBaseEncoding$1(this, writer);
        return baseEncoding$StandardBaseEncoding$1;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof BaseEncoding$StandardBaseEncoding;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (BaseEncoding$StandardBaseEncoding)object;
            Object object2 = this.alphabet;
            BaseEncoding$Alphabet baseEncoding$Alphabet = ((BaseEncoding$StandardBaseEncoding)object).alphabet;
            bl2 = ((BaseEncoding$Alphabet)object2).equals(baseEncoding$Alphabet);
            if (bl2 && (bl4 = Objects.equal(object2 = this.paddingChar, object = ((BaseEncoding$StandardBaseEncoding)object).paddingChar))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.alphabet.hashCode();
        Object[] objectArray = new Object[1];
        Character c10 = this.paddingChar;
        objectArray[0] = c10;
        int n11 = Objects.hashCode(objectArray);
        return n10 ^ n11;
    }

    public BaseEncoding lowerCase() {
        Object object = this.lowerCase;
        if (object == null) {
            Object object2;
            object = this.alphabet.lowerCase();
            if (object == (object2 = this.alphabet)) {
                object = this;
            } else {
                object2 = this.paddingChar;
                object = this.newInstance((BaseEncoding$Alphabet)object, (Character)object2);
            }
            this.lowerCase = object;
        }
        return object;
    }

    public int maxDecodedSize(int n10) {
        long l10 = this.alphabet.bitsPerChar;
        long l11 = n10;
        return (int)((l10 * l11 + (long)7) / (long)8);
    }

    public int maxEncodedSize(int n10) {
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
        int n11 = baseEncoding$Alphabet.charsPerChunk;
        int n12 = baseEncoding$Alphabet.bytesPerChunk;
        RoundingMode roundingMode = RoundingMode.CEILING;
        n10 = IntMath.divide(n10, n12, roundingMode);
        return n11 * n10;
    }

    public BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, Character c10) {
        BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding = new BaseEncoding$StandardBaseEncoding(baseEncoding$Alphabet, c10);
        return baseEncoding$StandardBaseEncoding;
    }

    public BaseEncoding omitPadding() {
        Object object = this.paddingChar;
        if (object == null) {
            object = this;
        } else {
            object = this.alphabet;
            object = this.newInstance((BaseEncoding$Alphabet)object, null);
        }
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
        Object object = this.alphabet.toString();
        stringBuilder.append((String)object);
        object = this.alphabet;
        int n10 = ((BaseEncoding$Alphabet)object).bitsPerChar;
        int n11 = 8 % n10;
        if (n11 != 0) {
            object = this.paddingChar;
            if (object == null) {
                object = ".omitPadding()";
                stringBuilder.append((String)object);
            } else {
                stringBuilder.append(".withPadChar('");
                object = this.paddingChar;
                stringBuilder.append(object);
                object = "')";
                stringBuilder.append((String)object);
            }
        }
        return stringBuilder.toString();
    }

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        char c10;
        int n10;
        Preconditions.checkNotNull(charSequence);
        Character c11 = this.paddingChar;
        if (c11 == null) {
            return charSequence;
        }
        char c12 = c11.charValue();
        for (n10 = charSequence.length() + -1; n10 >= 0 && (c10 = charSequence.charAt(n10)) == c12; n10 += -1) {
        }
        return charSequence.subSequence(0, ++n10);
    }

    public BaseEncoding upperCase() {
        Object object = this.upperCase;
        if (object == null) {
            Object object2;
            object = this.alphabet.upperCase();
            if (object == (object2 = this.alphabet)) {
                object = this;
            } else {
                object2 = this.paddingChar;
                object = this.newInstance((BaseEncoding$Alphabet)object, (Character)object2);
            }
            this.upperCase = object;
        }
        return object;
    }

    public BaseEncoding withPadChar(char c10) {
        Object object = this.alphabet;
        int n10 = ((BaseEncoding$Alphabet)object).bitsPerChar;
        int n11 = 8 % n10;
        if (n11 != 0 && ((object = this.paddingChar) == null || (n10 = (int)((Character)object).charValue()) != c10)) {
            object = this.alphabet;
            Character c11 = Character.valueOf(c10);
            return this.newInstance((BaseEncoding$Alphabet)object, c11);
        }
        return this;
    }

    public BaseEncoding withSeparator(String string2, int n10) {
        int n11;
        int n12 = 0;
        BaseEncoding$SeparatedBaseEncoding baseEncoding$SeparatedBaseEncoding = null;
        int n13 = 0;
        Object object = null;
        while (true) {
            int n14 = string2.length();
            n11 = 1;
            if (n13 >= n14) break;
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
            char c10 = string2.charAt(n13);
            n14 = baseEncoding$Alphabet.matches(c10) ^ n11;
            String string3 = "Separator (%s) cannot contain alphabet characters";
            Preconditions.checkArgument(n14 != 0, string3, (Object)string2);
            ++n13;
        }
        object = this.paddingChar;
        if (object != null) {
            n13 = ((Character)object).charValue();
            if ((n13 = string2.indexOf(n13)) < 0) {
                n12 = n11;
            }
            object = "Separator (%s) cannot contain padding character";
            Preconditions.checkArgument(n12 != 0, (String)object, (Object)string2);
        }
        baseEncoding$SeparatedBaseEncoding = new BaseEncoding$SeparatedBaseEncoding(this, string2, n10);
        return baseEncoding$SeparatedBaseEncoding;
    }
}

