/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.log;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class MobUncaughtExceptionHandler
implements Thread.UncaughtExceptionHandler {
    private static boolean disable = false;
    private static boolean isDebug = false;
    private static Thread.UncaughtExceptionHandler oriHandler;

    private MobUncaughtExceptionHandler() {
    }

    public static void closeLog() {
        isDebug = false;
    }

    public static void disable() {
        disable = true;
    }

    public static void openLog() {
        isDebug = true;
    }

    public static void register() {
        boolean bl2 = disable;
        if (!bl2) {
            oriHandler = Thread.getDefaultUncaughtExceptionHandler();
            MobUncaughtExceptionHandler mobUncaughtExceptionHandler = new MobUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(mobUncaughtExceptionHandler);
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        Object object;
        boolean bl2 = isDebug;
        if (bl2) {
            object = MobLog.getInstance();
            ((NLog)object).wtf(throwable);
        }
        MobLog.getInstance().crash(throwable);
        object = oriHandler;
        if (object != null) {
            object.uncaughtException(thread, throwable);
        }
    }
}

