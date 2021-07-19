/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor
extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
    private Method addRepeatedValueMethod;
    private Descriptors$EnumDescriptor enumDescriptor;
    private Method getRepeatedValueMethod;
    private Method getRepeatedValueMethodBuilder;
    private final Method getValueDescriptorMethod;
    private Method setRepeatedValueMethod;
    private boolean supportUnknownEnumValue;
    private final Method valueOfMethod;

    public GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class object2, Class clazz) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, (Class)object2, clazz);
        boolean bl2;
        Object object3 = ((Descriptors$FieldDescriptor)object).getEnumType();
        this.enumDescriptor = object3;
        object3 = this.type;
        int n10 = 1;
        Object object4 = new Class[n10];
        object4[0] = Descriptors$EnumValueDescriptor.class;
        this.valueOfMethod = object3 = GeneratedMessage.access$1100((Class)object3, "valueOf", object4);
        object3 = this.type;
        object4 = new Class[]{};
        Class[] classArray2 = "getValueDescriptor";
        this.getValueDescriptorMethod = object3 = GeneratedMessage.access$1100((Class)object3, (String)classArray2, object4);
        object = ((Descriptors$FieldDescriptor)object).getFile();
        this.supportUnknownEnumValue = bl2 = ((Descriptors$FileDescriptor)object).supportsUnknownEnumValue();
        if (bl2) {
            Class<Integer> clazz2;
            object = new StringBuilder();
            object3 = "get";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append((String)classArray);
            object4 = "Value";
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            classArray2 = new Class[n10];
            classArray2[0] = clazz2 = Integer.TYPE;
            this.getRepeatedValueMethod = object = GeneratedMessage.access$1100((Class)object2, (String)object, classArray2);
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            object2 = new Class[n10];
            object2[0] = clazz2;
            this.getRepeatedValueMethodBuilder = object = GeneratedMessage.access$1100(clazz, (String)object, object2);
            object = new StringBuilder();
            ((StringBuilder)object).append("set");
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            int n11 = 2;
            object2 = new Class[n11];
            object2[0] = clazz2;
            object2[n10] = clazz2;
            this.setRepeatedValueMethod = object = GeneratedMessage.access$1100(clazz, (String)object, object2);
            object = new StringBuilder();
            object2 = "add";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            classArray = new Class[n10];
            classArray[0] = clazz2;
            this.addRepeatedValueMethod = object = GeneratedMessage.access$1100(clazz, (String)object, classArray);
        }
    }

    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        boolean bl2 = this.supportUnknownEnumValue;
        int n10 = 1;
        if (bl2) {
            Method method = this.addRepeatedValueMethod;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = Integer.valueOf(((Descriptors$EnumValueDescriptor)object).getNumber());
            GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
            return;
        }
        Method method = this.valueOfMethod;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = GeneratedMessage.access$1200(method, null, objectArray);
        super.addRepeated(generatedMessage$Builder, object);
    }

    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = this.getRepeatedCount(generatedMessage$Builder);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.getRepeated(generatedMessage$Builder, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Object get(GeneratedMessage generatedMessage) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = this.getRepeatedCount(generatedMessage);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.getRepeated(generatedMessage, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Object getRepeated(GeneratedMessage$Builder object, int n10) {
        boolean bl2 = this.supportUnknownEnumValue;
        if (bl2) {
            Method method = this.getRepeatedValueMethodBuilder;
            Object[] objectArray = new Object[1];
            Integer n11 = n10;
            objectArray[0] = n11;
            int n12 = (Integer)GeneratedMessage.access$1200(method, object, objectArray);
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n12);
        }
        Method method = this.getValueDescriptorMethod;
        object = super.getRepeated((GeneratedMessage$Builder)object, n10);
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, object, objectArray);
    }

    public Object getRepeated(GeneratedMessage object, int n10) {
        boolean bl2 = this.supportUnknownEnumValue;
        if (bl2) {
            Method method = this.getRepeatedValueMethod;
            Object[] objectArray = new Object[1];
            Integer n11 = n10;
            objectArray[0] = n11;
            int n12 = (Integer)GeneratedMessage.access$1200(method, object, objectArray);
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n12);
        }
        Method method = this.getValueDescriptorMethod;
        object = super.getRepeated((GeneratedMessage)object, n10);
        Object[] objectArray = new Object[]{};
        return GeneratedMessage.access$1200(method, object, objectArray);
    }

    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n10, Object object) {
        boolean bl2 = this.supportUnknownEnumValue;
        int n11 = 1;
        if (bl2) {
            Method method = this.setRepeatedValueMethod;
            Object[] objectArray = new Object[2];
            Integer n12 = n10;
            objectArray[0] = n12;
            n12 = ((Descriptors$EnumValueDescriptor)object).getNumber();
            objectArray[n11] = n12;
            GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
            return;
        }
        Method method = this.valueOfMethod;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = GeneratedMessage.access$1200(method, null, objectArray);
        super.setRepeated(generatedMessage$Builder, n10, object);
    }
}

