/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public interface Hasher
extends PrimitiveSink {
    public HashCode hash();

    public int hashCode();

    public Hasher putBoolean(boolean var1);

    public Hasher putByte(byte var1);

    public Hasher putBytes(ByteBuffer var1);

    public Hasher putBytes(byte[] var1);

    public Hasher putBytes(byte[] var1, int var2, int var3);

    public Hasher putChar(char var1);

    public Hasher putDouble(double var1);

    public Hasher putFloat(float var1);

    public Hasher putInt(int var1);

    public Hasher putLong(long var1);

    public Hasher putObject(Object var1, Funnel var2);

    public Hasher putShort(short var1);

    public Hasher putString(CharSequence var1, Charset var2);

    public Hasher putUnencodedChars(CharSequence var1);
}

