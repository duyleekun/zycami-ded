/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

public final class GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor
extends GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor {
    private final Method getBuilderMethodBuilder;
    private final Method newBuilderMethod;

    public GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class clazz, Class clazz2) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, clazz, clazz2);
        object = this.type;
        Object object2 = new Class[]{};
        this.newBuilderMethod = object = GeneratedMessageV3.access$1000((Class)object, "newBuilder", object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("get");
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append("Builder");
        object = ((StringBuilder)object).toString();
        object2 = Integer.TYPE;
        classArray = new Class[]{object2};
        this.getBuilderMethodBuilder = object = GeneratedMessageV3.access$1000(clazz2, (String)object, classArray);
    }

    private Object coerceType(Object object) {
        Object object2 = this.type;
        boolean bl2 = ((Class)object2).isInstance(object);
        if (bl2) {
            return object;
        }
        object2 = this.newBuilderMethod;
        Object[] objectArray = new Object[]{};
        object2 = (Message$Builder)GeneratedMessageV3.access$1100((Method)object2, null, objectArray);
        object = (Message)object;
        return object2.mergeFrom((Message)object).build();
    }

    public void addRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        object = this.coerceType(object);
        super.addRepeated(generatedMessageV3$Builder, object);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        Method method = this.getBuilderMethodBuilder;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return (Message$Builder)GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Message$Builder newBuilder() {
        Method method = this.newBuilderMethod;
        Object[] objectArray = new Object[]{};
        return (Message$Builder)GeneratedMessageV3.access$1100(method, null, objectArray);
    }

    public void setRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10, Object object) {
        object = this.coerceType(object);
        super.setRepeated(generatedMessageV3$Builder, n10, object);
    }
}

