/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public final class ByteOrderedDataInputStream
extends InputStream
implements DataInput {
    private static final ByteOrder BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN;
    private ByteOrder mByteOrder;
    private final DataInputStream mDataInputStream;
    public final int mLength;
    public int mPosition;

    static {
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    }

    public ByteOrderedDataInputStream(InputStream inputStream) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(inputStream, byteOrder);
    }

    public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
        int n10;
        Object object = ByteOrder.BIG_ENDIAN;
        this.mByteOrder = object;
        this.mDataInputStream = object = new DataInputStream(inputStream);
        this.mLength = n10 = ((FilterInputStream)object).available();
        this.mPosition = 0;
        ((FilterInputStream)object).mark(n10);
        this.mByteOrder = byteOrder;
    }

    public ByteOrderedDataInputStream(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this(byteArrayInputStream);
    }

    public int available() {
        return this.mDataInputStream.available();
    }

    public int getLength() {
        return this.mLength;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void mark(int n10) {
        DataInputStream dataInputStream = this.mDataInputStream;
        synchronized (dataInputStream) {
            DataInputStream dataInputStream2 = this.mDataInputStream;
            dataInputStream2.mark(n10);
            return;
        }
    }

    public int peek() {
        return this.mPosition;
    }

    public int read() {
        int n10;
        this.mPosition = n10 = this.mPosition + 1;
        return this.mDataInputStream.read();
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = this.mDataInputStream.read(byArray, n10, n11);
        this.mPosition = n10 = this.mPosition + n12;
        return n12;
    }

    public boolean readBoolean() {
        int n10;
        this.mPosition = n10 = this.mPosition + 1;
        return this.mDataInputStream.readBoolean();
    }

    public byte readByte() {
        int n10;
        this.mPosition = n10 = this.mPosition + 1;
        int n11 = this.mLength;
        if (n10 <= n11) {
            Object object = this.mDataInputStream;
            n10 = ((FilterInputStream)object).read();
            if (n10 >= 0) {
                return (byte)n10;
            }
            object = new EOFException();
            throw object;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public char readChar() {
        int n10;
        this.mPosition = n10 = this.mPosition + 2;
        return this.mDataInputStream.readChar();
    }

    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    public void readFully(byte[] object) {
        int n10 = this.mPosition;
        int n11 = ((byte[])object).length;
        this.mPosition = n10 += n11;
        n11 = this.mLength;
        if (n10 <= n11) {
            int n12;
            DataInputStream dataInputStream = this.mDataInputStream;
            n11 = 0;
            int n13 = ((byte[])object).length;
            n10 = dataInputStream.read((byte[])object, 0, n13);
            if (n10 == (n12 = ((byte[])object).length)) {
                return;
            }
            object = new IOException;
            object("Couldn't read up to the length of buffer");
            throw object;
        }
        object = new EOFException;
        object();
        throw object;
    }

    public void readFully(byte[] object, int n10, int n11) {
        int n12;
        this.mPosition = n12 = this.mPosition + n11;
        int n13 = this.mLength;
        if (n12 <= n13) {
            DataInputStream dataInputStream = this.mDataInputStream;
            int n14 = dataInputStream.read((byte[])object, n10, n11);
            if (n14 == n11) {
                return;
            }
            object = new IOException;
            object("Couldn't read up to the length of buffer");
            throw object;
        }
        object = new EOFException;
        object();
        throw object;
    }

    public int readInt() {
        int n10;
        this.mPosition = n10 = this.mPosition + 4;
        int n11 = this.mLength;
        if (n10 <= n11) {
            DataInputStream dataInputStream;
            int n12;
            Object object;
            int n13;
            Object object2;
            Object object3 = this.mDataInputStream;
            n10 = ((FilterInputStream)object3).read();
            int n14 = n10 | (n11 = ((FilterInputStream)(object2 = this.mDataInputStream)).read()) | (n13 = ((FilterInputStream)(object = this.mDataInputStream)).read()) | (n12 = (dataInputStream = this.mDataInputStream).read());
            if (n14 >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                ByteOrder byteOrder2 = LITTLE_ENDIAN;
                if (byteOrder == byteOrder2) {
                    n12 <<= 24;
                    return (n12 += (n13 <<= 16)) + (n11 <<= 8) + n10;
                }
                byteOrder2 = BIG_ENDIAN;
                if (byteOrder == byteOrder2) {
                    n10 <<= 24;
                    n11 = n13 << 8;
                    return (n10 += (n11 <<= 16)) + n11 + n12;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Invalid byte order: ");
                object = this.mByteOrder;
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                object3 = new IOException((String)object2);
                throw object3;
            }
            object3 = new EOFException();
            throw object3;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public String readLine() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("readLine() not implemented.");
        throw unsupportedOperationException;
    }

    public long readLong() {
        int n10 = this.mPosition;
        int n11 = 8;
        this.mPosition = n10 += n11;
        int n12 = this.mLength;
        if (n10 <= n12) {
            DataInputStream dataInputStream;
            int n13;
            DataInputStream dataInputStream2;
            int n14;
            DataInputStream dataInputStream3;
            int n15;
            DataInputStream dataInputStream4;
            int n16;
            DataInputStream dataInputStream5;
            int n17;
            DataInputStream dataInputStream6;
            int n18;
            Object object;
            Object object2 = this.mDataInputStream;
            n10 = ((FilterInputStream)object2).read();
            int n19 = n10 | (n12 = ((FilterInputStream)(object = this.mDataInputStream)).read()) | (n18 = (dataInputStream6 = this.mDataInputStream).read()) | (n17 = (dataInputStream5 = this.mDataInputStream).read()) | (n16 = (dataInputStream4 = this.mDataInputStream).read()) | (n15 = (dataInputStream3 = this.mDataInputStream).read()) | (n14 = (dataInputStream2 = this.mDataInputStream).read()) | (n13 = (dataInputStream = this.mDataInputStream).read());
            if (n19 >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                ByteOrder byteOrder2 = LITTLE_ENDIAN;
                int n20 = 16;
                int n21 = 24;
                int n22 = 32;
                int n23 = 40;
                int n24 = 48;
                int n25 = 56;
                if (byteOrder == byteOrder2) {
                    long l10 = (long)n13 << n25;
                    long l11 = (long)n14 << n24;
                    l10 += l11;
                    l11 = (long)n15 << n23;
                    l10 += l11;
                    l11 = (long)n16 << n22;
                    l10 += l11;
                    l11 = (long)n17 << n21;
                    l10 += l11;
                    l11 = (long)n18 << n20;
                    l10 += l11;
                    n11 = n12;
                    l11 = (long)n12 << 8;
                    long l12 = n10;
                    return (l10 += l11) + l12;
                }
                n11 = n12;
                object = BIG_ENDIAN;
                if (byteOrder == object) {
                    long l13 = (long)n10 << n25;
                    long l14 = (long)n12 << n24;
                    l13 += l14;
                    l14 = (long)n18 << n23;
                    l13 += l14;
                    l14 = (long)n17 << n22;
                    l13 += l14;
                    l14 = (long)n16 << n21;
                    l13 += l14;
                    l14 = (long)n15 << 16;
                    l13 += l14;
                    l14 = (long)n14 << 8;
                    l13 += l14;
                    l14 = n13;
                    return l13 + l14;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Invalid byte order: ");
                object = this.mByteOrder;
                charSequence.append(object);
                charSequence = charSequence.toString();
                object2 = new IOException((String)charSequence);
                throw object2;
            }
            object2 = new EOFException();
            throw object2;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public short readShort() {
        int n10;
        this.mPosition = n10 = this.mPosition + 2;
        int n11 = this.mLength;
        if (n10 <= n11) {
            Object object;
            Object object2 = this.mDataInputStream;
            n10 = ((FilterInputStream)object2).read();
            int n12 = n10 | (n11 = ((FilterInputStream)(object = this.mDataInputStream)).read());
            if (n12 >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                ByteOrder byteOrder2 = LITTLE_ENDIAN;
                if (byteOrder == byteOrder2) {
                    return (short)((n11 << 8) + n10);
                }
                byteOrder2 = BIG_ENDIAN;
                if (byteOrder == byteOrder2) {
                    return (short)((n10 << 8) + n11);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid byte order: ");
                byteOrder = this.mByteOrder;
                ((StringBuilder)object).append(byteOrder);
                object = ((StringBuilder)object).toString();
                object2 = new IOException((String)object);
                throw object2;
            }
            object2 = new EOFException();
            throw object2;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public String readUTF() {
        int n10;
        this.mPosition = n10 = this.mPosition + 2;
        return this.mDataInputStream.readUTF();
    }

    public int readUnsignedByte() {
        int n10;
        this.mPosition = n10 = this.mPosition + 1;
        return this.mDataInputStream.readUnsignedByte();
    }

    public long readUnsignedInt() {
        return (long)this.readInt() & 0xFFFFFFFFL;
    }

    public int readUnsignedShort() {
        int n10;
        this.mPosition = n10 = this.mPosition + 2;
        int n11 = this.mLength;
        if (n10 <= n11) {
            Object object;
            Object object2 = this.mDataInputStream;
            n10 = ((FilterInputStream)object2).read();
            int n12 = n10 | (n11 = ((FilterInputStream)(object = this.mDataInputStream)).read());
            if (n12 >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                ByteOrder byteOrder2 = LITTLE_ENDIAN;
                if (byteOrder == byteOrder2) {
                    return (n11 << 8) + n10;
                }
                byteOrder2 = BIG_ENDIAN;
                if (byteOrder == byteOrder2) {
                    return (n10 << 8) + n11;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid byte order: ");
                byteOrder = this.mByteOrder;
                ((StringBuilder)object).append(byteOrder);
                object = ((StringBuilder)object).toString();
                object2 = new IOException((String)object);
                throw object2;
            }
            object2 = new EOFException();
            throw object2;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public void seek(long l10) {
        int n10 = this.mPosition;
        long l11 = n10;
        long l12 = l11 - l10;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 > 0) {
            n10 = 0;
            this.mPosition = 0;
            this.mDataInputStream.reset();
            DataInputStream dataInputStream = this.mDataInputStream;
            l13 = this.mLength;
            dataInputStream.mark((int)l13);
        } else {
            long l14 = n10;
            l10 -= l14;
        }
        int n11 = (int)l10;
        int n12 = this.skipBytes(n11);
        if (n12 == n11) {
            return;
        }
        IOException iOException = new IOException("Couldn't seek up to the byteCount");
        throw iOException;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    public int skipBytes(int n10) {
        int n11 = this.mLength;
        int n12 = this.mPosition;
        n10 = Math.min(n10, n11 -= n12);
        for (n11 = 0; n11 < n10; n11 += n12) {
            DataInputStream dataInputStream = this.mDataInputStream;
            int n13 = n10 - n11;
            n12 = dataInputStream.skipBytes(n13);
        }
        this.mPosition = n10 = this.mPosition + n11;
        return n11;
    }
}

