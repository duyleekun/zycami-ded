/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$ServiceDescriptorProto
extends GeneratedMessageV3
implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private static final DescriptorProtos$ServiceDescriptorProto DEFAULT_INSTANCE;
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private List method_;
    private volatile Object name_;
    private DescriptorProtos$ServiceOptions options_;

    static {
        Object object = new DescriptorProtos$ServiceDescriptorProto();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$ServiceDescriptorProto$1();
    }

    private DescriptorProtos$ServiceDescriptorProto() {
        List list;
        this.name_ = "";
        this.method_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$ServiceDescriptorProto(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block16: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            Object object;
                            int n14 = 10;
                            if (n13 != n14) {
                                Object object2;
                                n14 = 18;
                                if (n13 != n14) {
                                    n14 = 26;
                                    if (n13 != n14) {
                                        if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                        break block16;
                                    } else {
                                        n13 = 0;
                                        object = null;
                                        n12 = this.bitField0_ & 2;
                                        if (n12 != 0) {
                                            object = this.options_;
                                            object = ((DescriptorProtos$ServiceOptions)object).toBuilder();
                                        }
                                        object2 = DescriptorProtos$ServiceOptions.PARSER;
                                        object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                        this.options_ = object2 = (DescriptorProtos$ServiceOptions)object2;
                                        if (object != null) {
                                            ((DescriptorProtos$ServiceOptions$Builder)object).mergeFrom((DescriptorProtos$ServiceOptions)object2);
                                            this.options_ = object = ((DescriptorProtos$ServiceOptions$Builder)object).buildPartial();
                                        }
                                        this.bitField0_ = n13 = this.bitField0_ | 2;
                                        continue;
                                    }
                                }
                                n13 = n11 & 2;
                                if (n13 == 0) {
                                    this.method_ = object;
                                    n11 |= 2;
                                }
                                object = this.method_;
                                object2 = DescriptorProtos$MethodDescriptorProto.PARSER;
                                object2 = ((CodedInputStream)((Object)list)).readMessage((Parser)object2, (ExtensionRegistryLite)((Object)list2));
                                object.add(object2);
                                continue;
                            }
                            object = ((CodedInputStream)((Object)list)).readBytes();
                            n14 = this.bitField0_;
                            this.bitField0_ = n12 |= n14;
                            this.name_ = object;
                            continue;
                        }
                    }
                    n10 = n12;
                    continue;
                }
                catch (IOException iOException) {
                    list2 = new List(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)((Object)list2)).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable) {}
            int n15 = n11 & 2;
            if (n15 != 0) {
                this.method_ = list2 = Collections.unmodifiableList(this.method_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 2;
        if (n16 != 0) {
            this.method_ = list = Collections.unmodifiableList(this.method_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$ServiceDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ DescriptorProtos$ServiceDescriptorProto(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$13100(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return descriptorProtos$ServiceDescriptorProto.name_;
    }

    public static /* synthetic */ Object access$13102(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Object object) {
        descriptorProtos$ServiceDescriptorProto.name_ = object;
        return object;
    }

    public static /* synthetic */ List access$13200(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return descriptorProtos$ServiceDescriptorProto.method_;
    }

    public static /* synthetic */ List access$13202(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, List list) {
        descriptorProtos$ServiceDescriptorProto.method_ = list;
        return list;
    }

    public static /* synthetic */ DescriptorProtos$ServiceOptions access$13302(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        descriptorProtos$ServiceDescriptorProto.options_ = descriptorProtos$ServiceOptions;
        return descriptorProtos$ServiceOptions;
    }

    public static /* synthetic */ int access$13402(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, int n10) {
        descriptorProtos$ServiceDescriptorProto.bitField0_ = n10;
        return n10;
    }

    public static DescriptorProtos$ServiceDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$12600();
    }

    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$ServiceDescriptorProto$Builder newBuilder(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$ServiceDescriptorProto);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] byArray) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$ServiceDescriptorProto parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$ServiceDescriptorProto)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl4 = object instanceof DescriptorProtos$ServiceDescriptorProto;
        if (!bl4) {
            return super.equals(object);
        }
        object = (DescriptorProtos$ServiceDescriptorProto)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((DescriptorProtos$ServiceDescriptorProto)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object3 = this.getName())).equals(object2 = ((DescriptorProtos$ServiceDescriptorProto)object).getName()))) {
            return false;
        }
        object3 = this.getMethodList();
        bl4 = object3.equals(object2 = ((DescriptorProtos$ServiceDescriptorProto)object).getMethodList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 != (bl2 = ((DescriptorProtos$ServiceDescriptorProto)object).hasOptions())) {
            return false;
        }
        bl4 = this.hasOptions();
        if (bl4 && !(bl4 = ((DescriptorProtos$ServiceOptions)(object3 = this.getOptions())).equals(object2 = ((DescriptorProtos$ServiceDescriptorProto)object).getOptions()))) {
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

    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public DescriptorProtos$MethodDescriptorProto getMethod(int n10) {
        return (DescriptorProtos$MethodDescriptorProto)this.method_.get(n10);
    }

    public int getMethodCount() {
        return this.method_.size();
    }

    public List getMethodList() {
        return this.method_;
    }

    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int n10) {
        return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(n10);
    }

    public List getMethodOrBuilderList() {
        return this.method_;
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

    public DescriptorProtos$ServiceOptions getOptions() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.options_;
        if (descriptorProtos$ServiceOptions == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
        }
        return descriptorProtos$ServiceOptions;
    }

    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.options_;
        if (descriptorProtos$ServiceOptions == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
        }
        return descriptorProtos$ServiceOptions;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10;
        Object object;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = null;
        if ((n11 &= n12) != 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object) + 0;
        } else {
            n11 = 0;
            object = null;
        }
        while (true) {
            Object object2 = this.method_;
            n12 = object2.size();
            n10 = 2;
            if (n13 >= n12) break;
            object2 = (MessageLite)this.method_.get(n13);
            n12 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object2);
            n11 += n12;
            ++n13;
        }
        n12 = this.bitField0_ & n10;
        if (n12 != 0) {
            descriptorProtos$ServiceOptions = this.getOptions();
            n12 = CodedOutputStream.computeMessageSize(3, descriptorProtos$ServiceOptions);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
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
        Object object = DescriptorProtos$ServiceDescriptorProto.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getMethodCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getMethodList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOptions() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getOptions();
            n11 = ((DescriptorProtos$ServiceOptions)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$12700().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = null;
        for (n11 = 0; n11 < (n10 = this.getMethodCount()); ++n11) {
            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = this.getMethod(n11);
            n10 = (int)(descriptorProtos$MethodDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n11 = (int)(this.hasOptions() ? 1 : 0);
        if (n11 != 0 && (n11 = (descriptorProtos$ServiceOptions = this.getOptions()).isInitialized()) == 0) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$ServiceDescriptorProto.newBuilder();
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder = new DescriptorProtos$ServiceDescriptorProto$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$ServiceDescriptorProto$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$ServiceDescriptorProto();
        return object;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder toBuilder() {
        DescriptorProtos$ServiceDescriptorProtoOrBuilder descriptorProtos$ServiceDescriptorProtoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$ServiceDescriptorProtoOrBuilder) {
            descriptorProtos$ServiceDescriptorProtoOrBuilder = new DescriptorProtos$ServiceDescriptorProto$Builder(null);
        } else {
            descriptorProtos$ServiceDescriptorProtoOrBuilder = new DescriptorProtos$ServiceDescriptorProto$Builder(null);
            descriptorProtos$ServiceDescriptorProtoOrBuilder = ((DescriptorProtos$ServiceDescriptorProto$Builder)descriptorProtos$ServiceDescriptorProtoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$ServiceDescriptorProtoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        Object object;
        Object object2;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object2 = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n11 = 0;
        object2 = null;
        while (true) {
            object = this.method_;
            n12 = object.size();
            n10 = 2;
            if (n11 >= n12) break;
            object = (MessageLite)this.method_.get(n11);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 != 0) {
            n11 = 3;
            object = this.getOptions();
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

