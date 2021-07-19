/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.AVLogger$Level;
import cn.leancloud.logging.InternalLogger;
import cn.leancloud.logging.SimpleLogger$1;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleLogger
extends InternalLogger {
    private Logger logger = null;

    public SimpleLogger(Logger object) {
        if (object != null) {
            this.logger = object;
            return;
        }
        object = new IllegalArgumentException("Logger is null.");
        throw object;
    }

    private Level getNativeLevel(AVLogger$Level object) {
        int[] nArray = SimpleLogger$1.$SwitchMap$cn$leancloud$AVLogger$Level;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = Level.ALL;
                break;
            }
            case 6: {
                object = Level.FINER;
                break;
            }
            case 5: {
                object = Level.FINE;
                break;
            }
            case 4: {
                object = Level.INFO;
                break;
            }
            case 3: {
                object = Level.WARNING;
                break;
            }
            case 2: {
                object = Level.SEVERE;
                break;
            }
            case 1: {
                object = Level.OFF;
            }
        }
        return object;
    }

    public void internalWriteLog(AVLogger$Level object, String string2) {
        object = this.getNativeLevel((AVLogger$Level)((Object)object));
        Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Thread-");
        long l10 = Thread.currentThread().getId();
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        logger.log((Level)object, string2);
    }

    public void internalWriteLog(AVLogger$Level object, String string2, Throwable throwable) {
        object = this.getNativeLevel((AVLogger$Level)((Object)object));
        Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Thread-");
        long l10 = Thread.currentThread().getId();
        stringBuilder.append(l10);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        logger.log((Level)object, string2, throwable);
    }

    public void internalWriteLog(AVLogger$Level object, Throwable throwable) {
        object = this.getNativeLevel((AVLogger$Level)((Object)object));
        LogRecord logRecord = new LogRecord((Level)object, "");
        logRecord.setThrown(throwable);
        this.logger.log(logRecord);
    }

    public void setLevel(AVLogger$Level object) {
        super.setLevel((AVLogger$Level)((Object)object));
        Logger logger = this.logger;
        object = this.getNativeLevel((AVLogger$Level)((Object)object));
        logger.setLevel((Level)object);
    }
}

