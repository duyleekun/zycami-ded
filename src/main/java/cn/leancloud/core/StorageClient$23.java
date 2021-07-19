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

public class StorageClient$23
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ boolean val$enableCache;

    public StorageClient$23(StorageClient storageClient, boolean bl2, String string2) {
        this.this$0 = storageClient;
        this.val$enableCache = bl2;
        this.val$cacheKey = string2;
    }

    public Object apply(Map object) {
        boolean bl2;
        block20: {
            CharSequence charSequence;
            Object object2 = "result";
            try {
                object = object.get(object2);
            }
            catch (Exception exception) {
                object2 = StorageClient.access$000();
                charSequence = new StringBuilder();
                charSequence.append("RPCFunction error: ");
                String string2 = exception.getMessage();
                charSequence.append(string2);
                string2 = charSequence.toString();
                ((AVLogger)object2).d(string2);
                return null;
            }
            bl2 = this.val$enableCache;
            if (!bl2) break block20;
            object2 = this.val$cacheKey;
            bl2 = StringUtil.isEmpty((String)object2);
            if (bl2) break block20;
            object2 = StorageClient.access$000();
            charSequence = new StringBuilder();
            String string3 = "cache rpc result:";
            charSequence.append(string3);
            string3 = JSON.toJSONString(object);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            ((AVLogger)object2).d((String)charSequence);
            object2 = QueryResultCache.getInstance();
            charSequence = this.val$cacheKey;
            string3 = JSON.toJSONString(object);
            ((QueryResultCache)object2).cacheResult((String)charSequence, string3);
        }
        if (bl2 = object instanceof Collection) {
            object = (Collection)object;
            return Utils.getObjectFrom((Collection)object);
        }
        bl2 = object instanceof Map;
        if (bl2) {
            object = (Map)object;
            object = Utils.getObjectFrom((Map)object);
        }
        return object;
    }
}

