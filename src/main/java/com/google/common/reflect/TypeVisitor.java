/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

public abstract class TypeVisitor {
    private final Set visited;

    public TypeVisitor() {
        HashSet hashSet = Sets.newHashSet();
        this.visited = hashSet;
    }

    public final void visit(Type ... object) {
        int n10 = ((Type[])object).length;
        String string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            CharSequence charSequence;
            Object object2;
            boolean bl2;
            Type type = object[i10];
            if (type == null || !(bl2 = (object2 = this.visited).add(type))) continue;
            bl2 = type instanceof TypeVariable;
            if (bl2) {
                object2 = type;
                object2 = (TypeVariable)type;
                this.visitTypeVariable((TypeVariable)object2);
                continue;
            }
            bl2 = type instanceof WildcardType;
            if (bl2) {
                object2 = type;
                object2 = (WildcardType)type;
                this.visitWildcardType((WildcardType)object2);
                continue;
            }
            bl2 = type instanceof ParameterizedType;
            if (bl2) {
                object2 = type;
                object2 = (ParameterizedType)type;
                this.visitParameterizedType((ParameterizedType)object2);
                continue;
            }
            bl2 = type instanceof Class;
            if (bl2) {
                object2 = type;
                object2 = (Class)type;
                this.visitClass((Class)object2);
                continue;
            }
            bl2 = type instanceof GenericArrayType;
            if (bl2) {
                object2 = type;
                object2 = (GenericArrayType)type;
                this.visitGenericArrayType((GenericArrayType)object2);
                continue;
            }
            try {
                charSequence = new StringBuilder();
                string2 = "Unknown type: ";
            }
            catch (Throwable throwable) {
                this.visited.remove(type);
                throw throwable;
            }
            charSequence.append(string2);
            charSequence.append(type);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
    }

    public void visitClass(Class clazz) {
    }

    public void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    public void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    public void visitTypeVariable(TypeVariable typeVariable) {
    }

    public void visitWildcardType(WildcardType wildcardType) {
    }
}

