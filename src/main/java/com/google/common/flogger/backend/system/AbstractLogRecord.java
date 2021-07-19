/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend.system;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.backend.LogData;
import com.google.common.flogger.backend.Metadata;
import com.google.common.flogger.backend.SimpleMessageFormatter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public abstract class AbstractLogRecord
extends LogRecord {
    private final LogData data;

    public AbstractLogRecord(LogData logData) {
        Object object = logData.getLevel();
        super((Level)object, null);
        this.data = logData;
        object = logData.getLogSite();
        String string2 = ((LogSite)object).getClassName();
        this.setSourceClassName(string2);
        object = ((LogSite)object).getMethodName();
        this.setSourceMethodName((String)object);
        object = logData.getLoggerName();
        this.setLoggerName((String)object);
        object = TimeUnit.NANOSECONDS;
        long l10 = logData.getTimestampNanos();
        long l11 = ((TimeUnit)((Object)object)).toMillis(l10);
        this.setMillis(l11);
    }

    public AbstractLogRecord(RuntimeException object, LogData logData) {
        this(logData);
        Serializable serializable = logData.getLevel();
        int n10 = ((Level)serializable).intValue();
        Level level = Level.WARNING;
        int n11 = level.intValue();
        if (n10 >= n11) {
            level = logData.getLevel();
        }
        this.setLevel(level);
        this.setThrown((Throwable)object);
        super("LOGGING ERROR: ");
        object = ((Throwable)object).getMessage();
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append('\n');
        AbstractLogRecord.safeAppend(logData, (StringBuilder)serializable);
        object = ((StringBuilder)serializable).toString();
        this.setMessage((String)object);
    }

    private static void safeAppend(LogData logData, StringBuilder stringBuilder) {
        stringBuilder.append("  original message: ");
        Object object = logData.getTemplateContext();
        String string2 = "\n    ";
        int n10 = 0;
        if (object == null) {
            object = logData.getLiteralArgument();
            stringBuilder.append(object);
        } else {
            object = logData.getTemplateContext().getMessage();
            stringBuilder.append((String)object);
            stringBuilder.append("\n  original arguments:");
            for (Object object2 : logData.getArguments()) {
                stringBuilder.append(string2);
                object2 = SimpleMessageFormatter.safeToString(object2);
                stringBuilder.append((String)object2);
            }
        }
        object = logData.getMetadata();
        int n11 = ((Metadata)object).size();
        if (n11 > 0) {
            Object object3 = "\n  metadata:";
            stringBuilder.append((String)object3);
            while (n10 < (n11 = ((Metadata)object).size())) {
                stringBuilder.append(string2);
                object3 = ((Metadata)object).getKey(n10).getLabel();
                stringBuilder.append((String)object3);
                stringBuilder.append(": ");
                object3 = ((Metadata)object).getValue(n10);
                stringBuilder.append(object3);
                ++n10;
            }
        }
        stringBuilder.append("\n  level: ");
        object = logData.getLevel();
        stringBuilder.append(object);
        stringBuilder.append("\n  timestamp (nanos): ");
        long l10 = logData.getTimestampNanos();
        stringBuilder.append(l10);
        stringBuilder.append("\n  class: ");
        object = logData.getLogSite().getClassName();
        stringBuilder.append((String)object);
        stringBuilder.append("\n  method: ");
        object = logData.getLogSite().getMethodName();
        stringBuilder.append((String)object);
        stringBuilder.append("\n  line number: ");
        int n12 = logData.getLogSite().getLineNumber();
        stringBuilder.append(n12);
    }

    public final LogData getLogData() {
        return this.data;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(" {\n  message: ");
        object = this.getMessage();
        stringBuilder.append((String)object);
        stringBuilder.append("\n  arguments: ");
        object = this.getParameters();
        object = object != null ? Arrays.asList(this.getParameters()) : "<none>";
        stringBuilder.append(object);
        stringBuilder.append('\n');
        AbstractLogRecord.safeAppend(this.getLogData(), stringBuilder);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}

