/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$HashIterator;

public final class LocalCache$ValueIterator
extends LocalCache$HashIterator {
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$ValueIterator(LocalCache localCache) {
        this.this$0 = localCache;
        super(localCache);
    }

    public Object next() {
        return this.nextEntry().getValue();
    }
}

