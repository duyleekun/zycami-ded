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
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class CodedOutputStream$SafeDirectNioEncoder
extends CodedOutputStream {
    private final ByteBuffer buffer;
    private final int initialPosition;
    private final ByteBuffer originalBuffer;

    public CodedOutputStream$SafeDirectNioEncoder(ByteBuffer byteBuffer) {
        super(null);
        int n10;
        this.originalBuffer = byteBuffer;
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.buffer = byteBuffer2 = byteBuffer2.order(byteOrder);
        this.initialPosition = n10 = byteBuffer.position();
    }

    private void encode(String string2) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw object;
        }
        Utf8.encodeUtf8(string2, (ByteBuffer)object);
    }

    public void flush() {
        ByteBuffer byteBuffer = this.originalBuffer;
        int n10 = this.buffer.position();
        byteBuffer.position(n10);
    }

    public int getTotalBytesWritten() {
        int n10 = this.buffer.position();
        int n11 = this.initialPosition;
        return n10 - n11;
    }

    public int spaceLeft() {
        return this.buffer.remaining();
    }

    public void write(byte by2) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (BufferOverflowException bufferOverflowException) {
            object = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw object;
        }
        ((ByteBuffer)object).put(by2);
    }

    public void write(ByteBuffer byteBuffer) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (BufferOverflowException bufferOverflowException) {
            object = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw object;
        }
        ((ByteBuffer)object).put(byteBuffer);
    }

    public void write(byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = this.buffer;
        try {
            byteBuffer.put(byArray, n10, n11);
            return;
        }
        catch (BufferOverflowException bufferOverflowException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
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
        Object object;
        try {
            object = this.buffer;
        }
        catch (BufferOverflowException bufferOverflowException) {
            object = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw object;
        }
        ((ByteBuffer)object).putInt(n10);
    }

    public void writeFixed64(int n10, long l10) {
        this.writeTag(n10, 1);
        this.writeFixed64NoTag(l10);
    }

    public void writeFixed64NoTag(long l10) {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = this.buffer;
        }
        catch (BufferOverflowException bufferOverflowException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(bufferOverflowException);
            throw codedOutputStream$OutOfSpaceException;
        }
        byteBuffer.putLong(l10);
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
        ByteBuffer byteBuffer;
        Object object = this.buffer;
        int n10 = ((Buffer)object).position();
        try {
            int n11 = string2.length() * 3;
            n11 = CodedOutputStream.computeUInt32SizeNoTag(n11);
            int n12 = string2.length();
            n12 = CodedOutputStream.computeUInt32SizeNoTag(n12);
            if (n12 == n11) {
                ByteBuffer byteBuffer2 = this.buffer;
                n11 = byteBuffer2.position() + n12;
                byteBuffer = this.buffer;
                byteBuffer.position(n11);
                this.encode(string2);
                byteBuffer = this.buffer;
                n12 = byteBuffer.position();
                ByteBuffer byteBuffer3 = this.buffer;
                byteBuffer3.position(n10);
                n11 = n12 - n11;
                this.writeUInt32NoTag(n11);
                byteBuffer2 = this.buffer;
                byteBuffer2.position(n12);
                return;
            }
            n11 = Utf8.encodedLength(string2);
            this.writeUInt32NoTag(n11);
            this.encode(string2);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = new CodedOutputStream$OutOfSpaceException(illegalArgumentException);
            throw object;
        }
        catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
            byteBuffer = this.buffer;
            byteBuffer.position(n10);
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

    /*
     * Unable to fully structure code
     */
    public void writeUInt32NoTag(int var1_1) {
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl13
            var3_3 = this.buffer;
            break;
        }
        catch (BufferOverflowException var5_5) {
            var3_3 = new CodedOutputStream$OutOfSpaceException(var5_5);
            throw var3_3;
        }
        {
            var1_1 = (byte)var1_1;
            var3_3.put((byte)var1_1);
            return;
lbl13:
            // 1 sources

            var3_3 = this.buffer;
            var4_4 = (byte)(var1_1 & 127 | 128);
            var3_3.put(var4_4);
            var1_1 >>>= 7;
            continue;
        }
    }

    public void writeUInt64(int n10, long l10) {
        this.writeTag(n10, 0);
        this.writeUInt64NoTag(l10);
    }

    /*
     * Unable to fully structure code
     */
    public void writeUInt64NoTag(long var1_1) {
        while (true) lbl-1000:
        // 2 sources

        {
            if ((var7_4 = (cfr_temp_0 = (var3_2 = (long)-128 & var1_1) - (var5_3 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) ** GOTO lbl13
            var8_5 = this.buffer;
            break;
        }
        catch (BufferOverflowException var11_8) {
            var12_9 = new CodedOutputStream$OutOfSpaceException(var11_8);
            throw var12_9;
        }
        {
            var9_7 = (byte)var1_1;
            var8_5.put(var9_7);
            return;
lbl13:
            // 1 sources

            var8_5 = this.buffer;
            var10_6 = (byte)((int)var1_1 & 127 | 128);
            var8_5.put(var10_6);
            var7_4 = 7;
            var1_1 >>>= var7_4;
            ** while (true)
        }
    }
}

