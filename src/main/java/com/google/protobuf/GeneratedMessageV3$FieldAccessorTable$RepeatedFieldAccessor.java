/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$MethodInvoker;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker;
import com.google.protobuf.Message$Builder;
import java.util.List;

public class GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor
implements GeneratedMessageV3$FieldAccessorTable$FieldAccessor {
    public final GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$MethodInvoker invoker;
    public final Class type;

    public GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor(Descriptors$FieldDescriptor object, String string2, Class clazz, Class clazz2) {
        GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker generatedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker = new GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker((Descriptors$FieldDescriptor)object, string2, clazz, clazz2);
        this.type = object = generatedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker.getRepeatedMethod.getReturnType();
        this.invoker = object = GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor.getMethodInvoker(generatedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker);
    }

    public static GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$MethodInvoker getMethodInvoker(GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker generatedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker) {
        return generatedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker;
    }

    public void addRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        this.invoker.addRepeated(generatedMessageV3$Builder, object);
    }

    public void clear(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        this.invoker.clear(generatedMessageV3$Builder);
    }

    public Object get(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return this.invoker.get(generatedMessageV3$Builder);
    }

    public Object get(GeneratedMessageV3 generatedMessageV3) {
        return this.invoker.get(generatedMessageV3);
    }

    public Message$Builder getBuilder(GeneratedMessageV3$Builder object) {
        object = new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public Object getRaw(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return this.get(generatedMessageV3$Builder);
    }

    public Object getRaw(GeneratedMessageV3 generatedMessageV3) {
        return this.get(generatedMessageV3);
    }

    public Object getRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        return this.invoker.getRepeated(generatedMessageV3$Builder, n10);
    }

    public Object getRepeated(GeneratedMessageV3 generatedMessageV3, int n10) {
        return this.invoker.getRepeated(generatedMessageV3, n10);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessageV3$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return this.invoker.getRepeatedCount(generatedMessageV3$Builder);
    }

    public int getRepeatedCount(GeneratedMessageV3 generatedMessageV3) {
        return this.invoker.getRepeatedCount(generatedMessageV3);
    }

    public Object getRepeatedRaw(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        return this.getRepeated(generatedMessageV3$Builder, n10);
    }

    public Object getRepeatedRaw(GeneratedMessageV3 generatedMessageV3, int n10) {
        return this.getRepeated(generatedMessageV3, n10);
    }

    public boolean has(GeneratedMessageV3$Builder object) {
        object = new UnsupportedOperationException("hasField() called on a repeated field.");
        throw object;
    }

    public boolean has(GeneratedMessageV3 serializable) {
        serializable = new UnsupportedOperationException("hasField() called on a repeated field.");
        throw serializable;
    }

    public Message$Builder newBuilder() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        throw unsupportedOperationException;
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object iterator2) {
        boolean bl2;
        this.clear(generatedMessageV3$Builder);
        iterator2 = ((List)((Object)iterator2)).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.addRepeated(generatedMessageV3$Builder, e10);
        }
    }

    public void setRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10, Object object) {
        this.invoker.setRepeated(generatedMessageV3$Builder, n10, object);
    }
}

