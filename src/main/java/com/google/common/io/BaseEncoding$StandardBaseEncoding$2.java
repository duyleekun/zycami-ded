/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.InputStream;
import java.io.Reader;

public class BaseEncoding$StandardBaseEncoding$2
extends InputStream {
    public int bitBuffer = 0;
    public int bitBufferLength = 0;
    public boolean hitPadding = false;
    public int readChars = 0;
    public final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;
    public final /* synthetic */ Reader val$reader;

    public BaseEncoding$StandardBaseEncoding$2(BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding, Reader reader) {
        this.this$0 = baseEncoding$StandardBaseEncoding;
        this.val$reader = reader;
    }

    public void close() {
        this.val$reader.close();
    }

    public int read() {
        Object object;
        Object object2;
        Object object3;
        int n10;
        block6: {
            int n11;
            int n12;
            while (true) {
                block7: {
                    block8: {
                        block9: {
                            if ((n10 = ((Reader)(object3 = this.val$reader)).read()) == (n12 = -1)) {
                                n10 = (int)(this.hitPadding ? 1 : 0);
                                if (n10 == 0 && (n10 = (int)(((BaseEncoding$Alphabet)(object3 = this.this$0.alphabet)).isValidPaddingStartPosition(n11 = this.readChars) ? 1 : 0)) == 0) {
                                    object2 = new StringBuilder();
                                    ((StringBuilder)object2).append("Invalid input length ");
                                    n11 = this.readChars;
                                    ((StringBuilder)object2).append(n11);
                                    object2 = ((StringBuilder)object2).toString();
                                    object3 = new BaseEncoding$DecodingException((String)object2);
                                    throw object3;
                                }
                                return n12;
                            }
                            n12 = this.readChars;
                            n11 = 1;
                            this.readChars = n12 += n11;
                            n10 = (char)n10;
                            object2 = this.this$0.paddingChar;
                            if (object2 == null || (n12 = (int)((Character)object2).charValue()) != n10) break block7;
                            n10 = (int)(this.hitPadding ? 1 : 0);
                            if (n10 != 0) break block8;
                            n10 = this.readChars;
                            if (n10 == n11) break block9;
                            object2 = this.this$0.alphabet;
                            n10 += -1;
                            if ((n10 = (int)(((BaseEncoding$Alphabet)object2).isValidPaddingStartPosition(n10) ? 1 : 0)) != 0) break block8;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Padding cannot start at index ");
                        n11 = this.readChars;
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        object3 = new BaseEncoding$DecodingException((String)object2);
                        throw object3;
                    }
                    this.hitPadding = n11;
                    continue;
                }
                n12 = (int)(this.hitPadding ? 1 : 0);
                if (n12 != 0) break block6;
                n12 = this.bitBuffer;
                object = this.this$0.alphabet;
                int n13 = ((BaseEncoding$Alphabet)object).bitsPerChar;
                this.bitBuffer = n12 <<= n13;
                this.bitBuffer = n10 = ((BaseEncoding$Alphabet)object).decode((char)n10) | n12;
                n12 = this.bitBufferLength;
                object = this.this$0.alphabet;
                n11 = ((BaseEncoding$Alphabet)object).bitsPerChar;
                this.bitBufferLength = n12 += n11;
                n11 = 8;
                if (n12 >= n11) break;
            }
            this.bitBufferLength = n12 -= n11;
            return n10 >> n12 & 0xFF;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expected padding character but found '");
        ((StringBuilder)object).append((char)n10);
        ((StringBuilder)object).append("' at index ");
        n10 = this.readChars;
        ((StringBuilder)object).append(n10);
        object3 = ((StringBuilder)object).toString();
        object2 = new BaseEncoding$DecodingException((String)object3);
        throw object2;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n11 += n10, n12);
        for (n12 = n10; n12 < n11; ++n12) {
            int n13;
            int n14 = this.read();
            if (n14 == (n13 = -1)) {
                if ((n12 -= n10) != 0) {
                    n13 = n12;
                }
                return n13;
            }
            byArray[n12] = n14 = (int)((byte)n14);
        }
        return n12 - n10;
    }
}

