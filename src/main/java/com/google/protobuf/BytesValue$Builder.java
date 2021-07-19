/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValueOrBuilder;
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
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public final class BytesValue$Builder
extends GeneratedMessageV3$Builder
implements BytesValueOrBuilder {
    private ByteString value_;

    private BytesValue$Builder() {
        ByteString byteString;
        this.value_ = byteString = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ BytesValue$Builder(BytesValue$1 bytesValue$1) {
        this();
    }

    private BytesValue$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.value_ = object = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ BytesValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, BytesValue$1 bytesValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public BytesValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (BytesValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public BytesValue build() {
        BytesValue bytesValue = this.buildPartial();
        boolean bl2 = bytesValue.isInitialized();
        if (bl2) {
            return bytesValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(bytesValue);
    }

    public BytesValue buildPartial() {
        BytesValue bytesValue = new BytesValue(this, null);
        ByteString byteString = this.value_;
        BytesValue.access$302(bytesValue, byteString);
        this.onBuilt();
        return bytesValue;
    }

    public BytesValue$Builder clear() {
        ByteString byteString;
        super.clear();
        this.value_ = byteString = ByteString.EMPTY;
        return this;
    }

    public BytesValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (BytesValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public BytesValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (BytesValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public BytesValue$Builder clearValue() {
        ByteString byteString;
        this.value_ = byteString = BytesValue.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }

    public BytesValue$Builder clone() {
        return (BytesValue$Builder)super.clone();
    }

    public BytesValue getDefaultInstanceForType() {
        return BytesValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    public ByteString getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public BytesValue$Builder mergeFrom(BytesValue messageLite) {
        ByteString byteString;
        Serializable serializable = BytesValue.getDefaultInstance();
        if (messageLite == serializable) {
            return this;
        }
        serializable = messageLite.getValue();
        if (serializable != (byteString = ByteString.EMPTY)) {
            serializable = messageLite.getValue();
            this.setValue((ByteString)serializable);
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
    public BytesValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = BytesValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (BytesValue)object;
            if (object == null) break block7;
            this.mergeFrom((BytesValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (BytesValue)object2;
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
            this.mergeFrom((BytesValue)object3);
        }
        throw var1_6;
    }

    public BytesValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof BytesValue;
        if (bl2) {
            message = (BytesValue)message;
            return this.mergeFrom((BytesValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final BytesValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (BytesValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public BytesValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (BytesValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public BytesValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (BytesValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final BytesValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (BytesValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public BytesValue$Builder setValue(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.value_ = byteString;
        this.onChanged();
        return this;
    }
}

