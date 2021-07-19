/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$EnumValueDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
    private static final DescriptorProtos$EnumValueDescriptorProto DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private int number_;
    private DescriptorProtos$EnumValueOptions options_;

    static {
        Object object = new DescriptorProtos$EnumValueDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$EnumValueDescriptorProto$1();
    }

    private DescriptorProtos$EnumValueDescriptorProto() {
        this.name_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$EnumValueDescriptorProto(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        while (true) {
            if (n10 != 0) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11;
                    block14: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            Object object3;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 16;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block14;
                                    } else {
                                        n12 = 0;
                                        object3 = null;
                                        n11 = this.bitField0_ & 4;
                                        if (n11 != 0) {
                                            object3 = this.options_;
                                            object3 = ((DescriptorProtos$EnumValueOptions)object3).toBuilder();
                                        }
                                        Object object4 = DescriptorProtos$EnumValueOptions.PARSER;
                                        object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                        this.options_ = object4 = (DescriptorProtos$EnumValueOptions)object4;
                                        if (object3 != null) {
                                            ((DescriptorProtos$EnumValueOptions$Builder)object3).mergeFrom((DescriptorProtos$EnumValueOptions)object4);
                                            this.options_ = object3 = ((DescriptorProtos$EnumValueOptions$Builder)object3).buildPartial();
                                        }
                                        this.bitField0_ = n12 = this.bitField0_ | 4;
                                        continue;
                                    }
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.number_ = n12 = ((CodedInputStream)object).readInt32();
                                continue;
                            }
                            object3 = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.name_ = object3;
                            continue;
                        }
                    }
                    n10 = n11;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable2) {}
            break;
        }
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ DescriptorProtos$EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$EnumValueDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$EnumValueDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$12100(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        return descriptorProtos$EnumValueDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$12102(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, Object object) {
        descriptorProtos$EnumValueDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ int access$12202(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, int n10) {
        descriptorProtos$EnumValueDescriptorProto.number_ = n10;
        return n10;
    }

    public static /* synthetic */ DescriptorProtos$EnumValueOptions access$12302(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        descriptorProtos$EnumValueDescriptorProto.options_ = descriptorProtos$EnumValueOptions;
        return descriptorProtos$EnumValueOptions;
    }

    public static /* synthetic */ int access$12402(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, int n10) {
        descriptorProtos$EnumValueDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$EnumValueDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$11600();
    }

    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueDescriptorProto);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof DescriptorProtos$EnumValueDescriptorProto;
        if (n11 == 0) {
            return super.equals(object);
        }
        object = (DescriptorProtos$EnumValueDescriptorProto)object;
        n11 = this.hasName();
        if (n11 != (n10 = ((DescriptorProtos$EnumValueDescriptorProto)object).hasName())) {
            return false;
        }
        n11 = this.hasName();
        if (n11 != 0 && (n11 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$EnumValueDescriptorProto)object).getName())) == 0) {
            return false;
        }
        n11 = this.hasNumber();
        if (n11 != (n10 = ((DescriptorProtos$EnumValueDescriptorProto)object).hasNumber())) {
            return false;
        }
        n11 = this.hasNumber();
        if (n11 != 0 && (n11 = this.getNumber()) != (n10 = ((DescriptorProtos$EnumValueDescriptorProto)object).getNumber())) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != (n10 = (int)(((DescriptorProtos$EnumValueDescriptorProto)object).hasOptions() ? 1 : 0))) {
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((DescriptorProtos$EnumValueOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$EnumValueDescriptorProto)object).getOptions()) ? 1 : 0)) == 0) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = ((UnknownFieldSet)object3).equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.name_ = string2;
        }
        return string2;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getNumber() {
        return this.number_;
    }

    public DescriptorProtos$EnumValueOptions getOptions() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.options_;
        if (descriptorProtos$EnumValueOptions == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
        }
        return descriptorProtos$EnumValueOptions;
    }

    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.options_;
        if (descriptorProtos$EnumValueOptions == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
        }
        return descriptorProtos$EnumValueOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            Object object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            n11 = this.number_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.getOptions();
            n11 = CodedOutputStream.computeMessageSize(3, descriptorProtos$EnumValueOptions);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasNumber() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$EnumValueDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNumber() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.getNumber();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$EnumValueOptions)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$11700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasOptions();
        if (by2 && !(by2 = (descriptorProtos$EnumValueOptions = this.getOptions()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$EnumValueDescriptorProto.newBuilder();
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder = new DescriptorProtos$EnumValueDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$EnumValueDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$EnumValueDescriptorProto();
        return object;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder toBuilder() {
        DescriptorProtos$EnumValueDescriptorProtoOrBuilder descriptorProtos$EnumValueDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$EnumValueDescriptorProtoOrBuilder) {
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = new DescriptorProtos$EnumValueDescriptorProto$Builder(null);
        } else {
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = new DescriptorProtos$EnumValueDescriptorProto$Builder(null);
            descriptorProtos$EnumValueDescriptorProtoOrBuilder = ((DescriptorProtos$EnumValueDescriptorProto$Builder)descriptorProtos$EnumValueDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$EnumValueDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            Object object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            n10 = this.number_;
            codedOutputStream.writeInt32(n11, n10);
        }
        if ((n10 = this.bitField0_ & 4) != 0) {
            n10 = 3;
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = this.getOptions();
            codedOutputStream.writeMessage(n10, descriptorProtos$EnumValueOptions);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

