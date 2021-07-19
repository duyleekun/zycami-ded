/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStreamReader$1;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.InvalidProtocolBufferException$InvalidWireTypeException;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import java.util.List;
import java.util.Map;

public final class CodedInputStreamReader
implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag = 0;
    private int tag;

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        this.input = codedInputStream = (CodedInputStream)Internal.checkNotNull(codedInputStream, "input");
        codedInputStream.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
        if (codedInputStreamReader != null) {
            return codedInputStreamReader;
        }
        codedInputStreamReader = new CodedInputStreamReader(codedInputStream);
        return codedInputStreamReader;
    }

    private Object readField(WireFormat$FieldType object, Class clazz, ExtensionRegistryLite extensionRegistryLite) {
        int[] nArray = CodedInputStreamReader$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
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

    private Object readMessage(Schema object, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream codedInputStream = this.input;
        int n10 = codedInputStream.readUInt32();
        Object object2 = this.input;
        int n11 = ((CodedInputStream)object2).recursionDepth;
        int n12 = ((CodedInputStream)object2).recursionLimit;
        if (n11 < n12) {
            int n13;
            n10 = ((CodedInputStream)object2).pushLimit(n10);
            object2 = object.newInstance();
            CodedInputStream codedInputStream2 = this.input;
            codedInputStream2.recursionDepth = n12 = codedInputStream2.recursionDepth + 1;
            object.mergeFrom(object2, this, extensionRegistryLite);
            object.makeImmutable(object2);
            this.input.checkLastTagWas(0);
            object = this.input;
            ((CodedInputStream)object).recursionDepth = n13 = ((CodedInputStream)object).recursionDepth + -1;
            ((CodedInputStream)object).popLimit(n10);
            return object2;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private void requirePosition(int n10) {
        CodedInputStream codedInputStream = this.input;
        int n11 = codedInputStream.getTotalBytesRead();
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

    private void verifyPackedFixed32Length(int n10) {
        if ((n10 &= 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private void verifyPackedFixed64Length(int n10) {
        if ((n10 &= 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    public int getFieldNumber() {
        int n10;
        int n11 = this.nextTag;
        if (n11 != 0) {
            this.tag = n11;
            n11 = 0;
            Object var2_2 = null;
            this.nextTag = 0;
        } else {
            CodedInputStream codedInputStream = this.input;
            this.tag = n11 = codedInputStream.readTag();
        }
        n11 = this.tag;
        if (n11 != 0 && n11 != (n10 = this.endGroupTag)) {
            return WireFormat.getTagFieldNumber(n11);
        }
        return -1 >>> 1;
    }

    public int getTag() {
        return this.tag;
    }

    public boolean readBool() {
        this.requireWireType(0);
        return this.input.readBool();
    }

    public void readBoolList(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof BooleanArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (BooleanArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    n12 = (int)(this.input.readBool() ? 1 : 0);
                                    ((BooleanArrayList)list).addBoolean(n12 != 0);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n12 = (int)(this.input.readBool() ? 1 : 0);
                            ((BooleanArrayList)list).addBoolean(n12 != 0);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        object3 = this.input.readBool();
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            object2 = this.input.readBool();
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public ByteString readBytes() {
        this.requireWireType(2);
        return this.input.readBytes();
    }

    public void readBytesList(List list) {
        int n10;
        int n11 = WireFormat.getTagWireType(this.tag);
        if (n11 == (n10 = 2)) {
            Object object;
            do {
                object = this.readBytes();
                list.add(object);
                object = this.input;
                n11 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                if (n11 == 0) continue;
                return;
            } while ((n11 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
            this.nextTag = n11;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public double readDouble() {
        this.requireWireType(1);
        return this.input.readDouble();
    }

    public void readDoubleList(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    int n12;
                    block6: {
                        int n13;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof DoubleArrayList;
                                n10 = 2;
                                n12 = 1;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (DoubleArrayList)object;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n12) break block7;
                                if (n13 != n10) break block8;
                                object = this.input;
                                n13 = ((CodedInputStream)object).readUInt32();
                                this.verifyPackedFixed64Length(n13);
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n13;
                                do {
                                    double d10 = this.input.readDouble();
                                    ((DoubleArrayList)list).addDouble(d10);
                                } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            double d11 = this.input.readDouble();
                            ((DoubleArrayList)list).addDouble(d11);
                            object = this.input;
                            n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n13 == 0) continue;
                            return;
                        } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n13;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == n12) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    this.verifyPackedFixed64Length(n11);
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        double d12 = this.input.readDouble();
                        object3 = d12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            double d13 = this.input.readDouble();
            object2 = d13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public int readEnum() {
        this.requireWireType(0);
        return this.input.readEnum();
    }

    public void readEnumList(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof IntArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (IntArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    n12 = this.input.readEnum();
                                    ((IntArrayList)list).addInt(n12);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n12 = this.input.readEnum();
                            ((IntArrayList)list).addInt(n12);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        object3 = this.input.readEnum();
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            object2 = this.input.readEnum();
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public int readFixed32() {
        this.requireWireType(5);
        return this.input.readFixed32();
    }

    public void readFixed32List(List object) {
        int n10 = object instanceof IntArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (IntArrayList)object;
            int n13 = WireFormat.getTagWireType(this.tag);
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        n13 = this.input.readFixed32();
                        ((IntArrayList)list).addInt(n13);
                        object = this.input;
                        n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n13;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            object = this.input;
            n13 = ((CodedInputStream)object).readUInt32();
            this.verifyPackedFixed32Length(n13);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead();
            int n14 = n11 + n13;
            do {
                n13 = this.input.readFixed32();
                ((IntArrayList)list).addInt(n13);
            } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n14);
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    Object object2;
                    do {
                        object2 = this.input.readFixed32();
                        object.add(object2);
                        object2 = this.input;
                        n10 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
                        if (n10 == 0) continue;
                        return;
                    } while ((n10 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            Object object3 = this.input;
            n10 = ((CodedInputStream)object3).readUInt32();
            this.verifyPackedFixed32Length(n10);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead() + n10;
            do {
                object3 = this.input.readFixed32();
                object.add(object3);
            } while ((n10 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n11);
        }
    }

    public long readFixed64() {
        this.requireWireType(1);
        return this.input.readFixed64();
    }

    public void readFixed64List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    int n12;
                    block6: {
                        int n13;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof LongArrayList;
                                n10 = 2;
                                n12 = 1;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (LongArrayList)object;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n12) break block7;
                                if (n13 != n10) break block8;
                                object = this.input;
                                n13 = ((CodedInputStream)object).readUInt32();
                                this.verifyPackedFixed64Length(n13);
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n13;
                                do {
                                    long l10 = this.input.readFixed64();
                                    ((LongArrayList)list).addLong(l10);
                                } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.input.readFixed64();
                            ((LongArrayList)list).addLong(l11);
                            object = this.input;
                            n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n13 == 0) continue;
                            return;
                        } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n13;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == n12) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    this.verifyPackedFixed64Length(n11);
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        long l12 = this.input.readFixed64();
                        object3 = l12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l13 = this.input.readFixed64();
            object2 = l13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public float readFloat() {
        this.requireWireType(5);
        return this.input.readFloat();
    }

    public void readFloatList(List object) {
        int n10 = object instanceof FloatArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (FloatArrayList)object;
            int n13 = WireFormat.getTagWireType(this.tag);
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        float f10 = this.input.readFloat();
                        ((FloatArrayList)list).addFloat(f10);
                        object = this.input;
                        n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n13;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            object = this.input;
            n13 = ((CodedInputStream)object).readUInt32();
            this.verifyPackedFixed32Length(n13);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead();
            int n14 = n11 + n13;
            do {
                float f11 = this.input.readFloat();
                ((FloatArrayList)list).addFloat(f11);
            } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n14);
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    Object object2;
                    do {
                        float f12 = this.input.readFloat();
                        object2 = Float.valueOf(f12);
                        object.add(object2);
                        object2 = this.input;
                        n10 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
                        if (n10 == 0) continue;
                        return;
                    } while ((n10 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            Object object3 = this.input;
            n10 = ((CodedInputStream)object3).readUInt32();
            this.verifyPackedFixed32Length(n10);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead() + n10;
            do {
                float f13 = this.input.readFloat();
                object3 = Float.valueOf(f13);
                object.add(object3);
            } while ((n10 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n11);
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
            block2: {
                Object object;
                n11 = this.tag;
                do {
                    object = this.readGroup(schema, extensionRegistryLite);
                    list.add(object);
                    object = this.input;
                    n10 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                    if (n10 != 0 || (n10 = this.nextTag) != 0) break block2;
                } while ((n10 = ((CodedInputStream)(object = this.input)).readTag()) == n11);
                this.nextTag = n10;
            }
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
        return this.input.readInt32();
    }

    public void readInt32List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof IntArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (IntArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    n12 = this.input.readInt32();
                                    ((IntArrayList)list).addInt(n12);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n12 = this.input.readInt32();
                            ((IntArrayList)list).addInt(n12);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        object3 = this.input.readInt32();
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            object2 = this.input.readInt32();
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public long readInt64() {
        this.requireWireType(0);
        return this.input.readInt64();
    }

    public void readInt64List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof LongArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (LongArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    long l10 = this.input.readInt64();
                                    ((LongArrayList)list).addLong(l10);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.input.readInt64();
                            ((LongArrayList)list).addLong(l11);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        long l12 = this.input.readInt64();
                        object3 = l12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l13 = this.input.readInt64();
            object2 = l13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void readMap(Map var1_1, MapEntryLite$Metadata var2_3, ExtensionRegistryLite var3_4) {
        var4_5 = 2;
        this.requireWireType(var4_5);
        var5_6 = this.input;
        var6_7 = var5_6.readUInt32();
        var6_7 = this.input.pushLimit(var6_7);
        var7_8 = var2_3.defaultKey;
        var8_9 = var2_3.defaultValue;
        while (true) lbl-1000:
        // 5 sources

        {
            block19: {
                var9_10 = this.getFieldNumber();
                var10_11 = -1 >>> 1;
                if (var9_10 == var10_11) break;
                var11_12 = this.input;
                var10_11 = (int)var11_12.isAtEnd();
                if (var10_11 != 0) break;
                var10_11 = 1;
                var12_13 = "Unable to parse map entry.";
                if (var9_10 == var10_11) break block19;
                if (var9_10 == var4_5) ** GOTO lbl28
                var9_10 = (int)this.skipField();
                if (var9_10 != 0) continue;
                var13_14 /* !! */  = new InvalidProtocolBufferException(var12_13);
                throw var13_14 /* !! */ ;
lbl28:
                // 1 sources

                var13_14 /* !! */  = var2_3.valueType;
                var11_12 = var2_3.defaultValue;
                var11_12 = var11_12.getClass();
                var8_9 = this.readField(var13_14 /* !! */ , var11_12, var3_4);
            }
            var13_14 /* !! */  = var2_3.keyType;
            var10_11 = 0;
            var11_12 = null;
            try {
                var7_8 = this.readField(var13_14 /* !! */ , null, null);
                continue;
            }
            catch (InvalidProtocolBufferException$InvalidWireTypeException v0) {
                var9_10 = (int)this.skipField();
                if (var9_10 == 0) ** break;
                continue;
                var1_1 = new InvalidProtocolBufferException(var12_13);
                throw var1_1;
            }
            break;
        }
        var1_1.put(var7_8, var8_9);
        return;
        {
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
        ** GOTO lbl-1000
        finally {
            this.input.popLimit(var6_7);
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
            block2: {
                Object object;
                n11 = this.tag;
                do {
                    object = this.readMessage(schema, extensionRegistryLite);
                    list.add(object);
                    object = this.input;
                    n10 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                    if (n10 != 0 || (n10 = this.nextTag) != 0) break block2;
                } while ((n10 = ((CodedInputStream)(object = this.input)).readTag()) == n11);
                this.nextTag = n10;
            }
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
        return this.input.readSFixed32();
    }

    public void readSFixed32List(List object) {
        int n10 = object instanceof IntArrayList;
        int n11 = 5;
        int n12 = 2;
        if (n10 != 0) {
            List list = object;
            list = (IntArrayList)object;
            int n13 = WireFormat.getTagWireType(this.tag);
            if (n13 != n12) {
                if (n13 == n11) {
                    do {
                        n13 = this.input.readSFixed32();
                        ((IntArrayList)list).addInt(n13);
                        object = this.input;
                        n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                        if (n13 == 0) continue;
                        return;
                    } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n13;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            object = this.input;
            n13 = ((CodedInputStream)object).readUInt32();
            this.verifyPackedFixed32Length(n13);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead();
            int n14 = n11 + n13;
            do {
                n13 = this.input.readSFixed32();
                ((IntArrayList)list).addInt(n13);
            } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n14);
        } else {
            n10 = WireFormat.getTagWireType(this.tag);
            if (n10 != n12) {
                if (n10 == n11) {
                    Object object2;
                    do {
                        object2 = this.input.readSFixed32();
                        object.add(object2);
                        object2 = this.input;
                        n10 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
                        if (n10 == 0) continue;
                        return;
                    } while ((n10 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n11 = this.tag));
                    this.nextTag = n10;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            Object object3 = this.input;
            n10 = ((CodedInputStream)object3).readUInt32();
            this.verifyPackedFixed32Length(n10);
            CodedInputStream codedInputStream = this.input;
            n11 = codedInputStream.getTotalBytesRead() + n10;
            do {
                object3 = this.input.readSFixed32();
                object.add(object3);
            } while ((n10 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n11);
        }
    }

    public long readSFixed64() {
        this.requireWireType(1);
        return this.input.readSFixed64();
    }

    public void readSFixed64List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    int n12;
                    block6: {
                        int n13;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof LongArrayList;
                                n10 = 2;
                                n12 = 1;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (LongArrayList)object;
                                n13 = WireFormat.getTagWireType(this.tag);
                                if (n13 == n12) break block7;
                                if (n13 != n10) break block8;
                                object = this.input;
                                n13 = ((CodedInputStream)object).readUInt32();
                                this.verifyPackedFixed64Length(n13);
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n13;
                                do {
                                    long l10 = this.input.readSFixed64();
                                    ((LongArrayList)list).addLong(l10);
                                } while ((n13 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.input.readSFixed64();
                            ((LongArrayList)list).addLong(l11);
                            object = this.input;
                            n13 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n13 == 0) continue;
                            return;
                        } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n13;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == n12) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    this.verifyPackedFixed64Length(n11);
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        long l12 = this.input.readSFixed64();
                        object3 = l12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l13 = this.input.readSFixed64();
            object2 = l13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public int readSInt32() {
        this.requireWireType(0);
        return this.input.readSInt32();
    }

    public void readSInt32List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof IntArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (IntArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    n12 = this.input.readSInt32();
                                    ((IntArrayList)list).addInt(n12);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n12 = this.input.readSInt32();
                            ((IntArrayList)list).addInt(n12);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        object3 = this.input.readSInt32();
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            object2 = this.input.readSInt32();
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public long readSInt64() {
        this.requireWireType(0);
        return this.input.readSInt64();
    }

    public void readSInt64List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof LongArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (LongArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    long l10 = this.input.readSInt64();
                                    ((LongArrayList)list).addLong(l10);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.input.readSInt64();
                            ((LongArrayList)list).addLong(l11);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        long l12 = this.input.readSInt64();
                        object3 = l12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l13 = this.input.readSInt64();
            object2 = l13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public String readString() {
        this.requireWireType(2);
        return this.input.readString();
    }

    public void readStringList(List list) {
        this.readStringListInternal(list, false);
    }

    public void readStringListInternal(List object, boolean n10) {
        int n11;
        int n12 = WireFormat.getTagWireType(this.tag);
        if (n12 == (n11 = 2)) {
            Object object2;
            n12 = object instanceof LazyStringList;
            if (n12 != 0 && n10 == 0) {
                int n13;
                Object list = object;
                list = (LazyStringList)object;
                do {
                    object = this.readBytes();
                    list.add((ByteString)object);
                    object = this.input;
                    n13 = ((CodedInputStream)object).isAtEnd();
                    if (n13 == 0) continue;
                    return;
                } while ((n13 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                this.nextTag = n13;
                return;
            }
            do {
                object2 = n10 != 0 ? this.readStringRequireUtf8() : this.readString();
                ((List)object).add(object2);
                object2 = this.input;
                n12 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
                if (n12 == 0) continue;
                return;
            } while ((n12 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n11 = this.tag));
            this.nextTag = n12;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void readStringListRequireUtf8(List list) {
        this.readStringListInternal(list, true);
    }

    public String readStringRequireUtf8() {
        this.requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    public int readUInt32() {
        this.requireWireType(0);
        return this.input.readUInt32();
    }

    public void readUInt32List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof IntArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (IntArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    n12 = this.input.readUInt32();
                                    ((IntArrayList)list).addInt(n12);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            n12 = this.input.readUInt32();
                            ((IntArrayList)list).addInt(n12);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        object3 = this.input.readUInt32();
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            object2 = this.input.readUInt32();
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public long readUInt64() {
        this.requireWireType(0);
        return this.input.readUInt64();
    }

    public void readUInt64List(List object) {
        Object object2;
        int n10;
        int n11;
        block10: {
            block11: {
                block9: {
                    block6: {
                        int n12;
                        List list;
                        block7: {
                            block8: {
                                n11 = object instanceof LongArrayList;
                                n10 = 2;
                                if (n11 == 0) break block6;
                                list = object;
                                list = (LongArrayList)object;
                                n12 = WireFormat.getTagWireType(this.tag);
                                if (n12 == 0) break block7;
                                if (n12 != n10) break block8;
                                object = this.input;
                                n12 = ((CodedInputStream)object).readUInt32();
                                CodedInputStream codedInputStream = this.input;
                                n10 = codedInputStream.getTotalBytesRead() + n12;
                                do {
                                    long l10 = this.input.readUInt64();
                                    ((LongArrayList)list).addLong(l10);
                                } while ((n12 = ((CodedInputStream)(object = this.input)).getTotalBytesRead()) < n10);
                                this.requirePosition(n10);
                                break block9;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        do {
                            long l11 = this.input.readUInt64();
                            ((LongArrayList)list).addLong(l11);
                            object = this.input;
                            n12 = (int)(((CodedInputStream)object).isAtEnd() ? 1 : 0);
                            if (n12 == 0) continue;
                            return;
                        } while ((n12 = ((CodedInputStream)(object = this.input)).readTag()) == (n10 = this.tag));
                        this.nextTag = n12;
                        return;
                    }
                    n11 = WireFormat.getTagWireType(this.tag);
                    if (n11 == 0) break block10;
                    if (n11 != n10) break block11;
                    Object object3 = this.input;
                    n11 = ((CodedInputStream)object3).readUInt32();
                    CodedInputStream codedInputStream = this.input;
                    n10 = codedInputStream.getTotalBytesRead() + n11;
                    do {
                        long l12 = this.input.readUInt64();
                        object3 = l12;
                        object.add(object3);
                    } while ((n11 = ((CodedInputStream)(object3 = this.input)).getTotalBytesRead()) < n10);
                    this.requirePosition(n10);
                }
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            long l13 = this.input.readUInt64();
            object2 = l13;
            object.add(object2);
            object2 = this.input;
            n11 = (int)(((CodedInputStream)object2).isAtEnd() ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = ((CodedInputStream)(object2 = this.input)).readTag()) == (n10 = this.tag));
        this.nextTag = n11;
    }

    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    public boolean skipField() {
        int n10;
        CodedInputStream codedInputStream = this.input;
        int n11 = codedInputStream.isAtEnd();
        if (n11 == 0 && (n11 = this.tag) != (n10 = this.endGroupTag)) {
            return this.input.skipField(n11);
        }
        return false;
    }
}

