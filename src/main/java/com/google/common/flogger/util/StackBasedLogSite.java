/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.util;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.util.Checks;

public final class StackBasedLogSite
extends LogSite {
    private final StackTraceElement stackElement;

    public StackBasedLogSite(StackTraceElement stackTraceElement) {
        this.stackElement = stackTraceElement = (StackTraceElement)Checks.checkNotNull(stackTraceElement, "stack element");
    }

    public boolean equals(Object object) {
        StackTraceElement stackTraceElement;
        boolean bl2;
        boolean bl3 = object instanceof StackBasedLogSite;
        if (bl3 && (bl2 = (stackTraceElement = this.stackElement).equals(object = ((StackBasedLogSite)object).stackElement))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public String getClassName() {
        return this.stackElement.getClassName();
    }

    public String getFileName() {
        return this.stackElement.getFileName();
    }

    public int getLineNumber() {
        return Math.max(this.stackElement.getLineNumber(), 0);
    }

    public String getMethodName() {
        return this.stackElement.getMethodName();
    }

    public int hashCode() {
        return this.stackElement.hashCode();
    }
}

