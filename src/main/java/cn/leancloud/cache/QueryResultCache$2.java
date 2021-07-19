/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.LocalStorage;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.query.AVQueryResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class QueryResultCache$2
implements Callable {
    public final /* synthetic */ QueryResultCache this$0;
    public final /* synthetic */ String val$className;
    public final /* synthetic */ boolean val$isFinal;
    public final /* synthetic */ long val$maxAgeInMilliseconds;
    public final /* synthetic */ Map val$query;

    public QueryResultCache$2(QueryResultCache queryResultCache, String string2, Map map, boolean bl2, long l10) {
        this.this$0 = queryResultCache;
        this.val$className = string2;
        this.val$query = map;
        this.val$isFinal = bl2;
        this.val$maxAgeInMilliseconds = l10;
    }

    public List call() {
        Object object;
        ArrayList arrayList = this.val$className;
        Object object2 = this.val$query;
        arrayList = QueryResultCache.generateKeyForQueryCondition((String)((Object)arrayList), (Map)object2);
        object2 = this.this$0.getCacheFile((String)((Object)arrayList));
        String string2 = "cache file(key=";
        if (object2 != null && (object = ((File)object2).exists()) != 0) {
            Object object3;
            long l10 = this.val$maxAgeInMilliseconds;
            long l11 = 0L;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                l10 = System.currentTimeMillis();
                l11 = ((File)object2).lastModified();
                long l13 = (l10 -= l11) - (l11 = this.val$maxAgeInMilliseconds);
                object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object > 0) {
                    object2 = QueryResultCache.access$000();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append((String)((Object)arrayList));
                    stringBuilder.append(") is expired.");
                    arrayList = stringBuilder.toString();
                    ((AVLogger)object2).d((String)((Object)arrayList));
                    boolean bl2 = this.val$isFinal;
                    if (bl2) {
                        arrayList = new ArrayList();
                        return arrayList;
                    }
                    arrayList = new ArrayList("cache file is expired.");
                    throw arrayList;
                }
            }
            if ((object2 = (Object)((LocalStorage)(object3 = this.this$0)).readData((File)object2)) == null) {
                object2 = QueryResultCache.access$000();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)((Object)arrayList));
                ((StringBuilder)object3).append(") is empty.");
                arrayList = ((StringBuilder)object3).toString();
                ((AVLogger)object2).d((String)((Object)arrayList));
                boolean bl3 = this.val$isFinal;
                if (bl3) {
                    arrayList = new ArrayList();
                    return arrayList;
                }
                arrayList = new ArrayList("failed to read cache file.");
                throw arrayList;
            }
            int n10 = ((Object)object2).length;
            object3 = new String((byte[])object2, 0, n10, "UTF-8");
            object2 = QueryResultCache.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)((Object)arrayList));
            stringBuilder.append("), content: ");
            stringBuilder.append((String)object3);
            arrayList = stringBuilder.toString();
            ((AVLogger)object2).d((String)((Object)arrayList));
            return AVQueryResult.fromJSONString((String)object3).getResults();
        }
        object2 = QueryResultCache.access$000();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)((Object)arrayList));
        stringBuilder.append(") not existed.");
        arrayList = stringBuilder.toString();
        ((AVLogger)object2).d((String)((Object)arrayList));
        boolean bl4 = this.val$isFinal;
        if (bl4) {
            arrayList = new ArrayList();
            return arrayList;
        }
        arrayList = new ArrayList("cache is not existed.");
        throw arrayList;
    }
}

