/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$MethodInvoker;
import com.google.protobuf.Internal$EnumLite;
import java.lang.reflect.Method;

public final class GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker
implements GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$MethodInvoker {
    public final Method caseMethod;
    public final Method caseMethodBuilder;
    public final Method clearMethod;
    public final Method getMethod;
    public final Method getMethodBuilder;
    public final Method hasMethod;
    public final Method hasMethodBuilder;
    public final Method setMethod;

    public GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor$ReflectionInvoker(Descriptors$FieldDescriptor object, String object2, Class clazz, Class clazz2, String string2, boolean bl2, boolean bl3) {
        CharSequence charSequence;
        String string3 = "get";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        Object object3 = new Class[]{};
        this.getMethod = object = GeneratedMessageV3.access$1000(clazz, (String)object, (Class[])object3);
        super();
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        Object object4 = new Class[]{};
        this.getMethodBuilder = object3 = GeneratedMessageV3.access$1000(clazz2, (String)object3, (Class[])object4);
        object = ((Method)object).getReturnType();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("set");
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        int n10 = 1;
        object4 = new Class[n10];
        object4[0] = object;
        object = GeneratedMessageV3.access$1000(clazz2, (String)object3, (Class[])object4);
        this.setMethod = object;
        object = "has";
        object3 = null;
        if (bl3) {
            super();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append((String)object2);
            object4 = ((StringBuilder)object4).toString();
            Class[] classArray = new Class[]{};
            object4 = GeneratedMessageV3.access$1000(clazz, (String)object4, classArray);
        } else {
            n10 = 0;
            object4 = null;
        }
        this.hasMethod = object4;
        if (bl3) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object2);
            object = ((StringBuilder)charSequence).toString();
            charSequence = new Class[]{};
            object = GeneratedMessageV3.access$1000(clazz2, (String)object, (Class[])charSequence);
        } else {
            object = null;
        }
        this.hasMethodBuilder = object;
        object = new StringBuilder();
        charSequence = "clear";
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new Class[]{};
        this.clearMethod = object = GeneratedMessageV3.access$1000(clazz2, (String)object, (Class[])object2);
        object = "Case";
        if (bl2) {
            super();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            charSequence = new Class[]{};
            object2 = GeneratedMessageV3.access$1000(clazz, (String)object2, (Class[])charSequence);
        } else {
            object2 = null;
        }
        this.caseMethod = object2;
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = new Class[]{};
            object3 = GeneratedMessageV3.access$1000(clazz2, (String)object, (Class[])object2);
        }
        this.caseMethodBuilder = object3;
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

    public int getOneofFieldNumber(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.caseMethodBuilder;
        Object[] objectArray = new Object[]{};
        return ((Internal$EnumLite)GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray)).getNumber();
    }

    public int getOneofFieldNumber(GeneratedMessageV3 generatedMessageV3) {
        Method method = this.caseMethod;
        Object[] objectArray = new Object[]{};
        return ((Internal$EnumLite)GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray)).getNumber();
    }

    public boolean has(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        Method method = this.hasMethodBuilder;
        Object[] objectArray = new Object[]{};
        return (Boolean)GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }

    public boolean has(GeneratedMessageV3 generatedMessageV3) {
        Method method = this.hasMethod;
        Object[] objectArray = new Object[]{};
        return (Boolean)GeneratedMessageV3.access$1100(method, generatedMessageV3, objectArray);
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object object) {
        Method method = this.setMethod;
        Object[] objectArray = new Object[]{object};
        GeneratedMessageV3.access$1100(method, generatedMessageV3$Builder, objectArray);
    }
}

