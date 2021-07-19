/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.Murmur3_128HashFunction$Murmur3_128Hasher;
import java.io.Serializable;

public final class Murmur3_128HashFunction
extends AbstractHashFunction
implements Serializable {
    public static final HashFunction GOOD_FAST_HASH_128;
    public static final HashFunction MURMUR3_128;
    private static final long serialVersionUID;
    private final int seed;

    static {
        Murmur3_128HashFunction murmur3_128HashFunction = new Murmur3_128HashFunction(0);
        MURMUR3_128 = murmur3_128HashFunction;
        int n10 = Hashing.GOOD_FAST_HASH_SEED;
        murmur3_128HashFunction = new Murmur3_128HashFunction(n10);
        GOOD_FAST_HASH_128 = murmur3_128HashFunction;
    }

    public Murmur3_128HashFunction(int n10) {
        this.seed = n10;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof Murmur3_128HashFunction;
        boolean bl2 = false;
        if (n10 != 0) {
            object = (Murmur3_128HashFunction)object;
            n10 = this.seed;
            int n11 = ((Murmur3_128HashFunction)object).seed;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = Murmur3_128HashFunction.class.hashCode();
        int n11 = this.seed;
        return n10 ^ n11;
    }

    public Hasher newHasher() {
        int n10 = this.seed;
        Murmur3_128HashFunction$Murmur3_128Hasher murmur3_128HashFunction$Murmur3_128Hasher = new Murmur3_128HashFunction$Murmur3_128Hasher(n10);
        return murmur3_128HashFunction$Murmur3_128Hasher;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hashing.murmur3_128(");
        int n10 = this.seed;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

