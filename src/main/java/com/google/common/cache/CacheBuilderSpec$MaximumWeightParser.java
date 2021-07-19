/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$LongParser;

public class CacheBuilderSpec$MaximumWeightParser
extends CacheBuilderSpec$LongParser {
    public void parseLong(CacheBuilderSpec cacheBuilderSpec, long l10) {
        Long l11;
        Long l12 = cacheBuilderSpec.maximumWeight;
        boolean bl2 = true;
        boolean bl3 = l12 == null ? bl2 : false;
        String string2 = "maximum weight was already set to ";
        Preconditions.checkArgument(bl3, string2, (Object)l12);
        l12 = cacheBuilderSpec.maximumSize;
        if (l12 != null) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "maximum size was already set to ", (Object)l12);
        cacheBuilderSpec.maximumWeight = l11 = Long.valueOf(l10);
    }
}

