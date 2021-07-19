/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.reflect;

import com.google.gson.internal.reflect.ReflectionAccessor;
import java.lang.reflect.AccessibleObject;

public final class PreJava9ReflectionAccessor
extends ReflectionAccessor {
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}

