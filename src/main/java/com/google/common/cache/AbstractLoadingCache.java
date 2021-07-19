/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public abstract class AbstractLoadingCache
extends AbstractCache
implements LoadingCache {
    public final Object apply(Object object) {
        return this.getUnchecked(object);
    }

    public ImmutableMap getAll(Iterable object) {
        boolean bl2;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl3 = linkedHashMap.containsKey(e10);
            if (bl3) continue;
            Object object2 = this.get(e10);
            linkedHashMap.put(e10, object2);
        }
        return ImmutableMap.copyOf((Map)linkedHashMap);
    }

    public Object getUnchecked(Object object) {
        try {
            return this.get(object);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(throwable);
            throw uncheckedExecutionException;
        }
    }

    public void refresh(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

