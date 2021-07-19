/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;

public interface Cache$Listener {
    public void onSpanAdded(Cache var1, CacheSpan var2);

    public void onSpanRemoved(Cache var1, CacheSpan var2);

    public void onSpanTouched(Cache var1, CacheSpan var2, CacheSpan var3);
}

