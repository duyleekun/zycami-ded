/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeResolver$TypeVariableKey;
import com.google.common.reflect.TypeVisitor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;

public final class TypeResolver$TypeMappingIntrospector
extends TypeVisitor {
    private final Map mappings;

    private TypeResolver$TypeMappingIntrospector() {
        HashMap hashMap = Maps.newHashMap();
        this.mappings = hashMap;
    }

    public static ImmutableMap getTypeMappings(Type type) {
        Preconditions.checkNotNull(type);
        TypeResolver$TypeMappingIntrospector typeResolver$TypeMappingIntrospector = new TypeResolver$TypeMappingIntrospector();
        Type[] typeArray = new Type[]{type};
        typeResolver$TypeMappingIntrospector.visit(typeArray);
        return ImmutableMap.copyOf(typeResolver$TypeMappingIntrospector.mappings);
    }

    private void map(TypeResolver$TypeVariableKey object, Type object2) {
        Object object3 = this.mappings;
        boolean bl2 = object3.containsKey(object);
        if (bl2) {
            return;
        }
        object3 = object2;
        while (object3 != null) {
            boolean bl3 = ((TypeResolver$TypeVariableKey)object).equalsType((Type)object3);
            if (bl3) {
                while (object2 != null) {
                    object = this.mappings;
                    object2 = TypeResolver$TypeVariableKey.forLookup((Type)object2);
                    object2 = object = object.remove(object2);
                    object2 = (Type)object;
                }
                return;
            }
            Map map = this.mappings;
            object3 = TypeResolver$TypeVariableKey.forLookup((Type)object3);
            object3 = (Type)map.get(object3);
        }
        this.mappings.put(object, object2);
    }

    public void visitClass(Class typeArray) {
        Type type = typeArray.getGenericSuperclass();
        Type[] typeArray2 = new Type[]{type};
        this.visit(typeArray2);
        typeArray = typeArray.getGenericInterfaces();
        this.visit(typeArray);
    }

    public void visitParameterizedType(ParameterizedType type) {
        Type[] typeArray = (Type[])type.getRawType();
        Type[] typeArray2 = typeArray.getTypeParameters();
        Type[] typeArray3 = type.getActualTypeArguments();
        int n10 = typeArray2.length;
        int n11 = typeArray3.length;
        int n12 = 1;
        n10 = n10 == n11 ? n12 : 0;
        Preconditions.checkState(n10 != 0);
        for (n10 = 0; n10 < (n11 = typeArray2.length); ++n10) {
            Type type2 = typeArray2[n10];
            TypeResolver$TypeVariableKey typeResolver$TypeVariableKey = new TypeResolver$TypeVariableKey((TypeVariable)type2);
            type2 = typeArray3[n10];
            this.map(typeResolver$TypeVariableKey, type2);
        }
        typeArray2 = new Type[n12];
        typeArray2[0] = typeArray;
        this.visit(typeArray2);
        typeArray = new Type[n12];
        type = type.getOwnerType();
        typeArray[0] = type;
        this.visit(typeArray);
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

