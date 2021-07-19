/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$JavaVersion;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public final class Types$ParameterizedTypeImpl
implements ParameterizedType,
Serializable {
    private static final long serialVersionUID;
    private final ImmutableList argumentsList;
    private final Type ownerType;
    private final Class rawType;

    public Types$ParameterizedTypeImpl(Type object, Class clazz, Type[] typeArray) {
        Preconditions.checkNotNull(clazz);
        int n10 = typeArray.length;
        TypeVariable<Class<T>>[] typeVariableArray = clazz.getTypeParameters();
        int n11 = typeVariableArray.length;
        n10 = n10 == n11 ? 1 : 0;
        Preconditions.checkArgument(n10 != 0);
        Types.access$200(typeArray, "type parameter");
        this.ownerType = object;
        this.rawType = clazz;
        this.argumentsList = object = Types$JavaVersion.CURRENT.usedInGenericType(typeArray);
    }

    public boolean equals(Object objectArray) {
        boolean bl2;
        Type type;
        boolean bl3 = objectArray instanceof ParameterizedType;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        objectArray = (ParameterizedType)objectArray;
        Object[] objectArray2 = this.getRawType();
        bl3 = objectArray2.equals(type = objectArray.getRawType());
        if (bl3 && (bl3 = Objects.equal(objectArray2 = this.getOwnerType(), type = objectArray.getOwnerType())) && (bl2 = Arrays.equals(objectArray2 = this.getActualTypeArguments(), objectArray = objectArray.getActualTypeArguments()))) {
            bl4 = true;
        }
        return bl4;
    }

    public Type[] getActualTypeArguments() {
        return Types.access$300(this.argumentsList);
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int n10;
        Type type = this.ownerType;
        if (type == null) {
            n10 = 0;
            type = null;
        } else {
            n10 = type.hashCode();
        }
        int n11 = this.argumentsList.hashCode();
        n10 ^= n11;
        n11 = this.rawType.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        Object object;
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = this.ownerType;
        if (object2 != null && (bl2 = ((Types$JavaVersion)((Object)(object2 = Types$JavaVersion.CURRENT))).jdkTypeDuplicatesOwnerName())) {
            object = this.ownerType;
            object2 = ((Types$JavaVersion)((Object)object2)).typeName((Type)object);
            stringBuilder.append((String)object2);
            char c10 = '.';
            stringBuilder.append(c10);
        }
        object2 = this.rawType.getName();
        stringBuilder.append((String)object2);
        stringBuilder.append('<');
        object2 = Types.access$500();
        object = this.argumentsList;
        Function function = Types.access$400();
        object = Iterables.transform((Iterable)object, function);
        object2 = ((Joiner)object2).join((Iterable)object);
        stringBuilder.append((String)object2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

