/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.nio.ByteBuffer;

public abstract class ByteOutput {
    public abstract void write(byte var1);

    public abstract void write(ByteBuffer var1);

    public abstract void write(byte[] var1, int var2, int var3);

    public abstract void writeLazy(ByteBuffer var1);

    public abstract void writeLazy(byte[] var1, int var2, int var3);
}

