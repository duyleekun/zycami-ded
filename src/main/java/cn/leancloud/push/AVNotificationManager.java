/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.push;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AVNotificationManager {
    private static final String AV_PUSH_SERVICE_APP_DATA = "AV_PUSH_SERVICE_APP_DATA";
    private static final String ICON_KEY = "_notification_icon";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVNotificationManager.class);
    private static final String PUSH_MESSAGE_DEPOT = "com.avos.push.message";
    private final ConcurrentMap defaultPushCallback;
    private int notificationIcon;
    public final Map processedMessages;

    public AVNotificationManager() {
        ConcurrentHashMap concurrentHashMap;
        this.defaultPushCallback = concurrentHashMap = new ConcurrentHashMap();
        this.processedMessages = concurrentHashMap = new ConcurrentHashMap();
        this.notificationIcon = 0;
        this.readDataFromCache();
    }

    public static String getAction(String string2) {
        return AVNotificationManager.getJSONValue(string2, "action");
    }

    public static String getChannel(String string2) {
        return AVNotificationManager.getJSONValue(string2, "_channel");
    }

    public static Date getExpiration(String object) {
        object = JSON.parseObject((String)object);
        String string2 = "_expiration_time";
        try {
            object = ((JSONObject)object).getString(string2);
        }
        catch (Exception exception) {
            object = "";
        }
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            return null;
        }
        return StringUtil.dateFromString((String)object);
    }

    public static String getJSONValue(String object, String string2) {
        boolean bl2;
        object = (Map)JSON.parseObject((String)object, HashMap.class);
        String string3 = null;
        if (object != null && !(bl2 = object.isEmpty()) && (object = object.get(string2)) != null) {
            string3 = object.toString();
        }
        return string3;
    }

    public static boolean getSilent(String object) {
        Object object2 = "silent";
        boolean bl2 = StringUtil.isEmpty((String)object);
        boolean bl3 = false;
        if (!bl2) {
            block5: {
                object = JSON.parseObject((String)object);
                bl2 = object.containsKey(object2);
                if (!bl2) break block5;
                try {
                    bl3 = ((JSONObject)object).getBooleanValue((String)object2);
                }
                catch (Exception exception) {
                    object2 = LOGGER;
                    String string2 = "failed to parse JSON.";
                    ((AVLogger)object2).e(string2, exception);
                }
            }
            return bl3;
        }
        return false;
    }

    public static String getText(String object) {
        String string2;
        int n10;
        String string3 = AVNotificationManager.getJSONValue((String)object, "alert");
        if (string3 != null && (n10 = (string2 = string3.trim()).length()) > 0) {
            return string3;
        }
        object = (Map)JSON.parseObject((String)object, HashMap.class);
        string3 = null;
        if (object != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0 && (object = (Map)object.get(string2 = "data")) != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0 && (object = object.get(string2 = "message")) != null) {
            return object.toString();
        }
        return null;
    }

    private String getValue(String object, String string2) {
        boolean bl2;
        Object object2 = AVNotificationManager.getJSONValue((String)object, string2);
        boolean bl3 = StringUtil.isEmpty((String)object2);
        if (!bl3) {
            return object2;
        }
        object2 = HashMap.class;
        if ((object = (Map)JSON.parseObject((String)object, (Class)object2)) != null && !(bl2 = object.isEmpty())) {
            object2 = "data";
            if ((object = (Map)object.get(object2)) != null && !(bl2 = object.isEmpty())) {
                if ((object = object.get(string2)) != null) {
                    return object.toString();
                }
                return this.getApplicationName();
            }
            return this.getApplicationName();
        }
        return this.getApplicationName();
    }

    private void readDataFromCache() {
        int n10;
        Object object = AppConfiguration.getDefaultSetting();
        Object object2 = AV_PUSH_SERVICE_APP_DATA;
        object = object.getAll((String)object2).entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object3;
            object2 = (Map.Entry)object.next();
            Object object4 = (String)object2.getKey();
            boolean bl2 = ((String)object4).equals(object3 = ICON_KEY);
            if (bl2) {
                object2 = object2.getValue();
                object2 = (String)object2;
                n10 = Integer.parseInt((String)object2);
                try {
                    this.notificationIcon = n10;
                }
                catch (Exception exception) {
                    object4 = LOGGER;
                    ((AVLogger)object4).w(exception);
                }
                continue;
            }
            object2 = String.valueOf(object2.getValue());
            object3 = this.defaultPushCallback;
            object3.put(object4, object2);
        }
    }

    public void addDefaultPushCallback(String string2, String string3) {
        this.defaultPushCallback.put(string2, string3);
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        string3 = String.valueOf(string3);
        systemSetting.saveString(AV_PUSH_SERVICE_APP_DATA, string2, string3);
    }

    public boolean containsDefaultPushCallback(String string2) {
        return this.defaultPushCallback.containsKey(string2);
    }

    public abstract String getApplicationName();

    public String getDefaultPushCallback(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = null;
        } else {
            ConcurrentMap concurrentMap = this.defaultPushCallback;
            string2 = (String)concurrentMap.get(string2);
        }
        return string2;
    }

    public int getNotificationIcon() {
        return this.notificationIcon;
    }

    public String getSound(String string2) {
        return this.getValue(string2, "sound");
    }

    public String getTitle(String string2) {
        return this.getValue(string2, "title");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void processPushMessage(String string2, String object) {
        Object object2 = this.processedMessages;
        boolean bl2 = object2.containsKey(object);
        if (bl2) {
            object = LOGGER;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("duplicated push message, ignore it. data=");
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).w(string2);
            return;
        }
        object2 = this.processedMessages;
        Object object3 = "";
        object2.put(object, object3);
        try {
            object = AVNotificationManager.getChannel(string2);
            if (object == null || !(bl2 = this.containsDefaultPushCallback((String)object))) {
                object = AVOSCloud.getApplicationId();
            }
            if ((object2 = AVNotificationManager.getExpiration(string2)) != null && (bl2 = ((Date)object2).before((Date)(object3 = new Date())))) {
                object = LOGGER;
                object2 = new StringBuilder();
                object3 = "message expired:";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                ((AVLogger)object).d(string2);
                return;
            }
            object2 = AVNotificationManager.getAction(string2);
            if (object2 != null) {
                this.sendBroadcast((String)object, string2, (String)object2);
                return;
            }
            this.sendNotification((String)object, string2);
            return;
        }
        catch (Exception exception) {
            object = LOGGER;
            object2 = "Process notification failed.";
            ((AVLogger)object).e((String)object2, exception);
        }
    }

    public void removeDefaultPushCallback(String string2) {
        this.defaultPushCallback.remove(string2);
        AppConfiguration.getDefaultSetting().removeKey("AV_PUSH_SERVICE_APP_DATA", string2);
    }

    public abstract void sendBroadcast(String var1, String var2, String var3);

    public abstract void sendNotification(String var1, String var2);

    public void setNotificationIcon(int n10) {
        this.notificationIcon = n10;
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        String string2 = String.valueOf(n10);
        systemSetting.saveString("AV_PUSH_SERVICE_APP_DATA", "_notification_icon", string2);
    }

    public int size() {
        return this.defaultPushCallback.size();
    }
}

