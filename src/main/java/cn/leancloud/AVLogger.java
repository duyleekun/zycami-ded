/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger$Level;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.logging.InternalLogger;
import cn.leancloud.logging.InternalLoggerAdapter;
import cn.leancloud.utils.StringUtil;

public class AVLogger {
    private volatile InternalLogger internalLogger = null;
    private String tag = null;

    public AVLogger(String string2) {
        this.tag = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private InternalLogger getInternalLogger() {
        Object object = this.internalLogger;
        if (object != null) return this.internalLogger;
        synchronized (this) {
            object = this.internalLogger;
            if (object != null) return this.internalLogger;
            object = AppConfiguration.getLogAdapter();
            String string2 = this.tag;
            this.internalLogger = object = ((InternalLoggerAdapter)object).getLogger(string2);
            return this.internalLogger;
        }
    }

    public void d(String string2) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.DEBUG;
        this.writeLog(aVLogger$Level, string2);
    }

    public void d(String string2, Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.DEBUG;
        this.writeLog(aVLogger$Level, string2, throwable);
    }

    public void e(String string2) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.ERROR;
        this.writeLog(aVLogger$Level, string2);
    }

    public void e(String string2, Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.ERROR;
        this.writeLog(aVLogger$Level, string2, throwable);
    }

    public void i(String string2) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.INFO;
        this.writeLog(aVLogger$Level, string2);
    }

    public void i(String string2, Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.INFO;
        this.writeLog(aVLogger$Level, string2, throwable);
    }

    public boolean isEnabled(AVLogger$Level aVLogger$Level) {
        int n10;
        AVLogger$Level aVLogger$Level2 = AVOSCloud.getLogLevel();
        int n11 = aVLogger$Level2.intLevel();
        if (n11 >= (n10 = aVLogger$Level.intLevel())) {
            n10 = 1;
        } else {
            n10 = 0;
            aVLogger$Level = null;
        }
        return n10;
    }

    public void v(String string2) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.VERBOSE;
        this.writeLog(aVLogger$Level, string2);
    }

    public void v(String string2, Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.VERBOSE;
        this.writeLog(aVLogger$Level, string2, throwable);
    }

    public void w(String string2) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.WARNING;
        this.writeLog(aVLogger$Level, string2);
    }

    public void w(String string2, Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.WARNING;
        this.writeLog(aVLogger$Level, string2, throwable);
    }

    public void w(Throwable throwable) {
        AVLogger$Level aVLogger$Level = AVLogger$Level.WARNING;
        this.writeLog(aVLogger$Level, throwable);
    }

    public void writeLog(AVLogger$Level aVLogger$Level, String string2) {
        boolean bl2 = this.isEnabled(aVLogger$Level);
        if (!bl2) {
            return;
        }
        if (string2 == null) {
            string2 = "";
        }
        this.getInternalLogger().writeLog(aVLogger$Level, string2);
    }

    public void writeLog(AVLogger$Level aVLogger$Level, String string2, Throwable throwable) {
        if (throwable == null) {
            this.writeLog(aVLogger$Level, string2);
            return;
        }
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            this.writeLog(aVLogger$Level, throwable);
            return;
        }
        bl2 = this.isEnabled(aVLogger$Level);
        if (!bl2) {
            return;
        }
        this.getInternalLogger().writeLog(aVLogger$Level, string2, throwable);
    }

    public void writeLog(AVLogger$Level aVLogger$Level, Throwable throwable) {
        boolean bl2 = this.isEnabled(aVLogger$Level);
        if (!bl2) {
            return;
        }
        if (throwable == null) {
            return;
        }
        this.getInternalLogger().writeLog(aVLogger$Level, throwable);
    }
}

