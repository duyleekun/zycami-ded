/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.StorageClient;
import e.a.e0;
import e.a.v0.o;
import java.util.Map;

public class StorageClient$4
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$className;
    public final /* synthetic */ long val$maxAgeInMilliseconds;
    public final /* synthetic */ Map val$query;

    public StorageClient$4(StorageClient storageClient, String string2, Map map, long l10) {
        this.this$0 = storageClient;
        this.val$className = string2;
        this.val$query = map;
        this.val$maxAgeInMilliseconds = l10;
    }

    public e0 apply(Throwable object) {
        AVLogger aVLogger = StorageClient.access$000();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("failed to query networking, cause: ");
        object = ((Throwable)object).getMessage();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(", try to query local cache.");
        object = ((StringBuilder)object2).toString();
        aVLogger.d((String)object);
        object2 = QueryResultCache.getInstance();
        String string2 = this.val$className;
        Map map = this.val$query;
        long l10 = this.val$maxAgeInMilliseconds;
        return ((QueryResultCache)object2).getCacheResult(string2, map, l10, true);
    }
}

