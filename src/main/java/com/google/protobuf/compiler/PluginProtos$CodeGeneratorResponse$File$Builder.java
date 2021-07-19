/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$FileOrBuilder;
import java.io.IOException;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorResponse$File$Builder
extends GeneratedMessageV3$Builder
implements PluginProtos$CodeGeneratorResponse$FileOrBuilder {
    private int bitField0_;
    private Object content_;
    private Object insertionPoint_;
    private Object name_;

    private PluginProtos$CodeGeneratorResponse$File$Builder() {
        String string2 = "";
        this.name_ = string2;
        this.insertionPoint_ = string2;
        this.content_ = string2;
        this.maybeForceBuilderInitialization();
    }

    private PluginProtos$CodeGeneratorResponse$File$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.name_ = object = "";
        this.insertionPoint_ = object;
        this.content_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$File$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$File$Builder(PluginProtos$1 pluginProtos$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$2900();
    }

    private void maybeForceBuilderInitialization() {
        PluginProtos$CodeGeneratorResponse$File.access$3300();
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorResponse$File build() {
        Message message = this.buildPartial();
        boolean bl2 = ((PluginProtos$CodeGeneratorResponse$File)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public PluginProtos$CodeGeneratorResponse$File buildPartial() {
        Object object = null;
        PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File = new PluginProtos$CodeGeneratorResponse$File(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        n11 = n11 != 0 ? 1 : 0;
        Object object2 = this.name_;
        PluginProtos$CodeGeneratorResponse$File.access$3502(pluginProtos$CodeGeneratorResponse$File, object2);
        int n12 = n10 & 2;
        if (n12 != 0) {
            n11 |= 2;
        }
        object2 = this.insertionPoint_;
        PluginProtos$CodeGeneratorResponse$File.access$3602(pluginProtos$CodeGeneratorResponse$File, object2);
        if ((n10 &= 4) != 0) {
            n11 |= 4;
        }
        object = this.content_;
        PluginProtos$CodeGeneratorResponse$File.access$3702(pluginProtos$CodeGeneratorResponse$File, object);
        PluginProtos$CodeGeneratorResponse$File.access$3802(pluginProtos$CodeGeneratorResponse$File, n11);
        this.onBuilt();
        return pluginProtos$CodeGeneratorResponse$File;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clear() {
        int n10;
        int n11;
        super.clear();
        String string2 = "";
        this.name_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.insertionPoint_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.content_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFFB;
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clearContent() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance().getContent();
        this.content_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clearInsertionPoint() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance().getInsertionPoint();
        this.insertionPoint_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clearName() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder clone() {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.clone();
    }

    public String getContent() {
        Object object = this.content_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.content_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getContentBytes() {
        Object object = this.content_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.content_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public PluginProtos$CodeGeneratorResponse$File getDefaultInstanceForType() {
        return PluginProtos$CodeGeneratorResponse$File.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return PluginProtos.access$2900();
    }

    public String getInsertionPoint() {
        Object object = this.insertionPoint_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.insertionPoint_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getInsertionPointBytes() {
        Object object = this.insertionPoint_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.insertionPoint_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.name_ = string2;
            }
            return string2;
        }
        return (String)object;
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

    public boolean hasContent() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasInsertionPoint() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$3000().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorResponse$File.class, PluginProtos$CodeGeneratorResponse$File$Builder.class);
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
    public PluginProtos$CodeGeneratorResponse$File$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = PluginProtos$CodeGeneratorResponse$File.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (PluginProtos$CodeGeneratorResponse$File)object;
            if (object == null) break block7;
            this.mergeFrom((PluginProtos$CodeGeneratorResponse$File)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (PluginProtos$CodeGeneratorResponse$File)object2;
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
            this.mergeFrom((PluginProtos$CodeGeneratorResponse$File)object3);
        }
        throw var1_6;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof PluginProtos$CodeGeneratorResponse$File;
        if (bl2) {
            message = (PluginProtos$CodeGeneratorResponse$File)message;
            return this.mergeFrom((PluginProtos$CodeGeneratorResponse$File)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder mergeFrom(PluginProtos$CodeGeneratorResponse$File messageLite) {
        Object object = PluginProtos$CodeGeneratorResponse$File.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasName();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.name_ = object = PluginProtos$CodeGeneratorResponse$File.access$3500(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasInsertionPoint()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.insertionPoint_ = object = PluginProtos$CodeGeneratorResponse$File.access$3600(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasContent() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.content_ = object = PluginProtos$CodeGeneratorResponse$File.access$3700(messageLite);
            this.onChanged();
        }
        messageLite = PluginProtos$CodeGeneratorResponse$File.access$3900(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final PluginProtos$CodeGeneratorResponse$File$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setContent(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.content_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setContentBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.content_ = byteString;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setInsertionPoint(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.insertionPoint_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setInsertionPointBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.insertionPoint_ = byteString;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setName(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setNameBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final PluginProtos$CodeGeneratorResponse$File$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (PluginProtos$CodeGeneratorResponse$File$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

