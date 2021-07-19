/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.DataInput;

public interface ByteArrayDataInput
extends DataInput {
    public boolean readBoolean();

    public byte readByte();

    public char readChar();

    public double readDouble();

    public float readFloat();

    public void readFully(byte[] var1);

    public void readFully(byte[] var1, int var2, int var3);

    public int readInt();

    public String readLine();

    public long readLong();

    public short readShort();

    public String readUTF();

    public int readUnsignedByte();

    public int readUnsignedShort();

    public int skipBytes(int var1);
}

