/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValueOrBuilder;
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

public final class DoubleValue$Builder
extends GeneratedMessageV3$Builder
implements DoubleValueOrBuilder {
    private double value_;

    private DoubleValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DoubleValue$Builder(DoubleValue$1 doubleValue$1) {
        this();
    }

    private DoubleValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ DoubleValue$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, DoubleValue$1 doubleValue$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public DoubleValue$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DoubleValue$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public DoubleValue build() {
        DoubleValue doubleValue = this.buildPartial();
        boolean bl2 = doubleValue.isInitialized();
        if (bl2) {
            return doubleValue;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(doubleValue);
    }

    public DoubleValue buildPartial() {
        DoubleValue doubleValue = new DoubleValue(this, null);
        double d10 = this.value_;
        DoubleValue.access$302(doubleValue, d10);
        this.onBuilt();
        return doubleValue;
    }

    public DoubleValue$Builder clear() {
        super.clear();
        this.value_ = 0.0;
        return this;
    }

    public DoubleValue$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (DoubleValue$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public DoubleValue$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (DoubleValue$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public DoubleValue$Builder clearValue() {
        this.value_ = 0.0;
        this.onChanged();
        return this;
    }

    public DoubleValue$Builder clone() {
        return (DoubleValue$Builder)super.clone();
    }

    public DoubleValue getDefaultInstanceForType() {
        return DoubleValue.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    public double getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
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
    public DoubleValue$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = DoubleValue.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (DoubleValue)object;
            if (object == null) break block7;
            this.mergeFrom((DoubleValue)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (DoubleValue)object2;
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
            this.mergeFrom((DoubleValue)object3);
        }
        throw var1_6;
    }

    public DoubleValue$Builder mergeFrom(DoubleValue messageLite) {
        double d10;
        DoubleValue doubleValue = DoubleValue.getDefaultInstance();
        if (messageLite == doubleValue) {
            return this;
        }
        double d11 = messageLite.getValue();
        double d12 = d11 - (d10 = 0.0);
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object != false) {
            d11 = messageLite.getValue();
            this.setValue(d11);
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public DoubleValue$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof DoubleValue;
        if (bl2) {
            message = (DoubleValue)message;
            return this.mergeFrom((DoubleValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final DoubleValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DoubleValue$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public DoubleValue$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (DoubleValue$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public DoubleValue$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (DoubleValue$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final DoubleValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (DoubleValue$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public DoubleValue$Builder setValue(double d10) {
        this.value_ = d10;
        this.onChanged();
        return this;
    }
}

