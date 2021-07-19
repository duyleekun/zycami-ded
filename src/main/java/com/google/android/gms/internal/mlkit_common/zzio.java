/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

public final class zzio
implements PrivilegedExceptionAction {
    public final /* synthetic */ Object run() {
        Class<Unsafe> clazz = Unsafe.class;
        Field[] fieldArray = clazz.getDeclaredFields();
        int n10 = fieldArray.length;
        int n11 = 0;
        while (true) {
            Object object = null;
            if (n11 >= n10) break;
            Field field = fieldArray[n11];
            boolean bl2 = true;
            field.setAccessible(bl2);
            object = field.get(null);
            boolean bl3 = clazz.isInstance(object);
            if (bl3) {
                return (Unsafe)clazz.cast(object);
            }
            ++n11;
        }
        return null;
    }
}

