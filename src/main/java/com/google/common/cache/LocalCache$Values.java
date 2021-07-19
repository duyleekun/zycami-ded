/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ValueIterator;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

public final class LocalCache$Values
extends AbstractCollection {
    private final ConcurrentMap map;
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$Values(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        this.map = concurrentMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean contains(Object object) {
        return this.map.containsValue(object);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Iterator iterator() {
        LocalCache localCache = this.this$0;
        LocalCache$ValueIterator localCache$ValueIterator = new LocalCache$ValueIterator(localCache);
        return localCache$ValueIterator;
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

