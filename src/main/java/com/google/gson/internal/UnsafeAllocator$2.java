/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;
import java.lang.reflect.Method;

public class UnsafeAllocator$2
extends UnsafeAllocator {
    public final /* synthetic */ int val$constructorId;
    public final /* synthetic */ Method val$newInstance;

    public UnsafeAllocator$2(Method method, int n10) {
        this.val$newInstance = method;
        this.val$constructorId = n10;
    }

    public Object newInstance(Class constable) {
        UnsafeAllocator.assertInstantiable(constable);
        Method method = this.val$newInstance;
        Object[] objectArray = new Object[2];
        objectArray[0] = constable;
        constable = Integer.valueOf(this.val$constructorId);
        objectArray[1] = constable;
        return method.invoke(null, objectArray);
    }
}

