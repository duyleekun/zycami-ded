/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractMessage$Builder
extends AbstractMessageLite$Builder
implements Message$Builder {
    public static UninitializedMessageException newUninitializedMessageException(Message object) {
        object = MessageReflection.findMissingFields((MessageOrBuilder)object);
        UninitializedMessageException uninitializedMessageException = new UninitializedMessageException((List)object);
        return uninitializedMessageException;
    }

    public AbstractMessage$Builder clear() {
        boolean bl2;
        Iterator iterator2 = this.getAllFields().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator2.next().getKey();
            this.clearField(descriptors$FieldDescriptor);
        }
        return this;
    }

    public AbstractMessage$Builder clearOneof(Descriptors$OneofDescriptor object) {
        object = new UnsupportedOperationException("clearOneof() is not implemented.");
        throw object;
    }

    public AbstractMessage$Builder clone() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("clone() should be implemented in subclasses.");
        throw unsupportedOperationException;
    }

    public void dispose() {
        IllegalStateException illegalStateException = new IllegalStateException("Should be overridden by subclasses.");
        throw illegalStateException;
    }

    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor object) {
        object = new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        throw object;
    }

    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor object) {
        object = new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        throw object;
    }

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        throw object;
    }

    public boolean hasOneof(Descriptors$OneofDescriptor object) {
        object = new UnsupportedOperationException("hasOneof() is not implemented.");
        throw object;
    }

    public AbstractMessage$Builder internalMergeFrom(AbstractMessageLite messageLite) {
        messageLite = (Message)messageLite;
        return this.mergeFrom((Message)messageLite);
    }

    public void markClean() {
        IllegalStateException illegalStateException = new IllegalStateException("Should be overridden by subclasses.");
        throw illegalStateException;
    }

    public boolean mergeDelimitedFrom(InputStream inputStream) {
        return super.mergeDelimitedFrom(inputStream);
    }

    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public AbstractMessage$Builder mergeFrom(ByteString byteString) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString);
    }

    public AbstractMessage$Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(byteString, extensionRegistryLite);
    }

    public AbstractMessage$Builder mergeFrom(CodedInputStream codedInputStream) {
        ExtensionRegistry extensionRegistry = ExtensionRegistry.getEmptyRegistry();
        return this.mergeFrom(codedInputStream, (ExtensionRegistryLite)extensionRegistry);
    }

    public AbstractMessage$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        boolean bl2 = ((CodedInputStream)object).shouldDiscardUnknownFields();
        if (bl2) {
            bl2 = false;
            unknownFieldSet$Builder = null;
        } else {
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder(this.getUnknownFields());
        }
        while ((n10 = ((CodedInputStream)object).readTag()) != 0) {
            MessageReflection$BuilderAdapter messageReflection$BuilderAdapter = new MessageReflection$BuilderAdapter(this);
            Descriptors$Descriptor descriptors$Descriptor = this.getDescriptorForType();
            boolean bl3 = MessageReflection.mergeFieldFrom((CodedInputStream)object, unknownFieldSet$Builder, extensionRegistryLite, descriptors$Descriptor, messageReflection$BuilderAdapter, n10);
            if (bl3) continue;
        }
        if (unknownFieldSet$Builder != null) {
            object = unknownFieldSet$Builder.build();
            this.setUnknownFields((UnknownFieldSet)object);
        }
        return this;
    }

    public AbstractMessage$Builder mergeFrom(Message message) {
        Map map = message.getAllFields();
        return this.mergeFrom(message, map);
    }

    public AbstractMessage$Builder mergeFrom(Message object, Map object2) {
        Descriptors$GenericDescriptor descriptors$GenericDescriptor;
        Object object3 = object.getDescriptorForType();
        if (object3 == (descriptors$GenericDescriptor = this.getDescriptorForType())) {
            boolean bl2;
            object2 = object2.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Object object4;
                Object object5;
                object3 = (Map.Entry)object2.next();
                descriptors$GenericDescriptor = (Descriptors$FieldDescriptor)object3.getKey();
                boolean bl3 = ((Descriptors$FieldDescriptor)descriptors$GenericDescriptor).isRepeated();
                if (bl3) {
                    object3 = ((List)object3.getValue()).iterator();
                    while (bl3 = object3.hasNext()) {
                        object5 = object3.next();
                        this.addRepeatedField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor, object5);
                    }
                    continue;
                }
                object5 = ((Descriptors$FieldDescriptor)descriptors$GenericDescriptor).getJavaType();
                if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                    object5 = (Message)this.getField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
                    if (object5 == (object4 = object5.getDefaultInstanceForType())) {
                        object3 = object3.getValue();
                        this.setField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor, object3);
                        continue;
                    }
                    object4 = object5.newBuilderForType();
                    object5 = object4.mergeFrom((Message)object5);
                    object3 = (Message)object3.getValue();
                    object3 = object5.mergeFrom((Message)object3).build();
                    this.setField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor, object3);
                    continue;
                }
                object3 = object3.getValue();
                this.setField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor, object3);
            }
            object = object.getUnknownFields();
            this.mergeUnknownFields((UnknownFieldSet)object);
            return this;
        }
        object = new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        throw object;
    }

    public AbstractMessage$Builder mergeFrom(InputStream inputStream) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream);
    }

    public AbstractMessage$Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(inputStream, extensionRegistryLite);
    }

    public AbstractMessage$Builder mergeFrom(byte[] byArray) {
        return (AbstractMessage$Builder)super.mergeFrom(byArray);
    }

    public AbstractMessage$Builder mergeFrom(byte[] byArray, int n10, int n11) {
        return (AbstractMessage$Builder)super.mergeFrom(byArray, n10, n11);
    }

    public AbstractMessage$Builder mergeFrom(byte[] byArray, int n10, int n11, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(byArray, n10, n11, extensionRegistryLite);
    }

    public AbstractMessage$Builder mergeFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (AbstractMessage$Builder)super.mergeFrom(byArray, extensionRegistryLite);
    }

    public AbstractMessage$Builder mergeUnknownFields(UnknownFieldSet messageLite) {
        messageLite = UnknownFieldSet.newBuilder(this.getUnknownFields()).mergeFrom((UnknownFieldSet)messageLite).build();
        this.setUnknownFields((UnknownFieldSet)messageLite);
        return this;
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }
}

