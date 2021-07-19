/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$QueryExecutor;
import e.a.v0.o;
import e.a.z;

public class StorageClient$26
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ StorageClient$QueryExecutor val$cacheQueryExecutor;

    public StorageClient$26(StorageClient storageClient, StorageClient$QueryExecutor storageClient$QueryExecutor) {
        this.this$0 = storageClient;
        this.val$cacheQueryExecutor = storageClient$QueryExecutor;
    }

    public z apply(Throwable object) {
        AVLogger aVLogger = StorageClient.access$000();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to query networking, cause: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        stringBuilder.append(", try to query local cache.");
        object = stringBuilder.toString();
        aVLogger.d((String)object);
        return this.val$cacheQueryExecutor.executor();
    }
}

