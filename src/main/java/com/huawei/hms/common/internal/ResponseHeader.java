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
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseHeader
implements IMessageEntity,
ResponseErrorCode {
    private static final String TAG = "ResponseHeader";
    private String api_name;
    private String app_id = "";
    private int error_code;
    private String error_reason;
    private Parcelable parcelable;
    private String pkg_name;
    private String resolution;
    private String session_id;
    private String srv_name;
    private int status_code;
    private String transaction_id;

    public ResponseHeader() {
    }

    public ResponseHeader(int n10, int n11, String string2) {
        this.status_code = n10;
        this.error_code = n11;
        this.error_reason = string2;
    }

    public boolean fromJson(String string2) {
        Object object;
        try {
            object = new JSONObject(string2);
            string2 = "status_code";
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
        int n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.status_code = n10;
        string2 = "error_code";
        n10 = JsonUtil.getIntValue((JSONObject)object, string2);
        this.error_code = n10;
        string2 = "error_reason";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.error_reason = string2;
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
        string2 = "session_id";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.session_id = string2;
        string2 = "transaction_id";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.transaction_id = string2;
        string2 = "resolution";
        string2 = JsonUtil.getStringValue((JSONObject)object, string2);
        this.resolution = string2;
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

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    public int getErrorCode() {
        return this.error_code;
    }

    public String getErrorReason() {
        return this.error_reason;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public String getTransactionId() {
        return this.transaction_id;
    }

    public boolean hasResolution() {
        boolean bl2;
        Parcelable parcelable = this.parcelable;
        if (parcelable != null) {
            bl2 = true;
        } else {
            bl2 = false;
            parcelable = null;
        }
        return bl2;
    }

    public boolean isSuccess() {
        int n10 = this.status_code;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setApiName(String string2) {
        this.api_name = string2;
    }

    public void setAppID(String string2) {
        this.app_id = string2;
    }

    public void setErrorCode(int n10) {
        this.error_code = n10;
    }

    public void setErrorReason(String string2) {
        this.error_reason = string2;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(String string2) {
        this.pkg_name = string2;
    }

    public void setResolution(String string2) {
        this.resolution = string2;
    }

    public void setSessionId(String string2) {
        this.session_id = string2;
    }

    public void setSrvName(String string2) {
        this.srv_name = string2;
    }

    public void setStatusCode(int n10) {
        this.status_code = n10;
    }

    public void setTransactionId(String string2) {
        this.transaction_id = string2;
    }

    public String toJson() {
        CharSequence charSequence;
        String string2;
        JSONObject jSONObject;
        block22: {
            jSONObject = new JSONObject();
            string2 = "status_code";
            int n10 = this.status_code;
            jSONObject.put(string2, n10);
            string2 = "error_code";
            n10 = this.error_code;
            jSONObject.put(string2, n10);
            string2 = "error_reason";
            charSequence = this.error_reason;
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
            string2 = this.session_id;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block22;
            string2 = "session_id";
            charSequence = this.session_id;
            jSONObject.put(string2, (Object)charSequence);
        }
        string2 = "transaction_id";
        charSequence = this.transaction_id;
        jSONObject.put(string2, (Object)charSequence);
        string2 = "resolution";
        charSequence = this.resolution;
        try {
            jSONObject.put(string2, (Object)charSequence);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            String string3 = "toJson failed: ";
            charSequence.append(string3);
            String string4 = jSONException.getMessage();
            charSequence.append(string4);
            string4 = charSequence.toString();
            charSequence = TAG;
            HMSLog.e((String)charSequence, string4);
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status_code:");
        int n10 = this.status_code;
        stringBuilder.append(n10);
        stringBuilder.append(", error_code");
        n10 = this.error_code;
        stringBuilder.append(n10);
        stringBuilder.append(", api_name:");
        String string2 = this.api_name;
        stringBuilder.append(string2);
        stringBuilder.append(", app_id:");
        string2 = this.app_id;
        stringBuilder.append(string2);
        stringBuilder.append(", pkg_name:");
        string2 = this.pkg_name;
        stringBuilder.append(string2);
        stringBuilder.append(", session_id:*, transaction_id:");
        string2 = this.transaction_id;
        stringBuilder.append(string2);
        stringBuilder.append(", resolution:");
        string2 = this.resolution;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

