/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValueOrBuilder;
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

public final class BoolValue$Builder
extends GeneratedMessageV3$Builder
implements BoolValueOrBuilder {
    private boolean value_;

    private BoolValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ BoolValue$Builder(BoolValue$1 boolValue$1) {
        this();
    }

    private BoolValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ BoolValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, BoolValue$1 boolValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public BoolValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (BoolValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public BoolValue build() {
        BoolValue boolValue = this.buildPartial();
        boolean bl2 = boolValue.isInitialized();
        if (bl2) {
            return boolValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(boolValue);
    }

    public BoolValue buildPartial() {
        BoolValue boolValue = new BoolValue(this, null);
        boolean bl2 = this.value_;
        BoolValue.access$302(boolValue, bl2);
        this.onBuilt();
        return boolValue;
    }

    public BoolValue$Builder clear() {
        super.clear();
        this.value_ = false;
        return this;
    }

    public BoolValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (BoolValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public BoolValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (BoolValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public BoolValue$Builder clearValue() {
        this.value_ = false;
        this.onChanged();
        return this;
    }

    public BoolValue$Builder clone() {
        return (BoolValue$Builder)super.clone();
    }

    public BoolValue getDefaultInstanceForType() {
        return BoolValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    public boolean getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public BoolValue$Builder mergeFrom(BoolValue messageLite) {
        BoolValue boolValue = BoolValue.getDefaultInstance();
        if (messageLite == boolValue) {
            return this;
        }
        boolean bl2 = messageLite.getValue();
        if (bl2) {
            bl2 = messageLite.getValue();
            this.setValue(bl2);
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
    public BoolValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = BoolValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (BoolValue)object;
            if (object == null) break block7;
            this.mergeFrom((BoolValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (BoolValue)object2;
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
            this.mergeFrom((BoolValue)object3);
        }
        throw var1_6;
    }

    public BoolValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof BoolValue;
        if (bl2) {
            message = (BoolValue)message;
            return this.mergeFrom((BoolValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final BoolValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (BoolValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public BoolValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (BoolValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public BoolValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (BoolValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final BoolValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (BoolValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public BoolValue$Builder setValue(boolean bl2) {
        this.value_ = bl2;
        this.onChanged();
        return this;
    }
}

