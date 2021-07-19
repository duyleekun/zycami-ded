/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
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

public final class DescriptorProtos$SourceCodeInfo
extends GeneratedMessageV3
implements DescriptorProtos$SourceCodeInfoOrBuilder {
    private static final DescriptorProtos$SourceCodeInfo DEFAULT_INSTANCE;
    public static final int LOCATION_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private List location_;
    private byte memoizedIsInitialized;

    static {
        Object object = new DescriptorProtos$SourceCodeInfo();
        DEFAULT_INSTANCE = object;
        PARSER = object = new DescriptorProtos$SourceCodeInfo$1();
    }

    private DescriptorProtos$SourceCodeInfo() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.location_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DescriptorProtos$SourceCodeInfo(CodedInputStream list, ExtensionRegistryLite list2) {
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
                                    this.location_ = list3 = new List<Object>();
                                    n10 |= 1;
                                }
                                list3 = this.location_;
                                Object object = DescriptorProtos$SourceCodeInfo$Location.PARSER;
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
                this.location_ = list2 = Collections.unmodifiableList(this.location_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        boolean bl5 = n10 & true;
        if (bl5) {
            this.location_ = list = Collections.unmodifiableList(this.location_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private DescriptorProtos$SourceCodeInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ DescriptorProtos$SourceCodeInfo(GeneratedMessageV3$Builder generatedMessageV3$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ List access$28800(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return descriptorProtos$SourceCodeInfo.location_;
    }

    public static /* synthetic */ List access$28802(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo, List list) {
        descriptorProtos$SourceCodeInfo.location_ = list;
        return list;
    }

    public static DescriptorProtos$SourceCodeInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$27100();
    }

    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo$Builder newBuilder(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$SourceCodeInfo);
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString byteString) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteBuffer);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] byArray) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byArray);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$SourceCodeInfo)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof DescriptorProtos$SourceCodeInfo;
        if (!bl3) {
            return super.equals(object);
        }
        object = (DescriptorProtos$SourceCodeInfo)object;
        Object object2 = this.getLocationList();
        List list = ((DescriptorProtos$SourceCodeInfo)object).getLocationList();
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

    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public DescriptorProtos$SourceCodeInfo$Location getLocation(int n10) {
        return (DescriptorProtos$SourceCodeInfo$Location)this.location_.get(n10);
    }

    public int getLocationCount() {
        return this.location_.size();
    }

    public List getLocationList() {
        return this.location_;
    }

    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int n10) {
        return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(n10);
    }

    public List getLocationOrBuilderList() {
        return this.location_;
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
        for (n11 = 0; n11 < (n10 = (object = this.location_).size()); ++n11) {
            object = (MessageLite)this.location_.get(n11);
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
        Object object = DescriptorProtos$SourceCodeInfo.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getLocationCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getLocationList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$27200().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
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

    public DescriptorProtos$SourceCodeInfo$Builder newBuilderForType() {
        return DescriptorProtos$SourceCodeInfo.newBuilder();
    }

    public DescriptorProtos$SourceCodeInfo$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        DescriptorProtos$SourceCodeInfo$Builder descriptorProtos$SourceCodeInfo$Builder = new DescriptorProtos$SourceCodeInfo$Builder(generatedMessageV3$BuilderParent, null);
        return descriptorProtos$SourceCodeInfo$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new DescriptorProtos$SourceCodeInfo();
        return object;
    }

    public DescriptorProtos$SourceCodeInfo$Builder toBuilder() {
        DescriptorProtos$SourceCodeInfoOrBuilder descriptorProtos$SourceCodeInfoOrBuilder = DEFAULT_INSTANCE;
        if (this == descriptorProtos$SourceCodeInfoOrBuilder) {
            descriptorProtos$SourceCodeInfoOrBuilder = new DescriptorProtos$SourceCodeInfo$Builder(null);
        } else {
            descriptorProtos$SourceCodeInfoOrBuilder = new DescriptorProtos$SourceCodeInfo$Builder(null);
            descriptorProtos$SourceCodeInfoOrBuilder = ((DescriptorProtos$SourceCodeInfo$Builder)descriptorProtos$SourceCodeInfoOrBuilder).mergeFrom(this);
        }
        return descriptorProtos$SourceCodeInfoOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.location_).size()); ++i10) {
            object = (MessageLite)this.location_.get(i10);
            int n11 = 1;
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

