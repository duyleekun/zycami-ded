/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor;
import java.lang.reflect.Method;

public final class GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor
extends GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor {
    private final Method getBytesMethod;
    private final Method getBytesMethodBuilder;
    private final Method setBytesMethodBuilder;

    public GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class classArray2, Class clazz, String string2) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, (Class)classArray2, clazz, string2);
        super();
        string2 = "get";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        String string3 = "Bytes";
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Class[] classArray3 = new Class[]{};
        this.getBytesMethod = object = GeneratedMessageV3.access$1000((Class)classArray2, (String)object, classArray3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        classArray2 = new Class[]{};
        this.getBytesMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("set");
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{ByteString.class};
        this.setBytesMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray);
    }

    public Object getRaw(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.getBytesMethodBuilder;
        Object[] objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Object getRaw(GeneratedMessageV3 generatedMessageV3) {
        Method method = this.getBytesMethod;
        Object[] objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray);
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        boolean bl2 = object instanceof ByteString;
        if (bl2) {
            Method method = this.setBytesMethodBuilder;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
        } else {
            super.set(generatedMessageV3$Builder, object);
        }
    }
}

