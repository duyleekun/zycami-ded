/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader$1;
import com.google.common.cache.CacheLoader$FunctionToCacheLoader;
import com.google.common.cache.CacheLoader$SupplierToCacheLoader;
import com.google.common.cache.CacheLoader$UnsupportedLoadingOperationException;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class CacheLoader {
    public static CacheLoader asyncReloading(CacheLoader cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        CacheLoader$1 cacheLoader$1 = new CacheLoader$1(cacheLoader, executor);
        return cacheLoader$1;
    }

    public static CacheLoader from(Function function) {
        CacheLoader$FunctionToCacheLoader cacheLoader$FunctionToCacheLoader = new CacheLoader$FunctionToCacheLoader(function);
        return cacheLoader$FunctionToCacheLoader;
    }

    public static CacheLoader from(Supplier supplier) {
        CacheLoader$SupplierToCacheLoader cacheLoader$SupplierToCacheLoader = new CacheLoader$SupplierToCacheLoader(supplier);
        return cacheLoader$SupplierToCacheLoader;
    }

    public abstract Object load(Object var1);

    public Map loadAll(Iterable object) {
        object = new CacheLoader$UnsupportedLoadingOperationException();
        throw object;
    }

    public ListenableFuture reload(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        return Futures.immediateFuture(this.load(object));
    }
}

