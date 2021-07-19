/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator;

public class UnsafeAllocator$4
extends UnsafeAllocator {
    public Object newInstance(Class object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot allocate ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

