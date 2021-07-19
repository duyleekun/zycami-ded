/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$1;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$GeneratedCodeInfoOrBuilder;
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

public final class DescriptorProtos$GeneratedCodeInfo
extends GeneratedMessageV3
implements DescriptorProtos$GeneratedCodeInfoOrBuilder {
    public static final int ANNOTATION_FIELD_NUMBER = 1;
    private static final DescriptorProtos$GeneratedCodeInfo DEFAULT_INSTANCE;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private List annotation_;
    private byte memoizedIsInitialized;

    static {
        Object object = new DescriptorProtos$GeneratedCodeInfo();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$GeneratedCodeInfo$1();
    }

    private DescriptorProtos$GeneratedCodeInfo() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.annotation_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$GeneratedCodeInfo(CodedInputStream list, ExtensionRegistryLite list2) {
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
                                    this.annotation_ = list3 = new List<Object>();
                                    n10 |= 1;
                                }
                                list3 = this.annotation_;
                                Object object = DescriptorProtos$GeneratedCodeInfo$Annotation.PARSER;
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
                this.annotation_ = list2 = Collections.unmodifiableList(this.annotation_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.annotation_ = list = Collections.unmodifiableList(this.annotation_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$GeneratedCodeInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$GeneratedCodeInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$30600(DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo) {
        return descriptorProtos$GeneratedCodeInfo.annotation_;
    }

    public static /* synthetic */ List access$30602(DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo, List list) {
        descriptorProtos$GeneratedCodeInfo.annotation_ = list;
        return list;
    }

    public static DescriptorProtos$GeneratedCodeInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$29000();
    }

    public static DescriptorProtos$GeneratedCodeInfo$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$GeneratedCodeInfo$Builder newBuilder(DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$GeneratedCodeInfo);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteString byteString) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(byte[] byArray) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$GeneratedCodeInfo)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof DescriptorProtos$GeneratedCodeInfo;
        if (!bl3) {
            return super.equals(object);
        }
        object = (DescriptorProtos$GeneratedCodeInfo)object;
        Object object2 = this.getAnnotationList();
        List list = ((DescriptorProtos$GeneratedCodeInfo)object).getAnnotationList();
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

    public DescriptorProtos$GeneratedCodeInfo$Annotation getAnnotation(int n10) {
        return (DescriptorProtos$GeneratedCodeInfo$Annotation)this.annotation_.get(n10);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List getAnnotationList() {
        return this.annotation_;
    }

    public DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder getAnnotationOrBuilder(int n10) {
        return (DescriptorProtos$GeneratedCodeInfo$AnnotationOrBuilder)this.annotation_.get(n10);
    }

    public List getAnnotationOrBuilderList() {
        return this.annotation_;
    }

    public DescriptorProtos$GeneratedCodeInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        for (n11 = 0; n11 < (n10 = (object = this.annotation_).size()); ++n11) {
            object = (MessageLite)this.annotation_.get(n11);
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
        Object object = DescriptorProtos$GeneratedCodeInfo.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getAnnotationCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getAnnotationList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$29100().ensureFieldAccessorsInitialized(DescriptorProtos$GeneratedCodeInfo.class, DescriptorProtos$GeneratedCodeInfo$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder newBuilderForType() {
        return DescriptorProtos$GeneratedCodeInfo.newBuilder();
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$GeneratedCodeInfo$Builder descriptorProtos$GeneratedCodeInfo$Builder = new DescriptorProtos$GeneratedCodeInfo$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$GeneratedCodeInfo$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$GeneratedCodeInfo();
        return object;
    }

    public DescriptorProtos$GeneratedCodeInfo$Builder toBuilder() {
        DescriptorProtos$GeneratedCodeInfoOrBuilder descriptorProtos$GeneratedCodeInfoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$GeneratedCodeInfoOrBuilder) {
            descriptorProtos$GeneratedCodeInfoOrBuilder = new DescriptorProtos$GeneratedCodeInfo$Builder(null);
        } else {
            descriptorProtos$GeneratedCodeInfoOrBuilder = new DescriptorProtos$GeneratedCodeInfo$Builder(null);
            descriptorProtos$GeneratedCodeInfoOrBuilder = ((DescriptorProtos$GeneratedCodeInfo$Builder)descriptorProtos$GeneratedCodeInfoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$GeneratedCodeInfoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.annotation_).size()); ++i10) {
            object = (MessageLite)this.annotation_.get(i10);
            int n11 = 1;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

