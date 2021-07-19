/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class TypeResolver$TypeVariableKey {
    private final TypeVariable var;

    public TypeResolver$TypeVariableKey(TypeVariable typeVariable) {
        this.var = typeVariable = (TypeVariable)Preconditions.checkNotNull(typeVariable);
    }

    private boolean equalsTypeVariable(TypeVariable object) {
        boolean bl2;
        Object d10;
        Object object2 = this.var.getGenericDeclaration();
        boolean bl3 = object2.equals(d10 = object.getGenericDeclaration());
        if (bl3 && (bl2 = ((String)(object2 = this.var.getName())).equals(object = object.getName()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static TypeResolver$TypeVariableKey forLookup(Type type) {
        boolean bl2 = type instanceof TypeVariable;
        if (bl2) {
            type = (TypeVariable)type;
            TypeResolver$TypeVariableKey typeResolver$TypeVariableKey = new TypeResolver$TypeVariableKey((TypeVariable)type);
            return typeResolver$TypeVariableKey;
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof TypeResolver$TypeVariableKey;
        if (bl2) {
            object = ((TypeResolver$TypeVariableKey)object).var;
            return this.equalsTypeVariable((TypeVariable)object);
        }
        return false;
    }

    public boolean equalsType(Type type) {
        boolean bl2 = type instanceof TypeVariable;
        if (bl2) {
            type = (TypeVariable)type;
            return this.equalsTypeVariable((TypeVariable)type);
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Object object = this.var.getGenericDeclaration();
        objectArray[0] = object;
        object = this.var.getName();
        objectArray[1] = object;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        return this.var.toString();
    }
}

