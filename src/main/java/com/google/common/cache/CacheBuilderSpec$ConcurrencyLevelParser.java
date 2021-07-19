/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$IntegerParser;

public class CacheBuilderSpec$ConcurrencyLevelParser
extends CacheBuilderSpec$IntegerParser {
    public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int n10) {
        Integer n11;
        Integer n12 = cacheBuilderSpec.concurrencyLevel;
        boolean bl2 = n12 == null;
        Preconditions.checkArgument(bl2, "concurrency level was already set to ", (Object)n12);
        cacheBuilderSpec.concurrencyLevel = n11 = Integer.valueOf(n10);
    }
}

