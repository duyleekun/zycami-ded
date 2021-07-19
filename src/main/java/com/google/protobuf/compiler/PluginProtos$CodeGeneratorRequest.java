/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest$Builder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequestOrBuilder;
import com.google.protobuf.compiler.PluginProtos$Version;
import com.google.protobuf.compiler.PluginProtos$Version$Builder;
import com.google.protobuf.compiler.PluginProtos$VersionOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorRequest
extends GeneratedMessageV3
implements PluginProtos$CodeGeneratorRequestOrBuilder {
    public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
    private static final PluginProtos$CodeGeneratorRequest DEFAULT_INSTANCE;
    public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
    public static final int PARAMETER_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PROTO_FILE_FIELD_NUMBER = 15;
    private static final long serialVersionUID;
    private int bitField0_;
    private PluginProtos$Version compilerVersion_;
    private LazyStringList fileToGenerate_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object parameter_;
    private List protoFile_;

    static {
        Object object = new PluginProtos$CodeGeneratorRequest();
        DEFAULT_INSTANCE = object;
        PARSER = object = new PluginProtos$CodeGeneratorRequest$1();
    }

    private PluginProtos$CodeGeneratorRequest() {
        List list;
        this.fileToGenerate_ = list = LazyStringArrayList.EMPTY;
        this.parameter_ = "";
        list = Collections.emptyList();
        this.protoFile_ = list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PluginProtos$CodeGeneratorRequest(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block20: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            Object object;
                            Object object2;
                            int n14 = 10;
                            if (n13 != n14) {
                                n14 = 18;
                                if (n13 != n14) {
                                    n14 = 26;
                                    if (n13 != n14) {
                                        n14 = 122;
                                        if (n13 != n14) {
                                            if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                            break block20;
                                        } else {
                                            n13 = n11 & 4;
                                            if (n13 == 0) {
                                                this.protoFile_ = object2;
                                                n11 |= 4;
                                            }
                                            object2 = this.protoFile_;
                                            object = DescriptorProtos$FileDescriptorProto.PARSER;
                                            object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                            object2.add(object);
                                            continue;
                                        }
                                    }
                                    n13 = 0;
                                    object2 = null;
                                    n12 = this.bitField0_ & 2;
                                    if (n12 != 0) {
                                        object2 = this.compilerVersion_;
                                        object2 = ((PluginProtos$Version)object2).toBuilder();
                                    }
                                    object = PluginProtos$Version.PARSER;
                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                    this.compilerVersion_ = object = (PluginProtos$Version)object;
                                    if (object2 != null) {
                                        ((PluginProtos$Version$Builder)object2).mergeFrom((PluginProtos$Version)object);
                                        this.compilerVersion_ = object2 = ((PluginProtos$Version$Builder)object2).buildPartial();
                                    }
                                    this.bitField0_ = n13 = this.bitField0_ | 2;
                                    continue;
                                }
                                object2 = ((CodedInputStream)((Object)list)).readBytes();
                                n14 = this.bitField0_;
                                this.bitField0_ = n12 |= n14;
                                this.parameter_ = object2;
                                continue;
                            }
                            object2 = ((CodedInputStream)((Object)list)).readBytes();
                            n12 = n11 & 1;
                            if (n12 == 0) {
                                object = new LazyStringArrayList();
                                this.fileToGenerate_ = object;
                                n11 |= 1;
                            }
                            object = this.fileToGenerate_;
                            object.add((ByteString)object2);
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
            int n15 = n11 & 1;
            if (n15 != 0) {
                list2 = this.fileToGenerate_.getUnmodifiableView();
                this.fileToGenerate_ = list2;
            }
            if ((n15 = n11 & 4) != 0) {
                this.protoFile_ = list2 = Collections.unmodifiableList(this.protoFile_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 1;
        if (n16 != 0) {
            list = this.fileToGenerate_.getUnmodifiableView();
            this.fileToGenerate_ = list;
        }
        if ((n16 = n11 & 4) != 0) {
            this.protoFile_ = list = Collections.unmodifiableList(this.protoFile_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ PluginProtos$CodeGeneratorRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, PluginProtos$1 pluginProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private PluginProtos$CodeGeneratorRequest(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorRequest(GeneratedMessageV3$Builder generatedMessageV3$Builder, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$1700() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ LazyStringList access$1900(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest) {
        return pluginProtos$CodeGeneratorRequest.fileToGenerate_;
    }

    public static /* synthetic */ LazyStringList access$1902(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest, LazyStringList lazyStringList) {
        pluginProtos$CodeGeneratorRequest.fileToGenerate_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$2000(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest) {
        return pluginProtos$CodeGeneratorRequest.parameter_;
    }

    public static /* synthetic */ Object access$2002(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest, Object object) {
        pluginProtos$CodeGeneratorRequest.parameter_ = object;
        return object;
    }

    public static /* synthetic */ List access$2100(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest) {
        return pluginProtos$CodeGeneratorRequest.protoFile_;
    }

    public static /* synthetic */ List access$2102(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest, List list) {
        pluginProtos$CodeGeneratorRequest.protoFile_ = list;
        return list;
    }

    public static /* synthetic */ PluginProtos$Version access$2202(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest, PluginProtos$Version pluginProtos$Version) {
        pluginProtos$CodeGeneratorRequest.compilerVersion_ = pluginProtos$Version;
        return pluginProtos$Version;
    }

    public static /* synthetic */ int access$2302(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest, int n10) {
        pluginProtos$CodeGeneratorRequest.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$2400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$2500(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest) {
        return pluginProtos$CodeGeneratorRequest.unknownFields;
    }

    public static PluginProtos$CodeGeneratorRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$1300();
    }

    public static PluginProtos$CodeGeneratorRequest$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PluginProtos$CodeGeneratorRequest$Builder newBuilder(PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest) {
        return ((PluginProtos$CodeGeneratorRequest$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(pluginProtos$CodeGeneratorRequest);
    }

    public static PluginProtos$CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(ByteString byteString) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byteString);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byteBuffer);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(byte[] byArray) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byArray);
    }

    public static PluginProtos$CodeGeneratorRequest parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorRequest)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof PluginProtos$CodeGeneratorRequest;
        if (!bl4) {
            return super.equals(object);
        }
        object = (PluginProtos$CodeGeneratorRequest)object;
        Object object3 = this.getFileToGenerateList();
        ProtocolStringList protocolStringList = ((PluginProtos$CodeGeneratorRequest)object).getFileToGenerateList();
        bl4 = object3.equals(protocolStringList);
        protocolStringList = null;
        if (!bl4) {
            return false;
        }
        bl4 = this.hasParameter();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorRequest)object).hasParameter())) {
            return false;
        }
        bl4 = this.hasParameter();
        if (bl4 && !(bl4 = ((String)(object3 = this.getParameter())).equals(object2 = ((PluginProtos$CodeGeneratorRequest)object).getParameter()))) {
            return false;
        }
        object3 = this.getProtoFileList();
        bl4 = object3.equals(object2 = ((PluginProtos$CodeGeneratorRequest)object).getProtoFileList());
        if (!bl4) {
            return false;
        }
        bl4 = this.hasCompilerVersion();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorRequest)object).hasCompilerVersion())) {
            return false;
        }
        bl4 = this.hasCompilerVersion();
        if (bl4 && !(bl4 = ((PluginProtos$Version)(object3 = this.getCompilerVersion())).equals(object2 = ((PluginProtos$CodeGeneratorRequest)object).getCompilerVersion()))) {
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

    public PluginProtos$Version getCompilerVersion() {
        PluginProtos$Version pluginProtos$Version = this.compilerVersion_;
        if (pluginProtos$Version == null) {
            pluginProtos$Version = PluginProtos$Version.getDefaultInstance();
        }
        return pluginProtos$Version;
    }

    public PluginProtos$VersionOrBuilder getCompilerVersionOrBuilder() {
        PluginProtos$Version pluginProtos$Version = this.compilerVersion_;
        if (pluginProtos$Version == null) {
            pluginProtos$Version = PluginProtos$Version.getDefaultInstance();
        }
        return pluginProtos$Version;
    }

    public PluginProtos$CodeGeneratorRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getFileToGenerate(int n10) {
        return (String)this.fileToGenerate_.get(n10);
    }

    public ByteString getFileToGenerateBytes(int n10) {
        return this.fileToGenerate_.getByteString(n10);
    }

    public int getFileToGenerateCount() {
        return this.fileToGenerate_.size();
    }

    public ProtocolStringList getFileToGenerateList() {
        return this.fileToGenerate_;
    }

    public String getParameter() {
        Object object = this.parameter_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.parameter_ = string2;
        }
        return string2;
    }

    public ByteString getParameterBytes() {
        Object object = this.parameter_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.parameter_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public DescriptorProtos$FileDescriptorProto getProtoFile(int n10) {
        return (DescriptorProtos$FileDescriptorProto)this.protoFile_.get(n10);
    }

    public int getProtoFileCount() {
        return this.protoFile_.size();
    }

    public List getProtoFileList() {
        return this.protoFile_;
    }

    public DescriptorProtos$FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int n10) {
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.protoFile_.get(n10);
    }

    public List getProtoFileOrBuilderList() {
        return this.protoFile_;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        Object object2 = null;
        int n13 = 0;
        for (n12 = 0; n12 < (n10 = (object = this.fileToGenerate_).size()); ++n12) {
            object = this.fileToGenerate_.getRaw(n12);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n10;
        }
        n13 += 0;
        object2 = this.getFileToGenerateList();
        n12 = object2.size() * 1;
        n13 += n12;
        n12 = this.bitField0_ & 1;
        n10 = 2;
        if (n12 != 0) {
            object2 = this.parameter_;
            n12 = GeneratedMessageV3.computeStringSize(n10, object2);
            n13 += n12;
        }
        if ((n12 = this.bitField0_ & n10) != 0) {
            object = this.getCompilerVersion();
            n12 = CodedOutputStream.computeMessageSize(3, (MessageLite)object);
            n13 += n12;
        }
        while (n11 < (n12 = (object2 = this.protoFile_).size())) {
            object = (MessageLite)this.protoFile_.get(n11);
            n12 = CodedOutputStream.computeMessageSize(15, (MessageLite)object);
            n13 += n12;
            ++n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n11;
        return n13;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasCompilerVersion() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasParameter() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = PluginProtos$CodeGeneratorRequest.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getFileToGenerateCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getFileToGenerateList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasParameter() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getParameter();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getProtoFileCount()) > 0) {
            n10 = (n10 * 37 + 15) * 53;
            object = this.getProtoFileList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCompilerVersion() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getCompilerVersion();
            n11 = ((PluginProtos$Version)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$1400().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorRequest.class, PluginProtos$CodeGeneratorRequest$Builder.class);
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
        for (n11 = 0; n11 < (n10 = this.getProtoFileCount()); ++n11) {
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.getProtoFile(n11);
            n10 = descriptorProtos$FileDescriptorProto.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public PluginProtos$CodeGeneratorRequest$Builder newBuilderForType() {
        return PluginProtos$CodeGeneratorRequest.newBuilder();
    }

    public PluginProtos$CodeGeneratorRequest$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        PluginProtos$CodeGeneratorRequest$Builder pluginProtos$CodeGeneratorRequest$Builder = new PluginProtos$CodeGeneratorRequest$Builder(generatedMessageV3$BuilderParent, null);
        return pluginProtos$CodeGeneratorRequest$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new PluginProtos$CodeGeneratorRequest();
        return object;
    }

    public PluginProtos$CodeGeneratorRequest$Builder toBuilder() {
        PluginProtos$CodeGeneratorRequestOrBuilder pluginProtos$CodeGeneratorRequestOrBuilder = DEFAULT_INSTANCE;
        if (this == pluginProtos$CodeGeneratorRequestOrBuilder) {
            pluginProtos$CodeGeneratorRequestOrBuilder = new PluginProtos$CodeGeneratorRequest$Builder(null);
        } else {
            pluginProtos$CodeGeneratorRequestOrBuilder = new PluginProtos$CodeGeneratorRequest$Builder(null);
            pluginProtos$CodeGeneratorRequestOrBuilder = ((PluginProtos$CodeGeneratorRequest$Builder)pluginProtos$CodeGeneratorRequestOrBuilder).mergeFrom(this);
        }
        return pluginProtos$CodeGeneratorRequestOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        Object object;
        int n12 = 0;
        int n13 = 0;
        Object object2 = null;
        while (true) {
            object = this.fileToGenerate_;
            n11 = object.size();
            n10 = 1;
            if (n13 >= n11) break;
            object = this.fileToGenerate_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        n11 = 2;
        if (n13 != 0) {
            object2 = this.parameter_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        if ((n13 = this.bitField0_ & n11) != 0) {
            n13 = 3;
            object = this.getCompilerVersion();
            codedOutputStream.writeMessage(n13, (MessageLite)object);
        }
        while (n12 < (n13 = (object2 = this.protoFile_).size())) {
            n13 = 15;
            object = (MessageLite)this.protoFile_.get(n12);
            codedOutputStream.writeMessage(n13, (MessageLite)object);
            ++n12;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

