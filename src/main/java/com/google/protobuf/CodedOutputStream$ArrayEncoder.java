/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Android;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.nio.ByteBuffer;
import java.util.Objects;

public class CodedOutputStream$ArrayEncoder
extends CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;

    public CodedOutputStream$ArrayEncoder(byte[] object, int n10, int n11) {
        super(null);
        Object object2 = "buffer";
        Objects.requireNonNull(object, (String)object2);
        int n12 = n10 | n11;
        int n13 = ((byte[])object).length;
        int n14 = n10 + n11;
        if ((n12 |= (n13 -= n14)) >= 0) {
            this.buffer = object;
            this.offset = n10;
            this.position = n10;
            this.limit = n14;
            return;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        Integer n15 = n10;
        objectArray[1] = n15;
        n15 = n11;
        objectArray[2] = n15;
        object = String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void flush() {
    }

    public final int getTotalBytesWritten() {
        int n10 = this.position;
        int n11 = this.offset;
        return n10 - n11;
    }

    public final int spaceLeft() {
        int n10 = this.limit;
        int n11 = this.position;
        return n10 - n11;
    }

    public final void write(byte by2) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new CodedOutputStream$OutOfSpaceException;
            Object object2 = new Object[3];
            Integer n10 = this.position;
            object2[0] = n10;
            Integer n11 = this.limit;
            int n12 = 1;
            object2[n12] = n11;
            n10 = n12;
            object2[2] = n10;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.position;
        int n14 = n13 + 1;
        this.position = n14;
        object[n13] = by2;
    }

    public final void write(ByteBuffer byteBuffer) {
        Object object;
        int n10 = byteBuffer.remaining();
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            Object object2;
            object = new CodedOutputStream$OutOfSpaceException;
            Object[] objectArray = new Object[3];
            Integer n11 = this.position;
            objectArray[0] = n11;
            n11 = this.limit;
            objectArray[1] = n11;
            objectArray[2] = object2 = Integer.valueOf(n10);
            object2 = String.format("Pos: %d, limit: %d, len: %d", objectArray);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n12 = this.position;
        byteBuffer.get((byte[])object, n12, n10);
        int n13 = this.position + n10;
        this.position = n13;
    }

    public final void write(byte[] byArray, int n10, int n11) {
        Object[] objectArray;
        try {
            objectArray = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            objectArray = new Object[3];
            Integer n12 = this.position;
            objectArray[0] = (byte)n12;
            n12 = this.limit;
            objectArray[1] = (byte)n12;
            Object object = n11;
            objectArray[2] = (byte)object;
            object = String.format("Pos: %d, limit: %d, len: %d", objectArray);
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException((String)object, indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
        int n13 = this.position;
        System.arraycopy(byArray, n10, objectArray, n13, n11);
        int n14 = this.position + n11;
        this.position = n14;
    }

    public final void writeBool(int n10, boolean bl2) {
        this.writeTag(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        this.write((byte)n10);
    }

    public final void writeByteArray(int n10, byte[] byArray) {
        int n11 = byArray.length;
        this.writeByteArray(n10, byArray, 0, n11);
    }

    public final void writeByteArray(int n10, byte[] byArray, int n11, int n12) {
        this.writeTag(n10, 2);
        this.writeByteArrayNoTag(byArray, n11, n12);
    }

    public final void writeByteArrayNoTag(byte[] byArray, int n10, int n11) {
        this.writeUInt32NoTag(n11);
        this.write(byArray, n10, n11);
    }

    public final void writeByteBuffer(int n10, ByteBuffer byteBuffer) {
        this.writeTag(n10, 2);
        n10 = byteBuffer.capacity();
        this.writeUInt32NoTag(n10);
        this.writeRawBytes(byteBuffer);
    }

    public final void writeBytes(int n10, ByteString byteString) {
        this.writeTag(n10, 2);
        this.writeBytesNoTag(byteString);
    }

    public final void writeBytesNoTag(ByteString byteString) {
        int n10 = byteString.size();
        this.writeUInt32NoTag(n10);
        byteString.writeTo(this);
    }

    public final void writeFixed32(int n10, int n11) {
        this.writeTag(n10, 5);
        this.writeFixed32NoTag(n11);
    }

    public final void writeFixed32NoTag(int n10) {
        byte by2;
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new CodedOutputStream$OutOfSpaceException;
            Object object2 = new Object[3];
            Integer n11 = this.position;
            object2[0] = n11;
            Integer n12 = this.limit;
            by2 = 1;
            object2[by2] = n12;
            n11 = by2;
            object2[2] = n11;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.position;
        int n14 = n13 + 1;
        this.position = n14;
        by2 = (byte)(n10 & 0xFF);
        object[n13] = by2;
        n13 = n14 + 1;
        this.position = n13;
        by2 = (byte)(n10 >> 8 & 0xFF);
        object[n14] = by2;
        n14 = n13 + 1;
        this.position = n14;
        by2 = (byte)(n10 >> 16 & 0xFF);
        object[n13] = by2;
        n13 = n14 + 1;
        this.position = n13;
        n10 = (byte)(n10 >> 24 & 0xFF);
        object[n14] = n10;
    }

    public final void writeFixed64(int n10, long l10) {
        this.writeTag(n10, 1);
        this.writeFixed64NoTag(l10);
    }

    public final void writeFixed64NoTag(long l10) {
        int n10;
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new Object[3];
            Integer n11 = this.position;
            object[0] = (byte)n11;
            Integer n12 = this.limit;
            n10 = 1;
            object[n10] = (byte)n12;
            n11 = n10;
            object[2] = (byte)n11;
            object = String.format("Pos: %d, limit: %d, len: %d", object);
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException((String)object, indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
        int n13 = this.position;
        n10 = n13 + 1;
        this.position = n10;
        byte by2 = (byte)((int)l10 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        long l11 = l10 >> 8;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 16;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        l11 = l10 >> 24;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 32;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        l11 = l10 >> 40;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 48;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        n13 = 56;
        byte by3 = (byte)((int)(l10 >>= n13) & 0xFF);
        object[n10] = by3;
    }

    public final void writeInt32(int n10, int n11) {
        this.writeTag(n10, 0);
        this.writeInt32NoTag(n11);
    }

    public final void writeInt32NoTag(int n10) {
        if (n10 >= 0) {
            this.writeUInt32NoTag(n10);
        } else {
            long l10 = n10;
            this.writeUInt64NoTag(l10);
        }
    }

    public final void writeLazy(ByteBuffer byteBuffer) {
        this.write(byteBuffer);
    }

    public final void writeLazy(byte[] byArray, int n10, int n11) {
        this.write(byArray, n10, n11);
    }

    public final void writeMessage(int n10, MessageLite messageLite) {
        this.writeTag(n10, 2);
        this.writeMessageNoTag(messageLite);
    }

    public final void writeMessage(int n10, MessageLite messageLite, Schema schema) {
        this.writeTag(n10, 2);
        Object object = messageLite;
        n10 = ((AbstractMessageLite)messageLite).getSerializedSize(schema);
        this.writeUInt32NoTag(n10);
        object = this.wrapper;
        schema.writeTo(messageLite, (Writer)object);
    }

    public final void writeMessageNoTag(MessageLite messageLite) {
        int n10 = messageLite.getSerializedSize();
        this.writeUInt32NoTag(n10);
        messageLite.writeTo(this);
    }

    public final void writeMessageNoTag(MessageLite messageLite, Schema schema) {
        Object object = messageLite;
        int n10 = ((AbstractMessageLite)messageLite).getSerializedSize(schema);
        this.writeUInt32NoTag(n10);
        object = this.wrapper;
        schema.writeTo(messageLite, (Writer)object);
    }

    public final void writeMessageSetExtension(int n10, MessageLite messageLite) {
        int n11 = 1;
        int n12 = 3;
        this.writeTag(n11, n12);
        this.writeUInt32(2, n10);
        this.writeMessage(n12, messageLite);
        this.writeTag(n11, 4);
    }

    public final void writeRawBytes(ByteBuffer byteBuffer) {
        boolean bl2 = byteBuffer.hasArray();
        if (bl2) {
            byte[] byArray = byteBuffer.array();
            int n10 = byteBuffer.arrayOffset();
            int n11 = byteBuffer.capacity();
            this.write(byArray, n10, n11);
        } else {
            byteBuffer = byteBuffer.duplicate();
            byteBuffer.clear();
            this.write(byteBuffer);
        }
    }

    public final void writeRawMessageSetExtension(int n10, ByteString byteString) {
        int n11 = 1;
        int n12 = 3;
        this.writeTag(n11, n12);
        this.writeUInt32(2, n10);
        this.writeBytes(n12, byteString);
        this.writeTag(n11, 4);
    }

    public final void writeString(int n10, String string2) {
        this.writeTag(n10, 2);
        this.writeStringNoTag(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void writeStringNoTag(String string2) {
        int n10 = this.position;
        try {
            int n11 = string2.length() * 3;
            n11 = CodedOutputStream.computeUInt32SizeNoTag(n11);
            int n12 = string2.length();
            n12 = CodedOutputStream.computeUInt32SizeNoTag(n12);
            if (n12 == n11) {
                this.position = n11 = n10 + n12;
                byte[] byArray = this.buffer;
                int n13 = this.spaceLeft();
                n11 = Utf8.encode(string2, byArray, n11, n13);
                this.position = n10;
                int n14 = n11 - n10 - n12;
                this.writeUInt32NoTag(n14);
                this.position = n11;
                return;
            }
            n11 = Utf8.encodedLength(string2);
            this.writeUInt32NoTag(n11);
            byte[] byArray = this.buffer;
            n12 = this.position;
            int n15 = this.spaceLeft();
            this.position = n11 = Utf8.encode(string2, byArray, n12, n15);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            CodedOutputStream$OutOfSpaceException codedOutputStream$OutOfSpaceException = new CodedOutputStream$OutOfSpaceException(indexOutOfBoundsException);
            throw codedOutputStream$OutOfSpaceException;
        }
        catch (Utf8$UnpairedSurrogateException utf8$UnpairedSurrogateException) {
            this.position = n10;
            this.inefficientWriteStringNoTag(string2, utf8$UnpairedSurrogateException);
        }
    }

    public final void writeTag(int n10, int n11) {
        n10 = WireFormat.makeTag(n10, n11);
        this.writeUInt32NoTag(n10);
    }

    public final void writeUInt32(int n10, int n11) {
        this.writeTag(n10, 0);
        this.writeUInt32NoTag(n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void writeUInt32NoTag(int var1_1) {
        var2_2 = CodedOutputStream.access$100();
        if (var2_2 != 0 && (var2_2 = Android.isOnAndroidDevice()) == 0 && (var2_2 = this.spaceLeft()) >= (var3_3 = 5)) {
            var2_2 = var1_1 & -128;
            if (var2_2 == 0) {
                var4_4 = this.buffer;
                var3_3 = this.position;
                this.position = var5_7 = var3_3 + 1;
                var6_10 = var3_3;
                var1_1 = (byte)var1_1;
                UnsafeUtil.putByte(var4_4, var6_10, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            UnsafeUtil.putByte(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                UnsafeUtil.putByte(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            UnsafeUtil.putByte(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                UnsafeUtil.putByte(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            UnsafeUtil.putByte(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                UnsafeUtil.putByte(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            UnsafeUtil.putByte(var4_5, var6_11, var8_12);
            var1_1 >>>= 7;
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var1_1 = (byte)var1_1;
            UnsafeUtil.putByte(var4_5, var6_11, (byte)var1_1);
            return;
        }
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl97
            var4_6 /* !! */  = this.buffer;
            break;
        }
        catch (IndexOutOfBoundsException var9_14) {
            var4_6 /* !! */  = (byte[])new CodedOutputStream$OutOfSpaceException;
            var10_15 /* !! */  = new Object[3];
            var11_16 = this.position;
            var10_15 /* !! */ [0] = var11_16;
            var12_17 = this.limit;
            var8_13 = 1;
            var10_15 /* !! */ [var8_13] = var12_17;
            var11_16 = var8_13;
            var10_15 /* !! */ [2] = var11_16;
            var10_15 /* !! */  = String.format("Pos: %d, limit: %d, len: %d", var10_15 /* !! */ );
            var4_6 /* !! */ ((String)var10_15 /* !! */ , var9_14);
            throw var4_6 /* !! */ ;
        }
        {
            var3_3 = this.position;
            var5_9 = var3_3 + 1;
            this.position = var5_9;
            var1_1 = (byte)var1_1;
            var4_6 /* !! */ [var3_3] = var1_1;
            return;
lbl97:
            // 1 sources

            var4_6 /* !! */  = this.buffer;
            var3_3 = this.position;
            var5_9 = var3_3 + 1;
            this.position = var5_9;
            var5_9 = (byte)(var1_1 & 127 | 128);
            var4_6 /* !! */ [var3_3] = var5_9;
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void writeUInt64(int n10, long l10) {
        this.writeTag(n10, 0);
        this.writeUInt64NoTag(l10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void writeUInt64NoTag(long var1_1) {
        var3_2 = CodedOutputStream.access$100();
        var4_3 = 7;
        var5_4 = 0L;
        var7_5 = -128;
        if (var3_2 != 0 && (var3_2 = this.spaceLeft()) >= (var9_6 = 10)) {
            while (true) {
                if ((var3_2 = (int)((cfr_temp_0 = (var10_10 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) {
                    var12_12 = this.buffer;
                    var4_3 = this.position;
                    this.position = var13_14 = var4_3 + 1;
                    var14_16 = var4_3;
                    var16_17 = (byte)var1_1;
                    UnsafeUtil.putByte(var12_12, var14_16, var16_17);
                    return;
                }
                var12_12 = this.buffer;
                var9_6 = this.position;
                this.position = var17_7 = var9_6 + 1;
                var10_10 = var9_6;
                var18_9 = (byte)((int)var1_1 & 127 | 128);
                UnsafeUtil.putByte(var12_12, var10_10, var18_9);
                var1_1 >>>= var4_3;
            }
        }
        while (true) {
            if ((var3_2 = (int)((cfr_temp_1 = (var10_11 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) ** GOTO lbl48
            var12_13 /* !! */  = this.buffer;
            break;
        }
        catch (IndexOutOfBoundsException var19_19) {
            var12_13 /* !! */  = (byte[])new Object[3];
            var21_21 = this.position;
            var12_13 /* !! */ [0] = (byte)var21_21;
            var22_22 = this.limit;
            var13_15 = 1;
            var12_13 /* !! */ [var13_15] = (byte)var22_22;
            var21_21 = var13_15;
            var12_13 /* !! */ [2] = (byte)var21_21;
            var12_13 /* !! */  = (byte[])String.format("Pos: %d, limit: %d, len: %d", var12_13 /* !! */ );
            var20_20 = new CodedOutputStream$OutOfSpaceException((String)var12_13 /* !! */ , var19_19);
            throw var20_20;
        }
        {
            var4_3 = this.position;
            var13_15 = var4_3 + 1;
            this.position = var13_15;
            var16_18 = (byte)var1_1;
            var12_13 /* !! */ [var4_3] = var16_18;
            return;
lbl48:
            // 1 sources

            var12_13 /* !! */  = this.buffer;
            var9_6 = this.position;
            var17_8 = var9_6 + 1;
            this.position = var17_8;
            var17_8 = (byte)((int)var1_1 & 127 | 128);
            var12_13 /* !! */ [var9_6] = var17_8;
            var1_1 >>>= var4_3;
            continue;
        }
    }
}

