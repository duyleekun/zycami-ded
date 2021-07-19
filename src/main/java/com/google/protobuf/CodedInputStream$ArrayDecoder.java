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
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class CodedInputStream$ArrayDecoder
extends CodedInputStream {
    private final byte[] buffer;
    private int bufferSizeAfterLimit;
    private int currentLimit = -1 >>> 1;
    private boolean enableAliasing;
    private final boolean immutable;
    private int lastTag;
    private int limit;
    private int pos;
    private int startPos;

    private CodedInputStream$ArrayDecoder(byte[] byArray, int n10, int n11, boolean bl2) {
        super(null);
        this.buffer = byArray;
        this.limit = n11 += n10;
        this.pos = n10;
        this.startPos = n10;
        this.immutable = bl2;
    }

    public /* synthetic */ CodedInputStream$ArrayDecoder(byte[] byArray, int n10, int n11, boolean bl2, CodedInputStream$1 codedInputStream$1) {
        this(byArray, n10, n11, bl2);
    }

    private void recomputeBufferSizeAfterLimit() {
        int n10 = this.limit;
        int n11 = this.bufferSizeAfterLimit;
        this.limit = n10 += n11;
        n11 = this.startPos;
        int n12 = this.currentLimit;
        if ((n11 = n10 - n11) > n12) {
            this.bufferSizeAfterLimit = n11 -= n12;
            this.limit = n10 -= n11;
        } else {
            n10 = 0;
            this.bufferSizeAfterLimit = 0;
        }
    }

    private void skipRawVarint() {
        int n10 = this.limit;
        int n11 = this.pos;
        if ((n10 -= n11) >= (n11 = 10)) {
            this.skipRawVarintFastPath();
        } else {
            this.skipRawVarintSlowPath();
        }
    }

    private void skipRawVarintFastPath() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            int n11;
            byte[] byArray = this.buffer;
            int n12 = this.pos;
            this.pos = n11 = n12 + 1;
            n10 = byArray[n12];
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
        int n10 = this.pos;
        int n11 = this.startPos;
        return n10 - n11;
    }

    public boolean isAtEnd() {
        int n10 = this.pos;
        int n11 = this.limit;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
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
        int n10 = this.readRawVarint32();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                Object object;
                n11 = (int)(this.immutable ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(this.enableAliasing ? 1 : 0)) != 0) {
                    object = ByteBuffer.wrap(this.buffer, n12, n10).slice();
                } else {
                    object = this.buffer;
                    int n13 = n12 + n10;
                    object = ByteBuffer.wrap(Arrays.copyOfRange(object, n12, n13));
                }
                this.pos = n12 = this.pos + n10;
                return object;
            }
        }
        if (n10 == 0) {
            return Internal.EMPTY_BYTE_BUFFER;
        }
        if (n10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public ByteString readBytes() {
        int n10 = this.readRawVarint32();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                n11 = (int)(this.immutable ? 1 : 0);
                ByteString byteString = n11 != 0 && (n11 = (int)(this.enableAliasing ? 1 : 0)) != 0 ? ByteString.wrap(this.buffer, n12, n10) : ByteString.copyFrom(this.buffer, n12, n10);
                this.pos = n12 = this.pos + n10;
                return byteString;
            }
        }
        if (n10 == 0) {
            return ByteString.EMPTY;
        }
        return ByteString.wrap(this.readRawBytes(n10));
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
        int n10 = this.pos;
        int n11 = this.limit;
        if (n10 != n11) {
            int n12;
            byte[] byArray = this.buffer;
            this.pos = n12 = n10 + 1;
            return byArray[n10];
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public byte[] readRawBytes(int n10) {
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                this.pos = n10 += n12;
                return Arrays.copyOfRange(this.buffer, n12, n10);
            }
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
        int n10 = this.pos;
        int n11 = this.limit - n10;
        int n12 = 4;
        if (n11 >= n12) {
            byte[] byArray = this.buffer;
            this.pos = n12 = n10 + 4;
            n12 = byArray[n10] & 0xFF;
            int n13 = n10 + 1;
            n13 = (byArray[n13] & 0xFF) << 8;
            n12 |= n13;
            n13 = n10 + 2;
            n13 = (byArray[n13] & 0xFF) << 16;
            return (byArray[n10 += 3] & 0xFF) << 24 | (n12 |= n13);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public long readRawLittleEndian64() {
        int n10 = this.pos;
        int n11 = this.limit - n10;
        int n12 = 8;
        if (n11 >= n12) {
            int n13;
            byte[] byArray = this.buffer;
            this.pos = n13 = n10 + 8;
            long l10 = byArray[n10];
            long l11 = 255L;
            int n14 = n10 + 1;
            long l12 = ((long)byArray[n14] & l11) << n12;
            long l13 = (l10 &= l11) | l12;
            int n15 = n10 + 2;
            l12 = ((long)byArray[n15] & l11) << 16;
            l13 |= l12;
            n15 = n10 + 3;
            l12 = ((long)byArray[n15] & l11) << 24;
            l13 |= l12;
            n15 = n10 + 4;
            l12 = ((long)byArray[n15] & l11) << 32;
            l13 |= l12;
            n15 = n10 + 5;
            l12 = ((long)byArray[n15] & l11) << 40;
            l13 |= l12;
            n15 = n10 + 6;
            l12 = ((long)byArray[n15] & l11) << 48;
            return ((long)byArray[n10 += 7] & l11) << 56 | (l13 |= l12);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /*
     * Unable to fully structure code
     */
    public int readRawVarint32() {
        block7: {
            block8: {
                block10: {
                    block9: {
                        var2_2 = this.limit;
                        var1_1 = this.pos;
                        if (var2_2 == var1_1) break block8;
                        var3_3 = this.buffer;
                        var4_4 = var1_1 + 1;
                        if ((var1_1 = var3_3[var1_1]) >= 0) {
                            this.pos = var4_4;
                            return var1_1;
                        }
                        var5_5 = 9;
                        if ((var2_2 -= var4_4) < var5_5) break block8;
                        var2_2 = var4_4 + 1;
                        if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) >= 0) break block9;
                        var1_1 ^= -128;
                        break block7;
                    }
                    var4_4 = var2_2 + 1;
                    if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) >= 0) {
                        var1_1 ^= 16256;
lbl19:
                        // 4 sources

                        while (true) {
                            var2_2 = var4_4;
                            break block7;
                            break;
                        }
                    }
                    var2_2 = var4_4 + 1;
                    if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 21)) >= 0) break block10;
                    var6_6 = -2080896;
                    var1_1 ^= var6_6;
                    break block7;
                }
                var4_4 = var2_2 + 1;
                var2_2 = var3_3[var2_2];
                var5_5 = var2_2 << 28;
                var1_1 ^= var5_5;
                var5_5 = 266354560;
                var1_1 ^= var5_5;
                if (var2_2 >= 0) ** GOTO lbl19
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) >= 0) break block7;
                var4_4 = var2_2 + 1;
                if ((var2_2 = var3_3[var2_2]) >= 0) ** GOTO lbl19
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) >= 0) break block7;
                var4_4 = var2_2 + 1;
                if ((var2_2 = var3_3[var2_2]) < 0) ** break;
                ** while (true)
                var2_2 = var4_4 + 1;
                var6_7 = var3_3[var4_4];
                if (var6_7 >= 0) break block7;
            }
            return (int)this.readRawVarint64SlowPath();
        }
        this.pos = var2_2;
        return var1_1;
    }

    /*
     * Unable to fully structure code
     */
    public long readRawVarint64() {
        block12: {
            block16: {
                block15: {
                    block13: {
                        block14: {
                            var2_2 = this.limit;
                            var1_1 = this.pos;
                            if (var2_2 == var1_1) break block13;
                            var3_3 = this.buffer;
                            var4_4 = var1_1 + 1;
                            if ((var1_1 = var3_3[var1_1]) >= 0) {
                                this.pos = var4_4;
                                return var1_1;
                            }
                            var5_5 = 9;
                            if ((var2_2 -= var4_4) < var5_5) break block13;
                            var2_2 = var4_4 + 1;
                            if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) < 0) {
                                var1_1 ^= -128;
lbl14:
                                // 2 sources

                                while (true) {
                                    var6_6 = var1_1;
                                    break block12;
                                    break;
                                }
                            }
                            var4_4 = var2_2 + 1;
                            if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) < 0) break block14;
                            var8_7 = var1_1 ^= 16256;
                            var2_2 = var4_4;
                            var6_6 = var8_7;
                            break block12;
                        }
                        var2_2 = var4_4 + 1;
                        if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 21)) < 0) {
                            var10_8 = -2080896;
                            var1_1 ^= var10_8;
                            ** continue;
                        }
                        var11_9 = var1_1;
                        var1_1 = var2_2 + 1;
                        var13_10 = (long)var3_3[var2_2] << 28;
                        cfr_temp_0 = (var11_9 ^= var13_10) - (var13_10 = 0L);
                        var2_2 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                        if (var2_2 >= 0) {
                            var15_11 = 266354560L;
lbl36:
                            // 2 sources

                            while (true) {
                                var6_6 = var11_9 ^ var15_11;
                                var2_2 = var1_1;
                                break block12;
                                break;
                            }
                        }
                        var2_2 = var1_1 + 1;
                        var17_12 = (long)var3_3[var1_1] << 35;
                        cfr_temp_1 = (var11_9 ^= var17_12) - var13_10;
                        if ((var1_1 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0) {
                            var13_10 = -34093383808L;
lbl45:
                            // 2 sources

                            while (true) {
                                var6_6 = var11_9 ^ var13_10;
                                break block12;
                                break;
                            }
                        }
                        var1_1 = var2_2 + 1;
                        var17_12 = (long)var3_3[var2_2] << 42;
                        cfr_temp_2 = (var11_9 ^= var17_12) - var13_10;
                        if ((var2_2 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) >= 0) {
                            var15_11 = 4363953127296L;
                            ** continue;
                        }
                        var2_2 = var1_1 + 1;
                        var17_12 = (long)var3_3[var1_1] << 49;
                        cfr_temp_3 = (var11_9 ^= var17_12) - var13_10;
                        if ((var1_1 = (int)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) < 0) {
                            var13_10 = -558586000294016L;
                            ** continue;
                        }
                        var1_1 = var2_2 + 1;
                        var17_12 = (long)var3_3[var2_2] << 56;
                        var11_9 ^= var17_12;
                        var17_12 = 71499008037633920L;
                        cfr_temp_4 = (var11_9 ^= var17_12) - var13_10;
                        var2_2 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                        if (var2_2 >= 0) break block15;
                        var2_2 = var1_1 + 1;
                        var17_12 = var3_3[var1_1];
                        cfr_temp_5 = var17_12 - var13_10;
                        if ((var1_1 = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) >= 0) break block16;
                    }
                    return this.readRawVarint64SlowPath();
                }
                var2_2 = var1_1;
            }
            var6_6 = var11_9;
        }
        this.pos = var2_2;
        return var6_6;
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
        int n10 = this.readRawVarint32();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                byte[] byArray = this.buffer;
                int n13 = this.pos;
                Charset charset = Internal.UTF_8;
                String string2 = new String(byArray, n13, n10, charset);
                this.pos = n12 = this.pos + n10;
                return string2;
            }
        }
        if (n10 == 0) {
            return "";
        }
        if (n10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public String readStringRequireUtf8() {
        int n10 = this.readRawVarint32();
        if (n10 > 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                String string2 = Utf8.decodeUtf8(this.buffer, n12, n10);
                this.pos = n12 = this.pos + n10;
                return string2;
            }
        }
        if (n10 == 0) {
            return "";
        }
        if (n10 <= 0) {
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
        this.startPos = n10 = this.pos;
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
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                this.pos = n12 += n10;
                return;
            }
        }
        if (n10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}

