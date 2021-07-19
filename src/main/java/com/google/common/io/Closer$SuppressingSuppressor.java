/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.lang.reflect.Method;

public final class Closer$SuppressingSuppressor
implements Closer$Suppressor {
    public static final Closer$SuppressingSuppressor INSTANCE;
    public static final Method addSuppressed;

    static {
        Closer$SuppressingSuppressor closer$SuppressingSuppressor;
        INSTANCE = closer$SuppressingSuppressor = new Closer$SuppressingSuppressor();
        addSuppressed = Closer$SuppressingSuppressor.addSuppressedMethodOrNull();
    }

    private static Method addSuppressedMethodOrNull() {
        Class<Throwable> clazz;
        Class[] classArray;
        Class<Throwable> clazz2 = Throwable.class;
        String string2 = "addSuppressed";
        int n10 = 1;
        try {
            classArray = new Class[n10];
            clazz = Throwable.class;
        }
        catch (Throwable throwable) {
            return null;
        }
        classArray[0] = clazz;
        return clazz2.getMethod(string2, classArray);
    }

    public static boolean isAvailable() {
        boolean bl2;
        Method method = addSuppressed;
        if (method != null) {
            bl2 = true;
        } else {
            bl2 = false;
            method = null;
        }
        return bl2;
    }

    public void suppress(Closeable closeable, Throwable throwable, Throwable throwable2) {
        if (throwable == throwable2) {
            return;
        }
        Object object = addSuppressed;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = throwable2;
        try {
            ((Method)object).invoke(throwable, objectArray);
        }
        catch (Throwable throwable3) {
            object = Closer$LoggingSuppressor.INSTANCE;
            ((Closer$LoggingSuppressor)object).suppress(closeable, throwable, throwable2);
        }
    }
}

