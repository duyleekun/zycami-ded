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
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public final class BinaryWriter$UnsafeDirectWriter
extends BinaryWriter {
    private ByteBuffer buffer;
    private long bufferOffset;
    private long limitMinusOne;
    private long pos;

    public BinaryWriter$UnsafeDirectWriter(BufferAllocator bufferAllocator, int n10) {
        super(bufferAllocator, n10, null);
        this.nextBuffer();
    }

    public static /* synthetic */ boolean access$000() {
        return BinaryWriter$UnsafeDirectWriter.isSupported();
    }

    private int bufferPos() {
        long l10 = this.pos;
        long l11 = this.bufferOffset;
        return (int)(l10 - l11);
    }

    private int bytesWrittenToCurrentBuffer() {
        long l10 = this.limitMinusOne;
        long l11 = this.pos;
        return (int)(l10 - l11);
    }

    private static boolean isSupported() {
        return UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    private void nextBuffer() {
        AllocatedBuffer allocatedBuffer = this.newDirectBuffer();
        this.nextBuffer(allocatedBuffer);
    }

    private void nextBuffer(int n10) {
        AllocatedBuffer allocatedBuffer = this.newDirectBuffer(n10);
        this.nextBuffer(allocatedBuffer);
    }

    private void nextBuffer(AllocatedBuffer object) {
        boolean bl2 = ((AllocatedBuffer)object).hasNioBuffer();
        if (bl2) {
            ByteBuffer byteBuffer = ((AllocatedBuffer)object).nioBuffer();
            boolean bl3 = byteBuffer.isDirect();
            if (bl3) {
                long l10;
                this.finishCurrentBuffer();
                this.buffers.addFirst(object);
                this.buffer = byteBuffer;
                int n10 = byteBuffer.capacity();
                byteBuffer.limit(n10);
                this.buffer.position(0);
                this.bufferOffset = l10 = UnsafeUtil.addressOffset(this.buffer);
                long l11 = this.buffer.limit() + -1;
                this.limitMinusOne = l10 += l11;
                this.pos = l10;
                return;
            }
            object = new RuntimeException("Allocator returned non-direct buffer");
            throw object;
        }
        object = new RuntimeException("Allocated buffer does not have NIO buffer");
        throw object;
    }

    private int spaceLeft() {
        return this.bufferPos() + 1;
    }

    private void writeVarint32FiveBytes(int n10) {
        long l10;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 28);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 21 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, (byte)n10);
    }

    private void writeVarint32FourBytes(int n10) {
        long l10;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 21);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, (byte)n10);
    }

    private void writeVarint32OneByte(int n10) {
        long l10;
        long l11 = this.pos;
        this.pos = l10 = l11 - 1L;
        n10 = (byte)n10;
        UnsafeUtil.putByte(l11, (byte)n10);
    }

    private void writeVarint32ThreeBytes(int n10) {
        long l10;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 14);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, (byte)n10);
    }

    private void writeVarint32TwoBytes(int n10) {
        long l10;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 7);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(l11, (byte)n10);
    }

    private void writeVarint64EightBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 49);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 42;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64FiveBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 28);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 21;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64FourBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 21);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 14;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64NineBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 56);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 49;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 42 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64OneByte(long l10) {
        long l11;
        long l12 = this.pos;
        this.pos = l11 = l12 - 1L;
        byte by2 = (byte)l10;
        UnsafeUtil.putByte(l12, by2);
    }

    private void writeVarint64SevenBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 42);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 35;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64SixBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 35);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 28;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64TenBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 63);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 56;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 49 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 42 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64ThreeBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)((int)l10 >>> 14);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 7;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(l12, by3);
    }

    private void writeVarint64TwoBytes(long l10) {
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 7);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)((int)l10 & 0x7F | 0x80);
        UnsafeUtil.putByte(l12, by3);
    }

    public void finishCurrentBuffer() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            long l10;
            int n10 = this.totalDoneBytes;
            int n11 = this.bytesWrittenToCurrentBuffer();
            this.totalDoneBytes = n10 += n11;
            byteBuffer = this.buffer;
            n11 = this.bufferPos() + 1;
            byteBuffer.position(n11);
            n10 = 0;
            byteBuffer = null;
            this.buffer = null;
            this.pos = l10 = 0L;
            this.limitMinusOne = l10;
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

    public void write(byte by2) {
        long l10;
        long l11 = this.pos;
        this.pos = l10 = l11 - 1L;
        UnsafeUtil.putByte(l11, by2);
    }

    public void write(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.nextBuffer(n10);
        }
        long l10 = this.pos;
        long l11 = n10;
        this.pos = l10 -= l11;
        ByteBuffer byteBuffer2 = this.buffer;
        n11 = this.bufferPos() + 1;
        byteBuffer2.position(n11);
        this.buffer.put(byteBuffer);
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12 = this.spaceLeft();
        if (n12 < n11) {
            this.nextBuffer(n11);
        }
        long l10 = this.pos;
        long l11 = n11;
        this.pos = l10 -= l11;
        ByteBuffer byteBuffer = this.buffer;
        int n13 = this.bufferPos() + 1;
        byteBuffer.position(n13);
        this.buffer.put(byArray, n10, n11);
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
        long l10;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >> 24 & 0xFF);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >> 16 & 0xFF);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >> 8 & 0xFF);
        UnsafeUtil.putByte(l11, by2);
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0xFF);
        UnsafeUtil.putByte(l11, (byte)n10);
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
        long l11;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)((int)(l10 >> 56) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 48) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 40) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 32) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 24) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 16) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 8) & 0xFF);
        UnsafeUtil.putByte(l12, by2);
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)((int)l10 & 0xFF);
        UnsafeUtil.putByte(l12, by3);
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

    public void writeLazy(ByteBuffer object) {
        int n10 = ((Buffer)object).remaining();
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.totalDoneBytes = n11 = this.totalDoneBytes + n10;
            ArrayDeque arrayDeque = this.buffers;
            object = AllocatedBuffer.wrap((ByteBuffer)object);
            arrayDeque.addFirst(object);
            this.nextBuffer();
            return;
        }
        long l10 = this.pos;
        long l11 = n10;
        this.pos = l10 -= l11;
        ByteBuffer byteBuffer = this.buffer;
        n11 = this.bufferPos() + 1;
        byteBuffer.position(n11);
        this.buffer.put((ByteBuffer)object);
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
        long l10 = this.pos;
        long l11 = n11;
        this.pos = l10 -= l11;
        ByteBuffer byteBuffer = this.buffer;
        int n13 = this.bufferPos() + 1;
        byteBuffer.position(n13);
        this.buffer.put((byte[])object, n10, n11);
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
     * Could not resolve type clashes
     */
    public void writeString(String var1_1) {
        var2_2 = var1_1.length();
        this.requireSpace(var2_2);
        var2_2 = var1_1.length() + -1;
        while (true) {
            var3_3 = 128;
            var4_4 = 1L;
            if (var2_2 < 0 || (var6_5 = (int)var1_1.charAt(var2_2)) >= var3_3) break;
            var7_6 = this.pos;
            this.pos = var9_7 = var7_6 - var4_4;
            var3_3 = (byte)var6_5;
            UnsafeUtil.putByte(var7_6, (byte)var3_3);
            var2_2 += -1;
        }
        var6_5 = -1;
        if (var2_2 == var6_5) {
            return;
        }
        while (var2_2 >= 0) {
            block6: {
                block8: {
                    block7: {
                        block5: {
                            var11_8 = var1_1.charAt(var2_2);
                            if (var11_8 >= var3_3 || (var16_11 = (cfr_temp_0 = (var12_9 = this.pos) - (var14_10 = this.bufferOffset)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) < 0) break block5;
                            this.pos = var14_10 = var12_9 - var4_4;
                            var11_8 = var11_8;
                            UnsafeUtil.putByte(var12_9, var11_8);
                            break block6;
                        }
                        var17_12 = 2048;
                        if (var11_8 >= var17_12 || (var16_11 = (cfr_temp_1 = (var12_9 = this.pos) - (var14_10 = this.bufferOffset)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) <= 0) break block7;
                        this.pos = var14_10 = var12_9 - var4_4;
                        var16_11 = (byte)(var11_8 & 63 | var3_3);
                        UnsafeUtil.putByte(var12_9, (byte)var16_11);
                        var12_9 = this.pos;
                        this.pos = var14_10 = var12_9 - var4_4;
                        var11_8 = (byte)(var11_8 >>> 6 | 960);
                        UnsafeUtil.putByte(var12_9, var11_8);
                        break block6;
                    }
                    var17_12 = 55296;
                    if (var11_8 >= var17_12 && (var17_12 = 57343) >= var11_8 || (var16_11 = (cfr_temp_2 = (var12_9 = this.pos) - (var14_10 = this.bufferOffset + var4_4)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) <= 0) break block8;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var16_11 = (byte)(var11_8 & 63 | var3_3);
                    UnsafeUtil.putByte(var12_9, (byte)var16_11);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var16_11 = (byte)(var11_8 >>> 6 & 63 | var3_3);
                    UnsafeUtil.putByte(var12_9, (byte)var16_11);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var11_8 = (byte)(var11_8 >>> 12 | 480);
                    UnsafeUtil.putByte(var12_9, var11_8);
                    break block6;
                }
                var12_9 = this.pos;
                var14_10 = this.bufferOffset;
                var18_13 = 2;
                cfr_temp_3 = var12_9 - (var14_10 += var18_13);
                var17_12 = (byte)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                if (var17_12 <= 0) ** GOTO lbl83
                if (var2_2 == 0) ** GOTO lbl-1000
                var17_12 = var2_2 + -1;
                var20_14 = Character.isSurrogatePair((char)(var17_12 = (byte)var1_1.charAt(var17_12)), (char)var11_8);
                if (var20_14) {
                    var2_2 += -1;
                    var11_8 = Character.toCodePoint((char)var17_12, (char)var11_8);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var16_11 = (byte)(var11_8 & 63 | var3_3);
                    UnsafeUtil.putByte(var12_9, (byte)var16_11);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var16_11 = (byte)(var11_8 >>> 6 & 63 | var3_3);
                    UnsafeUtil.putByte(var12_9, (byte)var16_11);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var16_11 = (byte)(var11_8 >>> 12 & 63 | var3_3);
                    UnsafeUtil.putByte(var12_9, (byte)var16_11);
                    var12_9 = this.pos;
                    this.pos = var14_10 = var12_9 - var4_4;
                    var11_8 = (byte)(var11_8 >>> 18 | 240);
                    UnsafeUtil.putByte(var12_9, var11_8);
                } else lbl-1000:
                // 2 sources

                {
                    var3_3 = var2_2 + -1;
                    var1_1 = new Utf8$UnpairedSurrogateException(var3_3, var2_2);
                    throw var1_1;
lbl83:
                    // 1 sources

                    this.requireSpace(var2_2);
                    ++var2_2;
                }
            }
            var2_2 += var6_5;
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

