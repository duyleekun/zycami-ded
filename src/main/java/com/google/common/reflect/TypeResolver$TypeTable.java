/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeResolver$TypeTable$1;
import com.google.common.reflect.TypeResolver$TypeVariableKey;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$NativeTypeVariableEquals;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;

public class TypeResolver$TypeTable {
    private final ImmutableMap map;

    public TypeResolver$TypeTable() {
        ImmutableMap immutableMap;
        this.map = immutableMap = ImmutableMap.of();
    }

    private TypeResolver$TypeTable(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    public final Type resolve(TypeVariable typeVariable) {
        TypeResolver$TypeTable$1 typeResolver$TypeTable$1 = new TypeResolver$TypeTable$1(this, typeVariable, this);
        return this.resolveInternal(typeVariable, typeResolver$TypeTable$1);
    }

    public Type resolveInternal(TypeVariable object, TypeResolver$TypeTable objectArray) {
        Object object2 = this.map;
        TypeResolver$TypeVariableKey typeResolver$TypeVariableKey = new TypeResolver$TypeVariableKey((TypeVariable)object);
        object2 = (Type)object2.get(typeResolver$TypeVariableKey);
        boolean bl2 = false;
        typeResolver$TypeVariableKey = null;
        if (object2 == null) {
            boolean bl3;
            object2 = object.getBounds();
            int n10 = ((Type[])object2).length;
            if (n10 == 0) {
                return object;
            }
            TypeResolver typeResolver = new TypeResolver((TypeResolver$TypeTable)objectArray, null);
            objectArray = TypeResolver.access$300(typeResolver, (Type[])object2);
            bl2 = Types$NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY;
            if (bl2 && (bl3 = Arrays.equals(object2, objectArray))) {
                return object;
            }
            object2 = object.getGenericDeclaration();
            object = object.getName();
            return Types.newArtificialTypeVariable((GenericDeclaration)object2, (String)object, (Type[])objectArray);
        }
        object = new TypeResolver((TypeResolver$TypeTable)objectArray, null);
        return ((TypeResolver)object).resolveType((Type)object2);
    }

    public final TypeResolver$TypeTable where(Map object) {
        boolean bl2;
        Object object2 = ImmutableMap.builder();
        Object object3 = this.map;
        ((ImmutableMap$Builder)object2).putAll((Map)object3);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object3 = (Map.Entry)object.next();
            TypeResolver$TypeVariableKey typeResolver$TypeVariableKey = (TypeResolver$TypeVariableKey)object3.getKey();
            object3 = (Type)object3.getValue();
            boolean bl3 = typeResolver$TypeVariableKey.equalsType((Type)object3) ^ true;
            String string2 = "Type variable %s bound to itself";
            Preconditions.checkArgument(bl3, string2, (Object)typeResolver$TypeVariableKey);
            ((ImmutableMap$Builder)object2).put(typeResolver$TypeVariableKey, object3);
        }
        object2 = ((ImmutableMap$Builder)object2).build();
        object = new TypeResolver$TypeTable((ImmutableMap)object2);
        return object;
    }
}

