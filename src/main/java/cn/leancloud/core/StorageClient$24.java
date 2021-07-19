/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSON;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import java.util.Collection;
import java.util.Map;

public class StorageClient$24
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ boolean val$enableCache;

    public StorageClient$24(StorageClient storageClient, boolean bl2, String string2) {
        this.this$0 = storageClient;
        this.val$enableCache = bl2;
        this.val$cacheKey = string2;
    }

    public Object apply(Map object) {
        boolean bl2;
        Object object2;
        block20: {
            Object object3;
            object2 = "result";
            try {
                object2 = object.get(object2);
            }
            catch (Exception exception) {
                object2 = StorageClient.access$000();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("CloudFunction error: ");
                String string2 = exception.getMessage();
                ((StringBuilder)object3).append(string2);
                string2 = ((StringBuilder)object3).toString();
                ((AVLogger)object2).d(string2);
                return null;
            }
            boolean bl3 = this.val$enableCache;
            if (!bl3) break block20;
            object3 = this.val$cacheKey;
            bl3 = StringUtil.isEmpty((String)object3);
            if (bl3) break block20;
            object3 = StorageClient.access$000();
            CharSequence charSequence = new StringBuilder();
            String string3 = "cache cloud function result:";
            charSequence.append(string3);
            string3 = JSON.toJSONString(object2);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            ((AVLogger)object3).d((String)charSequence);
            object3 = QueryResultCache.getInstance();
            charSequence = this.val$cacheKey;
            object = JSON.toJSONString(object);
            ((QueryResultCache)object3).cacheResult((String)charSequence, (String)object);
        }
        if (bl2 = object2 instanceof Collection) {
            object2 = (Collection)object2;
            return Utils.getObjectFrom((Collection)object2);
        }
        bl2 = object2 instanceof Map;
        if (bl2) {
            object2 = (Map)object2;
            return Utils.getObjectFrom((Map)object2);
        }
        return object2;
    }
}

