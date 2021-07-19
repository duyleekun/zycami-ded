/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.RemoteMessage$Notification;
import com.huawei.hms.push.b;
import com.huawei.hms.push.s;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN;
    public static final String[] a;
    public static final int[] b;
    public static final long[] c;
    public static final HashMap d;
    public static final HashMap e;
    public static final HashMap f;
    public static final HashMap g;
    public static final HashMap h;
    public Bundle i;
    public RemoteMessage$Notification j;

    static {
        HashMap<String, Object> hashMap;
        Serializable serializable = Integer.valueOf(0);
        Object object = new String[]{};
        a = object;
        int[] nArray = new int[]{};
        b = nArray;
        Object object2 = new long[]{};
        c = object2;
        int n10 = 8;
        d = hashMap = new HashMap<String, Object>(n10);
        String string2 = "";
        hashMap.put("from", string2);
        hashMap.put("collapseKey", string2);
        hashMap.put("sendTime", string2);
        Integer n11 = 86400;
        hashMap.put("ttl", n11);
        n11 = 2;
        hashMap.put("urgency", n11);
        hashMap.put("oriUrgency", n11);
        hashMap.put("sendMode", serializable);
        hashMap.put("receiptMode", serializable);
        serializable = new HashMap(n10);
        e = serializable;
        ((HashMap)serializable).put("title_loc_key", string2);
        ((HashMap)serializable).put("body_loc_key", string2);
        ((HashMap)serializable).put("notifyIcon", string2);
        ((HashMap)serializable).put("title_loc_args", object);
        ((HashMap)serializable).put("body_loc_args", object);
        ((HashMap)serializable).put("ticker", string2);
        ((HashMap)serializable).put("notifyTitle", string2);
        ((HashMap)serializable).put("content", string2);
        serializable = new HashMap(n10);
        f = serializable;
        ((HashMap)serializable).put("icon", string2);
        ((HashMap)serializable).put("color", string2);
        ((HashMap)serializable).put("sound", string2);
        object = 1;
        ((HashMap)serializable).put("defaultLightSettings", object);
        ((HashMap)serializable).put("lightSettings", nArray);
        ((HashMap)serializable).put("defaultSound", object);
        ((HashMap)serializable).put("defaultVibrateTimings", object);
        ((HashMap)serializable).put("vibrateTimings", object2);
        object2 = new HashMap;
        object2(n10);
        g = object2;
        object2.put("tag", string2);
        object2.put("when", string2);
        object2.put("localOnly", object);
        object2.put("badgeSetNum", string2);
        object2.put("priority", string2);
        object2.put("autoCancel", object);
        object2.put("visibility", string2);
        object2.put("channelId", string2);
        h = object2 = new HashMap(3);
        object2.put("acn", string2);
        object2.put("intentUri", string2);
        object2.put("url", string2);
        object2 = new b();
        CREATOR = object2;
    }

    public RemoteMessage(Bundle bundle) {
        this.i = bundle = this.a(bundle);
    }

    public RemoteMessage(Parcel object) {
        Bundle bundle;
        this.i = bundle = object.readBundle();
        object = (RemoteMessage$Notification)object.readSerializable();
        this.j = object;
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgContent");
        }
        return null;
    }

    public static JSONObject b(Bundle object) {
        String string2 = "message_body";
        try {
            object = object.getByteArray(string2);
        }
        catch (JSONException jSONException) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
        object = v.a((byte[])object);
        string2 = new JSONObject((String)object);
        return string2;
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("notifyDetail");
        }
        return null;
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("param");
        }
        return null;
    }

    public static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("psContent");
        }
        return null;
    }

    public final Bundle a(Bundle object) {
        Bundle bundle = new Bundle();
        JSONObject jSONObject = RemoteMessage.b(object);
        JSONObject jSONObject2 = RemoteMessage.a(jSONObject);
        Object object2 = "data";
        String string2 = null;
        String string3 = JsonUtil.getString(jSONObject2, (String)object2, null);
        String string4 = "device_token";
        String string5 = object.getString(string4);
        bundle.putString(string4, string5);
        string4 = RemoteMessage.d(jSONObject2);
        string5 = RemoteMessage.b((JSONObject)string4);
        JSONObject jSONObject3 = RemoteMessage.c((JSONObject)string4);
        String string6 = "inputType";
        int n10 = object.getInt(string6);
        int n11 = 1;
        if (n10 == n11 && (n10 = (int)(s.a(jSONObject2, (JSONObject)string4, string3) ? 1 : 0)) != 0) {
            object = v.a(object.getByteArray("message_body"));
            bundle.putString((String)object2, (String)object);
            return bundle;
        }
        string6 = "to";
        String string7 = object.getString(string6);
        String string8 = "message_type";
        object = object.getString(string8);
        String string9 = "msgId";
        string2 = JsonUtil.getString(jSONObject2, string9, null);
        bundle.putString(string6, string7);
        bundle.putString((String)object2, string3);
        bundle.putString(string9, string2);
        bundle.putString(string8, (String)object);
        object = d;
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, (HashMap)object);
        object2 = this;
        string2 = string4;
        string3 = string5;
        string4 = jSONObject3;
        object = this.a(jSONObject, jSONObject2, (JSONObject)string2, (JSONObject)string5, jSONObject3);
        bundle.putBundle("notification", object);
        return bundle;
    }

    public final Bundle a(JSONObject object, JSONObject jSONObject, JSONObject object2, JSONObject jSONObject2, JSONObject jSONObject3) {
        Bundle bundle = new Bundle();
        HashMap hashMap = e;
        JsonUtil.transferJsonObjectToBundle(object2, bundle, hashMap);
        object2 = f;
        JsonUtil.transferJsonObjectToBundle(jSONObject2, bundle, (HashMap)object2);
        object2 = g;
        JsonUtil.transferJsonObjectToBundle(object, bundle, (HashMap)object2);
        object = h;
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, (HashMap)object);
        object = "notifyId";
        int n10 = JsonUtil.getInt(jSONObject, (String)object, 0);
        bundle.putInt((String)object, n10);
        return bundle;
    }

    public final int describeContents() {
        return 0;
    }

    public String getCollapseKey() {
        return this.i.getString("collapseKey");
    }

    public String getData() {
        return this.i.getString("data");
    }

    public Map getDataOfMap() {
        boolean bl2;
        HashMap hashMap = new HashMap();
        Object object = this.i;
        String string2 = "data";
        if ((object = object.getString(string2)) != null && !(bl2 = (string2 = ((String)object).trim()).isEmpty())) {
            try {
                string2 = new JSONObject((String)object);
                object = string2.keys();
            }
            catch (JSONException jSONException) {
                object = "RemoteMessage";
                string2 = "JSONException: get data from map failed";
                HMSLog.w((String)object, string2);
            }
            while (true) {
                boolean bl3 = object.hasNext();
                if (!bl3) break;
                Object object2 = object.next();
                object2 = String.valueOf(object2);
                Object object3 = string2.get(object2);
                object3 = String.valueOf(object3);
                hashMap.put(object2, object3);
                continue;
                break;
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.i.getString("from");
    }

    public String getMessageId() {
        return this.i.getString("msgId");
    }

    public String getMessageType() {
        return this.i.getString("message_type");
    }

    public RemoteMessage$Notification getNotification() {
        Object object = this.i.getBundle("notification");
        RemoteMessage$Notification remoteMessage$Notification = this.j;
        if (remoteMessage$Notification == null && object != null) {
            this.j = remoteMessage$Notification = new RemoteMessage$Notification((Bundle)object, null);
        }
        if ((object = this.j) == null) {
            remoteMessage$Notification = new Bundle();
            object = new RemoteMessage$Notification((Bundle)remoteMessage$Notification, null);
            this.j = object;
        }
        return this.j;
    }

    public int getOriginalUrgency() {
        int n10;
        Bundle bundle = this.i;
        String string2 = "oriUrgency";
        int n11 = bundle.getInt(string2);
        if (n11 != (n10 = 1) && n11 != (n10 = 2)) {
            n11 = 0;
            bundle = null;
        }
        return n11;
    }

    public int getReceiptMode() {
        return this.i.getInt("receiptMode");
    }

    public int getSendMode() {
        return this.i.getInt("sendMode");
    }

    public long getSentTime() {
        long l10;
        block5: {
            String string2;
            Object object;
            l10 = 0L;
            try {
                object = this.i;
                string2 = "sendTime";
            }
            catch (NumberFormatException numberFormatException) {
                HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
                return l10;
            }
            object = object.getString(string2);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block5;
            l10 = Long.parseLong((String)object);
        }
        return l10;
    }

    public String getTo() {
        return this.i.getString("to");
    }

    public String getToken() {
        return this.i.getString("device_token");
    }

    public int getTtl() {
        return this.i.getInt("ttl");
    }

    public int getUrgency() {
        int n10;
        Bundle bundle = this.i;
        String string2 = "urgency";
        int n11 = bundle.getInt(string2);
        if (n11 != (n10 = 1) && n11 != (n10 = 2)) {
            n11 = 0;
            bundle = null;
        }
        return n11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.i;
        parcel.writeBundle(object);
        object = this.j;
        parcel.writeSerializable((Serializable)object);
    }
}

