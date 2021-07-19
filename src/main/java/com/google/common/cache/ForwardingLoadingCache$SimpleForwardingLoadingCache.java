/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;

public abstract class ForwardingLoadingCache$SimpleForwardingLoadingCache
extends ForwardingLoadingCache {
    private final LoadingCache delegate;

    public ForwardingLoadingCache$SimpleForwardingLoadingCache(LoadingCache loadingCache) {
        this.delegate = loadingCache = (LoadingCache)Preconditions.checkNotNull(loadingCache);
    }

    public final LoadingCache delegate() {
        return this.delegate;
    }
}

