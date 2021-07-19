/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ApiProto;
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
import com.google.protobuf.Mixin;
import com.google.protobuf.Mixin$1;
import com.google.protobuf.MixinOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Mixin$Builder
extends GeneratedMessageV3$Builder
implements MixinOrBuilder {
    private Object name_;
    private Object root_;

    private Mixin$Builder() {
        String string2 = "";
        this.name_ = string2;
        this.root_ = string2;
        this.maybeForceBuilderInitialization();
    }

    private Mixin$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.name_ = object = "";
        this.root_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Mixin$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Mixin$1 mixin$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Mixin$Builder(Mixin$1 mixin$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Mixin$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Mixin$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Mixin build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Mixin)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Mixin buildPartial() {
        Mixin mixin = new Mixin(this, null);
        Object object = this.name_;
        Mixin.access$302(mixin, object);
        object = this.root_;
        Mixin.access$402(mixin, object);
        this.onBuilt();
        return mixin;
    }

    public Mixin$Builder clear() {
        super.clear();
        String string2 = "";
        this.name_ = string2;
        this.root_ = string2;
        return this;
    }

    public Mixin$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Mixin$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Mixin$Builder clearName() {
        String string2 = Mixin.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Mixin$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Mixin$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Mixin$Builder clearRoot() {
        String string2 = Mixin.getDefaultInstance().getRoot();
        this.root_ = string2;
        this.onChanged();
        return this;
    }

    public Mixin$Builder clone() {
        return (Mixin$Builder)super.clone();
    }

    public Mixin getDefaultInstanceForType() {
        return Mixin.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Mixin_descriptor;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.name_ = object = ((ByteString)object).toStringUtf8();
            return object;
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

    public String getRoot() {
        Object object = this.root_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.root_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getRootBytes() {
        Object object = this.root_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.root_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(Mixin.class, Mixin$Builder.class);
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
    public Mixin$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Mixin.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Mixin)object;
            if (object == null) break block7;
            this.mergeFrom((Mixin)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Mixin)object2;
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
            this.mergeFrom((Mixin)object3);
        }
        throw var1_6;
    }

    public Mixin$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Mixin;
        if (bl2) {
            message = (Mixin)message;
            return this.mergeFrom((Mixin)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Mixin$Builder mergeFrom(Mixin messageLite) {
        Object object = Mixin.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = messageLite.getName();
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.name_ = object = Mixin.access$300(messageLite);
            this.onChanged();
        }
        if (!(bl2 = ((String)(object = messageLite.getRoot())).isEmpty())) {
            this.root_ = object = Mixin.access$400(messageLite);
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final Mixin$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Mixin$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Mixin$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Mixin$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Mixin$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Mixin$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Mixin$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Mixin$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Mixin$Builder setRoot(String string2) {
        Objects.requireNonNull(string2);
        this.root_ = string2;
        this.onChanged();
        return this;
    }

    public Mixin$Builder setRootBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.root_ = byteString;
        this.onChanged();
        return this;
    }

    public final Mixin$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Mixin$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

