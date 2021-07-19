/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.push.s;
import com.huawei.hms.push.u;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.support.api.push.PushReceiver$a;
import com.huawei.hms.support.api.push.PushReceiver$b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver
extends BroadcastReceiver {
    public static /* synthetic */ JSONObject a(Intent intent) {
        return PushReceiver.b(intent);
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgContent");
        }
        return null;
    }

    public static JSONObject a(byte[] object) {
        try {
            object = v.a(object);
        }
        catch (JSONException jSONException) {
            HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
        JSONObject jSONObject = new JSONObject((String)object);
        return jSONObject;
    }

    public static JSONObject b(Intent intent) {
        intent = PushReceiver.a(intent.getByteArrayExtra("msg_data"));
        JSONObject jSONObject = PushReceiver.a((JSONObject)intent);
        String string2 = JsonUtil.getString(jSONObject, "data", null);
        JSONObject jSONObject2 = PushReceiver.b(jSONObject);
        boolean bl2 = s.a(jSONObject, jSONObject2, string2);
        if (bl2) {
            return intent;
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            return null;
        }
        try {
            intent = new JSONObject(string2);
            return intent;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("psContent");
        }
        return null;
    }

    public final void a(Context object, Intent intent) {
        String string2;
        block8: {
            string2 = "PushReceiver";
            Object object2 = "msg_data";
            boolean bl2 = intent.hasExtra((String)object2);
            if (!bl2) break block8;
            object2 = u.a();
            PushReceiver$a pushReceiver$a = new PushReceiver$a((Context)object, intent, null);
            ((ThreadPoolExecutor)object2).execute(pushReceiver$a);
        }
        object = "This push message dose not sent by hwpush.";
        try {
            HMSLog.i(string2, (String)object);
        }
        catch (Exception exception) {
            object = "handlePushMessageEvent execute task error";
            HMSLog.e(string2, (String)object);
        }
        catch (RuntimeException runtimeException) {
            object = "handlePushMessageEvent execute task runtime exception.";
            HMSLog.e(string2, (String)object);
        }
    }

    public final void b(Context object, Intent intent) {
        String string2;
        block8: {
            string2 = "PushReceiver";
            Object object2 = "device_token";
            boolean bl2 = intent.hasExtra((String)object2);
            if (!bl2) break block8;
            object2 = u.a();
            PushReceiver$b pushReceiver$b = new PushReceiver$b((Context)object, intent, null);
            ((ThreadPoolExecutor)object2).execute(pushReceiver$b);
        }
        object = "This message dose not sent by hwpush.";
        try {
            HMSLog.i(string2, (String)object);
        }
        catch (Exception exception) {
            object = "handlePushTokenEvent execute task error";
            HMSLog.e(string2, (String)object);
        }
        catch (RuntimeException runtimeException) {
            object = "handlePushMessageEvent execute task runtime exception.";
            HMSLog.e(string2, (String)object);
        }
    }

    public void onReceive(Context object, Intent object2) {
        if (object2 != null && object != null) {
            boolean bl2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("push receive broadcast message, Intent:");
            String string2 = object2.getAction();
            charSequence.append(string2);
            charSequence.append(" pkgName:");
            string2 = object.getPackageName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = "PushReceiver";
            HMSLog.i(string2, (String)charSequence);
            charSequence = "TestIntent";
            try {
                object2.getStringExtra((String)charSequence);
            }
            catch (Exception exception) {
                object = "intent has some error";
                HMSLog.e(string2, (String)object);
            }
            charSequence = object2.getAction();
            Object object3 = ResourceLoaderUtil.getmContext();
            if (object3 == null) {
                object3 = object.getApplicationContext();
                ResourceLoaderUtil.setmContext((Context)object3);
            }
            if (bl2 = ((String)(object3 = "com.huawei.android.push.intent.REGISTRATION")).equals(charSequence)) {
                this.b((Context)object, (Intent)object2);
            } else {
                object3 = "com.huawei.android.push.intent.RECEIVE";
                boolean bl3 = ((String)object3).equals(charSequence);
                if (bl3) {
                    this.a((Context)object, (Intent)object2);
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("message can't be recognised:");
                    bl3 = false;
                    charSequence = null;
                    object2 = object2.toUri(0);
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    HMSLog.i(string2, (String)object);
                }
            }
            return;
        }
    }
}

