/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

public final class GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor
extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
    private final Method getBuilderMethodBuilder;
    private final Method newBuilderMethod;

    public GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class clazz, Class clazz2) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, clazz, clazz2);
        object = this.type;
        Object object2 = new Class[]{};
        this.newBuilderMethod = object = GeneratedMessage.access$1100((Class)object, "newBuilder", object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("get");
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append("Builder");
        object = ((StringBuilder)object).toString();
        object2 = Integer.TYPE;
        classArray = new Class[]{object2};
        this.getBuilderMethodBuilder = object = GeneratedMessage.access$1100(clazz2, (String)object, classArray);
    }

    private Object coerceType(Object object) {
        Object object2 = this.type;
        boolean bl2 = ((Class)object2).isInstance(object);
        if (bl2) {
            return object;
        }
        object2 = this.newBuilderMethod;
        Object[] objectArray = new Object[]{};
        object2 = (Message$Builder)GeneratedMessage.access$1200((Method)object2, null, objectArray);
        object = (Message)object;
        return object2.mergeFrom((Message)object).build();
    }

    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        object = this.coerceType(object);
        super.addRepeated(generatedMessage$Builder, object);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder generatedMessage$Builder, int n10) {
        Method method = this.getBuilderMethodBuilder;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return (Message$Builder)GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Message$Builder newBuilder() {
        Method method = this.newBuilderMethod;
        Object[] objectArray = new Object[]{};
        return (Message$Builder)GeneratedMessage.access$1200(method, null, objectArray);
    }

    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n10, Object object) {
        object = this.coerceType(object);
        super.setRepeated(generatedMessage$Builder, n10, object);
    }
}

