/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.FluentLogger$1;
import com.google.common.flogger.FluentLogger$Api;
import com.google.common.flogger.LogContext;
import com.google.common.flogger.parser.DefaultPrintfMessageParser;
import com.google.common.flogger.parser.MessageParser;
import java.util.logging.Level;

public final class FluentLogger$Context
extends LogContext
implements FluentLogger$Api {
    public final /* synthetic */ FluentLogger this$0;

    private FluentLogger$Context(FluentLogger fluentLogger, Level level, boolean bl2) {
        this.this$0 = fluentLogger;
        super(level, bl2);
    }

    public /* synthetic */ FluentLogger$Context(FluentLogger fluentLogger, Level level, boolean bl2, FluentLogger$1 fluentLogger$1) {
        this(fluentLogger, level, bl2);
    }

    public FluentLogger$Api api() {
        return this;
    }

    public FluentLogger getLogger() {
        return this.this$0;
    }

    public MessageParser getMessageParser() {
        return DefaultPrintfMessageParser.getInstance();
    }

    public FluentLogger$Api noOp() {
        return FluentLogger.NO_OP;
    }
}

