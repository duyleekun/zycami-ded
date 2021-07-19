/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import com.google.protobuf.BinaryWriter;
import com.google.protobuf.BufferAllocator;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Schema;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public final class BinaryWriter$SafeHeapWriter
extends BinaryWriter {
    private AllocatedBuffer allocatedBuffer;
    private byte[] buffer;
    private int limit;
    private int limitMinusOne;
    private int offset;
    private int offsetMinusOne;
    private int pos;

    public BinaryWriter$SafeHeapWriter(BufferAllocator bufferAllocator, int n10) {
        super(bufferAllocator, n10, null);
        this.nextBuffer();
    }

    private void nextBuffer() {
        AllocatedBuffer allocatedBuffer = this.newHeapBuffer();
        this.nextBuffer(allocatedBuffer);
    }

    private void nextBuffer(int n10) {
        AllocatedBuffer allocatedBuffer = this.newHeapBuffer(n10);
        this.nextBuffer(allocatedBuffer);
    }

    private void nextBuffer(AllocatedBuffer object) {
        boolean n10 = ((AllocatedBuffer)object).hasArray();
        if (n10) {
            int n11;
            int n12;
            int n13;
            this.finishCurrentBuffer();
            this.buffers.addFirst(object);
            this.allocatedBuffer = object;
            byte[] byArray = ((AllocatedBuffer)object).array();
            this.buffer = byArray;
            int n14 = ((AllocatedBuffer)object).arrayOffset();
            this.limit = n13 = ((AllocatedBuffer)object).limit() + n14;
            int n15 = ((AllocatedBuffer)object).position();
            this.offset = n12 = n14 + n15;
            this.offsetMinusOne = n11 = n12 + -1;
            this.limitMinusOne = n15 = this.limit + -1;
            this.pos = n15;
            return;
        }
        object = new RuntimeException("Allocator returned non-heap buffer");
        throw object;
    }

    private void writeVarint32FiveBytes(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 28);
        this.pos = n12 = n11 + -1;
        byArray[n11] = by2 = (byte)(n10 >>> 21 & 0x7F | 0x80);
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        this.pos = n12 = n11 + -1;
        byArray[n11] = by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        this.pos = n11 = n12 + -1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0x7F | 0x80));
    }

    private void writeVarint32FourBytes(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 21);
        this.pos = n12 = n11 + -1;
        byArray[n11] = by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        this.pos = n12 = n11 + -1;
        byArray[n11] = n10 = (int)((byte)(n10 & 0x7F | 0x80));
    }

    private void writeVarint32OneByte(int n10) {
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = n10 = (int)((byte)n10);
    }

    private void writeVarint32ThreeBytes(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 14);
        this.pos = n12 = n11 + -1;
        byArray[n11] = by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        this.pos = n11 = n12 + -1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0x7F | 0x80));
    }

    private void writeVarint32TwoBytes(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >>> 7);
        this.pos = n12 = n11 + -1;
        byArray[n11] = n10 = (int)((byte)(n10 & 0x7F | 0x80));
    }

    private void writeVarint64EightBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 49);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 42;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 35 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 28 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 21 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64FiveBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 28);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 21;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64FourBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 21);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 14;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64NineBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 56);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 49;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 42 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 35 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 28 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 21 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64OneByte(long l10) {
        byte by2;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2 = (byte)l10;
    }

    private void writeVarint64SevenBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 42);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 35;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 28 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 21 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64SixBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 35);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 28;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 21 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64TenBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 63);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 56;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 49 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 42 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 35 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 28 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 21 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)(l10 >>> 14 & l12 | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 7 & l12 | l13);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64ThreeBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)((int)l10 >>> 14);
        this.pos = n11 = n10 + -1;
        long l11 = l10 >>> 7;
        long l12 = 127;
        long l13 = 128L;
        byArray[n10] = by3 = (byte)((l11 &= l12) | l13);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2 = (byte)(l10 & l12 | l13);
    }

    private void writeVarint64TwoBytes(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)(l10 >>> 7);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)((int)l10 & 0x7F | 0x80);
    }

    public int bytesWrittenToCurrentBuffer() {
        int n10 = this.limitMinusOne;
        int n11 = this.pos;
        return n10 - n11;
    }

    public void finishCurrentBuffer() {
        AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
        if (allocatedBuffer != null) {
            int n10 = this.totalDoneBytes;
            int n11 = this.bytesWrittenToCurrentBuffer();
            this.totalDoneBytes = n10 += n11;
            allocatedBuffer = this.allocatedBuffer;
            n11 = this.pos;
            int n12 = allocatedBuffer.arrayOffset();
            n11 = n11 - n12 + 1;
            allocatedBuffer.position(n11);
            this.allocatedBuffer = null;
            n10 = 0;
            allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
        }
    }

    public int getTotalBytesWritten() {
        int n10 = this.totalDoneBytes;
        int n11 = this.bytesWrittenToCurrentBuffer();
        return n10 + n11;
    }

    public void requireSpace(int n10) {
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.nextBuffer(n10);
        }
    }

    public int spaceLeft() {
        int n10 = this.pos;
        int n11 = this.offsetMinusOne;
        return n10 - n11;
    }

    public void write(byte by2) {
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by2;
    }

    public void write(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.nextBuffer(n10);
        }
        n11 = this.pos - n10;
        this.pos = n11++;
        byte[] byArray = this.buffer;
        byteBuffer.get(byArray, n11, n10);
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12 = this.spaceLeft();
        if (n12 < n11) {
            this.nextBuffer(n11);
        }
        n12 = this.pos - n11;
        this.pos = n12++;
        byte[] byArray2 = this.buffer;
        System.arraycopy(byArray, n10, byArray2, n12, n11);
    }

    public void writeBool(int n10, boolean bl2) {
        this.requireSpace(6);
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.write(by2);
        this.writeTag(n10, 0);
    }

    public void writeBool(boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.write(by2);
    }

    public void writeBytes(int n10, ByteString serializable) {
        try {
            ((ByteString)serializable).writeToReverse(this);
            this.requireSpace(10);
            int n11 = ((ByteString)serializable).size();
            this.writeVarint32(n11);
            this.writeTag(n10, 2);
            return;
        }
        catch (IOException iOException) {
            serializable = new RuntimeException(iOException);
            throw serializable;
        }
    }

    public void writeEndGroup(int n10) {
        this.writeTag(n10, 4);
    }

    public void writeFixed32(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >> 24 & 0xFF);
        this.pos = n12 = n11 + -1;
        byArray[n11] = by2 = (byte)(n10 >> 16 & 0xFF);
        this.pos = n11 = n12 + -1;
        byArray[n12] = by2 = (byte)(n10 >> 8 & 0xFF);
        this.pos = n12 = n11 + -1;
        byArray[n11] = n10 = (int)((byte)(n10 & 0xFF));
    }

    public void writeFixed32(int n10, int n11) {
        this.requireSpace(9);
        this.writeFixed32(n11);
        this.writeTag(n10, 5);
    }

    public void writeFixed64(int n10, long l10) {
        this.requireSpace(13);
        this.writeFixed64(l10);
        this.writeTag(n10, 1);
    }

    public void writeFixed64(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)((int)(l10 >> 56) & 0xFF);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)((int)(l10 >> 48) & 0xFF);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)((int)(l10 >> 40) & 0xFF);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)((int)(l10 >> 32) & 0xFF);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)((int)(l10 >> 24) & 0xFF);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by3 = (byte)((int)(l10 >> 16) & 0xFF);
        this.pos = n10 = n11 + -1;
        byArray[n11] = by3 = (byte)((int)(l10 >> 8) & 0xFF);
        this.pos = n11 = n10 + -1;
        byArray[n10] = by2 = (byte)((int)l10 & 0xFF);
    }

    public void writeGroup(int n10, Object object) {
        this.writeTag(n10, 4);
        Protobuf.getInstance().writeTo(object, this);
        this.writeTag(n10, 3);
    }

    public void writeGroup(int n10, Object object, Schema schema) {
        this.writeTag(n10, 4);
        schema.writeTo(object, this);
        this.writeTag(n10, 3);
    }

    public void writeInt32(int n10) {
        if (n10 >= 0) {
            this.writeVarint32(n10);
        } else {
            long l10 = n10;
            this.writeVarint64(l10);
        }
    }

    public void writeInt32(int n10, int n11) {
        this.requireSpace(15);
        this.writeInt32(n11);
        this.writeTag(n10, 0);
    }

    public void writeLazy(ByteBuffer byteBuffer) {
        Object object;
        int n10 = byteBuffer.remaining();
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.totalDoneBytes = n11 = this.totalDoneBytes + n10;
            ArrayDeque arrayDeque = this.buffers;
            object = AllocatedBuffer.wrap(byteBuffer);
            arrayDeque.addFirst(object);
            this.nextBuffer();
        }
        n11 = this.pos - n10;
        this.pos = n11++;
        object = this.buffer;
        byteBuffer.get((byte[])object, n11, n10);
    }

    public void writeLazy(byte[] object, int n10, int n11) {
        int n12 = this.spaceLeft();
        if (n12 < n11) {
            this.totalDoneBytes = n12 = this.totalDoneBytes + n11;
            ArrayDeque arrayDeque = this.buffers;
            object = AllocatedBuffer.wrap(object, n10, n11);
            arrayDeque.addFirst(object);
            this.nextBuffer();
            return;
        }
        n12 = this.pos - n11;
        this.pos = n12++;
        byte[] byArray = this.buffer;
        System.arraycopy(object, n10, byArray, n12, n11);
    }

    public void writeMessage(int n10, Object object) {
        int n11 = this.getTotalBytesWritten();
        Protobuf.getInstance().writeTo(object, this);
        int n12 = this.getTotalBytesWritten() - n11;
        this.requireSpace(10);
        this.writeVarint32(n12);
        this.writeTag(n10, 2);
    }

    public void writeMessage(int n10, Object object, Schema schema) {
        int n11 = this.getTotalBytesWritten();
        schema.writeTo(object, this);
        int n12 = this.getTotalBytesWritten() - n11;
        this.requireSpace(10);
        this.writeVarint32(n12);
        this.writeTag(n10, 2);
    }

    public void writeSInt32(int n10) {
        n10 = CodedOutputStream.encodeZigZag32(n10);
        this.writeVarint32(n10);
    }

    public void writeSInt32(int n10, int n11) {
        this.requireSpace(10);
        this.writeSInt32(n11);
        this.writeTag(n10, 0);
    }

    public void writeSInt64(int n10, long l10) {
        this.requireSpace(15);
        this.writeSInt64(l10);
        this.writeTag(n10, 0);
    }

    public void writeSInt64(long l10) {
        l10 = CodedOutputStream.encodeZigZag64(l10);
        this.writeVarint64(l10);
    }

    public void writeStartGroup(int n10) {
        this.writeTag(n10, 3);
    }

    public void writeString(int n10, String string2) {
        int n11 = this.getTotalBytesWritten();
        this.writeString(string2);
        int n12 = this.getTotalBytesWritten() - n11;
        this.requireSpace(10);
        this.writeVarint32(n12);
        this.writeTag(n10, 2);
    }

    /*
     * Unable to fully structure code
     */
    public void writeString(String var1_1) {
        var2_2 = var1_1.length();
        this.requireSpace(var2_2);
        var2_2 = var1_1.length() + -1;
        this.pos = var3_3 = this.pos - var2_2;
        while (true) {
            var3_3 = 128;
            if (var2_2 < 0 || (var4_4 = (int)var1_1.charAt(var2_2)) >= var3_3) break;
            var5_5 = this.buffer;
            var6_6 = this.pos + var2_2;
            var5_5[var6_6] = var4_4 = (int)((byte)var4_4);
            var2_2 += -1;
        }
        var4_4 = -1;
        if (var2_2 == var4_4) {
            this.pos = var7_7 = this.pos + -1;
            return;
        }
        this.pos = var6_6 = this.pos + var2_2;
        while (var2_2 >= 0) {
            block6: {
                block8: {
                    block7: {
                        block5: {
                            var6_6 = var1_1.charAt(var2_2);
                            if (var6_6 >= var3_3 || (var8_8 = this.pos) <= (var9_9 = this.offsetMinusOne)) break block5;
                            var10_10 = this.buffer;
                            this.pos = var11_11 = var8_8 + -1;
                            var10_10[var8_8] = var6_6 = (int)((byte)var6_6);
                            break block6;
                        }
                        var8_8 = 2048;
                        if (var6_6 >= var8_8 || (var8_8 = this.pos) <= (var9_9 = this.offset)) break block7;
                        var10_10 = this.buffer;
                        this.pos = var11_11 = var8_8 + -1;
                        var10_10[var8_8] = var12_12 = (byte)(var6_6 & 63 | var3_3);
                        this.pos = var8_8 = var11_11 + -1;
                        var10_10[var11_11] = var6_6 = (int)((byte)(var6_6 >>> 6 | 960));
                        break block6;
                    }
                    var8_8 = 55296;
                    if (var6_6 >= var8_8 && (var8_8 = 57343) >= var6_6 || (var8_8 = this.pos) <= (var9_9 = this.offset + 1)) break block8;
                    var10_10 = this.buffer;
                    this.pos = var11_11 = var8_8 + -1;
                    var10_10[var8_8] = var12_12 = (byte)(var6_6 & 63 | var3_3);
                    this.pos = var8_8 = var11_11 + -1;
                    var10_10[var11_11] = var12_12 = (byte)(var6_6 >>> 6 & 63 | var3_3);
                    this.pos = var11_11 = var8_8 + -1;
                    var10_10[var8_8] = var6_6 = (int)((byte)(var6_6 >>> 12 | 480));
                    break block6;
                }
                var8_8 = this.pos;
                var9_9 = this.offset + 2;
                if (var8_8 <= var9_9) ** GOTO lbl69
                if (var2_2 == 0) ** GOTO lbl-1000
                var8_8 = var2_2 + -1;
                var9_9 = (int)Character.isSurrogatePair((char)(var8_8 = (int)var1_1.charAt(var8_8)), (char)var6_6);
                if (var9_9 != 0) {
                    var2_2 += -1;
                    var6_6 = Character.toCodePoint((char)var8_8, (char)var6_6);
                    var13_13 = this.buffer;
                    var9_9 = this.pos;
                    this.pos = var11_11 = var9_9 + -1;
                    var13_13[var9_9] = var12_12 = (byte)(var6_6 & 63 | var3_3);
                    this.pos = var9_9 = var11_11 + -1;
                    var13_13[var11_11] = var12_12 = (byte)(var6_6 >>> 6 & 63 | var3_3);
                    this.pos = var11_11 = var9_9 + -1;
                    var13_13[var9_9] = var12_12 = (byte)(var6_6 >>> 12 & 63 | var3_3);
                    this.pos = var9_9 = var11_11 + -1;
                    var13_13[var11_11] = var6_6 = (int)((byte)(var6_6 >>> 18 | 240));
                } else lbl-1000:
                // 2 sources

                {
                    var3_3 = var2_2 + -1;
                    var1_1 = new Utf8$UnpairedSurrogateException(var3_3, var2_2);
                    throw var1_1;
lbl69:
                    // 1 sources

                    this.requireSpace(var2_2);
                    ++var2_2;
                }
            }
            var2_2 += var4_4;
        }
    }

    public void writeTag(int n10, int n11) {
        n10 = WireFormat.makeTag(n10, n11);
        this.writeVarint32(n10);
    }

    public void writeUInt32(int n10, int n11) {
        this.requireSpace(10);
        this.writeVarint32(n11);
        this.writeTag(n10, 0);
    }

    public void writeUInt64(int n10, long l10) {
        this.requireSpace(15);
        this.writeVarint64(l10);
        this.writeTag(n10, 0);
    }

    public void writeVarint32(int n10) {
        int n11 = n10 & 0xFFFFFF80;
        if (n11 == 0) {
            this.writeVarint32OneByte(n10);
        } else {
            n11 = n10 & 0xFFFFC000;
            if (n11 == 0) {
                this.writeVarint32TwoBytes(n10);
            } else {
                n11 = 0xFFE00000 & n10;
                if (n11 == 0) {
                    this.writeVarint32ThreeBytes(n10);
                } else {
                    n11 = 0xF0000000 & n10;
                    if (n11 == 0) {
                        this.writeVarint32FourBytes(n10);
                    } else {
                        this.writeVarint32FiveBytes(n10);
                    }
                }
            }
        }
    }

    public void writeVarint64(long l10) {
        byte by2 = BinaryWriter.access$200(l10);
        switch (by2) {
            default: {
                break;
            }
            case 10: {
                this.writeVarint64TenBytes(l10);
                break;
            }
            case 9: {
                this.writeVarint64NineBytes(l10);
                break;
            }
            case 8: {
                this.writeVarint64EightBytes(l10);
                break;
            }
            case 7: {
                this.writeVarint64SevenBytes(l10);
                break;
            }
            case 6: {
                this.writeVarint64SixBytes(l10);
                break;
            }
            case 5: {
                this.writeVarint64FiveBytes(l10);
                break;
            }
            case 4: {
                this.writeVarint64FourBytes(l10);
                break;
            }
            case 3: {
                this.writeVarint64ThreeBytes(l10);
                break;
            }
            case 2: {
                this.writeVarint64TwoBytes(l10);
                break;
            }
            case 1: {
                this.writeVarint64OneByte(l10);
            }
        }
    }
}

