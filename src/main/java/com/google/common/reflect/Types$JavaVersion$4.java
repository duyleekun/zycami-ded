/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types$JavaVersion;
import java.lang.reflect.Type;

public final class Types$JavaVersion$4
extends Types$JavaVersion {
    public boolean jdkTypeDuplicatesOwnerName() {
        return false;
    }

    public Type newArrayType(Type type) {
        return Types$JavaVersion.JAVA8.newArrayType(type);
    }

    public String typeName(Type type) {
        return Types$JavaVersion.JAVA8.typeName(type);
    }

    public Type usedInGenericType(Type type) {
        return Types$JavaVersion.JAVA8.usedInGenericType(type);
    }
}

