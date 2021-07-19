/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$ExtensionAdapter;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableMessage
extends GeneratedMessage
implements GeneratedMessage$ExtendableMessageOrBuilder {
    private static final long serialVersionUID = 1L;
    private final FieldSet extensions;

    public GeneratedMessage$ExtendableMessage() {
        FieldSet fieldSet;
        this.extensions = fieldSet = FieldSet.newFieldSet();
    }

    public GeneratedMessage$ExtendableMessage(GeneratedMessage$ExtendableBuilder object) {
        super((GeneratedMessage$Builder)object);
        this.extensions = object = GeneratedMessage$ExtendableBuilder.access$400((GeneratedMessage$ExtendableBuilder)object);
    }

    public static /* synthetic */ FieldSet access$600(GeneratedMessage$ExtendableMessage generatedMessage$ExtendableMessage) {
        return generatedMessage$ExtendableMessage.extensions;
    }

    private void verifyContainingType(Descriptors$FieldDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        if ((object = ((Descriptors$FieldDescriptor)object).getContainingType()) == (descriptors$Descriptor = this.getDescriptorForType())) {
            return;
        }
        object = new IllegalArgumentException("FieldDescriptor does not match message type.");
        throw object;
    }

    private void verifyExtensionContainingType(Extension object) {
        Object object2;
        Object object3 = ((Extension)object).getDescriptor().getContainingType();
        if (object3 == (object2 = this.getDescriptorForType())) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Extension is for type \"");
        object = ((Extension)object).getDescriptor().getContainingType().getFullName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("\" which does not match message type \"");
        object = this.getDescriptorForType().getFullName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("\".");
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.isInitialized();
    }

    public int extensionsSerializedSize() {
        return this.extensions.getSerializedSize();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.getMessageSetSerializedSize();
    }

    public Map getAllFields() {
        Map map = GeneratedMessage.access$800(this, false);
        Map map2 = this.getExtensionFields();
        map.putAll(map2);
        return Collections.unmodifiableMap(map);
    }

    public Map getAllFieldsRaw() {
        Map map = GeneratedMessage.access$800(this, false);
        Map map2 = this.getExtensionFields();
        map.putAll(map2);
        return Collections.unmodifiableMap(map);
    }

    public final Object getExtension(Extension extension) {
        return this.getExtension((ExtensionLite)extension);
    }

    public final Object getExtension(Extension extension, int n10) {
        return this.getExtension((ExtensionLite)extension, n10);
    }

    public final Object getExtension(ExtensionLite extensionLite) {
        extensionLite = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType((Extension)extensionLite);
        Object object = ((Extension)extensionLite).getDescriptor();
        Object object2 = this.extensions.getField((FieldSet$FieldDescriptorLite)object);
        if (object2 == null) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
            if (bl2) {
                return Collections.emptyList();
            }
            object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
            if (object2 == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                return ((Extension)extensionLite).getMessageDefaultInstance();
            }
            object = ((Descriptors$FieldDescriptor)object).getDefaultValue();
            return ((Extension)extensionLite).fromReflectionType(object);
        }
        return ((Extension)extensionLite).fromReflectionType(object2);
    }

    public final Object getExtension(ExtensionLite extensionLite, int n10) {
        extensionLite = GeneratedMessage.access$500(extensionLite);
        this.verifyExtensionContainingType((Extension)extensionLite);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((Extension)extensionLite).getDescriptor();
        Object object = this.extensions.getRepeatedField(descriptors$FieldDescriptor, n10);
        return ((Extension)extensionLite).singularFromReflectionType(object);
    }

    public final Object getExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.getExtension((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public final Object getExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10) {
        return this.getExtension((ExtensionLite)generatedMessage$GeneratedExtension, n10);
    }

    public final int getExtensionCount(Extension extension) {
        return this.getExtensionCount((ExtensionLite)extension);
    }

    public final int getExtensionCount(ExtensionLite object) {
        object = GeneratedMessage.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        object = ((Extension)object).getDescriptor();
        return this.extensions.getRepeatedFieldCount((FieldSet$FieldDescriptorLite)object);
    }

    public final int getExtensionCount(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.getExtensionCount((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public Map getExtensionFields() {
        return this.extensions.getAllFields();
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            Object object = this.extensions.getField(descriptors$FieldDescriptor);
            if (object == null) {
                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
                bl2 = descriptors$FieldDescriptor.isRepeated();
                if (bl2) {
                    return Collections.emptyList();
                }
                object = descriptors$FieldDescriptor.getJavaType();
                if (object == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                    return DynamicMessage.getDefaultInstance(descriptors$FieldDescriptor.getMessageType());
                }
                return descriptors$FieldDescriptor.getDefaultValue();
            }
            return object;
        }
        return super.getField(descriptors$FieldDescriptor);
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.getRepeatedField(descriptors$FieldDescriptor, n10);
        }
        return super.getRepeatedField(descriptors$FieldDescriptor, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.getRepeatedFieldCount(descriptors$FieldDescriptor);
        }
        return super.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    public final boolean hasExtension(Extension extension) {
        return this.hasExtension((ExtensionLite)extension);
    }

    public final boolean hasExtension(ExtensionLite object) {
        object = GeneratedMessage.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        FieldSet fieldSet = this.extensions;
        object = ((Extension)object).getDescriptor();
        return fieldSet.hasField((FieldSet$FieldDescriptorLite)object);
    }

    public final boolean hasExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.hasExtension((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            return this.extensions.hasField(descriptors$FieldDescriptor);
        }
        return super.hasField(descriptors$FieldDescriptor);
    }

    public boolean isInitialized() {
        boolean bl2 = super.isInitialized();
        bl2 = bl2 && (bl2 = this.extensionsAreInitialized());
        return bl2;
    }

    public void makeExtensionsImmutable() {
        this.extensions.makeImmutable();
    }

    public GeneratedMessage$ExtendableMessage$ExtensionWriter newExtensionWriter() {
        GeneratedMessage$ExtendableMessage$ExtensionWriter generatedMessage$ExtendableMessage$ExtensionWriter = new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, false, null);
        return generatedMessage$ExtendableMessage$ExtensionWriter;
    }

    public GeneratedMessage$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
        GeneratedMessage$ExtendableMessage$ExtensionWriter generatedMessage$ExtendableMessage$ExtensionWriter = new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, true, null);
        return generatedMessage$ExtendableMessage$ExtensionWriter;
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n10) {
        Descriptors$Descriptor descriptors$Descriptor = this.getDescriptorForType();
        Object object = this.extensions;
        MessageReflection$ExtensionAdapter messageReflection$ExtensionAdapter = new MessageReflection$ExtensionAdapter((FieldSet)object);
        object = codedInputStream;
        return MessageReflection.mergeFieldFrom(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, descriptors$Descriptor, messageReflection$ExtensionAdapter, n10);
    }
}

