/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.w;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage$Builder {
    public final Bundle a;
    public final Map b;

    public RemoteMessage$Builder(String string2) {
        HashMap hashMap;
        Bundle bundle;
        this.a = bundle = new Bundle();
        this.b = hashMap = new HashMap();
        bundle.putString("to", string2);
    }

    public RemoteMessage$Builder addData(String object, String string2) {
        if (object != null) {
            this.b.put(object, string2);
            return this;
        }
        object = new IllegalArgumentException("add data failed, key is null.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RemoteMessage build() {
        Object object;
        Object object2 = "msgId";
        Object object3 = "receiptMode";
        String string2 = "sendMode";
        String string3 = "ttl";
        String string4 = "collapseKey";
        String string5 = "send message failed";
        String string6 = "RemoteMessage";
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        try {
            boolean bl2;
            object = this.b;
            object = object.entrySet();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object e10 = object.next();
                Map.Entry entry = (Map.Entry)e10;
                Object k10 = entry.getKey();
                String string7 = (String)k10;
                Object v10 = entry.getValue();
                jSONObject.put(string7, v10);
            }
        }
        catch (JSONException jSONException) {
            HMSLog.w(string6, "JSONException: parse data to json failed.");
            object2 = new PushException(string5);
            throw object2;
        }
        try {
            object = jSONObject.toString();
            JSONObject jSONObject2 = new JSONObject();
            Bundle bundle2 = this.a;
            String string8 = bundle2.getString(string4);
            jSONObject2.put(string4, (Object)string8);
            string4 = this.a;
            int n10 = string4.getInt(string3);
            jSONObject2.put(string3, n10);
            string3 = this.a;
            int n11 = string3.getInt(string2);
            jSONObject2.put(string2, n11);
            string2 = this.a;
            int n12 = string2.getInt((String)object3);
            jSONObject2.put((String)object3, n12);
            object3 = new JSONObject();
            n12 = jSONObject.length();
            if (n12 != 0) {
                string2 = "data";
                object3.put(string2, object);
            }
            string2 = this.a;
            string2 = string2.getString((String)object2);
            object3.put((String)object2, (Object)string2);
            object2 = "msgContent";
            jSONObject2.put((String)object2, object3);
            object2 = jSONObject2.toString();
            object3 = w.a;
            object2 = ((String)object2).getBytes((Charset)object3);
            object3 = "message_body";
            bundle.putByteArray((String)object3, (byte[])object2);
            object2 = this.a;
            object3 = "to";
        }
        catch (JSONException jSONException) {
            HMSLog.w(string6, "JSONException: parse message body failed.");
            object2 = new PushException(string5);
            throw object2;
        }
        object2 = object2.getString((String)object3);
        bundle.putString((String)object3, (String)object2);
        object2 = this.a;
        object3 = "message_type";
        object2 = object2.getString((String)object3);
        bundle.putString((String)object3, (String)object2);
        return new RemoteMessage(bundle);
    }

    public RemoteMessage$Builder clearData() {
        this.b.clear();
        return this;
    }

    public RemoteMessage$Builder setCollapseKey(String string2) {
        this.a.putString("collapseKey", string2);
        return this;
    }

    public RemoteMessage$Builder setData(Map object) {
        boolean bl2;
        Object object2 = this.b;
        object2.clear();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            Map map = this.b;
            Object k10 = object2.getKey();
            object2 = object2.getValue();
            map.put(k10, object2);
        }
        return this;
    }

    public RemoteMessage$Builder setMessageId(String string2) {
        this.a.putString("msgId", string2);
        return this;
    }

    public RemoteMessage$Builder setMessageType(String string2) {
        this.a.putString("message_type", string2);
        return this;
    }

    public RemoteMessage$Builder setReceiptMode(int n10) {
        int n11 = 1;
        if (n10 != n11 && n10 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("receipt mode can only be 0 or 1.");
            throw illegalArgumentException;
        }
        this.a.putInt("receiptMode", n10);
        return this;
    }

    public RemoteMessage$Builder setSendMode(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("send mode can only be 0 or 1.");
            throw illegalArgumentException;
        }
        this.a.putInt("sendMode", n10);
        return this;
    }

    public RemoteMessage$Builder setTtl(int n10) {
        int n11 = 1;
        if (n10 >= n11 && n10 <= (n11 = 1296000)) {
            this.a.putInt("ttl", n10);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        throw illegalArgumentException;
    }
}

