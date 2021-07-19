/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.backend.Metadata;
import com.google.common.flogger.backend.TemplateContext;
import java.util.logging.Level;

public interface LogData {
    public Object[] getArguments();

    public Level getLevel();

    public Object getLiteralArgument();

    public LogSite getLogSite();

    public String getLoggerName();

    public Metadata getMetadata();

    public TemplateContext getTemplateContext();

    public long getTimestampMicros();

    public long getTimestampNanos();

    public boolean wasForced();
}

