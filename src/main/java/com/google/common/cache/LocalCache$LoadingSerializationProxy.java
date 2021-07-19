/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ManualSerializationProxy;
import com.google.common.collect.ImmutableMap;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class LocalCache$LoadingSerializationProxy
extends LocalCache$ManualSerializationProxy
implements LoadingCache,
Serializable {
    private static final long serialVersionUID = 1L;
    public transient LoadingCache autoDelegate;

    public LocalCache$LoadingSerializationProxy(LocalCache localCache) {
        super(localCache);
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        object = this.recreateCacheBuilder();
        CacheLoader cacheLoader = this.loader;
        this.autoDelegate = object = ((CacheBuilder)object).build(cacheLoader);
    }

    private Object readResolve() {
        return this.autoDelegate;
    }

    public final Object apply(Object object) {
        return this.autoDelegate.apply(object);
    }

    public Object get(Object object) {
        return this.autoDelegate.get(object);
    }

    public ImmutableMap getAll(Iterable iterable) {
        return this.autoDelegate.getAll(iterable);
    }

    public Object getUnchecked(Object object) {
        return this.autoDelegate.getUnchecked(object);
    }

    public void refresh(Object object) {
        this.autoDelegate.refresh(object);
    }
}

