/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVCloudQuery;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery$1;
import cn.leancloud.AVQuery$2;
import cn.leancloud.AVQuery$3;
import cn.leancloud.AVQuery$4;
import cn.leancloud.AVQuery$CachePolicy;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.query.QueryConditions;
import cn.leancloud.query.QueryOperation;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import e.a.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class AVQuery
implements Cloneable {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVQuery.class);
    private AVQuery$CachePolicy cachePolicy;
    private String className;
    private Class clazz;
    public QueryConditions conditions;
    private Boolean isRunning;
    private long maxCacheAge;

    public AVQuery(String string2) {
        this(string2, null);
    }

    public AVQuery(String object, Class clazz) {
        AVQuery$CachePolicy aVQuery$CachePolicy;
        this.cachePolicy = aVQuery$CachePolicy = AVQuery$CachePolicy.IGNORE_CACHE;
        this.maxCacheAge = -1;
        Transformer.checkClassName((String)object);
        this.className = object;
        this.clazz = clazz;
        this.conditions = object = new QueryConditions();
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    private AVQuery addAndItems(AVQuery cloneable) {
        QueryConditions queryConditions = this.conditions;
        cloneable = cloneable.conditions;
        queryConditions.addAndItems((QueryConditions)cloneable);
        return this;
    }

    private AVQuery addOrItems(QueryOperation queryOperation) {
        this.conditions.addOrItems(queryOperation);
        return this;
    }

    public static AVQuery and(List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            int n10;
            bl2 = false;
            AVQuery aVQuery = null;
            String string2 = ((AVQuery)object.get(0)).getClassName();
            AVQuery aVQuery2 = new AVQuery(string2);
            int n11 = object.size();
            if (n11 > (n10 = 1)) {
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    aVQuery = (AVQuery)object.next();
                    String string3 = aVQuery.getClassName();
                    n11 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n11 != 0) {
                        aVQuery2.addAndItems(aVQuery);
                        continue;
                    }
                    object = new IllegalArgumentException("All queries must be for the same class");
                    throw object;
                }
            } else {
                object = ((AVQuery)object.get((int)0)).conditions.getWhere();
                aVQuery2.setWhere((Map)object);
            }
            return aVQuery2;
        }
        object = new IllegalArgumentException("queries must be non-empty.");
        throw object;
    }

    public static void clearAllCachedResults() {
        QueryResultCache.getInstance().clearAllCachedFiles();
    }

    public static z doCloudQueryInBackground(String string2) {
        return AVCloudQuery.executeInBackground(string2);
    }

    public static z doCloudQueryInBackground(String string2, Class clazz) {
        return AVCloudQuery.executeInBackground(string2, clazz);
    }

    public static z doCloudQueryInBackground(String string2, Class clazz, Object ... objectArray) {
        return AVCloudQuery.executeInBackground(string2, clazz, objectArray);
    }

    public static z doCloudQueryInBackground(String string2, Object ... objectArray) {
        return AVCloudQuery.executeInBackground(string2, objectArray);
    }

    public static AVQuery getQuery(Class clazz) {
        String string2 = Transformer.getSubClassName(clazz);
        AVQuery aVQuery = new AVQuery(string2, clazz);
        return aVQuery;
    }

    public static AVQuery getQuery(String string2) {
        AVQuery aVQuery = new AVQuery(string2);
        return aVQuery;
    }

    public static AVQuery or(List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            int n10;
            bl2 = false;
            Object object2 = null;
            String string2 = ((AVQuery)object.get(0)).getClassName();
            AVQuery aVQuery = new AVQuery(string2);
            int n11 = object.size();
            if (n11 > (n10 = 1)) {
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    object2 = (AVQuery)object.next();
                    Object object3 = ((AVQuery)object2).getClassName();
                    n11 = (int)(string2.equals(object3) ? 1 : 0);
                    if (n11 != 0) {
                        object2 = ((AVQuery)object2).conditions.compileWhereOperationMap();
                        String string3 = "$or";
                        object3 = new QueryOperation(string3, string3, object2);
                        aVQuery.addOrItems((QueryOperation)object3);
                        continue;
                    }
                    object = new IllegalArgumentException("All queries must be for the same class");
                    throw object;
                }
            } else {
                object = ((AVQuery)object.get((int)0)).conditions.getWhere();
                aVQuery.setWhere((Map)object);
            }
            return aVQuery;
        }
        object = new IllegalArgumentException("queries must be non-empty.");
        throw object;
    }

    public AVQuery addAscendingOrder(String string2) {
        this.conditions.addAscendingOrder(string2);
        return this;
    }

    public AVQuery addDescendingOrder(String string2) {
        this.conditions.addDescendingOrder(string2);
        return this;
    }

    public AVQuery addWhereItem(String string2, String string3, Object object) {
        this.conditions.addWhereItem(string2, string3, object);
        return this;
    }

    public Map assembleJsonParam() {
        Map map = this.conditions.assembleJsonParam();
        String string2 = this.getClassName();
        map.put("className", string2);
        return map;
    }

    public Map assembleParameters() {
        this.conditions.assembleParameters();
        return this.conditions.getParameters();
    }

    public void clearCachedResult() {
        Object object = this.assembleParameters();
        String string2 = QueryResultCache.generateKeyForQueryCondition(this.getClassName(), (Map)object);
        QueryResultCache.getInstance().clearCachedFile(string2);
        object.put("limit", "1");
        object = QueryResultCache.generateKeyForQueryCondition(this.getClassName(), (Map)object);
        QueryResultCache.getInstance().clearCachedFile((String)object);
    }

    public AVQuery clone() {
        long l10;
        AVQuery aVQuery = (AVQuery)super.clone();
        Object object = Boolean.FALSE;
        aVQuery.isRunning = object;
        object = this.cachePolicy;
        aVQuery.cachePolicy = object;
        aVQuery.maxCacheAge = l10 = this.maxCacheAge;
        object = this.conditions;
        object = object != null ? ((QueryConditions)object).clone() : null;
        aVQuery.conditions = object;
        return aVQuery;
    }

    public int count() {
        return this.count(null);
    }

    public int count(AVUser aVUser) {
        return (Integer)this.countInBackground(aVUser).r();
    }

    public z countInBackground() {
        return this.countInBackground(null);
    }

    public z countInBackground(AVUser aVUser) {
        Map map = this.assembleParameters();
        map.put("count", "1");
        map.put("limit", "0");
        StorageClient storageClient = PaasClient.getStorageClient();
        String string2 = this.getClassName();
        return storageClient.queryCount(aVUser, string2, map);
    }

    public void deleteAll() {
        this.deleteAll(null);
    }

    public void deleteAll(AVUser aVUser) {
        this.deleteAllInBackground(aVUser).D();
    }

    public z deleteAllInBackground() {
        return this.deleteAllInBackground(null);
    }

    public z deleteAllInBackground(AVUser object) {
        object = this.findInBackground((AVUser)object);
        AVQuery$4 aVQuery$4 = new AVQuery$4(this);
        return ((z)object).s2(aVQuery$4);
    }

    public List find() {
        return (List)this.findInBackground().w();
    }

    public z findInBackground() {
        return this.findInBackground(null);
    }

    public z findInBackground(AVUser aVUser) {
        return this.findInBackground(aVUser, 0);
    }

    public z findInBackground(AVUser object, int n10) {
        Object object2;
        Object object3;
        Map map = this.assembleParameters();
        if (n10 > 0) {
            object3 = Integer.toString(n10);
            object2 = "limit";
            map.put(object2, object3);
        }
        object3 = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Query: ");
        ((StringBuilder)object2).append(map);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object3).d((String)object2);
        object2 = PaasClient.getStorageClient();
        String string2 = this.getClassName();
        AVQuery$CachePolicy aVQuery$CachePolicy = this.cachePolicy;
        long l10 = this.maxCacheAge;
        object = ((StorageClient)object2).queryObjects((AVUser)object, string2, map, aVQuery$CachePolicy, l10);
        object3 = new AVQuery$1(this);
        return ((z)object).H3((o)object3);
    }

    public AVObject get(String string2) {
        return (AVObject)this.getInBackground(string2).r();
    }

    public AVQuery$CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    public String getClassName() {
        return this.className;
    }

    public Class getClazz() {
        return this.clazz;
    }

    public AVObject getFirst() {
        return this.getFirst(null);
    }

    public AVObject getFirst(AVUser object) {
        try {
            object = this.getFirstInBackground((AVUser)object);
        }
        catch (NoSuchElementException noSuchElementException) {
            return null;
        }
        object = ((z)object).r();
        return (AVObject)object;
    }

    public z getFirstInBackground() {
        return this.getFirstInBackground(null);
    }

    public z getFirstInBackground(AVUser object) {
        object = this.findInBackground((AVUser)object, 1);
        AVQuery$3 aVQuery$3 = new AVQuery$3(this);
        return ((z)object).s2(aVQuery$3);
    }

    public z getInBackground(AVUser object, String object2) {
        Object object3;
        int n10;
        Object object4 = this.getInclude();
        if (object4 != null && (n10 = object4.size()) > 0) {
            object3 = ",";
            object4 = StringUtil.join((CharSequence)object3, (Iterable)object4);
        } else {
            object4 = null;
        }
        object3 = PaasClient.getStorageClient();
        String string2 = this.getClassName();
        object = ((StorageClient)object3).fetchObject((AVUser)object, string2, (String)object2, (String)object4);
        object2 = new AVQuery$2(this);
        return ((z)object).H3((o)object2);
    }

    public z getInBackground(String string2) {
        return this.getInBackground(null, string2);
    }

    public List getInclude() {
        return this.conditions.getInclude();
    }

    public int getLimit() {
        return this.conditions.getLimit();
    }

    public long getMaxCacheAge() {
        return this.maxCacheAge;
    }

    public String getOrder() {
        return this.conditions.getOrder();
    }

    public Map getParameters() {
        return this.conditions.getParameters();
    }

    public AVQuery$CachePolicy getPolicy() {
        return this.cachePolicy;
    }

    public Set getSelectedKeys() {
        return this.conditions.getSelectedKeys();
    }

    public int getSkip() {
        return this.conditions.getSkip();
    }

    public Map getWhere() {
        return this.conditions.getWhere();
    }

    public boolean hasCachedResult() {
        Map map = this.assembleParameters();
        StorageClient storageClient = PaasClient.getStorageClient();
        String string2 = this.getClassName();
        long l10 = this.getMaxCacheAge();
        return storageClient.hasCachedResult(string2, map, l10);
    }

    public AVQuery include(String string2) {
        this.conditions.include(string2);
        return this;
    }

    public AVQuery includeACL(boolean bl2) {
        this.conditions.includeACL(bl2);
        return this;
    }

    public boolean isIncludeACL() {
        return this.conditions.isIncludeACL();
    }

    public AVQuery limit(int n10) {
        this.setLimit(n10);
        return this;
    }

    public AVQuery order(String string2) {
        this.setOrder(string2);
        return this;
    }

    public AVQuery orderByAscending(String string2) {
        this.conditions.orderByAscending(string2);
        return this;
    }

    public AVQuery orderByDescending(String string2) {
        this.conditions.orderByDescending(string2);
        return this;
    }

    public AVQuery selectKeys(Collection collection) {
        this.conditions.selectKeys(collection);
        return this;
    }

    public AVQuery setCachePolicy(AVQuery$CachePolicy aVQuery$CachePolicy) {
        this.cachePolicy = aVQuery$CachePolicy;
        return this;
    }

    public AVQuery setClassName(String string2) {
        this.className = string2;
        return this;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setInclude(List list) {
        this.conditions.setInclude(list);
    }

    public AVQuery setLimit(int n10) {
        this.conditions.setLimit(n10);
        return this;
    }

    public AVQuery setMaxCacheAge(long l10) {
        this.maxCacheAge = l10;
        return this;
    }

    public AVQuery setOrder(String string2) {
        this.conditions.setOrder(string2);
        return this;
    }

    public void setParameters(Map map) {
        this.conditions.setParameters(map);
    }

    public AVQuery setPolicy(AVQuery$CachePolicy aVQuery$CachePolicy) {
        this.cachePolicy = aVQuery$CachePolicy;
        return this;
    }

    public void setSelectedKeys(Set set) {
        this.conditions.setSelectedKeys(set);
    }

    public AVQuery setSkip(int n10) {
        this.conditions.setSkip(n10);
        return this;
    }

    public AVQuery setWhere(Map map) {
        this.conditions.setWhere(map);
        return this;
    }

    public AVQuery skip(int n10) {
        this.setSkip(n10);
        return this;
    }

    public AVQuery whereContainedIn(String string2, Collection collection) {
        this.conditions.whereContainedIn(string2, collection);
        return this;
    }

    public AVQuery whereContains(String string2, String string3) {
        this.conditions.whereContains(string2, string3);
        return this;
    }

    public AVQuery whereContainsAll(String string2, Collection collection) {
        this.conditions.whereContainsAll(string2, collection);
        return this;
    }

    public AVQuery whereDoesNotExist(String string2) {
        this.conditions.whereDoesNotExist(string2);
        return this;
    }

    public AVQuery whereDoesNotMatchKeyInQuery(String string2, String string3, AVQuery object) {
        Object object2 = ((AVQuery)object).className;
        object2 = AVUtils.createMap("className", object2);
        object = ((AVQuery)object).conditions.compileWhereOperationMap();
        object2.put("where", object);
        object = AVUtils.createMap("query", object2);
        object.put("key", string3);
        this.addWhereItem(string2, "$dontSelect", object);
        return this;
    }

    public AVQuery whereDoesNotMatchQuery(String string2, AVQuery object) {
        Object object2 = ((AVQuery)object).className;
        object2 = AVUtils.createMap("className", object2);
        object = ((AVQuery)object).conditions.compileWhereOperationMap();
        object2.put("where", object);
        this.addWhereItem(string2, "$notInQuery", object2);
        return this;
    }

    public AVQuery whereEndsWith(String string2, String string3) {
        this.conditions.whereEndsWith(string2, string3);
        return this;
    }

    public AVQuery whereEqualTo(String string2, Object object) {
        this.conditions.whereEqualTo(string2, object);
        return this;
    }

    public AVQuery whereExists(String string2) {
        this.conditions.whereExists(string2);
        return this;
    }

    public AVQuery whereGreaterThan(String string2, Object object) {
        this.conditions.whereGreaterThan(string2, object);
        return this;
    }

    public AVQuery whereGreaterThanOrEqualTo(String string2, Object object) {
        this.conditions.whereGreaterThanOrEqualTo(string2, object);
        return this;
    }

    public AVQuery whereLessThan(String string2, Object object) {
        this.conditions.whereLessThan(string2, object);
        return this;
    }

    public AVQuery whereLessThanOrEqualTo(String string2, Object object) {
        this.conditions.whereLessThanOrEqualTo(string2, object);
        return this;
    }

    public AVQuery whereMatches(String string2, String string3) {
        this.conditions.whereMatches(string2, string3);
        return this;
    }

    public AVQuery whereMatches(String string2, String string3, String string4) {
        this.conditions.whereMatches(string2, string3, string4);
        return this;
    }

    public AVQuery whereMatchesKeyInQuery(String string2, String string3, AVQuery hashMap) {
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        Object object = ((AVQuery)((Object)hashMap)).getClassName();
        hashMap2.put("className", object);
        object = ((AVQuery)hashMap).conditions.compileWhereOperationMap();
        String string4 = "where";
        hashMap2.put(string4, object);
        object = ((AVQuery)hashMap).conditions;
        int n10 = ((QueryConditions)object).getSkip();
        if (n10 > 0) {
            n10 = ((AVQuery)hashMap).conditions.getSkip();
            object = n10;
            string4 = "skip";
            hashMap2.put(string4, object);
        }
        if ((n10 = ((QueryConditions)(object = ((AVQuery)hashMap).conditions)).getLimit()) > 0) {
            n10 = ((AVQuery)hashMap).conditions.getLimit();
            object = n10;
            string4 = "limit";
            hashMap2.put(string4, object);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object = ((AVQuery)((Object)hashMap)).getOrder())) ? 1 : 0)) == 0) {
            hashMap = ((AVQuery)((Object)hashMap)).getOrder();
            object = "order";
            hashMap2.put(object, hashMap);
        }
        hashMap = new HashMap<String, HashMap<String, String>>();
        hashMap.put("query", hashMap2);
        hashMap.put("key", (HashMap<String, String>)((Object)string3));
        return this.addWhereItem(string2, "$select", hashMap);
    }

    public AVQuery whereMatchesQuery(String string2, AVQuery object) {
        Map map = ((AVQuery)object).conditions.compileWhereOperationMap();
        map = AVUtils.createMap("where", map);
        Object object2 = ((AVQuery)object).className;
        String string3 = "className";
        map.put(string3, object2);
        object2 = ((AVQuery)object).conditions;
        int n10 = ((QueryConditions)object2).getSkip();
        if (n10 > 0) {
            n10 = ((AVQuery)object).conditions.getSkip();
            object2 = n10;
            string3 = "skip";
            map.put(string3, object2);
        }
        if ((n10 = ((QueryConditions)(object2 = ((AVQuery)object).conditions)).getLimit()) > 0) {
            n10 = ((AVQuery)object).conditions.getLimit();
            object2 = n10;
            string3 = "limit";
            map.put(string3, object2);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object2 = ((AVQuery)object).getOrder())) ? 1 : 0)) == 0) {
            object = ((AVQuery)object).getOrder();
            object2 = "order";
            map.put(object2, object);
        }
        this.addWhereItem(string2, "$inQuery", map);
        return this;
    }

    public AVQuery whereNear(String string2, AVGeoPoint aVGeoPoint) {
        this.conditions.whereNear(string2, aVGeoPoint);
        return this;
    }

    public AVQuery whereNotContainedIn(String string2, Collection collection) {
        this.conditions.whereNotContainedIn(string2, collection);
        return this;
    }

    public AVQuery whereNotEqualTo(String string2, Object object) {
        this.conditions.whereNotEqualTo(string2, object);
        return this;
    }

    public AVQuery whereSizeEqual(String string2, int n10) {
        this.conditions.whereSizeEqual(string2, n10);
        return this;
    }

    public AVQuery whereStartsWith(String string2, String string3) {
        this.conditions.whereStartsWith(string2, string3);
        return this;
    }

    public AVQuery whereWithinGeoBox(String string2, AVGeoPoint aVGeoPoint, AVGeoPoint aVGeoPoint2) {
        this.conditions.whereWithinGeoBox(string2, aVGeoPoint, aVGeoPoint2);
        return this;
    }

    public AVQuery whereWithinKilometers(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinKilometers(string2, aVGeoPoint, d10);
        return this;
    }

    public AVQuery whereWithinKilometers(String string2, AVGeoPoint aVGeoPoint, double d10, double d11) {
        this.conditions.whereWithinKilometers(string2, aVGeoPoint, d10, d11);
        return this;
    }

    public AVQuery whereWithinMiles(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinMiles(string2, aVGeoPoint, d10);
        return this;
    }

    public AVQuery whereWithinMiles(String string2, AVGeoPoint aVGeoPoint, double d10, double d11) {
        this.conditions.whereWithinMiles(string2, aVGeoPoint, d10, d11);
        return this;
    }

    public AVQuery whereWithinRadians(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinRadians(string2, aVGeoPoint, d10);
        return this;
    }

    public AVQuery whereWithinRadians(String string2, AVGeoPoint aVGeoPoint, double d10, double d11) {
        this.conditions.whereWithinRadians(string2, aVGeoPoint, d10, d11);
        return this;
    }
}

