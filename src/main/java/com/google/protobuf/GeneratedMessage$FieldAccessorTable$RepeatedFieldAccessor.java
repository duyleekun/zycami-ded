/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;
import java.util.List;

public class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    public final Method addRepeatedMethod;
    public final Method clearMethod;
    public final Method getCountMethod;
    public final Method getCountMethodBuilder;
    public final Method getMethod;
    public final Method getMethodBuilder;
    public final Method getRepeatedMethod;
    public final Method getRepeatedMethodBuilder;
    public final Method setRepeatedMethod;
    public final Class type;

    public GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class classArray2, Class clazz) {
        Class<Integer> clazz2;
        String string2 = "get";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        Object object2 = "List";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        Object object3 = new Class[]{};
        this.getMethod = object = GeneratedMessage.access$1100((Class)classArray2, (String)object, (Class[])object3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new Class[]{};
        this.getMethodBuilder = object = GeneratedMessage.access$1100(clazz, (String)object, object2);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        object = ((StringBuilder)object).toString();
        int n10 = 1;
        object3 = new Class[n10];
        object3[0] = clazz2 = Integer.TYPE;
        this.getRepeatedMethod = object = GeneratedMessage.access$1100((Class)classArray2, (String)object, (Class[])object3);
        super();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        Class[] classArray3 = new Class[n10];
        classArray3[0] = clazz2;
        this.getRepeatedMethodBuilder = object3 = GeneratedMessage.access$1100(clazz, (String)object3, classArray3);
        object = ((Method)object).getReturnType();
        this.type = object;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("set");
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        classArray3 = new Class[2];
        classArray3[0] = clazz2;
        classArray3[n10] = object;
        this.setRepeatedMethod = object3 = GeneratedMessage.access$1100(clazz, (String)object3, classArray3);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("add");
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        object2 = new Class[n10];
        object2[0] = object;
        object = GeneratedMessage.access$1100(clazz, (String)object3, object2);
        this.addRepeatedMethod = object;
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        object2 = "Count";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object3 = new Class[]{};
        this.getCountMethod = object = GeneratedMessage.access$1100((Class)classArray2, (String)object, (Class[])object3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        classArray2 = new Class[]{};
        this.getCountMethodBuilder = object = GeneratedMessage.access$1100(clazz, (String)object, classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("clear");
        ((StringBuilder)object).append((String)classArray);
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{};
        this.clearMethod = object = GeneratedMessage.access$1100(clazz, (String)object, classArray);
    }

    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        Method method = this.addRepeatedMethod;
        Object[] objectArray = new Object[]{object};
        GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public void clear(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.clearMethod;
        Object[] objectArray = new Object[]{};
        GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.getMethodBuilder;
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Object get(GeneratedMessage generatedMessage) {
        Method method = this.getMethod;
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, generatedMessage, objectArray);
    }

    public Message$Builder getBuilder(GeneratedMessage$Builder object) {
        object = new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }

    public Object getRaw(GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }

    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n10) {
        Method method = this.getRepeatedMethodBuilder;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public Object getRepeated(GeneratedMessage generatedMessage, int n10) {
        Method method = this.getRepeatedMethod;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return GeneratedMessage.access$1200(method, generatedMessage, objectArray);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.getCountMethodBuilder;
        Object[] objectArray = new Object[]{};
        return (Integer)GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public int getRepeatedCount(GeneratedMessage generatedMessage) {
        Method method = this.getCountMethod;
        Object[] objectArray = new Object[]{};
        return (Integer)GeneratedMessage.access$1200(method, generatedMessage, objectArray);
    }

    public Object getRepeatedRaw(GeneratedMessage$Builder generatedMessage$Builder, int n10) {
        return this.getRepeated(generatedMessage$Builder, n10);
    }

    public Object getRepeatedRaw(GeneratedMessage generatedMessage, int n10) {
        return this.getRepeated(generatedMessage, n10);
    }

    public boolean has(GeneratedMessage$Builder object) {
        object = new UnsupportedOperationException("hasField() called on a repeated field.");
        throw object;
    }

    public boolean has(GeneratedMessage serializable) {
        serializable = new UnsupportedOperationException("hasField() called on a repeated field.");
        throw serializable;
    }

    public Message$Builder newBuilder() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        throw unsupportedOperationException;
    }

    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object iterator2) {
        boolean bl2;
        this.clear(generatedMessage$Builder);
        iterator2 = ((List)((Object)iterator2)).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.addRepeated(generatedMessage$Builder, e10);
        }
    }

    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n10, Object object) {
        Method method = this.setRepeatedMethod;
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object;
        GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }
}

