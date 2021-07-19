/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.LogData;
import java.util.logging.Level;

public abstract class LoggerBackend {
    public abstract String getLoggerName();

    public abstract void handleError(RuntimeException var1, LogData var2);

    public abstract boolean isLoggable(Level var1);

    public abstract void log(LogData var1);
}

