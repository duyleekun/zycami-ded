/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.StackSize;

public final class LogSiteStackTrace
extends Exception {
    public LogSiteStackTrace(Throwable throwable, StackSize object, StackTraceElement[] stackTraceElementArray) {
        object = object.toString();
        super((String)object, throwable);
        this.setStackTrace(stackTraceElementArray);
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}

