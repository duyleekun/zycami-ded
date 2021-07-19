/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractCache
implements Cache {
    public ConcurrentMap asMap() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void cleanUp() {
    }

    public Object get(Object object, Callable callable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableMap getAllPresent(Iterable object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2;
            Object e10 = object.next();
            boolean bl3 = linkedHashMap.containsKey(e10);
            if (bl3 || (object2 = this.getIfPresent(e10)) == null) continue;
            linkedHashMap.put(e10, object2);
        }
        return ImmutableMap.copyOf((Map)linkedHashMap);
    }

    public void invalidate(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void invalidateAll() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void invalidateAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            this.invalidate(e10);
        }
    }

    public void put(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            this.put(k10, entry);
        }
    }

    public long size() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public CacheStats stats() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

