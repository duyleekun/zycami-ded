/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeCapture;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class TypeParameter
extends TypeCapture {
    public final TypeVariable typeVariable;

    public TypeParameter() {
        Type type = this.capture();
        Preconditions.checkArgument(type instanceof TypeVariable, "%s should be a type variable.", (Object)type);
        type = (TypeVariable)type;
        this.typeVariable = type;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof TypeParameter;
        if (bl2) {
            object = (TypeParameter)object;
            TypeVariable typeVariable = this.typeVariable;
            object = ((TypeParameter)object).typeVariable;
            return typeVariable.equals(object);
        }
        return false;
    }

    public final int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return this.typeVariable.toString();
    }
}

