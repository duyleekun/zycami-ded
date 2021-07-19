/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.Types;
import com.google.common.reflect.Types$JavaVersion;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Types$WildcardTypeImpl
implements WildcardType,
Serializable {
    private static final long serialVersionUID;
    private final ImmutableList lowerBounds;
    private final ImmutableList upperBounds;

    public Types$WildcardTypeImpl(Type[] object, Type[] typeArray) {
        Types.access$200(object, "lower bound for wildcard");
        Types.access$200(typeArray, "upper bound for wildcard");
        Types$JavaVersion types$JavaVersion = Types$JavaVersion.CURRENT;
        this.lowerBounds = object = types$JavaVersion.usedInGenericType((Type[])object);
        this.upperBounds = object = types$JavaVersion.usedInGenericType(typeArray);
    }

    public boolean equals(Object list) {
        boolean bl2;
        List<Type> list2;
        ImmutableList immutableList;
        boolean bl3 = list instanceof WildcardType;
        boolean bl4 = false;
        if (bl3 && (bl3 = (immutableList = this.lowerBounds).equals(list2 = Arrays.asList((list = (WildcardType)((Object)list)).getLowerBounds()))) && (bl2 = (immutableList = this.upperBounds).equals(list = Arrays.asList(list.getUpperBounds())))) {
            bl4 = true;
        }
        return bl4;
    }

    public Type[] getLowerBounds() {
        return Types.access$300(this.lowerBounds);
    }

    public Type[] getUpperBounds() {
        return Types.access$300(this.upperBounds);
    }

    public int hashCode() {
        int n10 = this.lowerBounds.hashCode();
        int n11 = this.upperBounds.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        Types$JavaVersion types$JavaVersion;
        Object object;
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder("?");
        Iterator iterator2 = this.lowerBounds.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Type)iterator2.next();
            stringBuilder.append(" super ");
            types$JavaVersion = Types$JavaVersion.CURRENT;
            object = types$JavaVersion.typeName((Type)object);
            stringBuilder.append((String)object);
        }
        iterator2 = Types.access$700(this.upperBounds).iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Type)iterator2.next();
            stringBuilder.append(" extends ");
            types$JavaVersion = Types$JavaVersion.CURRENT;
            object = types$JavaVersion.typeName((Type)object);
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }
}

