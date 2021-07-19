/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

public class UnsafeAllocator$3
extends UnsafeAllocator {
    public final /* synthetic */ Method val$newInstance;

    public UnsafeAllocator$3(Method method) {
        this.val$newInstance = method;
    }

    public Object newInstance(Class clazz) {
        UnsafeAllocator.assertInstantiable(clazz);
        Method method = this.val$newInstance;
        Object[] objectArray = new Object[]{clazz, Object.class};
        return method.invoke(null, objectArray);
    }
}

