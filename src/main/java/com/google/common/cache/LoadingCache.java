/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;

public interface LoadingCache
extends Cache,
Function {
    public Object apply(Object var1);

    public ConcurrentMap asMap();

    public Object get(Object var1);

    public ImmutableMap getAll(Iterable var1);

    public Object getUnchecked(Object var1);

    public void refresh(Object var1);
}

