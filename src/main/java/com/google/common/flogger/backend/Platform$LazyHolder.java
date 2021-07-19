/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.Platform;
import com.google.common.flogger.backend.PlatformProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class Platform$LazyHolder {
    private static final Platform INSTANCE = Platform$LazyHolder.loadFirstAvailablePlatform(Platform.access$000());

    private Platform$LazyHolder() {
    }

    public static /* synthetic */ Platform access$100() {
        return INSTANCE;
    }

    private static Platform loadFirstAvailablePlatform(String[] object) {
        Platform platform;
        CharSequence charSequence = new StringBuilder();
        try {
            platform = PlatformProvider.getPlatform();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            int n10 = 0;
            platform = null;
        }
        if (platform != null) {
            return platform;
        }
        for (Object object2 : object) {
            Object throwable;
            try {
                throwable = Class.forName((String)object2);
            }
            catch (Throwable throwable2) {
                char c10 = throwable2 instanceof InvocationTargetException;
                if (c10 != '\u0000') {
                    throwable = throwable2.getCause();
                }
                c10 = '\n';
                ((StringBuilder)charSequence).append(c10);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ": ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(throwable);
                continue;
            }
            Object[] objectArray = new Class[]{};
            throwable = ((Class)throwable).getConstructor((Class<?>[])objectArray);
            objectArray = new Object[]{};
            throwable = ((Constructor)throwable).newInstance(objectArray);
            return (Platform)throwable;
        }
        charSequence = ((StringBuilder)charSequence).insert(0, "No logging platforms found:").toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }
}

