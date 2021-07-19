/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  org.json.JSONObject
 */
package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.f;
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.support.api.push.PushReceiver;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONObject;

public class PushReceiver$a
implements Runnable {
    public Context a;
    public Intent b;

    public PushReceiver$a(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public /* synthetic */ PushReceiver$a(Context context, Intent intent, f f10) {
        this(context, intent);
    }

    public void run() {
        Object object = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        Object object2 = this.b.getPackage();
        object.setPackage((String)object2);
        object2 = PushReceiver.a(this.b);
        String string2 = "";
        String string3 = JsonUtil.getString((JSONObject)object2, "moduleName", string2);
        String string4 = "msgType";
        ErrorEnum errorEnum = null;
        int n10 = JsonUtil.getInt((JSONObject)object2, string4, 0);
        int n11 = JsonUtil.getInt((JSONObject)object2, "status", 0);
        ErrorEnum errorEnum2 = ErrorEnum.SUCCESS;
        int n12 = errorEnum2.getInternalCode();
        if (n12 != n11) {
            errorEnum = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE;
            n11 = errorEnum.getInternalCode();
        }
        errorEnum2 = new Bundle();
        boolean bl2 = "Push".equals(string3);
        String string5 = "message_id";
        String string6 = "message_type";
        int n13 = 1;
        if (bl2 && n10 == n13) {
            errorEnum2.putString(string6, "delivery");
            string3 = JsonUtil.getString((JSONObject)object2, "msgId", string2);
            errorEnum2.putString(string5, string3);
            errorEnum2.putInt("error", n11);
            object2 = JsonUtil.getString((JSONObject)object2, "transactionId", string2);
            string3 = "transaction_id";
            errorEnum2.putString(string3, (String)object2);
        } else {
            object2 = this.b.getExtras();
            if (object2 != null) {
                object2 = this.b.getExtras();
                errorEnum2.putAll((Bundle)object2);
            }
            errorEnum2.putString(string6, "received_message");
            object2 = this.b.getStringExtra("msgIdStr");
            errorEnum2.putString(string5, (String)object2);
            object2 = this.b.getByteArrayExtra("msg_data");
            errorEnum2.putByteArray("message_body", (byte[])object2);
            object2 = this.b;
            string3 = "device_token";
            object2 = v.a(object2.getByteArrayExtra(string3));
            errorEnum2.putString(string3, (String)object2);
            errorEnum2.putInt("inputType", n13);
            object2 = this.b;
            string3 = "message_proxy_type";
            object2 = object2.getStringExtra(string3);
            errorEnum2.putString(string3, (String)object2);
        }
        object2 = new h();
        string3 = this.a;
        boolean bl3 = ((h)object2).a((Context)string3, (Bundle)errorEnum2, (Intent)object);
        object2 = "PushReceiver";
        string3 = "receive ";
        if (bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            string3 = this.b.getAction();
            ((StringBuilder)object).append(string3);
            string3 = " and start service success";
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            HMSLog.i((String)object2, (String)object);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            string3 = this.b.getAction();
            ((StringBuilder)object).append(string3);
            string3 = " and start service failed";
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            HMSLog.e((String)object2, (String)object);
        }
    }
}

