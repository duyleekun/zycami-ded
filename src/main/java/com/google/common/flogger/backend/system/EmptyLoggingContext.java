/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.Tags;
import com.google.common.flogger.backend.system.LoggingContext;
import java.util.logging.Level;

public final class EmptyLoggingContext
extends LoggingContext {
    private static final LoggingContext INSTANCE;

    static {
        EmptyLoggingContext emptyLoggingContext = new EmptyLoggingContext();
        INSTANCE = emptyLoggingContext;
    }

    private EmptyLoggingContext() {
    }

    public static LoggingContext getInstance() {
        return INSTANCE;
    }

    public Tags getTags() {
        return Tags.empty();
    }

    public boolean shouldForceLogging(String string2, Level level, boolean bl2) {
        return false;
    }

    public String toString() {
        return "Empty logging context";
    }
}

