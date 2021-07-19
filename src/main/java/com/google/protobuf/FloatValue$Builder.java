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
import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValue$1;
import com.google.protobuf.FloatValueOrBuilder;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;

public final class FloatValue$Builder
extends GeneratedMessageV3$Builder
implements FloatValueOrBuilder {
    private float value_;

    private FloatValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ FloatValue$Builder(FloatValue$1 floatValue$1) {
        this();
    }

    private FloatValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ FloatValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, FloatValue$1 floatValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public FloatValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (FloatValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public FloatValue build() {
        FloatValue floatValue = this.buildPartial();
        boolean bl2 = floatValue.isInitialized();
        if (bl2) {
            return floatValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(floatValue);
    }

    public FloatValue buildPartial() {
        FloatValue floatValue = new FloatValue(this, null);
        float f10 = this.value_;
        FloatValue.access$302(floatValue, f10);
        this.onBuilt();
        return floatValue;
    }

    public FloatValue$Builder clear() {
        super.clear();
        this.value_ = 0.0f;
        return this;
    }

    public FloatValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (FloatValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public FloatValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (FloatValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public FloatValue$Builder clearValue() {
        this.value_ = 0.0f;
        this.onChanged();
        return this;
    }

    public FloatValue$Builder clone() {
        return (FloatValue$Builder)super.clone();
    }

    public FloatValue getDefaultInstanceForType() {
        return FloatValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    public float getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
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
    public FloatValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = FloatValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (FloatValue)object;
            if (object == null) break block7;
            this.mergeFrom((FloatValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (FloatValue)object2;
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
            this.mergeFrom((FloatValue)object3);
        }
        throw var1_6;
    }

    public FloatValue$Builder mergeFrom(FloatValue messageLite) {
        FloatValue floatValue = FloatValue.getDefaultInstance();
        if (messageLite == floatValue) {
            return this;
        }
        float f10 = messageLite.getValue();
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object != false) {
            f10 = messageLite.getValue();
            this.setValue(f10);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public FloatValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof FloatValue;
        if (bl2) {
            message = (FloatValue)message;
            return this.mergeFrom((FloatValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final FloatValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (FloatValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public FloatValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (FloatValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public FloatValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (FloatValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final FloatValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (FloatValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public FloatValue$Builder setValue(float f10) {
        this.value_ = f10;
        this.onChanged();
        return this;
    }
}

