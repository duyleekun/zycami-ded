/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$3;
import cn.leancloud.query.AVQueryResult;
import e.a.v0.o;
import java.util.List;

public class StorageClient$3$1
implements o {
    public final /* synthetic */ StorageClient$3 this$1;

    public StorageClient$3$1(StorageClient$3 storageClient$3) {
        this.this$1 = storageClient$3;
    }

    public List apply(AVQueryResult aVQueryResult) {
        int n10;
        Object object;
        Object object2;
        boolean bl2;
        Object object3 = this.this$1.val$className;
        aVQueryResult.setClassName((String)object3);
        object3 = aVQueryResult.getResults().iterator();
        while (bl2 = object3.hasNext()) {
            object2 = (AVObject)object3.next();
            object = this.this$1.val$className;
            ((AVObject)object2).setClassName((String)object);
        }
        object3 = QueryResultCache.getInstance();
        object2 = this.this$1.val$cacheKey;
        object = aVQueryResult.toJSONString();
        ((QueryResultCache)object3).cacheResult((String)object2, (String)object);
        object3 = StorageClient.access$000();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("invoke within StorageClient.queryObjects(). resultSize:");
        object = aVQueryResult.getResults();
        if (object != null) {
            object = aVQueryResult.getResults();
            n10 = object.size();
        } else {
            n10 = 0;
            object = null;
        }
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object3).d((String)object2);
        return aVQueryResult.getResults();
    }
}

