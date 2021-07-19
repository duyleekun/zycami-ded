/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeVisitor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public class TypeToken$3
extends TypeVisitor {
    public final /* synthetic */ TypeToken this$0;

    public TypeToken$3(TypeToken typeToken) {
        this.this$0 = typeToken;
    }

    public void visitGenericArrayType(GenericArrayType type) {
        Type[] typeArray = new Type[1];
        type = type.getGenericComponentType();
        typeArray[0] = type;
        this.visit(typeArray);
    }

    public void visitParameterizedType(ParameterizedType type) {
        Type[] typeArray = type.getActualTypeArguments();
        this.visit(typeArray);
        typeArray = new Type[1];
        type = type.getOwnerType();
        typeArray[0] = type;
        this.visit(typeArray);
    }

    public void visitTypeVariable(TypeVariable object) {
        CharSequence charSequence = new StringBuilder();
        Type type = TypeToken.access$500(this.this$0);
        charSequence.append(type);
        charSequence.append("contains a type variable and is not safe for the operation");
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public void visitWildcardType(WildcardType typeArray) {
        Type[] typeArray2 = typeArray.getLowerBounds();
        this.visit(typeArray2);
        typeArray = typeArray.getUpperBounds();
        this.visit(typeArray);
    }
}

