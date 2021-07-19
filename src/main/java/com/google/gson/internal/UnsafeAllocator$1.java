/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

public class UnsafeAllocator$1
extends UnsafeAllocator {
    public final /* synthetic */ Method val$allocateInstance;
    public final /* synthetic */ Object val$unsafe;

    public UnsafeAllocator$1(Method method, Object object) {
        this.val$allocateInstance = method;
        this.val$unsafe = object;
    }

    public Object newInstance(Class clazz) {
        UnsafeAllocator.assertInstantiable(clazz);
        Method method = this.val$allocateInstance;
        Object object = this.val$unsafe;
        Object[] objectArray = new Object[]{clazz};
        return method.invoke(object, objectArray);
    }
}

