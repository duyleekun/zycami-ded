/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.OutputStream;
import java.io.Writer;

public class BaseEncoding$StandardBaseEncoding$1
extends OutputStream {
    public int bitBuffer = 0;
    public int bitBufferLength = 0;
    public final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;
    public final /* synthetic */ Writer val$out;
    public int writtenChars = 0;

    public BaseEncoding$StandardBaseEncoding$1(BaseEncoding$StandardBaseEncoding standardBaseEncoding, Writer writer) {
        this.this$0 = standardBaseEncoding;
        this.val$out = writer;
    }

    public void close() {
        int n10 = this.bitBufferLength;
        if (n10 > 0) {
            int n11 = this.bitBuffer;
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.this$0.alphabet;
            int n12 = baseEncoding$Alphabet.bitsPerChar - n10;
            n10 = n11 << n12;
            n11 = baseEncoding$Alphabet.mask;
            n10 &= n11;
            Object object = this.val$out;
            n10 = baseEncoding$Alphabet.encode(n10);
            ((Writer)object).write(n10);
            this.writtenChars = n10 = this.writtenChars + 1;
            Object object2 = this.this$0.paddingChar;
            if (object2 != null) {
                while (true) {
                    n10 = this.writtenChars;
                    object = this.this$0;
                    baseEncoding$Alphabet = ((BaseEncoding$StandardBaseEncoding)object).alphabet;
                    int n13 = baseEncoding$Alphabet.charsPerChunk;
                    if ((n10 %= n13) == 0) break;
                    object2 = this.val$out;
                    object = ((BaseEncoding$StandardBaseEncoding)object).paddingChar;
                    n11 = ((Character)object).charValue();
                    ((Writer)object2).write(n11);
                    this.writtenChars = n10 = this.writtenChars + 1;
                }
            }
        }
        this.val$out.close();
    }

    public void flush() {
        this.val$out.flush();
    }

    public void write(int n10) {
        int n11;
        this.bitBuffer = n11 = this.bitBuffer << 8;
        this.bitBuffer = n10 = n10 & 0xFF | n11;
        this.bitBufferLength = n10 = this.bitBufferLength + 8;
        while (true) {
            n10 = this.bitBufferLength;
            BaseEncoding$Alphabet baseEncoding$Alphabet = this.this$0.alphabet;
            int n12 = baseEncoding$Alphabet.bitsPerChar;
            if (n10 < n12) break;
            int n13 = this.bitBuffer;
            n10 -= n12;
            n10 = n13 >> n10;
            n12 = baseEncoding$Alphabet.mask;
            n10 &= n12;
            Writer writer = this.val$out;
            n10 = baseEncoding$Alphabet.encode(n10);
            writer.write(n10);
            this.writtenChars = n10 = this.writtenChars + 1;
            n10 = this.bitBufferLength;
            baseEncoding$Alphabet = this.this$0.alphabet;
            n11 = baseEncoding$Alphabet.bitsPerChar;
            this.bitBufferLength = n10 -= n11;
        }
    }
}

