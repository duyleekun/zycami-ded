/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import d.h.a.a.q0.e.a;

public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = a.a;

    public static /* synthetic */ String a(DataSpec dataSpec) {
        String string2 = dataSpec.key;
        if (string2 == null) {
            dataSpec = dataSpec.uri;
            string2 = dataSpec.toString();
        }
        return string2;
    }

    public String buildCacheKey(DataSpec var1);
}

