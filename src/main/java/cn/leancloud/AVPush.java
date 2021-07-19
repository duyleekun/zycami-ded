/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVPush$1;
import cn.leancloud.AVQuery;
import cn.leancloud.callback.SendCallback;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.PushClient;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.z;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AVPush {
    private static final String APNsTeamIdTag = "apns_team_id";
    private static final String APNsTopicTag = "topic";
    private static final Set DEVICE_TYPES;
    private static final int FlowControlMinValue = 1000;
    private static final String FlowControlTag = "flow_control";
    private static final AVLogger LOGGER;
    private static final String NotificationIdTag = "notification_id";
    private static final String RequestIdTag = "req_id";
    private static final String deviceTypeTag = "deviceType";
    public static final String iOSEnvironmentDev = "dev";
    public static final String iOSEnvironmentProd = "prod";
    private static final String iOSEnvironmentTag = "prod";
    private String APNsTeamId = null;
    private String APNsTopic = null;
    private final Set channelSet;
    private String cql;
    private long expirationTime;
    private long expirationTimeInterval;
    private int flowControl = 0;
    private String iOSEnvironment = null;
    private volatile AVObject notification;
    private String notificationId = null;
    private final Map pushData;
    private Date pushDate = null;
    private AVQuery pushQuery;
    private final Set pushTarget;
    private String requestId = null;

    static {
        HashSet<String> hashSet;
        LOGGER = LogUtil.getLogger(AVPush.class);
        DEVICE_TYPES = hashSet = new HashSet<String>();
        hashSet.add("android");
        hashSet.add("ios");
    }

    public AVPush() {
        Cloneable cloneable = new Cloneable();
        this.channelSet = cloneable;
        this.pushData = cloneable;
        Set set = DEVICE_TYPES;
        this.pushTarget = cloneable = new Cloneable(set);
        cloneable = AVInstallation.getQuery();
        this.pushQuery = cloneable;
    }

    public static /* synthetic */ AVObject access$000(AVPush aVPush) {
        return aVPush.notification;
    }

    public static /* synthetic */ AVObject access$002(AVPush aVPush, AVObject aVObject) {
        aVPush.notification = aVObject;
        return aVObject;
    }

    private Date expirationDateTime() {
        long l10 = this.expirationTime;
        Date date = new Date(l10);
        return date;
    }

    private Map postDataMap() {
        long l10;
        long l11;
        long l12;
        Object object;
        Object object2;
        int n10;
        Serializable serializable = new HashMap();
        Object object3 = this.pushQuery;
        if (object3 != null) {
            object3 = this.pushTarget;
            n10 = object3.size();
            object2 = deviceTypeTag;
            if (n10 == 0) {
                object3 = this.pushQuery;
                object = DEVICE_TYPES;
                ((AVQuery)object3).whereNotContainedIn((String)object2, (Collection)object);
            } else {
                int n11;
                object3 = this.pushTarget;
                n10 = object3.size();
                if (n10 == (n11 = 1)) {
                    object3 = this.pushQuery;
                    object = this.pushTarget.toArray()[0];
                    ((AVQuery)object3).whereEqualTo((String)object2, object);
                }
            }
            object3 = this.pushQuery.assembleParameters();
            object2 = object3.keySet();
            int n12 = object2.size();
            if (n12 > 0 && (n12 = (int)(StringUtil.isEmpty((String)(object2 = this.cql)) ? 1 : 0)) == 0) {
                serializable = new IllegalStateException("You can't use AVQuery and Cloud query at the same time.");
                throw serializable;
            }
            object3 = object3.entrySet().iterator();
            while ((n12 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                object2 = (Map.Entry)object3.next();
                object = object2.getKey();
                object2 = JSON.parse((String)object2.getValue());
                serializable.put(object, object2);
            }
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object3 = this.cql)) ? 1 : 0)) == 0) {
            object3 = this.cql;
            object2 = "cql";
            serializable.put(object2, object3);
        }
        if ((n10 = (object3 = this.channelSet).size()) > 0) {
            object3 = this.pushChannelsData();
            serializable.putAll(object3);
        }
        if ((n10 = (int)((l12 = (l11 = this.expirationTime) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
            object3 = this.expirationDateTime();
            object2 = "expiration_time";
            serializable.put(object2, object3);
        }
        l11 = this.expirationTimeInterval;
        n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        object2 = "push_time";
        if (n10 > 0) {
            object3 = new Date();
            object3 = StringUtil.stringFromDate((Date)object3);
            serializable.put(object2, object3);
            l10 = this.expirationTimeInterval;
            object3 = l10;
            object = "expiration_interval";
            serializable.put(object, object3);
        }
        if ((object3 = this.pushDate) != null) {
            object3 = StringUtil.stringFromDate((Date)object3);
            serializable.put(object2, object3);
        }
        if ((n10 = this.flowControl) > 0) {
            object3 = n10;
            object2 = FlowControlTag;
            serializable.put(object2, object3);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object3 = this.iOSEnvironment)) ? 1 : 0)) == 0) {
            object3 = this.iOSEnvironment;
            object2 = "prod";
            serializable.put(object2, object3);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object3 = this.APNsTopic)) ? 1 : 0)) == 0) {
            object3 = this.APNsTopic;
            object2 = APNsTopicTag;
            serializable.put(object2, object3);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object3 = this.APNsTeamId)) ? 1 : 0)) == 0) {
            object3 = this.APNsTeamId;
            object2 = APNsTeamIdTag;
            serializable.put(object2, object3);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)(object3 = this.notificationId)) ? 1 : 0)) == 0) {
            object3 = this.notificationId;
            object2 = NotificationIdTag;
            serializable.put(object2, object3);
        }
        object3 = this.pushData;
        serializable.putAll(object3);
        return serializable;
    }

    private Map pushChannelsData() {
        Set set = this.channelSet;
        return AVUtils.createStringObjectMap("channels", set);
    }

    public static z sendDataInBackground(JSONObject jSONObject, AVQuery aVQuery) {
        AVPush aVPush = new AVPush();
        aVPush.setData(jSONObject);
        aVPush.setQuery(aVQuery);
        return aVPush.sendInBackground();
    }

    public static void sendDataInBackground(JSONObject jSONObject, AVQuery aVQuery, SendCallback sendCallback) {
        AVPush aVPush = new AVPush();
        aVPush.setData(jSONObject);
        aVPush.setQuery(aVQuery);
        aVPush.sendInBackground(sendCallback);
    }

    public static z sendMessageInBackground(String string2, AVQuery aVQuery) {
        AVPush aVPush = new AVPush();
        aVPush.setMessage(string2);
        aVPush.setQuery(aVQuery);
        return aVPush.sendInBackground();
    }

    public static void sendMessageInBackground(String string2, AVQuery aVQuery, SendCallback sendCallback) {
        AVPush aVPush = new AVPush();
        aVPush.setMessage(string2);
        aVPush.setQuery(aVQuery);
        aVPush.sendInBackground(sendCallback);
    }

    public void clearExpiration() {
        long l10;
        this.expirationTime = l10 = 0L;
        this.expirationTimeInterval = l10;
    }

    public Set getChannelSet() {
        return this.channelSet;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public long getExpirationTimeInterval() {
        return this.expirationTimeInterval;
    }

    public int getFlowControl() {
        return this.flowControl;
    }

    public AVObject getNotification() {
        return this.notification;
    }

    public Map getPushData() {
        return this.pushData;
    }

    public Date getPushDate() {
        return this.pushDate;
    }

    public AVQuery getPushQuery() {
        return this.pushQuery;
    }

    public Set getPushTarget() {
        return this.pushTarget;
    }

    public void send() {
        this.sendInBackground().r();
    }

    public z sendInBackground() {
        Map map;
        try {
            map = this.postDataMap();
        }
        catch (Exception exception) {
            return z.m2(exception);
        }
        PushClient pushClient = PaasClient.getPushClient();
        return pushClient.sendPushRequest(map);
    }

    public void sendInBackground(SendCallback sendCallback) {
        z z10 = this.sendInBackground();
        AVPush$1 aVPush$1 = new AVPush$1(this, sendCallback);
        z10.subscribe(aVPush$1);
    }

    public void setAPNsTeamId(String string2) {
        this.APNsTeamId = string2;
    }

    public void setAPNsTopic(String string2) {
        this.APNsTopic = string2;
    }

    public void setChannel(String string2) {
        this.channelSet.clear();
        this.channelSet.add(string2);
    }

    public void setChannels(Collection collection) {
        this.channelSet.clear();
        this.channelSet.addAll(collection);
    }

    public void setCloudQuery(String string2) {
        this.cql = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setData(JSONObject object) {
        try {
            HashMap hashMap = new HashMap();
            object = object.entrySet();
            object = object.iterator();
            while (true) {
                Object object2;
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.pushData;
                    object2 = "data";
                    object.put(object2, hashMap);
                    return;
                }
                object2 = object.next();
                object2 = (Map.Entry)object2;
                Object k10 = object2.getKey();
                object2 = object2.getValue();
                hashMap.put(k10, object2);
            }
        }
        catch (Exception exception) {
            AVLogger aVLogger = LOGGER;
            aVLogger.w(exception);
        }
    }

    public void setData(Map map) {
        this.pushData.put("data", map);
    }

    public void setExpirationTime(long l10) {
        this.expirationTime = l10;
    }

    public void setExpirationTimeInterval(long l10) {
        this.expirationTimeInterval = l10;
    }

    public void setFlowControl(int n10) {
        int n11 = 1000;
        if (n10 < n11) {
            n10 = n11;
        }
        this.flowControl = n10;
    }

    public void setMessage(String object) {
        this.pushData.clear();
        object = AVUtils.createStringObjectMap("alert", object);
        this.pushData.put("data", object);
    }

    public void setNotificationId(String string2) {
        this.notificationId = string2;
    }

    public void setPushDate(Date date) {
        this.pushDate = date;
    }

    public void setPushToAndroid(boolean bl2) {
        String string2 = "android";
        if (bl2) {
            Set set = this.pushTarget;
            set.add(string2);
        } else {
            Set set = this.pushTarget;
            set.remove(string2);
        }
    }

    public void setPushToIOS(boolean bl2) {
        String string2 = "ios";
        if (bl2) {
            Set set = this.pushTarget;
            set.add(string2);
        } else {
            Set set = this.pushTarget;
            set.remove(string2);
        }
    }

    public void setPushToWindowsPhone(boolean bl2) {
        String string2 = "wp";
        if (bl2) {
            Set set = this.pushTarget;
            set.add(string2);
        } else {
            Set set = this.pushTarget;
            set.remove(string2);
        }
    }

    public void setQuery(AVQuery aVQuery) {
        this.pushQuery = aVQuery;
    }

    public void setRequestId(String string2) {
        this.requestId = string2;
    }

    public void setiOSEnvironment(String string2) {
        this.iOSEnvironment = string2;
    }
}

