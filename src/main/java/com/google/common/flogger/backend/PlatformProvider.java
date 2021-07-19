/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.Platform;
import com.google.common.flogger.backend.system.DefaultPlatform;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class PlatformProvider {
    private PlatformProvider() {
    }

    public static Platform getPlatform() {
        Object object = DefaultPlatform.class;
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        object = ((Constructor)object).newInstance(objectArray);
        try {
            return (Platform)object;
        }
        catch (IllegalAccessException | InstantiationException | NoClassDefFoundError | NoSuchMethodException | InvocationTargetException throwable) {
            return null;
        }
    }
}

