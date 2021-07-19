/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Murmur3_128HashFunction$Murmur3_128Hasher
extends AbstractStreamingHasher {
    private static final long C1 = -8663945395140668459L;
    private static final long C2 = 5545529020109919103L;
    private static final int CHUNK_SIZE = 16;
    private long h1;
    private long h2;
    private int length;

    public Murmur3_128HashFunction$Murmur3_128Hasher(int n10) {
        super(16);
        long l10;
        this.h1 = l10 = (long)n10;
        this.h2 = l10;
        this.length = 0;
    }

    private void bmix64(long l10, long l11) {
        long l12 = this.h1;
        this.h1 = l10 = Murmur3_128HashFunction$Murmur3_128Hasher.mixK1(l10) ^ l12;
        this.h1 = l10 = Long.rotateLeft(l10, 27);
        l12 = this.h2;
        this.h1 = l10 += l12;
        long l13 = 5;
        this.h1 = l10 = l10 * l13 + 1390208809L;
        this.h2 = l10 = Murmur3_128HashFunction$Murmur3_128Hasher.mixK2(l11) ^ l12;
        this.h2 = l10 = Long.rotateLeft(l10, 31);
        l11 = this.h1;
        this.h2 = l10 += l11;
        this.h2 = l10 = l10 * l13 + 944331445L;
    }

    private static long fmix64(long l10) {
        int n10 = 33;
        long l11 = l10 >>> n10;
        l10 = (l10 ^ l11) * -49064778989728563L;
        l11 = l10 >>> n10;
        l10 = (l10 ^ l11) * -4265267296055464877L;
        long l12 = l10 >>> n10;
        return l10 ^ l12;
    }

    private static long mixK1(long l10) {
        return Long.rotateLeft(l10 * -8663945395140668459L, 31) * 5545529020109919103L;
    }

    private static long mixK2(long l10) {
        return Long.rotateLeft(l10 * 5545529020109919103L, 33) * -8663945395140668459L;
    }

    public HashCode makeHash() {
        long l10;
        long l11 = this.h1;
        int n10 = this.length;
        long l12 = n10;
        this.h1 = l11 ^= l12;
        l12 = this.h2;
        long l13 = n10;
        this.h2 = l10 = l12 ^ l13;
        this.h1 = l11 += l10;
        this.h2 = l10 += l11;
        this.h1 = l11 = Murmur3_128HashFunction$Murmur3_128Hasher.fmix64(l11);
        this.h2 = l11 = Murmur3_128HashFunction$Murmur3_128Hasher.fmix64(this.h2);
        this.h1 = l10 = this.h1 + l11;
        this.h2 = l11 += l10;
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer = byteBuffer.order(byteOrder);
        long l14 = this.h1;
        byteBuffer = byteBuffer.putLong(l14);
        l14 = this.h2;
        return HashCode.fromBytesNoCopy(byteBuffer.putLong(l14).array());
    }

    public void process(ByteBuffer byteBuffer) {
        int n10;
        long l10 = byteBuffer.getLong();
        long l11 = byteBuffer.getLong();
        this.bmix64(l10, l11);
        this.length = n10 = this.length + 16;
    }

    /*
     * Unable to fully structure code
     */
    public void processRemaining(ByteBuffer var1_1) {
        block17: {
            block18: {
                var2_2 = this.length;
                var3_3 = var1_1.remaining();
                this.length = var2_2 += var3_3;
                var2_2 = var1_1.remaining();
                var3_3 = 48;
                var4_4 = 40;
                var5_5 = 32;
                var6_6 = 24;
                var7_7 = 16;
                var8_8 = 0L;
                var10_9 = 8;
                switch (var2_2) {
                    default: {
                        var1_1 = new AssertionError((Object)"Should never get here.");
                        throw var1_1;
                    }
                    case 15: {
                        var2_2 = UnsignedBytes.toInt(var1_1.get(14));
                        var11_10 = var2_2;
                        var13_12 = var11_10 << var3_3 ^ var8_8;
                        ** GOTO lbl23
                    }
                    case 14: {
                        var13_12 = var8_8;
lbl23:
                        // 2 sources

                        var15_13 = UnsignedBytes.toInt(var1_1.get(13));
                        var11_10 = (long)var15_13 << var4_4;
                        var13_12 ^= var11_10;
                        ** GOTO lbl29
                    }
                    case 13: {
                        var13_12 = var8_8;
lbl29:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(12));
                        var11_10 = var4_4;
                        var16_15 = var11_10 << var5_5;
                        var13_12 ^= var16_15;
                        ** GOTO lbl36
                    }
                    case 12: {
                        var13_12 = var8_8;
lbl36:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(11));
                        var16_15 = (long)var4_4 << var6_6;
                        var13_12 ^= var16_15;
                        ** GOTO lbl42
                    }
                    case 11: {
                        var13_12 = var8_8;
lbl42:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(10));
                        var16_15 = (long)var4_4 << var7_7;
                        var13_12 ^= var16_15;
                        ** GOTO lbl48
                    }
                    case 10: {
                        var13_12 = var8_8;
lbl48:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(9));
                        var16_15 = (long)var4_4 << var10_9;
                        var13_12 ^= var16_15;
                        ** GOTO lbl54
                    }
                    case 9: {
                        var13_12 = var8_8;
lbl54:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(var10_9));
                        var16_15 = var4_4;
                        var13_12 ^= var16_15;
                        ** GOTO lbl60
                    }
                    case 8: {
                        var13_12 = var8_8;
lbl60:
                        // 2 sources

                        var16_15 = var1_1.getLong() ^ var8_8;
                        var8_8 = var13_12;
                        break block17;
                    }
                    case 7: {
                        var2_2 = UnsignedBytes.toInt(var1_1.get(6));
                        var11_11 = var2_2;
                        var13_12 = var11_11 << var3_3 ^ var8_8;
                        ** GOTO lbl70
                    }
                    case 6: {
                        var13_12 = var8_8;
lbl70:
                        // 2 sources

                        var15_14 = UnsignedBytes.toInt(var1_1.get(5));
                        var11_11 = (long)var15_14 << var4_4;
                        var13_12 ^= var11_11;
                        ** GOTO lbl76
                    }
                    case 5: {
                        var13_12 = var8_8;
lbl76:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(4));
                        var11_11 = var4_4;
                        var16_15 = var11_11 << var5_5;
                        var13_12 ^= var16_15;
                        ** GOTO lbl83
                    }
                    case 4: {
                        var13_12 = var8_8;
lbl83:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(3));
                        var16_15 = (long)var4_4 << var6_6;
                        var13_12 ^= var16_15;
                        ** GOTO lbl89
                    }
                    case 3: {
                        var13_12 = var8_8;
lbl89:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(2));
                        var16_15 = (long)var4_4 << var7_7;
                        var13_12 ^= var16_15;
                        ** GOTO lbl95
                    }
                    case 2: {
                        var13_12 = var8_8;
lbl95:
                        // 2 sources

                        var4_4 = UnsignedBytes.toInt(var1_1.get(1));
                        var16_15 = (long)var4_4 << var10_9;
                        var13_12 ^= var16_15;
                        break block18;
                    }
                    case 1: 
                }
                var13_12 = var8_8;
            }
            var4_4 = 0;
            var18_16 = UnsignedBytes.toInt(var1_1.get(0));
            var16_15 = (long)var18_16 ^ var13_12;
        }
        var13_12 = this.h1;
        var16_15 = Murmur3_128HashFunction$Murmur3_128Hasher.mixK1(var16_15);
        this.h1 = var13_12 ^= var16_15;
        var13_12 = this.h2;
        var16_15 = Murmur3_128HashFunction$Murmur3_128Hasher.mixK2(var8_8);
        this.h2 = var13_12 ^= var16_15;
    }
}

