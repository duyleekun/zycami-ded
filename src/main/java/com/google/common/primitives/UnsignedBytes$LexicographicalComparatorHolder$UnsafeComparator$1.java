/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

public final class UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1
implements PrivilegedExceptionAction {
    public Unsafe run() {
        Object object = Unsafe.class;
        for (Field field : ((Class)object).getDeclaredFields()) {
            field.setAccessible(true);
            Object object2 = field.get(null);
            boolean bl2 = ((Class)object).isInstance(object2);
            if (!bl2) continue;
            return (Unsafe)((Class)object).cast(object2);
        }
        object = new NoSuchFieldError("the Unsafe");
        throw object;
    }
}

