/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
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
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class CodedOutputStream$OutputStreamEncoder
extends CodedOutputStream$AbstractBufferedEncoder {
    private final OutputStream out;

    public CodedOutputStream$OutputStreamEncoder(OutputStream outputStream, int n10) {
        super(n10);
        Objects.requireNonNull(outputStream, "out");
        this.out = outputStream;
    }

    private void doFlush() {
        OutputStream outputStream = this.out;
        byte[] byArray = this.buffer;
        int n10 = this.position;
        outputStream.write(byArray, 0, n10);
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
        int n10 = this.limit;
        int n11 = this.position;
        int n12 = n10 - n11;
        int n13 = byteBuffer.remaining();
        if (n12 >= n13) {
            int n14;
            byte[] byArray = this.buffer;
            byteBuffer.get(byArray, n11, n13);
            this.position = n14 = this.position + n13;
            this.totalBytesWritten = n14 = this.totalBytesWritten + n13;
        } else {
            int n15;
            Object object;
            byte[] byArray = this.buffer;
            byteBuffer.get(byArray, n11, n10 -= n11);
            n13 -= n10;
            this.position = n11 = this.limit;
            this.totalBytesWritten = n11 = this.totalBytesWritten + n10;
            this.doFlush();
            while (true) {
                n10 = this.limit;
                n11 = 0;
                if (n13 <= n10) break;
                byArray = this.buffer;
                byteBuffer.get(byArray, 0, n10);
                object = this.out;
                byArray = this.buffer;
                int n16 = this.limit;
                ((OutputStream)object).write(byArray, 0, n16);
                n10 = this.limit;
                n13 -= n10;
                this.totalBytesWritten = n11 = this.totalBytesWritten + n10;
            }
            object = this.buffer;
            byteBuffer.get((byte[])object, 0, n13);
            this.position = n13;
            this.totalBytesWritten = n15 = this.totalBytesWritten + n13;
        }
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12 = this.limit;
        int n13 = this.position;
        int n14 = n12 - n13;
        if (n14 >= n11) {
            int n15;
            byte[] byArray2 = this.buffer;
            System.arraycopy(byArray, n10, byArray2, n13, n11);
            this.position = n15 = this.position + n11;
            this.totalBytesWritten = n15 = this.totalBytesWritten + n11;
        } else {
            int n16;
            byte[] byArray3 = this.buffer;
            System.arraycopy(byArray, n10, byArray3, n13, n12 -= n13);
            n10 += n12;
            n11 -= n12;
            this.position = n13 = this.limit;
            this.totalBytesWritten = n13 = this.totalBytesWritten + n12;
            this.doFlush();
            n12 = this.limit;
            if (n11 <= n12) {
                byte[] byArray4 = this.buffer;
                n13 = 0;
                System.arraycopy(byArray, n10, byArray4, 0, n11);
                this.position = n11;
            } else {
                OutputStream outputStream = this.out;
                outputStream.write(byArray, n10, n11);
            }
            this.totalBytesWritten = n16 = this.totalBytesWritten + n11;
        }
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
     * Unable to fully structure code
     */
    public void writeStringNoTag(String var1_1) {
        var2_2 = var1_1.length() * 3;
        var3_3 = CodedOutputStream.computeUInt32SizeNoTag(var2_2);
        var4_4 = var3_3 + var2_2;
        var5_5 = this.limit;
        if (var4_4 <= var5_5) ** GOTO lbl19
        var6_6 = new byte[var2_2];
        var4_4 = 0;
        var2_2 = Utf8.encode(var1_1, var6_6, 0, var2_2);
        this.writeUInt32NoTag(var2_2);
        this.writeLazy(var6_6, 0, var2_2);
        return;
lbl19:
        // 1 sources

        var2_2 = this.position;
        if (var4_4 <= (var5_5 -= var2_2)) ** GOTO lbl23
        this.doFlush();
lbl23:
        // 2 sources

        var2_2 = var1_1.length();
        var2_2 = CodedOutputStream.computeUInt32SizeNoTag(var2_2);
        var4_4 = this.position;
        if (var2_2 != var3_3) ** GOTO lbl45
        var3_3 = var4_4 + var2_2;
        this.position = var3_3;
        var7_8 = this.buffer;
        var8_9 = this.limit - var3_3;
        var3_3 = Utf8.encode(var1_1, var7_8, var3_3, var8_9);
        this.position = var4_4;
        var5_5 = var3_3 - var4_4 - var2_2;
        this.bufferUInt32NoTag(var5_5);
        this.position = var3_3;
        ** GOTO lbl55
lbl45:
        // 1 sources

        var5_5 = Utf8.encodedLength(var1_1);
        this.bufferUInt32NoTag(var5_5);
        var9_10 = this.buffer;
        var3_3 = this.position;
        var2_2 = Utf8.encode(var1_1, var9_10, var3_3, var5_5);
        this.position = var2_2;
lbl55:
        // 2 sources

        var2_2 = this.totalBytesWritten + var5_5;
        try {
            this.totalBytesWritten = var2_2;
        }
        catch (ArrayIndexOutOfBoundsException var9_11) {
            var6_7 = new CodedOutputStream$OutOfSpaceException(var9_11);
            throw var6_7;
        }
        catch (Utf8$UnpairedSurrogateException var9_12) {
            var3_3 = this.totalBytesWritten;
            var5_5 = this.position - var4_4;
            var3_3 -= var5_5;
            this.totalBytesWritten = var3_3;
            this.position = var4_4;
            throw var9_12;
            {
                catch (Utf8$UnpairedSurrogateException var9_13) {
                    this.inefficientWriteStringNoTag(var1_1, var9_13);
                }
            }
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

