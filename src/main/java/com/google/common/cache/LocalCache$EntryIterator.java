/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;
import java.util.Map;

public final class LocalCache$EntryIterator
extends LocalCache$HashIterator {
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$EntryIterator(LocalCache localCache) {
        this.this$0 = localCache;
        super(localCache);
    }

    public Map.Entry next() {
        return this.nextEntry();
    }
}

