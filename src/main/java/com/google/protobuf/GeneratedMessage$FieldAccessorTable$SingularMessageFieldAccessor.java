/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

public final class GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor
extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
    private final Method getBuilderMethodBuilder;
    private final Method newBuilderMethod;

    public GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class clazz, Class clazz2, String classArray2) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, clazz, clazz2, (String)classArray2);
        object = this.type;
        classArray2 = new Class[]{};
        this.newBuilderMethod = object = GeneratedMessage.access$1100((Class)object, "newBuilder", classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("get");
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append("Builder");
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{};
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
        return object2.mergeFrom((Message)object).buildPartial();
    }

    public Message$Builder getBuilder(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.getBuilderMethodBuilder;
        Object[] objectArray = new Object[]{};
        return (Message$Builder)GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Message$Builder newBuilder() {
        Method method = this.newBuilderMethod;
        Object[] objectArray = new Object[]{};
        return (Message$Builder)GeneratedMessage.access$1200(method, null, objectArray);
    }

    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        object = this.coerceType(object);
        super.set(generatedMessage$Builder, object);
    }
}

