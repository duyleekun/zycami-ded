/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Empty;
import com.google.protobuf.Empty$1;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;

public final class Empty$Builder
extends GeneratedMessageV3$Builder
implements EmptyOrBuilder {
    private Empty$Builder() {
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Empty$Builder(Empty$1 empty$1) {
        this();
    }

    private Empty$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Empty$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Empty$1 empty$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Empty$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Empty$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Empty build() {
        Empty empty = this.buildPartial();
        boolean bl2 = empty.isInitialized();
        if (bl2) {
            return empty;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(empty);
    }

    public Empty buildPartial() {
        Empty empty = new Empty(this, null);
        this.onBuilt();
        return empty;
    }

    public Empty$Builder clear() {
        super.clear();
        return this;
    }

    public Empty$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Empty$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Empty$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Empty$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Empty$Builder clone() {
        return (Empty$Builder)super.clone();
    }

    public Empty getDefaultInstanceForType() {
        return Empty.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
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
    public Empty$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Empty.access$300();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Empty)object;
            if (object == null) break block7;
            this.mergeFrom((Empty)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Empty)object2;
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
            this.mergeFrom((Empty)object3);
        }
        throw var1_6;
    }

    public Empty$Builder mergeFrom(Empty messageLite) {
        Empty empty = Empty.getDefaultInstance();
        if (messageLite == empty) {
            return this;
        }
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public Empty$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Empty;
        if (bl2) {
            message = (Empty)message;
            return this.mergeFrom((Empty)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Empty$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Empty$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Empty$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Empty$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Empty$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Empty$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Empty$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Empty$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

