/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.SimpleMessageFormatter;
import com.google.common.flogger.backend.SimpleMessageFormatter$SimpleLogHandler;
import com.google.common.flogger.backend.system.AbstractLogRecord;
import java.util.logging.Level;

public final class SimpleLogRecord
extends AbstractLogRecord
implements SimpleMessageFormatter$SimpleLogHandler {
    private SimpleLogRecord(LogData logData) {
        super(logData);
        SimpleMessageFormatter.format(logData, this);
    }

    private SimpleLogRecord(RuntimeException runtimeException, LogData logData) {
        super(runtimeException, logData);
    }

    public static SimpleLogRecord create(LogData logData) {
        SimpleLogRecord simpleLogRecord = new SimpleLogRecord(logData);
        return simpleLogRecord;
    }

    public static SimpleLogRecord error(RuntimeException runtimeException, LogData logData) {
        SimpleLogRecord simpleLogRecord = new SimpleLogRecord(runtimeException, logData);
        return simpleLogRecord;
    }

    public void handleFormattedLogMessage(Level level, String string2, Throwable throwable) {
        this.setMessage(string2);
        this.setThrown(throwable);
    }
}

