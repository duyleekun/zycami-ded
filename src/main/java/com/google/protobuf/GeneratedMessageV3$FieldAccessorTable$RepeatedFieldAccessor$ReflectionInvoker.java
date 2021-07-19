/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$MethodInvoker;
import java.lang.reflect.Method;

public final class GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker
implements GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$MethodInvoker {
    public final Method addRepeatedMethod;
    public final Method clearMethod;
    public final Method getCountMethod;
    public final Method getCountMethodBuilder;
    public final Method getMethod;
    public final Method getMethodBuilder;
    public final Method getRepeatedMethod;
    public final Method getRepeatedMethodBuilder;
    public final Method setRepeatedMethod;

    public GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor$ReflectionInvoker(Descriptors$FieldDescriptor object, String classArray, Class classArray2, Class clazz) {
        Class<Integer> clazz2;
        String string2 = "get";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        Object object2 = "List";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        Object object3 = new Class[]{};
        this.getMethod = object = GeneratedMessageV3.access$1000((Class)classArray2, (String)object, (Class[])object3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new Class[]{};
        this.getMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, object2);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        object = ((StringBuilder)object).toString();
        int n10 = 1;
        object3 = new Class[n10];
        object3[0] = clazz2 = Integer.TYPE;
        this.getRepeatedMethod = object = GeneratedMessageV3.access$1000((Class)classArray2, (String)object, (Class[])object3);
        super();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        Class[] classArray3 = new Class[n10];
        classArray3[0] = clazz2;
        this.getRepeatedMethodBuilder = object3 = GeneratedMessageV3.access$1000(clazz, (String)object3, classArray3);
        object = ((Method)object).getReturnType();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("set");
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        classArray3 = new Class[2];
        classArray3[0] = clazz2;
        classArray3[n10] = object;
        this.setRepeatedMethod = object3 = GeneratedMessageV3.access$1000(clazz, (String)object3, classArray3);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("add");
        ((StringBuilder)object3).append((String)classArray);
        object3 = ((StringBuilder)object3).toString();
        object2 = new Class[n10];
        object2[0] = object;
        object = GeneratedMessageV3.access$1000(clazz, (String)object3, object2);
        this.addRepeatedMethod = object;
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        object2 = "Count";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object3 = new Class[]{};
        this.getCountMethod = object = GeneratedMessageV3.access$1000((Class)classArray2, (String)object, (Class[])object3);
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append((String)classArray);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        classArray2 = new Class[]{};
        this.getCountMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray2);
        object = new StringBuilder();
        ((StringBuilder)object).append("clear");
        ((StringBuilder)object).append((String)classArray);
        object = ((StringBuilder)object).toString();
        classArray = new Class[]{};
        this.clearMethod = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray);
    }

    public void addRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        Method method = this.addRepeatedMethod;
        Object[] objectArray = new Object[]{object};
        GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public void clear(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.clearMethod;
        Object[] objectArray = new Object[]{};
        GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Object get(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.getMethodBuilder;
        Object[] objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Object get(GeneratedMessageV3 generatedMessageV3) {
        Method method = this.getMethod;
        Object[] objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray);
    }

    public Object getRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        Method method = this.getRepeatedMethodBuilder;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public Object getRepeated(GeneratedMessageV3 generatedMessageV3, int n10) {
        Method method = this.getRepeatedMethod;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray);
    }

    public int getRepeatedCount(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.getCountMethodBuilder;
        Object[] objectArray = new Object[]{};
        return (Integer)GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public int getRepeatedCount(GeneratedMessageV3 generatedMessageV3) {
        Method method = this.getCountMethod;
        Object[] objectArray = new Object[]{};
        return (Integer)GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray);
    }

    public void setRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10, Object object) {
        Method method = this.setRepeatedMethod;
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object;
        GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }
}

