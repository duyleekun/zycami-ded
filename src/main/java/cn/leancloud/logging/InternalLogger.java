/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.logging;

import cn.leancloud.AVLogger$Level;

public abstract class InternalLogger {
    private AVLogger$Level level;

    public InternalLogger() {
        AVLogger$Level aVLogger$Level;
        this.level = aVLogger$Level = AVLogger$Level.INFO;
    }

    public abstract void internalWriteLog(AVLogger$Level var1, String var2);

    public abstract void internalWriteLog(AVLogger$Level var1, String var2, Throwable var3);

    public abstract void internalWriteLog(AVLogger$Level var1, Throwable var2);

    public void setLevel(AVLogger$Level aVLogger$Level) {
        this.level = aVLogger$Level;
    }

    public void writeLog(AVLogger$Level aVLogger$Level, String string2) {
        this.internalWriteLog(aVLogger$Level, string2);
    }

    public void writeLog(AVLogger$Level aVLogger$Level, String string2, Throwable throwable) {
        this.internalWriteLog(aVLogger$Level, string2, throwable);
    }

    public void writeLog(AVLogger$Level aVLogger$Level, Throwable throwable) {
        this.internalWriteLog(aVLogger$Level, throwable);
    }
}

