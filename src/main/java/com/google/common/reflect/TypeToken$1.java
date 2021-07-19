/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Invokable$MethodInvokable;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TypeToken$1
extends Invokable$MethodInvokable {
    public final /* synthetic */ TypeToken this$0;

    public TypeToken$1(TypeToken typeToken, Method method) {
        this.this$0 = typeToken;
        super(method);
    }

    public Type[] getGenericExceptionTypes() {
        TypeResolver typeResolver = TypeToken.access$000(this.this$0);
        Type[] typeArray = super.getGenericExceptionTypes();
        return typeResolver.resolveTypesInPlace(typeArray);
    }

    public Type[] getGenericParameterTypes() {
        TypeResolver typeResolver = TypeToken.access$100(this.this$0);
        Type[] typeArray = super.getGenericParameterTypes();
        return typeResolver.resolveTypesInPlace(typeArray);
    }

    public Type getGenericReturnType() {
        TypeResolver typeResolver = TypeToken.access$000(this.this$0);
        Type type = super.getGenericReturnType();
        return typeResolver.resolveType(type);
    }

    public TypeToken getOwnerType() {
        return this.this$0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getOwnerType();
        stringBuilder.append(object);
        stringBuilder.append(".");
        object = super.toString();
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }
}

