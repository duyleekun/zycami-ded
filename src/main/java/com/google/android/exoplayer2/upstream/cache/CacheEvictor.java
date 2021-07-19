/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$Listener;

public interface CacheEvictor
extends Cache$Listener {
    public void onCacheInitialized();

    public void onStartFile(Cache var1, String var2, long var3, long var5);

    public boolean requiresCacheSpanTouches();
}

