/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken$TypeCollector;
import java.util.Arrays;

public final class TypeToken$TypeCollector$2
extends TypeToken$TypeCollector {
    public TypeToken$TypeCollector$2() {
        super(null);
    }

    public Iterable getInterfaces(Class clazz) {
        return Arrays.asList(clazz.getInterfaces());
    }

    public Class getRawType(Class clazz) {
        return clazz;
    }

    public Class getSuperclass(Class clazz) {
        return clazz.getSuperclass();
    }
}

