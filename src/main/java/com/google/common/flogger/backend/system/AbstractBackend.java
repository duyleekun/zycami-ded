/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.LoggerBackend;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public abstract class AbstractBackend
extends LoggerBackend {
    private static volatile boolean cannotUseForcingLogger = false;
    private final Logger logger;

    public AbstractBackend(Logger logger) {
        this.logger = logger;
    }

    private static void publish(Logger logger, LogRecord logRecord) {
        for (Handler handler : logger.getHandlers()) {
            handler.publish(logRecord);
        }
        boolean bl2 = logger.getUseParentHandlers();
        if (bl2 && (logger = logger.getParent()) != null) {
            AbstractBackend.publish(logger, logRecord);
        }
    }

    public void forceLoggingViaChildLogger(LogRecord logRecord) {
        Level level;
        Logger logger = this.logger;
        logger = this.getForcingLogger(logger);
        try {
            level = Level.ALL;
        }
        catch (SecurityException securityException) {
            cannotUseForcingLogger = true;
            logger = Logger.getLogger("");
            level = Level.SEVERE;
            logger.log(level, "Forcing log statements with Flogger has been partially disabled.\nThe Flogger library cannot modify logger log levels, which is necessary to force log statements. This is likely due to an installed SecurityManager.\nForced log statements will still be published directly to log handlers, but will not be visible to the 'log(LogRecord)' method of Logger sub-classes.\n");
            AbstractBackend.publish(this.logger, logRecord);
            return;
        }
        logger.setLevel(level);
        logger.log(logRecord);
    }

    public Logger getForcingLogger(Logger object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = ((Logger)object).getName();
        stringBuilder.append((String)object);
        stringBuilder.append(".__forced__");
        return Logger.getLogger(stringBuilder.toString());
    }

    public final String getLoggerName() {
        return this.logger.getName();
    }

    public final boolean isLoggable(Level level) {
        return this.logger.isLoggable(level);
    }

    public void log(LogRecord logRecord, boolean bl2) {
        Object object;
        Object object2;
        if (bl2 && !(bl2 = ((Logger)(object2 = this.logger)).isLoggable((Level)(object = logRecord.getLevel())))) {
            object2 = this.logger.getFilter();
            if (object2 != null) {
                object2.isLoggable(logRecord);
            }
            if ((object2 = this.logger.getClass()) != (object = Logger.class) && !(bl2 = cannotUseForcingLogger)) {
                this.forceLoggingViaChildLogger(logRecord);
            } else {
                object2 = this.logger;
                AbstractBackend.publish((Logger)object2, logRecord);
            }
        } else {
            object2 = this.logger;
            ((Logger)object2).log(logRecord);
        }
    }
}

