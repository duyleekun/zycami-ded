/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;

public class TypeToken$Bounds {
    private final Type[] bounds;
    private final boolean target;

    public TypeToken$Bounds(Type[] typeArray, boolean bl2) {
        this.bounds = typeArray;
        this.target = bl2;
    }

    public boolean isSubtypeOf(Type type) {
        Type[] typeArray = this.bounds;
        int n10 = typeArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            TypeToken typeToken = TypeToken.of(typeArray[i10]);
            boolean bl3 = typeToken.isSubtypeOf(type);
            if (bl3 != (bl2 = this.target)) continue;
            return bl2;
        }
        return this.target ^ true;
    }

    public boolean isSupertypeOf(Type object) {
        object = TypeToken.of((Type)object);
        for (Type type : this.bounds) {
            boolean bl2;
            boolean bl3 = ((TypeToken)object).isSubtypeOf(type);
            if (bl3 != (bl2 = this.target)) continue;
            return bl2;
        }
        return this.target ^ true;
    }
}

