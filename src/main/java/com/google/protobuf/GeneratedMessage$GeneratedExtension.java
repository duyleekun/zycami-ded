/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$5;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$GeneratedExtension$1;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.WireFormat$FieldType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratedMessage$GeneratedExtension
extends Extension {
    private GeneratedMessage$ExtensionDescriptorRetriever descriptorRetriever;
    private final Method enumGetValueDescriptor;
    private final Method enumValueOf;
    private final Extension$ExtensionType extensionType;
    private final Message messageDefaultInstance;
    private final Class singularType;

    public GeneratedMessage$GeneratedExtension(GeneratedMessage$ExtensionDescriptorRetriever object, Class object2, Message object3, Extension$ExtensionType extension$ExtensionType) {
        Class<Message> clazz = Message.class;
        boolean bl2 = clazz.isAssignableFrom((Class<?>)object2);
        if (bl2 && !(bl2 = ((Class)object2).isInstance(object3))) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Bad messageDefaultInstance for ");
            object2 = ((Class)object2).getName();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            super((String)object2);
            throw object;
        }
        this.descriptorRetriever = object;
        this.singularType = object2;
        this.messageDefaultInstance = object3;
        object = ProtocolMessageEnum.class;
        int n10 = (int)(object.isAssignableFrom((Class<?>)object2) ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            object = new Class[n10];
            bl2 = false;
            clazz = null;
            object[0] = Descriptors$EnumValueDescriptor.class;
            this.enumValueOf = object = GeneratedMessage.access$1100((Class)object2, "valueOf", object);
            object = new Class[]{};
            object3 = "getValueDescriptor";
            this.enumGetValueDescriptor = object = GeneratedMessage.access$1100((Class)object2, (String)object3, object);
        } else {
            n10 = 0;
            object = null;
            this.enumValueOf = null;
            this.enumGetValueDescriptor = null;
        }
        this.extensionType = extension$ExtensionType;
    }

    public Object fromReflectionType(Object iterator2) {
        Object object = this.getDescriptor();
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (bl2) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
            if (object2 != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE) && (object = ((Descriptors$FieldDescriptor)object).getJavaType()) != (object2 = Descriptors$FieldDescriptor$JavaType.ENUM)) {
                return iterator2;
            }
            object = new ArrayList();
            iterator2 = ((List)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object2 = iterator2.next();
                object2 = this.singularFromReflectionType(object2);
                object.add(object2);
            }
            return object;
        }
        return this.singularFromReflectionType(iterator2);
    }

    public Object getDefaultValue() {
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        boolean bl2 = this.isRepeated();
        if (bl2) {
            return Collections.emptyList();
        }
        Object object = this.getDescriptor().getJavaType();
        if (object == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            return this.messageDefaultInstance;
        }
        object = this.getDescriptor().getDefaultValue();
        return this.singularFromReflectionType(object);
    }

    public Descriptors$FieldDescriptor getDescriptor() {
        Object object = this.descriptorRetriever;
        if (object != null) {
            return object.getDescriptor();
        }
        object = new IllegalStateException("getDescriptor() called before internalInit()");
        throw object;
    }

    public Extension$ExtensionType getExtensionType() {
        return this.extensionType;
    }

    public WireFormat$FieldType getLiteType() {
        return this.getDescriptor().getLiteType();
    }

    public Message getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }

    public int getNumber() {
        return this.getDescriptor().getNumber();
    }

    public void internalInit(Descriptors$FieldDescriptor object) {
        GeneratedMessage$ExtensionDescriptorRetriever generatedMessage$ExtensionDescriptorRetriever = this.descriptorRetriever;
        if (generatedMessage$ExtensionDescriptorRetriever == null) {
            this.descriptorRetriever = generatedMessage$ExtensionDescriptorRetriever = new GeneratedMessage$GeneratedExtension$1(this, (Descriptors$FieldDescriptor)object);
            return;
        }
        object = new IllegalStateException("Already initialized.");
        throw object;
    }

    public boolean isRepeated() {
        return this.getDescriptor().isRepeated();
    }

    public Object singularFromReflectionType(Object object) {
        Object object2 = this.getDescriptor();
        Object[] objectArray = GeneratedMessage$5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        object2 = ((Descriptors$FieldDescriptor)object2).getJavaType();
        int n10 = ((Enum)object2).ordinal();
        int n11 = 1;
        if ((n10 = objectArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                return object;
            }
            object2 = this.enumValueOf;
            objectArray = new Object[n11];
            object = (Descriptors$EnumValueDescriptor)object;
            objectArray[0] = (int)object;
            return GeneratedMessage.access$1200((Method)object2, null, objectArray);
        }
        object2 = this.singularType;
        n10 = (int)(((Class)object2).isInstance(object) ? 1 : 0);
        if (n10 != 0) {
            return object;
        }
        object2 = this.messageDefaultInstance.newBuilderForType();
        object = (Message)object;
        return object2.mergeFrom((Message)object).build();
    }

    public Object singularToReflectionType(Object object) {
        Object object2 = this.getDescriptor();
        Object[] objectArray = GeneratedMessage$5.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        object2 = ((Descriptors$FieldDescriptor)object2).getJavaType();
        int n10 = ((Enum)object2).ordinal();
        int n11 = 2;
        if ((n10 = objectArray[n10]) != n11) {
            return object;
        }
        object2 = this.enumGetValueDescriptor;
        objectArray = new Object[0];
        return GeneratedMessage.access$1200((Method)object2, object, objectArray);
    }

    public Object toReflectionType(Object iterator2) {
        Object object = this.getDescriptor();
        boolean bl2 = ((Descriptors$FieldDescriptor)object).isRepeated();
        if (bl2) {
            Object object2;
            if ((object = ((Descriptors$FieldDescriptor)object).getJavaType()) == (object2 = Descriptors$FieldDescriptor$JavaType.ENUM)) {
                object = new ArrayList();
                iterator2 = ((List)((Object)iterator2)).iterator();
                while (bl2 = iterator2.hasNext()) {
                    object2 = iterator2.next();
                    object2 = this.singularToReflectionType(object2);
                    object.add(object2);
                }
                return object;
            }
            return iterator2;
        }
        return this.singularToReflectionType(iterator2);
    }
}

