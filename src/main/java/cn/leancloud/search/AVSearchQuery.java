/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.search;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import cn.leancloud.core.PaasClient;
import cn.leancloud.search.AVSearchQuery$1;
import cn.leancloud.search.AVSearchResponse;
import cn.leancloud.search.AVSearchSortBuilder;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import e.a.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AVSearchQuery {
    public static final String AVSEARCH_APP_URL = "app_url_avoscloud_";
    public static final String AVSEARCH_DEEP_LINK = "deep_link_avoscloud_";
    public static final String AVSEARCH_HIGHTLIGHT = "highlight_avoscloud_";
    public static final String DATA_EXTRA_SEARCH_KEY = "com.avos.avoscloud.search.key";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVSearchQuery.class);
    private static final String URL = "search/select";
    private String className;
    public Class clazz;
    private List fields;
    private String hightlights;
    private int hits;
    private List include;
    private int limit = 100;
    private String order;
    private String queryString;
    private String sid;
    private int skip = 0;
    private AVSearchSortBuilder sortBuilder;
    private String titleAttribute;

    public AVSearchQuery() {
        this(null);
    }

    public AVSearchQuery(String string2) {
        this(string2, null);
    }

    public AVSearchQuery(String object, Class clazz) {
        this.queryString = object;
        this.clazz = clazz;
        object = new LinkedList();
        this.include = object;
        this.className = clazz == null ? (object = Transformer.getSubClassName(AVObject.class)) : (object = Transformer.getSubClassName(clazz));
    }

    public static /* synthetic */ List access$000(AVSearchQuery aVSearchQuery, AVSearchResponse aVSearchResponse) {
        return aVSearchQuery.processContent(aVSearchResponse);
    }

    private Map getParameters(String object) {
        String string2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = "q";
        hashMap.put(string3, object);
        object = this.sid;
        int n10 = StringUtil.isEmpty((String)object);
        if (n10 == 0) {
            object = this.sid;
            string3 = "sid";
            hashMap.put(string3, object);
        }
        object = this.hightlights;
        n10 = StringUtil.isEmpty((String)object);
        string3 = "highlights";
        if (n10 == 0) {
            object = this.hightlights;
            hashMap.put(string3, object);
        } else {
            object = "*";
            hashMap.put(string3, object);
        }
        object = this.fields;
        string3 = ",";
        if (object != null && (n10 = object.size()) > 0) {
            object = this.fields;
            object = StringUtil.join(string3, (Iterable)object);
            string2 = "fields";
            hashMap.put(string2, object);
        }
        if ((n10 = this.limit) > 0) {
            object = String.valueOf(n10);
            string2 = "limit";
            hashMap.put(string2, object);
        }
        if ((n10 = this.skip) > 0) {
            object = String.valueOf(n10);
            string2 = "skip";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object = this.order)) ? 1 : 0)) == 0) {
            object = this.order;
            string2 = "order";
            hashMap.put(string2, object);
        }
        if ((object = this.sortBuilder) != null) {
            object = AVUtils.jsonStringFromObjectWithNull(((AVSearchSortBuilder)object).getSortFields());
            string2 = "sort";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)((object = this.include).isEmpty() ? 1 : 0)) == 0) {
            object = this.include;
            object = StringUtil.join(string3, (Iterable)object);
            string3 = "include";
            hashMap.put(string3, object);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object = this.className)) ? 1 : 0)) == 0) {
            object = this.className;
            string3 = "clazz";
            hashMap.put(string3, object);
        }
        return hashMap;
    }

    private List processContent(AVSearchResponse mapArray) {
        int n10;
        if (mapArray == null) {
            return Collections.emptyList();
        }
        LinkedList<Object> linkedList = mapArray.sid;
        this.sid = linkedList;
        this.hits = n10 = mapArray.hits;
        linkedList = new LinkedList<Object>();
        for (Map map : mapArray.results) {
            String string2;
            Object v10;
            String string3;
            boolean bl2;
            if (map == null || (bl2 = map.isEmpty())) continue;
            Object object = this.clazz;
            if (object == null) {
                string3 = this.className;
                boolean bl3 = StringUtil.isEmpty(string3);
                string3 = bl3 ? (String)map.get("className") : this.className;
                object = new AVObject(string3);
            } else {
                object = (AVObject)((Class)object).newInstance();
            }
            string3 = "_highlight";
            boolean bl4 = map.containsKey(string3);
            if (bl4) {
                v10 = map.get(string3);
                string2 = AVSEARCH_HIGHTLIGHT;
                map.put(string2, v10);
                map.remove(string3);
            }
            if (bl4 = map.containsKey(string3 = "_app_url")) {
                v10 = map.get(string3);
                string2 = AVSEARCH_APP_URL;
                map.put(string2, v10);
                map.remove(string3);
            }
            if (bl4 = map.containsKey(string3 = "_deeplink")) {
                v10 = map.get(string3);
                string2 = AVSEARCH_DEEP_LINK;
                map.put(string2, v10);
                map.remove(string3);
            }
            ((AVObject)object).resetServerData(map);
            linkedList.add(object);
        }
        return linkedList;
    }

    public AVSearchQuery addAscendingOrder(String string2) {
        Object[] objectArray = this.order;
        boolean bl2 = StringUtil.isEmpty((String)objectArray);
        if (bl2) {
            return this.orderByAscending(string2);
        }
        objectArray = new Object[2];
        String string3 = this.order;
        objectArray[0] = string3;
        objectArray[1] = string2;
        this.order = string2 = String.format("%s,%s", objectArray);
        return this;
    }

    public AVSearchQuery addDescendingOrder(String string2) {
        Object[] objectArray = this.order;
        boolean bl2 = StringUtil.isEmpty((String)objectArray);
        if (bl2) {
            return this.orderByDescending(string2);
        }
        objectArray = new Object[2];
        String string3 = this.order;
        objectArray[0] = string3;
        objectArray[1] = string2;
        this.order = string2 = String.format("%s,-%s", objectArray);
        return this;
    }

    public z findInBackground() {
        return this.findInBackground(null);
    }

    public z findInBackground(AVUser aVUser) {
        Object object = this.queryString;
        object = this.getParameters((String)object);
        return this.getSearchResult(aVUser, (Map)object);
    }

    public String getClassName() {
        return this.className;
    }

    public List getFields() {
        return this.fields;
    }

    public String getHightLights() {
        return this.hightlights;
    }

    public int getHits() {
        return this.hits;
    }

    public String getLastId() {
        return this.sid;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public z getSearchResult(AVUser object, Map object2) {
        object = PaasClient.getStorageClient().search((AVUser)object, (Map)object2);
        object2 = new AVSearchQuery$1(this);
        return ((z)object).H3((o)object2);
    }

    public String getSid() {
        return this.sid;
    }

    public int getSkip() {
        return this.skip;
    }

    public AVSearchSortBuilder getSortBuilder() {
        return this.sortBuilder;
    }

    public String getTitleAttribute() {
        return this.titleAttribute;
    }

    public void include(String string2) {
        this.include.add(string2);
    }

    public AVSearchQuery order(String string2) {
        this.order = string2;
        return this;
    }

    public AVSearchQuery orderByAscending(String string2) {
        Object[] objectArray = this.order;
        int n10 = StringUtil.isEmpty((String)objectArray);
        int n11 = 1;
        if (n10 != 0) {
            objectArray = new Object[n11];
            objectArray[0] = string2;
            this.order = string2 = String.format("%s", objectArray);
        } else {
            n10 = 2;
            objectArray = new Object[n10];
            String string3 = this.order;
            objectArray[0] = string3;
            objectArray[n11] = string2;
            this.order = string2 = String.format("%s,%s", objectArray);
        }
        return this;
    }

    public AVSearchQuery orderByDescending(String string2) {
        Object[] objectArray = this.order;
        int n10 = StringUtil.isEmpty((String)objectArray);
        int n11 = 1;
        if (n10 != 0) {
            objectArray = new Object[n11];
            objectArray[0] = string2;
            this.order = string2 = String.format("-%s", objectArray);
        } else {
            n10 = 2;
            objectArray = new Object[n10];
            String string3 = this.order;
            objectArray[0] = string3;
            objectArray[n11] = string2;
            this.order = string2 = String.format("%s,-%s", objectArray);
        }
        return this;
    }

    public void setClassName(String string2) {
        this.className = string2;
    }

    public void setFields(List list) {
        this.fields = list;
    }

    public void setHightLights(String string2) {
        this.hightlights = string2;
    }

    public void setLastId(String string2) {
        this.sid = string2;
    }

    public void setLimit(int n10) {
        this.limit = n10;
    }

    public void setQueryString(String string2) {
        boolean bl2;
        String string3 = this.queryString;
        if (!(string3 == null && string2 == null || string3 != null && (bl2 = string3.equals(string2)))) {
            bl2 = false;
            string3 = null;
            this.sid = null;
        }
        this.queryString = string2;
    }

    public void setSid(String string2) {
        this.sid = string2;
    }

    public void setSkip(int n10) {
        this.skip = n10;
    }

    public void setSortBuilder(AVSearchSortBuilder aVSearchSortBuilder) {
        this.sortBuilder = aVSearchSortBuilder;
    }

    public void setTitleAttribute(String string2) {
        this.titleAttribute = string2;
    }
}

