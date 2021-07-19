/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.Types$GenericArrayTypeImpl;
import com.google.common.reflect.Types$JavaVersion;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class Types$JavaVersion$1
extends Types$JavaVersion {
    public GenericArrayType newArrayType(Type type) {
        Types$GenericArrayTypeImpl types$GenericArrayTypeImpl = new Types$GenericArrayTypeImpl(type);
        return types$GenericArrayTypeImpl;
    }

    public Type usedInGenericType(Type clazz) {
        Preconditions.checkNotNull(clazz);
        boolean bl2 = clazz instanceof Class;
        if (bl2) {
            Class clazz2 = clazz;
            clazz2 = clazz;
            boolean bl3 = clazz2.isArray();
            if (bl3) {
                clazz2 = clazz2.getComponentType();
                clazz = new Class(clazz2);
            }
        }
        return clazz;
    }
}

