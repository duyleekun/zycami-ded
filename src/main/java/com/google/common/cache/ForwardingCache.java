/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public abstract class ForwardingCache
extends ForwardingObject
implements Cache {
    public ConcurrentMap asMap() {
        return this.delegate().asMap();
    }

    public void cleanUp() {
        this.delegate().cleanUp();
    }

    public abstract Cache delegate();

    public Object get(Object object, Callable callable) {
        return this.delegate().get(object, callable);
    }

    public ImmutableMap getAllPresent(Iterable iterable) {
        return this.delegate().getAllPresent(iterable);
    }

    public Object getIfPresent(Object object) {
        return this.delegate().getIfPresent(object);
    }

    public void invalidate(Object object) {
        this.delegate().invalidate(object);
    }

    public void invalidateAll() {
        this.delegate().invalidateAll();
    }

    public void invalidateAll(Iterable iterable) {
        this.delegate().invalidateAll(iterable);
    }

    public void put(Object object, Object object2) {
        this.delegate().put(object, object2);
    }

    public void putAll(Map map) {
        this.delegate().putAll(map);
    }

    public long size() {
        return this.delegate().size();
    }

    public CacheStats stats() {
        return this.delegate().stats();
    }
}

