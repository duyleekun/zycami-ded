/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.InvalidProtocolBufferException$InvalidWireTypeException;
import com.google.protobuf.MessageLiteToString;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.util.Arrays;

public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    static {
        UnknownFieldSetLite unknownFieldSetLite;
        int[] nArray = new int[]{};
        Object[] objectArray = new Object[]{};
        DEFAULT_INSTANCE = unknownFieldSetLite = new UnknownFieldSetLite(0, nArray, objectArray, false);
    }

    private UnknownFieldSetLite() {
        int n10 = 8;
        int[] nArray = new int[n10];
        Object[] objectArray = new Object[n10];
        this(0, nArray, objectArray, true);
    }

    private UnknownFieldSetLite(int n10, int[] nArray, Object[] objectArray, boolean bl2) {
        this.memoizedSerializedSize = -1;
        this.count = n10;
        this.tags = nArray;
        this.objects = objectArray;
        this.isMutable = bl2;
    }

    private void ensureCapacity() {
        int n10 = this.count;
        Object[] objectArray = this.tags;
        int n11 = objectArray.length;
        if (n10 == n11) {
            n11 = 4;
            n11 = n10 < n11 ? 8 : n10 >> 1;
            this.tags = objectArray = Arrays.copyOf(objectArray, n10 += n11);
            objectArray = this.objects;
            int[] nArray = Arrays.copyOf(objectArray, n10);
            this.objects = nArray;
        }
    }

    private static boolean equals(int[] nArray, int[] nArray2, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            int n12 = nArray2[i10];
            if (n11 == n12) continue;
            return false;
        }
        return true;
    }

    private static boolean equals(Object[] objectArray, Object[] objectArray2, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Object object2 = objectArray2[i10];
            boolean bl2 = object.equals(object2);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] nArray, int n10) {
        int n11 = 17;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            int n12 = nArray[i10];
            n11 += n12;
        }
        return n11;
    }

    private static int hashCode(Object[] objectArray, int n10) {
        int n11 = 17;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            Object object = objectArray[i10];
            int n12 = object.hashCode();
            n11 += n12;
        }
        return n11;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream codedInputStream) {
        int n10;
        while ((n10 = codedInputStream.readTag()) != 0 && (n10 = (int)(this.mergeFieldFrom(n10, codedInputStream) ? 1 : 0)) != 0) {
        }
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int n10 = unknownFieldSetLite.count;
        int n11 = unknownFieldSetLite2.count;
        int[] nArray = Arrays.copyOf(unknownFieldSetLite.tags, n10 += n11);
        Object[] objectArray = unknownFieldSetLite2.tags;
        int n12 = unknownFieldSetLite.count;
        int n13 = unknownFieldSetLite2.count;
        System.arraycopy(objectArray, 0, nArray, n12, n13);
        objectArray = Arrays.copyOf(unknownFieldSetLite.objects, n10);
        Object[] objectArray2 = unknownFieldSetLite2.objects;
        int n14 = unknownFieldSetLite.count;
        int n15 = unknownFieldSetLite2.count;
        System.arraycopy(objectArray2, 0, objectArray, n14, n15);
        unknownFieldSetLite = new UnknownFieldSetLite(n10, nArray, objectArray, true);
        return unknownFieldSetLite;
    }

    public static UnknownFieldSetLite newInstance() {
        UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
        return unknownFieldSetLite;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void writeField(int n10, Object object, Writer writer) {
        Writer$FieldOrder writer$FieldOrder;
        int n11 = WireFormat.getTagFieldNumber(n10);
        if ((n10 = WireFormat.getTagWireType(n10)) == 0) {
            object = (Long)object;
            long l10 = (Long)object;
            writer.writeInt64(n11, l10);
            return;
        }
        int n12 = 1;
        if (n10 == n12) {
            object = (Long)object;
            long l11 = (Long)object;
            writer.writeFixed64(n11, l11);
            return;
        }
        n12 = 2;
        if (n10 == n12) {
            object = (ByteString)object;
            writer.writeBytes(n11, (ByteString)object);
            return;
        }
        n12 = 3;
        if (n10 != n12) {
            n12 = 5;
            if (n10 == n12) {
                object = (Integer)object;
                n10 = (Integer)object;
                writer.writeFixed32(n11, n10);
                return;
            }
            object = InvalidProtocolBufferException.invalidWireType();
            RuntimeException runtimeException = new RuntimeException((Throwable)object);
            throw runtimeException;
        }
        Writer$FieldOrder writer$FieldOrder2 = writer.fieldOrder();
        if (writer$FieldOrder2 == (writer$FieldOrder = Writer$FieldOrder.ASCENDING)) {
            writer.writeStartGroup(n11);
            object = (UnknownFieldSetLite)object;
            ((UnknownFieldSetLite)object).writeTo(writer);
            writer.writeEndGroup(n11);
            return;
        }
        writer.writeEndGroup(n11);
        object = (UnknownFieldSetLite)object;
        ((UnknownFieldSetLite)object).writeTo(writer);
        writer.writeStartGroup(n11);
    }

    public void checkMutable() {
        boolean bl2 = this.isMutable;
        if (bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean equals(Object objectArray) {
        Object[] objectArray2;
        boolean bl2;
        int[] nArray;
        int[] nArray2;
        boolean bl3 = true;
        if (this == objectArray) {
            return bl3;
        }
        if (objectArray == null) {
            return false;
        }
        int n10 = objectArray instanceof UnknownFieldSetLite;
        if (n10 == 0) {
            return false;
        }
        objectArray = (UnknownFieldSetLite)objectArray;
        n10 = this.count;
        int n11 = objectArray.count;
        if (n10 == n11 && (n10 = (int)(UnknownFieldSetLite.equals(nArray2 = this.tags, nArray = objectArray.tags, n10) ? 1 : 0)) != 0 && (bl2 = UnknownFieldSetLite.equals(objectArray2 = this.objects, objectArray = objectArray.objects, n11 = this.count))) {
            return bl3;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int getSerializedSize() {
        int n10 = this.memoizedSerializedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        IllegalStateException illegalStateException = null;
        n11 = 0;
        InvalidProtocolBufferException$InvalidWireTypeException invalidProtocolBufferException$InvalidWireTypeException = null;
        while (true) {
            int n12;
            block8: {
                long l10;
                int n13;
                Object object;
                block9: {
                    block10: {
                        if (n10 >= (n12 = this.count)) {
                            this.memoizedSerializedSize = n11;
                            return n11;
                        }
                        object = this.tags;
                        n12 = object[n10];
                        n13 = WireFormat.getTagFieldNumber(n12);
                        if ((n12 = WireFormat.getTagWireType(n12)) == 0) break block9;
                        int n14 = 1;
                        if (n12 == n14) break block10;
                        n14 = 2;
                        if (n12 != n14) {
                            int n15 = 3;
                            if (n12 != n15) {
                                n14 = 5;
                                if (n12 != n14) {
                                    invalidProtocolBufferException$InvalidWireTypeException = InvalidProtocolBufferException.invalidWireType();
                                    illegalStateException = new IllegalStateException(invalidProtocolBufferException$InvalidWireTypeException);
                                    throw illegalStateException;
                                }
                                object = (Integer)this.objects[n10];
                                n12 = (Integer)object;
                                n12 = CodedOutputStream.computeFixed32Size(n13, n12);
                                break block8;
                            } else {
                                n12 = CodedOutputStream.computeTagSize(n13) * n14;
                                UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite)this.objects[n10];
                                n13 = unknownFieldSetLite.getSerializedSize();
                                n12 += n13;
                            }
                            break block8;
                        } else {
                            object = (ByteString)this.objects[n10];
                            n12 = CodedOutputStream.computeBytesSize(n13, (ByteString)object);
                        }
                        break block8;
                    }
                    object = (Long)this.objects[n10];
                    l10 = (Long)object;
                    n12 = CodedOutputStream.computeFixed64Size(n13, l10);
                    break block8;
                }
                object = (Long)this.objects[n10];
                l10 = (Long)object;
                n12 = CodedOutputStream.computeUInt64Size(n13, l10);
            }
            n11 += n12;
            ++n10;
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int n10;
        int n11 = this.memoizedSerializedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = this.count); ++n11) {
            int[] nArray = this.tags;
            n10 = WireFormat.getTagFieldNumber(nArray[n11]);
            ByteString byteString = (ByteString)this.objects[n11];
            n10 = CodedOutputStream.computeRawMessageSetExtensionSize(n10, byteString);
            n12 += n10;
        }
        this.memoizedSerializedSize = n12;
        return n12;
    }

    public int hashCode() {
        int n10 = this.count;
        int n11 = (527 + n10) * 31;
        n10 = UnknownFieldSetLite.hashCode(this.tags, n10);
        n11 = (n11 + n10) * 31;
        Object[] objectArray = this.objects;
        int n12 = this.count;
        n10 = UnknownFieldSetLite.hashCode(objectArray, n12);
        return n11 + n10;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean mergeFieldFrom(int n10, CodedInputStream object) {
        this.checkMutable();
        int bl2 = WireFormat.getTagFieldNumber(n10);
        int n11 = WireFormat.getTagWireType(n10);
        int n12 = 1;
        if (n11) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 != n13) {
                    int n14 = 3;
                    int n15 = 4;
                    if (n11 != n14) {
                        if (n11 != n15) {
                            int n16 = 5;
                            if (n11 == n16) {
                                object = ((CodedInputStream)object).readFixed32();
                                this.storeField(n10, object);
                                return n12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
                    unknownFieldSetLite.mergeFrom((CodedInputStream)object);
                    int n17 = WireFormat.makeTag(bl2, n15);
                    ((CodedInputStream)object).checkLastTagWas(n17);
                    this.storeField(n10, unknownFieldSetLite);
                    return n12;
                }
                object = ((CodedInputStream)object).readBytes();
                this.storeField(n10, object);
                return n12;
            }
            object = ((CodedInputStream)object).readFixed64();
            this.storeField(n10, object);
            return n12;
        }
        object = ((CodedInputStream)object).readInt64();
        this.storeField(n10, object);
        return n12;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int n10, ByteString byteString) {
        this.checkMutable();
        if (n10 != 0) {
            n10 = WireFormat.makeTag(n10, 2);
            this.storeField(n10, byteString);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public UnknownFieldSetLite mergeVarintField(int n10, int n11) {
        this.checkMutable();
        if (n10 != 0) {
            n10 = WireFormat.makeTag(n10, 0);
            Long l10 = n11;
            this.storeField(n10, l10);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public final void printWithIndent(StringBuilder stringBuilder, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.count); ++i10) {
            n11 = WireFormat.getTagFieldNumber(this.tags[i10]);
            String string2 = String.valueOf(n11);
            Object object = this.objects[i10];
            MessageLiteToString.printField(stringBuilder, n10, string2, object);
        }
    }

    public void storeField(int n10, Object object) {
        this.checkMutable();
        this.ensureCapacity();
        int[] nArray = this.tags;
        int n11 = this.count;
        nArray[n11] = n10;
        this.objects[n11] = object;
        this.count = ++n11;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.count); ++i10) {
            int[] nArray = this.tags;
            n10 = WireFormat.getTagFieldNumber(nArray[i10]);
            ByteString byteString = (ByteString)this.objects[i10];
            codedOutputStream.writeRawMessageSetExtension(n10, byteString);
        }
    }

    public void writeAsMessageSetTo(Writer writer) {
        Object object;
        Writer$FieldOrder writer$FieldOrder = writer.fieldOrder();
        if (writer$FieldOrder == (object = Writer$FieldOrder.DESCENDING)) {
            for (int i10 = this.count + -1; i10 >= 0; i10 += -1) {
                object = this.tags;
                int n10 = WireFormat.getTagFieldNumber((int)object[i10]);
                Object object2 = this.objects[i10];
                writer.writeMessageSetItem(n10, object2);
            }
        } else {
            int n11;
            writer$FieldOrder = null;
            for (int i11 = 0; i11 < (n11 = this.count); ++i11) {
                object = this.tags;
                n11 = WireFormat.getTagFieldNumber((int)object[i11]);
                Object object3 = this.objects[i11];
                writer.writeMessageSetItem(n11, object3);
            }
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.count); ++i10) {
            long l10;
            Object object = this.tags;
            n10 = object[i10];
            int n11 = WireFormat.getTagFieldNumber(n10);
            if ((n10 = WireFormat.getTagWireType(n10)) != 0) {
                int n12 = 1;
                if (n10 != n12) {
                    n12 = 2;
                    if (n10 != n12) {
                        n12 = 3;
                        if (n10 != n12) {
                            n12 = 5;
                            if (n10 == n12) {
                                object = (Integer)this.objects[i10];
                                n10 = (Integer)object;
                                codedOutputStream.writeFixed32(n11, n10);
                                continue;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        codedOutputStream.writeTag(n11, n12);
                        object = (UnknownFieldSetLite)this.objects[i10];
                        ((UnknownFieldSetLite)object).writeTo(codedOutputStream);
                        n10 = 4;
                        codedOutputStream.writeTag(n11, n10);
                        continue;
                    }
                    object = (ByteString)this.objects[i10];
                    codedOutputStream.writeBytes(n11, (ByteString)object);
                    continue;
                }
                object = (Long)this.objects[i10];
                l10 = (Long)object;
                codedOutputStream.writeFixed64(n11, l10);
                continue;
            }
            object = (Long)this.objects[i10];
            l10 = (Long)object;
            codedOutputStream.writeUInt64(n11, l10);
        }
    }

    public void writeTo(Writer writer) {
        Object object;
        int n10 = this.count;
        if (n10 == 0) {
            return;
        }
        Writer$FieldOrder writer$FieldOrder = writer.fieldOrder();
        if (writer$FieldOrder == (object = Writer$FieldOrder.ASCENDING)) {
            Object object2;
            writer$FieldOrder = null;
            for (n10 = 0; n10 < (object2 = this.count); ++n10) {
                object = this.tags;
                object2 = (Object)object[n10];
                Object object3 = this.objects[n10];
                UnknownFieldSetLite.writeField(object2, object3, writer);
            }
        } else {
            for (n10 = this.count + -1; n10 >= 0; n10 += -1) {
                object = this.tags;
                Writer$FieldOrder writer$FieldOrder2 = object[n10];
                Object object4 = this.objects[n10];
                UnknownFieldSetLite.writeField((int)writer$FieldOrder2, object4, writer);
            }
        }
    }
}

