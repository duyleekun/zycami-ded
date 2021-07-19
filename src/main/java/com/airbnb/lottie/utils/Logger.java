/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;
import com.airbnb.lottie.utils.LogcatLogger;

public class Logger {
    private static LottieLogger INSTANCE;

    static {
        LogcatLogger logcatLogger = new LogcatLogger();
        INSTANCE = logcatLogger;
    }

    public static void debug(String string2) {
        INSTANCE.debug(string2);
    }

    public static void debug(String string2, Throwable throwable) {
        INSTANCE.debug(string2, throwable);
    }

    public static void error(String string2, Throwable throwable) {
        INSTANCE.error(string2, throwable);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void warning(String string2) {
        INSTANCE.warning(string2);
    }

    public static void warning(String string2, Throwable throwable) {
        INSTANCE.warning(string2, throwable);
    }
}

