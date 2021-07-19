/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.io.Closeables;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Closer$LoggingSuppressor
implements Closer$Suppressor {
    public static final Closer$LoggingSuppressor INSTANCE;

    static {
        Closer$LoggingSuppressor closer$LoggingSuppressor;
        INSTANCE = closer$LoggingSuppressor = new Closer$LoggingSuppressor();
    }

    public void suppress(Closeable object, Throwable object2, Throwable throwable) {
        object2 = Closeables.logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Suppressing exception thrown when closing ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        ((Logger)object2).log(level, (String)object, throwable);
    }
}

