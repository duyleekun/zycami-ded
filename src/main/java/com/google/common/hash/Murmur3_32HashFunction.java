/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.Murmur3_32HashFunction$Murmur3_32Hasher;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.charset.Charset;

public final class Murmur3_32HashFunction
extends AbstractHashFunction
implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    public static final HashFunction GOOD_FAST_HASH_32;
    public static final HashFunction MURMUR3_32;
    private static final long serialVersionUID;
    private final int seed;

    static {
        Murmur3_32HashFunction murmur3_32HashFunction = new Murmur3_32HashFunction(0);
        MURMUR3_32 = murmur3_32HashFunction;
        int n10 = Hashing.GOOD_FAST_HASH_SEED;
        murmur3_32HashFunction = new Murmur3_32HashFunction(n10);
        GOOD_FAST_HASH_32 = murmur3_32HashFunction;
    }

    public Murmur3_32HashFunction(int n10) {
        this.seed = n10;
    }

    public static /* synthetic */ int access$000(int n10) {
        return Murmur3_32HashFunction.mixK1(n10);
    }

    public static /* synthetic */ int access$100(int n10, int n11) {
        return Murmur3_32HashFunction.mixH1(n10, n11);
    }

    public static /* synthetic */ int access$200(byte[] byArray, int n10) {
        return Murmur3_32HashFunction.getIntLittleEndian(byArray, n10);
    }

    public static /* synthetic */ long access$300(char c10) {
        return Murmur3_32HashFunction.charToTwoUtf8Bytes(c10);
    }

    public static /* synthetic */ long access$400(char c10) {
        return Murmur3_32HashFunction.charToThreeUtf8Bytes(c10);
    }

    public static /* synthetic */ long access$500(int n10) {
        return Murmur3_32HashFunction.codePointToFourUtf8Bytes(n10);
    }

    public static /* synthetic */ HashCode access$600(int n10, int n11) {
        return Murmur3_32HashFunction.fmix(n10, n11);
    }

    private static long charToThreeUtf8Bytes(char c10) {
        int n10 = (c10 >>> 12 | 0x1E0) & 0xFF;
        int n11 = (c10 >>> 6 & 0x3F | 0x80) << 8;
        return (c10 & 0x3F | 0x80) << 16 | (n10 |= n11);
    }

    private static long charToTwoUtf8Bytes(char c10) {
        int n10 = (c10 >>> 6 | 0x3C0) & 0xFF;
        return (c10 & 0x3F | 0x80) << 8 | n10;
    }

    private static long codePointToFourUtf8Bytes(int n10) {
        long l10 = ((long)(n10 >>> 18) | 0xF0L) & 0xFFL;
        long l11 = n10 >>> 12 & 0x3F;
        long l12 = 128L;
        l11 = (l11 | l12) << 8;
        l10 |= l11;
        l11 = ((long)(n10 >>> 6 & 0x3F) | l12) << 16;
        l10 |= l11;
        l11 = ((long)(n10 & 0x3F) | l12) << 24;
        return l10 | l11;
    }

    private static HashCode fmix(int n10, int n11) {
        n10 ^= n11;
        n11 = n10 >>> 16;
        n10 = (n10 ^ n11) * -2048144789;
        n11 = n10 >>> 13;
        n10 = (n10 ^ n11) * -1028477387;
        n11 = n10 >>> 16;
        return HashCode.fromInt(n10 ^ n11);
    }

    private static int getIntLittleEndian(byte[] byArray, int n10) {
        byte by2 = n10 + 3;
        by2 = byArray[by2];
        byte by3 = n10 + 2;
        by3 = byArray[by3];
        byte by4 = n10 + 1;
        by4 = byArray[by4];
        byte by5 = byArray[n10];
        return Ints.fromBytes(by2, by3, by4, by5);
    }

    private static int mixH1(int n10, int n11) {
        return Integer.rotateLeft(n10 ^ n11, 13) * 5 + -430675100;
    }

    private static int mixK1(int n10) {
        return Integer.rotateLeft(n10 * -862048943, 15) * 461845907;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof Murmur3_32HashFunction;
        boolean bl2 = false;
        if (n10 != 0) {
            object = (Murmur3_32HashFunction)object;
            n10 = this.seed;
            int n11 = ((Murmur3_32HashFunction)object).seed;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public HashCode hashBytes(byte[] byArray, int n10, int n11) {
        int n12;
        int n13 = n10 + n11;
        int n14 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n13, n14);
        n13 = this.seed;
        n14 = 0;
        int n15 = 0;
        while ((n12 = n15 + 4) <= n11) {
            n15 += n10;
            n15 = Murmur3_32HashFunction.mixK1(Murmur3_32HashFunction.getIntLittleEndian(byArray, n15));
            n13 = Murmur3_32HashFunction.mixH1(n13, n15);
            n15 = n12;
        }
        n12 = n15;
        n15 = 0;
        while (n12 < n11) {
            int n16 = n10 + n12;
            n16 = UnsignedBytes.toInt(byArray[n16]) << n15;
            n14 ^= n16;
            ++n12;
            n15 += 8;
        }
        return Murmur3_32HashFunction.fmix(Murmur3_32HashFunction.mixK1(n14) ^ n13, n11);
    }

    public int hashCode() {
        int n10 = Murmur3_32HashFunction.class.hashCode();
        int n11 = this.seed;
        return n10 ^ n11;
    }

    public HashCode hashInt(int n10) {
        n10 = Murmur3_32HashFunction.mixK1(n10);
        return Murmur3_32HashFunction.fmix(Murmur3_32HashFunction.mixH1(this.seed, n10), 4);
    }

    public HashCode hashLong(long l10) {
        int n10 = (int)l10;
        int n11 = (int)(l10 >>> 32);
        int n12 = Murmur3_32HashFunction.mixK1(n10);
        n12 = Murmur3_32HashFunction.mixH1(this.seed, n12);
        n11 = Murmur3_32HashFunction.mixK1(n11);
        return Murmur3_32HashFunction.fmix(Murmur3_32HashFunction.mixH1(n12, n11), 8);
    }

    public HashCode hashString(CharSequence object, Charset charset) {
        Charset charset2 = Charsets.UTF_8;
        int n10 = charset2.equals(charset);
        if (n10 != 0) {
            int n11;
            int n12;
            int n13;
            n10 = object.length();
            int n14 = this.seed;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            while (true) {
                n13 = n16 + 4;
                n12 = 128;
                if (n13 > n10) break;
                int n18 = object.charAt(n16);
                int n19 = n16 + 1;
                n19 = object.charAt(n19);
                n11 = n16 + 2;
                n11 = object.charAt(n11);
                int n20 = n16 + 3;
                n20 = object.charAt(n20);
                if (n18 >= n12 || n19 >= n12 || n11 >= n12 || n20 >= n12) break;
                n16 = n19 << 8 | n18;
                n12 = n11 << 16;
                n16 |= n12;
                n12 = n20 << 24;
                n16 = Murmur3_32HashFunction.mixK1(n16 | n12);
                n14 = Murmur3_32HashFunction.mixH1(n14, n16);
                n17 += 4;
                n16 = n13;
            }
            long l10 = 0L;
            while (n16 < n10) {
                long l11;
                n13 = object.charAt(n16);
                if (n13 < n12) {
                    l11 = (long)n13 << n15;
                    l10 |= l11;
                    n15 += 8;
                    ++n17;
                } else {
                    n11 = 2048;
                    if (n13 < n11) {
                        l11 = Murmur3_32HashFunction.charToTwoUtf8Bytes((char)n13) << n15;
                        l10 |= l11;
                        n15 += 16;
                        n17 += 2;
                    } else {
                        n11 = 55296;
                        if (n13 >= n11 && n13 <= (n11 = 57343)) {
                            n11 = Character.codePointAt((CharSequence)object, n16);
                            if (n11 == n13) {
                                object = object.toString().getBytes(charset);
                                return this.hashBytes((byte[])object);
                            }
                            ++n16;
                            l11 = Murmur3_32HashFunction.codePointToFourUtf8Bytes(n11) << n15;
                            l10 |= l11;
                            n17 += 4;
                        } else {
                            l11 = Murmur3_32HashFunction.charToThreeUtf8Bytes((char)n13) << n15;
                            l10 |= l11;
                            n15 += 24;
                            n17 += 3;
                        }
                    }
                }
                n13 = 32;
                if (n15 >= n13) {
                    n11 = Murmur3_32HashFunction.mixK1((int)l10);
                    n14 = Murmur3_32HashFunction.mixH1(n14, n11);
                    l10 >>>= n13;
                    n15 += -32;
                }
                ++n16;
            }
            return Murmur3_32HashFunction.fmix(Murmur3_32HashFunction.mixK1((int)l10) ^ n14, n17);
        }
        object = object.toString().getBytes(charset);
        return this.hashBytes((byte[])object);
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int n10;
        int n11;
        int n12;
        int n13 = this.seed;
        for (n12 = n10 = 1; n12 < (n11 = charSequence.length()); n12 += 2) {
            n11 = n12 + -1;
            n11 = charSequence.charAt(n11);
            int n14 = charSequence.charAt(n12) << 16;
            n11 = Murmur3_32HashFunction.mixK1(n11 | n14);
            n13 = Murmur3_32HashFunction.mixH1(n13, n11);
        }
        n12 = charSequence.length() & n10;
        if (n12 == n10) {
            n12 = charSequence.length() - n10;
            n10 = Murmur3_32HashFunction.mixK1(charSequence.charAt(n12));
            n13 ^= n10;
        }
        int n15 = charSequence.length() * 2;
        return Murmur3_32HashFunction.fmix(n13, n15);
    }

    public Hasher newHasher() {
        int n10 = this.seed;
        Murmur3_32HashFunction$Murmur3_32Hasher murmur3_32HashFunction$Murmur3_32Hasher = new Murmur3_32HashFunction$Murmur3_32Hasher(n10);
        return murmur3_32HashFunction$Murmur3_32Hasher;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hashing.murmur3_32(");
        int n10 = this.seed;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

