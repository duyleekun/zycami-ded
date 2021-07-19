/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class Invokable$ConstructorInvokable
extends Invokable {
    public final Constructor constructor;

    public Invokable$ConstructorInvokable(Constructor constructor) {
        super(constructor);
        this.constructor = constructor;
    }

    private boolean mayNeedHiddenThis() {
        boolean bl2;
        Class clazz = this.constructor.getDeclaringClass();
        GenericDeclaration genericDeclaration = clazz.getEnclosingConstructor();
        boolean bl3 = true;
        if (genericDeclaration != null) {
            return bl3;
        }
        genericDeclaration = clazz.getEnclosingMethod();
        if (genericDeclaration != null) {
            return Modifier.isStatic(((Method)genericDeclaration).getModifiers()) ^ bl3;
        }
        genericDeclaration = clazz.getEnclosingClass();
        if (genericDeclaration == null || (bl2 = Modifier.isStatic(clazz.getModifiers()))) {
            bl3 = false;
        }
        return bl3;
    }

    public Type[] getGenericExceptionTypes() {
        return this.constructor.getGenericExceptionTypes();
    }

    public Type[] getGenericParameterTypes() {
        Object object;
        int n10;
        int n11;
        Type[] typeArray = this.constructor.getGenericParameterTypes();
        int n12 = typeArray.length;
        if (n12 > 0 && (n12 = (int)(this.mayNeedHiddenThis() ? 1 : 0)) != 0 && (n11 = typeArray.length) == (n10 = ((Class<?>[])(object = this.constructor.getParameterTypes())).length)) {
            n11 = 0;
            Class<?> clazz = this.getDeclaringClass().getEnclosingClass();
            if ((object = object[0]) == clazz) {
                n12 = 1;
                n11 = typeArray.length;
                typeArray = Arrays.copyOfRange(typeArray, n12, n11);
            }
        }
        return typeArray;
    }

    public Type getGenericReturnType() {
        Type type = this.getDeclaringClass();
        Type[] typeArray = type.getTypeParameters();
        int n10 = typeArray.length;
        if (n10 > 0) {
            type = Types.newParameterizedType(type, typeArray);
        }
        return type;
    }

    public final Annotation[][] getParameterAnnotations() {
        return this.constructor.getParameterAnnotations();
    }

    public final TypeVariable[] getTypeParameters() {
        TypeVariable<Class<T>>[] typeVariableArray = this.getDeclaringClass().getTypeParameters();
        TypeVariable<Constructor<T>>[] typeVariableArray2 = this.constructor.getTypeParameters();
        int n10 = typeVariableArray.length;
        int n11 = typeVariableArray2.length;
        TypeVariable[] typeVariableArray3 = new TypeVariable[n10 + n11];
        n11 = typeVariableArray.length;
        System.arraycopy(typeVariableArray, 0, typeVariableArray3, 0, n11);
        int n12 = typeVariableArray.length;
        n11 = typeVariableArray2.length;
        System.arraycopy(typeVariableArray2, 0, typeVariableArray3, n12, n11);
        return typeVariableArray3;
    }

    public final Object invokeInternal(Object object, Object[] objectArray) {
        try {
            object = this.constructor;
        }
        catch (InstantiationException instantiationException) {
            CharSequence charSequence = new StringBuilder();
            Constructor constructor = this.constructor;
            charSequence.append(constructor);
            charSequence.append(" failed.");
            charSequence = charSequence.toString();
            objectArray = new RuntimeException((String)charSequence, instantiationException);
            throw objectArray;
        }
        return ((Constructor)object).newInstance(objectArray);
    }

    public final boolean isOverridable() {
        return false;
    }

    public final boolean isVarArgs() {
        return this.constructor.isVarArgs();
    }
}

