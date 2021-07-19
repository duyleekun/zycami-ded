/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.reflect.PreJava9ReflectionAccessor;
import com.google.gson.internal.reflect.UnsafeReflectionAccessor;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        int n10;
        int n11 = JavaVersion.getMajorJavaVersion();
        ReflectionAccessor reflectionAccessor = n11 < (n10 = 9) ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
        instance = reflectionAccessor;
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject var1);
}

