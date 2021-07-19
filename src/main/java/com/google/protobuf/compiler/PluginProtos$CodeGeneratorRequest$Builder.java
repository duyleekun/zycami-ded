/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequestOrBuilder;
import com.google.protobuf.compiler.PluginProtos$Version;
import com.google.protobuf.compiler.PluginProtos$Version$Builder;
import com.google.protobuf.compiler.PluginProtos$VersionOrBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorRequest$Builder
extends GeneratedMessageV3$Builder
implements PluginProtos$CodeGeneratorRequestOrBuilder {
    private int bitField0_;
    private SingleFieldBuilderV3 compilerVersionBuilder_;
    private PluginProtos$Version compilerVersion_;
    private LazyStringList fileToGenerate_;
    private Object parameter_;
    private RepeatedFieldBuilderV3 protoFileBuilder_;
    private List protoFile_;

    private PluginProtos$CodeGeneratorRequest$Builder() {
        List list;
        this.fileToGenerate_ = list = LazyStringArrayList.EMPTY;
        this.parameter_ = "";
        list = Collections.emptyList();
        this.protoFile_ = list;
        this.maybeForceBuilderInitialization();
    }

    private PluginProtos$CodeGeneratorRequest$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = LazyStringArrayList.EMPTY;
        this.fileToGenerate_ = list;
        this.parameter_ = "";
        this.protoFile_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ PluginProtos$CodeGeneratorRequest$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorRequest$Builder(PluginProtos$1 pluginProtos$1) {
        this();
    }

    private void ensureFileToGenerateIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            LazyStringList lazyStringList = this.fileToGenerate_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.fileToGenerate_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    private void ensureProtoFileIsMutable() {
        int n10 = this.bitField0_ & 4;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.protoFile_;
            this.protoFile_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 4;
        }
    }

    private SingleFieldBuilderV3 getCompilerVersionFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            PluginProtos$Version pluginProtos$Version = this.getCompilerVersion();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.compilerVersionBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(pluginProtos$Version, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.compilerVersion_ = null;
        }
        return this.compilerVersionBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$1300();
    }

    private RepeatedFieldBuilderV3 getProtoFileFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.protoFile_;
            int n10 = this.bitField0_ & 4;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.protoFileBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.protoFile_ = null;
        }
        return this.protoFileBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = PluginProtos$CodeGeneratorRequest.access$1700();
        if (bl2) {
            this.getProtoFileFieldBuilder();
            this.getCompilerVersionFieldBuilder();
        }
    }

    public PluginProtos$CodeGeneratorRequest$Builder addAllFileToGenerate(Iterable iterable) {
        this.ensureFileToGenerateIsMutable();
        LazyStringList lazyStringList = this.fileToGenerate_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addAllProtoFile(Iterable iterable) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addFileToGenerate(String string2) {
        Objects.requireNonNull(string2);
        this.ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(string2);
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addFileToGenerateBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(byteString);
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addProtoFile(int n10, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addProtoFile(int n10, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            object.add(n10, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addProtoFile(DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder addProtoFile(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            object.add(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addProtoFileBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getProtoFileFieldBuilder();
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FileDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$FileDescriptorProto);
    }

    public DescriptorProtos$FileDescriptorProto$Builder addProtoFileBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getProtoFileFieldBuilder();
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FileDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$FileDescriptorProto);
    }

    public PluginProtos$CodeGeneratorRequest$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorRequest build() {
        Message message = this.buildPartial();
        boolean bl2 = ((PluginProtos$CodeGeneratorRequest)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public PluginProtos$CodeGeneratorRequest buildPartial() {
        LazyStringList lazyStringList;
        Object object = null;
        PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest = new PluginProtos$CodeGeneratorRequest(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        if (n11 != 0) {
            this.fileToGenerate_ = lazyStringList = this.fileToGenerate_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        }
        lazyStringList = this.fileToGenerate_;
        PluginProtos$CodeGeneratorRequest.access$1902(pluginProtos$CodeGeneratorRequest, lazyStringList);
        n11 = n10 & 2;
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            lazyStringList = null;
        }
        List list = this.parameter_;
        PluginProtos$CodeGeneratorRequest.access$2002(pluginProtos$CodeGeneratorRequest, list);
        list = this.protoFileBuilder_;
        if (list == null) {
            int n12 = this.bitField0_ & 4;
            if (n12 != 0) {
                this.protoFile_ = list = Collections.unmodifiableList(this.protoFile_);
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.protoFile_;
            PluginProtos$CodeGeneratorRequest.access$2102(pluginProtos$CodeGeneratorRequest, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            PluginProtos$CodeGeneratorRequest.access$2102(pluginProtos$CodeGeneratorRequest, list);
        }
        if ((n10 &= 8) != 0) {
            object = this.compilerVersionBuilder_;
            if (object == null) {
                object = this.compilerVersion_;
                PluginProtos$CodeGeneratorRequest.access$2202(pluginProtos$CodeGeneratorRequest, (PluginProtos$Version)object);
            } else {
                object = (PluginProtos$Version)((SingleFieldBuilderV3)object).build();
                PluginProtos$CodeGeneratorRequest.access$2202(pluginProtos$CodeGeneratorRequest, (PluginProtos$Version)object);
            }
            n11 |= 2;
        }
        PluginProtos$CodeGeneratorRequest.access$2302(pluginProtos$CodeGeneratorRequest, n11);
        this.onBuilt();
        return pluginProtos$CodeGeneratorRequest;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clear() {
        int n10;
        super.clear();
        Object object = LazyStringArrayList.EMPTY;
        this.fileToGenerate_ = object;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = "";
        this.parameter_ = string2;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        object = this.protoFileBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.protoFile_ = object;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        object = this.compilerVersionBuilder_;
        if (object == null) {
            n10 = 0;
            object = null;
            this.compilerVersion_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearCompilerVersion() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.compilerVersion_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearFileToGenerate() {
        int n10;
        LazyStringList lazyStringList;
        this.fileToGenerate_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearParameter() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = PluginProtos$CodeGeneratorRequest.getDefaultInstance().getParameter();
        this.parameter_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clearProtoFile() {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            int n10;
            this.protoFile_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder clone() {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.clone();
    }

    public PluginProtos$Version getCompilerVersion() {
        Object object = this.compilerVersionBuilder_;
        if (object == null) {
            object = this.compilerVersion_;
            if (object == null) {
                object = PluginProtos$Version.getDefaultInstance();
            }
            return object;
        }
        return (PluginProtos$Version)((SingleFieldBuilderV3)object).getMessage();
    }

    public PluginProtos$Version$Builder getCompilerVersionBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.onChanged();
        return (PluginProtos$Version$Builder)this.getCompilerVersionFieldBuilder().getBuilder();
    }

    public PluginProtos$VersionOrBuilder getCompilerVersionOrBuilder() {
        Object object = this.compilerVersionBuilder_;
        if (object != null) {
            return (PluginProtos$VersionOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.compilerVersion_;
        if (object == null) {
            object = PluginProtos$Version.getDefaultInstance();
        }
        return object;
    }

    public PluginProtos$CodeGeneratorRequest getDefaultInstanceForType() {
        return PluginProtos$CodeGeneratorRequest.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return PluginProtos.access$1300();
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
        return this.fileToGenerate_.getUnmodifiableView();
    }

    public String getParameter() {
        Object object = this.parameter_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.parameter_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public DescriptorProtos$FileDescriptorProto getProtoFile(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FileDescriptorProto)this.protoFile_.get(n10);
        }
        return (DescriptorProtos$FileDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$FileDescriptorProto$Builder getProtoFileBuilder(int n10) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getProtoFileFieldBuilder().getBuilder(n10);
    }

    public List getProtoFileBuilderList() {
        return this.getProtoFileFieldBuilder().getBuilderList();
    }

    public int getProtoFileCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.protoFile_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getProtoFileList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.protoFile_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.protoFile_.get(n10);
        }
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getProtoFileOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.protoFile_);
    }

    public boolean hasCompilerVersion() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasParameter() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$1400().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorRequest.class, PluginProtos$CodeGeneratorRequest$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getProtoFileCount()); ++i10) {
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.getProtoFile(i10);
            n10 = (int)(descriptorProtos$FileDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public PluginProtos$CodeGeneratorRequest$Builder mergeCompilerVersion(PluginProtos$Version message) {
        int n10;
        Object object = this.compilerVersionBuilder_;
        if (object == null) {
            PluginProtos$Version pluginProtos$Version;
            int n11 = this.bitField0_ & 8;
            if (n11 != 0 && (object = this.compilerVersion_) != null && object != (pluginProtos$Version = PluginProtos$Version.getDefaultInstance())) {
                object = PluginProtos$Version.newBuilder(this.compilerVersion_);
                this.compilerVersion_ = message = ((PluginProtos$Version$Builder)object).mergeFrom((PluginProtos$Version)message).buildPartial();
            } else {
                this.compilerVersion_ = message;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom((AbstractMessage)message);
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PluginProtos$CodeGeneratorRequest$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = PluginProtos$CodeGeneratorRequest.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (PluginProtos$CodeGeneratorRequest)object;
            if (object == null) break block7;
            this.mergeFrom((PluginProtos$CodeGeneratorRequest)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (PluginProtos$CodeGeneratorRequest)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((PluginProtos$CodeGeneratorRequest)object3);
        }
        throw var1_6;
    }

    public PluginProtos$CodeGeneratorRequest$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof PluginProtos$CodeGeneratorRequest;
        if (bl2) {
            message = (PluginProtos$CodeGeneratorRequest)message;
            return this.mergeFrom((PluginProtos$CodeGeneratorRequest)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder mergeFrom(PluginProtos$CodeGeneratorRequest messageLite) {
        List list;
        Object object = PluginProtos$CodeGeneratorRequest.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = PluginProtos$CodeGeneratorRequest.access$1900(messageLite);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            object = this.fileToGenerate_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.fileToGenerate_ = object = PluginProtos$CodeGeneratorRequest.access$1900(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensureFileToGenerateIsMutable();
                object = this.fileToGenerate_;
                list = PluginProtos$CodeGeneratorRequest.access$1900(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasParameter()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.parameter_ = object = PluginProtos$CodeGeneratorRequest.access$2000(messageLite);
            this.onChanged();
        }
        if ((object = this.protoFileBuilder_) == null) {
            object = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.protoFile_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.protoFile_ = object = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureProtoFileIsMutable();
                    object = this.protoFile_;
                    list = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.protoFileBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    this.protoFileBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.protoFileBuilder_ = null;
                    list = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
                    this.protoFile_ = list;
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFB;
                    n11 = (int)(PluginProtos$CodeGeneratorRequest.access$2400() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getProtoFileFieldBuilder();
                    }
                    this.protoFileBuilder_ = object;
                } else {
                    object = this.protoFileBuilder_;
                    list = PluginProtos$CodeGeneratorRequest.access$2100(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasCompilerVersion() ? 1 : 0)) != 0) {
            object = messageLite.getCompilerVersion();
            this.mergeCompilerVersion((PluginProtos$Version)object);
        }
        messageLite = PluginProtos$CodeGeneratorRequest.access$2500(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final PluginProtos$CodeGeneratorRequest$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public PluginProtos$CodeGeneratorRequest$Builder removeProtoFile(int n10) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setCompilerVersion(PluginProtos$Version$Builder messageOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            messageOrBuilder = messageOrBuilder.build();
            this.compilerVersion_ = messageOrBuilder;
            this.onChanged();
        } else {
            messageOrBuilder = messageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)messageOrBuilder);
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setCompilerVersion(PluginProtos$Version pluginProtos$Version) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(pluginProtos$Version);
            this.compilerVersion_ = pluginProtos$Version;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(pluginProtos$Version);
        }
        this.bitField0_ = n10 = this.bitField0_ | 8;
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorRequest$Builder setFileToGenerate(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureFileToGenerateIsMutable();
        this.fileToGenerate_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setParameter(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.parameter_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setParameterBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.parameter_ = byteString;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setProtoFile(int n10, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setProtoFile(int n10, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.protoFileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureProtoFileIsMutable();
            object = this.protoFile_;
            object.set(n10, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorRequest$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final PluginProtos$CodeGeneratorRequest$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorRequest$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

