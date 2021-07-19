/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.Any$1;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import java.io.IOException;
import java.util.Objects;

public final class Any$Builder
extends GeneratedMessageV3$Builder
implements AnyOrBuilder {
    private Object typeUrl_ = "";
    private ByteString value_;

    private Any$Builder() {
        ByteString byteString;
        this.value_ = byteString = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Any$Builder(Any$1 any$1) {
        this();
    }

    private Any$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.value_ = object = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Any$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Any$1 any$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Any$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Any$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Any build() {
        Any any = this.buildPartial();
        boolean bl2 = any.isInitialized();
        if (bl2) {
            return any;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(any);
    }

    public Any buildPartial() {
        Any any = new Any(this, null);
        Object object = this.typeUrl_;
        Any.access$302(any, object);
        object = this.value_;
        Any.access$402(any, (ByteString)object);
        this.onBuilt();
        return any;
    }

    public Any$Builder clear() {
        ByteString byteString;
        super.clear();
        this.typeUrl_ = "";
        this.value_ = byteString = ByteString.EMPTY;
        return this;
    }

    public Any$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Any$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Any$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Any$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Any$Builder clearTypeUrl() {
        String string2 = Any.getDefaultInstance().getTypeUrl();
        this.typeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Any$Builder clearValue() {
        ByteString byteString;
        this.value_ = byteString = Any.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }

    public Any$Builder clone() {
        return (Any$Builder)super.clone();
    }

    public Any getDefaultInstanceForType() {
        return Any.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    public String getTypeUrl() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.typeUrl_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getTypeUrlBytes() {
        Object object = this.typeUrl_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.typeUrl_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public ByteString getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Any$Builder mergeFrom(Any messageLite) {
        ByteString byteString;
        Object object = Any.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = messageLite.getTypeUrl();
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.typeUrl_ = object = Any.access$300(messageLite);
            this.onChanged();
        }
        if ((object = messageLite.getValue()) != (byteString = ByteString.EMPTY)) {
            object = messageLite.getValue();
            this.setValue((ByteString)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
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
    public Any$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Any.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Any)object;
            if (object == null) break block7;
            this.mergeFrom((Any)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Any)object2;
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
            this.mergeFrom((Any)object3);
        }
        throw var1_6;
    }

    public Any$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Any;
        if (bl2) {
            message = (Any)message;
            return this.mergeFrom((Any)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Any$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Any$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Any$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Any$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Any$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Any$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Any$Builder setTypeUrl(String string2) {
        Objects.requireNonNull(string2);
        this.typeUrl_ = string2;
        this.onChanged();
        return this;
    }

    public Any$Builder setTypeUrlBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.typeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    public final Any$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Any$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Any$Builder setValue(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.value_ = byteString;
        this.onChanged();
        return this;
    }
}

