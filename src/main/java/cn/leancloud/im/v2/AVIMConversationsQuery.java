/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.AVQuery$CachePolicy;
import cn.leancloud.cache.QueryResultCache;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationQueryConditions;
import cn.leancloud.im.v2.AVIMConversationsQuery$1;
import cn.leancloud.im.v2.AVIMConversationsQuery$2;
import cn.leancloud.im.v2.AVIMConversationsQuery$3;
import cn.leancloud.im.v2.AVIMConversationsQuery$4;
import cn.leancloud.im.v2.AVIMConversationsQuery$5;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import cn.leancloud.json.JSON;
import cn.leancloud.query.QueryConditions;
import cn.leancloud.query.QueryOperation;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.v0.o;
import e.a.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AVIMConversationsQuery {
    private static final String CONVERSATION_CLASS_NAME = "_conversation";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVIMConversationsQuery.class);
    private static final long MAX_CONVERSATION_CACHE_TIME = 3600000L;
    private AVIMClient client;
    public AVIMConversationQueryConditions conditions;
    private long maxAge;
    public AVQuery$CachePolicy policy;

    public AVIMConversationsQuery(AVIMClient object) {
        AVQuery$CachePolicy aVQuery$CachePolicy;
        this.policy = aVQuery$CachePolicy = AVQuery$CachePolicy.CACHE_ELSE_NETWORK;
        this.maxAge = 3600000L;
        this.client = object;
        this.conditions = object = new AVIMConversationQueryConditions();
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ void access$100(AVIMConversationsQuery aVIMConversationsQuery, AVIMConversationQueryCallback aVIMConversationQueryCallback, Map map) {
        aVIMConversationsQuery.queryFromNetwork(aVIMConversationQueryCallback, map);
    }

    public static /* synthetic */ AVIMClient access$200(AVIMConversationsQuery aVIMConversationsQuery) {
        return aVIMConversationsQuery.client;
    }

    public static /* synthetic */ List access$300(AVIMConversationsQuery aVIMConversationsQuery, List list) {
        return aVIMConversationsQuery.parseQueryResult(list);
    }

    public static /* synthetic */ void access$400(AVIMConversationsQuery aVIMConversationsQuery, Map map, List list) {
        aVIMConversationsQuery.cacheQueryResult(map, list);
    }

    private void cacheQueryResult(Map object, List object2) {
        boolean bl2;
        Object object3 = new LinkedList();
        Object object4 = object2.iterator();
        Object object5 = null;
        while (bl2 = object4.hasNext()) {
            object5 = (AVIMConversation)object4.next();
            String string2 = ((AVIMConversation)object5).getConversationId();
            object3.add(string2);
            object5 = ((AVIMConversation)object5).storage;
        }
        if (object5 != null) {
            ((AVIMMessageStorage)object5).insertConversations((List)object2);
        } else {
            object2 = LOGGER;
            object4 = "Message Storage is null, skip save queryResult.";
            ((AVLogger)object2).d((String)object4);
        }
        object = QueryResultCache.generateKeyForQueryCondition(CONVERSATION_CLASS_NAME, (Map)object);
        object2 = QueryResultCache.getInstance();
        object3 = JSON.toJSONString(object3);
        ((QueryResultCache)object2).cacheResult((String)object, (String)object3);
    }

    private void findWithCondition(Map map, AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        Object object = AVIMConversationsQuery$5.$SwitchMap$cn$leancloud$AVQuery$CachePolicy;
        AVQuery$CachePolicy aVQuery$CachePolicy = this.policy;
        int n10 = aVQuery$CachePolicy.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                break;
            }
            case 5: 
            case 6: {
                this.queryFromNetwork(aVIMConversationQueryCallback, map);
                break;
            }
            case 4: {
                this.queryFromCache(aVIMConversationQueryCallback, map);
                break;
            }
            case 3: {
                object = AppConfiguration.getGlobalNetworkingDetector();
                n11 = (int)(object.isConnected() ? 1 : 0);
                if (n11 != 0) {
                    this.queryFromNetwork(aVIMConversationQueryCallback, map);
                    break;
                }
                this.queryFromCache(aVIMConversationQueryCallback, map);
                break;
            }
            case 1: 
            case 2: {
                object = new AVIMConversationsQuery$1;
                ((AVIMConversationsQuery$1)object)(this, aVIMConversationQueryCallback, map);
                this.queryFromCache((AVIMConversationQueryCallback)object, map);
            }
        }
    }

    public static AVIMConversationsQuery or(List object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            boolean bl2;
            n10 = 0;
            AVIMClient aVIMClient = ((AVIMConversationsQuery)object.get((int)0)).client;
            AVIMConversationsQuery aVIMConversationsQuery = new AVIMConversationsQuery(aVIMClient);
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object2;
                Object object3 = (AVIMConversationsQuery)object.next();
                Object object4 = aVIMClient.getClientId();
                boolean bl3 = ((String)object4).equals(object2 = ((AVIMConversationsQuery)object3).client.getClientId());
                if (bl3) {
                    object4 = aVIMConversationsQuery.conditions;
                    object3 = ((AVIMConversationsQuery)object3).conditions.compileWhereOperationMap();
                    String string2 = "$or";
                    object2 = new QueryOperation(string2, string2, object3);
                    ((QueryConditions)object4).addOrItems((QueryOperation)object2);
                    continue;
                }
                object = new IllegalArgumentException("All queries must be for the same client");
                throw object;
            }
            return aVIMConversationsQuery;
        }
        object = new IllegalArgumentException("Queries cannot be empty");
        throw object;
    }

    private List parseQueryResult(List list) {
        int n10;
        LinkedList<Object> linkedList = new LinkedList<Object>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            AVIMClient aVIMClient;
            Object object = (Map)list.get(i10);
            AVIMConversation aVIMConversation = AVIMConversation.parseFromJson(this.client, (Map)object);
            if (aVIMConversation == null || (object = (aVIMClient = this.client).mergeConversationCache(aVIMConversation, false, (Map)object)) == null) continue;
            linkedList.add(object);
        }
        return linkedList;
    }

    private void queryFromCache(AVIMConversationQueryCallback aVIMConversationQueryCallback, Map object) {
        Object object2 = QueryResultCache.getInstance();
        long l10 = this.maxAge;
        object = ((QueryResultCache)object2).getCacheRawResult(CONVERSATION_CLASS_NAME, (Map)object, l10, true);
        object2 = new AVIMConversationsQuery$3(this);
        object = ((z)object).H3((o)object2);
        object2 = new AVIMConversationsQuery$2(this, aVIMConversationQueryCallback);
        ((z)object).subscribe((g0)object2);
    }

    private void queryFromNetwork(AVIMConversationQueryCallback object, Map object2) {
        Object object3 = AppConfiguration.getGlobalNetworkingDetector();
        boolean bl2 = object3.isConnected();
        if (!bl2) {
            if (object != null) {
                object2 = null;
                int n10 = 100;
                String string2 = "Connection lost";
                object3 = new AVException(n10, string2);
                ((AVCallback)object).internalDone(null, (AVException)object3);
            }
            return;
        }
        object3 = JSON.toJSONString(object2);
        AVIMConversationsQuery$4 aVIMConversationsQuery$4 = new AVIMConversationsQuery$4(this, (Map)object2, (AVIMConversationQueryCallback)object);
        object = InternalConfiguration.getOperationTube();
        object2 = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        object.queryConversations((AVConnectionManager)object2, string3, (String)object3, aVIMConversationsQuery$4);
    }

    public AVIMConversationsQuery addAscendingOrder(String string2) {
        this.conditions.addAscendingOrder(string2);
        return this;
    }

    public AVIMConversationsQuery addDescendingOrder(String string2) {
        this.conditions.addDescendingOrder(string2);
        return this;
    }

    public AVIMConversationsQuery containsMembers(List list) {
        this.conditions.addWhereItem("m", "$all", list);
        return this;
    }

    public void directFindInBackground(String object, String object2, int n10, int n11, int n12, AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = "where";
        hashMap.put(string2, object);
        boolean bl2 = StringUtil.isEmpty(object2);
        if (!bl2) {
            object = "order";
            hashMap.put((String)object, object2);
        }
        if (n10 > 0) {
            object = Integer.toString(n10);
            object2 = "skip";
            hashMap.put((String)object2, object);
        }
        if (n11 > 0) {
            object = Integer.toString(n11);
            object2 = "limit";
            hashMap.put((String)object2, object);
        }
        object = AVIMConversationQueryConditions.assembleParameters(hashMap, n12);
        boolean bl3 = AVIMConversationQueryConditions.isWithLastMessagesRefreshed(n12);
        if (bl3) {
            object2 = AVQuery$CachePolicy.NETWORK_ELSE_CACHE;
            this.policy = object2;
        }
        this.findWithCondition((Map)object, aVIMConversationQueryCallback);
    }

    public void findInBackground(AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        AVQuery$CachePolicy aVQuery$CachePolicy;
        Map map = this.conditions.assembleParameters();
        Object object = this.conditions;
        boolean bl2 = object.isWithLastMessagesRefreshed();
        if (bl2 && ((object = AVQuery$CachePolicy.CACHE_ELSE_NETWORK) == (aVQuery$CachePolicy = this.policy) || (object = AVQuery$CachePolicy.CACHE_THEN_NETWORK) == aVQuery$CachePolicy)) {
            object = AVQuery$CachePolicy.NETWORK_ELSE_CACHE;
            this.policy = object;
        }
        this.findWithCondition(map, aVIMConversationQueryCallback);
    }

    public void findTempConversationsInBackground(List list, AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        this.conditions.setTempConversationIds(list);
        this.findInBackground(aVIMConversationQueryCallback);
    }

    public long getCacheMaxAge() {
        return this.maxAge / 1000L;
    }

    public boolean isWithLastMessagesRefreshed() {
        return this.conditions.isWithLastMessagesRefreshed();
    }

    public AVIMConversationsQuery limit(int n10) {
        return this.setLimit(n10);
    }

    public AVIMConversationsQuery orderByAscending(String string2) {
        this.conditions.orderByAscending(string2);
        return this;
    }

    public AVIMConversationsQuery orderByDescending(String string2) {
        this.conditions.orderByDescending(string2);
        return this;
    }

    public void setCacheMaxAge(long l10) {
        this.maxAge = l10 *= 1000L;
    }

    public AVIMConversationsQuery setCompact(boolean bl2) {
        this.conditions.setCompact(bl2);
        return this;
    }

    public AVIMConversationsQuery setLimit(int n10) {
        this.conditions.setLimit(n10);
        return this;
    }

    public void setQueryPolicy(AVQuery$CachePolicy aVQuery$CachePolicy) {
        this.policy = aVQuery$CachePolicy;
    }

    public AVIMConversationsQuery setSkip(int n10) {
        this.conditions.setSkip(n10);
        return this;
    }

    public AVIMConversationsQuery setWithLastMessagesRefreshed(boolean bl2) {
        this.conditions.setWithLastMessagesRefreshed(bl2);
        return this;
    }

    public AVIMConversationsQuery skip(int n10) {
        return this.setSkip(n10);
    }

    public AVIMConversationsQuery whereContains(String string2, String string3) {
        this.conditions.whereContains(string2, string3);
        return this;
    }

    public AVIMConversationsQuery whereContainsAll(String string2, Collection collection) {
        this.conditions.whereContainsAll(string2, collection);
        return this;
    }

    public AVIMConversationsQuery whereContainsIn(String string2, Collection collection) {
        this.conditions.whereContainedIn(string2, collection);
        return this;
    }

    public AVIMConversationsQuery whereDoesNotExist(String string2) {
        this.conditions.whereDoesNotExist(string2);
        return this;
    }

    public AVIMConversationsQuery whereEndsWith(String string2, String string3) {
        this.conditions.whereEndsWith(string2, string3);
        return this;
    }

    public AVIMConversationsQuery whereEqualTo(String string2, Object object) {
        this.conditions.whereEqualTo(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereExists(String string2) {
        this.conditions.whereExists(string2);
        return this;
    }

    public AVIMConversationsQuery whereGreaterThan(String string2, Object object) {
        this.conditions.whereGreaterThan(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereGreaterThanOrEqualsTo(String string2, Object object) {
        this.conditions.whereGreaterThanOrEqualTo(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereLessThan(String string2, Object object) {
        this.conditions.whereLessThan(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereLessThanOrEqualsTo(String string2, Object object) {
        this.conditions.whereLessThanOrEqualTo(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereMatches(String string2, String string3) {
        this.conditions.whereMatches(string2, string3);
        return this;
    }

    public AVIMConversationsQuery whereMatches(String string2, String string3, String string4) {
        this.conditions.whereMatches(string2, string3, string4);
        return this;
    }

    public AVIMConversationsQuery whereNear(String string2, AVGeoPoint aVGeoPoint) {
        this.conditions.whereNear(string2, aVGeoPoint);
        return this;
    }

    public AVIMConversationsQuery whereNotContainsIn(String string2, Collection collection) {
        this.conditions.whereNotContainedIn(string2, collection);
        return this;
    }

    public AVIMConversationsQuery whereNotEqualsTo(String string2, Object object) {
        this.conditions.whereNotEqualTo(string2, object);
        return this;
    }

    public AVIMConversationsQuery whereSizeEqual(String string2, int n10) {
        this.conditions.whereSizeEqual(string2, n10);
        return this;
    }

    public AVIMConversationsQuery whereStartsWith(String string2, String string3) {
        this.conditions.whereStartsWith(string2, string3);
        return this;
    }

    public AVIMConversationsQuery whereWithinGeoBox(String string2, AVGeoPoint aVGeoPoint, AVGeoPoint aVGeoPoint2) {
        this.conditions.whereWithinGeoBox(string2, aVGeoPoint, aVGeoPoint2);
        return this;
    }

    public AVIMConversationsQuery whereWithinKilometers(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinKilometers(string2, aVGeoPoint, d10);
        return this;
    }

    public AVIMConversationsQuery whereWithinMiles(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinMiles(string2, aVGeoPoint, d10);
        return this;
    }

    public AVIMConversationsQuery whereWithinRadians(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.conditions.whereWithinRadians(string2, aVGeoPoint, d10);
        return this;
    }

    public AVIMConversationsQuery withMembers(List list) {
        return this.withMembers(list, false);
    }

    public AVIMConversationsQuery withMembers(List object, boolean bl2) {
        HashSet<Object> hashSet = new HashSet<Object>((Collection<Object>)object);
        if (bl2) {
            object = this.client.getClientId();
            hashSet.add(object);
        }
        object = new LinkedList(hashSet);
        this.containsMembers((List)object);
        int n10 = hashSet.size();
        this.whereSizeEqual("m", n10);
        return this;
    }
}

