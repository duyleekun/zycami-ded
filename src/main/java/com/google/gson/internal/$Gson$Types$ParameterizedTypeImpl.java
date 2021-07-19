/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class $Gson$Types$ParameterizedTypeImpl
implements ParameterizedType,
Serializable {
    private static final long serialVersionUID;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public $Gson$Types$ParameterizedTypeImpl(Type typeArray, Type typeArray2, Type ... object) {
        int n10;
        boolean bl2 = typeArray2 instanceof Class;
        int n11 = 0;
        if (bl2) {
            Type[] typeArray3 = typeArray2;
            typeArray3 = (Class)typeArray2;
            boolean bl3 = Modifier.isStatic(typeArray3.getModifiers());
            boolean bl4 = true;
            if (!bl3 && (typeArray3 = typeArray3.getEnclosingClass()) != null) {
                bl2 = false;
                typeArray3 = null;
            } else {
                bl2 = bl4;
            }
            if (typeArray == null && !bl2) {
                bl4 = false;
            }
            $Gson$Preconditions.checkArgument(bl4);
        }
        if (typeArray == null) {
            n10 = 0;
            typeArray = null;
        } else {
            typeArray = $Gson$Types.canonicalize((Type)typeArray);
        }
        this.ownerType = typeArray;
        typeArray = $Gson$Types.canonicalize((Type)typeArray2);
        this.rawType = typeArray;
        typeArray = (Type[])object.clone();
        this.typeArguments = typeArray;
        n10 = typeArray.length;
        while (n11 < n10) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[n11]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[n11]);
            typeArray2 = this.typeArguments;
            typeArray2[n11] = object = $Gson$Types.canonicalize(typeArray2[n11]);
            ++n11;
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof ParameterizedType;
        if (bl3 && (bl2 = $Gson$Types.equals(this, (Type)(object = (ParameterizedType)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type[] getActualTypeArguments() {
        return (Type[])this.typeArguments.clone();
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int n10 = Arrays.hashCode(this.typeArguments);
        int n11 = this.rawType.hashCode();
        n10 ^= n11;
        n11 = $Gson$Types.hashCodeOrZero(this.ownerType);
        return n10 ^ n11;
    }

    public String toString() {
        Type[] typeArray = this.typeArguments;
        int n10 = typeArray.length;
        if (n10 == 0) {
            return $Gson$Types.typeToString(this.rawType);
        }
        int n11 = (n10 + 1) * 30;
        StringBuilder stringBuilder = new StringBuilder(n11);
        Object object = $Gson$Types.typeToString(this.rawType);
        stringBuilder.append((String)object);
        stringBuilder.append("<");
        object = this.typeArguments;
        String string2 = null;
        object = $Gson$Types.typeToString(object[0]);
        stringBuilder.append((String)object);
        for (n11 = 1; n11 < n10; ++n11) {
            stringBuilder.append(", ");
            string2 = $Gson$Types.typeToString(this.typeArguments[n11]);
            stringBuilder.append(string2);
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}

