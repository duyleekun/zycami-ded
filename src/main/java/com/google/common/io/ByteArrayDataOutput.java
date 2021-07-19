/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.DataOutput;

public interface ByteArrayDataOutput
extends DataOutput {
    public byte[] toByteArray();

    public void write(int var1);

    public void write(byte[] var1);

    public void write(byte[] var1, int var2, int var3);

    public void writeBoolean(boolean var1);

    public void writeByte(int var1);

    public void writeBytes(String var1);

    public void writeChar(int var1);

    public void writeChars(String var1);

    public void writeDouble(double var1);

    public void writeFloat(float var1);

    public void writeInt(int var1);

    public void writeLong(long var1);

    public void writeShort(int var1);

    public void writeUTF(String var1);
}

