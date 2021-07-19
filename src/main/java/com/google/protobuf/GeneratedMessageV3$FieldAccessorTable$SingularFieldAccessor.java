/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$MethodInvoker;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker;
import com.google.protobuf.Message$Builder;

public class GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor
implements GeneratedMessageV3$FieldAccessorTable$FieldAccessor {
    public final Descriptors$FieldDescriptor field;
    public final boolean hasHasMethod;
    public final GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$MethodInvoker invoker;
    public final boolean isOneofField;
    public final Class type;

    public GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string2, Class clazz, Class clazz2, String string3) {
        Object object;
        GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor generatedMessageV3$FieldAccessorTable$SingularFieldAccessor = this;
        Object object2 = descriptors$FieldDescriptor.getContainingOneof();
        boolean bl2 = true;
        boolean bl3 = object2 != null ? bl2 : false;
        generatedMessageV3$FieldAccessorTable$SingularFieldAccessor.isOneofField = bl3;
        object2 = descriptors$FieldDescriptor.getFile();
        boolean bl4 = GeneratedMessageV3$FieldAccessorTable.access$1200((Descriptors$FileDescriptor)object2);
        boolean bl5 = !bl4 && (bl3 || (object2 = descriptors$FieldDescriptor.getJavaType()) != (object = Descriptors$FieldDescriptor$JavaType.MESSAGE)) ? false : bl2;
        generatedMessageV3$FieldAccessorTable$SingularFieldAccessor.hasHasMethod = bl5;
        object = object2;
        super(descriptors$FieldDescriptor, string2, clazz, clazz2, string3, bl3, bl5);
        Object object3 = descriptors$FieldDescriptor;
        generatedMessageV3$FieldAccessorTable$SingularFieldAccessor.field = descriptors$FieldDescriptor;
        generatedMessageV3$FieldAccessorTable$SingularFieldAccessor.type = object3 = ((GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker)object2).getMethod.getReturnType();
        object2 = GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor.getMethodInvoker((GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker)object2);
        generatedMessageV3$FieldAccessorTable$SingularFieldAccessor.invoker = object2;
    }

    public static GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$MethodInvoker getMethodInvoker(GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker generatedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker) {
        return generatedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker;
    }

    public void addRepeated(GeneratedMessageV3$Builder object, Object object2) {
        object = new UnsupportedOperationException("addRepeatedField() called on a singular field.");
        throw object;
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

    public Object getRepeated(GeneratedMessageV3$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        throw object;
    }

    public Object getRepeated(GeneratedMessageV3 serializable, int n10) {
        serializable = new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        throw serializable;
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessageV3$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessageV3$Builder object) {
        object = new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessageV3 serializable) {
        serializable = new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        throw serializable;
    }

    public Object getRepeatedRaw(GeneratedMessageV3$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
        throw object;
    }

    public Object getRepeatedRaw(GeneratedMessageV3 serializable, int n10) {
        serializable = new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
        throw serializable;
    }

    public boolean has(GeneratedMessageV3$Builder object) {
        int n10 = this.hasHasMethod;
        if (n10 == 0) {
            n10 = this.isOneofField;
            boolean bl2 = true;
            if (n10 != 0) {
                Descriptors$FieldDescriptor descriptors$FieldDescriptor;
                int n11 = this.invoker.getOneofFieldNumber((GeneratedMessageV3$Builder)object);
                if (n11 != (n10 = (descriptors$FieldDescriptor = this.field).getNumber())) {
                    bl2 = false;
                }
                return bl2;
            }
            object = this.get((GeneratedMessageV3$Builder)object);
            Object object2 = this.field.getDefaultValue();
            return object.equals(object2) ^ bl2;
        }
        return this.invoker.has((GeneratedMessageV3$Builder)object);
    }

    public boolean has(GeneratedMessageV3 object) {
        int n10 = this.hasHasMethod;
        if (n10 == 0) {
            n10 = this.isOneofField;
            boolean bl2 = true;
            if (n10 != 0) {
                Descriptors$FieldDescriptor descriptors$FieldDescriptor;
                int n11 = this.invoker.getOneofFieldNumber((GeneratedMessageV3)object);
                if (n11 != (n10 = (descriptors$FieldDescriptor = this.field).getNumber())) {
                    bl2 = false;
                }
                return bl2;
            }
            object = this.get((GeneratedMessageV3)object);
            Object object2 = this.field.getDefaultValue();
            return object.equals(object2) ^ bl2;
        }
        return this.invoker.has((GeneratedMessageV3)object);
    }

    public Message$Builder newBuilder() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        throw unsupportedOperationException;
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        this.invoker.set(generatedMessageV3$Builder, object);
    }

    public void setRepeated(GeneratedMessageV3$Builder object, int n10, Object object2) {
        object = new UnsupportedOperationException("setRepeatedField() called on a singular field.");
        throw object;
    }
}

