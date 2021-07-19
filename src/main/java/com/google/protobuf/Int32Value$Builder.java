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
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;

public final class Int32Value$Builder
extends GeneratedMessageV3$Builder
implements Int32ValueOrBuilder {
    private int value_;

    private Int32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Int32Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Int32Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Int32Value$1 int32Value$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Int32Value$Builder(Int32Value$1 int32Value$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Int32Value$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Int32Value$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Int32Value build() {
        Int32Value int32Value = this.buildPartial();
        boolean bl2 = int32Value.isInitialized();
        if (bl2) {
            return int32Value;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(int32Value);
    }

    public Int32Value buildPartial() {
        Int32Value int32Value = new Int32Value(this, null);
        int n10 = this.value_;
        Int32Value.access$302(int32Value, n10);
        this.onBuilt();
        return int32Value;
    }

    public Int32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }

    public Int32Value$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Int32Value$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Int32Value$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Int32Value$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Int32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }

    public Int32Value$Builder clone() {
        return (Int32Value$Builder)super.clone();
    }

    public Int32Value getDefaultInstanceForType() {
        return Int32Value.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    public int getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
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
    public Int32Value$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Int32Value.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Int32Value)object;
            if (object == null) break block7;
            this.mergeFrom((Int32Value)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Int32Value)object2;
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
            this.mergeFrom((Int32Value)object3);
        }
        throw var1_6;
    }

    public Int32Value$Builder mergeFrom(Int32Value messageLite) {
        Int32Value int32Value = Int32Value.getDefaultInstance();
        if (messageLite == int32Value) {
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

    public Int32Value$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Int32Value;
        if (bl2) {
            message = (Int32Value)message;
            return this.mergeFrom((Int32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Int32Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Int32Value$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Int32Value$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Int32Value$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Int32Value$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Int32Value$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Int32Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Int32Value$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Int32Value$Builder setValue(int n10) {
        this.value_ = n10;
        this.onChanged();
        return this;
    }
}

