/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

public class MessageReflection$ExtensionAdapter
implements MessageReflection$MergeTarget {
    private final FieldSet extensions;

    public MessageReflection$ExtensionAdapter(FieldSet fieldSet) {
        this.extensions = fieldSet;
    }

    public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.extensions.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.extensions.clearField(descriptors$FieldDescriptor);
        return this;
    }

    public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this;
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String string2) {
        return extensionRegistry.findImmutableExtensionByName(string2);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors$Descriptor descriptors$Descriptor, int n10) {
        return extensionRegistry.findImmutableExtensionByNumber(descriptors$Descriptor, n10);
    }

    public Object finish() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("finish() called on FieldSet object");
        throw unsupportedOperationException;
    }

    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.EXTENSION_SET;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        throw unsupportedOperationException;
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.getField(descriptors$FieldDescriptor);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return null;
    }

    public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.needsUtf8Check();
        if (bl2) {
            return WireFormat$Utf8Validation.STRICT;
        }
        return WireFormat$Utf8Validation.LOOSE;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.hasField(descriptors$FieldDescriptor);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return false;
    }

    public MessageReflection$MergeTarget newEmptyTargetForField(Descriptors$FieldDescriptor object, Message message) {
        object = new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        throw object;
    }

    public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor object, Message message) {
        object = new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        throw object;
    }

    public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message messageOrBuilder) {
        Message message;
        messageOrBuilder = messageOrBuilder.newBuilderForType();
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (!bl2 && (message = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            messageOrBuilder.mergeFrom(message);
        }
        int n10 = descriptors$FieldDescriptor.getNumber();
        codedInputStream.readGroup(n10, (MessageLite$Builder)((Object)messageOrBuilder), extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor object, Message messageOrBuilder) {
        messageOrBuilder = messageOrBuilder.newBuilderForType();
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl2 && (object = (Message)this.getField((Descriptors$FieldDescriptor)object)) != null) {
            messageOrBuilder.mergeFrom((Message)object);
        }
        codedInputStream.readMessage((MessageLite$Builder)((Object)messageOrBuilder), extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor object, Message messageOrBuilder) {
        messageOrBuilder = messageOrBuilder.newBuilderForType();
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl2 && (object = (Message)this.getField((Descriptors$FieldDescriptor)object)) != null) {
            messageOrBuilder.mergeFrom((Message)object);
        }
        messageOrBuilder.mergeFrom(byteString, extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.extensions.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        this.extensions.setRepeatedField(descriptors$FieldDescriptor, n10, object);
        return this;
    }
}

