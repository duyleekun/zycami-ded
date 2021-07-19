/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken$TypeCollector;

public final class TypeToken$TypeCollector$1
extends TypeToken$TypeCollector {
    public TypeToken$TypeCollector$1() {
        super(null);
    }

    public Iterable getInterfaces(TypeToken typeToken) {
        return typeToken.getGenericInterfaces();
    }

    public Class getRawType(TypeToken typeToken) {
        return typeToken.getRawType();
    }

    public TypeToken getSuperclass(TypeToken typeToken) {
        return typeToken.getGenericSuperclass();
    }
}

