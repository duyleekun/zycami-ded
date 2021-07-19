/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$FileOrBuilder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponseOrBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorResponse$Builder
extends GeneratedMessageV3$Builder
implements PluginProtos$CodeGeneratorResponseOrBuilder {
    private int bitField0_;
    private Object error_ = "";
    private RepeatedFieldBuilderV3 fileBuilder_;
    private List file_;

    private PluginProtos$CodeGeneratorResponse$Builder() {
        List list;
        this.file_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    private PluginProtos$CodeGeneratorResponse$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.file_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$Builder(PluginProtos$1 pluginProtos$1) {
        this();
    }

    private void ensureFileIsMutable() {
        int n10 = this.bitField0_ & 2;
        if (n10 == 0) {
            ArrayList arrayList;
            List list = this.file_;
            this.file_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | 2;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$2700();
    }

    private RepeatedFieldBuilderV3 getFileFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.file_;
            int n10 = this.bitField0_ & 2;
            n10 = n10 != 0 ? 1 : 0;
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.fileBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl2);
            repeatedFieldBuilderV3 = null;
            this.file_ = null;
        }
        return this.fileBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = PluginProtos$CodeGeneratorResponse.access$4300();
        if (bl2) {
            this.getFileFieldBuilder();
        }
    }

    public PluginProtos$CodeGeneratorResponse$Builder addAllFile(Iterable iterable) {
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

    public PluginProtos$CodeGeneratorResponse$Builder addFile(int n10, PluginProtos$CodeGeneratorResponse$File$Builder messageOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            object.add(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder addFile(int n10, PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(pluginProtos$CodeGeneratorResponse$File);
            this.ensureFileIsMutable();
            object = this.file_;
            object.add(n10, pluginProtos$CodeGeneratorResponse$File);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, pluginProtos$CodeGeneratorResponse$File);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder addFile(PluginProtos$CodeGeneratorResponse$File$Builder messageOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            object.add(messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder addFile(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(pluginProtos$CodeGeneratorResponse$File);
            this.ensureFileIsMutable();
            object = this.file_;
            object.add(pluginProtos$CodeGeneratorResponse$File);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(pluginProtos$CodeGeneratorResponse$File);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder addFileBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFileFieldBuilder();
        PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance();
        return (PluginProtos$CodeGeneratorResponse$File$Builder)repeatedFieldBuilderV3.addBuilder(pluginProtos$CodeGeneratorResponse$File);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder addFileBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFileFieldBuilder();
        PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance();
        return (PluginProtos$CodeGeneratorResponse$File$Builder)repeatedFieldBuilderV3.addBuilder(n10, pluginProtos$CodeGeneratorResponse$File);
    }

    public PluginProtos$CodeGeneratorResponse$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorResponse build() {
        Message message = this.buildPartial();
        boolean bl2 = ((PluginProtos$CodeGeneratorResponse)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public PluginProtos$CodeGeneratorResponse buildPartial() {
        List list = null;
        PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse = new PluginProtos$CodeGeneratorResponse(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        list = this.error_;
        PluginProtos$CodeGeneratorResponse.access$4502(pluginProtos$CodeGeneratorResponse, list);
        list = this.fileBuilder_;
        if (list == null) {
            n10 = this.bitField0_ & 2;
            if (n10 != 0) {
                this.file_ = list = Collections.unmodifiableList(this.file_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.file_;
            PluginProtos$CodeGeneratorResponse.access$4602(pluginProtos$CodeGeneratorResponse, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            PluginProtos$CodeGeneratorResponse.access$4602(pluginProtos$CodeGeneratorResponse, list);
        }
        PluginProtos$CodeGeneratorResponse.access$4702(pluginProtos$CodeGeneratorResponse, n11);
        this.onBuilt();
        return pluginProtos$CodeGeneratorResponse;
    }

    public PluginProtos$CodeGeneratorResponse$Builder clear() {
        int n10;
        super.clear();
        this.error_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        Object object = this.fileBuilder_;
        if (object == null) {
            this.file_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder clearError() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = PluginProtos$CodeGeneratorResponse.getDefaultInstance().getError();
        this.error_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public PluginProtos$CodeGeneratorResponse$Builder clearFile() {
        Object object = this.fileBuilder_;
        if (object == null) {
            int n10;
            this.file_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public PluginProtos$CodeGeneratorResponse$Builder clone() {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.clone();
    }

    public PluginProtos$CodeGeneratorResponse getDefaultInstanceForType() {
        return PluginProtos$CodeGeneratorResponse.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return PluginProtos.access$2700();
    }

    public String getError() {
        Object object = this.error_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.error_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getErrorBytes() {
        Object object = this.error_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.error_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public PluginProtos$CodeGeneratorResponse$File getFile(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (PluginProtos$CodeGeneratorResponse$File)this.file_.get(n10);
        }
        return (PluginProtos$CodeGeneratorResponse$File)repeatedFieldBuilderV3.getMessage(n10);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder getFileBuilder(int n10) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)this.getFileFieldBuilder().getBuilder(n10);
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

    public PluginProtos$CodeGeneratorResponse$FileOrBuilder getFileOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (PluginProtos$CodeGeneratorResponse$FileOrBuilder)this.file_.get(n10);
        }
        return (PluginProtos$CodeGeneratorResponse$FileOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getFileOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.file_);
    }

    public boolean hasError() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$2800().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorResponse.class, PluginProtos$CodeGeneratorResponse$Builder.class);
    }

    public final boolean isInitialized() {
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
    public PluginProtos$CodeGeneratorResponse$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = PluginProtos$CodeGeneratorResponse.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (PluginProtos$CodeGeneratorResponse)object;
            if (object == null) break block7;
            this.mergeFrom((PluginProtos$CodeGeneratorResponse)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (PluginProtos$CodeGeneratorResponse)object2;
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
            this.mergeFrom((PluginProtos$CodeGeneratorResponse)object3);
        }
        throw var1_6;
    }

    public PluginProtos$CodeGeneratorResponse$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof PluginProtos$CodeGeneratorResponse;
        if (bl2) {
            message = (PluginProtos$CodeGeneratorResponse)message;
            return this.mergeFrom((PluginProtos$CodeGeneratorResponse)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder mergeFrom(PluginProtos$CodeGeneratorResponse messageLite) {
        Object object = PluginProtos$CodeGeneratorResponse.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasError();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.error_ = object = PluginProtos$CodeGeneratorResponse.access$4500(messageLite);
            this.onChanged();
        }
        if ((object = this.fileBuilder_) == null) {
            object = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.file_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.file_ = object = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureFileIsMutable();
                    object = this.file_;
                    List list = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.fileBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    List list;
                    this.fileBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.fileBuilder_ = null;
                    this.file_ = list = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
                    n11 = (int)(PluginProtos$CodeGeneratorResponse.access$4800() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getFileFieldBuilder();
                    }
                    this.fileBuilder_ = object;
                } else {
                    object = this.fileBuilder_;
                    List list = PluginProtos$CodeGeneratorResponse.access$4600(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = PluginProtos$CodeGeneratorResponse.access$4900(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final PluginProtos$CodeGeneratorResponse$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public PluginProtos$CodeGeneratorResponse$Builder removeFile(int n10) {
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

    public PluginProtos$CodeGeneratorResponse$Builder setError(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.error_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder setErrorBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.error_ = byteString;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorResponse$Builder setFile(int n10, PluginProtos$CodeGeneratorResponse$File$Builder messageOrBuilder) {
        Object object = this.fileBuilder_;
        if (object == null) {
            this.ensureFileIsMutable();
            object = this.file_;
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            object.set(n10, messageOrBuilder);
            this.onChanged();
        } else {
            messageOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)messageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)messageOrBuilder);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder setFile(int n10, PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        Object object = this.fileBuilder_;
        if (object == null) {
            Objects.requireNonNull(pluginProtos$CodeGeneratorResponse$File);
            this.ensureFileIsMutable();
            object = this.file_;
            object.set(n10, pluginProtos$CodeGeneratorResponse$File);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, pluginProtos$CodeGeneratorResponse$File);
        }
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final PluginProtos$CodeGeneratorResponse$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorResponse$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

