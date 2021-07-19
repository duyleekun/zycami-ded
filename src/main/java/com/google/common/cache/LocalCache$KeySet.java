/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractCacheSet;
import com.google.common.cache.LocalCache$KeyIterator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

public final class LocalCache$KeySet
extends LocalCache$AbstractCacheSet {
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$KeySet(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        super(localCache, concurrentMap);
    }

    public boolean contains(Object object) {
        return this.map.containsKey(object);
    }

    public Iterator iterator() {
        LocalCache localCache = this.this$0;
        LocalCache$KeyIterator localCache$KeyIterator = new LocalCache$KeyIterator(localCache);
        return localCache$KeyIterator;
    }

    public boolean remove(Object object) {
        boolean bl2;
        ConcurrentMap concurrentMap = this.map;
        if ((object = concurrentMap.remove(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

