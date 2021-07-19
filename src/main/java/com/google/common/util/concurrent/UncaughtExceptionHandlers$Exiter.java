/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class UncaughtExceptionHandlers$Exiter
implements Thread.UncaughtExceptionHandler {
    private static final Logger logger = Logger.getLogger(UncaughtExceptionHandlers$Exiter.class.getName());
    private final Runtime runtime;

    public UncaughtExceptionHandlers$Exiter(Runtime runtime) {
        this.runtime = runtime;
    }

    public void uncaughtException(Thread object, Throwable object2) {
        int n10 = 1;
        Object object3 = logger;
        Level level = Level.SEVERE;
        Locale locale = Locale.ROOT;
        String string2 = "Caught an exception in %s.  Shutting down.";
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = String.format(locale, string2, objectArray);
        try {
            ((Logger)object3).log(level, (String)object, (Throwable)object2);
        }
        catch (Throwable throwable) {
            object3 = System.err;
            object2 = ((Throwable)object2).getMessage();
            ((PrintStream)object3).println((String)object2);
            object2 = System.err;
            String string3 = throwable.getMessage();
            ((PrintStream)object2).println(string3);
        }
        return;
        {
            finally {
                this.runtime.exit(n10);
            }
        }
    }
}

