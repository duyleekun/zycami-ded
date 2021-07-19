/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeVisitor;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public class TypeToken$4
extends TypeVisitor {
    public final /* synthetic */ TypeToken this$0;
    public final /* synthetic */ ImmutableSet$Builder val$builder;

    public TypeToken$4(TypeToken typeToken, ImmutableSet$Builder immutableSet$Builder) {
        this.this$0 = typeToken;
        this.val$builder = immutableSet$Builder;
    }

    public void visitClass(Class clazz) {
        this.val$builder.add(clazz);
    }

    public void visitGenericArrayType(GenericArrayType type) {
        ImmutableSet$Builder immutableSet$Builder = this.val$builder;
        type = Types.getArrayClass(TypeToken.of(type.getGenericComponentType()).getRawType());
        immutableSet$Builder.add(type);
    }

    public void visitParameterizedType(ParameterizedType type) {
        ImmutableSet$Builder immutableSet$Builder = this.val$builder;
        type = (Class)type.getRawType();
        immutableSet$Builder.add(type);
    }

    public void visitTypeVariable(TypeVariable typeArray) {
        typeArray = typeArray.getBounds();
        this.visit(typeArray);
    }

    public void visitWildcardType(WildcardType typeArray) {
        typeArray = typeArray.getUpperBounds();
        this.visit(typeArray);
    }
}

