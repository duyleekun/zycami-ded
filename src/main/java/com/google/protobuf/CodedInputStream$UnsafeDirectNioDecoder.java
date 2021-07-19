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

public final class CodedInputStream$UnsafeDirectNioDecoder
extends CodedInputStream {
    private final long address;
    private final ByteBuffer buffer;
    private int bufferSizeAfterLimit;
    private int currentLimit = -1 >>> 1;
    private boolean enableAliasing;
    private final boolean immutable;
    private int lastTag;
    private long limit;
    private long pos;
    private long startPos;

    private CodedInputStream$UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean bl2) {
        super(null);
        long l10;
        long l11;
        this.buffer = byteBuffer;
        this.address = l11 = UnsafeUtil.addressOffset(byteBuffer);
        this.limit = l10 = (long)byteBuffer.limit() + l11;
        l10 = byteBuffer.position();
        this.pos = l11 += l10;
        this.startPos = l11;
        this.immutable = bl2;
    }

    public /* synthetic */ CodedInputStream$UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean bl2, CodedInputStream$1 codedInputStream$1) {
        this(byteBuffer, bl2);
    }

    private int bufferPos(long l10) {
        long l11 = this.address;
        return (int)(l10 - l11);
    }

    public static boolean isSupported() {
        return UnsafeUtil.hasUnsafeByteBufferOperations();
    }

    private void recomputeBufferSizeAfterLimit() {
        long l10 = this.limit;
        long l11 = this.bufferSizeAfterLimit;
        this.limit = l10 += l11;
        l11 = this.startPos;
        int n10 = (int)(l11 = l10 - l11);
        int n11 = this.currentLimit;
        if (n10 > n11) {
            this.bufferSizeAfterLimit = n10 -= n11;
            l11 = n10;
            this.limit = l10 -= l11;
        } else {
            this.bufferSizeAfterLimit = 0;
        }
    }

    private int remaining() {
        long l10 = this.limit;
        long l11 = this.pos;
        return (int)(l10 - l11);
    }

    private void skipRawVarint() {
        int n10;
        int n11 = this.remaining();
        if (n11 >= (n10 = 10)) {
            this.skipRawVarintFastPath();
        } else {
            this.skipRawVarintSlowPath();
        }
    }

    private void skipRawVarintFastPath() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            long l10;
            long l11 = this.pos;
            this.pos = l10 = 1L + l11;
            n10 = UnsafeUtil.getByte(l11);
            if (n10 < 0) continue;
            return;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void skipRawVarintSlowPath() {
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
    private ByteBuffer slice(long l10, long l11) {
        Throwable throwable2222222;
        int n10;
        int n11;
        block4: {
            ByteBuffer byteBuffer = this.buffer;
            n11 = byteBuffer.position();
            ByteBuffer byteBuffer2 = this.buffer;
            n10 = byteBuffer2.limit();
            ByteBuffer byteBuffer3 = this.buffer;
            int n12 = this.bufferPos(l10);
            byteBuffer3.position(n12);
            ByteBuffer byteBuffer4 = this.buffer;
            int n13 = this.bufferPos(l11);
            byteBuffer4.limit(n13);
            byteBuffer4 = this.buffer;
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
            this.buffer.position(n11);
            this.buffer.limit(n10);
            return byteBuffer4;
        }
        this.buffer.position(n11);
        this.buffer.limit(n10);
        throw throwable2222222;
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
        long l10 = this.pos;
        long l11 = this.startPos;
        return (int)(l10 - l11);
    }

    public boolean isAtEnd() {
        long l10 = this.pos;
        long l11 = this.limit;
        long l12 = l10 - l11;
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
        int n10;
        int n11 = this.readRawVarint32();
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            long l10;
            n10 = (int)(this.immutable ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(this.enableAliasing ? 1 : 0)) != 0) {
                long l11 = this.pos;
                long l12 = n11;
                long l13 = l11 + l12;
                ByteBuffer byteBuffer = this.slice(l11, l13);
                this.pos = l11 = this.pos + l12;
                return byteBuffer;
            }
            byte[] byArray = new byte[n11];
            long l14 = this.pos;
            long l15 = n11;
            UnsafeUtil.copyMemory(l14, byArray, 0L, l15);
            this.pos = l10 = this.pos + l15;
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
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            long l10;
            n10 = (int)(this.immutable ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(this.enableAliasing ? 1 : 0)) != 0) {
                long l11 = this.pos;
                long l12 = n11;
                long l13 = l11 + l12;
                ByteBuffer byteBuffer = this.slice(l11, l13);
                this.pos = l11 = this.pos + l12;
                return ByteString.wrap(byteBuffer);
            }
            byte[] byArray = new byte[n11];
            long l14 = this.pos;
            long l15 = n11;
            UnsafeUtil.copyMemory(l14, byArray, 0L, l15);
            this.pos = l10 = this.pos + l15;
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
        long l10 = this.pos;
        long l11 = this.limit;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.pos = l11 = 1L + l10;
            return UnsafeUtil.getByte(l10);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public byte[] readRawBytes(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = this.remaining())) {
            byte[] byArray = new byte[n10];
            long l10 = this.pos;
            long l11 = n10;
            long l12 = l10 + l11;
            this.slice(l10, l12).get(byArray);
            this.pos = l10 = this.pos + l11;
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
        long l10 = this.pos;
        long l11 = this.limit - l10;
        long l12 = 4;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            this.pos = l12 += l10;
            object = UnsafeUtil.getByte(l10) & 0xFF;
            int n10 = (UnsafeUtil.getByte(1L + l10) & 0xFF) << 8;
            object = object | n10;
            n10 = (UnsafeUtil.getByte((long)2 + l10) & 0xFF) << 16;
            object = object | n10;
            return (UnsafeUtil.getByte(l10 + (long)3) & 0xFF) << 24 | object;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public long readRawLittleEndian64() {
        long l10 = this.pos;
        long l11 = this.limit - l10;
        long l12 = 8;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            this.pos = l12 += l10;
            l11 = UnsafeUtil.getByte(l10);
            l12 = 255L;
            l11 &= l12;
            long l14 = ((long)UnsafeUtil.getByte(1L + l10) & l12) << 8;
            l11 |= l14;
            l14 = ((long)UnsafeUtil.getByte((long)2 + l10) & l12) << 16;
            l11 |= l14;
            l14 = ((long)UnsafeUtil.getByte((long)3 + l10) & l12) << 24;
            l11 |= l14;
            l14 = ((long)UnsafeUtil.getByte((long)4 + l10) & l12) << 32;
            l11 |= l14;
            l14 = ((long)UnsafeUtil.getByte((long)5 + l10) & l12) << 40;
            l11 |= l14;
            l14 = ((long)UnsafeUtil.getByte((long)6 + l10) & l12) << 48;
            return ((long)UnsafeUtil.getByte(l10 + (long)7) & l12) << 56 | (l11 |= l14);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
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
                        var3_2 = this.limit;
                        var1_1 = this.pos;
                        cfr_temp_0 = var3_2 - var1_1;
                        var5_3 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var5_3 /* !! */  == false) break block8;
                        var3_2 = 1L;
                        var6_4 = var1_1 + var3_2;
                        var8_5 = UnsafeUtil.getByte(var1_1);
                        if (var8_5 >= 0) {
                            this.pos = var6_4;
                            return var8_5;
                        }
                        var9_6 = this.limit - var6_4;
                        var11_7 = 9;
                        cfr_temp_1 = var9_6 - var11_7;
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
        this.pos = var9_6;
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
                                                            l12 = this.limit;
                                                            l11 = this.pos;
                                                            long l15 = l12 - l11;
                                                            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                                                            if (object == false) {
                                                                return this.readRawVarint64SlowPath();
                                                            }
                                                            l12 = 1L;
                                                            l13 = l11 + l12;
                                                            n11 = UnsafeUtil.getByte(l11);
                                                            if (n11 >= 0) {
                                                                this.pos = l13;
                                                                return n11;
                                                            }
                                                            l10 = this.limit - l13;
                                                            l14 = 9;
                                                            long l16 = l10 - l14;
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
        this.pos = l10;
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
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            long l10;
            byte[] byArray = new byte[n11];
            long l11 = this.pos;
            long l12 = n11;
            UnsafeUtil.copyMemory(l11, byArray, 0L, l12);
            Charset charset = Internal.UTF_8;
            String string2 = new String(byArray, charset);
            this.pos = l10 = this.pos + l12;
            return string2;
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
        if (n11 > 0 && n11 <= (n10 = this.remaining())) {
            long l10 = this.pos;
            n10 = this.bufferPos(l10);
            String string2 = Utf8.decodeUtf8(this.buffer, n10, n11);
            long l11 = this.pos;
            long l12 = n11;
            this.pos = l11 += l12;
            return string2;
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
        long l10;
        this.startPos = l10 = this.pos;
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
        int n11;
        if (n10 >= 0 && n10 <= (n11 = this.remaining())) {
            long l10 = this.pos;
            long l11 = n10;
            this.pos = l10 += l11;
            return;
        }
        if (n10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}

