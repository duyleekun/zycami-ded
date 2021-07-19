/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.ByteArrayDataOutput;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteStreams$ByteArrayDataOutputStream
implements ByteArrayDataOutput {
    public final ByteArrayOutputStream byteArrayOutputStream;
    public final DataOutput output;

    public ByteStreams$ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        this.output = dataOutputStream;
    }

    public byte[] toByteArray() {
        return this.byteArrayOutputStream.toByteArray();
    }

    public void write(int n10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.write(n10);
    }

    public void write(byte[] byArray) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.write(byArray);
    }

    public void write(byte[] byArray, int n10, int n11) {
        DataOutput dataOutput;
        try {
            dataOutput = this.output;
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
        dataOutput.write(byArray, n10, n11);
    }

    public void writeBoolean(boolean bl2) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeBoolean(bl2);
    }

    public void writeByte(int n10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeByte(n10);
    }

    public void writeBytes(String string2) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeBytes(string2);
    }

    public void writeChar(int n10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeChar(n10);
    }

    public void writeChars(String string2) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeChars(string2);
    }

    public void writeDouble(double d10) {
        DataOutput dataOutput;
        try {
            dataOutput = this.output;
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
        dataOutput.writeDouble(d10);
    }

    public void writeFloat(float f10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeFloat(f10);
    }

    public void writeInt(int n10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeInt(n10);
    }

    public void writeLong(long l10) {
        DataOutput dataOutput;
        try {
            dataOutput = this.output;
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
        dataOutput.writeLong(l10);
    }

    public void writeShort(int n10) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeShort(n10);
    }

    public void writeUTF(String string2) {
        Object object;
        try {
            object = this.output;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
        object.writeUTF(string2);
    }
}

