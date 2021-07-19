/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.LoggerBackend;
import com.google.common.flogger.backend.Platform$LazyHolder;
import com.google.common.flogger.backend.Platform$LogCallerFinder;
import com.google.common.flogger.backend.Tags;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class Platform {
    private static String ANDROID_PLATFORM = "com.google.common.flogger.backend.android.AndroidPlatform";
    private static final String[] AVAILABLE_PLATFORMS;
    private static String DEFAULT_PLATFORM = "com.google.common.flogger.backend.system.DefaultPlatform";

    static {
        String[] stringArray = new String[]{"com.google.common.flogger.backend.system.DefaultPlatform"};
        AVAILABLE_PLATFORMS = stringArray;
    }

    public static /* synthetic */ String[] access$000() {
        return AVAILABLE_PLATFORMS;
    }

    public static LoggerBackend getBackend(String string2) {
        return Platform$LazyHolder.access$100().getBackendImpl(string2);
    }

    public static Platform$LogCallerFinder getCallerFinder() {
        return Platform$LazyHolder.access$100().getCallerFinderImpl();
    }

    public static String getConfigInfo() {
        return Platform$LazyHolder.access$100().getConfigInfoImpl();
    }

    public static long getCurrentTimeNanos() {
        return Platform$LazyHolder.access$100().getCurrentTimeNanosImpl();
    }

    public static Tags getInjectedTags() {
        return Platform$LazyHolder.access$100().getInjectedTagsImpl();
    }

    public static boolean shouldForceLogging(String string2, Level level, boolean bl2) {
        return Platform$LazyHolder.access$100().shouldForceLoggingImpl(string2, level, bl2);
    }

    public abstract LoggerBackend getBackendImpl(String var1);

    public abstract Platform$LogCallerFinder getCallerFinderImpl();

    public abstract String getConfigInfoImpl();

    public long getCurrentTimeNanosImpl() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l10 = System.currentTimeMillis();
        return timeUnit.toNanos(l10);
    }

    public Tags getInjectedTagsImpl() {
        return Tags.empty();
    }

    public boolean shouldForceLoggingImpl(String string2, Level level, boolean bl2) {
        return false;
    }
}

