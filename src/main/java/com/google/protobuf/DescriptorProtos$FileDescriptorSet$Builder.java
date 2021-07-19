/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DescriptorProtos$FileDescriptorSet$Builder
extends GeneratedMessageV3$Builder
implements DescriptorProtos$FileDescriptorSetOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 fileBuilder_;
    private List file_;

    private DescriptorProtos$FileDescriptorSet$Builder() {
        List list;
        this.file_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorSet$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    private DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.file_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureFileIsMutable() {
        int n10 = this.bitField0_ & 1;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.file_;
            this.file_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 1;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$000();
    }

    private RepeatedFieldBuilderV3 getFileFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.file_;
            int n10 = this.bitField0_;
            int n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.fileBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n11 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.file_ = null;
        }
        return this.fileBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = GeneratedMessageV3.alwaysUseFieldBuilders;
        if (bl2) {
            this.getFileFieldBuilder();
        }
    }

    public DescriptorProtos$FileDescriptorSet$Builder addAllFile(Iterable iterable) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(int n10, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.add(n10, descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(int n10, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureFileIsMutable();
            object = this.file_;
            object.add(n10, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.add(descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureFileIsMutable();
            object = this.file_;
            object.add(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFileFieldBuilder();
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FileDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(descriptorProtos$FileDescriptorProto);
    }

    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFileFieldBuilder();
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.getDefaultInstance();
        return (DescriptorProtos$FileDescriptorProto$Builder)repeatedFieldBuilderV3.addBuilder(n10, descriptorProtos$FileDescriptorProto);
    }

    public DescriptorProtos$FileDescriptorSet$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileDescriptorSet build() {
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = this.buildPartial();
        boolean bl2 = descriptorProtos$FileDescriptorSet.isInitialized();
        if (bl2) {
            return descriptorProtos$FileDescriptorSet;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(descriptorProtos$FileDescriptorSet);
    }

    public DescriptorProtos$FileDescriptorSet buildPartial() {
        List list = null;
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = new DescriptorProtos$FileDescriptorSet(this, null);
        int n10 = this.bitField0_;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            if ((n10 &= 1) != 0) {
                this.file_ = list = Collections.unmodifiableList(this.file_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.file_;
            DescriptorProtos$FileDescriptorSet.access$502(descriptorProtos$FileDescriptorSet, list);
        } else {
            list = repeatedFieldBuilderV3.build();
            DescriptorProtos$FileDescriptorSet.access$502(descriptorProtos$FileDescriptorSet, list);
        }
        this.onBuilt();
        return descriptorProtos$FileDescriptorSet;
    }

    public DescriptorProtos$FileDescriptorSet$Builder clear() {
        super.clear();
        Object object = this.fileBuilder_;
        if (object == null) {
            int n10;
            this.file_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DescriptorProtos$FileDescriptorSet$Builder clearFile() {
        Object object = this.fileBuilder_;
        if (object == null) {
            int n10;
            this.file_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DescriptorProtos$FileDescriptorSet$Builder clone() {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.clone();
    }

    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorSet.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$000();
    }

    public DescriptorProtos$FileDescriptorProto getFile(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FileDescriptorProto)this.file_.get(n10);
        }
        return (DescriptorProtos$FileDescriptorProto)repeatedFieldBuilderV3.getMessage(n10);
    }

    public DescriptorProtos$FileDescriptorProto$Builder getFileBuilder(int n10) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().getBuilder(n10);
    }

    public List getFileBuilderList() {
        return this.getFileFieldBuilder().getBuilderList();
    }

    public int getFileCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.file_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getFileList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.file_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(n10);
        }
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getFileOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.file_);
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getFileCount()); ++i10) {
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.getFile(i10);
            n10 = (int)(descriptorProtos$FileDescriptorProto.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DescriptorProtos$FileDescriptorSet.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DescriptorProtos$FileDescriptorSet)object;
            if (object == null) break block7;
            this.mergeFrom((DescriptorProtos$FileDescriptorSet)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DescriptorProtos$FileDescriptorSet)object2;
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
            this.mergeFrom((DescriptorProtos$FileDescriptorSet)object3);
        }
        throw var1_6;
    }

    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(DescriptorProtos$FileDescriptorSet messageLite) {
        Object object = DescriptorProtos$FileDescriptorSet.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.fileBuilder_;
        if (object == null) {
            object = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
            int n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.file_;
                n10 = object.isEmpty();
                if (n10 != 0) {
                    this.file_ = object = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureFileIsMutable();
                    object = this.file_;
                    List list = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                object = this.fileBuilder_;
                bl2 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl2) {
                    int n11;
                    List list;
                    this.fileBuilder_.dispose();
                    bl2 = false;
                    object = null;
                    this.fileBuilder_ = null;
                    this.file_ = list = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                    n11 = (int)(GeneratedMessageV3.alwaysUseFieldBuilders ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getFileFieldBuilder();
                    }
                    this.fileBuilder_ = object;
                } else {
                    object = this.fileBuilder_;
                    List list = DescriptorProtos$FileDescriptorSet.access$500(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DescriptorProtos$FileDescriptorSet;
        if (bl2) {
            message = (DescriptorProtos$FileDescriptorSet)message;
            return this.mergeFrom((DescriptorProtos$FileDescriptorSet)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DescriptorProtos$FileDescriptorSet$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DescriptorProtos$FileDescriptorSet$Builder removeFile(int n10) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DescriptorProtos$FileDescriptorSet$Builder setFile(int n10, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProtoOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            object.set(n10, descriptorProtos$FileDescriptorProtoOrBuilder);
            this.onChanged();
        } else {
            descriptorProtos$FileDescriptorProtoOrBuilder = ((DescriptorProtos$FileDescriptorProto$Builder)descriptorProtos$FileDescriptorProtoOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)descriptorProtos$FileDescriptorProtoOrBuilder));
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder setFile(int n10, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(descriptorProtos$FileDescriptorProto);
            this.ensureFileIsMutable();
            object = this.file_;
            object.set(n10, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DescriptorProtos$FileDescriptorSet$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DescriptorProtos$FileDescriptorSet$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

