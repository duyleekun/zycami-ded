/*
 * Decompiled with CFR 0.151.
 */
package com.google.j2objc.annotations;

public final class ReflectionSupport$Level
extends Enum {
    private static final /* synthetic */ ReflectionSupport$Level[] $VALUES;
    public static final /* enum */ ReflectionSupport$Level FULL;
    public static final /* enum */ ReflectionSupport$Level NATIVE_ONLY;

    static {
        ReflectionSupport$Level reflectionSupport$Level;
        ReflectionSupport$Level reflectionSupport$Level2;
        NATIVE_ONLY = reflectionSupport$Level2 = new ReflectionSupport$Level("NATIVE_ONLY", 0);
        int n10 = 1;
        FULL = reflectionSupport$Level = new ReflectionSupport$Level("FULL", n10);
        ReflectionSupport$Level[] reflectionSupport$LevelArray = new ReflectionSupport$Level[2];
        reflectionSupport$LevelArray[0] = reflectionSupport$Level2;
        reflectionSupport$LevelArray[n10] = reflectionSupport$Level;
        $VALUES = reflectionSupport$LevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ReflectionSupport$Level() {
        void var2_-1;
        void var1_-1;
    }

    public static ReflectionSupport$Level valueOf(String string2) {
        return Enum.valueOf(ReflectionSupport$Level.class, string2);
    }

    public static ReflectionSupport$Level[] values() {
        return (ReflectionSupport$Level[])$VALUES.clone();
    }
}

