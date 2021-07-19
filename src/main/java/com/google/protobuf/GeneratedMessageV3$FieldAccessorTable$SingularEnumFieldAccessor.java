/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor;
import java.lang.reflect.Method;

public final class GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor
extends GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor {
    private Descriptors$EnumDescriptor enumDescriptor;
    private Method getValueDescriptorMethod;
    private Method getValueMethod;
    private Method getValueMethodBuilder;
    private Method setValueMethod;
    private boolean supportUnknownEnumValue;
    private Method valueOfMethod;

    public GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor(Descriptors$FieldDescriptor object, String classArray, Class object2, Class clazz, String object3) {
        super((Descriptors$FieldDescriptor)object, (String)classArray, (Class)object2, clazz, (String)object3);
        boolean bl2;
        this.enumDescriptor = object3 = ((Descriptors$FieldDescriptor)object).getEnumType();
        object3 = this.type;
        int n10 = 1;
        Object object4 = new Class[n10];
        object4[0] = Descriptors$EnumValueDescriptor.class;
        this.valueOfMethod = object3 = GeneratedMessageV3.access$1000((Class)object3, "valueOf", object4);
        object3 = this.type;
        object4 = new Class[]{};
        Class[] classArray2 = "getValueDescriptor";
        this.getValueDescriptorMethod = object3 = GeneratedMessageV3.access$1000((Class)object3, (String)classArray2, object4);
        object = ((Descriptors$FieldDescriptor)object).getFile();
        this.supportUnknownEnumValue = bl2 = ((Descriptors$FileDescriptor)object).supportsUnknownEnumValue();
        if (bl2) {
            object = new StringBuilder();
            object3 = "get";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append((String)classArray);
            object4 = "Value";
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            classArray2 = new Class[]{};
            this.getValueMethod = object = GeneratedMessageV3.access$1000((Class)object2, (String)object, classArray2);
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            object2 = new Class[]{};
            this.getValueMethodBuilder = object = GeneratedMessageV3.access$1000(clazz, (String)object, object2);
            object = new StringBuilder();
            ((StringBuilder)object).append("set");
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            classArray = new Class[n10];
            classArray[0] = object2 = Integer.TYPE;
            this.setValueMethod = object = GeneratedMessageV3.access$1000(clazz, (String)object, classArray);
        }
    }

    public Object get(GeneratedMessageV3$Builder object) {
        boolean bl2 = this.supportUnknownEnumValue;
        Object[] objectArray = null;
        if (bl2) {
            Method method = this.getValueMethodBuilder;
            objectArray = new Object[]{};
            int n10 = (Integer)GeneratedMessageV3.access$1100(method, object, objectArray);
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n10);
        }
        Method method = this.getValueDescriptorMethod;
        object = super.get((GeneratedMessageV3$Builder)object);
        objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, object, objectArray);
    }

    public Object get(GeneratedMessageV3 object) {
        boolean bl2 = this.supportUnknownEnumValue;
        Object[] objectArray = null;
        if (bl2) {
            Method method = this.getValueMethod;
            objectArray = new Object[]{};
            int n10 = (Integer)GeneratedMessageV3.access$1100(method, object, objectArray);
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n10);
        }
        Method method = this.getValueDescriptorMethod;
        object = super.get((GeneratedMessageV3)object);
        objectArray = new Object[]{};
        return GeneratedMessageV3.access$1100(method, object, objectArray);
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        boolean bl2 = this.supportUnknownEnumValue;
        int n10 = 1;
        if (bl2) {
            Method method = this.setValueMethod;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = Integer.valueOf(((Descriptors$EnumValueDescriptor)object).getNumber());
            GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
            return;
        }
        Method method = this.valueOfMethod;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = GeneratedMessageV3.access$1100(method, null, objectArray);
        super.set(generatedMessageV3$Builder, object);
    }
}

