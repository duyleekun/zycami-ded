/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class LittleEndianDataInputStream
extends FilterInputStream
implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        inputStream = (InputStream)Preconditions.checkNotNull(inputStream);
        super(inputStream);
    }

    private byte readAndCheckByte() {
        int n10 = -1;
        Object object = this.in;
        int n11 = ((InputStream)object).read();
        if (n10 != n11) {
            return (byte)n11;
        }
        object = new EOFException();
        throw object;
    }

    public boolean readBoolean() {
        int n10 = this.readUnsignedByte();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public byte readByte() {
        return (byte)this.readUnsignedByte();
    }

    public char readChar() {
        return (char)this.readUnsignedShort();
    }

    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    public void readFully(byte[] byArray) {
        ByteStreams.readFully(this, byArray);
    }

    public void readFully(byte[] byArray, int n10, int n11) {
        ByteStreams.readFully(this, byArray, n10, n11);
    }

    public int readInt() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        return Ints.fromBytes(this.readAndCheckByte(), by4, by3, by2);
    }

    public String readLine() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("readLine is not supported");
        throw unsupportedOperationException;
    }

    public long readLong() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        byte by5 = this.readAndCheckByte();
        byte by6 = this.readAndCheckByte();
        byte by7 = this.readAndCheckByte();
        byte by8 = this.readAndCheckByte();
        return Longs.fromBytes(this.readAndCheckByte(), by8, by7, by6, by5, by4, by3, by2);
    }

    public short readShort() {
        return (short)this.readUnsignedShort();
    }

    public String readUTF() {
        InputStream inputStream = this.in;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        return dataInputStream.readUTF();
    }

    public int readUnsignedByte() {
        Object object = this.in;
        int n10 = ((InputStream)object).read();
        if (n10 >= 0) {
            return n10;
        }
        object = new EOFException();
        throw object;
    }

    public int readUnsignedShort() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        return Ints.fromBytes((byte)0, (byte)0, by3, by2);
    }

    public int skipBytes(int n10) {
        InputStream inputStream = this.in;
        long l10 = n10;
        return (int)inputStream.skip(l10);
    }
}

