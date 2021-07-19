/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.StringValue;
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.util.Objects;

public final class StringValue$Builder
extends GeneratedMessageV3$Builder
implements StringValueOrBuilder {
    private Object value_ = "";

    private StringValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private StringValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ StringValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, StringValue$1 stringValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ StringValue$Builder(StringValue$1 stringValue$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public StringValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (StringValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public StringValue build() {
        Message message = this.buildPartial();
        boolean bl2 = ((StringValue)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public StringValue buildPartial() {
        StringValue stringValue = new StringValue(this, null);
        Object object = this.value_;
        StringValue.access$302(stringValue, object);
        this.onBuilt();
        return stringValue;
    }

    public StringValue$Builder clear() {
        super.clear();
        this.value_ = "";
        return this;
    }

    public StringValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (StringValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public StringValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (StringValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public StringValue$Builder clearValue() {
        String string2 = StringValue.getDefaultInstance().getValue();
        this.value_ = string2;
        this.onChanged();
        return this;
    }

    public StringValue$Builder clone() {
        return (StringValue$Builder)super.clone();
    }

    public StringValue getDefaultInstanceForType() {
        return StringValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    public String getValue() {
        Object object = this.value_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            this.value_ = object = ((ByteString)object).toStringUtf8();
            return object;
        }
        return (String)object;
    }

    public ByteString getValueBytes() {
        Object object = this.value_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.value_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
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
    public StringValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = StringValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (StringValue)object;
            if (object == null) break block7;
            this.mergeFrom((StringValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (StringValue)object2;
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
            this.mergeFrom((StringValue)object3);
        }
        throw var1_6;
    }

    public StringValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof StringValue;
        if (bl2) {
            message = (StringValue)message;
            return this.mergeFrom((StringValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public StringValue$Builder mergeFrom(StringValue messageLite) {
        Object object = StringValue.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = messageLite.getValue();
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.value_ = object = StringValue.access$300(messageLite);
            this.onChanged();
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final StringValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (StringValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public StringValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (StringValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public StringValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (StringValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final StringValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (StringValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public StringValue$Builder setValue(String string2) {
        Objects.requireNonNull(string2);
        this.value_ = string2;
        this.onChanged();
        return this;
    }

    public StringValue$Builder setValueBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.value_ = byteString;
        this.onChanged();
        return this;
    }
}

