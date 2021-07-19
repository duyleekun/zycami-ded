/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

public class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    public final Method caseMethod;
    public final Method caseMethodBuilder;
    public final Method clearMethod;
    public final Descriptors$FieldDescriptor field;
    public final Method getMethod;
    public final Method getMethodBuilder;
    public final boolean hasHasMethod;
    public final Method hasMethod;
    public final Method hasMethodBuilder;
    public final boolean isOneofField;
    public final Method setMethod;
    public final Class type;

    public GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(Descriptors$FieldDescriptor object, String object2, Class clazz, Class clazz2, String string2) {
        int n10;
        int n11;
        this.field = object;
        Descriptors$OneofDescriptor descriptors$OneofDescriptor = ((Descriptors$FieldDescriptor)object).getContainingOneof();
        int n12 = 1;
        if (descriptors$OneofDescriptor != null) {
            n11 = n12;
        } else {
            n11 = 0;
            descriptors$OneofDescriptor = null;
        }
        this.isOneofField = n11;
        Object object3 = ((Descriptors$FieldDescriptor)object).getFile();
        boolean bl2 = GeneratedMessage$FieldAccessorTable.access$1300((Descriptors$FileDescriptor)object3);
        if (!(bl2 || n11 == 0 && (object = ((Descriptors$FieldDescriptor)object).getJavaType()) == (object3 = Descriptors$FieldDescriptor$JavaType.MESSAGE))) {
            n10 = 0;
            object = null;
        } else {
            n10 = n12;
        }
        this.hasHasMethod = n10;
        String string3 = "get";
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        Object object4 = new Class[]{};
        this.getMethod = object3 = GeneratedMessage.access$1100(clazz, (String)object3, (Class[])object4);
        super();
        ((StringBuilder)object4).append(string3);
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        Class[] classArray = new Class[]{};
        this.getMethodBuilder = object4 = GeneratedMessage.access$1100(clazz2, (String)object4, classArray);
        this.type = object3 = ((Method)object3).getReturnType();
        object4 = new StringBuilder();
        classArray = "set";
        ((StringBuilder)object4).append((String)classArray);
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        Class[] classArray2 = new Class[n12];
        classArray2[0] = object3;
        this.setMethod = classArray2 = GeneratedMessage.access$1100(clazz2, (String)object4, classArray2);
        classArray2 = "has";
        bl2 = false;
        object3 = null;
        if (n10 != 0) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)classArray2);
            ((StringBuilder)object4).append((String)object2);
            object4 = ((StringBuilder)object4).toString();
            classArray = new Class[]{};
            object4 = GeneratedMessage.access$1100(clazz, (String)object4, classArray);
        } else {
            object4 = null;
        }
        this.hasMethod = object4;
        if (n10 != 0) {
            super();
            ((StringBuilder)object).append((String)classArray2);
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            classArray2 = new Class[]{};
            object = GeneratedMessage.access$1100(clazz2, (String)object, classArray2);
        } else {
            n10 = 0;
            object = null;
        }
        this.hasMethodBuilder = object;
        object = new StringBuilder();
        classArray2 = "clear";
        ((StringBuilder)object).append((String)classArray2);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new Class[]{};
        this.clearMethod = object = GeneratedMessage.access$1100(clazz2, (String)object, (Class[])object2);
        object = "Case";
        if (n11 != 0) {
            super();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            classArray2 = new Class[]{};
            object2 = GeneratedMessage.access$1100(clazz, (String)object2, classArray2);
        } else {
            object2 = null;
        }
        this.caseMethod = object2;
        if (n11 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = new Class[]{};
            object3 = GeneratedMessage.access$1100(clazz2, (String)object, (Class[])object2);
        }
        this.caseMethodBuilder = object3;
    }

    private int getOneofFieldNumber(GeneratedMessage$Builder generatedMessage$Builder) {
        Method method = this.caseMethodBuilder;
        Object[] objectArray = new Object[]{};
        return ((Internal$EnumLite)GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray)).getNumber();
    }

    private int getOneofFieldNumber(GeneratedMessage generatedMessage) {
        Method method = this.caseMethod;
        Object[] objectArray = new Object[]{};
        return ((Internal$EnumLite)GeneratedMessage.access$1200(method, generatedMessage, objectArray)).getNumber();
    }

    public void addRepeated(GeneratedMessage$Builder object, Object object2) {
        object = new UnsupportedOperationException("addRepeatedField() called on a singular field.");
        throw object;
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

    public Object getRepeated(GeneratedMessage$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        throw object;
    }

    public Object getRepeated(GeneratedMessage serializable, int n10) {
        serializable = new UnsupportedOperationException("getRepeatedField() called on a singular field.");
        throw serializable;
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessage$Builder object) {
        object = new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessage serializable) {
        serializable = new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
        throw serializable;
    }

    public Object getRepeatedRaw(GeneratedMessage$Builder object, int n10) {
        object = new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
        throw object;
    }

    public Object getRepeatedRaw(GeneratedMessage serializable, int n10) {
        serializable = new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
        throw serializable;
    }

    public boolean has(GeneratedMessage$Builder object) {
        int n10 = this.hasHasMethod;
        boolean bl2 = false;
        Object[] objectArray = null;
        if (n10 == 0) {
            n10 = this.isOneofField;
            boolean bl3 = true;
            if (n10 != 0) {
                Descriptors$FieldDescriptor descriptors$FieldDescriptor;
                int n11 = this.getOneofFieldNumber((GeneratedMessage$Builder)object);
                if (n11 == (n10 = (descriptors$FieldDescriptor = this.field).getNumber())) {
                    bl2 = bl3;
                }
                return bl2;
            }
            object = this.get((GeneratedMessage$Builder)object);
            Object object2 = this.field.getDefaultValue();
            return object.equals(object2) ^ bl3;
        }
        Method method = this.hasMethodBuilder;
        objectArray = new Object[]{};
        return (Boolean)GeneratedMessage.access$1200(method, object, objectArray);
    }

    public boolean has(GeneratedMessage object) {
        int n10 = this.hasHasMethod;
        boolean bl2 = false;
        Object[] objectArray = null;
        if (n10 == 0) {
            n10 = this.isOneofField;
            boolean bl3 = true;
            if (n10 != 0) {
                Descriptors$FieldDescriptor descriptors$FieldDescriptor;
                int n11 = this.getOneofFieldNumber((GeneratedMessage)object);
                if (n11 == (n10 = (descriptors$FieldDescriptor = this.field).getNumber())) {
                    bl2 = bl3;
                }
                return bl2;
            }
            object = this.get((GeneratedMessage)object);
            Object object2 = this.field.getDefaultValue();
            return object.equals(object2) ^ bl3;
        }
        Method method = this.hasMethod;
        objectArray = new Object[]{};
        return (Boolean)GeneratedMessage.access$1200(method, object, objectArray);
    }

    public Message$Builder newBuilder() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
        throw unsupportedOperationException;
    }

    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        Method method = this.setMethod;
        Object[] objectArray = new Object[]{object};
        GeneratedMessage.access$1200(method, generatedMessage$Builder, objectArray);
    }

    public void setRepeated(GeneratedMessage$Builder object, int n10, Object object2) {
        object = new UnsupportedOperationException("setRepeatedField() called on a singular field.");
        throw object;
    }
}

