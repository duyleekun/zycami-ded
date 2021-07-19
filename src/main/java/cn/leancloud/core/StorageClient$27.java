/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$27$1;
import cn.leancloud.core.StorageClient$QueryExecutor;
import e.a.v0.o;
import e.a.z;

public class StorageClient$27
implements StorageClient$QueryExecutor {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ long val$maxCacheAge;
    public final /* synthetic */ String val$name;

    public StorageClient$27(StorageClient storageClient, String string2, String string3, long l10) {
        this.this$0 = storageClient;
        this.val$name = string2;
        this.val$cacheKey = string3;
        this.val$maxCacheAge = l10;
    }

    public z executor() {
        Object object = QueryResultCache.getInstance();
        Object object2 = this.val$name;
        String string2 = this.val$cacheKey;
        long l10 = this.val$maxCacheAge;
        object = ((QueryResultCache)object).getCacheRawResult((String)object2, string2, l10, true);
        object2 = new StorageClient$27$1(this);
        return ((z)object).H3((o)object2);
    }
}

