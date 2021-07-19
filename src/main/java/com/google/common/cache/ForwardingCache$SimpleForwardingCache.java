/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingCache;

public abstract class ForwardingCache$SimpleForwardingCache
extends ForwardingCache {
    private final Cache delegate;

    public ForwardingCache$SimpleForwardingCache(Cache cache) {
        this.delegate = cache = (Cache)Preconditions.checkNotNull(cache);
    }

    public final Cache delegate() {
        return this.delegate;
    }
}

