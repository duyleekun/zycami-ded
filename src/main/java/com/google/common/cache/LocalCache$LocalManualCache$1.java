/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache$LocalManualCache;
import java.util.concurrent.Callable;

public class LocalCache$LocalManualCache$1
extends CacheLoader {
    public final /* synthetic */ LocalCache$LocalManualCache this$0;
    public final /* synthetic */ Callable val$valueLoader;

    public LocalCache$LocalManualCache$1(LocalCache$LocalManualCache localCache$LocalManualCache, Callable callable) {
        this.this$0 = localCache$LocalManualCache;
        this.val$valueLoader = callable;
    }

    public Object load(Object object) {
        return this.val$valueLoader.call();
    }
}

