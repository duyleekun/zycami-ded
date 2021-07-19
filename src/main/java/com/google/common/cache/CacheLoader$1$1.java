/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$1;
import java.util.concurrent.Callable;

public class CacheLoader$1$1
implements Callable {
    public final /* synthetic */ CacheLoader$1 this$0;
    public final /* synthetic */ Object val$key;
    public final /* synthetic */ Object val$oldValue;

    public CacheLoader$1$1(CacheLoader$1 var1_1, Object object, Object object2) {
        this.this$0 = var1_1;
        this.val$key = object;
        this.val$oldValue = object2;
    }

    public Object call() {
        CacheLoader cacheLoader = this.this$0.val$loader;
        Object object = this.val$key;
        Object object2 = this.val$oldValue;
        return cacheLoader.reload(object, object2).get();
    }
}

