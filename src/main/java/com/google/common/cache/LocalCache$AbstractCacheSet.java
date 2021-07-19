/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

public abstract class LocalCache$AbstractCacheSet
extends AbstractSet {
    public final ConcurrentMap map;
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$AbstractCacheSet(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        this.map = concurrentMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public int size() {
        return this.map.size();
    }

    public Object[] toArray() {
        return LocalCache.access$200(this).toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return LocalCache.access$200(this).toArray(objectArray);
    }
}

