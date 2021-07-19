/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeResolver$1;
import com.google.common.reflect.TypeResolver$TypeMappingIntrospector;
import com.google.common.reflect.TypeResolver$TypeTable;
import com.google.common.reflect.TypeResolver$WildcardCapturer;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$WildcardTypeImpl;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;

public final class TypeResolver {
    private final TypeResolver$TypeTable typeTable;

    public TypeResolver() {
        TypeResolver$TypeTable typeResolver$TypeTable;
        this.typeTable = typeResolver$TypeTable = new TypeResolver$TypeTable();
    }

    private TypeResolver(TypeResolver$TypeTable typeResolver$TypeTable) {
        this.typeTable = typeResolver$TypeTable;
    }

    public /* synthetic */ TypeResolver(TypeResolver$TypeTable typeResolver$TypeTable, TypeResolver$1 typeResolver$1) {
        this(typeResolver$TypeTable);
    }

    public static /* synthetic */ void access$000(Map map, Type type, Type type2) {
        TypeResolver.populateTypeMappings(map, type, type2);
    }

    public static /* synthetic */ Object access$100(Class clazz, Object object) {
        return TypeResolver.expectArgument(clazz, object);
    }

    public static /* synthetic */ Type[] access$300(TypeResolver typeResolver, Type[] typeArray) {
        return typeResolver.resolveTypes(typeArray);
    }

    public static TypeResolver covariantly(Type object) {
        TypeResolver typeResolver = new TypeResolver();
        object = TypeResolver$TypeMappingIntrospector.getTypeMappings((Type)object);
        return typeResolver.where((Map)object);
    }

    private static Object expectArgument(Class object, Object object2) {
        try {
            return ((Class)object).cast(object2);
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object2);
            stringBuilder.append(" is not a ");
            object = ((Class)object).getSimpleName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
    }

    public static TypeResolver invariantly(Type object) {
        object = TypeResolver$WildcardCapturer.INSTANCE.capture((Type)object);
        TypeResolver typeResolver = new TypeResolver();
        object = TypeResolver$TypeMappingIntrospector.getTypeMappings((Type)object);
        return typeResolver.where((Map)object);
    }

    private static void populateTypeMappings(Map typeArray, Type type, Type type2) {
        boolean bl2 = type.equals(type2);
        if (bl2) {
            return;
        }
        TypeResolver$1 typeResolver$1 = new TypeResolver$1((Map)typeArray, type2);
        typeArray = new Type[]{type};
        typeResolver$1.visit(typeArray);
    }

    private Type resolveGenericArrayType(GenericArrayType type) {
        type = type.getGenericComponentType();
        return Types.newArrayType(this.resolveType(type));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType typeArray) {
        Type type = typeArray.getOwnerType();
        type = type == null ? null : this.resolveType(type);
        Type type2 = typeArray.getRawType();
        type2 = this.resolveType(type2);
        typeArray = typeArray.getActualTypeArguments();
        typeArray = this.resolveTypes(typeArray);
        type2 = (Class)type2;
        return Types.newParameterizedTypeWithOwner(type, (Class)type2, typeArray);
    }

    private Type[] resolveTypes(Type[] typeArray) {
        int n10;
        int n11 = typeArray.length;
        Type[] typeArray2 = new Type[n11];
        for (int i10 = 0; i10 < (n10 = typeArray.length); ++i10) {
            Type type = typeArray[i10];
            typeArray2[i10] = type = this.resolveType(type);
        }
        return typeArray2;
    }

    private WildcardType resolveWildcardType(WildcardType typeArray) {
        Type[] typeArray2 = typeArray.getLowerBounds();
        typeArray = typeArray.getUpperBounds();
        typeArray2 = this.resolveTypes(typeArray2);
        typeArray = this.resolveTypes(typeArray);
        Types$WildcardTypeImpl types$WildcardTypeImpl = new Types$WildcardTypeImpl(typeArray2, typeArray);
        return types$WildcardTypeImpl;
    }

    public Type resolveType(Type type) {
        Preconditions.checkNotNull(type);
        boolean bl2 = type instanceof TypeVariable;
        if (bl2) {
            TypeResolver$TypeTable typeResolver$TypeTable = this.typeTable;
            type = (TypeVariable)type;
            return typeResolver$TypeTable.resolve((TypeVariable)type);
        }
        bl2 = type instanceof ParameterizedType;
        if (bl2) {
            type = (ParameterizedType)type;
            return this.resolveParameterizedType((ParameterizedType)type);
        }
        bl2 = type instanceof GenericArrayType;
        if (bl2) {
            type = (GenericArrayType)type;
            return this.resolveGenericArrayType((GenericArrayType)type);
        }
        bl2 = type instanceof WildcardType;
        if (bl2) {
            type = (WildcardType)type;
            type = this.resolveWildcardType((WildcardType)type);
        }
        return type;
    }

    public Type[] resolveTypesInPlace(Type[] typeArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = typeArray.length); ++i10) {
            Type type = typeArray[i10];
            typeArray[i10] = type = this.resolveType(type);
        }
        return typeArray;
    }

    public TypeResolver where(Type type, Type type2) {
        HashMap hashMap = Maps.newHashMap();
        type = (Type)Preconditions.checkNotNull(type);
        type2 = (Type)Preconditions.checkNotNull(type2);
        TypeResolver.populateTypeMappings(hashMap, type, type2);
        return this.where(hashMap);
    }

    public TypeResolver where(Map object) {
        object = this.typeTable.where((Map)object);
        TypeResolver typeResolver = new TypeResolver((TypeResolver$TypeTable)object);
        return typeResolver;
    }
}

