/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.AbstractLogger;
import com.google.common.flogger.FluentLogger$Api;
import com.google.common.flogger.FluentLogger$Context;
import com.google.common.flogger.FluentLogger$NoOp;
import com.google.common.flogger.backend.LoggerBackend;
import com.google.common.flogger.backend.Platform;
import java.util.logging.Level;

public final class FluentLogger
extends AbstractLogger {
    public static final FluentLogger$NoOp NO_OP;

    static {
        FluentLogger$NoOp fluentLogger$NoOp;
        NO_OP = fluentLogger$NoOp = new FluentLogger$NoOp(null);
    }

    public FluentLogger(LoggerBackend loggerBackend) {
        super(loggerBackend);
    }

    public static FluentLogger forEnclosingClass() {
        Object object = Platform.getCallerFinder().findLoggingClass(FluentLogger.class);
        object = Platform.getBackend((String)object);
        FluentLogger fluentLogger = new FluentLogger((LoggerBackend)object);
        return fluentLogger;
    }

    public FluentLogger$Api at(Level object) {
        boolean bl2 = this.isLoggable((Level)object);
        String string2 = this.getName();
        boolean bl3 = Platform.shouldForceLogging(string2, (Level)object, bl2);
        if (!bl2 && !bl3) {
            object = NO_OP;
        } else {
            FluentLogger$Context fluentLogger$Context = new FluentLogger$Context(this, (Level)object, bl3, null);
            object = fluentLogger$Context;
        }
        return object;
    }
}

