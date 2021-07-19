/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$GenericArrayTypeImpl;
import com.google.common.reflect.Types$JavaVersion;
import java.lang.reflect.Type;

public final class Types$JavaVersion$2
extends Types$JavaVersion {
    public Type newArrayType(Type type) {
        boolean bl2 = type instanceof Class;
        if (bl2) {
            return Types.getArrayClass((Class)type);
        }
        Types$GenericArrayTypeImpl types$GenericArrayTypeImpl = new Types$GenericArrayTypeImpl(type);
        return types$GenericArrayTypeImpl;
    }

    public Type usedInGenericType(Type type) {
        return (Type)Preconditions.checkNotNull(type);
    }
}

