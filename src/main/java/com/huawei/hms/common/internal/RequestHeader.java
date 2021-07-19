/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestHeader
implements IMessageEntity {
    private static final String TAG = "RequestHeader";
    private int apiLevel;
    private String api_name;
    private String app_id = "";
    private int kitSdkVersion;
    private Parcelable parcelable;
    private String pkg_name;
    private int sdk_version = 50200300;
    private String session_id;
    private String srv_name;
    private String transaction_id;
    private String version = "4.0";

    public boolean fromJson(String string2) {
        Object object;
        try {
            object = new JSONObject(string2);
            string2 = "version";
        }
        catch (JSONException jSONException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("fromJson failed: ");
            String string3 = jSONException.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            HMSLog.e(TAG, string3);
            return false;
        }
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.version = string2;
        string2 = "srv_name";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.srv_name = string2;
        string2 = "api_name";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.api_name = string2;
        string2 = "app_id";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.app_id = string2;
        string2 = "pkg_name";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.pkg_name = string2;
        string2 = "sdk_version";
        int n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.sdk_version = n10;
        string2 = "kitSdkVersion";
        n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.kitSdkVersion = n10;
        string2 = "apiLevel";
        n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.apiLevel = n10;
        string2 = "session_id";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.session_id = string2;
        string2 = "transaction_id";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.transaction_id = string2;
        return true;
    }

    public String getActualAppID() {
        String[] stringArray = this.app_id;
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        stringArray = this.app_id;
        String string3 = "\\|";
        int n10 = (stringArray = stringArray.split(string3)).length;
        if (n10 == 0) {
            return string2;
        }
        int n11 = stringArray.length;
        n10 = 1;
        if (n11 == n10) {
            return stringArray[0];
        }
        return stringArray[n10];
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    public int getKitSdkVersion() {
        return this.kitSdkVersion;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    public int getSdkVersion() {
        return this.sdk_version;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    public String getTransactionId() {
        return this.transaction_id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setApiLevel(int n10) {
        this.apiLevel = n10;
    }

    public void setApiName(String string2) {
        this.api_name = string2;
    }

    public void setAppID(String string2) {
        this.app_id = string2;
    }

    public void setKitSdkVersion(int n10) {
        this.kitSdkVersion = n10;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(String string2) {
        this.pkg_name = string2;
    }

    public void setSdkVersion(int n10) {
        this.sdk_version = n10;
    }

    public void setSessionId(String string2) {
        this.session_id = string2;
    }

    public void setSrvName(String string2) {
        this.srv_name = string2;
    }

    public void setTransactionId(String string2) {
        this.transaction_id = string2;
    }

    public void setVersion(String string2) {
        this.version = string2;
    }

    public String toJson() {
        CharSequence charSequence;
        String string2;
        JSONObject jSONObject;
        block22: {
            jSONObject = new JSONObject();
            string2 = "version";
            charSequence = this.version;
            jSONObject.put(string2, (Object)charSequence);
            string2 = "srv_name";
            charSequence = this.srv_name;
            jSONObject.put(string2, (Object)charSequence);
            string2 = "api_name";
            charSequence = this.api_name;
            jSONObject.put(string2, (Object)charSequence);
            string2 = "app_id";
            charSequence = this.app_id;
            jSONObject.put(string2, (Object)charSequence);
            string2 = "pkg_name";
            charSequence = this.pkg_name;
            jSONObject.put(string2, (Object)charSequence);
            string2 = "sdk_version";
            int n10 = this.sdk_version;
            jSONObject.put(string2, n10);
            string2 = "kitSdkVersion";
            n10 = this.kitSdkVersion;
            jSONObject.put(string2, n10);
            string2 = "apiLevel";
            n10 = this.apiLevel;
            jSONObject.put(string2, n10);
            string2 = this.session_id;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block22;
            string2 = "session_id";
            charSequence = this.session_id;
            jSONObject.put(string2, (Object)charSequence);
        }
        string2 = "transaction_id";
        charSequence = this.transaction_id;
        try {
            jSONObject.put(string2, (Object)charSequence);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            String string3 = "toJson failed: ";
            ((StringBuilder)charSequence).append(string3);
            String string4 = jSONException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            charSequence = TAG;
            HMSLog.e((String)charSequence, string4);
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("api_name:");
        String string2 = this.api_name;
        stringBuilder.append(string2);
        stringBuilder.append(", app_id:");
        string2 = this.app_id;
        stringBuilder.append(string2);
        stringBuilder.append(", pkg_name:");
        string2 = this.pkg_name;
        stringBuilder.append(string2);
        stringBuilder.append(", sdk_version:");
        int n10 = this.sdk_version;
        stringBuilder.append(n10);
        stringBuilder.append(", session_id:*, transaction_id:");
        string2 = this.transaction_id;
        stringBuilder.append(string2);
        stringBuilder.append(", kitSdkVersion:");
        n10 = this.kitSdkVersion;
        stringBuilder.append(n10);
        stringBuilder.append(", apiLevel:");
        n10 = this.apiLevel;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

