/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;

public class TrimmedThrowableData {
    public final TrimmedThrowableData cause;
    public final String className;
    public final String localizedMessage;
    public final StackTraceElement[] stacktrace;

    public TrimmedThrowableData(Throwable throwable, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        Object object = throwable.getLocalizedMessage();
        this.localizedMessage = object;
        object = throwable.getClass().getName();
        this.className = object;
        object = throwable.getStackTrace();
        object = stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])object);
        this.stacktrace = object;
        throwable = throwable.getCause();
        if (throwable != null) {
            super(throwable, stackTraceTrimmingStrategy);
        } else {
            object = null;
        }
        this.cause = object;
    }
}

