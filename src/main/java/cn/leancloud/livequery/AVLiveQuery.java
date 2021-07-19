/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.livequery.AVLiveQuery$1;
import cn.leancloud.livequery.AVLiveQuery$2;
import cn.leancloud.livequery.AVLiveQuery$3;
import cn.leancloud.livequery.AVLiveQuery$EventType;
import cn.leancloud.livequery.AVLiveQueryConnectionHandler;
import cn.leancloud.livequery.AVLiveQueryEventHandler;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import cn.leancloud.livequery.LiveQueryConnectionListener;
import cn.leancloud.ops.Utils;
import cn.leancloud.service.RealtimeClient;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class AVLiveQuery {
    public static final String ACTION_LIVE_QUERY_LOGIN = "action_live_query_login";
    public static final String LIVEQUERY_PRIFIX = "live_query_";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVLiveQuery.class);
    private static final String OBJECT = "object";
    private static final String OP = "op";
    private static final String QUERY = "query";
    private static final String QUERY_ID = "query_id";
    private static final String SESSION_TOKEN = "sessionToken";
    private static final String SP_LIVEQUERY_KEY = "livequery_keyzone";
    private static final String SP_SUBSCRIBE_ID = "subscribeId";
    public static final String SUBSCRIBE_ID = "id";
    private static final String UPDATE_KEYS = "updatedKeys";
    private static final LiveQueryConnectionListener liveQueryConnectionListener;
    private static Set liveQuerySet;
    private static String subscribeId;
    private AVLiveQueryEventHandler eventHandler;
    private AVQuery query;
    private String queryId;

    static {
        HashSet hashSet = new HashSet();
        liveQueryConnectionListener = hashSet;
        AVConnectionManager.getInstance().subscribeDefaultConnectionListener("leancloud_livequery_default_id", (AVConnectionListener)((Object)hashSet));
        hashSet = new HashSet();
        liveQuerySet = Collections.synchronizedSet(hashSet);
    }

    private AVLiveQuery(AVQuery aVQuery) {
        this.query = aVQuery;
    }

    public static /* synthetic */ void access$000(AVLiveQuery aVLiveQuery, Map map, AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        aVLiveQuery.subscribeThroughRESTAPI(map, aVLiveQuerySubscribeCallback);
    }

    public static /* synthetic */ String access$102(AVLiveQuery aVLiveQuery, String string2) {
        aVLiveQuery.queryId = string2;
        return string2;
    }

    public static /* synthetic */ Set access$200() {
        return liveQuerySet;
    }

    private String getSessionToken() {
        AVUser aVUser = AVUser.getCurrentUser();
        if (aVUser != null) {
            return aVUser.getSessionToken();
        }
        return "";
    }

    private static String getSubscribeId() {
        Object object = subscribeId;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            object = AppConfiguration.getDefaultSetting();
            String string2 = SP_LIVEQUERY_KEY;
            String string3 = SP_SUBSCRIBE_ID;
            String string4 = "";
            subscribeId = object = object.getString(string2, string3, string4);
            bl2 = StringUtil.isEmpty((String)object);
            if (bl2) {
                object = AppConfiguration.getApplicationPackageName();
                string4 = UUID.randomUUID().toString();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                stringBuilder.append(string4);
                subscribeId = MDFive.computeMD5(stringBuilder.toString());
                object = AppConfiguration.getDefaultSetting();
                string4 = subscribeId;
                object.saveString(string2, string3, string4);
            }
        }
        return subscribeId;
    }

    public static AVLiveQuery initWithQuery(AVQuery object) {
        if (object != null) {
            AVLiveQuery aVLiveQuery = new AVLiveQuery((AVQuery)object);
            return aVLiveQuery;
        }
        object = new IllegalArgumentException("query cannot be null");
        throw object;
    }

    private void loginLiveQuery(AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        String string2;
        AVConnectionManager aVConnectionManager;
        Object object = InternalConfiguration.getOperationTube();
        boolean bl2 = object.loginLiveQuery(aVConnectionManager = AVConnectionManager.getInstance(), string2 = AVLiveQuery.getSubscribeId(), aVLiveQuerySubscribeCallback);
        if (!bl2 && aVLiveQuerySubscribeCallback != null) {
            int n10 = 119;
            string2 = "can't invoke operation in background.";
            object = new AVException(n10, string2);
            aVLiveQuerySubscribeCallback.internalDone((AVException)object);
        }
    }

    public static void processData(ArrayList object) {
        boolean bl2;
        String string2 = UPDATE_KEYS;
        object = ((ArrayList)object).iterator();
        block26: while (bl2 = object.hasNext()) {
            Object object2;
            int n10;
            Object object3;
            int n11;
            ArrayList<Object> arrayList;
            Object object4;
            String string3;
            Object object5;
            Object[] objectArray;
            block29: {
                objectArray = (String)object.next();
                objectArray = JSON.parseObject((String)objectArray);
                object5 = OP;
                object5 = objectArray.getString((String)object5);
                string3 = QUERY_ID;
                string3 = objectArray.getString(string3);
                object4 = OBJECT;
                object4 = objectArray.getJSONObject((String)object4);
                boolean bl3 = StringUtil.isEmpty(string3);
                if (bl3) continue;
                arrayList = new ArrayList<Object>();
                n11 = objectArray.containsKey(string2);
                if (n11 == 0) break block29;
                objectArray = objectArray.getJSONArray(string2);
                objectArray = objectArray.toArray();
                n11 = objectArray.length;
                object3 = null;
                for (n10 = 0; n10 < n11; ++n10) {
                    object2 = objectArray[n10];
                    object2 = (String)object2;
                    arrayList.add(object2);
                    continue;
                }
            }
            objectArray = liveQuerySet;
            try {
                objectArray = objectArray.iterator();
            }
            catch (Exception exception) {
                object5 = LOGGER;
                string3 = "Parsing json data error, ";
                ((AVLogger)object5).e(string3, exception);
                continue;
            }
            while (true) {
                n11 = objectArray.hasNext();
                if (n11 == 0) continue block26;
                break;
            }
            {
                Object object6 = objectArray.next();
                object6 = (AVLiveQuery)object6;
                object3 = ((AVLiveQuery)object6).queryId;
                n10 = (int)(string3.equals(object3) ? 1 : 0);
                if (n10 == 0) continue;
                object6 = ((AVLiveQuery)object6).eventHandler;
                if (object6 == null) continue;
                object3 = AVLiveQuery$EventType.getType((String)object5);
                object2 = Utils.parseObjectFromMap((Map)object4);
                ((AVLiveQueryEventHandler)object6).done((AVLiveQuery$EventType)((Object)object3), (AVObject)object2, arrayList);
                continue;
            }
        }
    }

    public static void resumeSubscribeers() {
        boolean bl2;
        Iterator iterator2 = liveQuerySet.iterator();
        while (bl2 = iterator2.hasNext()) {
            AVLiveQuery aVLiveQuery = (AVLiveQuery)iterator2.next();
            aVLiveQuery.subscribeInBackground(null);
        }
    }

    public static void setConnectionHandler(AVLiveQueryConnectionHandler aVLiveQueryConnectionHandler) {
        liveQueryConnectionListener.setConnectionHandler(aVLiveQueryConnectionHandler);
    }

    private void subscribeThroughRESTAPI(Map object, AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        object = RealtimeClient.getInstance().subscribeLiveQuery((Map)object);
        AVLiveQuery$2 aVLiveQuery$2 = new AVLiveQuery$2(this, aVLiveQuerySubscribeCallback);
        ((z)object).subscribe(aVLiveQuery$2);
    }

    public void setEventHandler(AVLiveQueryEventHandler object) {
        if (object != null) {
            this.eventHandler = object;
            return;
        }
        object = new IllegalArgumentException("eventHandler can not be null.");
        throw object;
    }

    public void subscribeInBackground(AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        Object object = this.query.assembleParameters();
        HashMap<String, Map> hashMap = this.query.getClassName();
        object.put("className", hashMap);
        hashMap = new HashMap<String, Map>();
        String string2 = QUERY;
        hashMap.put(string2, (Map)object);
        object = this.getSessionToken();
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            string2 = SESSION_TOKEN;
            hashMap.put(string2, (Map)object);
        }
        object = AVLiveQuery.getSubscribeId();
        string2 = SUBSCRIBE_ID;
        hashMap.put(string2, (Map)object);
        object = liveQueryConnectionListener;
        boolean bl3 = ((LiveQueryConnectionListener)object).connectionIsOpen();
        if (bl3) {
            this.subscribeThroughRESTAPI(hashMap, aVLiveQuerySubscribeCallback);
        } else {
            object = new AVLiveQuery$1(this, aVLiveQuerySubscribeCallback, hashMap);
            this.loginLiveQuery((AVLiveQuerySubscribeCallback)object);
        }
    }

    public void unsubscribeInBackground(AVLiveQuerySubscribeCallback aVLiveQuerySubscribeCallback) {
        Object object = new HashMap();
        Object object2 = AVLiveQuery.getSubscribeId();
        object.put(SUBSCRIBE_ID, object2);
        object2 = this.queryId;
        object.put(QUERY_ID, object2);
        object = RealtimeClient.getInstance().unsubscribeLiveQuery((Map)object);
        object2 = new AVLiveQuery$3(this, aVLiveQuerySubscribeCallback);
        ((z)object).subscribe((g0)object2);
    }
}

