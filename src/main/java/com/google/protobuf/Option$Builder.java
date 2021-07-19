/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.Option;
import com.google.protobuf.Option$1;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Option$Builder
extends GeneratedMessageV3$Builder
implements OptionOrBuilder {
    private Object name_ = "";
    private SingleFieldBuilderV3 valueBuilder_;
    private Any value_;

    private Option$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Option$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Option$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Option$1 option$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Option$Builder(Option$1 option$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    private SingleFieldBuilderV3 getValueFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.valueBuilder_;
        if (singleFieldBuilderV3 == null) {
            Any any = this.getValue();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.valueBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(any, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.value_ = null;
        }
        return this.valueBuilder_;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Option$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Option$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Option build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Option)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Option buildPartial() {
        Option option = new Option(this, null);
        Object object = this.name_;
        Option.access$302(option, object);
        object = this.valueBuilder_;
        if (object == null) {
            object = this.value_;
            Option.access$402(option, (Any)object);
        } else {
            object = (Any)((SingleFieldBuilderV3)object).build();
            Option.access$402(option, (Any)object);
        }
        this.onBuilt();
        return option;
    }

    public Option$Builder clear() {
        super.clear();
        this.name_ = "";
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.valueBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.value_ = null;
        } else {
            this.value_ = null;
            this.valueBuilder_ = null;
        }
        return this;
    }

    public Option$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Option$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Option$Builder clearName() {
        String string2 = Option.getDefaultInstance().getName();
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Option$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Option$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Option$Builder clearValue() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.valueBuilder_;
        if (singleFieldBuilderV3 == null) {
            this.value_ = null;
            this.onChanged();
        } else {
            this.value_ = null;
            this.valueBuilder_ = null;
        }
        return this;
    }

    public Option$Builder clone() {
        return (Option$Builder)super.clone();
    }

    public Option getDefaultInstanceForType() {
        return Option.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
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

    public Any getValue() {
        Object object = this.valueBuilder_;
        if (object == null) {
            object = this.value_;
            if (object == null) {
                object = Any.getDefaultInstance();
            }
            return object;
        }
        return (Any)((SingleFieldBuilderV3)object).getMessage();
    }

    public Any$Builder getValueBuilder() {
        this.onChanged();
        return (Any$Builder)this.getValueFieldBuilder().getBuilder();
    }

    public AnyOrBuilder getValueOrBuilder() {
        Object object = this.valueBuilder_;
        if (object != null) {
            return (AnyOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.value_;
        if (object == null) {
            object = Any.getDefaultInstance();
        }
        return object;
    }

    public boolean hasValue() {
        boolean bl2;
        Object object = this.valueBuilder_;
        if (object == null && (object = this.value_) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
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
    public Option$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Option.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Option)object;
            if (object == null) break block7;
            this.mergeFrom((Option)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Option)object2;
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
            this.mergeFrom((Option)object3);
        }
        throw var1_6;
    }

    public Option$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Option;
        if (bl2) {
            message = (Option)message;
            return this.mergeFrom((Option)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Option$Builder mergeFrom(Option messageLite) {
        Object object = Option.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = messageLite.getName();
        boolean bl2 = ((String)object).isEmpty();
        if (!bl2) {
            this.name_ = object = Option.access$300(messageLite);
            this.onChanged();
        }
        if (bl2 = messageLite.hasValue()) {
            object = messageLite.getValue();
            this.mergeValue((Any)object);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final Option$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Option$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Option$Builder mergeValue(Any any) {
        Object object = this.valueBuilder_;
        if (object == null) {
            object = this.value_;
            if (object != null) {
                object = Any.newBuilder((Any)object);
                this.value_ = any = ((Any$Builder)object).mergeFrom(any).buildPartial();
            } else {
                this.value_ = any;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(any);
        }
        return this;
    }

    public Option$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Option$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Option$Builder setName(String string2) {
        Objects.requireNonNull(string2);
        this.name_ = string2;
        this.onChanged();
        return this;
    }

    public Option$Builder setNameBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    public Option$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Option$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Option$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Option$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Option$Builder setValue(Any$Builder anyOrBuilder) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.valueBuilder_;
        if (singleFieldBuilderV3 == null) {
            anyOrBuilder = anyOrBuilder.build();
            this.value_ = anyOrBuilder;
            this.onChanged();
        } else {
            anyOrBuilder = anyOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)anyOrBuilder));
        }
        return this;
    }

    public Option$Builder setValue(Any any) {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.valueBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(any);
            this.value_ = any;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(any);
        }
        return this;
    }
}

