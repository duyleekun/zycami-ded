/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseWrap {
    private static final String TAG = "ResponseWrap";
    private String body;
    private ResponseHeader responseHeader;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public boolean fromJson(String object) {
        String string2;
        Object object2;
        try {
            object2 = new JSONObject((String)object);
            object = this.responseHeader;
            string2 = "status_code";
        }
        catch (JSONException jSONException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("fromJson failed: ");
            String string3 = jSONException.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            HMSLog.e(TAG, string3);
            return false;
        }
        int n10 = JsonUtil.getIntValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setStatusCode(n10);
        object = this.responseHeader;
        string2 = "error_code";
        n10 = JsonUtil.getIntValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setErrorCode(n10);
        object = this.responseHeader;
        string2 = "error_reason";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setErrorReason(string2);
        object = this.responseHeader;
        string2 = "srv_name";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setSrvName(string2);
        object = this.responseHeader;
        string2 = "api_name";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setApiName(string2);
        object = this.responseHeader;
        string2 = "app_id";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setAppID(string2);
        object = this.responseHeader;
        string2 = "pkg_name";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setPkgName(string2);
        object = this.responseHeader;
        string2 = "session_id";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setSessionId(string2);
        object = this.responseHeader;
        string2 = "transaction_id";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setTransactionId(string2);
        object = this.responseHeader;
        string2 = "resolution";
        string2 = JsonUtil.getStringValue((JSONObject)object2, string2);
        ((ResponseHeader)object).setResolution(string2);
        object = "body";
        object = JsonUtil.getStringValue((JSONObject)object2, (String)object);
        this.body = object;
        return true;
    }

    public String getBody() {
        String string2 = this.body;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = new JSONObject();
            this.body = string2 = string2.toString();
        }
        return this.body;
    }

    public ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setBody(String string2) {
        this.body = string2;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        Object object = "status_code";
        try {
            boolean bl2;
            Object object2 = this.responseHeader;
            int n10 = ((ResponseHeader)object2).getStatusCode();
            jSONObject.put((String)object, n10);
            object = "error_code";
            object2 = this.responseHeader;
            n10 = ((ResponseHeader)object2).getErrorCode();
            jSONObject.put((String)object, n10);
            object = "error_reason";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getErrorReason();
            jSONObject.put((String)object, object2);
            object = "srv_name";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getSrvName();
            jSONObject.put((String)object, object2);
            object = "api_name";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getApiName();
            jSONObject.put((String)object, object2);
            object = "app_id";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getAppID();
            jSONObject.put((String)object, object2);
            object = "pkg_name";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getPkgName();
            jSONObject.put((String)object, object2);
            object = "transaction_id";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getTransactionId();
            jSONObject.put((String)object, object2);
            object = "resolution";
            object2 = this.responseHeader;
            object2 = ((ResponseHeader)object2).getResolution();
            jSONObject.put((String)object, object2);
            object = this.responseHeader;
            object = ((ResponseHeader)object).getSessionId();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 == 0) {
                object2 = "session_id";
                jSONObject.put((String)object2, object);
            }
            if (bl2 = TextUtils.isEmpty((CharSequence)(object = this.body))) return jSONObject.toString();
            object = "body";
            object2 = this.body;
            jSONObject.put((String)object, object2);
            return jSONObject.toString();
        }
        catch (JSONException jSONException) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "toJson failed: ";
            charSequence.append(string2);
            String string3 = jSONException.getMessage();
            charSequence.append(string3);
            string3 = charSequence.toString();
            charSequence = TAG;
            HMSLog.e((String)charSequence, string3);
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResponseWrap{body='");
        Object object = this.body;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", responseHeader=");
        object = this.responseHeader;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

