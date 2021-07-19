/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public interface Cache {
    public ConcurrentMap asMap();

    public void cleanUp();

    public Object get(Object var1, Callable var2);

    public ImmutableMap getAllPresent(Iterable var1);

    public Object getIfPresent(Object var1);

    public void invalidate(Object var1);

    public void invalidateAll();

    public void invalidateAll(Iterable var1);

    public void put(Object var1, Object var2);

    public void putAll(Map var1);

    public long size();

    public CacheStats stats();
}

