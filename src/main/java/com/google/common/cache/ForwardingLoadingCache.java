/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;

public abstract class ForwardingLoadingCache
extends ForwardingCache
implements LoadingCache {
    public Object apply(Object object) {
        return this.delegate().apply(object);
    }

    public abstract LoadingCache delegate();

    public Object get(Object object) {
        return this.delegate().get(object);
    }

    public ImmutableMap getAll(Iterable iterable) {
        return this.delegate().getAll(iterable);
    }

    public Object getUnchecked(Object object) {
        return this.delegate().getUnchecked(object);
    }

    public void refresh(Object object) {
        this.delegate().refresh(object);
    }
}

