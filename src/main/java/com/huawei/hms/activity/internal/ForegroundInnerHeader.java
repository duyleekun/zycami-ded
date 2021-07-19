/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ForegroundInnerHeader {
    private final String TAG;
    private String action;
    private int apkVersion;
    private String responseCallbackKey;

    public ForegroundInnerHeader() {
        this.TAG = "ForegroundInnerHeader";
    }

    public void fromJson(String string2) {
        Object object = new JSONObject(string2);
        string2 = "apkVersion";
        int n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.apkVersion = n10;
        string2 = "action";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.action = string2;
        string2 = "responseCallbackKey";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        try {
            this.responseCallbackKey = string2;
        }
        catch (JSONException jSONException) {
            object = new StringBuilder();
            String string3 = "fromJson failed: ";
            ((StringBuilder)object).append(string3);
            String string4 = jSONException.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            object = "ForegroundInnerHeader";
            HMSLog.e((String)object, string4);
        }
    }

    public String getAction() {
        return this.action;
    }

    public int getApkVersion() {
        return this.apkVersion;
    }

    public String getResponseCallbackKey() {
        return this.responseCallbackKey;
    }

    public void setAction(String string2) {
        this.action = string2;
    }

    public void setApkVersion(int n10) {
        this.apkVersion = n10;
    }

    public void setResponseCallbackKey(String string2) {
        this.responseCallbackKey = string2;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        String string2 = "apkVersion";
        int n10 = this.apkVersion;
        jSONObject.put(string2, n10);
        string2 = "action";
        CharSequence charSequence = this.action;
        jSONObject.put(string2, (Object)charSequence);
        string2 = "responseCallbackKey";
        charSequence = this.responseCallbackKey;
        try {
            jSONObject.put(string2, (Object)charSequence);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            String string3 = "ForegroundInnerHeader toJson failed: ";
            ((StringBuilder)charSequence).append(string3);
            String string4 = jSONException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            charSequence = "ForegroundInnerHeader";
            HMSLog.e((String)charSequence, string4);
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apkVersion:");
        int n10 = this.apkVersion;
        stringBuilder.append(n10);
        stringBuilder.append(", action:");
        String string2 = this.action;
        stringBuilder.append(string2);
        stringBuilder.append(", responseCallbackKey:");
        string2 = this.responseCallbackKey;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

