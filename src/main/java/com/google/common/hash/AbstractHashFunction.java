/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class AbstractHashFunction
implements HashFunction {
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        return this.newHasher(n10).putBytes(byteBuffer).hash();
    }

    public HashCode hashBytes(byte[] byArray) {
        int n10 = byArray.length;
        return this.hashBytes(byArray, 0, n10);
    }

    public HashCode hashBytes(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        return this.newHasher(n11).putBytes(byArray, n10, n11).hash();
    }

    public HashCode hashInt(int n10) {
        return this.newHasher(4).putInt(n10).hash();
    }

    public HashCode hashLong(long l10) {
        return this.newHasher(8).putLong(l10).hash();
    }

    public HashCode hashObject(Object object, Funnel funnel) {
        return this.newHasher().putObject(object, funnel).hash();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.newHasher().putString(charSequence, charset).hash();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int n10 = charSequence.length() * 2;
        return this.newHasher(n10).putUnencodedChars(charSequence).hash();
    }

    public Hasher newHasher(int n10) {
        boolean bl2 = n10 >= 0;
        Preconditions.checkArgument(bl2, "expectedInputSize must be >= 0 but was %s", n10);
        return this.newHasher();
    }
}

