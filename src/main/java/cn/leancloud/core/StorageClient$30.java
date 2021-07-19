/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVQuery$CachePolicy;
import cn.leancloud.AVUser;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$QueryExecutor;
import e.a.z;
import java.util.Map;

public class StorageClient$30
implements StorageClient$QueryExecutor {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ AVUser val$asAuthenticatedUser;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ AVQuery$CachePolicy val$cachePolicy;
    public final /* synthetic */ String val$name;
    public final /* synthetic */ Map val$params;

    public StorageClient$30(StorageClient storageClient, AVUser aVUser, String string2, Map map, AVQuery$CachePolicy aVQuery$CachePolicy, String string3) {
        this.this$0 = storageClient;
        this.val$asAuthenticatedUser = aVUser;
        this.val$name = string2;
        this.val$params = map;
        this.val$cachePolicy = aVQuery$CachePolicy;
        this.val$cacheKey = string3;
    }

    public z executor() {
        boolean bl2;
        StorageClient storageClient = this.this$0;
        AVUser aVUser = this.val$asAuthenticatedUser;
        String string2 = this.val$name;
        Map map = this.val$params;
        AVQuery$CachePolicy aVQuery$CachePolicy = this.val$cachePolicy;
        Object object = AVQuery$CachePolicy.IGNORE_CACHE;
        if (aVQuery$CachePolicy != object && aVQuery$CachePolicy != (object = AVQuery$CachePolicy.NETWORK_ONLY)) {
            bl2 = true;
        } else {
            bl2 = false;
            aVQuery$CachePolicy = null;
        }
        object = this.val$cacheKey;
        return storageClient.callFunction(aVUser, string2, map, bl2, (String)object);
    }
}

