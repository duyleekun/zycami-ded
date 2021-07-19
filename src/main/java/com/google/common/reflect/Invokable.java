/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.reflect.Element;
import com.google.common.reflect.Invokable$ConstructorInvokable;
import com.google.common.reflect.Invokable$MethodInvokable;
import com.google.common.reflect.Parameter;
import com.google.common.reflect.TypeToken;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public abstract class Invokable
extends Element
implements GenericDeclaration {
    public Invokable(AccessibleObject accessibleObject) {
        super(accessibleObject);
    }

    public static Invokable from(Constructor constructor) {
        Invokable$ConstructorInvokable invokable$ConstructorInvokable = new Invokable$ConstructorInvokable(constructor);
        return invokable$ConstructorInvokable;
    }

    public static Invokable from(Method method) {
        Invokable$MethodInvokable invokable$MethodInvokable = new Invokable$MethodInvokable(method);
        return invokable$MethodInvokable;
    }

    public final Class getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public final ImmutableList getExceptionTypes() {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        Type[] typeArray = this.getGenericExceptionTypes();
        int n10 = typeArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            TypeToken typeToken = TypeToken.of(typeArray[i10]);
            immutableList$Builder.add(typeToken);
        }
        return immutableList$Builder.build();
    }

    public abstract Type[] getGenericExceptionTypes();

    public abstract Type[] getGenericParameterTypes();

    public abstract Type getGenericReturnType();

    public TypeToken getOwnerType() {
        return TypeToken.of(this.getDeclaringClass());
    }

    public abstract Annotation[][] getParameterAnnotations();

    public final ImmutableList getParameters() {
        int n10;
        Type[] typeArray = this.getGenericParameterTypes();
        Annotation[][] annotationArray = this.getParameterAnnotations();
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        for (int i10 = 0; i10 < (n10 = typeArray.length); ++i10) {
            TypeToken typeToken = TypeToken.of(typeArray[i10]);
            Annotation[] annotationArray2 = annotationArray[i10];
            Parameter parameter = new Parameter(this, i10, typeToken, annotationArray2);
            immutableList$Builder.add(parameter);
        }
        return immutableList$Builder.build();
    }

    public final TypeToken getReturnType() {
        return TypeToken.of(this.getGenericReturnType());
    }

    public final Object invoke(Object object, Object ... objectArray) {
        objectArray = (Object[])Preconditions.checkNotNull(objectArray);
        return this.invokeInternal(object, objectArray);
    }

    public abstract Object invokeInternal(Object var1, Object[] var2);

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    public final Invokable returning(TypeToken object) {
        Serializable serializable = this.getReturnType();
        boolean bl2 = ((TypeToken)object).isSupertypeOf((TypeToken)serializable);
        if (bl2) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invokable is known to return ");
        TypeToken typeToken = this.getReturnType();
        stringBuilder.append(typeToken);
        stringBuilder.append(", not ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        serializable = new IllegalArgumentException((String)object);
        throw serializable;
    }

    public final Invokable returning(Class serializable) {
        serializable = TypeToken.of(serializable);
        return this.returning((TypeToken)serializable);
    }
}

