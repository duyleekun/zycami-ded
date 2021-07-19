/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.StorageClient;
import cn.leancloud.query.AVQueryResult;
import e.a.v0.o;

public class StorageClient$7
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$7(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public Integer apply(AVQueryResult aVQueryResult) {
        AVLogger aVLogger = StorageClient.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("invoke within StorageClient.queryCount(). result:");
        charSequence.append(aVQueryResult);
        charSequence.append(", return:");
        int n10 = aVQueryResult.getCount();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        return aVQueryResult.getCount();
    }
}

