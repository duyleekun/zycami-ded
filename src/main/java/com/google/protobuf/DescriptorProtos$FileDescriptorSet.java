/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
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

public final class DescriptorProtos$FileDescriptorSet
extends GeneratedMessageV3
implements DescriptorProtos$FileDescriptorSetOrBuilder {
    private static final DescriptorProtos$FileDescriptorSet DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private List file_;
    private byte memoizedIsInitialized;

    static {
        Object object = new DescriptorProtos$FileDescriptorSet();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$FileDescriptorSet$1();
    }

    private DescriptorProtos$FileDescriptorSet() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.file_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$FileDescriptorSet(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block12: {
            Throwable throwable2;
            this();
            Objects.requireNonNull(list2);
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            boolean bl2 = false;
            n10 = 0;
            while (true) {
                boolean bl3 = true;
                if (bl2) break block12;
                try {
                    try {
                        int n11 = ((CodedInputStream)((Object)list)).readTag();
                        if (n11 != 0) {
                            int n12 = 10;
                            if (n11 != n12) {
                                if ((n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n11) ? 1 : 0)) != 0) continue;
                            } else {
                                List<Object> list3;
                                n11 = n10 & 1;
                                if (n11 == 0) {
                                    this.file_ = list3 = new List<Object>();
                                    n10 |= 1;
                                }
                                list3 = this.file_;
                                Object object = DescriptorProtos$FileDescriptorProto.PARSER;
                                object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                list3.add(object);
                                continue;
                            }
                        }
                        bl2 = bl3;
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
                catch (Throwable throwable2) {}
                break;
            }
            boolean bl4 = n10 & true;
            if (bl4) {
                this.file_ = list2 = Collections.unmodifiableList(this.file_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.file_ = list = Collections.unmodifiableList(this.file_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorSet(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$FileDescriptorSet(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorSet(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$500(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet) {
        return descriptorProtos$FileDescriptorSet.file_;
    }

    public static /* synthetic */ List access$502(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet, List list) {
        descriptorProtos$FileDescriptorSet.file_ = list;
        return list;
    }

    public static DescriptorProtos$FileDescriptorSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$000();
    }

    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileDescriptorSet$Builder newBuilder(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileDescriptorSet);
    }

    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] byArray) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$FileDescriptorSet parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorSet)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof DescriptorProtos$FileDescriptorSet;
        if (!bl3) {
            return super.equals(object);
        }
        object = (DescriptorProtos$FileDescriptorSet)object;
        Object object2 = this.getFileList();
        List list = ((DescriptorProtos$FileDescriptorSet)object).getFileList();
        bl3 = object2.equals(list);
        list = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public DescriptorProtos$FileDescriptorProto getFile(int n10) {
        return (DescriptorProtos$FileDescriptorProto)this.file_.get(n10);
    }

    public int getFileCount() {
        return this.file_.size();
    }

    public List getFileList() {
        return this.file_;
    }

    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int n10) {
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(n10);
    }

    public List getFileOrBuilderList() {
        return this.file_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n12 = 0;
        for (n11 = 0; n11 < (n10 = (object = this.file_).size()); ++n11) {
            object = (MessageLite)this.file_.get(n11);
            int n13 = 1;
            n10 = CodedOutputStream.computeMessageSize(n13, (MessageLite)object);
            n12 += n10;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n11;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = DescriptorProtos$FileDescriptorSet.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getFileCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getFileList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
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
        for (n11 = 0; n11 < (n10 = this.getFileCount()); ++n11) {
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.getFile(n11);
            n10 = descriptorProtos$FileDescriptorProto.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public DescriptorProtos$FileDescriptorSet$Builder newBuilderForType() {
        return DescriptorProtos$FileDescriptorSet.newBuilder();
    }

    public DescriptorProtos$FileDescriptorSet$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$FileDescriptorSet$Builder descriptorProtos$FileDescriptorSet$Builder = new DescriptorProtos$FileDescriptorSet$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$FileDescriptorSet$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$FileDescriptorSet();
        return object;
    }

    public DescriptorProtos$FileDescriptorSet$Builder toBuilder() {
        DescriptorProtos$FileDescriptorSetOrBuilder descriptorProtos$FileDescriptorSetOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$FileDescriptorSetOrBuilder) {
            descriptorProtos$FileDescriptorSetOrBuilder = new DescriptorProtos$FileDescriptorSet$Builder(null);
        } else {
            descriptorProtos$FileDescriptorSetOrBuilder = new DescriptorProtos$FileDescriptorSet$Builder(null);
            descriptorProtos$FileDescriptorSetOrBuilder = ((DescriptorProtos$FileDescriptorSet$Builder)descriptorProtos$FileDescriptorSetOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$FileDescriptorSetOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.file_).size()); ++i10) {
            object = (MessageLite)this.file_.get(i10);
            int n11 = 1;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

