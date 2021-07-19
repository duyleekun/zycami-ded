/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStream$1;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;

public final class CodedInputStream$IterableDirectByteBufferDecoder
extends CodedInputStream {
    private int bufferSizeAfterCurrentLimit;
    private long currentAddress;
    private ByteBuffer currentByteBuffer;
    private long currentByteBufferLimit;
    private long currentByteBufferPos;
    private long currentByteBufferStartPos;
    private int currentLimit;
    private boolean enableAliasing;
    private boolean immutable;
    private Iterable input;
    private Iterator iterator;
    private int lastTag;
    private int startOffset;
    private int totalBufferSize;
    private int totalBytesRead;

    private CodedInputStream$IterableDirectByteBufferDecoder(Iterable object, int n10, boolean bl2) {
        super(null);
        int n11;
        this.currentLimit = n11 = -1 >>> 1;
        this.totalBufferSize = n10;
        this.input = object;
        this.iterator = object = object.iterator();
        this.immutable = bl2;
        object = null;
        this.totalBytesRead = 0;
        this.startOffset = 0;
        if (n10 == 0) {
            long l10;
            this.currentByteBuffer = object = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = l10 = 0L;
            this.currentByteBufferStartPos = l10;
            this.currentByteBufferLimit = l10;
            this.currentAddress = l10;
        } else {
            this.tryGetNextByteBuffer();
        }
    }

    public /* synthetic */ CodedInputStream$IterableDirectByteBufferDecoder(Iterable iterable, int n10, boolean bl2, CodedInputStream$1 codedInputStream$1) {
        this(iterable, n10, bl2);
    }

    private long currentRemaining() {
        long l10 = this.currentByteBufferLimit;
        long l11 = this.currentByteBufferPos;
        return l10 - l11;
    }

    private void getNextByteBuffer() {
        Iterator iterator2 = this.iterator;
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            this.tryGetNextByteBuffer();
            return;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void readRawBytesTo(byte[] byArray, int n10, int n11) {
        int n12;
        if (n11 >= 0 && n11 <= (n12 = this.remaining())) {
            Object object;
            for (n12 = n11; n12 > 0; n12 -= object) {
                long l10;
                long l11 = this.currentRemaining();
                long l12 = l11 - (l10 = 0L);
                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object == false) {
                    this.getNextByteBuffer();
                }
                object = (int)this.currentRemaining();
                object = Math.min(n12, (int)object);
                long l13 = this.currentByteBufferPos;
                int n13 = n11 - n12 + n10;
                long l14 = n13;
                long l15 = object;
                UnsafeUtil.copyMemory(l13, byArray, l14, l15);
                this.currentByteBufferPos = l11 = this.currentByteBufferPos + l15;
            }
            return;
        }
        if (n11 <= 0) {
            if (n11 == 0) {
                return;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void recomputeBufferSizeAfterLimit() {
        int n10 = this.totalBufferSize;
        int n11 = this.bufferSizeAfterCurrentLimit;
        this.totalBufferSize = n10 += n11;
        n11 = this.startOffset;
        int n12 = this.currentLimit;
        if ((n11 = n10 - n11) > n12) {
            this.bufferSizeAfterCurrentLimit = n11 -= n12;
            this.totalBufferSize = n10 -= n11;
        } else {
            n10 = 0;
            this.bufferSizeAfterCurrentLimit = 0;
        }
    }

    private int remaining() {
        int n10 = this.totalBufferSize;
        int n11 = this.totalBytesRead;
        long l10 = n10 - n11;
        long l11 = this.currentByteBufferPos;
        l10 -= l11;
        l11 = this.currentByteBufferStartPos;
        return (int)(l10 + l11);
    }

    private void skipRawVarint() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            n10 = this.readRawByte();
            if (n10 < 0) continue;
            return;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ByteBuffer slice(int n10, int n11) {
        Throwable throwable2222222;
        int n12;
        int n13;
        block4: {
            ByteBuffer byteBuffer = this.currentByteBuffer;
            n13 = byteBuffer.position();
            ByteBuffer byteBuffer2 = this.currentByteBuffer;
            n12 = byteBuffer2.limit();
            ByteBuffer byteBuffer3 = this.currentByteBuffer;
            byteBuffer3.position(n10);
            ByteBuffer byteBuffer4 = this.currentByteBuffer;
            byteBuffer4.limit(n11);
            byteBuffer4 = this.currentByteBuffer;
            byteBuffer4 = byteBuffer4.slice();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
                {
                    InvalidProtocolBufferException invalidProtocolBufferException = InvalidProtocolBufferException.truncatedMessage();
                    throw invalidProtocolBufferException;
                }
            }
            this.currentByteBuffer.position(n13);
            this.currentByteBuffer.limit(n12);
            return byteBuffer4;
        }
        this.currentByteBuffer.position(n13);
        this.currentByteBuffer.limit(n12);
        throw throwable2222222;
    }

    private void tryGetNextByteBuffer() {
        long l10;
        ByteBuffer byteBuffer;
        this.currentByteBuffer = byteBuffer = (ByteBuffer)this.iterator.next();
        int n10 = this.totalBytesRead;
        long l11 = this.currentByteBufferPos;
        long l12 = this.currentByteBufferStartPos;
        int n11 = (int)(l11 - l12);
        this.totalBytesRead = n10 += n11;
        this.currentByteBufferPos = l10 = (long)byteBuffer.position();
        this.currentByteBufferStartPos = l10;
        this.currentByteBufferLimit = l10 = (long)this.currentByteBuffer.limit();
        this.currentAddress = l10 = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentByteBufferPos = l11 = this.currentByteBufferPos + l10;
        this.currentByteBufferStartPos = l11 = this.currentByteBufferStartPos + l10;
        this.currentByteBufferLimit = l11 = this.currentByteBufferLimit + l10;
    }

    public void checkLastTagWas(int n10) {
        int n11 = this.lastTag;
        if (n11 == n10) {
            return;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void enableAliasing(boolean bl2) {
        this.enableAliasing = bl2;
    }

    public int getBytesUntilLimit() {
        int n10 = this.currentLimit;
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return -1;
        }
        n11 = this.getTotalBytesRead();
        return n10 - n11;
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public int getTotalBytesRead() {
        int n10 = this.totalBytesRead;
        int n11 = this.startOffset;
        long l10 = n10 - n11;
        long l11 = this.currentByteBufferPos;
        l10 += l11;
        l11 = this.currentByteBufferStartPos;
        return (int)(l10 - l11);
    }

    public boolean isAtEnd() {
        long l10 = this.totalBytesRead;
        long l11 = this.currentByteBufferPos;
        l10 += l11;
        l11 = this.currentByteBufferStartPos;
        int n10 = this.totalBufferSize;
        long l12 = (l10 -= l11) - (l11 = (long)n10);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void popLimit(int n10) {
        this.currentLimit = n10;
        this.recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int n10) {
        if (n10 >= 0) {
            int n11 = this.getTotalBytesRead();
            if ((n10 += n11) <= (n11 = this.currentLimit)) {
                this.currentLimit = n10;
                this.recomputeBufferSizeAfterLimit();
                return n11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() {
        long l10;
        long l11 = this.readRawVarint64();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public byte[] readByteArray() {
        int n10 = this.readRawVarint32();
        return this.readRawBytes(n10);
    }

    public ByteBuffer readByteBuffer() {
        long l10;
        long l11;
        long l12;
        int n10;
        int n11 = this.readRawVarint32();
        if (n11 > 0 && (n10 = (int)((l12 = (l11 = (long)n11) - (l10 = this.currentRemaining())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            n10 = (int)(this.immutable ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(this.enableAliasing ? 1 : 0)) != 0) {
                long l13;
                this.currentByteBufferPos = l13 = this.currentByteBufferPos + l11;
                long l14 = this.currentAddress;
                int n12 = (int)(l13 - l14 - l11);
                n11 = (int)(l13 - l14);
                return this.slice(n12, n11);
            }
            byte[] byArray = new byte[n11];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, byArray, 0L, l11);
            this.currentByteBufferPos = l10 = this.currentByteBufferPos + l11;
            return ByteBuffer.wrap(byArray);
        }
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            byte[] byArray = new byte[n11];
            this.readRawBytesTo(byArray, 0, n11);
            return ByteBuffer.wrap(byArray);
        }
        if (n11 == 0) {
            return Internal.EMPTY_BYTE_BUFFER;
        }
        if (n11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public ByteString readBytes() {
        int n10;
        int n11 = this.readRawVarint32();
        if (n11 > 0) {
            long l10 = n11;
            long l11 = this.currentByteBufferLimit;
            long l12 = this.currentByteBufferPos;
            long l13 = l10 - (l11 -= l12);
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 <= 0) {
                n10 = (int)(this.immutable ? 1 : 0);
                if (n10 != 0 && (n10 = (int)(this.enableAliasing ? 1 : 0)) != 0) {
                    l11 = this.currentAddress;
                    n10 = (int)(l12 - l11);
                    ByteString byteString = ByteString.wrap(this.slice(n10, n11 += n10));
                    this.currentByteBufferPos = l11 = this.currentByteBufferPos + l10;
                    return byteString;
                }
                byte[] byArray = new byte[n11];
                l11 = l12;
                long l14 = 0L;
                UnsafeUtil.copyMemory(l12, byArray, l14, l10);
                this.currentByteBufferPos = l11 = this.currentByteBufferPos + l10;
                return ByteString.wrap(byArray);
            }
        }
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            byte[] byArray = new byte[n11];
            this.readRawBytesTo(byArray, 0, n11);
            return ByteString.wrap(byArray);
        }
        if (n11 == 0) {
            return ByteString.EMPTY;
        }
        if (n11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public double readDouble() {
        return Double.longBitsToDouble(this.readRawLittleEndian64());
    }

    public int readEnum() {
        return this.readRawVarint32();
    }

    public int readFixed32() {
        return this.readRawLittleEndian32();
    }

    public long readFixed64() {
        return this.readRawLittleEndian64();
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readRawLittleEndian32());
    }

    public MessageLite readGroup(int n10, Parser object, ExtensionRegistryLite extensionRegistryLite) {
        int n11 = this.recursionDepth;
        int n12 = this.recursionLimit;
        if (n11 < n12) {
            this.recursionDepth = ++n11;
            object = (MessageLite)object.parsePartialFrom(this, extensionRegistryLite);
            n10 = WireFormat.makeTag(n10, 4);
            this.checkLastTagWas(n10);
            this.recursionDepth = n10 = this.recursionDepth + -1;
            return object;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void readGroup(int n10, MessageLite$Builder messageLite$Builder, ExtensionRegistryLite extensionRegistryLite) {
        int n11 = this.recursionDepth;
        int n12 = this.recursionLimit;
        if (n11 < n12) {
            this.recursionDepth = ++n11;
            messageLite$Builder.mergeFrom(this, extensionRegistryLite);
            n10 = WireFormat.makeTag(n10, 4);
            this.checkLastTagWas(n10);
            this.recursionDepth = n10 = this.recursionDepth + -1;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() {
        return this.readRawVarint32();
    }

    public long readInt64() {
        return this.readRawVarint64();
    }

    public MessageLite readMessage(Parser object, ExtensionRegistryLite extensionRegistryLite) {
        int n10 = this.readRawVarint32();
        int n11 = this.recursionDepth;
        int n12 = this.recursionLimit;
        if (n11 < n12) {
            int n13;
            n10 = this.pushLimit(n10);
            this.recursionDepth = n11 = this.recursionDepth + 1;
            object = (MessageLite)object.parsePartialFrom(this, extensionRegistryLite);
            this.checkLastTagWas(0);
            this.recursionDepth = n13 = this.recursionDepth + -1;
            this.popLimit(n10);
            return object;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public void readMessage(MessageLite$Builder messageLite$Builder, ExtensionRegistryLite extensionRegistryLite) {
        int n10 = this.readRawVarint32();
        int n11 = this.recursionDepth;
        int n12 = this.recursionLimit;
        if (n11 < n12) {
            int n13;
            n10 = this.pushLimit(n10);
            this.recursionDepth = n11 = this.recursionDepth + 1;
            messageLite$Builder.mergeFrom(this, extensionRegistryLite);
            this.checkLastTagWas(0);
            this.recursionDepth = n13 = this.recursionDepth + -1;
            this.popLimit(n10);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() {
        long l10;
        long l11 = this.currentRemaining();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.getNextByteBuffer();
        }
        l11 = this.currentByteBufferPos;
        this.currentByteBufferPos = l10 = 1L + l11;
        return UnsafeUtil.getByte(l11);
    }

    public byte[] readRawBytes(int n10) {
        long l10;
        long l11;
        long l12;
        int n11;
        if (n10 >= 0 && (n11 = (int)((l12 = (l11 = (long)n10) - (l10 = this.currentRemaining())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            byte[] byArray = new byte[n10];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, byArray, 0L, l11);
            this.currentByteBufferPos = l10 = this.currentByteBufferPos + l11;
            return byArray;
        }
        if (n10 >= 0 && n10 <= (n11 = this.remaining())) {
            byte[] byArray = new byte[n10];
            this.readRawBytesTo(byArray, 0, n10);
            return byArray;
        }
        if (n10 <= 0) {
            if (n10 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public int readRawLittleEndian32() {
        long l10;
        long l11 = this.currentRemaining();
        long l12 = l11 - (l10 = (long)4);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            l11 = this.currentByteBufferPos;
            this.currentByteBufferPos = l10 += l11;
            int n10 = UnsafeUtil.getByte(l11) & 0xFF;
            int n11 = (UnsafeUtil.getByte(1L + l11) & 0xFF) << 8;
            n10 |= n11;
            n11 = (UnsafeUtil.getByte((long)2 + l11) & 0xFF) << 16;
            return (UnsafeUtil.getByte(l11 + (long)3) & 0xFF) << 24 | (n10 |= n11);
        }
        object = this.readRawByte() & 0xFF;
        int n12 = (this.readRawByte() & 0xFF) << 8;
        object = object | n12;
        n12 = (this.readRawByte() & 0xFF) << 16;
        object = object | n12;
        n12 = (this.readRawByte() & 0xFF) << 24;
        return object | n12;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long readRawLittleEndian64() {
        long l10 = this.currentRemaining();
        long l11 = 8;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 56;
        int n11 = 32;
        int n12 = 24;
        int n13 = 16;
        int n14 = 8;
        long l13 = 255L;
        if (l12 >= 0) {
            long l14 = this.currentByteBufferPos;
            this.currentByteBufferPos = l11 += l14;
            l11 = (long)UnsafeUtil.getByte(l14) & l13;
            long l15 = 1L + l14;
            long l16 = ((long)UnsafeUtil.getByte(l15) & l13) << n14;
            l11 |= l16;
            l16 = ((long)UnsafeUtil.getByte((long)2 + l14) & l13) << n13;
            l11 |= l16;
            l16 = ((long)UnsafeUtil.getByte((long)3 + l14) & l13) << n12;
            l11 |= l16;
            l16 = ((long)UnsafeUtil.getByte((long)4 + l14) & l13) << n11;
            l11 |= l16;
            l16 = ((long)UnsafeUtil.getByte((long)5 + l14) & l13) << 40;
            l11 |= l16;
            l16 = ((long)UnsafeUtil.getByte((long)6 + l14) & l13) << 48;
            l11 |= l16;
            l16 = 7;
            l12 = UnsafeUtil.getByte(l14 += l16);
            return ((long)l12 & l13) << n10 | l11;
        }
        l11 = (long)this.readRawByte() & l13;
        long l17 = ((long)this.readRawByte() & l13) << n14;
        l11 |= l17;
        l17 = ((long)this.readRawByte() & l13) << n13;
        l11 |= l17;
        l17 = ((long)this.readRawByte() & l13) << n12;
        l11 |= l17;
        l17 = ((long)this.readRawByte() & l13) << n11;
        l11 |= l17;
        l17 = ((long)this.readRawByte() & l13) << 40;
        l11 |= l17;
        l17 = ((long)this.readRawByte() & l13) << 48;
        l11 |= l17;
        l12 = this.readRawByte();
        return ((long)l12 & l13) << n10 | l11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int readRawVarint32() {
        block7: {
            block8: {
                block10: {
                    block9: {
                        var3_2 = this.currentByteBufferLimit;
                        var1_1 = this.currentByteBufferPos;
                        cfr_temp_0 = var3_2 - var1_1;
                        var5_3 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var5_3 /* !! */  == false) break block8;
                        var3_2 = 1L;
                        var6_4 = var1_1 + var3_2;
                        var8_5 = UnsafeUtil.getByte(var1_1);
                        if (var8_5 >= 0) {
                            this.currentByteBufferPos = var6_4 = this.currentByteBufferPos + var3_2;
                            return var8_5;
                        }
                        var9_6 = this.currentByteBufferLimit;
                        var11_7 = this.currentByteBufferPos;
                        cfr_temp_1 = (var9_6 -= var11_7) - (var11_7 = (long)10);
                        var13_8 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                        if (var13_8 /* !! */  < 0) break block8;
                        var9_6 = var6_4 + var3_2;
                        var13_8 /* !! */  = UnsafeUtil.getByte(var6_4) << 7;
                        if ((var8_5 ^= var13_8 /* !! */ ) >= 0) break block9;
                        var8_5 ^= -128;
                        break block7;
                    }
                    var6_4 = var9_6 + var3_2;
                    var13_8 /* !! */  = UnsafeUtil.getByte(var9_6) << 14;
                    if ((var8_5 ^= var13_8 /* !! */ ) >= 0) {
                        var8_5 ^= 16256;
lbl27:
                        // 4 sources

                        while (true) {
                            var9_6 = var6_4;
                            break block7;
                            break;
                        }
                    }
                    var9_6 = var6_4 + var3_2;
                    var13_8 /* !! */  = UnsafeUtil.getByte(var6_4) << 21;
                    if ((var8_5 ^= var13_8 /* !! */ ) >= 0) break block10;
                    var13_8 /* !! */  = -2080896;
                    var8_5 ^= var13_8 /* !! */ ;
                    break block7;
                }
                var6_4 = var9_6 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var9_6);
                var14_9 = var13_8 /* !! */  << 28;
                var8_5 ^= var14_9;
                var14_9 = 266354560;
                var8_5 ^= var14_9;
                if (var13_8 /* !! */  >= 0) ** GOTO lbl27
                var9_6 = var6_4 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var6_4);
                if (var13_8 /* !! */  >= 0) break block7;
                var6_4 = var9_6 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var9_6);
                if (var13_8 /* !! */  >= 0) ** GOTO lbl27
                var9_6 = var6_4 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var6_4);
                if (var13_8 /* !! */  >= 0) break block7;
                var6_4 = var9_6 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var9_6);
                if (var13_8 /* !! */  < 0) ** break;
                ** while (true)
                var9_6 = var6_4 + var3_2;
                var13_8 /* !! */  = UnsafeUtil.getByte(var6_4);
                if (var13_8 /* !! */  >= 0) break block7;
            }
            return (int)this.readRawVarint64SlowPath();
        }
        this.currentByteBufferPos = var9_6;
        return var8_5;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long readRawVarint64() {
        long l10;
        long l11;
        block9: {
            long l12;
            block16: {
                long l13;
                block7: {
                    int n10;
                    long l14;
                    block15: {
                        block13: {
                            block14: {
                                block11: {
                                    block12: {
                                        block10: {
                                            int n11;
                                            block8: {
                                                block5: {
                                                    block6: {
                                                        block4: {
                                                            l12 = this.currentByteBufferLimit;
                                                            l11 = this.currentByteBufferPos;
                                                            long l15 = l12 - l11;
                                                            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                                                            if (object == false) {
                                                                return this.readRawVarint64SlowPath();
                                                            }
                                                            l12 = 1L;
                                                            l13 = l11 + l12;
                                                            n11 = UnsafeUtil.getByte(l11);
                                                            if (n11 >= 0) {
                                                                this.currentByteBufferPos = l13 = this.currentByteBufferPos + l12;
                                                                return n11;
                                                            }
                                                            l10 = this.currentByteBufferLimit;
                                                            l14 = this.currentByteBufferPos;
                                                            long l16 = (l10 -= l14) - (l14 = (long)10);
                                                            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                                            if (object2 < 0) {
                                                                return this.readRawVarint64SlowPath();
                                                            }
                                                            l10 = l13 + l12;
                                                            int n12 = UnsafeUtil.getByte(l13) << 7;
                                                            if ((n11 ^= n12) >= 0) break block4;
                                                            n11 ^= 0xFFFFFF80;
                                                            break block5;
                                                        }
                                                        l13 = l10 + l12;
                                                        int n13 = UnsafeUtil.getByte(l10) << 14;
                                                        if ((n11 ^= n13) < 0) break block6;
                                                        l11 = n11 ^= 0x3F80;
                                                        break block7;
                                                    }
                                                    l10 = l13 + l12;
                                                    int n14 = UnsafeUtil.getByte(l13) << 21;
                                                    if ((n11 ^= n14) >= 0) break block8;
                                                    int n15 = -2080896;
                                                    n11 ^= n15;
                                                }
                                                l11 = n11;
                                                break block9;
                                            }
                                            l11 = n11;
                                            l13 = l10 + l12;
                                            byte by2 = UnsafeUtil.getByte(l10);
                                            l10 = (long)by2 << 28;
                                            long l17 = (l11 ^= l10) - (l10 = 0L);
                                            Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                                            if (object < 0) break block10;
                                            l12 = 266354560L;
                                            break block11;
                                        }
                                        l14 = l13 + l12;
                                        l13 = UnsafeUtil.getByte(l13);
                                        n10 = 35;
                                        long l18 = (l11 ^= (l13 <<= n10)) - l10;
                                        Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                                        if (object >= 0) break block12;
                                        l12 = -34093383808L;
                                        break block13;
                                    }
                                    l13 = l14 + l12;
                                    l14 = UnsafeUtil.getByte(l14);
                                    n10 = 42;
                                    long l19 = (l11 ^= (l14 <<= n10)) - l10;
                                    Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                                    if (object < 0) break block14;
                                    l12 = 4363953127296L;
                                }
                                l11 ^= l12;
                                break block7;
                            }
                            l14 = l13 + l12;
                            l13 = UnsafeUtil.getByte(l13);
                            n10 = 49;
                            long l20 = (l11 ^= (l13 <<= n10)) - l10;
                            Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                            if (object >= 0) break block15;
                            l12 = -558586000294016L;
                        }
                        l11 ^= l12;
                        l10 = l14;
                        break block9;
                    }
                    l13 = l14 + l12;
                    l14 = UnsafeUtil.getByte(l14);
                    n10 = 56;
                    l11 ^= (l14 <<= n10);
                    l14 = 71499008037633920L;
                    long l21 = (l11 ^= l14) - l10;
                    Object object = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                    if (object >= 0) break block7;
                    l12 += l13;
                    long l22 = (l13 = (long)UnsafeUtil.getByte(l13)) - l10;
                    Object object3 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                    if (object3 < 0) {
                        return this.readRawVarint64SlowPath();
                    }
                    break block16;
                }
                l10 = l13;
                break block9;
            }
            l10 = l12;
        }
        this.currentByteBufferPos = l10;
        return l11;
    }

    public long readRawVarint64SlowPath() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 7) {
            n10 = this.readRawByte();
            int n11 = n10 & 0x7F;
            long l11 = (long)n11 << i10;
            l10 |= l11;
            if ((n10 &= 0x80) != 0) continue;
            return l10;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() {
        return this.readRawLittleEndian32();
    }

    public long readSFixed64() {
        return this.readRawLittleEndian64();
    }

    public int readSInt32() {
        return CodedInputStream.decodeZigZag32(this.readRawVarint32());
    }

    public long readSInt64() {
        return CodedInputStream.decodeZigZag64(this.readRawVarint64());
    }

    public String readString() {
        int n10;
        int n11 = this.readRawVarint32();
        if (n11 > 0) {
            long l10 = n11;
            long l11 = this.currentByteBufferLimit;
            long l12 = this.currentByteBufferPos;
            long l13 = l10 - (l11 -= l12);
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 <= 0) {
                long l14;
                byte[] byArray = new byte[n11];
                l11 = l12;
                long l15 = 0L;
                UnsafeUtil.copyMemory(l12, byArray, l15, l10);
                Charset charset = Internal.UTF_8;
                String string2 = new String(byArray, charset);
                this.currentByteBufferPos = l14 = this.currentByteBufferPos + l10;
                return string2;
            }
        }
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            byte[] byArray = new byte[n11];
            this.readRawBytesTo(byArray, 0, n11);
            Charset charset = Internal.UTF_8;
            String string3 = new String(byArray, charset);
            return string3;
        }
        if (n11 == 0) {
            return "";
        }
        if (n11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public String readStringRequireUtf8() {
        int n10;
        int n11 = this.readRawVarint32();
        if (n11 > 0) {
            long l10 = n11;
            long l11 = this.currentByteBufferLimit;
            long l12 = this.currentByteBufferPos;
            long l13 = l10 - (l11 -= l12);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object <= 0) {
                l11 = this.currentByteBufferStartPos;
                object = (int)(l12 - l11);
                String string2 = Utf8.decodeUtf8(this.currentByteBuffer, (int)object, n11);
                this.currentByteBufferPos = l11 = this.currentByteBufferPos + l10;
                return string2;
            }
        }
        if (n11 >= 0 && n11 <= (n10 = this.remaining())) {
            byte[] byArray = new byte[n11];
            this.readRawBytesTo(byArray, 0, n11);
            return Utf8.decodeUtf8(byArray, 0, n11);
        }
        if (n11 == 0) {
            return "";
        }
        if (n11 <= 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public int readTag() {
        int n10 = this.isAtEnd();
        if (n10 != 0) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = n10 = this.readRawVarint32();
        if ((n10 = WireFormat.getTagFieldNumber(n10)) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() {
        return this.readRawVarint32();
    }

    public long readUInt64() {
        return this.readRawVarint64();
    }

    public void readUnknownGroup(int n10, MessageLite$Builder messageLite$Builder) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        this.readGroup(n10, messageLite$Builder, extensionRegistryLite);
    }

    public void resetSizeCounter() {
        int n10;
        long l10 = this.totalBytesRead;
        long l11 = this.currentByteBufferPos;
        l10 += l11;
        l11 = this.currentByteBufferStartPos;
        this.startOffset = n10 = (int)(l10 - l11);
    }

    public boolean skipField(int n10) {
        int n11 = WireFormat.getTagWireType(n10);
        int n12 = 1;
        if (n11) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 != n13) {
                    n13 = 3;
                    int n14 = 4;
                    if (n11 != n13) {
                        if (n11 != n14) {
                            n10 = 5;
                            if (n11 == n10) {
                                this.skipRawBytes(n14);
                                return n12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    this.skipMessage();
                    n10 = WireFormat.makeTag(WireFormat.getTagFieldNumber(n10), n14);
                    this.checkLastTagWas(n10);
                    return n12;
                }
                n10 = this.readRawVarint32();
                this.skipRawBytes(n10);
                return n12;
            }
            this.skipRawBytes(8);
            return n12;
        }
        this.skipRawVarint();
        return n12;
    }

    public boolean skipField(int n10, CodedOutputStream codedOutputStream) {
        int bl2 = WireFormat.getTagWireType(n10);
        int n11 = 1;
        if (bl2) {
            if (bl2 != n11) {
                int n12 = 2;
                if (bl2 != n12) {
                    int n13 = 3;
                    int n14 = 4;
                    if (bl2 != n13) {
                        if (bl2 != n14) {
                            int n15 = 5;
                            if (bl2 == n15) {
                                int n16 = this.readRawLittleEndian32();
                                codedOutputStream.writeRawVarint32(n10);
                                codedOutputStream.writeFixed32NoTag(n16);
                                return n11;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    codedOutputStream.writeRawVarint32(n10);
                    this.skipMessage(codedOutputStream);
                    n10 = WireFormat.makeTag(WireFormat.getTagFieldNumber(n10), n14);
                    this.checkLastTagWas(n10);
                    codedOutputStream.writeRawVarint32(n10);
                    return n11;
                }
                ByteString byteString = this.readBytes();
                codedOutputStream.writeRawVarint32(n10);
                codedOutputStream.writeBytesNoTag(byteString);
                return n11;
            }
            long l10 = this.readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(n10);
            codedOutputStream.writeFixed64NoTag(l10);
            return n11;
        }
        long l11 = this.readInt64();
        codedOutputStream.writeRawVarint32(n10);
        codedOutputStream.writeUInt64NoTag(l11);
        return n11;
    }

    public void skipMessage() {
        int n10;
        while ((n10 = this.readTag()) != 0 && (n10 = (int)(this.skipField(n10) ? 1 : 0)) != 0) {
        }
    }

    public void skipMessage(CodedOutputStream codedOutputStream) {
        int n10;
        while ((n10 = this.readTag()) != 0 && (n10 = (int)(this.skipField(n10, codedOutputStream) ? 1 : 0)) != 0) {
        }
    }

    public void skipRawBytes(int n10) {
        if (n10 >= 0) {
            long l10 = n10;
            int n11 = this.totalBufferSize;
            int n12 = this.totalBytesRead;
            long l11 = n11 -= n12;
            long l12 = this.currentByteBufferPos;
            l11 -= l12;
            l12 = this.currentByteBufferStartPos;
            long l13 = l10 - (l11 += l12);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object <= 0) {
                while (n10 > 0) {
                    l10 = this.currentRemaining();
                    long l14 = l10 - (l11 = 0L);
                    object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object == false) {
                        this.getNextByteBuffer();
                    }
                    l10 = this.currentRemaining();
                    object = (int)l10;
                    object = Math.min(n10, (int)object);
                    n10 -= object;
                    long l15 = this.currentByteBufferPos;
                    long l16 = object;
                    this.currentByteBufferPos = l15 += l16;
                }
                return;
            }
        }
        if (n10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}

