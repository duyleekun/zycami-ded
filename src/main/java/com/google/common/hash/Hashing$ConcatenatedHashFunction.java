/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing$1;
import java.util.Arrays;

public final class Hashing$ConcatenatedHashFunction
extends AbstractCompositeHashFunction {
    private Hashing$ConcatenatedHashFunction(HashFunction ... hashFunctionArray) {
        super(hashFunctionArray);
        for (HashFunction hashFunction : hashFunctionArray) {
            boolean bl2 = hashFunction.bits() % 8;
            bl2 = !bl2;
            int n10 = hashFunction.bits();
            String string2 = "the number of bits (%s) in hashFunction (%s) must be divisible by 8";
            Preconditions.checkArgument(bl2, string2, n10, (Object)hashFunction);
        }
    }

    public /* synthetic */ Hashing$ConcatenatedHashFunction(HashFunction[] hashFunctionArray, Hashing$1 hashing$1) {
        this(hashFunctionArray);
    }

    public int bits() {
        HashFunction[] hashFunctionArray = this.functions;
        int n10 = hashFunctionArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            HashFunction hashFunction = hashFunctionArray[i10];
            int n12 = hashFunction.bits();
            n11 += n12;
        }
        return n11;
    }

    public boolean equals(Object objectArray) {
        boolean bl2 = objectArray instanceof Hashing$ConcatenatedHashFunction;
        if (bl2) {
            objectArray = (Hashing$ConcatenatedHashFunction)objectArray;
            Object[] objectArray2 = this.functions;
            objectArray = objectArray.functions;
            return Arrays.equals(objectArray2, objectArray);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.functions);
    }

    public HashCode makeHash(Hasher[] hasherArray) {
        int n10 = this.bits() / 8;
        byte[] byArray = new byte[n10];
        int n11 = hasherArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            HashCode hashCode = hasherArray[i10].hash();
            int n13 = hashCode.bits() / 8;
            int n14 = hashCode.writeBytesTo(byArray, n12, n13);
            n12 += n14;
        }
        return HashCode.fromBytesNoCopy(byArray);
    }
}

