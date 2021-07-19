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
import com.google.protobuf.Int64Value;
import com.google.protobuf.Int64Value$1;
import com.google.protobuf.Int64ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;

public final class Int64Value$Builder
extends GeneratedMessageV3$Builder
implements Int64ValueOrBuilder {
    private long value_;

    private Int64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Int64Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Int64Value$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Int64Value$1 int64Value$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Int64Value$Builder(Int64Value$1 int64Value$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Int64Value$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Int64Value$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Int64Value build() {
        Int64Value int64Value = this.buildPartial();
        boolean bl2 = int64Value.isInitialized();
        if (bl2) {
            return int64Value;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(int64Value);
    }

    public Int64Value buildPartial() {
        Int64Value int64Value = new Int64Value(this, null);
        long l10 = this.value_;
        Int64Value.access$302(int64Value, l10);
        this.onBuilt();
        return int64Value;
    }

    public Int64Value$Builder clear() {
        super.clear();
        this.value_ = 0L;
        return this;
    }

    public Int64Value$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Int64Value$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Int64Value$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Int64Value$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Int64Value$Builder clearValue() {
        this.value_ = 0L;
        this.onChanged();
        return this;
    }

    public Int64Value$Builder clone() {
        return (Int64Value$Builder)super.clone();
    }

    public Int64Value getDefaultInstanceForType() {
        return Int64Value.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    public long getValue() {
        return this.value_;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
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
    public Int64Value$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Int64Value.access$400();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Int64Value)object;
            if (object == null) break block7;
            this.mergeFrom((Int64Value)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Int64Value)object2;
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
            this.mergeFrom((Int64Value)object3);
        }
        throw var1_6;
    }

    public Int64Value$Builder mergeFrom(Int64Value messageLite) {
        long l10;
        Int64Value int64Value = Int64Value.getDefaultInstance();
        if (messageLite == int64Value) {
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

    public Int64Value$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Int64Value;
        if (bl2) {
            message = (Int64Value)message;
            return this.mergeFrom((Int64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Int64Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Int64Value$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Int64Value$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Int64Value$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Int64Value$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Int64Value$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Int64Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Int64Value$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Int64Value$Builder setValue(long l10) {
        this.value_ = l10;
        this.onChanged();
        return this;
    }
}

