/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.logging;

import com.google.firebase.perf.logging.LogWrapper;
import java.util.Locale;

public class AndroidLogger {
    private static volatile AndroidLogger instance;
    private boolean isLogcatEnabled = false;
    private final LogWrapper logWrapper;

    private AndroidLogger() {
        this(null);
    }

    public AndroidLogger(LogWrapper logWrapper) {
        if (logWrapper == null) {
            logWrapper = LogWrapper.getInstance();
        }
        this.logWrapper = logWrapper;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AndroidLogger getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = AndroidLogger.class;
        synchronized (object) {
            AndroidLogger androidLogger = instance;
            if (androidLogger != null) return instance;
            instance = androidLogger = new AndroidLogger();
            return instance;
        }
    }

    public void debug(String string2) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            logWrapper.d(string2);
        }
    }

    public void debug(String string2, Object ... objectArray) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            Locale locale = Locale.ENGLISH;
            string2 = String.format(locale, string2, objectArray);
            logWrapper.d(string2);
        }
    }

    public void error(String string2) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            logWrapper.e(string2);
        }
    }

    public void error(String string2, Object ... objectArray) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            Locale locale = Locale.ENGLISH;
            string2 = String.format(locale, string2, objectArray);
            logWrapper.e(string2);
        }
    }

    public void info(String string2) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            logWrapper.i(string2);
        }
    }

    public void info(String string2, Object ... objectArray) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            Locale locale = Locale.ENGLISH;
            string2 = String.format(locale, string2, objectArray);
            logWrapper.i(string2);
        }
    }

    public boolean isLogcatEnabled() {
        return this.isLogcatEnabled;
    }

    public void setLogcatEnabled(boolean bl2) {
        this.isLogcatEnabled = bl2;
    }

    public void verbose(String string2) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            logWrapper.v(string2);
        }
    }

    public void verbose(String string2, Object ... objectArray) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            Locale locale = Locale.ENGLISH;
            string2 = String.format(locale, string2, objectArray);
            logWrapper.v(string2);
        }
    }

    public void warn(String string2) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            logWrapper.w(string2);
        }
    }

    public void warn(String string2, Object ... objectArray) {
        boolean bl2 = this.isLogcatEnabled;
        if (bl2) {
            LogWrapper logWrapper = this.logWrapper;
            Locale locale = Locale.ENGLISH;
            string2 = String.format(locale, string2, objectArray);
            logWrapper.w(string2);
        }
    }
}

