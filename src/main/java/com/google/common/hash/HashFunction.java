/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public interface HashFunction {
    public int bits();

    public HashCode hashBytes(ByteBuffer var1);

    public HashCode hashBytes(byte[] var1);

    public HashCode hashBytes(byte[] var1, int var2, int var3);

    public HashCode hashInt(int var1);

    public HashCode hashLong(long var1);

    public HashCode hashObject(Object var1, Funnel var2);

    public HashCode hashString(CharSequence var1, Charset var2);

    public HashCode hashUnencodedChars(CharSequence var1);

    public Hasher newHasher();

    public Hasher newHasher(int var1);
}

