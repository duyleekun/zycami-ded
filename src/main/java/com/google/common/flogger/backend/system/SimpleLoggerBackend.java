/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.system.AbstractBackend;
import com.google.common.flogger.backend.system.SimpleLogRecord;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleLoggerBackend
extends AbstractBackend {
    public SimpleLoggerBackend(Logger logger) {
        super(logger);
    }

    public void handleError(RuntimeException serializable, LogData logData) {
        serializable = SimpleLogRecord.error(serializable, logData);
        boolean bl2 = logData.wasForced();
        this.log((LogRecord)serializable, bl2);
    }

    public void log(LogData logData) {
        SimpleLogRecord simpleLogRecord = SimpleLogRecord.create(logData);
        boolean bl2 = logData.wasForced();
        this.log(simpleLogRecord, bl2);
    }
}

