/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.util.Map;

public class TriggerCallbackRequest
extends OSSRequest {
    private String mBucketName;
    private Map mCallbackParam;
    private Map mCallbackVars;
    private String mObjectKey;

    public TriggerCallbackRequest(String string2, String string3, Map map, Map map2) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setCallbackParam(map);
        this.setCallbackVars(map2);
    }

    public String getBucketName() {
        return this.mBucketName;
    }

    public Map getCallbackParam() {
        return this.mCallbackParam;
    }

    public Map getCallbackVars() {
        return this.mCallbackVars;
    }

    public String getObjectKey() {
        return this.mObjectKey;
    }

    public void setBucketName(String string2) {
        this.mBucketName = string2;
    }

    public void setCallbackParam(Map map) {
        this.mCallbackParam = map;
    }

    public void setCallbackVars(Map map) {
        this.mCallbackVars = map;
    }

    public void setObjectKey(String string2) {
        this.mObjectKey = string2;
    }
}

