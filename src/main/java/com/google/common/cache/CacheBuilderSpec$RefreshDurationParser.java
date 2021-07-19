/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

public class CacheBuilderSpec$RefreshDurationParser
extends CacheBuilderSpec$DurationParser {
    public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long l10, TimeUnit timeUnit) {
        boolean bl2;
        TimeUnit timeUnit2 = cacheBuilderSpec.refreshTimeUnit;
        if (timeUnit2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            timeUnit2 = null;
        }
        Preconditions.checkArgument(bl2, "refreshAfterWrite already set");
        cacheBuilderSpec.refreshDuration = l10;
        cacheBuilderSpec.refreshTimeUnit = timeUnit;
    }
}

