/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream$1;
import com.google.protobuf.CodedInputStream$ArrayDecoder;
import com.google.protobuf.CodedInputStream$IterableDirectByteBufferDecoder;
import com.google.protobuf.CodedInputStream$StreamDecoder;
import com.google.protobuf.CodedInputStream$UnsafeDirectNioDecoder;
import com.google.protobuf.CodedInputStreamReader;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.IterableByteBufferInputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    public int recursionDepth;
    public int recursionLimit = 100;
    private boolean shouldDiscardUnknownFields = false;
    public int sizeLimit = -1 >>> 1;
    public CodedInputStreamReader wrapper;

    private CodedInputStream() {
    }

    public /* synthetic */ CodedInputStream(CodedInputStream$1 codedInputStream$1) {
        this();
    }

    public static int decodeZigZag32(int n10) {
        int n11 = n10 >>> 1;
        return -(n10 & 1) ^ n11;
    }

    public static long decodeZigZag64(long l10) {
        long l11 = l10 >>> 1;
        return -(l10 & 1L) ^ l11;
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return CodedInputStream.newInstance(inputStream, 4096);
    }

    public static CodedInputStream newInstance(InputStream object, int n10) {
        if (n10 > 0) {
            if (object == null) {
                return CodedInputStream.newInstance(Internal.EMPTY_BYTE_ARRAY);
            }
            CodedInputStream$StreamDecoder codedInputStream$StreamDecoder = new CodedInputStream$StreamDecoder((InputStream)object, n10, null);
            return codedInputStream$StreamDecoder;
        }
        object = new IllegalArgumentException("bufferSize must be > 0");
        throw object;
    }

    public static CodedInputStream newInstance(Iterable iterable) {
        boolean bl2 = CodedInputStream$UnsafeDirectNioDecoder.isSupported();
        if (!bl2) {
            IterableByteBufferInputStream iterableByteBufferInputStream = new IterableByteBufferInputStream(iterable);
            return CodedInputStream.newInstance(iterableByteBufferInputStream);
        }
        return CodedInputStream.newInstance(iterable, false);
    }

    public static CodedInputStream newInstance(Iterable iterable, boolean bl2) {
        boolean bl3;
        Object object = iterable.iterator();
        int n10 = 0;
        int n11 = 0;
        while (bl3 = object.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer)object.next();
            int n12 = byteBuffer.remaining();
            n11 += n12;
            n12 = (int)(byteBuffer.hasArray() ? 1 : 0);
            if (n12 != 0) {
                n10 |= 1;
                continue;
            }
            bl3 = byteBuffer.isDirect();
            if (bl3) {
                n10 |= 2;
                continue;
            }
            n10 |= 4;
        }
        int n13 = 2;
        if (n10 == n13) {
            object = new CodedInputStream$IterableDirectByteBufferDecoder(iterable, n11, bl2, null);
            return object;
        }
        IterableByteBufferInputStream iterableByteBufferInputStream = new IterableByteBufferInputStream(iterable);
        return CodedInputStream.newInstance(iterableByteBufferInputStream);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return CodedInputStream.newInstance(byteBuffer, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean bl2) {
        boolean bl3 = byteBuffer.hasArray();
        if (bl3) {
            byte[] codedInputStream$UnsafeDirectNioDecoder = byteBuffer.array();
            int n10 = byteBuffer.arrayOffset();
            int n11 = byteBuffer.position();
            int n12 = byteBuffer.remaining();
            return CodedInputStream.newInstance(codedInputStream$UnsafeDirectNioDecoder, n10 += n11, n12, bl2);
        }
        bl3 = byteBuffer.isDirect();
        if (bl3 && (bl3 = CodedInputStream$UnsafeDirectNioDecoder.isSupported())) {
            CodedInputStream$UnsafeDirectNioDecoder byArray = new CodedInputStream$UnsafeDirectNioDecoder(byteBuffer, bl2, null);
            return byArray;
        }
        int n13 = byteBuffer.remaining();
        byte[] byArray = new byte[n13];
        byteBuffer.duplicate().get(byArray);
        return CodedInputStream.newInstance(byArray, 0, n13, true);
    }

    public static CodedInputStream newInstance(byte[] byArray) {
        int n10 = byArray.length;
        return CodedInputStream.newInstance(byArray, 0, n10);
    }

    public static CodedInputStream newInstance(byte[] byArray, int n10, int n11) {
        return CodedInputStream.newInstance(byArray, n10, n11, false);
    }

    public static CodedInputStream newInstance(byte[] byArray, int n10, int n11, boolean bl2) {
        CodedInputStream$ArrayDecoder codedInputStream$ArrayDecoder = new CodedInputStream$ArrayDecoder(byArray, n10, n11, bl2, null);
        try {
            codedInputStream$ArrayDecoder.pushLimit(n11);
            return codedInputStream$ArrayDecoder;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(invalidProtocolBufferException);
            throw illegalArgumentException;
        }
    }

    public static int readRawVarint32(int n10, InputStream inputStream) {
        int n11;
        int n12;
        int n13;
        block6: {
            n13 = n10 & 0x80;
            if (n13 == 0) {
                return n10;
            }
            n10 &= 0x7F;
            n13 = 7;
            while (true) {
                n12 = 32;
                n11 = -1;
                if (n13 >= n12) break block6;
                n12 = inputStream.read();
                if (n12 == n11) break;
                n11 = (n12 & 0x7F) << n13;
                n10 |= n11;
                if ((n12 &= 0x80) == 0) {
                    return n10;
                }
                n13 += 7;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        while (n13 < (n12 = 64)) {
            n12 = inputStream.read();
            if (n12 != n11) {
                if ((n12 &= 0x80) == 0) {
                    return n10;
                }
                n13 += 7;
                continue;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public static int readRawVarint32(InputStream inputStream) {
        int n10;
        int n11 = inputStream.read();
        if (n11 != (n10 = -1)) {
            return CodedInputStream.readRawVarint32(n11, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public abstract void checkLastTagWas(int var1);

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean var1);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int var1);

    public abstract int pushLimit(int var1);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract MessageLite readGroup(int var1, Parser var2, ExtensionRegistryLite var3);

    public abstract void readGroup(int var1, MessageLite$Builder var2, ExtensionRegistryLite var3);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract MessageLite readMessage(Parser var1, ExtensionRegistryLite var2);

    public abstract void readMessage(MessageLite$Builder var1, ExtensionRegistryLite var2);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int var1);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    public abstract void readUnknownGroup(int var1, MessageLite$Builder var2);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int n10) {
        if (n10 >= 0) {
            int n11 = this.recursionLimit;
            this.recursionLimit = n10;
            return n11;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recursion limit cannot be negative: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final int setSizeLimit(int n10) {
        if (n10 >= 0) {
            int n11 = this.sizeLimit;
            this.sizeLimit = n10;
            return n11;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size limit cannot be negative: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int var1);

    public abstract boolean skipField(int var1, CodedOutputStream var2);

    public abstract void skipMessage();

    public abstract void skipMessage(CodedOutputStream var1);

    public abstract void skipRawBytes(int var1);

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }
}

