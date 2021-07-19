/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStream$AbstractBufferedEncoder;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class CodedOutputStream$ByteOutputEncoder
extends CodedOutputStream$AbstractBufferedEncoder {
    private final ByteOutput out;

    public CodedOutputStream$ByteOutputEncoder(ByteOutput byteOutput, int n10) {
        super(n10);
        Objects.requireNonNull(byteOutput, "out");
        this.out = byteOutput;
    }

    private void doFlush() {
        ByteOutput byteOutput = this.out;
        byte[] byArray = this.buffer;
        int n10 = this.position;
        byteOutput.write(byArray, 0, n10);
        this.position = 0;
    }

    private void flushIfNotAvailable(int n10) {
        int n11 = this.limit;
        int n12 = this.position;
        if ((n11 -= n12) < n10) {
            this.doFlush();
        }
    }

    public void flush() {
        int n10 = this.position;
        if (n10 > 0) {
            this.doFlush();
        }
    }

    public void write(byte by2) {
        int n10 = this.position;
        int n11 = this.limit;
        if (n10 == n11) {
            this.doFlush();
        }
        this.buffer(by2);
    }

    public void write(ByteBuffer byteBuffer) {
        int n10;
        this.flush();
        int n11 = byteBuffer.remaining();
        this.out.write(byteBuffer);
        this.totalBytesWritten = n10 = this.totalBytesWritten + n11;
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12;
        this.flush();
        this.out.write(byArray, n10, n11);
        this.totalBytesWritten = n12 = this.totalBytesWritten + n11;
    }

    public void writeBool(int n10, boolean bl2) {
        this.flushIfNotAvailable(11);
        this.bufferTag(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        this.buffer((byte)n10);
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
        this.flushIfNotAvailable(14);
        this.bufferTag(n10, 5);
        this.bufferFixed32NoTag(n11);
    }

    public void writeFixed32NoTag(int n10) {
        this.flushIfNotAvailable(4);
        this.bufferFixed32NoTag(n10);
    }

    public void writeFixed64(int n10, long l10) {
        this.flushIfNotAvailable(18);
        this.bufferTag(n10, 1);
        this.bufferFixed64NoTag(l10);
    }

    public void writeFixed64NoTag(long l10) {
        this.flushIfNotAvailable(8);
        this.bufferFixed64NoTag(l10);
    }

    public void writeInt32(int n10, int n11) {
        this.flushIfNotAvailable(20);
        this.bufferTag(n10, 0);
        this.bufferInt32NoTag(n11);
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
        int n10;
        this.flush();
        int n11 = byteBuffer.remaining();
        this.out.writeLazy(byteBuffer);
        this.totalBytesWritten = n10 = this.totalBytesWritten + n11;
    }

    public void writeLazy(byte[] byArray, int n10, int n11) {
        int n12;
        this.flush();
        this.out.writeLazy(byArray, n10, n11);
        this.totalBytesWritten = n12 = this.totalBytesWritten + n11;
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
        int n10;
        int n11 = string2.length() * 3;
        int n12 = CodedOutputStream.computeUInt32SizeNoTag(n11);
        int n13 = n12 + n11;
        if (n13 > (n10 = this.limit)) {
            byte[] byArray = new byte[n11];
            int n14 = Utf8.encode(string2, byArray, 0, n11);
            this.writeUInt32NoTag(n14);
            this.writeLazy(byArray, 0, n14);
            return;
        }
        n11 = this.position;
        if (n13 > (n10 -= n11)) {
            this.doFlush();
        }
        n11 = this.position;
        try {
            n13 = string2.length();
            n13 = CodedOutputStream.computeUInt32SizeNoTag(n13);
            if (n13 == n12) {
                this.position = n12 = n11 + n13;
                byte[] byArray = this.buffer;
                int n15 = this.limit - n12;
                n12 = Utf8.encode(string2, byArray, n12, n15);
                this.position = n11;
                n10 = n12 - n11 - n13;
                this.bufferUInt32NoTag(n10);
                this.position = n12;
                this.totalBytesWritten = n12 = this.totalBytesWritten + n10;
                return;
            }
            n12 = Utf8.encodedLength(string2);
            this.bufferUInt32NoTag(n12);
            byte[] byArray = this.buffer;
            n10 = this.position;
            this.position = n13 = Utf8.encode(string2, byArray, n10, n12);
            this.totalBytesWritten = n13 = this.totalBytesWritten + n12;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
            n13 = this.totalBytesWritten;
            n10 = this.position - n11;
            this.totalBytesWritten = n13 -= n10;
            this.position = n11;
            this.inefficientWriteStringNoTag(string2, utf8$UnpairedSurrogateException);
        }
    }

    public void writeTag(int n10, int n11) {
        n10 = WireFormat.makeTag(n10, n11);
        this.writeUInt32NoTag(n10);
    }

    public void writeUInt32(int n10, int n11) {
        this.flushIfNotAvailable(20);
        this.bufferTag(n10, 0);
        this.bufferUInt32NoTag(n11);
    }

    public void writeUInt32NoTag(int n10) {
        this.flushIfNotAvailable(5);
        this.bufferUInt32NoTag(n10);
    }

    public void writeUInt64(int n10, long l10) {
        this.flushIfNotAvailable(20);
        this.bufferTag(n10, 0);
        this.bufferUInt64NoTag(l10);
    }

    public void writeUInt64NoTag(long l10) {
        this.flushIfNotAvailable(10);
        this.bufferUInt64NoTag(l10);
    }
}

