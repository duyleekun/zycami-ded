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
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;

public final class BinaryWriter$SafeDirectWriter
extends BinaryWriter {
    private ByteBuffer buffer;
    private int limitMinusOne;
    private int pos;

    public BinaryWriter$SafeDirectWriter(BufferAllocator bufferAllocator, int n10) {
        super(bufferAllocator, n10, null);
        this.nextBuffer();
    }

    private int bytesWrittenToCurrentBuffer() {
        int n10 = this.limitMinusOne;
        int n11 = this.pos;
        return n10 - n11;
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
            Object object2 = ((AllocatedBuffer)object).nioBuffer();
            boolean bl3 = ((ByteBuffer)object2).isDirect();
            if (bl3) {
                this.finishCurrentBuffer();
                this.buffers.addFirst(object);
                this.buffer = object2;
                int n10 = ((Buffer)object2).capacity();
                ((ByteBuffer)object2).limit(n10);
                this.buffer.position(0);
                object = this.buffer;
                object2 = ByteOrder.LITTLE_ENDIAN;
                ((ByteBuffer)object).order((ByteOrder)object2);
                this.limitMinusOne = n10 = this.buffer.limit() + -1;
                this.pos = n10;
                return;
            }
            object = new RuntimeException("Allocator returned non-direct buffer");
            throw object;
        }
        object = new RuntimeException("Allocated buffer does not have NIO buffer");
        throw object;
    }

    private int spaceLeft() {
        return this.pos + 1;
    }

    private void writeVarint32FiveBytes(int n10) {
        int n11;
        ByteBuffer byteBuffer = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        n11 = (byte)(n10 >>> 28);
        byteBuffer.put(n12, (byte)n11);
        int n13 = this.pos + -4;
        this.pos = n13++;
        ByteBuffer byteBuffer2 = this.buffer;
        n11 = (n10 >>> 21 & 0x7F | 0x80) << 24;
        int n14 = (n10 >>> 14 & 0x7F | 0x80) << 16;
        n11 |= n14;
        n14 = (n10 >>> 7 & 0x7F | 0x80) << 8;
        n10 = n10 & 0x7F | 0x80 | (n11 |= n14);
        byteBuffer2.putInt(n13, n10);
    }

    private void writeVarint32FourBytes(int n10) {
        int n11 = this.pos + -4;
        this.pos = n11++;
        ByteBuffer byteBuffer = this.buffer;
        int n12 = (0xFE00000 & n10) << 3;
        int n13 = (0x1FC000 & n10 | 0x200000) << 2;
        n12 |= n13;
        n13 = (n10 & 0x3F80 | 0x4000) << 1;
        n10 = n10 & 0x7F | 0x80 | (n12 |= n13);
        byteBuffer.putInt(n11, n10);
    }

    private void writeVarint32OneByte(int n10) {
        int n11;
        ByteBuffer byteBuffer = this.buffer;
        int n12 = this.pos;
        this.pos = n11 = n12 + -1;
        n10 = (byte)n10;
        byteBuffer.put(n12, (byte)n10);
    }

    private void writeVarint32ThreeBytes(int n10) {
        int n11;
        this.pos = n11 = this.pos + -3;
        ByteBuffer byteBuffer = this.buffer;
        int n12 = (0x1FC000 & n10) << 10;
        int n13 = (n10 & 0x3F80 | 0x4000) << 9;
        n10 = (n10 & 0x7F | 0x80) << 8 | (n12 |= n13);
        byteBuffer.putInt(n11, n10);
    }

    private void writeVarint32TwoBytes(int n10) {
        int n11 = this.pos + -2;
        this.pos = n11++;
        ByteBuffer byteBuffer = this.buffer;
        int n12 = (n10 & 0x3F80) << 1;
        n10 = (short)(n10 & 0x7F | 0x80 | n12);
        byteBuffer.putShort(n11, (short)n10);
    }

    private void writeVarint64EightBytes(long l10) {
        int n10;
        this.pos = n10 = this.pos + -8;
        ByteBuffer byteBuffer = this.buffer;
        int n11 = 1;
        long l11 = (0xFE000000000000L & l10) << 7;
        long l12 = (0x1FC0000000000L & l10 | 0x2000000000000L) << 6;
        l11 |= l12;
        l12 = (0x3F800000000L & l10 | 0x40000000000L) << 5;
        l11 |= l12;
        l12 = (0x7F0000000L & l10 | 0x800000000L) << 4;
        l11 |= l12;
        l12 = (0xFE00000L & l10 | 0x10000000L) << 3;
        l11 |= l12;
        l12 = (0x1FC000L & l10 | 0x200000L) << 2;
        l11 |= l12;
        l12 = (0x3F80L & l10 | 0x4000L) << n11;
        long l13 = l11 | l12;
        l10 = l10 & (long)127 | 0x80L | l13;
        byteBuffer.putLong(n10 += n11, l10);
    }

    private void writeVarint64EightBytesWithSign(long l10) {
        int n10;
        this.pos = n10 = this.pos + -8;
        ByteBuffer byteBuffer = this.buffer;
        int n11 = 1;
        long l11 = (0xFE000000000000L & l10 | 0x100000000000000L) << 7;
        long l12 = (0x1FC0000000000L & l10 | 0x2000000000000L) << 6;
        l11 |= l12;
        l12 = (0x3F800000000L & l10 | 0x40000000000L) << 5;
        l11 |= l12;
        l12 = (0x7F0000000L & l10 | 0x800000000L) << 4;
        l11 |= l12;
        l12 = (0xFE00000L & l10 | 0x10000000L) << 3;
        l11 |= l12;
        l12 = (0x1FC000L & l10 | 0x200000L) << 2;
        l11 |= l12;
        l12 = (0x3F80L & l10 | 0x4000L) << n11;
        long l13 = l11 | l12;
        l10 = l10 & (long)127 | 0x80L | l13;
        byteBuffer.putLong(n10 += n11, l10);
    }

    private void writeVarint64FiveBytes(long l10) {
        int n10;
        this.pos = n10 = this.pos + -5;
        ByteBuffer byteBuffer = this.buffer;
        long l11 = (0x7F0000000L & l10) << 28;
        long l12 = (0xFE00000L & l10 | 0x10000000L) << 27;
        l11 |= l12;
        l12 = (0x1FC000L & l10 | 0x200000L) << 26;
        l11 |= l12;
        l12 = (0x3F80L & l10 | 0x4000L) << 25;
        l10 = (l10 & (long)127 | 0x80L) << 24 | (l11 |= l12);
        byteBuffer.putLong(n10 += -2, l10);
    }

    private void writeVarint64FourBytes(long l10) {
        int n10 = (int)l10;
        this.writeVarint32FourBytes(n10);
    }

    private void writeVarint64NineBytes(long l10) {
        ByteBuffer byteBuffer = this.buffer;
        int n10 = this.pos;
        byte by2 = n10 + -1;
        this.pos = by2;
        by2 = (byte)(l10 >>> 56);
        byteBuffer.put(n10, by2);
        this.writeVarint64EightBytesWithSign(l10 &= 0xFFFFFFFFFFFFFFL);
    }

    private void writeVarint64OneByte(long l10) {
        int n10 = (int)l10;
        this.writeVarint32OneByte(n10);
    }

    private void writeVarint64SevenBytes(long l10) {
        int n10;
        this.pos = n10 = this.pos + -7;
        ByteBuffer byteBuffer = this.buffer;
        long l11 = (0x1FC0000000000L & l10) << 14;
        long l12 = (0x3F800000000L & l10 | 0x40000000000L) << 13;
        l11 |= l12;
        l12 = (0x7F0000000L & l10 | 0x800000000L) << 12;
        l11 |= l12;
        l12 = (0xFE00000L & l10 | 0x10000000L) << 11;
        l11 |= l12;
        l12 = (0x1FC000L & l10 | 0x200000L) << 10;
        l11 |= l12;
        l12 = (0x3F80L & l10 | 0x4000L) << 9;
        l10 = (l10 & (long)127 | 0x80L) << 8 | (l11 |= l12);
        byteBuffer.putLong(n10, l10);
    }

    private void writeVarint64SixBytes(long l10) {
        int n10;
        this.pos = n10 = this.pos + -6;
        ByteBuffer byteBuffer = this.buffer;
        long l11 = (0x3F800000000L & l10) << 21;
        long l12 = (0x7F0000000L & l10 | 0x800000000L) << 20;
        l11 |= l12;
        l12 = (0xFE00000L & l10 | 0x10000000L) << 19;
        l11 |= l12;
        l12 = (0x1FC000L & l10 | 0x200000L) << 18;
        l11 |= l12;
        l12 = (0x3F80L & l10 | 0x4000L) << 17;
        l10 = (l10 & (long)127 | 0x80L) << 16 | (l11 |= l12);
        byteBuffer.putLong(n10 += -1, l10);
    }

    private void writeVarint64TenBytes(long l10) {
        ByteBuffer byteBuffer = this.buffer;
        int n10 = this.pos;
        byte by2 = n10 + -1;
        this.pos = by2;
        by2 = (byte)(l10 >>> 63);
        byteBuffer.put(n10, by2);
        byteBuffer = this.buffer;
        n10 = this.pos;
        by2 = n10 + -1;
        this.pos = by2;
        by2 = (byte)(l10 >>> 56 & (long)127 | 0x80L);
        byteBuffer.put(n10, by2);
        this.writeVarint64EightBytesWithSign(l10 &= 0xFFFFFFFFFFFFFFL);
    }

    private void writeVarint64ThreeBytes(long l10) {
        int n10 = (int)l10;
        this.writeVarint32ThreeBytes(n10);
    }

    private void writeVarint64TwoBytes(long l10) {
        int n10 = (int)l10;
        this.writeVarint32TwoBytes(n10);
    }

    public void finishCurrentBuffer() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            int n10 = this.totalDoneBytes;
            int n11 = this.bytesWrittenToCurrentBuffer();
            this.totalDoneBytes = n10 += n11;
            byteBuffer = this.buffer;
            n11 = this.pos + 1;
            byteBuffer.position(n11);
            this.buffer = null;
            n10 = 0;
            byteBuffer = null;
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

    public void write(byte by2) {
        int n10;
        ByteBuffer byteBuffer = this.buffer;
        int n11 = this.pos;
        this.pos = n10 = n11 + -1;
        byteBuffer.put(n11, by2);
    }

    public void write(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        int n11 = this.spaceLeft();
        if (n11 < n10) {
            this.nextBuffer(n10);
        }
        n11 = this.pos - n10;
        this.pos = n11++;
        ByteBuffer byteBuffer2 = this.buffer;
        byteBuffer2.position(n11);
        this.buffer.put(byteBuffer);
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12 = this.spaceLeft();
        if (n12 < n11) {
            this.nextBuffer(n11);
        }
        n12 = this.pos - n11;
        this.pos = n12++;
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.position(n12);
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
        int n11 = this.pos + -4;
        this.pos = n11++;
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.putInt(n11, n10);
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
        int n10 = this.pos + -8;
        this.pos = n10++;
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.putLong(n10, l10);
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
        n11 = this.pos - n10;
        this.pos = n11++;
        ByteBuffer byteBuffer = this.buffer;
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
        n12 = this.pos - n11;
        this.pos = n12++;
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.position(n12);
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
        var2_2 = var1_1.length();
        var3_3 = 1;
        this.pos = var4_4 = this.pos - (var2_2 -= var3_3);
        while (true) {
            var4_4 = 128;
            if (var2_2 < 0 || (var5_5 = (int)var1_1.charAt(var2_2)) >= var4_4) break;
            var6_6 = this.buffer;
            var7_7 = this.pos + var2_2;
            var5_5 = (byte)var5_5;
            var6_6.put((int)var7_7, (byte)var5_5);
            var2_2 += -1;
        }
        var5_5 = -1;
        if (var2_2 == var5_5) {
            this.pos = var8_8 = this.pos - var3_3;
            return;
        }
        var7_7 = this.pos + var2_2;
        this.pos = var7_7;
        while (var2_2 >= 0) {
            block6: {
                block8: {
                    block7: {
                        block5: {
                            var7_7 = (byte)var1_1.charAt(var2_2);
                            if (var7_7 >= var4_4 || (var9_9 = this.pos) < 0) break block5;
                            var10_10 = this.buffer;
                            this.pos = var11_11 = var9_9 + -1;
                            var7_7 = var7_7;
                            var10_10.put((int)var9_9, var7_7);
                            break block6;
                        }
                        var9_9 = 2048;
                        if (var7_7 >= var9_9 || (var9_9 = this.pos) <= 0) break block7;
                        var10_10 = this.buffer;
                        this.pos = var11_11 = var9_9 + -1;
                        var11_11 = (byte)(var7_7 & 63 | var4_4);
                        var10_10.put((int)var9_9, (byte)var11_11);
                        var12_12 = this.buffer;
                        var13_13 = this.pos;
                        this.pos = var11_11 = var13_13 + -1;
                        var7_7 = (byte)(var7_7 >>> 6 | 960);
                        var12_12.put((int)var13_13, var7_7);
                        break block6;
                    }
                    var9_9 = 55296;
                    if (var7_7 >= var9_9 && (var9_9 = 57343) >= var7_7 || (var9_9 = this.pos) <= var3_3) break block8;
                    var10_10 = this.buffer;
                    this.pos = var11_11 = var9_9 + -1;
                    var11_11 = (byte)(var7_7 & 63 | var4_4);
                    var10_10.put((int)var9_9, (byte)var11_11);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var11_11 = (byte)(var7_7 >>> 6 & 63 | var4_4);
                    var12_12.put((int)var13_13, (byte)var11_11);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var7_7 = (byte)(var7_7 >>> 12 | 480);
                    var12_12.put((int)var13_13, var7_7);
                    break block6;
                }
                var9_9 = this.pos;
                var13_13 = 2;
                if (var9_9 <= var13_13) ** GOTO lbl105
                if (var2_2 == 0) ** GOTO lbl-1000
                var9_9 = var2_2 + -1;
                var13_13 = (byte)Character.isSurrogatePair((char)(var9_9 = (byte)var1_1.charAt(var9_9)), (char)var7_7);
                if (var13_13 != 0) {
                    var2_2 += -1;
                    var7_7 = Character.toCodePoint((char)var9_9, (char)var7_7);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var11_11 = (byte)(var7_7 & 63 | var4_4);
                    var12_12.put((int)var13_13, (byte)var11_11);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var11_11 = (byte)(var7_7 >>> 6 & 63 | var4_4);
                    var12_12.put((int)var13_13, (byte)var11_11);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var11_11 = (byte)(var7_7 >>> 12 & 63 | var4_4);
                    var12_12.put((int)var13_13, (byte)var11_11);
                    var12_12 = this.buffer;
                    var13_13 = this.pos;
                    this.pos = var11_11 = var13_13 + -1;
                    var7_7 = (byte)(var7_7 >>> 18 | 240);
                    var12_12.put((int)var13_13, var7_7);
                } else lbl-1000:
                // 2 sources

                {
                    var3_3 = var2_2 + -1;
                    var1_1 = new Utf8$UnpairedSurrogateException(var3_3, var2_2);
                    throw var1_1;
lbl105:
                    // 1 sources

                    this.requireSpace(var2_2);
                    ++var2_2;
                }
            }
            var2_2 += var5_5;
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

