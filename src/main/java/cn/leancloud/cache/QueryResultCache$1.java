/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.LocalStorage;
import cn.leancloud.cache.QueryResultCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;

public class QueryResultCache$1
implements Callable {
    public final /* synthetic */ QueryResultCache this$0;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ boolean val$isFinal;
    public final /* synthetic */ long val$maxAgeInMilliseconds;

    public QueryResultCache$1(QueryResultCache queryResultCache, String string2, boolean bl2, long l10) {
        this.this$0 = queryResultCache;
        this.val$cacheKey = string2;
        this.val$isFinal = bl2;
        this.val$maxAgeInMilliseconds = l10;
    }

    public String call() {
        Object object;
        Object object2 = this.this$0;
        String string2 = this.val$cacheKey;
        object2 = ((LocalStorage)object2).getCacheFile(string2);
        string2 = "";
        String string3 = "cache file(key=";
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
                    stringBuilder.append(string3);
                    string3 = this.val$cacheKey;
                    stringBuilder.append(string3);
                    stringBuilder.append(") is expired.");
                    string3 = stringBuilder.toString();
                    ((AVLogger)object2).d(string3);
                    boolean bl2 = this.val$isFinal;
                    if (!bl2) {
                        return string2;
                    }
                    object2 = new FileNotFoundException("cache file is expired.");
                    throw object2;
                }
            }
            if ((object2 = (Object)((LocalStorage)(object3 = this.this$0)).readData((File)object2)) == null) {
                object2 = QueryResultCache.access$000();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                string3 = this.val$cacheKey;
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(") is empty.");
                string3 = ((StringBuilder)object3).toString();
                ((AVLogger)object2).d(string3);
                boolean bl3 = this.val$isFinal;
                if (!bl3) {
                    return string2;
                }
                object2 = new InterruptedException("failed to read cache file.");
                throw object2;
            }
            int n10 = ((Object)object2).length;
            string2 = new String((byte[])object2, 0, n10, "UTF-8");
            object2 = QueryResultCache.access$000();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string3);
            string3 = this.val$cacheKey;
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append("), content: ");
            ((StringBuilder)object3).append(string2);
            string3 = ((StringBuilder)object3).toString();
            ((AVLogger)object2).d(string3);
            return string2;
        }
        object2 = QueryResultCache.access$000();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        string3 = this.val$cacheKey;
        stringBuilder.append(string3);
        stringBuilder.append(") not existed.");
        string3 = stringBuilder.toString();
        ((AVLogger)object2).d(string3);
        boolean bl4 = this.val$isFinal;
        if (!bl4) {
            return string2;
        }
        object2 = new FileNotFoundException("cache is not existed.");
        throw object2;
    }
}

