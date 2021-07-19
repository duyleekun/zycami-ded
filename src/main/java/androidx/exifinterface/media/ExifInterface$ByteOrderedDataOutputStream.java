/*
 * Decompiled with CFR 0.151.
 */
package androidx.exifinterface.media;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

public class ExifInterface$ByteOrderedDataOutputStream
extends FilterOutputStream {
    private ByteOrder mByteOrder;
    public final OutputStream mOutputStream;

    public ExifInterface$ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    public void write(byte[] byArray) {
        this.mOutputStream.write(byArray);
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.mOutputStream.write(byArray, n10, n11);
    }

    public void writeByte(int n10) {
        this.mOutputStream.write(n10);
    }

    public void writeInt(int n10) {
        Object object = this.mByteOrder;
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        if (object == byteOrder) {
            object = this.mOutputStream;
            int n11 = n10 >>> 0 & 0xFF;
            ((OutputStream)object).write(n11);
            object = this.mOutputStream;
            n11 = n10 >>> 8 & 0xFF;
            ((OutputStream)object).write(n11);
            object = this.mOutputStream;
            n11 = n10 >>> 16 & 0xFF;
            ((OutputStream)object).write(n11);
            object = this.mOutputStream;
            n10 = n10 >>> 24 & 0xFF;
            ((OutputStream)object).write(n10);
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
            if (object == byteOrder) {
                object = this.mOutputStream;
                int n12 = n10 >>> 24 & 0xFF;
                ((OutputStream)object).write(n12);
                object = this.mOutputStream;
                n12 = n10 >>> 16 & 0xFF;
                ((OutputStream)object).write(n12);
                object = this.mOutputStream;
                n12 = n10 >>> 8 & 0xFF;
                ((OutputStream)object).write(n12);
                object = this.mOutputStream;
                n10 = n10 >>> 0 & 0xFF;
                ((OutputStream)object).write(n10);
            }
        }
    }

    public void writeShort(short s10) {
        Object object = this.mByteOrder;
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        if (object == byteOrder) {
            object = this.mOutputStream;
            int n10 = s10 >>> 0 & 0xFF;
            ((OutputStream)object).write(n10);
            object = this.mOutputStream;
            s10 = (short)(s10 >>> 8 & 0xFF);
            ((OutputStream)object).write(s10);
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
            if (object == byteOrder) {
                object = this.mOutputStream;
                int n11 = s10 >>> 8 & 0xFF;
                ((OutputStream)object).write(n11);
                object = this.mOutputStream;
                s10 = (short)(s10 >>> 0 & 0xFF);
                ((OutputStream)object).write(s10);
            }
        }
    }

    public void writeUnsignedInt(long l10) {
        int n10 = (int)l10;
        this.writeInt(n10);
    }

    public void writeUnsignedShort(int n10) {
        n10 = (short)n10;
        this.writeShort((short)n10);
    }
}

