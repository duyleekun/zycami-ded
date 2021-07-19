/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class Android {
    private static final boolean IS_ROBOLECTRIC;
    private static final Class MEMORY_CLASS;

    static {
        boolean bl2;
        MEMORY_CLASS = Android.getClassForName("libcore.io.Memory");
        Class clazz = Android.getClassForName("org.robolectric.Robolectric");
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        IS_ROBOLECTRIC = bl2;
    }

    private static Class getClassForName(String string2) {
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static Class getMemoryClass() {
        return MEMORY_CLASS;
    }

    public static boolean isOnAndroidDevice() {
        boolean bl2;
        Class clazz = MEMORY_CLASS;
        if (clazz != null && !(bl2 = IS_ROBOLECTRIC)) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }
}

