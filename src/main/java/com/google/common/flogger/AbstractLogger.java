/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LoggingApi;
import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.LoggerBackend;
import com.google.common.flogger.backend.LoggingException;
import com.google.common.flogger.util.Checks;
import java.io.PrintStream;
import java.util.logging.Level;

public abstract class AbstractLogger {
    private final LoggerBackend backend;

    public AbstractLogger(LoggerBackend loggerBackend) {
        this.backend = loggerBackend = (LoggerBackend)Checks.checkNotNull(loggerBackend, "backend");
    }

    public abstract LoggingApi at(Level var1);

    public final LoggingApi atConfig() {
        Level level = Level.CONFIG;
        return this.at(level);
    }

    public final LoggingApi atFine() {
        Level level = Level.FINE;
        return this.at(level);
    }

    public final LoggingApi atFiner() {
        Level level = Level.FINER;
        return this.at(level);
    }

    public final LoggingApi atFinest() {
        Level level = Level.FINEST;
        return this.at(level);
    }

    public final LoggingApi atInfo() {
        Level level = Level.INFO;
        return this.at(level);
    }

    public final LoggingApi atSevere() {
        Level level = Level.SEVERE;
        return this.at(level);
    }

    public final LoggingApi atWarning() {
        Level level = Level.WARNING;
        return this.at(level);
    }

    public final LoggerBackend getBackend() {
        return this.backend;
    }

    public String getName() {
        return this.backend.getLoggerName();
    }

    public final boolean isLoggable(Level level) {
        return this.backend.isLoggable(level);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void write(LogData logData) {
        Object object = "data";
        Checks.checkNotNull(logData, (String)object);
        try {
            object = this.backend;
            ((LoggerBackend)object).log(logData);
            return;
        }
        catch (RuntimeException runtimeException) {
            try {
                LoggerBackend object2 = this.backend;
                object2.handleError(runtimeException, logData);
                return;
            }
            catch (RuntimeException runtimeException2) {
                PrintStream printStream = System.err;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("logging error: ");
                String string2 = runtimeException2.getMessage();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                printStream.println((String)charSequence);
                printStream = System.err;
                runtimeException2.printStackTrace(printStream);
                return;
            }
            catch (LoggingException loggingException) {
                throw loggingException;
            }
        }
    }
}

