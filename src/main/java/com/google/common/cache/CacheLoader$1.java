/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$1$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.Map;
import java.util.concurrent.Executor;

public final class CacheLoader$1
extends CacheLoader {
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ CacheLoader val$loader;

    public CacheLoader$1(CacheLoader cacheLoader, Executor executor) {
        this.val$loader = cacheLoader;
        this.val$executor = executor;
    }

    public Object load(Object object) {
        return this.val$loader.load(object);
    }

    public Map loadAll(Iterable iterable) {
        return this.val$loader.loadAll(iterable);
    }

    public ListenableFuture reload(Object object, Object object2) {
        CacheLoader$1$1 cacheLoader$1$1 = new CacheLoader$1$1(this, object, object2);
        object = ListenableFutureTask.create(cacheLoader$1$1);
        this.val$executor.execute((Runnable)object);
        return object;
    }
}

