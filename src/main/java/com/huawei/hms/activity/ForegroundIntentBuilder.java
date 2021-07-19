/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.ForegroundBusDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder {
    private Activity activity;
    private String foregroundBody;
    private RequestHeader foregroundHeader;
    private ForegroundInnerHeader innerHeader;

    public ForegroundIntentBuilder(Activity object) {
        if (object != null) {
            RequestHeader requestHeader;
            this.activity = object;
            this.foregroundHeader = requestHeader = new RequestHeader();
            object = object.getPackageName();
            requestHeader.setPkgName((String)object);
            this.foregroundHeader.setSdkVersion(50200300);
            this.foregroundBody = "";
            this.innerHeader = object;
            ((ForegroundInnerHeader)object).setApkVersion(30000000);
            return;
        }
        super("listener must not be null.");
        throw object;
    }

    public static void registerResponseCallback(String string2, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(string2, busResponseCallback);
    }

    public static void unregisterResponseCallback(String string2) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(string2);
    }

    public Intent build() {
        CharSequence charSequence;
        Activity activity = this.activity;
        Object object = ForegroundBusDelegate.class.getName();
        activity = BridgeActivity.getIntentStartBridgeActivity(activity, (String)object);
        object = this.foregroundHeader.getAppID();
        String string2 = "|";
        if (object == null) {
            object = this.foregroundHeader;
            charSequence = new StringBuilder();
            String string3 = Util.getAppId((Context)this.activity);
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            ((RequestHeader)object).setAppID(string2);
        } else {
            object = this.foregroundHeader;
            charSequence = new StringBuilder();
            String string4 = Util.getAppId((Context)this.activity);
            charSequence.append(string4);
            charSequence.append(string2);
            string2 = this.foregroundHeader.getAppID();
            charSequence.append(string2);
            string2 = charSequence.toString();
            ((RequestHeader)object).setAppID(string2);
        }
        object = this.foregroundHeader.getTransactionId();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = this.foregroundHeader;
            string2 = ((RequestHeader)object).getAppID();
            charSequence = "hub.request";
            string2 = TransactionIdCreater.getId(string2, (String)charSequence);
            ((RequestHeader)object).setTransactionId(string2);
        }
        object = this.foregroundHeader.toJson();
        activity.putExtra("HMS_FOREGROUND_REQ_HEADER", (String)object);
        object = this.foregroundBody;
        activity.putExtra("HMS_FOREGROUND_REQ_BODY", (String)object);
        object = this.innerHeader.toJson();
        activity.putExtra("HMS_FOREGROUND_REQ_INNER", (String)object);
        return activity;
    }

    public ForegroundIntentBuilder setAction(String string2) {
        this.foregroundHeader.setApiName(string2);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int n10) {
        this.foregroundHeader.setApiLevel(n10);
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int n10) {
        this.foregroundHeader.setKitSdkVersion(n10);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int n10) {
        this.innerHeader.setApkVersion(n10);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String string2) {
        this.foregroundBody = string2;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String string2) {
        this.innerHeader.setResponseCallbackKey(string2);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String string2, BusResponseCallback busResponseCallback) {
        this.innerHeader.setResponseCallbackKey(string2);
        ForegroundBusResponseMgr.getInstance().registerObserver(string2, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String string2) {
        this.foregroundHeader.setSrvName(string2);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String string2) {
        this.foregroundHeader.setAppID(string2);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String string2) {
        this.foregroundHeader.setTransactionId(string2);
        return this;
    }
}

