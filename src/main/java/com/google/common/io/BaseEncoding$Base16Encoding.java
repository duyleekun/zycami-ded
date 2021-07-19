/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;

public final class BaseEncoding$Base16Encoding
extends BaseEncoding$StandardBaseEncoding {
    public final char[] encoding;

    private BaseEncoding$Base16Encoding(BaseEncoding$Alphabet baseEncoding$Alphabet) {
        super(baseEncoding$Alphabet, null);
        char[] cArray = new char[512];
        this.encoding = cArray;
        cArray = BaseEncoding$Alphabet.access$000(baseEncoding$Alphabet);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 16;
        if (n10 == n12) {
            n10 = 1;
        } else {
            n10 = 0;
            cArray = null;
        }
        Preconditions.checkArgument(n10 != 0);
        while (n11 < (n10 = 256)) {
            cArray = this.encoding;
            n12 = n11 >>> 4;
            cArray[n11] = n12 = (int)baseEncoding$Alphabet.encode(n12);
            cArray = this.encoding;
            n12 = n11 | 0x100;
            int n13 = n11 & 0xF;
            cArray[n12] = n13 = (int)baseEncoding$Alphabet.encode(n13);
            ++n11;
        }
    }

    public BaseEncoding$Base16Encoding(String string2, String object) {
        object = ((String)object).toCharArray();
        BaseEncoding$Alphabet baseEncoding$Alphabet = new BaseEncoding$Alphabet(string2, (char[])object);
        this(baseEncoding$Alphabet);
    }

    public int decodeTo(byte[] object, CharSequence charSequence) {
        Preconditions.checkNotNull(object);
        int n10 = charSequence.length() % 2;
        int n11 = 1;
        if (n10 != n11) {
            int n12;
            Object var5_5 = null;
            n11 = 0;
            for (n10 = 0; n10 < (n12 = charSequence.length()); n10 += 2) {
                BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet;
                int n13 = charSequence.charAt(n10);
                n12 = baseEncoding$Alphabet.decode((char)n13) << 4;
                BaseEncoding$Alphabet baseEncoding$Alphabet2 = this.alphabet;
                char c10 = n10 + 1;
                c10 = charSequence.charAt(c10);
                n13 = baseEncoding$Alphabet2.decode(c10);
                n12 |= n13;
                n13 = n11 + 1;
                object[n11] = n12 = (int)((byte)n12);
                n11 = n13;
            }
            return n11;
        }
        object = new BaseEncoding$DecodingException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid input length ");
        int n14 = charSequence.length();
        stringBuilder.append(n14);
        charSequence = stringBuilder.toString();
        object((String)charSequence);
        throw object;
    }

    public void encodeTo(Appendable appendable, byte[] byArray, int n10, int n11) {
        Preconditions.checkNotNull(appendable);
        int n12 = n10 + n11;
        int c10 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, c10);
        for (n12 = 0; n12 < n11; ++n12) {
            char c11 = n10 + n12;
            c11 = byArray[c11] & 0xFF;
            char c12 = this.encoding[c11];
            appendable.append(c12);
            char[] cArray = this.encoding;
            c11 |= 0x100;
            c11 = cArray[c11];
            appendable.append(c11);
        }
    }

    public BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, Character object) {
        object = new BaseEncoding$Base16Encoding(baseEncoding$Alphabet);
        return object;
    }
}

