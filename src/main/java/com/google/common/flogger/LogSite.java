/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSite$1;
import com.google.common.flogger.LogSite$InjectedLogSite;
import com.google.common.flogger.LogSiteKey;

public abstract class LogSite
implements LogSiteKey {
    public static final LogSite INVALID;
    public static final int UNKNOWN_LINE;

    static {
        LogSite$1 logSite$1 = new LogSite$1();
        INVALID = logSite$1;
    }

    public static LogSite injectedLogSite(String string2, String string3, int n10, String string4) {
        LogSite$InjectedLogSite logSite$InjectedLogSite = new LogSite$InjectedLogSite(string2, string3, n10, string4, null);
        return logSite$InjectedLogSite;
    }

    public abstract String getClassName();

    public abstract String getFileName();

    public abstract int getLineNumber();

    public abstract String getMethodName();

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogSite{ class=");
        String string2 = this.getClassName();
        stringBuilder.append(string2);
        stringBuilder.append(", method=");
        string2 = this.getMethodName();
        stringBuilder.append(string2);
        stringBuilder.append(", line=");
        int n10 = this.getLineNumber();
        stringBuilder.append(n10);
        string2 = this.getFileName();
        if (string2 != null) {
            stringBuilder.append(", file=");
            string2 = this.getFileName();
            stringBuilder.append(string2);
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

