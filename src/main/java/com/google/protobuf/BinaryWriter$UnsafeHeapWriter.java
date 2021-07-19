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
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public final class BinaryWriter$UnsafeHeapWriter
extends BinaryWriter {
    private AllocatedBuffer allocatedBuffer;
    private byte[] buffer;
    private long limit;
    private long limitMinusOne;
    private long offset;
    private long offsetMinusOne;
    private long pos;

    public BinaryWriter$UnsafeHeapWriter(BufferAllocator bufferAllocator, int n10) {
        super(bufferAllocator, n10, null);
        this.nextBuffer();
    }

    private int arrayPos() {
        return (int)this.pos;
    }

    public static boolean isSupported() {
        return UnsafeUtil.hasUnsafeArrayOperations();
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
            long l10;
            long l11;
            this.finishCurrentBuffer();
            this.buffers.addFirst(object);
            this.allocatedBuffer = object;
            byte[] byArray = ((AllocatedBuffer)object).array();
            this.buffer = byArray;
            int n11 = ((AllocatedBuffer)object).arrayOffset();
            this.limit = l11 = (long)(((AllocatedBuffer)object).limit() + n11);
            int n12 = ((AllocatedBuffer)object).position();
            this.offset = l10 = (long)(n11 + n12);
            long l12 = 1L;
            this.offsetMinusOne = l10 -= l12;
            this.limitMinusOne = l10 = this.limit - l12;
            this.pos = l10;
            return;
        }
        object = new RuntimeException("Allocator returned non-heap buffer");
        throw object;
    }

    private void writeVarint32FiveBytes(int n10) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 28);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 21 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
    }

    private void writeVarint32FourBytes(int n10) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 21);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 14 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
    }

    private void writeVarint32OneByte(int n10) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        this.pos = l10 = l11 - 1L;
        n10 = (byte)n10;
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
    }

    private void writeVarint32ThreeBytes(int n10) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 14);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >>> 7 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
    }

    private void writeVarint32TwoBytes(int n10) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >>> 7);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
    }

    private void writeVarint64EightBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 49);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 42;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64FiveBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 28);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 21;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64FourBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 21);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 14;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64NineBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 56);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 49;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 42 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64OneByte(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        this.pos = l11 = l12 - 1L;
        byte by2 = (byte)l10;
        UnsafeUtil.putByte(byArray, l12, by2);
    }

    private void writeVarint64SevenBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 42);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 35;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64SixBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 35);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 28;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64TenBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 63);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 56;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 49 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 42 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 35 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 28 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 21 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 14 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)(l10 >>> 7 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64ThreeBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)((int)l10 >>> 14);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        l11 = l10 >>> 7;
        long l14 = 127;
        long l15 = 128L;
        by2 = (byte)((l11 &= l14) | l15);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)(l10 & l14 | l15);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    private void writeVarint64TwoBytes(long l10) {
        long l11;
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)(l10 >>> 7);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)((int)l10 & 0x7F | 0x80);
        UnsafeUtil.putByte(byArray, l12, by3);
    }

    public int bytesWrittenToCurrentBuffer() {
        long l10 = this.limitMinusOne;
        long l11 = this.pos;
        return (int)(l10 - l11);
    }

    public void finishCurrentBuffer() {
        AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
        if (allocatedBuffer != null) {
            long l10;
            int n10 = this.totalDoneBytes;
            int n11 = this.bytesWrittenToCurrentBuffer();
            this.totalDoneBytes = n10 += n11;
            allocatedBuffer = this.allocatedBuffer;
            n11 = this.arrayPos();
            AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
            int n12 = allocatedBuffer2.arrayOffset();
            n11 = n11 - n12 + 1;
            allocatedBuffer.position(n11);
            n10 = 0;
            allocatedBuffer = null;
            this.allocatedBuffer = null;
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

    public int spaceLeft() {
        long l10 = this.pos;
        long l11 = this.offsetMinusOne;
        return (int)(l10 - l11);
    }

    public void write(byte by2) {
        long l10;
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        this.pos = l10 = l11 - 1L;
        UnsafeUtil.putByte(byArray, l11, by2);
    }

    public void write(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        this.requireSpace(n10);
        long l10 = this.pos;
        long l11 = n10;
        this.pos = l10 -= l11;
        byte[] byArray = this.buffer;
        int n11 = this.arrayPos() + 1;
        byteBuffer.get(byArray, n11, n10);
    }

    public void write(byte[] object, int n10, int n11) {
        int n12;
        int n13;
        int n14 = 1;
        if (n10 >= 0 && (n13 = n10 + n11) <= (n12 = ((byte[])object).length)) {
            this.requireSpace(n11);
            long l10 = this.pos;
            long l11 = n11;
            this.pos = l10 -= l11;
            byte[] byArray = this.buffer;
            n12 = this.arrayPos() + n14;
            System.arraycopy(object, n10, byArray, n12, n11);
            return;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        object = n10;
        objectArray[n14] = object;
        Integer n15 = n11;
        objectArray[2] = n15;
        object = String.format("value.length=%d, offset=%d, length=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
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
        byte[] byArray = this.buffer;
        long l11 = this.pos;
        long l12 = 1L;
        this.pos = l10 = l11 - l12;
        byte by2 = (byte)(n10 >> 24 & 0xFF);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >> 16 & 0xFF);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l10 = l11 - l12;
        by2 = (byte)(n10 >> 8 & 0xFF);
        UnsafeUtil.putByte(byArray, l11, by2);
        byArray = this.buffer;
        l11 = this.pos;
        this.pos = l12 = l11 - l12;
        n10 = (byte)(n10 & 0xFF);
        UnsafeUtil.putByte(byArray, l11, (byte)n10);
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
        byte[] byArray = this.buffer;
        long l12 = this.pos;
        long l13 = 1L;
        this.pos = l11 = l12 - l13;
        byte by2 = (byte)((int)(l10 >> 56) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 48) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 40) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 32) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 24) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 16) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l11 = l12 - l13;
        by2 = (byte)((int)(l10 >> 8) & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by2);
        byArray = this.buffer;
        l12 = this.pos;
        this.pos = l13 = l12 - l13;
        byte by3 = (byte)((int)l10 & 0xFF);
        UnsafeUtil.putByte(byArray, l12, by3);
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
            object = this.buffers;
            AllocatedBuffer allocatedBuffer = AllocatedBuffer.wrap(byteBuffer);
            ((ArrayDeque)object).addFirst(allocatedBuffer);
            this.nextBuffer();
        }
        long l10 = this.pos;
        long l11 = n10;
        this.pos = l10 -= l11;
        object = this.buffer;
        int n12 = this.arrayPos() + 1;
        byteBuffer.get((byte[])object, n12, n10);
    }

    public void writeLazy(byte[] object, int n10, int n11) {
        int n12;
        int n13;
        int n14 = 1;
        if (n10 >= 0 && (n13 = n10 + n11) <= (n12 = ((byte[])object).length)) {
            n13 = this.spaceLeft();
            if (n13 < n11) {
                this.totalDoneBytes = n14 = this.totalDoneBytes + n11;
                ArrayDeque arrayDeque = this.buffers;
                object = AllocatedBuffer.wrap(object, n10, n11);
                arrayDeque.addFirst(object);
                this.nextBuffer();
                return;
            }
            long l10 = this.pos;
            long l11 = n11;
            this.pos = l10 -= l11;
            byte[] byArray = this.buffer;
            n12 = this.arrayPos() + n14;
            System.arraycopy(object, n10, byArray, n12, n11);
            return;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        object = n10;
        objectArray[n14] = object;
        Integer n15 = n11;
        objectArray[2] = n15;
        object = String.format("value.length=%d, offset=%d, length=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
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
            var7_6 = this.buffer;
            var8_7 = this.pos;
            this.pos = var4_4 = var8_7 - var4_4;
            var10_8 = (byte)var6_5;
            UnsafeUtil.putByte(var7_6, var8_7, var10_8);
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
                            var11_9 = var1_1.charAt(var2_2);
                            if (var11_9 >= var3_3 || (var16_12 = (cfr_temp_0 = (var12_10 = this.pos) - (var14_11 = this.offsetMinusOne)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) <= 0) break block5;
                            var17_13 = this.buffer;
                            this.pos = var18_14 = var12_10 - var4_4;
                            var11_9 = var11_9;
                            UnsafeUtil.putByte(var17_13, var12_10, var11_9);
                            break block6;
                        }
                        var20_15 = 2048;
                        if (var11_9 >= var20_15 || (var16_12 = (cfr_temp_1 = (var12_10 = this.pos) - (var14_11 = this.offset)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) <= 0) break block7;
                        var17_13 = this.buffer;
                        this.pos = var18_14 = var12_10 - var4_4;
                        var21_16 = (byte)(var11_9 & 63 | var3_3);
                        UnsafeUtil.putByte(var17_13, var12_10, var21_16);
                        var22_17 = this.buffer;
                        var23_18 = this.pos;
                        this.pos = var18_14 = var23_18 - var4_4;
                        var11_9 = (byte)(var11_9 >>> 6 | 960);
                        UnsafeUtil.putByte(var22_17, var23_18, var11_9);
                        break block6;
                    }
                    var20_15 = 55296;
                    if (var11_9 >= var20_15 && (var20_15 = 57343) >= var11_9 || (var16_12 = (cfr_temp_2 = (var12_10 = this.pos) - (var14_11 = this.offset + var4_4)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) <= 0) break block8;
                    var17_13 = this.buffer;
                    this.pos = var18_14 = var12_10 - var4_4;
                    var21_16 = (byte)(var11_9 & 63 | var3_3);
                    UnsafeUtil.putByte(var17_13, var12_10, var21_16);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var21_16 = (byte)(var11_9 >>> 6 & 63 | var3_3);
                    UnsafeUtil.putByte(var22_17, var23_18, var21_16);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var11_9 = (byte)(var11_9 >>> 12 | 480);
                    UnsafeUtil.putByte(var22_17, var23_18, var11_9);
                    break block6;
                }
                var12_10 = this.pos;
                var14_11 = this.offset;
                var25_19 = 2;
                cfr_temp_3 = var12_10 - (var14_11 += var25_19);
                var20_15 = (byte)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                if (var20_15 <= 0) ** GOTO lbl94
                if (var2_2 == 0) ** GOTO lbl-1000
                var20_15 = var2_2 + -1;
                var27_20 = Character.isSurrogatePair((char)(var20_15 = (byte)var1_1.charAt(var20_15)), (char)var11_9);
                if (var27_20) {
                    var2_2 += -1;
                    var11_9 = Character.toCodePoint((char)var20_15, (char)var11_9);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var21_16 = (byte)(var11_9 & 63 | var3_3);
                    UnsafeUtil.putByte(var22_17, var23_18, var21_16);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var21_16 = (byte)(var11_9 >>> 6 & 63 | var3_3);
                    UnsafeUtil.putByte(var22_17, var23_18, var21_16);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var21_16 = (byte)(var11_9 >>> 12 & 63 | var3_3);
                    UnsafeUtil.putByte(var22_17, var23_18, var21_16);
                    var22_17 = this.buffer;
                    var23_18 = this.pos;
                    this.pos = var18_14 = var23_18 - var4_4;
                    var11_9 = (byte)(var11_9 >>> 18 | 240);
                    UnsafeUtil.putByte(var22_17, var23_18, var11_9);
                } else lbl-1000:
                // 2 sources

                {
                    var3_3 = var2_2 + -1;
                    var1_1 = new Utf8$UnpairedSurrogateException(var3_3, var2_2);
                    throw var1_1;
lbl94:
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

