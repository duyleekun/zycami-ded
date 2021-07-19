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
import com.google.protobuf.UInt64Value;
import com.google.protobuf.UInt64Value$1;
import com.google.protobuf.UInt64ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;

public final class UInt64Value$Builder
extends GeneratedMessageV3$Builder
implements UInt64ValueOrBuilder {
    private long value_;

    private UInt64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private UInt64Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ UInt64Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, UInt64Value$1 uInt64Value$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ UInt64Value$Builder(UInt64Value$1 uInt64Value$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public UInt64Value$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (UInt64Value$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public UInt64Value build() {
        Message message = this.buildPartial();
        boolean bl2 = ((UInt64Value)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public UInt64Value buildPartial() {
        UInt64Value uInt64Value = new UInt64Value(this, null);
        long l10 = this.value_;
        UInt64Value.access$302(uInt64Value, l10);
        this.onBuilt();
        return uInt64Value;
    }

    public UInt64Value$Builder clear() {
        super.clear();
        this.value_ = 0L;
        return this;
    }

    public UInt64Value$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (UInt64Value$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public UInt64Value$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (UInt64Value$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public UInt64Value$Builder clearValue() {
        this.value_ = 0L;
        this.onChanged();
        return this;
    }

    public UInt64Value$Builder clone() {
        return (UInt64Value$Builder)super.clone();
    }

    public UInt64Value getDefaultInstanceForType() {
        return UInt64Value.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    public long getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
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
    public UInt64Value$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = UInt64Value.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (UInt64Value)object;
            if (object == null) break block7;
            this.mergeFrom((UInt64Value)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (UInt64Value)object2;
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
            this.mergeFrom((UInt64Value)object3);
        }
        throw var1_6;
    }

    public UInt64Value$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof UInt64Value;
        if (bl2) {
            message = (UInt64Value)message;
            return this.mergeFrom((UInt64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public UInt64Value$Builder mergeFrom(UInt64Value messageLite) {
        long l10;
        UInt64Value uInt64Value = UInt64Value.getDefaultInstance();
        if (messageLite == uInt64Value) {
            return this;
        }
        long l11 = messageLite.getValue();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = messageLite.getValue();
            this.setValue(l11);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final UInt64Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (UInt64Value$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public UInt64Value$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (UInt64Value$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public UInt64Value$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (UInt64Value$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final UInt64Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (UInt64Value$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public UInt64Value$Builder setValue(long l10) {
        this.value_ = l10;
        this.onChanged();
        return this;
    }
}

