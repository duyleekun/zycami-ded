/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.graph.MapIteratorCache$1;
import java.util.Map;
import java.util.Set;

public class MapIteratorCache {
    private final Map backingMap;
    private volatile transient Map.Entry cacheEntry;

    public MapIteratorCache(Map map) {
        this.backingMap = map = (Map)Preconditions.checkNotNull(map);
    }

    public static /* synthetic */ Map access$000(MapIteratorCache mapIteratorCache) {
        return mapIteratorCache.backingMap;
    }

    public static /* synthetic */ Map.Entry access$102(MapIteratorCache mapIteratorCache, Map.Entry entry) {
        mapIteratorCache.cacheEntry = entry;
        return entry;
    }

    public final void clear() {
        this.clearCache();
        this.backingMap.clear();
    }

    public void clearCache() {
        this.cacheEntry = null;
    }

    public final boolean containsKey(Object object) {
        boolean bl2;
        Object object2 = this.getIfCached(object);
        if (object2 == null && !(bl2 = (object2 = this.backingMap).containsKey(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object get(Object object) {
        Object object2 = this.getIfCached(object);
        if (object2 == null) {
            object2 = this.getWithoutCaching(object);
        }
        return object2;
    }

    public Object getIfCached(Object object) {
        Object k10;
        Map.Entry entry = this.cacheEntry;
        if (entry != null && (k10 = entry.getKey()) == object) {
            return entry.getValue();
        }
        return null;
    }

    public final Object getWithoutCaching(Object object) {
        return this.backingMap.get(object);
    }

    public final Object put(Object object, Object object2) {
        this.clearCache();
        return this.backingMap.put(object, object2);
    }

    public final Object remove(Object object) {
        this.clearCache();
        return this.backingMap.remove(object);
    }

    public final Set unmodifiableKeySet() {
        MapIteratorCache$1 mapIteratorCache$1 = new MapIteratorCache$1(this);
        return mapIteratorCache$1;
    }
}

