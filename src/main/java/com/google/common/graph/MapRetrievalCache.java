/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.MapIteratorCache;
import com.google.common.graph.MapRetrievalCache$CacheEntry;
import java.util.Map;

public class MapRetrievalCache
extends MapIteratorCache {
    private volatile transient MapRetrievalCache$CacheEntry cacheEntry1;
    private volatile transient MapRetrievalCache$CacheEntry cacheEntry2;

    public MapRetrievalCache(Map map) {
        super(map);
    }

    private void addToCache(MapRetrievalCache$CacheEntry mapRetrievalCache$CacheEntry) {
        MapRetrievalCache$CacheEntry mapRetrievalCache$CacheEntry2;
        this.cacheEntry2 = mapRetrievalCache$CacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = mapRetrievalCache$CacheEntry;
    }

    private void addToCache(Object object, Object object2) {
        MapRetrievalCache$CacheEntry mapRetrievalCache$CacheEntry = new MapRetrievalCache$CacheEntry(object, object2);
        this.addToCache(mapRetrievalCache$CacheEntry);
    }

    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    public Object get(Object object) {
        Object object2 = this.getIfCached(object);
        if (object2 != null) {
            return object2;
        }
        object2 = this.getWithoutCaching(object);
        if (object2 != null) {
            this.addToCache(object, object2);
        }
        return object2;
    }

    public Object getIfCached(Object object) {
        Object object2;
        Object object3 = super.getIfCached(object);
        if (object3 != null) {
            return object3;
        }
        object3 = this.cacheEntry1;
        if (object3 != null && (object2 = ((MapRetrievalCache$CacheEntry)object3).key) == object) {
            return ((MapRetrievalCache$CacheEntry)object3).value;
        }
        object3 = this.cacheEntry2;
        if (object3 != null && (object2 = ((MapRetrievalCache$CacheEntry)object3).key) == object) {
            this.addToCache((MapRetrievalCache$CacheEntry)object3);
            return ((MapRetrievalCache$CacheEntry)object3).value;
        }
        return null;
    }
}

