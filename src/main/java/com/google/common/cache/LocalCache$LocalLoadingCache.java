/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingSerializationProxy;
import com.google.common.cache.LocalCache$LocalManualCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

public class LocalCache$LocalLoadingCache
extends LocalCache$LocalManualCache
implements LoadingCache {
    private static final long serialVersionUID = 1L;

    public LocalCache$LocalLoadingCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        cacheLoader = (CacheLoader)Preconditions.checkNotNull(cacheLoader);
        LocalCache localCache = new LocalCache(cacheBuilder, cacheLoader);
        super(localCache, null);
    }

    public final Object apply(Object object) {
        return this.getUnchecked(object);
    }

    public Object get(Object object) {
        return this.localCache.getOrLoad(object);
    }

    public ImmutableMap getAll(Iterable iterable) {
        return this.localCache.getAll(iterable);
    }

    public Object getUnchecked(Object object) {
        try {
            return this.get(object);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(throwable);
            throw uncheckedExecutionException;
        }
    }

    public void refresh(Object object) {
        this.localCache.refresh(object);
    }

    public Object writeReplace() {
        LocalCache localCache = this.localCache;
        LocalCache$LoadingSerializationProxy localCache$LoadingSerializationProxy = new LocalCache$LoadingSerializationProxy(localCache);
        return localCache$LoadingSerializationProxy;
    }
}

