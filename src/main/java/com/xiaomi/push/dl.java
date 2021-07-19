/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class dl
implements LoggerInterface {
    private LoggerInterface a = null;
    private LoggerInterface b = null;

    public dl(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.a = loggerInterface;
        this.b = loggerInterface2;
    }

    public void log(String string2) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(string2);
        }
        if ((loggerInterface = this.b) != null) {
            loggerInterface.log(string2);
        }
    }

    public void log(String string2, Throwable throwable) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(string2, throwable);
        }
        if ((loggerInterface = this.b) != null) {
            loggerInterface.log(string2, throwable);
        }
    }

    public void setTag(String string2) {
    }
}

