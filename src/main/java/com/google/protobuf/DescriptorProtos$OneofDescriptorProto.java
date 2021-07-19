/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofOptions;
import com.google.protobuf.DescriptorProtos$OneofOptions$Builder;
import com.google.protobuf.DescriptorProtos$OneofOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class DescriptorProtos$OneofDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
    private static final DescriptorProtos$OneofDescriptorProto DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;
    private DescriptorProtos$OneofOptions options_;

    static {
        Object object = new DescriptorProtos$OneofDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$OneofDescriptorProto$1();
    }

    private DescriptorProtos$OneofDescriptorProto() {
        this.name_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$OneofDescriptorProto(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block13: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            Object object3;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                    break block13;
                                } else {
                                    n12 = 0;
                                    object3 = null;
                                    n11 = this.bitField0_ & 2;
                                    if (n11 != 0) {
                                        object3 = this.options_;
                                        object3 = ((DescriptorProtos$OneofOptions)object3).toBuilder();
                                    }
                                    Object object4 = DescriptorProtos$OneofOptions.PARSER;
                                    object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                    this.options_ = object4 = (DescriptorProtos$OneofOptions)object4;
                                    if (object3 != null) {
                                        ((DescriptorProtos$OneofOptions$Builder)object3).mergeFrom((DescriptorProtos$OneofOptions)object4);
                                        this.options_ = object3 = ((DescriptorProtos$OneofOptions$Builder)object3).buildPartial();
                                    }
                                    this.bitField0_ = n12 = this.bitField0_ | 2;
                                    continue;
                                }
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

    public /* synthetic */ DescriptorProtos$OneofDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$OneofDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$OneofDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$9100(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        return descriptorProtos$OneofDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$9102(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, Object object) {
        descriptorProtos$OneofDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ DescriptorProtos$OneofOptions access$9202(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        descriptorProtos$OneofDescriptorProto.options_ = descriptorProtos$OneofOptions;
        return descriptorProtos$OneofOptions;
    }

    public static /* synthetic */ int access$9302(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, int n10) {
        descriptorProtos$OneofDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$OneofDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$8600();
    }

    public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$OneofDescriptorProto);
    }

    public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof DescriptorProtos$OneofDescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$OneofDescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$OneofDescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$OneofDescriptorProto)object).getName()))) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$OneofDescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$OneofOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$OneofDescriptorProto)object).getOptions()))) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object3).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
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

    public DescriptorProtos$OneofOptions getOptions() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = this.options_;
        if (descriptorProtos$OneofOptions == null) {
            descriptorProtos$OneofOptions = DescriptorProtos$OneofOptions.getDefaultInstance();
        }
        return descriptorProtos$OneofOptions;
    }

    public DescriptorProtos$OneofOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = this.options_;
        if (descriptorProtos$OneofOptions == null) {
            descriptorProtos$OneofOptions = DescriptorProtos$OneofOptions.getDefaultInstance();
        }
        return descriptorProtos$OneofOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            object = this.getOptions();
            n11 = CodedOutputStream.computeMessageSize(n12, (MessageLite)object);
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

    public boolean hasOptions() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$OneofDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$OneofOptions)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$8700().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasOptions();
        if (by2 && !(by2 = (descriptorProtos$OneofOptions = this.getOptions()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$OneofDescriptorProto.newBuilder();
    }

    public DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder = new DescriptorProtos$OneofDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$OneofDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$OneofDescriptorProto();
        return object;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder toBuilder() {
        DescriptorProtos$OneofDescriptorProtoOrBuilder descriptorProtos$OneofDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$OneofDescriptorProtoOrBuilder) {
            descriptorProtos$OneofDescriptorProtoOrBuilder = new DescriptorProtos$OneofDescriptorProto$Builder(null);
        } else {
            descriptorProtos$OneofDescriptorProtoOrBuilder = new DescriptorProtos$OneofDescriptorProto$Builder(null);
            descriptorProtos$OneofDescriptorProtoOrBuilder = ((DescriptorProtos$OneofDescriptorProto$Builder)descriptorProtos$OneofDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$OneofDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            object = this.getOptions();
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

