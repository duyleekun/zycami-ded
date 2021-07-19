/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.LocalStorage;
import cn.leancloud.cache.QueryResultCache$1;
import cn.leancloud.cache.QueryResultCache$2;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class QueryResultCache
extends LocalStorage {
    private static QueryResultCache INSTANCE;
    private static final AVLogger LOGGER;
    private ExecutorService executor;

    static {
        LOGGER = LogUtil.getLogger(QueryResultCache.class);
        INSTANCE = null;
    }

    private QueryResultCache() {
        Object object = AppConfiguration.getQueryResultCacheDir();
        super((String)object);
        this.executor = object = Executors.newFixedThreadPool(2);
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static String generateCachedKey(String object, Map object2) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        object = object2.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            stringBuilder.append(string2);
            string2 = "=";
            stringBuilder.append(string2);
            object2 = object2.getValue().toString();
            stringBuilder.append((String)object2);
            object2 = "&";
            stringBuilder.append((String)object2);
        }
        return MDFive.computeMD5(stringBuilder.toString());
    }

    public static String generateKeyForQueryCondition(String object, Map object2) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        object = object2.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            stringBuilder.append(string2);
            string2 = "=";
            stringBuilder.append(string2);
            object2 = (String)object2.getValue();
            stringBuilder.append((String)object2);
            object2 = "&";
            stringBuilder.append((String)object2);
        }
        return MDFive.computeMD5(stringBuilder.toString());
    }

    public static QueryResultCache getInstance() {
        Class<QueryResultCache> clazz = QueryResultCache.class;
        synchronized (clazz) {
            QueryResultCache queryResultCache = INSTANCE;
            if (queryResultCache == null) {
                INSTANCE = queryResultCache = new QueryResultCache();
            }
            queryResultCache = INSTANCE;
            return queryResultCache;
        }
    }

    public String cacheResult(String string2, String object) {
        Object object2 = LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("save cache. key=");
        charSequence.append(string2);
        String string3 = ", value=";
        charSequence.append(string3);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        ((AVLogger)object2).d((String)charSequence);
        boolean bl2 = StringUtil.isEmpty(string2);
        charSequence = null;
        if (!bl2 && object != null) {
            object2 = "UTF-8";
            object = ((String)object).getBytes((String)object2);
            try {
                return super.saveData(string2, (byte[])object);
            }
            catch (Exception exception) {
                object = LOGGER;
                ((AVLogger)object).w(exception);
            }
        }
        return null;
    }

    public z getCacheRawResult(String object, String object2, long l10, boolean bl2) {
        QueryResultCache$1 queryResultCache$1;
        AVLogger aVLogger = LOGGER;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("try to get cache raw result for class:");
        ((StringBuilder)object3).append((String)object);
        object = ((StringBuilder)object3).toString();
        aVLogger.d((String)object);
        object = AppConfiguration.getDefaultScheduler();
        boolean bl3 = AppConfiguration.isAsynchronized();
        object3 = queryResultCache$1;
        queryResultCache$1 = new QueryResultCache$1(this, (String)object2, bl2, l10);
        object2 = new FutureTask(queryResultCache$1);
        Object object4 = this.executor;
        object4.submit((Runnable)object2);
        object2 = z.S2(object2);
        if (bl3) {
            object4 = b.d();
            object2 = ((z)object2).L5((h0)object4);
        }
        if (object != null) {
            object = object.create();
            object2 = ((z)object2).i4((h0)object);
        }
        return object2;
    }

    public z getCacheRawResult(String string2, Map map, long l10, boolean bl2) {
        AVLogger aVLogger = LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("try to get cache raw result for class:");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        String string3 = QueryResultCache.generateKeyForQueryCondition(string2, map);
        return this.getCacheRawResult(string2, string3, l10, bl2);
    }

    public z getCacheResult(String futureTask, Map map, long l10, boolean bl2) {
        Object object = LOGGER;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("try to get cache result for class:");
        charSequence.append((String)((Object)futureTask));
        charSequence = charSequence.toString();
        ((AVLogger)object).d((String)charSequence);
        object = new QueryResultCache$2(this, (String)((Object)futureTask), map, bl2, l10);
        futureTask = new FutureTask(object);
        this.executor.submit(futureTask);
        return z.S2(futureTask);
    }

    public boolean hasCachedResult(String string2, Map object, long l10) {
        Object object2;
        string2 = QueryResultCache.generateKeyForQueryCondition(string2, (Map)object);
        object = this.getCacheFile(string2);
        String string3 = "cache file(key=";
        if (object != null && (object2 = ((File)object).exists()) != 0) {
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                l11 = System.currentTimeMillis();
                long l13 = ((File)object).lastModified();
                long l14 = (l11 -= l13) - l10;
                Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 > 0) {
                    object = LOGGER;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    stringBuilder.append(") is expired.");
                    string2 = stringBuilder.toString();
                    ((AVLogger)object).d(string2);
                    return false;
                }
            }
            return true;
        }
        object = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(") not existed.");
        string2 = stringBuilder.toString();
        ((AVLogger)object).d(string2);
        return false;
    }
}

