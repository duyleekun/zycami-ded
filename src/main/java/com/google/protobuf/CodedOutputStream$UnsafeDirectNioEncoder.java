/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

public final class CodedOutputStream$UnsafeDirectNioEncoder
extends CodedOutputStream {
    private final long address;
    private final ByteBuffer buffer;
    private final long initialPosition;
    private final long limit;
    private final long oneVarintLimit;
    private final ByteBuffer originalBuffer;
    private long position;

    public CodedOutputStream$UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
        super(null);
        long l10;
        long l11;
        this.originalBuffer = byteBuffer;
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.buffer = byteBuffer2 = byteBuffer2.order(byteOrder);
        this.address = l11 = UnsafeUtil.addressOffset(byteBuffer);
        this.initialPosition = l10 = (long)byteBuffer.position() + l11;
        long l12 = byteBuffer.limit();
        this.limit = l11 += l12;
        this.oneVarintLimit = l11 -= (long)10;
        this.position = l10;
    }

    private int bufferPos(long l10) {
        long l11 = this.address;
        return (int)(l10 - l11);
    }

    public static boolean isSupported() {
        return UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    private void repositionBuffer(long l10) {
        ByteBuffer byteBuffer = this.buffer;
        int n10 = this.bufferPos(l10);
        byteBuffer.position(n10);
    }

    public void flush() {
        ByteBuffer byteBuffer = this.originalBuffer;
        long l10 = this.position;
        int n10 = this.bufferPos(l10);
        byteBuffer.position(n10);
    }

    public int getTotalBytesWritten() {
        long l10 = this.position;
        long l11 = this.initialPosition;
        return (int)(l10 - l11);
    }

    public int spaceLeft() {
        long l10 = this.limit;
        long l11 = this.position;
        return (int)(l10 - l11);
    }

    public void write(byte by2) {
        long l10 = this.position;
        long l11 = this.limit;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            this.position = l11 = 1L + l10;
            UnsafeUtil.putByte(l10, by2);
            return;
        }
        Object object2 = new Object[3];
        Number number = this.position;
        object2[0] = number;
        Long l13 = this.limit;
        object = 1;
        object2[object] = l13;
        number = (int)object;
        object2[2] = number;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException((String)object2);
        throw codedOutputStream$OutOfSpaceException;
    }

    public void write(ByteBuffer byteBuffer) {
        int n10;
        try {
            n10 = byteBuffer.remaining();
        }
        catch (BufferOverflowException bufferOverflowException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw codedOutputStream$OutOfSpaceException;
        }
        long l10 = this.position;
        this.repositionBuffer(l10);
        ByteBuffer byteBuffer2 = this.buffer;
        byteBuffer2.put(byteBuffer);
        l10 = this.position;
        long l11 = n10;
        l10 += l11;
        this.position = l10;
    }

    public void write(byte[] object, int n10, int n11) {
        int n12;
        if (object != null && n10 >= 0 && n11 >= 0 && (n12 = ((byte[])object).length - n11) >= n10) {
            long l10 = this.limit;
            long l11 = n11;
            long l12 = this.position;
            long l13 = (l10 -= l11) - l12;
            n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n12 >= 0) {
                long l14;
                long l15 = n10;
                UnsafeUtil.copyMemory(object, l15, l12, l11);
                this.position = l14 = this.position + l11;
                return;
            }
        }
        Objects.requireNonNull(object, "value");
        object = new CodedOutputStream$OutOfSpaceException;
        Object object2 = new Object[3];
        Long l16 = this.position;
        object2[0] = l16;
        l16 = this.limit;
        object2[1] = l16;
        Integer n13 = n11;
        object2[2] = n13;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        object((String)object2);
        throw object;
    }

    public void writeBool(int n10, boolean bl2) {
        this.writeTag(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        this.write((byte)n10);
    }

    public void writeByteArray(int n10, byte[] byArray) {
        int n11 = byArray.length;
        this.writeByteArray(n10, byArray, 0, n11);
    }

    public void writeByteArray(int n10, byte[] byArray, int n11, int n12) {
        this.writeTag(n10, 2);
        this.writeByteArrayNoTag(byArray, n11, n12);
    }

    public void writeByteArrayNoTag(byte[] byArray, int n10, int n11) {
        this.writeUInt32NoTag(n11);
        this.write(byArray, n10, n11);
    }

    public void writeByteBuffer(int n10, ByteBuffer byteBuffer) {
        this.writeTag(n10, 2);
        n10 = byteBuffer.capacity();
        this.writeUInt32NoTag(n10);
        this.writeRawBytes(byteBuffer);
    }

    public void writeBytes(int n10, ByteString byteString) {
        this.writeTag(n10, 2);
        this.writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) {
        int n10 = byteString.size();
        this.writeUInt32NoTag(n10);
        byteString.writeTo(this);
    }

    public void writeFixed32(int n10, int n11) {
        this.writeTag(n10, 5);
        this.writeFixed32NoTag(n11);
    }

    public void writeFixed32NoTag(int n10) {
        long l10;
        ByteBuffer byteBuffer = this.buffer;
        long l11 = this.position;
        int n11 = this.bufferPos(l11);
        byteBuffer.putInt(n11, n10);
        this.position = l10 = this.position + (long)4;
    }

    public void writeFixed64(int n10, long l10) {
        this.writeTag(n10, 1);
        this.writeFixed64NoTag(l10);
    }

    public void writeFixed64NoTag(long l10) {
        ByteBuffer byteBuffer = this.buffer;
        long l11 = this.position;
        int n10 = this.bufferPos(l11);
        byteBuffer.putLong(n10, l10);
        this.position = l10 = this.position + (long)8;
    }

    public void writeInt32(int n10, int n11) {
        this.writeTag(n10, 0);
        this.writeInt32NoTag(n11);
    }

    public void writeInt32NoTag(int n10) {
        if (n10 >= 0) {
            this.writeUInt32NoTag(n10);
        } else {
            long l10 = n10;
            this.writeUInt64NoTag(l10);
        }
    }

    public void writeLazy(ByteBuffer byteBuffer) {
        this.write(byteBuffer);
    }

    public void writeLazy(byte[] byArray, int n10, int n11) {
        this.write(byArray, n10, n11);
    }

    public void writeMessage(int n10, MessageLite messageLite) {
        this.writeTag(n10, 2);
        this.writeMessageNoTag(messageLite);
    }

    public void writeMessage(int n10, MessageLite messageLite, Schema schema) {
        this.writeTag(n10, 2);
        this.writeMessageNoTag(messageLite, schema);
    }

    public void writeMessageNoTag(MessageLite messageLite) {
        int n10 = messageLite.getSerializedSize();
        this.writeUInt32NoTag(n10);
        messageLite.writeTo(this);
    }

    public void writeMessageNoTag(MessageLite messageLite, Schema schema) {
        Object object = messageLite;
        int n10 = ((AbstractMessageLite)messageLite).getSerializedSize(schema);
        this.writeUInt32NoTag(n10);
        object = this.wrapper;
        schema.writeTo(messageLite, (Writer)object);
    }

    public void writeMessageSetExtension(int n10, MessageLite messageLite) {
        int n11 = 1;
        int n12 = 3;
        this.writeTag(n11, n12);
        this.writeUInt32(2, n10);
        this.writeMessage(n12, messageLite);
        this.writeTag(n11, 4);
    }

    public void writeRawBytes(ByteBuffer byteBuffer) {
        boolean bl2 = byteBuffer.hasArray();
        if (bl2) {
            byte[] byArray = byteBuffer.array();
            int n10 = byteBuffer.arrayOffset();
            int n11 = byteBuffer.capacity();
            this.write(byArray, n10, n11);
        } else {
            byteBuffer = byteBuffer.duplicate();
            byteBuffer.clear();
            this.write(byteBuffer);
        }
    }

    public void writeRawMessageSetExtension(int n10, ByteString byteString) {
        int n11 = 1;
        int n12 = 3;
        this.writeTag(n11, n12);
        this.writeUInt32(2, n10);
        this.writeBytes(n12, byteString);
        this.writeTag(n11, 4);
    }

    public void writeString(int n10, String string2) {
        this.writeTag(n10, 2);
        this.writeStringNoTag(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeStringNoTag(String string2) {
        long l10 = this.position;
        try {
            int n10 = string2.length() * 3;
            n10 = CodedOutputStream.computeUInt32SizeNoTag(n10);
            int n11 = string2.length();
            n11 = CodedOutputStream.computeUInt32SizeNoTag(n11);
            if (n11 == n10) {
                long l11 = this.position;
                n10 = this.bufferPos(l11) + n11;
                ByteBuffer byteBuffer = this.buffer;
                byteBuffer.position(n10);
                byteBuffer = this.buffer;
                Utf8.encodeUtf8(string2, byteBuffer);
                byteBuffer = this.buffer;
                n11 = byteBuffer.position() - n10;
                this.writeUInt32NoTag(n11);
                l11 = this.position;
                long l12 = n11;
                this.position = l11 += l12;
                return;
            }
            n10 = Utf8.encodedLength(string2);
            this.writeUInt32NoTag(n10);
            long l13 = this.position;
            this.repositionBuffer(l13);
            ByteBuffer byteBuffer = this.buffer;
            Utf8.encodeUtf8(string2, byteBuffer);
            l13 = this.position;
            long l14 = n10;
            this.position = l13 += l14;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(illegalArgumentException);
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
            this.position = l10;
            this.repositionBuffer(l10);
            this.inefficientWriteStringNoTag(string2, utf8$UnpairedSurrogateException);
        }
    }

    public void writeTag(int n10, int n11) {
        n10 = WireFormat.makeTag(n10, n11);
        this.writeUInt32NoTag(n10);
    }

    public void writeUInt32(int n10, int n11) {
        this.writeTag(n10, 0);
        this.writeUInt32NoTag(n11);
    }

    public void writeUInt32NoTag(int n10) {
        long l10;
        long l11;
        long l12;
        long l13 = this.position;
        long l14 = this.oneVarintLimit;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        long l16 = 1L;
        if (l15 <= 0) {
            while (true) {
                long l17;
                long l18;
                if ((l15 = (long)(n10 & 0xFFFFFF80)) == false) {
                    l18 = this.position;
                    this.position = l16 += l18;
                    n10 = (byte)n10;
                    UnsafeUtil.putByte(l18, (byte)n10);
                    return;
                }
                l18 = this.position;
                this.position = l17 = l18 + l16;
                l15 = (byte)(n10 & 0x7F | 0x80);
                UnsafeUtil.putByte(l18, (byte)l15);
                n10 >>>= 7;
            }
        }
        while ((l15 = (l12 = (l11 = this.position) - (l10 = this.limit)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            l15 = n10 & 0xFFFFFF80;
            if (l15 == false) {
                this.position = l16 += l11;
                n10 = (byte)n10;
                UnsafeUtil.putByte(l11, (byte)n10);
                return;
            }
            this.position = l10 = l11 + l16;
            l15 = (byte)(n10 & 0x7F | 0x80);
            UnsafeUtil.putByte(l11, (byte)l15);
            n10 >>>= 7;
        }
        Object object = new Object[3];
        Number number = this.position;
        object[0] = number;
        Long l19 = this.limit;
        int n11 = 1;
        object[n11] = l19;
        number = n11;
        object[2] = number;
        object = String.format("Pos: %d, limit: %d, len: %d", object);
        CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException((String)object);
        throw codedOutputStream$OutOfSpaceException;
    }

    public void writeUInt64(int n10, long l10) {
        this.writeTag(n10, 0);
        this.writeUInt64NoTag(l10);
    }

    public void writeUInt64NoTag(long l10) {
        long l11;
        long l12;
        long l13;
        long l14 = this.position;
        long l15 = this.oneVarintLimit;
        Object object = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        int n10 = 7;
        l15 = 0L;
        long l16 = -128;
        long l17 = 1L;
        if (object <= 0) {
            while (true) {
                long l18;
                long l19;
                long l20;
                if ((object = (l20 = (l19 = l10 & l16) - l15) == 0L ? 0 : (l20 < 0L ? -1 : 1)) == false) {
                    l14 = this.position;
                    this.position = l17 += l14;
                    byte by2 = (byte)l10;
                    UnsafeUtil.putByte(l14, by2);
                    return;
                }
                l19 = this.position;
                this.position = l18 = l19 + l17;
                object = (byte)((int)l10 & 0x7F | 0x80);
                UnsafeUtil.putByte(l19, (byte)object);
                l10 >>>= n10;
            }
        }
        while ((object = (l13 = (l12 = this.position) - (l11 = this.limit)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            l11 = l10 & l16;
            long l21 = l11 - l15;
            object = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object == false) {
                this.position = l17 += l12;
                byte by3 = (byte)l10;
                UnsafeUtil.putByte(l12, by3);
                return;
            }
            this.position = l11 = l12 + l17;
            object = (byte)((int)l10 & 0x7F | 0x80);
            UnsafeUtil.putByte(l12, (byte)object);
            l10 >>>= n10;
        }
        Object object2 = new Object[3];
        Number number = this.position;
        object2[0] = number;
        Long l22 = this.limit;
        n10 = 1;
        object2[n10] = l22;
        number = n10;
        object2[2] = number;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException((String)object2);
        throw codedOutputStream$OutOfSpaceException;
    }
}

