/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.backend.Platform$LogCallerFinder;
import com.google.common.flogger.util.CallerFinder;
import com.google.common.flogger.util.StackBasedLogSite;
import java.io.Serializable;

public final class StackBasedCallerFinder
extends Platform$LogCallerFinder {
    private static final Platform$LogCallerFinder INSTANCE;

    static {
        StackBasedCallerFinder stackBasedCallerFinder = new StackBasedCallerFinder();
        INSTANCE = stackBasedCallerFinder;
    }

    private StackBasedCallerFinder() {
    }

    public static Platform$LogCallerFinder getInstance() {
        return INSTANCE;
    }

    public LogSite findLogSite(Class serializable, int n10) {
        Throwable throwable = new Throwable();
        LogSite logSite = (serializable = CallerFinder.findCallerOf(serializable, throwable, ++n10)) != null ? new StackBasedLogSite((StackTraceElement)serializable) : LogSite.INVALID;
        return logSite;
    }

    public String findLoggingClass(Class object) {
        Serializable serializable = new Throwable();
        int n10 = 1;
        if ((serializable = CallerFinder.findCallerOf((Class)object, (Throwable)serializable, n10)) != null) {
            return ((StackTraceElement)serializable).getClassName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("no caller found on the stack for: ");
        object = ((Class)object).getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        serializable = new IllegalStateException((String)object);
        throw serializable;
    }

    public String toString() {
        return "Default stack-based caller finder";
    }
}

