/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

public final class CacheLoader$FunctionToCacheLoader
extends CacheLoader
implements Serializable {
    private static final long serialVersionUID;
    private final Function computingFunction;

    public CacheLoader$FunctionToCacheLoader(Function function) {
        this.computingFunction = function = (Function)Preconditions.checkNotNull(function);
    }

    public Object load(Object object) {
        Function function = this.computingFunction;
        object = Preconditions.checkNotNull(object);
        return function.apply(object);
    }
}

