/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream$1;
import com.google.protobuf.CodedOutputStream$ArrayEncoder;
import com.google.protobuf.CodedOutputStream$ByteOutputEncoder;
import com.google.protobuf.CodedOutputStream$HeapNioEncoder;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.CodedOutputStream$OutputStreamEncoder;
import com.google.protobuf.CodedOutputStream$SafeDirectNioEncoder;
import com.google.protobuf.CodedOutputStream$UnsafeDirectNioEncoder;
import com.google.protobuf.CodedOutputStreamWriter;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream
extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private boolean serializationDeterministic;
    public CodedOutputStreamWriter wrapper;

    static {
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    private CodedOutputStream() {
    }

    public /* synthetic */ CodedOutputStream(CodedOutputStream$1 codedOutputStream$1) {
        this();
    }

    public static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static int computeBoolSize(int n10, boolean bl2) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeBoolSizeNoTag(bl2);
        return n10 + n11;
    }

    public static int computeBoolSizeNoTag(boolean bl2) {
        return 1;
    }

    public static int computeByteArraySize(int n10, byte[] byArray) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeByteArraySizeNoTag(byArray);
        return n10 + n11;
    }

    public static int computeByteArraySizeNoTag(byte[] byArray) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(byArray.length);
    }

    public static int computeByteBufferSize(int n10, ByteBuffer byteBuffer) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeByteBufferSizeNoTag(byteBuffer);
        return n10 + n11;
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int n10, ByteString byteString) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeBytesSizeNoTag(byteString);
        return n10 + n11;
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int n10, double d10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeDoubleSizeNoTag(d10);
        return n10 + n11;
    }

    public static int computeDoubleSizeNoTag(double d10) {
        return 8;
    }

    public static int computeEnumSize(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeEnumSizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeEnumSizeNoTag(int n10) {
        return CodedOutputStream.computeInt32SizeNoTag(n10);
    }

    public static int computeFixed32Size(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeFixed32SizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeFixed32SizeNoTag(int n10) {
        return 4;
    }

    public static int computeFixed64Size(int n10, long l10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeFixed64SizeNoTag(l10);
        return n10 + n11;
    }

    public static int computeFixed64SizeNoTag(long l10) {
        return 8;
    }

    public static int computeFloatSize(int n10, float f10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeFloatSizeNoTag(f10);
        return n10 + n11;
    }

    public static int computeFloatSizeNoTag(float f10) {
        return 4;
    }

    public static int computeGroupSize(int n10, MessageLite messageLite) {
        n10 = CodedOutputStream.computeTagSize(n10) * 2;
        int n11 = CodedOutputStream.computeGroupSizeNoTag(messageLite);
        return n10 + n11;
    }

    public static int computeGroupSize(int n10, MessageLite messageLite, Schema schema) {
        n10 = CodedOutputStream.computeTagSize(n10) * 2;
        int n11 = CodedOutputStream.computeGroupSizeNoTag(messageLite, schema);
        return n10 + n11;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite)messageLite).getSerializedSize(schema);
    }

    public static int computeInt32Size(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeInt32SizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeInt32SizeNoTag(int n10) {
        if (n10 >= 0) {
            return CodedOutputStream.computeUInt32SizeNoTag(n10);
        }
        return 10;
    }

    public static int computeInt64Size(int n10, long l10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeInt64SizeNoTag(l10);
        return n10 + n11;
    }

    public static int computeInt64SizeNoTag(long l10) {
        return CodedOutputStream.computeUInt64SizeNoTag(l10);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int n10, LazyFieldLite lazyFieldLite) {
        int n11 = CodedOutputStream.computeTagSize(1);
        int n12 = 2;
        n11 *= n12;
        n10 = CodedOutputStream.computeUInt32Size(n12, n10);
        n11 += n10;
        n10 = CodedOutputStream.computeLazyFieldSize(3, lazyFieldLite);
        return n11 + n10;
    }

    public static int computeLazyFieldSize(int n10, LazyFieldLite lazyFieldLite) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeLazyFieldSizeNoTag(lazyFieldLite);
        return n10 + n11;
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int n10) {
        return CodedOutputStream.computeUInt32SizeNoTag(n10) + n10;
    }

    public static int computeMessageSetExtensionSize(int n10, MessageLite messageLite) {
        int n11 = CodedOutputStream.computeTagSize(1);
        int n12 = 2;
        n11 *= n12;
        n10 = CodedOutputStream.computeUInt32Size(n12, n10);
        n11 += n10;
        n10 = CodedOutputStream.computeMessageSize(3, messageLite);
        return n11 + n10;
    }

    public static int computeMessageSize(int n10, MessageLite messageLite) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeMessageSizeNoTag(messageLite);
        return n10 + n11;
    }

    public static int computeMessageSize(int n10, MessageLite messageLite, Schema schema) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeMessageSizeNoTag(messageLite, schema);
        return n10 + n11;
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(((AbstractMessageLite)messageLite).getSerializedSize(schema));
    }

    public static int computePreferredBufferSize(int n10) {
        int n11 = 4096;
        if (n10 > n11) {
            return n11;
        }
        return n10;
    }

    public static int computeRawMessageSetExtensionSize(int n10, ByteString byteString) {
        int n11 = CodedOutputStream.computeTagSize(1);
        int n12 = 2;
        n11 *= n12;
        n10 = CodedOutputStream.computeUInt32Size(n12, n10);
        n11 += n10;
        n10 = CodedOutputStream.computeBytesSize(3, byteString);
        return n11 + n10;
    }

    public static int computeRawVarint32Size(int n10) {
        return CodedOutputStream.computeUInt32SizeNoTag(n10);
    }

    public static int computeRawVarint64Size(long l10) {
        return CodedOutputStream.computeUInt64SizeNoTag(l10);
    }

    public static int computeSFixed32Size(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeSFixed32SizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeSFixed32SizeNoTag(int n10) {
        return 4;
    }

    public static int computeSFixed64Size(int n10, long l10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeSFixed64SizeNoTag(l10);
        return n10 + n11;
    }

    public static int computeSFixed64SizeNoTag(long l10) {
        return 8;
    }

    public static int computeSInt32Size(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeSInt32SizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeSInt32SizeNoTag(int n10) {
        return CodedOutputStream.computeUInt32SizeNoTag(CodedOutputStream.encodeZigZag32(n10));
    }

    public static int computeSInt64Size(int n10, long l10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeSInt64SizeNoTag(l10);
        return n10 + n11;
    }

    public static int computeSInt64SizeNoTag(long l10) {
        return CodedOutputStream.computeUInt64SizeNoTag(CodedOutputStream.encodeZigZag64(l10));
    }

    public static int computeStringSize(int n10, String string2) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeStringSizeNoTag(string2);
        return n10 + n11;
    }

    public static int computeStringSizeNoTag(String object) {
        int n10;
        try {
            n10 = Utf8.encodedLength((CharSequence)object);
        }
        catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
            Charset charset = Internal.UTF_8;
            object = ((String)object).getBytes(charset);
            n10 = ((Object)object).length;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(n10);
    }

    public static int computeTagSize(int n10) {
        return CodedOutputStream.computeUInt32SizeNoTag(WireFormat.makeTag(n10, 0));
    }

    public static int computeUInt32Size(int n10, int n11) {
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 = CodedOutputStream.computeUInt32SizeNoTag(n11);
        return n10 + n11;
    }

    public static int computeUInt32SizeNoTag(int n10) {
        int n11 = n10 & 0xFFFFFF80;
        if (n11 == 0) {
            return 1;
        }
        n11 = n10 & 0xFFFFC000;
        if (n11 == 0) {
            return 2;
        }
        n11 = 0xFFE00000 & n10;
        if (n11 == 0) {
            return 3;
        }
        n11 = -268435456;
        if ((n10 &= n11) == 0) {
            return 4;
        }
        return 5;
    }

    public static int computeUInt64Size(int n10, long l10) {
        n10 = CodedOutputStream.computeTagSize(n10);
        int n11 = CodedOutputStream.computeUInt64SizeNoTag(l10);
        return n10 + n11;
    }

    public static int computeUInt64SizeNoTag(long l10) {
        long l11;
        long l12;
        int n10;
        long l13 = (long)-128 & l10;
        long l14 = 0L;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return 1;
        }
        object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object < 0) {
            return 10;
        }
        l13 = 0xFFFFFFF800000000L & l10;
        long l16 = l13 - l14;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false) {
            object = 6;
            n10 = 28;
            l10 >>>= n10;
        } else {
            object = 2;
        }
        long l17 = 0xFFE00000L & l10;
        n10 = (int)(l17 == l14 ? 0 : (l17 < l14 ? -1 : 1));
        if (n10 != 0) {
            object += 2;
            n10 = 14;
            l10 >>>= n10;
        }
        if ((l12 = (l11 = (l10 &= (l17 = -16384L)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            ++object;
        }
        return (int)object;
    }

    public static int encodeZigZag32(int n10) {
        int n11 = n10 << 1;
        return n10 >> 31 ^ n11;
    }

    public static long encodeZigZag64(long l10) {
        long l11 = l10 << 1;
        return l10 >> 63 ^ l11;
    }

    public static CodedOutputStream newInstance(ByteOutput object, int n10) {
        if (n10 >= 0) {
            CodedOutputStream$ByteOutputEncoder codedOutputStream$ByteOutputEncoder = new CodedOutputStream$ByteOutputEncoder((ByteOutput)object, n10);
            return codedOutputStream$ByteOutputEncoder;
        }
        object = new IllegalArgumentException("bufferSize must be positive");
        throw object;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return CodedOutputStream.newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int n10) {
        CodedOutputStream$OutputStreamEncoder codedOutputStream$OutputStreamEncoder = new CodedOutputStream$OutputStreamEncoder(outputStream, n10);
        return codedOutputStream$OutputStreamEncoder;
    }

    public static CodedOutputStream newInstance(ByteBuffer object) {
        boolean bl2 = ((ByteBuffer)object).hasArray();
        if (bl2) {
            CodedOutputStream$HeapNioEncoder codedOutputStream$HeapNioEncoder = new CodedOutputStream$HeapNioEncoder((ByteBuffer)object);
            return codedOutputStream$HeapNioEncoder;
        }
        bl2 = ((ByteBuffer)object).isDirect();
        if (bl2 && !(bl2 = ((Buffer)object).isReadOnly())) {
            bl2 = CodedOutputStream$UnsafeDirectNioEncoder.isSupported();
            object = bl2 ? CodedOutputStream.newUnsafeInstance((ByteBuffer)object) : CodedOutputStream.newSafeInstance((ByteBuffer)object);
            return object;
        }
        object = new IllegalArgumentException("ByteBuffer is read-only");
        throw object;
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int n10) {
        return CodedOutputStream.newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(byte[] byArray) {
        int n10 = byArray.length;
        return CodedOutputStream.newInstance(byArray, 0, n10);
    }

    public static CodedOutputStream newInstance(byte[] byArray, int n10, int n11) {
        CodedOutputStream$ArrayEncoder codedOutputStream$ArrayEncoder = new CodedOutputStream$ArrayEncoder(byArray, n10, n11);
        return codedOutputStream$ArrayEncoder;
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        CodedOutputStream$SafeDirectNioEncoder codedOutputStream$SafeDirectNioEncoder = new CodedOutputStream$SafeDirectNioEncoder(byteBuffer);
        return codedOutputStream$SafeDirectNioEncoder;
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        CodedOutputStream$UnsafeDirectNioEncoder codedOutputStream$UnsafeDirectNioEncoder = new CodedOutputStream$UnsafeDirectNioEncoder(byteBuffer);
        return codedOutputStream$UnsafeDirectNioEncoder;
    }

    public final void checkNoSpaceLeft() {
        int n10 = this.spaceLeft();
        if (n10 == 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String object, Utf8$UnpairedSurrogateException object2) {
        Logger logger = CodedOutputStream.logger;
        Level level = Level.WARNING;
        String string2 = "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!";
        logger.log(level, string2, (Throwable)object2);
        object2 = Internal.UTF_8;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        this.writeUInt32NoTag(n10);
        n10 = 0;
        object2 = null;
        int n11 = ((Object)object).length;
        try {
            this.writeLazy((byte[])object, 0, n11);
            return;
        }
        catch (CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException) {
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object2 = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw object2;
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    public abstract void write(byte var1);

    public abstract void write(ByteBuffer var1);

    public abstract void write(byte[] var1, int var2, int var3);

    public abstract void writeBool(int var1, boolean var2);

    public final void writeBoolNoTag(boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.write(by2);
    }

    public abstract void writeByteArray(int var1, byte[] var2);

    public abstract void writeByteArray(int var1, byte[] var2, int var3, int var4);

    public final void writeByteArrayNoTag(byte[] byArray) {
        int n10 = byArray.length;
        this.writeByteArrayNoTag(byArray, 0, n10);
    }

    public abstract void writeByteArrayNoTag(byte[] var1, int var2, int var3);

    public abstract void writeByteBuffer(int var1, ByteBuffer var2);

    public abstract void writeBytes(int var1, ByteString var2);

    public abstract void writeBytesNoTag(ByteString var1);

    public final void writeDouble(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.writeFixed64(n10, l10);
    }

    public final void writeDoubleNoTag(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.writeFixed64NoTag(l10);
    }

    public final void writeEnum(int n10, int n11) {
        this.writeInt32(n10, n11);
    }

    public final void writeEnumNoTag(int n10) {
        this.writeInt32NoTag(n10);
    }

    public abstract void writeFixed32(int var1, int var2);

    public abstract void writeFixed32NoTag(int var1);

    public abstract void writeFixed64(int var1, long var2);

    public abstract void writeFixed64NoTag(long var1);

    public final void writeFloat(int n10, float f10) {
        int n11 = Float.floatToRawIntBits(f10);
        this.writeFixed32(n10, n11);
    }

    public final void writeFloatNoTag(float f10) {
        int n10 = Float.floatToRawIntBits(f10);
        this.writeFixed32NoTag(n10);
    }

    public final void writeGroup(int n10, MessageLite messageLite) {
        this.writeTag(n10, 3);
        this.writeGroupNoTag(messageLite);
        this.writeTag(n10, 4);
    }

    public final void writeGroup(int n10, MessageLite messageLite, Schema schema) {
        this.writeTag(n10, 3);
        this.writeGroupNoTag(messageLite, schema);
        this.writeTag(n10, 4);
    }

    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) {
        CodedOutputStreamWriter codedOutputStreamWriter = this.wrapper;
        schema.writeTo(messageLite, codedOutputStreamWriter);
    }

    public abstract void writeInt32(int var1, int var2);

    public abstract void writeInt32NoTag(int var1);

    public final void writeInt64(int n10, long l10) {
        this.writeUInt64(n10, l10);
    }

    public final void writeInt64NoTag(long l10) {
        this.writeUInt64NoTag(l10);
    }

    public abstract void writeLazy(ByteBuffer var1);

    public abstract void writeLazy(byte[] var1, int var2, int var3);

    public abstract void writeMessage(int var1, MessageLite var2);

    public abstract void writeMessage(int var1, MessageLite var2, Schema var3);

    public abstract void writeMessageNoTag(MessageLite var1);

    public abstract void writeMessageNoTag(MessageLite var1, Schema var2);

    public abstract void writeMessageSetExtension(int var1, MessageLite var2);

    public final void writeRawByte(byte by2) {
        this.write(by2);
    }

    public final void writeRawByte(int n10) {
        n10 = (byte)n10;
        this.write((byte)n10);
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.writeTo(this);
    }

    public abstract void writeRawBytes(ByteBuffer var1);

    public final void writeRawBytes(byte[] byArray) {
        int n10 = byArray.length;
        this.write(byArray, 0, n10);
    }

    public final void writeRawBytes(byte[] byArray, int n10, int n11) {
        this.write(byArray, n10, n11);
    }

    public final void writeRawLittleEndian32(int n10) {
        this.writeFixed32NoTag(n10);
    }

    public final void writeRawLittleEndian64(long l10) {
        this.writeFixed64NoTag(l10);
    }

    public abstract void writeRawMessageSetExtension(int var1, ByteString var2);

    public final void writeRawVarint32(int n10) {
        this.writeUInt32NoTag(n10);
    }

    public final void writeRawVarint64(long l10) {
        this.writeUInt64NoTag(l10);
    }

    public final void writeSFixed32(int n10, int n11) {
        this.writeFixed32(n10, n11);
    }

    public final void writeSFixed32NoTag(int n10) {
        this.writeFixed32NoTag(n10);
    }

    public final void writeSFixed64(int n10, long l10) {
        this.writeFixed64(n10, l10);
    }

    public final void writeSFixed64NoTag(long l10) {
        this.writeFixed64NoTag(l10);
    }

    public final void writeSInt32(int n10, int n11) {
        n11 = CodedOutputStream.encodeZigZag32(n11);
        this.writeUInt32(n10, n11);
    }

    public final void writeSInt32NoTag(int n10) {
        n10 = CodedOutputStream.encodeZigZag32(n10);
        this.writeUInt32NoTag(n10);
    }

    public final void writeSInt64(int n10, long l10) {
        l10 = CodedOutputStream.encodeZigZag64(l10);
        this.writeUInt64(n10, l10);
    }

    public final void writeSInt64NoTag(long l10) {
        l10 = CodedOutputStream.encodeZigZag64(l10);
        this.writeUInt64NoTag(l10);
    }

    public abstract void writeString(int var1, String var2);

    public abstract void writeStringNoTag(String var1);

    public abstract void writeTag(int var1, int var2);

    public abstract void writeUInt32(int var1, int var2);

    public abstract void writeUInt32NoTag(int var1);

    public abstract void writeUInt64(int var1, long var2);

    public abstract void writeUInt64NoTag(long var1);
}

