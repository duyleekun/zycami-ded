/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public final class Platform {
    private Platform() {
    }

    public static boolean isInstanceOfThrowableClass(Throwable throwable, Class clazz) {
        return clazz.isInstance(throwable);
    }
}

