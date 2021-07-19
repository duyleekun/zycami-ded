/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
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
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32Value$1;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;

public final class UInt32Value$Builder
extends GeneratedMessageV3$Builder
implements UInt32ValueOrBuilder {
    private int value_;

    private UInt32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private UInt32Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ UInt32Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, UInt32Value$1 uInt32Value$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ UInt32Value$Builder(UInt32Value$1 uInt32Value$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public UInt32Value$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (UInt32Value$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public UInt32Value build() {
        Message message = this.buildPartial();
        boolean bl2 = ((UInt32Value)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public UInt32Value buildPartial() {
        UInt32Value uInt32Value = new UInt32Value(this, null);
        int n10 = this.value_;
        UInt32Value.access$302(uInt32Value, n10);
        this.onBuilt();
        return uInt32Value;
    }

    public UInt32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    public UInt32Value$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (UInt32Value$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public UInt32Value$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (UInt32Value$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public UInt32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    public UInt32Value$Builder clone() {
        return (UInt32Value$Builder)super.clone();
    }

    public UInt32Value getDefaultInstanceForType() {
        return UInt32Value.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }

    public int getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
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
    public UInt32Value$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = UInt32Value.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (UInt32Value)object;
            if (object == null) break block7;
            this.mergeFrom((UInt32Value)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (UInt32Value)object2;
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
            this.mergeFrom((UInt32Value)object3);
        }
        throw var1_6;
    }

    public UInt32Value$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof UInt32Value;
        if (bl2) {
            message = (UInt32Value)message;
            return this.mergeFrom((UInt32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public UInt32Value$Builder mergeFrom(UInt32Value messageLite) {
        UInt32Value uInt32Value = UInt32Value.getDefaultInstance();
        if (messageLite == uInt32Value) {
            return this;
        }
        int n10 = messageLite.getValue();
        if (n10 != 0) {
            n10 = messageLite.getValue();
            this.setValue(n10);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final UInt32Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (UInt32Value$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public UInt32Value$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (UInt32Value$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public UInt32Value$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (UInt32Value$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final UInt32Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (UInt32Value$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public UInt32Value$Builder setValue(int n10) {
        this.value_ = n10;
        this.onChanged();
        return this;
    }
}

