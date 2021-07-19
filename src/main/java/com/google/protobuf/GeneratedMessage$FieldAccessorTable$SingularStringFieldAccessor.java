/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import java.lang.reflect.Method;

public final class GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor
extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
    private final Method getBytesMethod;
    private final Method getBytesMethodBuilder;
    private final Method setBytesMethodBuilder;

    public GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class classArray2, Class clazz, String string2) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, (Class)classArray2, clazz, string2);
        super();
        string2 = "get";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        String string3 = "Bytes";
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Class[] classArray3 = new Class[]{};
        this.getBytesMethod = object = GeneratedMessage.access$1100((Class)classArray2, (String)object, classArray3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        classArray2 = new Class[]{};
        this.getBytesMethodBuilder = object = GeneratedMessage.access$1100(clazz, (String)object, classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("set");
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{ByteString.class};
        this.setBytesMethodBuilder = object = GeneratedMessage.access$1100(clazz, (String)object, classArray);
    }

    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.getBytesMethodBuilder;
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Object getRaw(GeneratedMessage generatedMessage) {
        Method method = this.getBytesMethod;
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, generatedMessage, objectArray);
    }

    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        boolean bl2 = object instanceof ByteString;
        if (bl2) {
            Method method = this.setBytesMethodBuilder;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
        } else {
            super.set(generatedMessage$Builder, object);
        }
    }
}

