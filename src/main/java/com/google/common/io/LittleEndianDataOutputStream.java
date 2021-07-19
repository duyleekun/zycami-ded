/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class LittleEndianDataOutputStream
extends FilterOutputStream
implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        outputStream = (OutputStream)Preconditions.checkNotNull(outputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        super(dataOutputStream);
    }

    public void close() {
        this.out.close();
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.out.write(byArray, n10, n11);
    }

    public void writeBoolean(boolean bl2) {
        ((DataOutputStream)this.out).writeBoolean(bl2);
    }

    public void writeByte(int n10) {
        ((DataOutputStream)this.out).writeByte(n10);
    }

    public void writeBytes(String string2) {
        ((DataOutputStream)this.out).writeBytes(string2);
    }

    public void writeChar(int n10) {
        this.writeShort(n10);
    }

    public void writeChars(String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            this.writeChar(n10);
        }
    }

    public void writeDouble(double d10) {
        long l10 = Double.doubleToLongBits(d10);
        this.writeLong(l10);
    }

    public void writeFloat(float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.writeInt(n10);
    }

    public void writeInt(int n10) {
        OutputStream outputStream = this.out;
        int n11 = n10 & 0xFF;
        outputStream.write(n11);
        outputStream = this.out;
        n11 = n10 >> 8 & 0xFF;
        outputStream.write(n11);
        outputStream = this.out;
        n11 = n10 >> 16 & 0xFF;
        outputStream.write(n11);
        outputStream = this.out;
        n10 = n10 >> 24 & 0xFF;
        outputStream.write(n10);
    }

    public void writeLong(long l10) {
        byte[] byArray = Longs.toByteArray(Long.reverseBytes(l10));
        int n10 = byArray.length;
        this.write(byArray, 0, n10);
    }

    public void writeShort(int n10) {
        OutputStream outputStream = this.out;
        int n11 = n10 & 0xFF;
        outputStream.write(n11);
        outputStream = this.out;
        n10 = n10 >> 8 & 0xFF;
        outputStream.write(n10);
    }

    public void writeUTF(String string2) {
        ((DataOutputStream)this.out).writeUTF(string2);
    }
}

