/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler$CrashListener;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashlyticsUncaughtExceptionHandler
implements Thread.UncaughtExceptionHandler {
    private final CrashlyticsUncaughtExceptionHandler$CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException;
    private final SettingsDataProvider settingsDataProvider;

    public CrashlyticsUncaughtExceptionHandler(CrashlyticsUncaughtExceptionHandler$CrashListener object, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.crashListener = object;
        this.settingsDataProvider = settingsDataProvider;
        this.defaultHandler = uncaughtExceptionHandler;
        this.isHandlingException = object = new AtomicBoolean(false);
    }

    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void uncaughtException(Thread var1_1, Throwable var2_2) {
        block7: {
            block6: {
                var3_3 = this.isHandlingException;
                var4_4 = true;
                var3_3.set(var4_4);
                var3_3 = null;
                var5_5 = "Completed exception processing. Invoking default exception handler.";
                if (var1_1 != null) ** GOTO lbl12
                try {
                    var6_6 = Logger.getLogger();
                    var7_9 = "Could not handle uncaught exception; null thread";
                    var6_6.e(var7_9);
                    break block6;
lbl12:
                    // 1 sources

                    if (var2_2 == null) {
                        var6_6 = Logger.getLogger();
                        var7_10 = "Could not handle uncaught exception; null throwable";
                        var6_6.e(var7_10);
                        break block6;
                    } else {
                        var6_6 = this.crashListener;
                        var7_11 = this.settingsDataProvider;
                        var6_6.onUncaughtException(var7_11, (Thread)var1_1, var2_2);
                    }
                    break block6;
                }
                catch (Throwable var6_7) {
                    break block7;
                }
                catch (Exception var6_8) {}
                var7_12 = Logger.getLogger();
                var8_13 = "An error occurred in the uncaught exception handler";
                var7_12.e(var8_13, var6_8);
            }
            var6_6 = Logger.getLogger();
            var6_6.d((String)var5_5);
            var5_5 = this.defaultHandler;
            var5_5.uncaughtException((Thread)var1_1, var2_2);
            var1_1 = this.isHandlingException;
            var1_1.set(false);
            return;
        }
        Logger.getLogger().d((String)var5_5);
        this.defaultHandler.uncaughtException((Thread)var1_1, var2_2);
        this.isHandlingException.set(false);
        throw var6_7;
    }
}

