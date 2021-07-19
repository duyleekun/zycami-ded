/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction$1;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

public abstract class AbstractCompositeHashFunction
extends AbstractHashFunction {
    private static final long serialVersionUID;
    public final HashFunction[] functions;

    public AbstractCompositeHashFunction(HashFunction ... hashFunctionArray) {
        int n10 = hashFunctionArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            HashFunction hashFunction = hashFunctionArray[i10];
            Preconditions.checkNotNull(hashFunction);
        }
        this.functions = hashFunctionArray;
    }

    private Hasher fromHashers(Hasher[] hasherArray) {
        AbstractCompositeHashFunction$1 abstractCompositeHashFunction$1 = new AbstractCompositeHashFunction$1(this, hasherArray);
        return abstractCompositeHashFunction$1;
    }

    public abstract HashCode makeHash(Hasher[] var1);

    public Hasher newHasher() {
        HashFunction[] hashFunctionArray = this.functions;
        int n10 = hashFunctionArray.length;
        Hasher[] hasherArray = new Hasher[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Hasher hasher;
            hasherArray[i10] = hasher = this.functions[i10].newHasher();
        }
        return this.fromHashers(hasherArray);
    }

    public Hasher newHasher(int n10) {
        HashFunction[] hashFunctionArray;
        int n11;
        int n12 = 0;
        if (n10 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            hashFunctionArray = null;
        }
        Preconditions.checkArgument(n11 != 0);
        hashFunctionArray = this.functions;
        n11 = hashFunctionArray.length;
        Hasher[] hasherArray = new Hasher[n11];
        while (n12 < n11) {
            Hasher hasher;
            hasherArray[n12] = hasher = this.functions[n12].newHasher(n10);
            ++n12;
        }
        return this.fromHashers(hasherArray);
    }
}

