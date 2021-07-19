/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.Crc32cHashFunction$Crc32cHasher;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

public final class Crc32cHashFunction
extends AbstractHashFunction {
    public static final HashFunction CRC_32_C;

    static {
        Crc32cHashFunction crc32cHashFunction = new Crc32cHashFunction();
        CRC_32_C = crc32cHashFunction;
    }

    public int bits() {
        return 32;
    }

    public Hasher newHasher() {
        Crc32cHashFunction$Crc32cHasher crc32cHashFunction$Crc32cHasher = new Crc32cHashFunction$Crc32cHasher();
        return crc32cHashFunction$Crc32cHasher;
    }

    public String toString() {
        return "Hashing.crc32c()";
    }
}

