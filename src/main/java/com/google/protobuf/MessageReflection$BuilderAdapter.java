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
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

public class MessageReflection$BuilderAdapter
implements MessageReflection$MergeTarget {
    private final Message$Builder builder;

    public MessageReflection$BuilderAdapter(Message$Builder message$Builder) {
        this.builder = message$Builder;
    }

    public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.builder.addRepeatedField(descriptors$FieldDescriptor, object);
        return this;
    }

    public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.builder.clearField(descriptors$FieldDescriptor);
        return this;
    }

    public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.builder.clearOneof(descriptors$OneofDescriptor);
        return this;
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String string2) {
        return extensionRegistry.findImmutableExtensionByName(string2);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors$Descriptor descriptors$Descriptor, int n10) {
        return extensionRegistry.findImmutableExtensionByNumber(descriptors$Descriptor, n10);
    }

    public Object finish() {
        return this.builder.buildPartial();
    }

    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.MESSAGE;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return this.builder.getDescriptorForType();
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.getField(descriptors$FieldDescriptor);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.getOneofFieldDescriptor(descriptors$OneofDescriptor);
    }

    public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor object) {
        boolean bl2 = ((Descriptors$FieldDescriptor)object).needsUtf8Check();
        if (bl2) {
            return WireFormat$Utf8Validation.STRICT;
        }
        boolean bl3 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl3 && (bl3 = (object = this.builder) instanceof GeneratedMessage$Builder)) {
            return WireFormat$Utf8Validation.LAZY;
        }
        return WireFormat$Utf8Validation.LOOSE;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.hasField(descriptors$FieldDescriptor);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.hasOneof(descriptors$OneofDescriptor);
    }

    public MessageReflection$MergeTarget newEmptyTargetForField(Descriptors$FieldDescriptor object, Message object2) {
        if (object2 != null) {
            object = object2.newBuilderForType();
        } else {
            object2 = this.builder;
            object = object2.newBuilderForField((Descriptors$FieldDescriptor)object);
        }
        object2 = new MessageReflection$BuilderAdapter((Message$Builder)object);
        return object2;
    }

    public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor object, Message messageOrBuilder) {
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.newBuilderForType() : this.builder.newBuilderForField((Descriptors$FieldDescriptor)object);
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl2 && (object = (Message)this.getField((Descriptors$FieldDescriptor)object)) != null) {
            messageOrBuilder.mergeFrom((Message)object);
        }
        object = new MessageReflection$BuilderAdapter((Message$Builder)messageOrBuilder);
        return object;
    }

    public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message messageOrBuilder) {
        Message message;
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.newBuilderForType() : this.builder.newBuilderForField(descriptors$FieldDescriptor);
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (!bl2 && (message = (Message)this.getField(descriptors$FieldDescriptor)) != null) {
            messageOrBuilder.mergeFrom(message);
        }
        int n10 = descriptors$FieldDescriptor.getNumber();
        codedInputStream.readGroup(n10, (MessageLite$Builder)((Object)messageOrBuilder), extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor object, Message messageOrBuilder) {
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.newBuilderForType() : this.builder.newBuilderForField((Descriptors$FieldDescriptor)object);
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl2 && (object = (Message)this.getField((Descriptors$FieldDescriptor)object)) != null) {
            messageOrBuilder.mergeFrom((Message)object);
        }
        codedInputStream.readMessage((MessageLite$Builder)((Object)messageOrBuilder), extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors$FieldDescriptor object, Message messageOrBuilder) {
        messageOrBuilder = messageOrBuilder != null ? messageOrBuilder.newBuilderForType() : this.builder.newBuilderForField((Descriptors$FieldDescriptor)object);
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (!bl2 && (object = (Message)this.getField((Descriptors$FieldDescriptor)object)) != null) {
            messageOrBuilder.mergeFrom((Message)object);
        }
        messageOrBuilder.mergeFrom(byteString, extensionRegistryLite);
        return messageOrBuilder.buildPartial();
    }

    public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.builder.setField(descriptors$FieldDescriptor, object);
        return this;
    }

    public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        this.builder.setRepeatedField(descriptors$FieldDescriptor, n10, object);
        return this;
    }
}

