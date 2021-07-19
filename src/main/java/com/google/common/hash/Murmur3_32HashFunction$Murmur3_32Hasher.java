/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_32HashFunction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class Murmur3_32HashFunction$Murmur3_32Hasher
extends AbstractHasher {
    private long buffer;
    private int h1;
    private boolean isDone;
    private int length;
    private int shift;

    public Murmur3_32HashFunction$Murmur3_32Hasher(int n10) {
        this.h1 = n10;
        this.length = 0;
        this.isDone = false;
    }

    private void update(int n10, long l10) {
        long l11 = this.buffer;
        long l12 = 0xFFFFFFFFL;
        l10 &= l12;
        int n11 = this.shift;
        this.buffer = l10 = l10 << n11 | l11;
        int n12 = n10 * 8;
        this.shift = n11 += n12;
        this.length = n12 = this.length + n10;
        n10 = 32;
        if (n11 >= n10) {
            n12 = this.h1;
            int n13 = Murmur3_32HashFunction.access$000((int)l10);
            this.h1 = n13 = Murmur3_32HashFunction.access$100(n12, n13);
            this.buffer = l10 = this.buffer >>> n10;
            this.shift = n13 = this.shift - n10;
        }
    }

    public HashCode hash() {
        int n10 = this.isDone;
        int n11 = 1;
        Preconditions.checkState(n10 ^ n11);
        this.isDone = n11;
        n10 = this.h1;
        n11 = Murmur3_32HashFunction.access$000((int)this.buffer);
        this.h1 = n10 ^= n11;
        n11 = this.length;
        return Murmur3_32HashFunction.access$600(n10, n11);
    }

    public Hasher putByte(byte by2) {
        long l10 = by2 & 0xFF;
        this.update(1, l10);
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        byte by2;
        byte by3;
        ByteOrder byteOrder = byteBuffer.order();
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder2);
        while ((by3 = byteBuffer.remaining()) >= (by2 = 4)) {
            by3 = byteBuffer.getInt();
            this.putInt(by3);
        }
        while ((by3 = (byte)(byteBuffer.hasRemaining() ? 1 : 0)) != 0) {
            by3 = byteBuffer.get();
            this.putByte(by3);
        }
        byteBuffer.order(byteOrder);
        return this;
    }

    public Hasher putBytes(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        n12 = 0;
        while ((n13 = n12 + 4) <= n11) {
            long l10 = Murmur3_32HashFunction.access$200(byArray, n12 += n10);
            this.update(4, l10);
            n12 = n13;
        }
        while (n12 < n11) {
            n13 = n10 + n12;
            n13 = byArray[n13];
            this.putByte((byte)n13);
            ++n12;
        }
        return this;
    }

    public Hasher putChar(char c10) {
        long l10 = c10;
        this.update(2, l10);
        return this;
    }

    public Hasher putInt(int n10) {
        long l10 = n10;
        this.update(4, l10);
        return this;
    }

    public Hasher putLong(long l10) {
        long l11 = (int)l10;
        int n10 = 4;
        this.update(n10, l11);
        this.update(n10, l10 >>>= 32);
        return this;
    }

    public Hasher putString(CharSequence object, Charset charset) {
        Charset charset2 = Charsets.UTF_8;
        int n10 = charset2.equals(charset);
        if (n10 != 0) {
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            n10 = object.length();
            int n16 = 0;
            while (true) {
                n15 = n16 + 4;
                n14 = 4;
                n13 = 128;
                if (n15 > n10) break;
                n12 = object.charAt(n16);
                n11 = n16 + 1;
                n11 = object.charAt(n11);
                int n17 = n16 + 2;
                n17 = object.charAt(n17);
                int n18 = n16 + 3;
                n18 = object.charAt(n18);
                if (n12 >= n13 || n11 >= n13 || n17 >= n13 || n18 >= n13) break;
                n16 = n11 << 8 | n12;
                n13 = n17 << 16;
                n16 |= n13;
                n13 = n18 << 24;
                long l10 = n16 | n13;
                this.update(n14, l10);
                n16 = n15;
            }
            while (n16 < n10) {
                long l11;
                n15 = object.charAt(n16);
                n12 = 1;
                if (n15 < n13) {
                    l11 = n15;
                    this.update(n12, l11);
                } else {
                    n11 = 2048;
                    if (n15 < n11) {
                        l11 = Murmur3_32HashFunction.access$300((char)n15);
                        n15 = 2;
                        this.update(n15, l11);
                    } else {
                        n11 = 55296;
                        if (n15 >= n11 && n15 <= (n11 = 57343)) {
                            n11 = Character.codePointAt((CharSequence)object, n16);
                            if (n11 == n15) {
                                object = object.subSequence(n16, n10).toString().getBytes(charset);
                                this.putBytes((byte[])object);
                                return this;
                            }
                            ++n16;
                            l11 = Murmur3_32HashFunction.access$500(n11);
                            this.update(n14, l11);
                        } else {
                            l11 = Murmur3_32HashFunction.access$400((char)n15);
                            n15 = 3;
                            this.update(n15, l11);
                        }
                    }
                }
                n16 += n12;
            }
            return this;
        }
        return super.putString((CharSequence)object, charset);
    }
}

