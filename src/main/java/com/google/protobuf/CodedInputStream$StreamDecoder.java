/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStream$1;
import com.google.protobuf.CodedInputStream$StreamDecoder$RefillCallback;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream$StreamDecoder
extends CodedInputStream {
    private final byte[] buffer;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit = -1 >>> 1;
    private final InputStream input;
    private int lastTag;
    private int pos;
    private CodedInputStream$StreamDecoder$RefillCallback refillCallback = null;
    private int totalBytesRetired;

    private CodedInputStream$StreamDecoder(InputStream object, int n10) {
        super(null);
        Internal.checkNotNull(object, "input");
        this.input = object;
        object = new byte[n10];
        this.buffer = (byte[])object;
        this.bufferSize = 0;
        this.pos = 0;
        this.totalBytesRetired = 0;
    }

    public /* synthetic */ CodedInputStream$StreamDecoder(InputStream inputStream, int n10, CodedInputStream$1 codedInputStream$1) {
        this(inputStream, n10);
    }

    public static /* synthetic */ int access$500(CodedInputStream$StreamDecoder codedInputStream$StreamDecoder) {
        return codedInputStream$StreamDecoder.pos;
    }

    public static /* synthetic */ byte[] access$600(CodedInputStream$StreamDecoder codedInputStream$StreamDecoder) {
        return codedInputStream$StreamDecoder.buffer;
    }

    private ByteString readBytesSlowPath(int n10) {
        int n11;
        Object object = this.readRawBytesSlowPathOneChunk(n10);
        if (object != null) {
            return ByteString.copyFrom(object);
        }
        int n12 = this.pos;
        int n13 = this.bufferSize;
        int n14 = n13 - n12;
        this.totalBytesRetired = n11 = this.totalBytesRetired + n13;
        n13 = 0;
        this.pos = 0;
        this.bufferSize = 0;
        n11 = n10 - n14;
        Object object2 = this.readRawBytesSlowPathRemainingChunks(n11);
        byte[] byArray = new byte[n10];
        byte[] byArray2 = this.buffer;
        System.arraycopy(byArray2, n12, byArray, 0, n14);
        object = object2.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (byte[])object.next();
            int n15 = ((Object)object2).length;
            System.arraycopy(object2, 0, byArray, n14, n15);
            n11 = ((Object)object2).length;
            n14 += n11;
        }
        return ByteString.wrap(byArray);
    }

    private byte[] readRawBytesSlowPath(int n10, boolean bl2) {
        int n11;
        Object object = this.readRawBytesSlowPathOneChunk(n10);
        if (object != null) {
            if (bl2) {
                Object byArray = object.clone();
                object = byArray;
                object = (byte[])byArray;
            }
            return object;
        }
        int n12 = this.pos;
        int n13 = this.bufferSize;
        int n14 = n13 - n12;
        this.totalBytesRetired = n11 = this.totalBytesRetired + n13;
        n13 = 0;
        object = null;
        this.pos = 0;
        this.bufferSize = 0;
        n11 = n10 - n14;
        Object object2 = this.readRawBytesSlowPathRemainingChunks(n11);
        byte[] byArray = new byte[n10];
        byte[] byArray2 = this.buffer;
        System.arraycopy(byArray2, n12, byArray, 0, n14);
        Iterator iterator2 = object2.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object2 = (byte[])iterator2.next();
            int n15 = ((Object)object2).length;
            System.arraycopy(object2, 0, byArray, n14, n15);
            n11 = ((Object)object2).length;
            n14 += n11;
        }
        return byArray;
    }

    private byte[] readRawBytesSlowPathOneChunk(int n10) {
        if (n10 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        if (n10 >= 0) {
            int n11 = this.totalBytesRetired;
            int n12 = this.pos;
            int n13 = n11 + n12 + n10;
            int n14 = this.sizeLimit;
            if ((n14 = n13 - n14) <= 0) {
                n14 = this.currentLimit;
                if (n13 <= n14) {
                    Object object;
                    n11 = this.bufferSize - n12;
                    n13 = 4096;
                    if ((n12 = n10 - n11) >= n13 && n12 > (n13 = ((InputStream)(object = this.input)).available())) {
                        return null;
                    }
                    byte[] byArray = new byte[n10];
                    object = this.buffer;
                    n14 = this.pos;
                    System.arraycopy(object, n14, byArray, 0, n11);
                    n13 = this.totalBytesRetired;
                    n14 = this.bufferSize;
                    this.totalBytesRetired = n13 += n14;
                    this.pos = 0;
                    this.bufferSize = 0;
                    while (n11 < n10) {
                        object = this.input;
                        n14 = n10 - n11;
                        n13 = ((InputStream)object).read(byArray, n11, n14);
                        if (n13 != (n14 = -1)) {
                            this.totalBytesRetired = n14 = this.totalBytesRetired + n13;
                            n11 += n13;
                            continue;
                        }
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    return byArray;
                }
                n14 = n14 - n11 - n12;
                this.skipRawBytes(n14);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    private List readRawBytesSlowPathRemainingChunks(int n10) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        while (n10 > 0) {
            int n11;
            int n12 = Math.min(n10, 4096);
            byte[] byArray = new byte[n12];
            for (int i10 = 0; i10 < n12; i10 += n11) {
                InputStream inputStream = this.input;
                int n13 = n12 - i10;
                n11 = inputStream.read(byArray, i10, n13);
                if (n11 != (n13 = -1)) {
                    this.totalBytesRetired = n13 = this.totalBytesRetired + n11;
                    continue;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            n10 -= n12;
            arrayList.add(byArray);
        }
        return arrayList;
    }

    private void recomputeBufferSizeAfterLimit() {
        int n10 = this.bufferSize;
        int n11 = this.bufferSizeAfterLimit;
        this.bufferSize = n10 += n11;
        n11 = this.totalBytesRetired + n10;
        int n12 = this.currentLimit;
        if (n11 > n12) {
            this.bufferSizeAfterLimit = n11 -= n12;
            this.bufferSize = n10 -= n11;
        } else {
            n10 = 0;
            this.bufferSizeAfterLimit = 0;
        }
    }

    private void refillBuffer(int n10) {
        int n11 = this.tryRefillBuffer(n10);
        if (n11 == 0) {
            n11 = this.sizeLimit;
            int n12 = this.totalBytesRetired;
            n11 -= n12;
            n12 = this.pos;
            if (n10 > (n11 -= n12)) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void skipRawBytesSlowPath(int n10) {
        if (n10 >= 0) {
            int n11 = this.totalBytesRetired;
            int n12 = this.pos;
            int n13 = n11 + n12 + n10;
            int n14 = this.currentLimit;
            if (n13 <= n14) {
                Object object = this.refillCallback;
                n14 = 0;
                if (object == null) {
                    this.totalBytesRetired = n11 += n12;
                    n11 = this.bufferSize - n12;
                    this.bufferSize = 0;
                    this.pos = 0;
                    for (n14 = n11; n14 < n10; n14 += n11) {
                        long l10;
                        InputStream inputStream;
                        n11 = n10 - n14;
                        try {
                            inputStream = this.input;
                        }
                        catch (Throwable throwable) {
                            this.totalBytesRetired = n11 = this.totalBytesRetired + n14;
                            this.recomputeBufferSizeAfterLimit();
                            throw throwable;
                        }
                        long l11 = n11;
                        long l12 = inputStream.skip(l11);
                        long l13 = 0L;
                        n13 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1));
                        if (n13 >= 0 && (l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) <= 0) {
                            if (n13 == 0) break;
                            n11 = (int)l12;
                            continue;
                        }
                        object = new StringBuilder();
                        Object object2 = this.input;
                        object2 = object2.getClass();
                        ((StringBuilder)object).append(object2);
                        object2 = "#skip returned invalid result: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(l12);
                        String string2 = "\nThe InputStream implementation is buggy.";
                        ((StringBuilder)object).append(string2);
                        string2 = ((StringBuilder)object).toString();
                        IllegalStateException illegalStateException = new IllegalStateException(string2);
                        throw illegalStateException;
                    }
                    this.totalBytesRetired = n11 = this.totalBytesRetired + n14;
                    this.recomputeBufferSizeAfterLimit();
                }
                if (n14 < n10) {
                    n11 = this.bufferSize;
                    n12 = this.pos;
                    n12 = n11 - n12;
                    this.pos = n11;
                    n11 = 1;
                    this.refillBuffer(n11);
                    while ((n13 = n10 - n12) > (n14 = this.bufferSize)) {
                        n12 += n14;
                        this.pos = n14;
                        this.refillBuffer(n11);
                    }
                    this.pos = n13;
                }
                return;
            }
            n14 = n14 - n11 - n12;
            this.skipRawBytes(n14);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    private void skipRawVarint() {
        int n10 = this.bufferSize;
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

    private boolean tryRefillBuffer(int n10) {
        int n11 = this.pos;
        int n12 = n11 + n10;
        int n13 = this.bufferSize;
        if (n12 > n13) {
            Object object;
            n12 = this.sizeLimit;
            n13 = this.totalBytesRetired;
            if (n10 > (n12 = n12 - n13 - n11)) {
                return false;
            }
            if ((n13 = n13 + n11 + n10) > (n11 = this.currentLimit)) {
                return false;
            }
            Object object2 = this.refillCallback;
            if (object2 != null) {
                object2.onRefill();
            }
            if ((n11 = this.pos) > 0) {
                n12 = this.bufferSize;
                if (n12 > n11) {
                    object = this.buffer;
                    System.arraycopy(object, n11, object, 0, n12 -= n11);
                }
                this.totalBytesRetired = n12 = this.totalBytesRetired + n11;
                this.bufferSize = n12 = this.bufferSize - n11;
                this.pos = 0;
            }
            object2 = this.input;
            Object object3 = this.buffer;
            n13 = this.bufferSize;
            int n14 = ((byte[])object3).length - n13;
            int n15 = this.sizeLimit;
            int n16 = this.totalBytesRetired;
            n11 = ((InputStream)object2).read((byte[])object3, n13, n14 = Math.min(n14, n15 = n15 - n16 - n13));
            if (n11 != 0 && n11 >= (n12 = -1) && n11 <= (n12 = ((byte[])(object3 = this.buffer)).length)) {
                if (n11 > 0) {
                    this.bufferSize = n12 = this.bufferSize + n11;
                    this.recomputeBufferSizeAfterLimit();
                    n11 = this.bufferSize;
                    n10 = n11 >= n10 ? 1 : (int)(this.tryRefillBuffer(n10) ? 1 : 0);
                    return n10 != 0;
                }
                return false;
            }
            object3 = new StringBuilder;
            ((StringBuilder)object3)();
            object = this.input.getClass();
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append("#read(byte[]) returned invalid result: ");
            ((StringBuilder)object3).append(n11);
            ((StringBuilder)object3).append("\nThe InputStream implementation is buggy.");
            object2 = ((StringBuilder)object3).toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object2);
            throw illegalStateException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(n10);
        stringBuilder.append(" bytes were already available in buffer");
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public void checkLastTagWas(int n10) {
        int n11 = this.lastTag;
        if (n11 == n10) {
            return;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void enableAliasing(boolean bl2) {
    }

    public int getBytesUntilLimit() {
        int n10 = this.currentLimit;
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return -1;
        }
        n11 = this.totalBytesRetired;
        int n12 = this.pos;
        return n10 - (n11 += n12);
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public int getTotalBytesRead() {
        int n10 = this.totalBytesRetired;
        int n11 = this.pos;
        return n10 + n11;
    }

    public boolean isAtEnd() {
        int n10 = this.pos;
        int n11 = this.bufferSize;
        boolean bl2 = true;
        if (n10 != n11 || (n10 = (int)(this.tryRefillBuffer((int)(bl2 ? 1 : 0)) ? 1 : 0)) != 0) {
            bl2 = false;
        }
        return bl2;
    }

    public void popLimit(int n10) {
        this.currentLimit = n10;
        this.recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int n10) {
        if (n10 >= 0) {
            int n11 = this.totalBytesRetired;
            int n12 = this.pos;
            n11 += n12;
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
        int n11 = this.bufferSize;
        int n12 = this.pos;
        if (n10 <= (n11 -= n12) && n10 > 0) {
            byte[] byArray = this.buffer;
            int n13 = n12 + n10;
            byArray = Arrays.copyOfRange(byArray, n12, n13);
            this.pos = n12 = this.pos + n10;
            return byArray;
        }
        return this.readRawBytesSlowPath(n10, false);
    }

    public ByteBuffer readByteBuffer() {
        int n10 = this.readRawVarint32();
        int n11 = this.bufferSize;
        int n12 = this.pos;
        if (n10 <= (n11 -= n12) && n10 > 0) {
            Object object = this.buffer;
            int n13 = n12 + n10;
            object = ByteBuffer.wrap(Arrays.copyOfRange(object, n12, n13));
            this.pos = n12 = this.pos + n10;
            return object;
        }
        if (n10 == 0) {
            return Internal.EMPTY_BYTE_BUFFER;
        }
        return ByteBuffer.wrap(this.readRawBytesSlowPath(n10, true));
    }

    public ByteString readBytes() {
        int n10 = this.readRawVarint32();
        int n11 = this.bufferSize;
        int n12 = this.pos;
        if (n10 <= (n11 -= n12) && n10 > 0) {
            ByteString byteString = ByteString.copyFrom(this.buffer, n12, n10);
            this.pos = n12 = this.pos + n10;
            return byteString;
        }
        if (n10 == 0) {
            return ByteString.EMPTY;
        }
        return this.readBytesSlowPath(n10);
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
        int n10;
        int n11 = this.pos;
        int n12 = this.bufferSize;
        if (n11 == n12) {
            n11 = 1;
            this.refillBuffer(n11);
        }
        byte[] byArray = this.buffer;
        n12 = this.pos;
        this.pos = n10 = n12 + 1;
        return byArray[n12];
    }

    public byte[] readRawBytes(int n10) {
        int n11 = this.pos;
        int n12 = this.bufferSize - n11;
        if (n10 <= n12 && n10 > 0) {
            this.pos = n10 += n11;
            return Arrays.copyOfRange(this.buffer, n11, n10);
        }
        return this.readRawBytesSlowPath(n10, false);
    }

    public int readRawLittleEndian32() {
        int n10 = this.pos;
        int n11 = this.bufferSize - n10;
        int n12 = 4;
        if (n11 < n12) {
            this.refillBuffer(n12);
            n10 = this.pos;
        }
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

    public long readRawLittleEndian64() {
        int n10;
        int n11 = this.pos;
        int n12 = this.bufferSize - n11;
        int n13 = 8;
        if (n12 < n13) {
            this.refillBuffer(n13);
            n11 = this.pos;
        }
        byte[] byArray = this.buffer;
        this.pos = n10 = n11 + 8;
        long l10 = byArray[n11];
        long l11 = 255L;
        int n14 = n11 + 1;
        long l12 = ((long)byArray[n14] & l11) << n13;
        long l13 = (l10 &= l11) | l12;
        int n15 = n11 + 2;
        l12 = ((long)byArray[n15] & l11) << 16;
        l13 |= l12;
        n15 = n11 + 3;
        l12 = ((long)byArray[n15] & l11) << 24;
        l13 |= l12;
        n15 = n11 + 4;
        l12 = ((long)byArray[n15] & l11) << 32;
        l13 |= l12;
        n15 = n11 + 5;
        l12 = ((long)byArray[n15] & l11) << 40;
        l13 |= l12;
        n15 = n11 + 6;
        l12 = ((long)byArray[n15] & l11) << 48;
        return ((long)byArray[n11 += 7] & l11) << 56 | (l13 |= l12);
    }

    /*
     * Unable to fully structure code
     */
    public int readRawVarint32() {
        block7: {
            block8: {
                block10: {
                    block9: {
                        var2_2 = this.bufferSize;
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
                            var2_2 = this.bufferSize;
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
        int n10;
        int n11;
        int n12 = this.readRawVarint32();
        if (n12 > 0) {
            n11 = this.bufferSize;
            n10 = this.pos;
            if (n12 <= (n11 -= n10)) {
                byte[] byArray = this.buffer;
                int n13 = this.pos;
                Charset charset = Internal.UTF_8;
                String string2 = new String(byArray, n13, n12, charset);
                this.pos = n10 = this.pos + n12;
                return string2;
            }
        }
        if (n12 == 0) {
            return "";
        }
        n11 = this.bufferSize;
        if (n12 <= n11) {
            this.refillBuffer(n12);
            byte[] byArray = this.buffer;
            int n14 = this.pos;
            Charset charset = Internal.UTF_8;
            String string3 = new String(byArray, n14, n12, charset);
            this.pos = n10 = this.pos + n12;
            return string3;
        }
        byte[] byArray = this.readRawBytesSlowPath(n12, false);
        Charset charset = Internal.UTF_8;
        String string4 = new String(byArray, charset);
        return string4;
    }

    public String readStringRequireUtf8() {
        byte[] byArray;
        int n10;
        int n11;
        int n12;
        int n13 = this.readRawVarint32();
        if (n13 <= (n12 = (n11 = this.bufferSize) - (n10 = this.pos)) && n13 > 0) {
            byArray = this.buffer;
            this.pos = n12 = n10 + n13;
        } else {
            if (n13 == 0) {
                return "";
            }
            if (n13 <= n11) {
                this.refillBuffer(n13);
                byArray = this.buffer;
                this.pos = n10 = n13 + 0;
            } else {
                byArray = this.readRawBytesSlowPath(n13, false);
            }
            n10 = 0;
        }
        return Utf8.decodeUtf8(byArray, n10, n13);
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
        this.totalBytesRetired = n10 = -this.pos;
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
        int n11 = this.bufferSize;
        int n12 = this.pos;
        if (n10 <= (n11 -= n12) && n10 >= 0) {
            this.pos = n12 += n10;
        } else {
            this.skipRawBytesSlowPath(n10);
        }
    }
}

