/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.huawei.hms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.adapter.BinderAdapter$BinderCallBack;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.d$a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BaseHmsClient$1
implements BinderAdapter$BinderCallBack {
    public final /* synthetic */ BaseHmsClient this$0;

    public BaseHmsClient$1(BaseHmsClient baseHmsClient) {
        this.this$0 = baseHmsClient;
    }

    public void onBinderFailed(int n10) {
        this.onBinderFailed(n10, null);
    }

    public void onBinderFailed(int n10, Intent object) {
        n10 = 10;
        Object object2 = "BaseHmsClient";
        if (object != null) {
            Object object3 = this.this$0.getClientSettings().getCpActivity();
            Context context = this.this$0.getContext();
            if ((object3 = Util.getActiveActivity(object3, context)) != null) {
                String string2 = "onBinderFailed: SDK try to resolve and reConnect!";
                HMSLog.i((String)object2, string2);
                object3.startActivity(object);
            } else {
                HMSLog.i((String)object2, "onBinderFailed: return pendingIntent to kit and cp");
                object2 = BaseHmsClient.access$400(this.this$0);
                int n11 = 11;
                int n12 = 0x8000000;
                object = PendingIntent.getActivity((Context)object2, (int)n11, (Intent)object, (int)n12);
                object2 = this.this$0;
                object3 = new ConnectionResult(n10, (PendingIntent)object);
                BaseHmsClient.access$500((BaseHmsClient)object2, (ConnectionResult)object3);
                BaseHmsClient baseHmsClient = this.this$0;
                BaseHmsClient.access$002(baseHmsClient, null);
            }
        } else {
            HMSLog.i((String)object2, "onBinderFailed: pendingIntent is null!");
            object = this.this$0;
            object2 = new ConnectionResult(n10, null);
            BaseHmsClient.access$500((BaseHmsClient)object, (ConnectionResult)object2);
            BaseHmsClient baseHmsClient = this.this$0;
            BaseHmsClient.access$002(baseHmsClient, null);
        }
    }

    public void onNullBinding(ComponentName componentName) {
        BaseHmsClient.access$200(this.this$0, 1);
        BaseHmsClient.access$300(this.this$0, 10);
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = "BaseHmsClient";
        HMSLog.i((String)object, "Enter onServiceConnected.");
        BaseHmsClient baseHmsClient = this.this$0;
        object2 = d$a.a(object2);
        BaseHmsClient.access$002(baseHmsClient, (d)object2);
        object2 = BaseHmsClient.access$000(this.this$0);
        if (object2 == null) {
            HMSLog.e((String)object, "Failed to get service as interface, trying to unbind.");
            BaseHmsClient.access$100(this.this$0).unBind();
            BaseHmsClient.access$200(this.this$0, 1);
            BaseHmsClient.access$300(this.this$0, 10);
            return;
        }
        this.this$0.onConnecting();
    }

    public void onServiceDisconnected(ComponentName object) {
        String string2 = "Enter onServiceDisconnected.";
        HMSLog.i("BaseHmsClient", string2);
        object = this.this$0;
        int n10 = 1;
        BaseHmsClient.access$200((BaseHmsClient)object, n10);
        object = BaseHmsClient.access$600(this.this$0);
        if (object != null) {
            object = BaseHmsClient.access$600(this.this$0);
            object.onConnectionSuspended(n10);
        }
    }
}

