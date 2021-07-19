/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class GenericTypeReflector {
    public static Class getType(Type object) {
        int n10 = object instanceof Class;
        if (n10 != 0) {
            return (Class)object;
        }
        n10 = object instanceof ParameterizedType;
        if (n10 != 0) {
            return (Class)((ParameterizedType)object).getRawType();
        }
        n10 = object instanceof TypeVariable;
        if (n10 != 0) {
            Type[] typeArray = (object = (TypeVariable)object).getBounds();
            n10 = typeArray.length;
            if (n10 == 0) {
                return Object.class;
            }
            return GenericTypeReflector.getType(object.getBounds()[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not supported: ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

