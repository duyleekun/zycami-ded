/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Objects;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$JavaVersion;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class Types$GenericArrayTypeImpl
implements GenericArrayType,
Serializable {
    private static final long serialVersionUID;
    private final Type componentType;

    public Types$GenericArrayTypeImpl(Type type) {
        this.componentType = type = Types$JavaVersion.CURRENT.usedInGenericType(type);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof GenericArrayType;
        if (bl2) {
            object = (GenericArrayType)object;
            Type type = this.getGenericComponentType();
            object = object.getGenericComponentType();
            return Objects.equal(type, object);
        }
        return false;
    }

    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Types.toString(this.componentType);
        stringBuilder.append(string2);
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }
}

