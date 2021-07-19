/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSiteStats$RateLimitPeriod;
import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.StackSize;
import com.google.common.flogger.backend.Tags;

public final class LogContext$Key {
    public static final MetadataKey CONTEXT_STACK_SIZE;
    public static final MetadataKey LOG_AT_MOST_EVERY;
    public static final MetadataKey LOG_CAUSE;
    public static final MetadataKey LOG_EVERY_N;
    public static final MetadataKey TAGS;
    public static final MetadataKey WAS_FORCED;

    static {
        LOG_CAUSE = MetadataKey.single("cause", Throwable.class);
        LOG_EVERY_N = MetadataKey.single("ratelimit_count", Integer.class);
        LOG_AT_MOST_EVERY = MetadataKey.single("ratelimit_period", LogSiteStats.RateLimitPeriod.class);
        WAS_FORCED = MetadataKey.single("forced", Boolean.class);
        TAGS = MetadataKey.single("tags", Tags.class);
        CONTEXT_STACK_SIZE = MetadataKey.single("stack_size", StackSize.class);
    }

    private LogContext$Key() {
    }
}

