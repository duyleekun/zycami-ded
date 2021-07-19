/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BinaryReader;
import com.google.protobuf.BinaryReader$1;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Schema;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public final class BinaryReader$SafeHeapReader
extends BinaryReader {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int endGroupTag;
    private final int initialPos;
    private int limit;
    private int pos;
    private int tag;

    public BinaryReader$SafeHeapReader(ByteBuffer byteBuffer, boolean bl2) {
        super(null);
        int n10;
        int n11;
        this.bufferIsImmutable = bl2;
        byte[] byArray = byteBuffer.array();
        this.buffer = byArray;
        int n12 = byteBuffer.arrayOffset();
        int n13 = byteBuffer.position();
        this.pos = n11 = n12 + n13;
        this.initialPos = n11;
        int n14 = byteBuffer.arrayOffset();
        int n15 = byteBuffer.limit();
        this.limit = n10 = n14 + n15;
    }

    private boolean isAtEnd() {
        int n10 = this.pos;
        int n11 = this.limit;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    private byte readByte() {
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

    private Object readField(WireFormat$FieldType object, Class clazz, ExtensionRegistryLite extensionRegistryLite) {
        int[] nArray = BinaryReader$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("unsupported field type.");
                throw object;
            }
            case 17: {
                return this.readUInt64();
            }
            case 16: {
                return this.readUInt32();
            }
            case 15: {
                return this.readStringRequireUtf8();
            }
            case 14: {
                return this.readSInt64();
            }
            case 13: {
                return this.readSInt32();
            }
            case 12: {
                return this.readSFixed64();
            }
            case 11: {
                return this.readSFixed32();
            }
            case 10: {
                return this.readMessage(clazz, extensionRegistryLite);
            }
            case 9: {
                return this.readInt64();
            }
            case 8: {
                return this.readInt32();
            }
            case 7: {
                return Float.valueOf(this.readFloat());
            }
            case 6: {
                return this.readFixed64();
            }
            case 5: {
                return this.readFixed32();
            }
            case 4: {
                return this.readEnum();
            }
            case 3: {
                return this.readDouble();
            }
            case 2: {
                return this.readBytes();
            }
            case 1: 
        }
        return this.readBool();
    }

    private Object readGroup(Schema object, ExtensionRegistryLite extensionRegistryLite) {
        block7: {
            Object object2;
            int n10 = this.endGroupTag;
            int n11 = WireFormat.getTagFieldNumber(this.tag);
            int n12 = 4;
            this.endGroupTag = n11 = WireFormat.makeTag(n11, n12);
            try {
                object2 = object.newInstance();
            }
            catch (Throwable throwable) {
                this.endGroupTag = n10;
                throw throwable;
            }
            object.mergeFrom(object2, this, extensionRegistryLite);
            object.makeImmutable(object2);
            int n13 = this.tag;
            int n14 = this.endGroupTag;
            if (n13 != n14) break block7;
            this.endGroupTag = n10;
            return object2;
        }
        object = InvalidProtocolBufferException.parseFailure();
        throw object;
    }

    private int readLittleEndian32() {
        this.requireBytes(4);
        return this.readLittleEndian32_NoCheck();
    }

    private int readLittleEndian32_NoCheck() {
        int n10;
        int n11 = this.pos;
        byte[] byArray = this.buffer;
        this.pos = n10 = n11 + 4;
        n10 = byArray[n11] & 0xFF;
        int n12 = n11 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n10 |= n12;
        n12 = n11 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n11 += 3] & 0xFF) << 24 | (n10 |= n12);
    }

    private long readLittleEndian64() {
        this.requireBytes(8);
        return this.readLittleEndian64_NoCheck();
    }

    private long readLittleEndian64_NoCheck() {
        int n10;
        int n11 = this.pos;
        byte[] byArray = this.buffer;
        this.pos = n10 = n11 + 8;
        long l10 = byArray[n11];
        long l11 = 255L;
        l10 &= l11;
        int n12 = n11 + 1;
        long l12 = ((long)byArray[n12] & l11) << 8;
        l10 |= l12;
        n12 = n11 + 2;
        l12 = ((long)byArray[n12] & l11) << 16;
        l10 |= l12;
        n12 = n11 + 3;
        l12 = ((long)byArray[n12] & l11) << 24;
        l10 |= l12;
        n12 = n11 + 4;
        l12 = ((long)byArray[n12] & l11) << 32;
        l10 |= l12;
        n12 = n11 + 5;
        l12 = ((long)byArray[n12] & l11) << 40;
        l10 |= l12;
        n12 = n11 + 6;
        l12 = ((long)byArray[n12] & l11) << 48;
        return ((long)byArray[n11 += 7] & l11) << 56 | (l10 |= l12);
    }

    private Object readMessage(Schema object, ExtensionRegistryLite extensionRegistryLite) {
        block6: {
            Object object2;
            int n10;
            int n11 = this.readVarint32();
            this.requireBytes(n11);
            int n12 = this.limit;
            this.limit = n10 = this.pos + n11;
            try {
                object2 = object.newInstance();
            }
            catch (Throwable throwable) {
                this.limit = n12;
                throw throwable;
            }
            object.mergeFrom(object2, this, extensionRegistryLite);
            object.makeImmutable(object2);
            int n13 = this.pos;
            if (n13 != n10) break block6;
            this.limit = n12;
            return object2;
        }
        object = InvalidProtocolBufferException.parseFailure();
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private int readVarint32() {
        block7: {
            block6: {
                block9: {
                    block8: {
                        var2_2 = this.limit;
                        var1_1 = this.pos;
                        if (var2_2 == var1_1) break block7;
                        var3_3 = this.buffer;
                        var4_4 = var1_1 + 1;
                        if ((var1_1 = var3_3[var1_1]) >= 0) {
                            this.pos = var4_4;
                            return var1_1;
                        }
                        var5_5 = 9;
                        if ((var2_2 -= var4_4) < var5_5) {
                            return (int)this.readVarint64SlowPath();
                        }
                        var2_2 = var4_4 + 1;
                        if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) >= 0) break block8;
                        var1_1 ^= -128;
                        break block6;
                    }
                    var4_4 = var2_2 + 1;
                    if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) >= 0) {
                        var1_1 ^= 16256;
lbl20:
                        // 4 sources

                        while (true) {
                            var2_2 = var4_4;
                            break block6;
                            break;
                        }
                    }
                    var2_2 = var4_4 + 1;
                    if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 21)) >= 0) break block9;
                    var6_6 = -2080896;
                    var1_1 ^= var6_6;
                    break block6;
                }
                var4_4 = var2_2 + 1;
                var2_2 = var3_3[var2_2];
                var5_5 = var2_2 << 28;
                var1_1 ^= var5_5;
                var5_5 = 266354560;
                var1_1 ^= var5_5;
                if (var2_2 >= 0) ** GOTO lbl20
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) >= 0) break block6;
                var4_4 = var2_2 + 1;
                if ((var2_2 = var3_3[var2_2]) >= 0) ** GOTO lbl20
                var2_2 = var4_4 + 1;
                if ((var4_4 = var3_3[var4_4]) < 0) {
                    var4_4 = var2_2 + 1;
                    if ((var2_2 = var3_3[var2_2]) < 0) ** break;
                    ** continue;
                    var2_2 = var4_4 + 1;
                    var6_7 = var3_3[var4_4];
                    if (var6_7 < 0) {
                        throw InvalidProtocolBufferException.malformedVarint();
                    }
                }
            }
            this.pos = var2_2;
            return var1_1;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private long readVarint64SlowPath() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 7) {
            n10 = this.readByte();
            int n11 = n10 & 0x7F;
            long l11 = (long)n11 << i10;
            l10 |= l11;
            if ((n10 &= 0x80) != 0) continue;
            return l10;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void requireBytes(int n10) {
        if (n10 >= 0) {
            int n11 = this.limit;
            int n12 = this.pos;
            if (n10 <= (n11 -= n12)) {
                return;
            }
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void requirePosition(int n10) {
        int n11 = this.pos;
        if (n11 == n10) {
            return;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private void requireWireType(int n10) {
        int n11 = WireFormat.getTagWireType(this.tag);
        if (n11 == n10) {
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    private void skipBytes(int n10) {
        int n11;
        this.requireBytes(n10);
        this.pos = n11 = this.pos + n10;
    }

    private void skipGroup() {
        int n10 = this.endGroupTag;
        int n11 = WireFormat.getTagFieldNumber(this.tag);
        int n12 = 4;
        this.endGroupTag = n11 = WireFormat.makeTag(n11, n12);
        while ((n11 = this.getFieldNumber()) != (n12 = -1 >>> 1) && (n11 = (int)(this.skipField() ? 1 : 0)) != 0) {
        }
        n11 = this.tag;
        n12 = this.endGroupTag;
        if (n11 == n12) {
            this.endGroupTag = n10;
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void skipVarint() {
        int n10 = this.limit;
        int n11 = this.pos;
        int n12 = 10;
        if ((n10 -= n11) >= n12) {
            byte[] byArray = this.buffer;
            for (int i10 = 0; i10 < n12; ++i10) {
                int n13 = n11 + 1;
                if ((n11 = byArray[n11]) >= 0) {
                    this.pos = n13;
                    return;
                }
                n11 = n13;
            }
        }
        this.skipVarintSlowPath();
    }

    private void skipVarintSlowPath() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            n10 = this.readByte();
            if (n10 < 0) continue;
            return;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    private void verifyPackedFixed32Length(int n10) {
        this.requireBytes(n10);
        if ((n10 &= 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void verifyPackedFixed64Length(int n10) {
        this.requireBytes(n10);
        if ((n10 &= 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    public int getFieldNumber() {
        int n10 = this.isAtEnd();
        int n11 = -1 >>> 1;
        if (n10 != 0) {
            return n11;
        }
        this.tag = n10 = this.readVarint32();
        int n12 = this.endGroupTag;
        if (n10 == n12) {
            return n11;
        }
        return WireFormat.getTagFieldNumber(n10);
    }

    public int getTag() {
        return this.tag;
    }

    public int getTotalBytesRead() {
        int n10 = this.pos;
        int n11 = this.initialPos;
        return n10 - n11;
    }

    public boolean readBool() {
        boolean bl2 = false;
        this.requireWireType(0);
        int n10 = this.readVarint32();
        if (n10 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void readBoolList(List list) {
        int n10;
        int n11;
        int n12;
        block17: {
            block18: {
                block16: {
                    int n13;
                    block13: {
                        int n14;
                        List list2;
                        block14: {
                            block15: {
                                n12 = list instanceof BooleanArrayList;
                                n11 = 1;
                                n10 = 0;
                                n13 = 2;
                                if (!n12) break block13;
                                list2 = list;
                                list2 = (BooleanArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (!n14) break block14;
                                if (n14 != n13) break block15;
                                n14 = this.readVarint32();
                                n13 = this.pos + n14;
                                while ((n14 = this.pos) < n13) {
                                    n14 = this.readVarint32();
                                    if (n14) {
                                        n14 = n11;
                                    } else {
                                        n14 = 0;
                                        list = null;
                                    }
                                    ((BooleanArrayList)list2).addBoolean(n14 != 0);
                                }
                                this.requirePosition(n13);
                                break block16;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n14 = (int)(this.readBool() ? 1 : 0);
                            ((BooleanArrayList)list2).addBoolean(n14 != 0);
                            n14 = this.isAtEnd();
                            if (n14) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (!n12) break block17;
                    if (n12 != n13) break block18;
                    n12 = this.readVarint32();
                    n13 = this.pos + n12;
                    while ((n12 = this.pos) < n13) {
                        Boolean bl2;
                        n12 = this.readVarint32();
                        if (n12) {
                            n12 = n11;
                        } else {
                            n12 = 0;
                            bl2 = null;
                        }
                        bl2 = n12 != 0;
                        list.add(bl2);
                    }
                    this.requirePosition(n13);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Boolean bl3 = this.readBool();
            list.add(bl3);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public ByteString readBytes() {
        int n10;
        Object object;
        this.requireWireType(2);
        int n11 = this.readVarint32();
        if (n11 == 0) {
            return ByteString.EMPTY;
        }
        this.requireBytes(n11);
        boolean bl2 = this.bufferIsImmutable;
        if (bl2) {
            object = this.buffer;
            n10 = this.pos;
            object = ByteString.wrap(object, n10, n11);
        } else {
            object = this.buffer;
            n10 = this.pos;
            object = ByteString.copyFrom(object, n10, n11);
        }
        this.pos = n10 = this.pos + n11;
        return object;
    }

    public void readBytesList(List list) {
        int n10;
        int n11 = WireFormat.getTagWireType(this.tag);
        if (n11 == (n10 = 2)) {
            int n12;
            do {
                ByteString byteString = this.readBytes();
                list.add(byteString);
                n11 = (int)(this.isAtEnd() ? 1 : 0);
                if (n11 != 0) {
                    return;
                }
                n11 = this.pos;
            } while ((n10 = this.readVarint32()) == (n12 = this.tag));
            this.pos = n11;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public double readDouble() {
        this.requireWireType(1);
        return Double.longBitsToDouble(this.readLittleEndian64());
    }

    public void readDoubleList(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof DoubleArrayList;
                                n11 = 2;
                                n10 = 1;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (DoubleArrayList)list;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n10) break block8;
                                if (n13 != n11) break block9;
                                n13 = this.readVarint32();
                                this.verifyPackedFixed64Length(n13);
                                n11 = this.pos + n13;
                                while ((n13 = this.pos) < n11) {
                                    long l10 = this.readLittleEndian64_NoCheck();
                                    double d10 = Double.longBitsToDouble(l10);
                                    ((DoubleArrayList)list2).addDouble(d10);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            double d11 = this.readDouble();
                            ((DoubleArrayList)list2).addDouble(d11);
                            n13 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n13 != 0) {
                                return;
                            }
                            n13 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
                        this.pos = n13;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == n10) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        this.verifyPackedFixed64Length(n12);
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            long l11 = this.readLittleEndian64_NoCheck();
                            double d12 = Double.longBitsToDouble(l11);
                            Double d13 = d12;
                            list.add(d13);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            double d14 = this.readDouble();
            Double d15 = d14;
            list.add(d15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public int readEnum() {
        this.requireWireType(0);
        return this.readVarint32();
    }

    public void readEnumList(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        int n14;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof IntArrayList;
                                n11 = 2;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (IntArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block8;
                                if (n14 != n11) break block9;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    n14 = this.readVarint32();
                                    ((IntArrayList)list2).addInt(n14);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n14 = this.readEnum();
                            ((IntArrayList)list2).addInt(n14);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            n12 = this.readVarint32();
                            Integer n15 = n12;
                            list.add(n15);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Integer n16 = this.readEnum();
            list.add(n16);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public int readFixed32() {
        this.requireWireType(5);
        return this.readLittleEndian32();
    }

    public void readFixed32List(List list) {
        int n10 = list instanceof IntArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (IntArrayList)list;
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        n10 = this.readFixed32();
                        ((IntArrayList)list).addInt(n10);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                ((IntArrayList)list).addInt(n10);
            }
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        Integer n13 = this.readFixed32();
                        list.add(n13);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                Integer n14 = n10;
                list.add(n14);
            }
        }
    }

    public long readFixed64() {
        this.requireWireType(1);
        return this.readLittleEndian64();
    }

    public void readFixed64List(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof LongArrayList;
                                n11 = 2;
                                n10 = 1;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (LongArrayList)list;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n10) break block8;
                                if (n13 != n11) break block9;
                                n13 = this.readVarint32();
                                this.verifyPackedFixed64Length(n13);
                                n11 = this.pos + n13;
                                while ((n13 = this.pos) < n11) {
                                    long l10 = this.readLittleEndian64_NoCheck();
                                    ((LongArrayList)list2).addLong(l10);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.readFixed64();
                            ((LongArrayList)list2).addLong(l11);
                            n13 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n13 != 0) {
                                return;
                            }
                            n13 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
                        this.pos = n13;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == n10) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        this.verifyPackedFixed64Length(n12);
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            long l12 = this.readLittleEndian64_NoCheck();
                            Long l13 = l12;
                            list.add(l13);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l14 = this.readFixed64();
            Long l15 = l14;
            list.add(l15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public float readFloat() {
        this.requireWireType(5);
        return Float.intBitsToFloat(this.readLittleEndian32());
    }

    public void readFloatList(List list) {
        int n10 = list instanceof FloatArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (FloatArrayList)list;
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        float f10 = this.readFloat();
                        ((FloatArrayList)list).addFloat(f10);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                float f11 = Float.intBitsToFloat(n10);
                ((FloatArrayList)list).addFloat(f11);
            }
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        float f12 = this.readFloat();
                        Float f13 = Float.valueOf(f12);
                        list.add(f13);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                float f14 = Float.intBitsToFloat(n10);
                Float f15 = Float.valueOf(f14);
                list.add(f15);
            }
        }
    }

    public Object readGroup(Class object, ExtensionRegistryLite extensionRegistryLite) {
        this.requireWireType(3);
        object = Protobuf.getInstance().schemaFor((Class)object);
        return this.readGroup((Schema)object, extensionRegistryLite);
    }

    public Object readGroupBySchemaWithCheck(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        this.requireWireType(3);
        return this.readGroup(schema, extensionRegistryLite);
    }

    public void readGroupList(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        int n11 = WireFormat.getTagWireType(this.tag);
        if (n11 == (n10 = 3)) {
            int n12;
            n11 = this.tag;
            do {
                Object object = this.readGroup(schema, extensionRegistryLite);
                list.add(object);
                n10 = (int)(this.isAtEnd() ? 1 : 0);
                if (n10 != 0) {
                    return;
                }
                n10 = this.pos;
            } while ((n12 = this.readVarint32()) == n11);
            this.pos = n10;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void readGroupList(List list, Class object, ExtensionRegistryLite extensionRegistryLite) {
        object = Protobuf.getInstance().schemaFor((Class)object);
        this.readGroupList(list, (Schema)object, extensionRegistryLite);
    }

    public int readInt32() {
        this.requireWireType(0);
        return this.readVarint32();
    }

    public void readInt32List(List list) {
        int n10;
        int n11;
        int n12;
        block13: {
            block14: {
                block12: {
                    block9: {
                        int n13;
                        int n14;
                        List list2;
                        block10: {
                            block11: {
                                n12 = list instanceof IntArrayList;
                                n11 = 2;
                                if (n12 == 0) break block9;
                                list2 = list;
                                list2 = (IntArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block10;
                                if (n14 != n11) break block11;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    n14 = this.readVarint32();
                                    ((IntArrayList)list2).addInt(n14);
                                }
                                this.requirePosition(n11);
                                break block12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n14 = this.readInt32();
                            ((IntArrayList)list2).addInt(n14);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block13;
                    if (n12 != n11) break block14;
                    n12 = this.readVarint32();
                    n11 = this.pos + n12;
                    while ((n12 = this.pos) < n11) {
                        n12 = this.readVarint32();
                        Integer n15 = n12;
                        list.add(n15);
                    }
                    this.requirePosition(n11);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Integer n16 = this.readInt32();
            list.add(n16);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public long readInt64() {
        this.requireWireType(0);
        return this.readVarint64();
    }

    public void readInt64List(List list) {
        int n10;
        int n11;
        int n12;
        block13: {
            block14: {
                block12: {
                    block9: {
                        int n13;
                        int n14;
                        List list2;
                        block10: {
                            block11: {
                                n12 = list instanceof LongArrayList;
                                n11 = 2;
                                if (n12 == 0) break block9;
                                list2 = list;
                                list2 = (LongArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block10;
                                if (n14 != n11) break block11;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    long l10 = this.readVarint64();
                                    ((LongArrayList)list2).addLong(l10);
                                }
                                this.requirePosition(n11);
                                break block12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.readInt64();
                            ((LongArrayList)list2).addLong(l11);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block13;
                    if (n12 != n11) break block14;
                    n12 = this.readVarint32();
                    n11 = this.pos + n12;
                    while ((n12 = this.pos) < n11) {
                        long l12 = this.readVarint64();
                        Long l13 = l12;
                        list.add(l13);
                    }
                    this.requirePosition(n11);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l14 = this.readInt64();
            Long l15 = l14;
            list.add(l15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void readMap(Map object, MapEntryLite$Metadata mapEntryLite$Metadata, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        int n11 = 2;
        this.requireWireType(n11);
        int n12 = this.readVarint32();
        this.requireBytes(n12);
        int n13 = this.limit;
        this.limit = n10 = this.pos + n12;
        Object object2 = mapEntryLite$Metadata.defaultKey;
        Object object3 = mapEntryLite$Metadata.defaultValue;
        while (true) {
            Class<?> clazz;
            int n14;
            int n15;
            if ((n15 = this.getFieldNumber()) == (n14 = -1 >>> 1)) {
                object.put(object2, object3);
                return;
            }
            n14 = 1;
            String string2 = "Unable to parse map entry.";
            if (n15 != n14) {
                if (n15 != n11) {
                    n15 = (int)(this.skipField() ? 1 : 0);
                    if (n15 != 0) continue;
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(string2);
                    throw invalidProtocolBufferException;
                }
                WireFormat$FieldType wireFormat$FieldType = mapEntryLite$Metadata.valueType;
                clazz = mapEntryLite$Metadata.defaultValue;
                clazz = clazz.getClass();
                object3 = this.readField(wireFormat$FieldType, clazz, extensionRegistryLite);
                continue;
            }
            WireFormat$FieldType wireFormat$FieldType = mapEntryLite$Metadata.keyType;
            n14 = 0;
            clazz = null;
            object2 = this.readField(wireFormat$FieldType, null, null);
        }
        {
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public Object readMessage(Class object, ExtensionRegistryLite extensionRegistryLite) {
        this.requireWireType(2);
        object = Protobuf.getInstance().schemaFor((Class)object);
        return this.readMessage((Schema)object, extensionRegistryLite);
    }

    public Object readMessageBySchemaWithCheck(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        this.requireWireType(2);
        return this.readMessage(schema, extensionRegistryLite);
    }

    public void readMessageList(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        int n11 = WireFormat.getTagWireType(this.tag);
        if (n11 == (n10 = 2)) {
            int n12;
            n11 = this.tag;
            do {
                Object object = this.readMessage(schema, extensionRegistryLite);
                list.add(object);
                n10 = (int)(this.isAtEnd() ? 1 : 0);
                if (n10 != 0) {
                    return;
                }
                n10 = this.pos;
            } while ((n12 = this.readVarint32()) == n11);
            this.pos = n10;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void readMessageList(List list, Class object, ExtensionRegistryLite extensionRegistryLite) {
        object = Protobuf.getInstance().schemaFor((Class)object);
        this.readMessageList(list, (Schema)object, extensionRegistryLite);
    }

    public int readSFixed32() {
        this.requireWireType(5);
        return this.readLittleEndian32();
    }

    public void readSFixed32List(List list) {
        int n10 = list instanceof IntArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            list = (IntArrayList)list;
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        n10 = this.readSFixed32();
                        ((IntArrayList)list).addInt(n10);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                ((IntArrayList)list).addInt(n10);
            }
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    do {
                        Integer n13 = this.readSFixed32();
                        list.add(n13);
                        n10 = (int)(this.isAtEnd() ? 1 : 0);
                        if (n10 != 0) {
                            return;
                        }
                        n10 = this.pos;
                    } while ((n11 = this.readVarint32()) == (n12 = this.tag));
                    this.pos = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            n10 = this.readVarint32();
            this.verifyPackedFixed32Length(n10);
            n11 = this.pos + n10;
            while ((n10 = this.pos) < n11) {
                n10 = this.readLittleEndian32_NoCheck();
                Integer n14 = n10;
                list.add(n14);
            }
        }
    }

    public long readSFixed64() {
        this.requireWireType(1);
        return this.readLittleEndian64();
    }

    public void readSFixed64List(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof LongArrayList;
                                n11 = 2;
                                n10 = 1;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (LongArrayList)list;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n10) break block8;
                                if (n13 != n11) break block9;
                                n13 = this.readVarint32();
                                this.verifyPackedFixed64Length(n13);
                                n11 = this.pos + n13;
                                while ((n13 = this.pos) < n11) {
                                    long l10 = this.readLittleEndian64_NoCheck();
                                    ((LongArrayList)list2).addLong(l10);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.readSFixed64();
                            ((LongArrayList)list2).addLong(l11);
                            n13 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n13 != 0) {
                                return;
                            }
                            n13 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
                        this.pos = n13;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == n10) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        this.verifyPackedFixed64Length(n12);
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            long l12 = this.readLittleEndian64_NoCheck();
                            Long l13 = l12;
                            list.add(l13);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l14 = this.readSFixed64();
            Long l15 = l14;
            list.add(l15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public int readSInt32() {
        this.requireWireType(0);
        return CodedInputStream.decodeZigZag32(this.readVarint32());
    }

    public void readSInt32List(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        int n14;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof IntArrayList;
                                n11 = 2;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (IntArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block8;
                                if (n14 != n11) break block9;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    n14 = CodedInputStream.decodeZigZag32(this.readVarint32());
                                    ((IntArrayList)list2).addInt(n14);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n14 = this.readSInt32();
                            ((IntArrayList)list2).addInt(n14);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            n12 = CodedInputStream.decodeZigZag32(this.readVarint32());
                            Integer n15 = n12;
                            list.add(n15);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Integer n16 = this.readSInt32();
            list.add(n16);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public long readSInt64() {
        this.requireWireType(0);
        return CodedInputStream.decodeZigZag64(this.readVarint64());
    }

    public void readSInt64List(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        int n14;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof LongArrayList;
                                n11 = 2;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (LongArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block8;
                                if (n14 != n11) break block9;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    long l10 = CodedInputStream.decodeZigZag64(this.readVarint64());
                                    ((LongArrayList)list2).addLong(l10);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.readSInt64();
                            ((LongArrayList)list2).addLong(l11);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            long l12 = CodedInputStream.decodeZigZag64(this.readVarint64());
                            Long l13 = l12;
                            list.add(l13);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l14 = this.readSInt64();
            Long l15 = l14;
            list.add(l15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public String readString() {
        return this.readStringInternal(false);
    }

    public String readStringInternal(boolean bl2) {
        int n10;
        int n11;
        Object object;
        this.requireWireType(2);
        int n12 = this.readVarint32();
        if (n12 == 0) {
            return "";
        }
        this.requireBytes(n12);
        if (bl2 && !(bl2 = Utf8.isValidUtf8((byte[])(object = (Object)this.buffer), n11 = this.pos, n10 = n11 + n12))) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        byte[] byArray = this.buffer;
        n10 = this.pos;
        Charset charset = Internal.UTF_8;
        object = new String(byArray, n10, n12, charset);
        this.pos = n11 = this.pos + n12;
        return object;
    }

    public void readStringList(List list) {
        this.readStringListInternal(list, false);
    }

    public void readStringListInternal(List iterable, boolean n10) {
        int n11;
        int n12 = WireFormat.getTagWireType(this.tag);
        if (n12 == (n11 = 2)) {
            int n13;
            n12 = iterable instanceof LazyStringList;
            if (n12 != 0 && n10 == 0) {
                int n14;
                List list = iterable;
                list = (LazyStringList)iterable;
                do {
                    iterable = this.readBytes();
                    list.add((ByteString)iterable);
                    n14 = this.isAtEnd();
                    if (n14 != 0) {
                        return;
                    }
                    n14 = this.pos;
                } while ((n10 = this.readVarint32()) == (n11 = this.tag));
                this.pos = n14;
                return;
            }
            do {
                String string2 = this.readStringInternal(n10 != 0);
                iterable.add(string2);
                n12 = (int)(this.isAtEnd() ? 1 : 0);
                if (n12 != 0) {
                    return;
                }
                n12 = this.pos;
            } while ((n11 = this.readVarint32()) == (n13 = this.tag));
            this.pos = n12;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void readStringListRequireUtf8(List list) {
        this.readStringListInternal(list, true);
    }

    public String readStringRequireUtf8() {
        return this.readStringInternal(true);
    }

    public int readUInt32() {
        this.requireWireType(0);
        return this.readVarint32();
    }

    public void readUInt32List(List list) {
        int n10;
        int n11;
        int n12;
        block11: {
            block12: {
                block10: {
                    block7: {
                        int n13;
                        int n14;
                        List list2;
                        block8: {
                            block9: {
                                n12 = list instanceof IntArrayList;
                                n11 = 2;
                                if (n12 == 0) break block7;
                                list2 = list;
                                list2 = (IntArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block8;
                                if (n14 != n11) break block9;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    n14 = this.readVarint32();
                                    ((IntArrayList)list2).addInt(n14);
                                }
                                break block10;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n14 = this.readUInt32();
                            ((IntArrayList)list2).addInt(n14);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block11;
                    if (n12 == n11) {
                        n12 = this.readVarint32();
                        n11 = this.pos + n12;
                        while ((n12 = this.pos) < n11) {
                            n12 = this.readVarint32();
                            Integer n15 = n12;
                            list.add(n15);
                        }
                    }
                    break block12;
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            Integer n16 = this.readUInt32();
            list.add(n16);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    public long readUInt64() {
        this.requireWireType(0);
        return this.readVarint64();
    }

    public void readUInt64List(List list) {
        int n10;
        int n11;
        int n12;
        block13: {
            block14: {
                block12: {
                    block9: {
                        int n13;
                        int n14;
                        List list2;
                        block10: {
                            block11: {
                                n12 = list instanceof LongArrayList;
                                n11 = 2;
                                if (n12 == 0) break block9;
                                list2 = list;
                                list2 = (LongArrayList)list;
                                n14 = WireFormat.getTagWireType(this.tag);
                                if (n14 == 0) break block10;
                                if (n14 != n11) break block11;
                                n14 = this.readVarint32();
                                n11 = this.pos + n14;
                                while ((n14 = this.pos) < n11) {
                                    long l10 = this.readVarint64();
                                    ((LongArrayList)list2).addLong(l10);
                                }
                                this.requirePosition(n11);
                                break block12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.readUInt64();
                            ((LongArrayList)list2).addLong(l11);
                            n14 = (int)(this.isAtEnd() ? 1 : 0);
                            if (n14 != 0) {
                                return;
                            }
                            n14 = this.pos;
                        } while ((n11 = this.readVarint32()) == (n13 = this.tag));
                        this.pos = n14;
                        return;
                    }
                    n12 = WireFormat.getTagWireType(this.tag);
                    if (n12 == 0) break block13;
                    if (n12 != n11) break block14;
                    n12 = this.readVarint32();
                    n11 = this.pos + n12;
                    while ((n12 = this.pos) < n11) {
                        long l12 = this.readVarint64();
                        Long l13 = l12;
                        list.add(l13);
                    }
                    this.requirePosition(n11);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l14 = this.readUInt64();
            Long l15 = l14;
            list.add(l15);
            n12 = (int)(this.isAtEnd() ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            n12 = this.pos;
        } while ((n11 = this.readVarint32()) == (n10 = this.tag));
        this.pos = n12;
    }

    /*
     * Unable to fully structure code
     */
    public long readVarint64() {
        var2_2 = this.limit;
        var1_1 = this.pos;
        if (var2_2 != var1_1) {
            var3_3 = this.buffer;
            var4_4 = var1_1 + 1;
            if ((var1_1 = var3_3[var1_1]) >= 0) {
                this.pos = var4_4;
                return var1_1;
            }
            var5_5 = 9;
            if ((var2_2 -= var4_4) < var5_5) {
                return this.readVarint64SlowPath();
            }
            var2_2 = var4_4 + 1;
            if ((var1_1 ^= (var4_4 = var3_3[var4_4] << 7)) < 0) {
                var1_1 ^= -128;
lbl15:
                // 2 sources

                while (true) {
                    var6_6 = var1_1;
                    break;
                }
            } else {
                var4_4 = var2_2 + 1;
                if ((var1_1 ^= (var2_2 = var3_3[var2_2] << 14)) >= 0) {
                    var8_7 = var1_1 ^= 16256;
                    var2_2 = var4_4;
                    var6_6 = var8_7;
                } else {
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
                            break;
                        }
                    } else {
                        var2_2 = var1_1 + 1;
                        var17_12 = (long)var3_3[var1_1] << 35;
                        cfr_temp_1 = (var11_9 ^= var17_12) - var13_10;
                        if ((var1_1 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0) {
                            var13_10 = -34093383808L;
lbl45:
                            // 2 sources

                            while (true) {
                                var6_6 = var11_9 ^ var13_10;
                                break;
                            }
                        } else {
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
                            if (var2_2 < 0) {
                                var2_2 = var1_1 + 1;
                                var17_12 = var3_3[var1_1];
                                cfr_temp_5 = var17_12 - var13_10;
                                if ((var1_1 = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) < 0) {
                                    throw InvalidProtocolBufferException.malformedVarint();
                                }
                            } else {
                                var2_2 = var1_1;
                            }
                            var6_6 = var11_9;
                        }
                    }
                }
            }
            this.pos = var2_2;
            return var6_6;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public boolean skipField() {
        int n10;
        int n11 = this.isAtEnd();
        if (n11 == 0 && (n11 = this.tag) != (n10 = this.endGroupTag)) {
            n11 = WireFormat.getTagWireType(n11);
            n10 = 1;
            if (n11 != 0) {
                if (n11 != n10) {
                    int n12 = 2;
                    if (n11 != n12) {
                        n12 = 3;
                        if (n11 != n12) {
                            n12 = 5;
                            if (n11 == n12) {
                                this.skipBytes(4);
                                return n10 != 0;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        this.skipGroup();
                        return n10 != 0;
                    }
                    n11 = this.readVarint32();
                    this.skipBytes(n11);
                    return n10 != 0;
                }
                this.skipBytes(8);
                return n10 != 0;
            }
            this.skipVarint();
            return n10 != 0;
        }
        return false;
    }
}

