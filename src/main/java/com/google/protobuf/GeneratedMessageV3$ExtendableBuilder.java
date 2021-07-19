/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$Builder;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessageOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessageV3$ExtendableBuilder
extends GeneratedMessageV3$Builder
implements GeneratedMessageV3$ExtendableMessageOrBuilder {
    private FieldSet$Builder extensions;

    public GeneratedMessageV3$ExtendableBuilder() {
    }

    public GeneratedMessageV3$ExtendableBuilder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
    }

    public static /* synthetic */ FieldSet access$400(GeneratedMessageV3$ExtendableBuilder generatedMessageV3$ExtendableBuilder) {
        return generatedMessageV3$ExtendableBuilder.buildExtensions();
    }

    private FieldSet buildExtensions() {
        Object object = this.extensions;
        object = object == null ? FieldSet.emptySet() : ((FieldSet$Builder)object).build();
        return object;
    }

    private void ensureExtensionsIsMutable() {
        FieldSet$Builder fieldSet$Builder = this.extensions;
        if (fieldSet$Builder == null) {
            this.extensions = fieldSet$Builder = FieldSet.newBuilder();
        }
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

    public final GeneratedMessageV3$ExtendableBuilder addExtension(Extension extension, Object object) {
        return this.addExtension((ExtensionLite)extension, object);
    }

    public final GeneratedMessageV3$ExtendableBuilder addExtension(ExtensionLite object, Object object2) {
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((Extension)object).getDescriptor();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        object = ((Extension)object).singularToReflectionType(object2);
        fieldSet$Builder.addRepeatedField(descriptors$FieldDescriptor, object);
        this.onChanged();
        return this;
    }

    public GeneratedMessageV3$ExtendableBuilder addExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return this.addExtension((ExtensionLite)generatedMessage$GeneratedExtension, object);
    }

    public GeneratedMessageV3$ExtendableBuilder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(descriptors$FieldDescriptor, object);
            this.onChanged();
            return this;
        }
        return (GeneratedMessageV3$ExtendableBuilder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public GeneratedMessageV3$ExtendableBuilder clear() {
        this.extensions = null;
        return (GeneratedMessageV3$ExtendableBuilder)super.clear();
    }

    public final GeneratedMessageV3$ExtendableBuilder clearExtension(Extension extension) {
        return this.clearExtension((ExtensionLite)extension);
    }

    public final GeneratedMessageV3$ExtendableBuilder clearExtension(ExtensionLite object) {
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        this.ensureExtensionsIsMutable();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        object = ((Extension)object).getDescriptor();
        fieldSet$Builder.clearField((FieldSet$FieldDescriptorLite)object);
        this.onChanged();
        return this;
    }

    public GeneratedMessageV3$ExtendableBuilder clearExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.clearExtension((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public GeneratedMessageV3$ExtendableBuilder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.clearField(descriptors$FieldDescriptor);
            this.onChanged();
            return this;
        }
        return (GeneratedMessageV3$ExtendableBuilder)super.clearField(descriptors$FieldDescriptor);
    }

    public boolean extensionsAreInitialized() {
        FieldSet$Builder fieldSet$Builder = this.extensions;
        boolean bl2 = fieldSet$Builder == null ? true : fieldSet$Builder.isInitialized();
        return bl2;
    }

    public Map getAllFields() {
        Map map = GeneratedMessageV3$Builder.access$900(this);
        Object object = this.extensions;
        if (object != null) {
            object = ((FieldSet$Builder)object).getAllFields();
            map.putAll(object);
        }
        return Collections.unmodifiableMap(map);
    }

    public final Object getExtension(Extension extension) {
        return this.getExtension((ExtensionLite)extension);
    }

    public final Object getExtension(Extension extension, int n10) {
        return this.getExtension((ExtensionLite)extension, n10);
    }

    public final Object getExtension(ExtensionLite extensionLite) {
        boolean bl2;
        extensionLite = GeneratedMessageV3.access$500(extensionLite);
        this.verifyExtensionContainingType((Extension)extensionLite);
        Object object = ((Extension)extensionLite).getDescriptor();
        Object object2 = this.extensions;
        if (object2 == null) {
            bl2 = false;
            object2 = null;
        } else {
            object2 = ((FieldSet$Builder)object2).getField((FieldSet$FieldDescriptorLite)object);
        }
        if (object2 == null) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
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

    public final Object getExtension(ExtensionLite object, int n10) {
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((Extension)object).getDescriptor();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        if (fieldSet$Builder != null) {
            Object object2 = fieldSet$Builder.getRepeatedField(descriptors$FieldDescriptor, n10);
            return ((Extension)object).singularFromReflectionType(object2);
        }
        object = new IndexOutOfBoundsException();
        throw object;
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
        int n10;
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        object = ((Extension)object).getDescriptor();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        if (fieldSet$Builder == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = fieldSet$Builder.getRepeatedFieldCount((FieldSet$FieldDescriptorLite)object);
        }
        return n10;
    }

    public final int getExtensionCount(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.getExtensionCount((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            Object object = this.extensions;
            if (object == null) {
                bl2 = false;
                object = null;
            } else {
                object = ((FieldSet$Builder)object).getField(descriptors$FieldDescriptor);
            }
            if (object == null) {
                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
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

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor object) {
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isExtension();
        if (bl2) {
            this.verifyContainingType((Descriptors$FieldDescriptor)object);
            Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE;
            if (object2 == descriptors$FieldDescriptor$JavaType) {
                this.ensureExtensionsIsMutable();
                object2 = this.extensions.getFieldAllowBuilders((FieldSet$FieldDescriptorLite)object);
                if (object2 == null) {
                    object2 = DynamicMessage.newBuilder(((Descriptors$FieldDescriptor)object).getMessageType());
                    this.extensions.setField((FieldSet$FieldDescriptorLite)object, object2);
                    this.onChanged();
                    return object2;
                }
                boolean bl3 = object2 instanceof Message$Builder;
                if (bl3) {
                    return (Message$Builder)object2;
                }
                bl3 = object2 instanceof Message;
                if (bl3) {
                    object2 = ((Message)object2).toBuilder();
                    this.extensions.setField((FieldSet$FieldDescriptorLite)object, object2);
                    this.onChanged();
                    return object2;
                }
                object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                throw object;
            }
            object = new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            throw object;
        }
        return super.getFieldBuilder((Descriptors$FieldDescriptor)object);
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor object, int n10) {
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isExtension();
        if (bl2) {
            this.verifyContainingType((Descriptors$FieldDescriptor)object);
            FieldSet$Builder fieldSet$Builder = this.extensions;
            if (fieldSet$Builder != null) {
                return fieldSet$Builder.getRepeatedField((FieldSet$FieldDescriptorLite)object, n10);
            }
            object = new IndexOutOfBoundsException();
            throw object;
        }
        return super.getRepeatedField((Descriptors$FieldDescriptor)object, n10);
    }

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor object, int n10) {
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isExtension();
        if (bl2) {
            this.verifyContainingType((Descriptors$FieldDescriptor)object);
            this.ensureExtensionsIsMutable();
            Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE;
            String string2 = "getRepeatedFieldBuilder() called on a non-Message type.";
            if (object2 == descriptors$FieldDescriptor$JavaType) {
                object2 = this.extensions.getRepeatedFieldAllowBuilders((FieldSet$FieldDescriptorLite)object, n10);
                boolean bl3 = object2 instanceof Message$Builder;
                if (bl3) {
                    return (Message$Builder)object2;
                }
                bl3 = object2 instanceof Message;
                if (bl3) {
                    object2 = ((Message)object2).toBuilder();
                    this.extensions.setRepeatedField((FieldSet$FieldDescriptorLite)object, n10, object2);
                    this.onChanged();
                    return object2;
                }
                object = new UnsupportedOperationException(string2);
                throw object;
            }
            object = new UnsupportedOperationException(string2);
            throw object;
        }
        return super.getRepeatedFieldBuilder((Descriptors$FieldDescriptor)object, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            int n10;
            this.verifyContainingType(descriptors$FieldDescriptor);
            FieldSet$Builder fieldSet$Builder = this.extensions;
            if (fieldSet$Builder == null) {
                n10 = 0;
                descriptors$FieldDescriptor = null;
            } else {
                n10 = fieldSet$Builder.getRepeatedFieldCount(descriptors$FieldDescriptor);
            }
            return n10;
        }
        return super.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    public final boolean hasExtension(Extension extension) {
        return this.hasExtension((ExtensionLite)extension);
    }

    public final boolean hasExtension(ExtensionLite object) {
        boolean bl2;
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        FieldSet$Builder fieldSet$Builder = this.extensions;
        if (fieldSet$Builder == null) {
            bl2 = false;
            object = null;
        } else {
            object = ((Extension)object).getDescriptor();
            bl2 = fieldSet$Builder.hasField((FieldSet$FieldDescriptorLite)object);
        }
        return bl2;
    }

    public final boolean hasExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        return this.hasExtension((ExtensionLite)generatedMessage$GeneratedExtension);
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            boolean bl3;
            this.verifyContainingType(descriptors$FieldDescriptor);
            FieldSet$Builder fieldSet$Builder = this.extensions;
            if (fieldSet$Builder == null) {
                bl3 = false;
                descriptors$FieldDescriptor = null;
            } else {
                bl3 = fieldSet$Builder.hasField(descriptors$FieldDescriptor);
            }
            return bl3;
        }
        return super.hasField(descriptors$FieldDescriptor);
    }

    public void internalSetExtensionSet(FieldSet object) {
        this.extensions = object = FieldSet$Builder.fromFieldSet((FieldSet)object);
    }

    public boolean isInitialized() {
        boolean bl2 = super.isInitialized();
        bl2 = bl2 && (bl2 = this.extensionsAreInitialized());
        return bl2;
    }

    public final void mergeExtensionFields(GeneratedMessageV3$ExtendableMessage object) {
        Object object2 = GeneratedMessageV3$ExtendableMessage.access$600((GeneratedMessageV3$ExtendableMessage)object);
        if (object2 != null) {
            this.ensureExtensionsIsMutable();
            object2 = this.extensions;
            object = GeneratedMessageV3$ExtendableMessage.access$600((GeneratedMessageV3$ExtendableMessage)object);
            ((FieldSet$Builder)object2).mergeFrom((FieldSet)object);
            this.onChanged();
        }
    }

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            return DynamicMessage.newBuilder(descriptors$FieldDescriptor.getMessageType());
        }
        return super.newBuilderForField(descriptors$FieldDescriptor);
    }

    public final GeneratedMessageV3$ExtendableBuilder setExtension(Extension extension, int n10, Object object) {
        return this.setExtension((ExtensionLite)extension, n10, object);
    }

    public final GeneratedMessageV3$ExtendableBuilder setExtension(Extension extension, Object object) {
        return this.setExtension((ExtensionLite)extension, object);
    }

    public final GeneratedMessageV3$ExtendableBuilder setExtension(ExtensionLite object, int n10, Object object2) {
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((Extension)object).getDescriptor();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        object = ((Extension)object).singularToReflectionType(object2);
        fieldSet$Builder.setRepeatedField(descriptors$FieldDescriptor, n10, object);
        this.onChanged();
        return this;
    }

    public final GeneratedMessageV3$ExtendableBuilder setExtension(ExtensionLite object, Object object2) {
        object = GeneratedMessageV3.access$500((ExtensionLite)object);
        this.verifyExtensionContainingType((Extension)object);
        this.ensureExtensionsIsMutable();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((Extension)object).getDescriptor();
        FieldSet$Builder fieldSet$Builder = this.extensions;
        object = ((Extension)object).toReflectionType(object2);
        fieldSet$Builder.setField(descriptors$FieldDescriptor, object);
        this.onChanged();
        return this;
    }

    public GeneratedMessageV3$ExtendableBuilder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, int n10, Object object) {
        return this.setExtension((ExtensionLite)generatedMessage$GeneratedExtension, n10, object);
    }

    public GeneratedMessageV3$ExtendableBuilder setExtension(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension, Object object) {
        return this.setExtension((ExtensionLite)generatedMessage$GeneratedExtension, object);
    }

    public GeneratedMessageV3$ExtendableBuilder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.setField(descriptors$FieldDescriptor, object);
            this.onChanged();
            return this;
        }
        return (GeneratedMessageV3$ExtendableBuilder)super.setField(descriptors$FieldDescriptor, object);
    }

    public GeneratedMessageV3$ExtendableBuilder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        boolean bl2 = descriptors$FieldDescriptor.isExtension();
        if (bl2) {
            this.verifyContainingType(descriptors$FieldDescriptor);
            this.ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(descriptors$FieldDescriptor, n10, object);
            this.onChanged();
            return this;
        }
        return (GeneratedMessageV3$ExtendableBuilder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }
}

