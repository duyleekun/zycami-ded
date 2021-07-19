/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;

public final class BaseEncoding$Base64Encoding
extends BaseEncoding$StandardBaseEncoding {
    private BaseEncoding$Base64Encoding(BaseEncoding$Alphabet object, Character c10) {
        super((BaseEncoding$Alphabet)object, c10);
        object = BaseEncoding$Alphabet.access$000((BaseEncoding$Alphabet)object);
        boolean bl2 = ((Object)object).length;
        boolean bl3 = 64 != 0;
        if (bl2 == bl3) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkArgument(bl2);
    }

    public BaseEncoding$Base64Encoding(String string2, String object, Character c10) {
        object = ((String)object).toCharArray();
        BaseEncoding$Alphabet baseEncoding$Alphabet = new BaseEncoding$Alphabet(string2, (char[])object);
        this(baseEncoding$Alphabet, c10);
    }

    public int decodeTo(byte[] object, CharSequence charSequence) {
        Preconditions.checkNotNull(object);
        charSequence = this.trimTrailingPadding(charSequence);
        Object object2 = this.alphabet;
        int n10 = charSequence.length();
        boolean n11 = ((BaseEncoding$Alphabet)object2).isValidPaddingStartPosition(n10);
        if (n11) {
            int n12;
            int n13;
            boolean bl2 = false;
            object2 = null;
            n10 = 0;
            BaseEncoding$Alphabet baseEncoding$Alphabet = null;
            while (n13 < (n12 = charSequence.length())) {
                BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
                char c10 = n13 + true;
                int n13 = charSequence.charAt(n13);
                n13 = baseEncoding$Alphabet2.decode((char)n13) << 18;
                baseEncoding$Alphabet2 = this.alphabet;
                int n14 = c10 + true;
                c10 = charSequence.charAt(c10);
                n12 = baseEncoding$Alphabet2.decode(c10) << 12;
                n13 |= n12;
                n12 = n10 + 1;
                c10 = (char)(n13 >>> 16);
                object[n10] = c10;
                n10 = charSequence.length();
                if (n14 < n10) {
                    baseEncoding$Alphabet = this.alphabet;
                    c10 = n14 + true;
                    n14 = charSequence.charAt(n14);
                    n10 = baseEncoding$Alphabet.decode((char)n14) << 6;
                    n13 |= n10;
                    n10 = n12 + 1;
                    n14 = (byte)(n13 >>> 8 & 0xFF);
                    object[n12] = n14;
                    n12 = charSequence.length();
                    if (c10 < n12) {
                        baseEncoding$Alphabet2 = this.alphabet;
                        n14 = c10 + '\u0001';
                        c10 = charSequence.charAt(c10);
                        n12 = baseEncoding$Alphabet2.decode(c10);
                        n13 |= n12;
                        n12 = n10 + 1;
                        n13 = (byte)(n13 & 0xFF);
                        object[n10] = n13;
                    } else {
                        n13 = c10;
                        continue;
                    }
                }
                n10 = n12;
                n13 = n14;
            }
            return n10;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Invalid input length ");
        int n15 = charSequence.length();
        ((StringBuilder)object2).append(n15);
        charSequence = ((StringBuilder)object2).toString();
        object = new BaseEncoding$DecodingException((String)charSequence);
        throw object;
    }

    public void encodeTo(Appendable appendable, byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(appendable);
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        while (n11 >= (n13 = 3)) {
            n13 = n10 + 1;
            n10 = (byArray[n10] & 0xFF) << 16;
            char c10 = n13 + 1;
            n13 = (byArray[n13] & 0xFF) << 8;
            n10 |= n13;
            n13 = c10 + 1;
            c10 = byArray[c10] & 0xFF;
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
            int n14 = (n10 |= c10) >>> 18;
            c10 = baseEncoding$Alphabet.encode(n14);
            appendable.append(c10);
            baseEncoding$Alphabet = this.alphabet;
            n14 = n10 >>> 12 & 0x3F;
            c10 = baseEncoding$Alphabet.encode(n14);
            appendable.append(c10);
            baseEncoding$Alphabet = this.alphabet;
            n14 = n10 >>> 6 & 0x3F;
            c10 = baseEncoding$Alphabet.encode(n14);
            appendable.append(c10);
            baseEncoding$Alphabet = this.alphabet;
            n10 &= 0x3F;
            n10 = baseEncoding$Alphabet.encode(n10);
            appendable.append((char)n10);
            n11 += -3;
            n10 = n13;
        }
        if (n10 < n12) {
            this.encodeChunkTo(appendable, byArray, n10, n12 -= n10);
        }
    }

    public BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, Character c10) {
        BaseEncoding$Base64Encoding baseEncoding$Base64Encoding = new BaseEncoding$Base64Encoding(baseEncoding$Alphabet, c10);
        return baseEncoding$Base64Encoding;
    }
}

