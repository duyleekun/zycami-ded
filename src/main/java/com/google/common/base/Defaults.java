/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;

public final class Defaults {
    private static final Double DOUBLE_DEFAULT = 0.0;
    private static final Float FLOAT_DEFAULT = Float.valueOf(0.0f);

    private Defaults() {
    }

    public static Object defaultValue(Class clazz) {
        Preconditions.checkNotNull(clazz);
        Class<Comparable<Boolean>> clazz2 = Boolean.TYPE;
        if (clazz == clazz2) {
            return Boolean.FALSE;
        }
        clazz2 = Character.TYPE;
        if (clazz == clazz2) {
            return Character.valueOf('\u0000');
        }
        clazz2 = Byte.TYPE;
        if (clazz == clazz2) {
            return (byte)0;
        }
        clazz2 = Short.TYPE;
        if (clazz == clazz2) {
            return (short)0;
        }
        clazz2 = Integer.TYPE;
        if (clazz == clazz2) {
            return 0;
        }
        clazz2 = Long.TYPE;
        if (clazz == clazz2) {
            return 0L;
        }
        clazz2 = Float.TYPE;
        if (clazz == clazz2) {
            return FLOAT_DEFAULT;
        }
        clazz2 = Double.TYPE;
        if (clazz == clazz2) {
            return DOUBLE_DEFAULT;
        }
        return null;
    }
}

