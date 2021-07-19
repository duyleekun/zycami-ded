/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Invokable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Invokable$MethodInvokable
extends Invokable {
    public final Method method;

    public Invokable$MethodInvokable(Method method) {
        super(method);
        this.method = method;
    }

    public Type[] getGenericExceptionTypes() {
        return this.method.getGenericExceptionTypes();
    }

    public Type[] getGenericParameterTypes() {
        return this.method.getGenericParameterTypes();
    }

    public Type getGenericReturnType() {
        return this.method.getGenericReturnType();
    }

    public final Annotation[][] getParameterAnnotations() {
        return this.method.getParameterAnnotations();
    }

    public final TypeVariable[] getTypeParameters() {
        return this.method.getTypeParameters();
    }

    public final Object invokeInternal(Object object, Object[] objectArray) {
        return this.method.invoke(object, objectArray);
    }

    public final boolean isOverridable() {
        Class clazz;
        boolean bl2 = this.isFinal();
        if (!(bl2 || (bl2 = this.isPrivate()) || (bl2 = this.isStatic()) || (bl2 = Modifier.isFinal((clazz = this.getDeclaringClass()).getModifiers())))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public final boolean isVarArgs() {
        return this.method.isVarArgs();
    }
}

